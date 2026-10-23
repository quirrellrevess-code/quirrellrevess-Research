#!/usr/bin/env python3
"""Read-only cross-stream report for recorded URA/LegendAI JSONL telemetry.

This tool validates record shapes and reports turn-level overlap. It does not
infer that a request was caused by a recommendation and never executes input.
"""
from __future__ import annotations

import argparse
import json
from datetime import datetime, timezone
import sys
from collections import Counter
from pathlib import Path
from typing import Any


STREAMS = {
    "observations": {
        "required": ("captured_at_utc", "turn", "command_count", "commands"),
        "turn_field": "turn",
    },
    "requests": {
        "required": ("captured_at_utc", "current_turn", "command_type", "command_id"),
        "turn_field": "current_turn",
    },
    "recommendations": {
        "required": ("captured_at_utc", "source", "recommendation_text", "turn", "verified", "executable"),
        "turn_field": "turn",
    },
}


def read_jsonl(path: Path) -> tuple[list[dict[str, Any]], list[dict[str, Any]]]:
    records: list[dict[str, Any]] = []
    errors: list[dict[str, Any]] = []
    with path.open("r", encoding="utf-8-sig") as stream:
        for line_number, line in enumerate(stream, 1):
            if not line.strip():
                continue
            try:
                value = json.loads(line)
            except json.JSONDecodeError as exc:
                errors.append({"line": line_number, "reason": "invalid_json", "detail": exc.msg})
                continue
            if not isinstance(value, dict):
                errors.append({"line": line_number, "reason": "record_not_object"})
                continue
            records.append(value)
    return records, errors


def normalize_record(name: str, record: dict[str, Any]) -> dict[str, Any]:
    """Normalize known field names from both the Python bridge and C# sink."""
    normalized = dict(record)
    # Both bridge and sink may emit timestamp_utc; normalize it consistently
    # across streams before required-field, ordering, and sample audits.
    if "captured_at_utc" not in normalized and "timestamp_utc" in normalized:
        normalized["captured_at_utc"] = normalized["timestamp_utc"]
    if name == "recommendations":
        if "recommendation_text" not in normalized and "recommendation" in normalized:
            normalized["recommendation_text"] = normalized["recommendation"]
    return normalized


def observation_command_contract_issues(record: dict[str, Any]) -> list[str]:
    """Validate command telemetry availability and its cross-field invariants."""
    issues: list[str] = []
    available = record.get("commands_available")
    commands = record.get("commands")
    count = record.get("command_count")

    if "commands_available" in record and type(available) is not bool:
        issues.append("commands_available_not_boolean")

    if available is True:
        if not isinstance(commands, list):
            issues.append("available_commands_not_array")
        if type(count) is not int or count < 0:
            issues.append("available_command_count_invalid")
        elif isinstance(commands, list) and count != len(commands):
            issues.append("command_count_length_mismatch")
    elif available is False:
        if commands is not None:
            issues.append("unavailable_commands_not_null")
        if count is not None:
            issues.append("unavailable_command_count_not_null")
    else:
        # Legacy rows without the availability flag, and rows with an invalid flag,
        # still get shape/count checks wherever the payload permits them.
        if isinstance(commands, list):
            if type(count) is not int or count < 0:
                issues.append("available_command_count_invalid")
            elif count != len(commands):
                issues.append("command_count_length_mismatch")
        elif commands is None:
            if count is not None:
                issues.append("null_commands_with_nonnull_count")
        elif "commands" in record:
            issues.append("commands_not_array_or_null")
    return issues

def analyze_stream(name: str, records: list[dict[str, Any]], parse_errors: list[dict[str, Any]]) -> dict[str, Any]:
    schema = STREAMS[name]
    records = [normalize_record(name, record) for record in records]
    missing = Counter()
    invalid_turns = 0
    missing_turns = 0
    null_turns = 0
    invalid_turn_types = 0
    invalid_timestamps = 0
    timestamp_missing_or_null = 0
    timestamp_invalid_format_or_timezone = 0
    timestamp_out_of_order = 0
    timestamp_duplicates = 0
    seen_timestamps: set[datetime] = set()
    previous_timestamp: datetime | None = None
    valid_turns: set[int] = set()
    unverified = 0
    executable_marked = 0
    invalid_verified_flag_types = 0
    invalid_executable_flag_types = 0
    association_status_values: Counter[str] = Counter()
    association_status_missing = 0
    association_status_null = 0
    association_status_invalid = 0
    association_context_mismatch = 0
    command_contract_issue_counts: Counter[str] = Counter()

    for record in records:
        for field in schema["required"]:
            if field not in record:
                missing[field] += 1
        if name == "observations":
            command_contract_issue_counts.update(observation_command_contract_issues(record))
        turn_field = schema["turn_field"]
        turn = record.get(turn_field)
        if type(turn) is int and turn >= 0:
            valid_turns.add(turn)
        else:
            invalid_turns += 1
            if turn_field not in record:
                missing_turns += 1
            elif turn is None:
                null_turns += 1
            else:
                invalid_turn_types += 1
        timestamp_value = record.get("captured_at_utc", record.get("timestamp_utc"))
        parsed_timestamp = parse_timestamp(record)
        if parsed_timestamp is None:
            invalid_timestamps += 1
            if timestamp_value is None or timestamp_value == "":
                timestamp_missing_or_null += 1
            else:
                timestamp_invalid_format_or_timezone += 1
        else:
            timestamp_utc = parsed_timestamp.astimezone(timezone.utc)
            if timestamp_utc in seen_timestamps:
                timestamp_duplicates += 1
            seen_timestamps.add(timestamp_utc)
            if previous_timestamp is not None and timestamp_utc < previous_timestamp:
                timestamp_out_of_order += 1
            previous_timestamp = timestamp_utc
        if record.get("verified") is False:
            unverified += 1
        if "verified" in record and type(record["verified"]) is not bool:
            invalid_verified_flag_types += 1
        if record.get("executable") is True:
            executable_marked += 1
        if "executable" in record and type(record["executable"]) is not bool:
            invalid_executable_flag_types += 1
        if name == "recommendations":
            if "turn_association_status" not in record:
                association_status_missing += 1
            elif record["turn_association_status"] is None:
                association_status_null += 1
            elif (
                not isinstance(record["turn_association_status"], str)
                or record["turn_association_status"] not in {
                    "target_context_available_unverified",
                    "unavailable_in_airredirector_context",
                    "unavailable_in_stdout_only",
                }
            ):
                association_status_invalid += 1
            else:
                status = record["turn_association_status"]
                association_status_values[status] += 1
                turn_value = record.get("turn")
                chara_value = record.get("single_mode_chara_id")
                has_valid_turn = type(turn_value) is int and turn_value >= 0
                has_valid_chara = type(chara_value) is int and chara_value >= 0
                if status == "target_context_available_unverified" and not (has_valid_turn and has_valid_chara):
                    association_context_mismatch += 1
                elif status == "unavailable_in_airredirector_context" and has_valid_turn and has_valid_chara:
                    association_context_mismatch += 1
                elif status == "unavailable_in_stdout_only" and (turn_value is not None or chara_value is not None):
                    association_context_mismatch += 1

    result = {
        "record_count": len(records),
        "parse_error_count": len(parse_errors),
        "parse_errors": parse_errors[:20],
        "missing_required_fields": dict(sorted(missing.items())),
        "valid_turn_count": len(valid_turns),
        "turns": sorted(valid_turns),
        "records_without_valid_turn": invalid_turns,
        "turn_quality": {
            "missing_field_count": missing_turns,
            "null_count": null_turns,
            "invalid_type_or_range_count": invalid_turn_types,
        },
        "invalid_or_unavailable_timestamp_count": invalid_timestamps,
        "timestamp_quality": {
            "missing_or_null_count": timestamp_missing_or_null,
            "invalid_format_or_timezone_count": timestamp_invalid_format_or_timezone,
            "out_of_order_count": timestamp_out_of_order,
            "duplicate_instant_count": timestamp_duplicates,
        },
        "explicitly_unverified_count": unverified,
        "marked_executable_count": executable_marked,
        "invalid_boolean_flag_types": {
            "verified": invalid_verified_flag_types,
            "executable": invalid_executable_flag_types,
        },
    }
    if name == "observations":
        result["command_telemetry_contract_issues"] = dict(sorted(command_contract_issue_counts.items()))
    if name == "recommendations":
        result["turn_association_status"] = {
            "missing_field_count": association_status_missing,
            "null_count": association_status_null,
            "invalid_type_or_empty_count": association_status_invalid,
            "context_mismatch_count": association_context_mismatch,
            "values": dict(sorted(association_status_values.items())),
        }
    return result


def parse_timestamp(record: dict[str, Any]) -> datetime | None:
    value = record.get("captured_at_utc", record.get("timestamp_utc"))
    if not isinstance(value, str) or not value:
        return None
    try:
        parsed = datetime.fromisoformat(value.replace("Z", "+00:00"))
    except ValueError:
        return None
    if parsed.tzinfo is None:
        return None
    return parsed


def compare_recommendations_and_requests(
    recommendations: list[dict[str, Any]], requests: list[dict[str, Any]]
) -> list[dict[str, Any]]:
    """Compare same-turn timestamps without inferring causality."""
    request_by_turn: dict[int, list[dict[str, Any]]] = {}
    for request_index, request in enumerate(requests):
        turn = request.get("current_turn")
        if type(turn) is int and turn >= 0:
            request_by_turn.setdefault(turn, []).append(request)

    comparisons = []
    for recommendation in recommendations:
        turn = recommendation.get("turn")
        if type(turn) is not int or turn < 0:
            continue
        rec_time = parse_timestamp(recommendation)
        for request in request_by_turn.get(turn, []):
            req_time = parse_timestamp(request)
            if rec_time is None or req_time is None:
                relation, delta = "timestamp_unavailable", None
            else:
                delta = round((req_time - rec_time).total_seconds(), 3)
                relation = (
                    "recommendation_timestamp_before_request"
                    if delta > 0 else
                    "request_timestamp_before_recommendation"
                    if delta < 0 else
                    "same_timestamp"
                )
            proximity = (
                "unavailable" if delta is None else
                "within_2s_diagnostic_window" if abs(delta) <= 2.0 else
                "outside_2s_diagnostic_window"
            )
            comparisons.append({
                "turn": turn,
                "recommendation": recommendation.get("recommendation_text"),
                "request_command_type": request.get("command_type"),
                "request_command_id": request.get("command_id"),
                "request_minus_recommendation_seconds": delta,
                "timestamp_order": relation,
                "timestamp_proximity_2s": proximity,
                "same_state_verified": False,
                "causal_link_verified": False,
            })
    comparisons.sort(key=lambda item: (
        item["turn"],
        item["request_minus_recommendation_seconds"] is None,
        item["request_minus_recommendation_seconds"] or 0,
    ))
    return comparisons


IDENTITY_FIELDS = ("run_id", "scenario_id", "single_mode_chara_id", "chara_id")


def compare_shared_identity(left: dict[str, Any], right: dict[str, Any]) -> dict[str, Any]:
    """Compare only explicit, shared identity fields; never infer missing identity."""
    compared: dict[str, dict[str, Any]] = {}
    mismatches: list[str] = []
    for field in IDENTITY_FIELDS:
        if field not in left or field not in right:
            continue
        lv, rv = left[field], right[field]
        if lv is None or rv is None:
            continue
        # IDs are accepted only as non-negative integers or non-empty strings.
        valid_left = (type(lv) is int and lv >= 0) or (isinstance(lv, str) and bool(lv.strip()))
        valid_right = (type(rv) is int and rv >= 0) or (isinstance(rv, str) and bool(rv.strip()))
        if not valid_left or not valid_right:
            continue
        compared[field] = {"left": lv, "right": rv, "match": lv == rv}
        if lv != rv:
            mismatches.append(field)
    return {
        "status": "mismatch" if mismatches else "matched_shared_fields" if compared else "identity_unavailable",
        "compared_fields": compared,
        "mismatch_fields": mismatches,
        "same_state_verified": False,
    }


def build_identity_consistency(loaded: dict[str, list[dict[str, Any]]]) -> dict[str, Any]:
    """Audit same-turn identity fields across streams without treating turn as identity proof."""
    specs = (
        ("observations", "requests", "turn", "current_turn"),
        ("observations", "recommendations", "turn", "turn"),
        ("requests", "recommendations", "current_turn", "turn"),
    )
    output: dict[str, Any] = {}
    for left_name, right_name, left_turn_key, right_turn_key in specs:
        left_by_turn: dict[int, list[tuple[int, dict[str, Any]]]] = {}
        right_by_turn: dict[int, list[tuple[int, dict[str, Any]]]] = {}
        for record_index, row in enumerate(loaded[left_name]):
            turn = row.get(left_turn_key)
            if type(turn) is int and turn >= 0:
                left_by_turn.setdefault(turn, []).append((record_index, row))
        for record_index, row in enumerate(loaded[right_name]):
            turn = row.get(right_turn_key)
            if type(turn) is int and turn >= 0:
                right_by_turn.setdefault(turn, []).append((record_index, row))
        counts: Counter[str] = Counter()
        samples: list[dict[str, Any]] = []
        for turn in sorted(set(left_by_turn) & set(right_by_turn)):
            for left_index, left in left_by_turn[turn]:
                for right_index, right in right_by_turn[turn]:
                    result = compare_shared_identity(left, right)
                    counts[result["status"]] += 1
                    if result["status"] == "mismatch" and len(samples) < 20:
                        samples.append({
                            "turn": turn,
                            "left_record_index": left_index,
                            "right_record_index": right_index,
                            **result,
                        })
        output[f"{left_name}_vs_{right_name}"] = {
            "same_turn_pairs": sum(counts.values()),
            "status_counts": dict(sorted(counts.items())),
            "mismatch_samples": samples,
            "interpretation": "Identity field comparison only; shared turn and matching identifiers do not prove same-state alignment or causality.",
        }
    return output


def audit_request_command_membership(
    observations: list[dict[str, Any]], requests: list[dict[str, Any]]
) -> dict[str, Any]:
    """Check whether observed request command IDs appear in same-turn snapshots."""
    obs_by_turn: dict[int, list[tuple[int, dict[str, Any]]]] = {}
    for snapshot_index, observation in enumerate(observations):
        turn = observation.get("turn")
        if type(turn) is int and turn >= 0:
            obs_by_turn.setdefault(turn, []).append((snapshot_index, observation))

    counts: Counter[str] = Counter()
    samples: list[dict[str, Any]] = []
    compared = 0
    for request_index, request in enumerate(requests):
        turn = request.get("current_turn")
        if type(turn) is not int or turn < 0:
            continue
        matching_observations = obs_by_turn.get(turn, [])
        if not matching_observations:
            counts["no_same_turn_observation"] += 1
            continue
        command_id = request.get("command_id")
        if type(command_id) is not int or command_id < 0:
            counts["invalid_or_missing_request_command_id"] += 1
            continue
        usable: list[tuple[int, bool, str]] = []
        request_time = parse_timestamp(request)
        for snapshot_index, observation in matching_observations:
            commands_available = observation.get("commands_available")
            commands = observation.get("commands")
            if commands_available is False or not isinstance(commands, list):
                continue
            snapshot_time = parse_timestamp(observation)
            if request_time is None or snapshot_time is None:
                temporal_relation = "timestamp_unavailable"
            elif snapshot_time < request_time:
                temporal_relation = "snapshot_before_request"
            elif snapshot_time == request_time:
                temporal_relation = "same_timestamp"
            else:
                temporal_relation = "snapshot_after_request"
            ids = [
                item.get("command_id") for item in commands
                if isinstance(item, dict) and type(item.get("command_id")) is int
                and item["command_id"] >= 0
            ]
            usable.append((snapshot_index, command_id in ids, temporal_relation))
        if not usable:
            counts["snapshot_command_list_unavailable"] += 1
            continue
        compared += 1
        # Preserve membership diagnostics, but separately report whether snapshots
        # could have existed by request time. Same-turn snapshots after the request
        # must not be presented as evidence of request-time availability.
        memberships = [present for _, present, _ in usable]
        prior_or_equal = [item for item in usable if item[2] in {"snapshot_before_request", "same_timestamp"}]
        if request_time is None or any(item[2] == "timestamp_unavailable" for item in usable):
            temporal_status = "request_or_snapshot_timestamp_unavailable"
        elif prior_or_equal:
            temporal_status = "has_snapshot_at_or_before_request"
        else:
            temporal_status = "all_snapshots_after_request"
        counts[temporal_status] += 1
        if all(memberships):
            status = "present_in_all_same_turn_snapshots"
        elif not any(memberships):
            status = "absent_from_all_same_turn_snapshots"
        else:
            status = "inconsistent_across_same_turn_snapshots"
        counts[status] += 1
        if status != "present_in_all_same_turn_snapshots" or temporal_status != "has_snapshot_at_or_before_request":
            if len(samples) < 20:
                samples.append({
                    "request_index": request_index,
                    "turn": turn,
                    "command_id": command_id,
                    "status": status,
                    "temporal_status": temporal_status,
                    "snapshot_count": len(usable),
                    "snapshot_record_indices": [index for index, _, _ in usable],
                })
    return {
        "request_count_with_valid_turn": sum(
            1 for row in requests if type(row.get("current_turn")) is int and row["current_turn"] >= 0
        ),
        "request_count_compared": compared,
        "status_counts": dict(sorted(counts.items())),
        "non_present_samples": samples,
        "same_state_verified": False,
        "causal_link_verified": False,
        "temporal_status_note": "Temporal statuses are diagnostic only. Snapshots after a request are not evidence that the command was available at request time; missing timestamps prevent temporal confirmation.",
        "interpretation": "Command-ID membership is a same-turn consistency check only. Temporal ordering is reported separately; neither membership nor a prior timestamp proves same-state alignment, request validity, or causality.",
    }



def collect_record_anomaly_samples(
    loaded: dict[str, list[dict[str, Any]]],
    stream_reports: dict[str, dict[str, Any]],
    limit: int = 50,
) -> list[dict[str, Any]]:
    """Return bounded, record-addressable samples for directly inspectable anomalies."""
    samples: list[dict[str, Any]] = []
    for name, records in loaded.items():
        schema = STREAMS[name]
        previous_valid_timestamp: datetime | None = None
        seen_timestamp_instants: set[datetime] = set()
        for index, raw in enumerate(records):
            record = normalize_record(name, raw)
            location = {
                "stream": name,
                "record_index": index,
                "turn": record.get(schema["turn_field"]),
            }
            for field in schema["required"]:
                if field not in record:
                    samples.append({**location, "issue": "missing_required_field", "field": field})
            turn = record.get(schema["turn_field"])
            if type(turn) is not int or turn < 0:
                samples.append({**location, "issue": "invalid_or_missing_turn"})
            if parse_timestamp(record) is None:
                value = record.get("captured_at_utc", record.get("timestamp_utc"))
                samples.append({
                    **location,
                    "issue": "timestamp_missing" if value is None or value == "" else "timestamp_invalid",
                })
            else:
                parsed_timestamp = parse_timestamp(record)
                current_utc = parsed_timestamp.astimezone(timezone.utc)
                # Match analyze_stream's per-stream ordering and duplicate semantics in O(n).
                if previous_valid_timestamp is not None and current_utc < previous_valid_timestamp:
                    samples.append({**location, "issue": "timestamp_out_of_order"})
                if current_utc in seen_timestamp_instants:
                    samples.append({**location, "issue": "duplicate_timestamp_instant"})
                seen_timestamp_instants.add(current_utc)
                previous_valid_timestamp = current_utc
            if name == "observations":
                samples.extend({**location, "issue": issue}
                               for issue in observation_command_contract_issues(record))
            if record.get("executable") is True:
                samples.append({**location, "issue": "record_marked_executable"})
            if "verified" in record and type(record["verified"]) is not bool:
                samples.append({**location, "issue": "verified_flag_not_boolean"})
            if "executable" in record and type(record["executable"]) is not bool:
                samples.append({**location, "issue": "executable_flag_not_boolean"})
            if name == "recommendations":
                status = record.get("turn_association_status")
                if status not in {
                    "target_context_available_unverified",
                    "unavailable_in_airredirector_context",
                    "unavailable_in_stdout_only",
                }:
                    samples.append({**location, "issue": "invalid_turn_association_status"})
                elif stream_reports[name]["turn_association_status"]["context_mismatch_count"]:
                    # Recheck the local row rather than assigning the stream-wide count to every row.
                    chara = record.get("single_mode_chara_id")
                    has_turn = type(turn) is int and turn >= 0
                    has_chara = type(chara) is int and chara >= 0
                    mismatch = (
                        status == "target_context_available_unverified" and not (has_turn and has_chara)
                    ) or (
                        status == "unavailable_in_airredirector_context" and has_turn and has_chara
                    ) or (
                        status == "unavailable_in_stdout_only" and (turn is not None or chara is not None)
                    )
                    if mismatch:
                        samples.append({**location, "issue": "recommendation_context_mismatch"})
            if len(samples) >= limit:
                return samples[:limit]
    return samples[:limit]


def summarize_data_quality(
    loaded: dict[str, list[dict[str, Any]]],
    stream_reports: dict[str, dict[str, Any]],
    identity_consistency: dict[str, Any],
    command_membership: dict[str, Any],
) -> dict[str, Any]:
    """Aggregate known data-quality anomalies without claiming state alignment."""
    totals: Counter[str] = Counter()
    record_count = 0
    valid_turn_count = 0
    for name, records in loaded.items():
        report = stream_reports[name]
        record_count += len(records)
        valid_turn_count += report["valid_turn_count"]
        totals["parse_errors"] += report["parse_error_count"]
        totals["missing_required_fields"] += sum(report["missing_required_fields"].values())
        totals["records_without_valid_turn"] += report["records_without_valid_turn"]
        if name == "observations":
            totals["observation_command_contract_issues"] += sum(
                report.get("command_telemetry_contract_issues", {}).values()
            )
        totals["timestamps_missing_or_invalid"] += report["invalid_or_unavailable_timestamp_count"]
        totals["timestamps_out_of_order"] += report["timestamp_quality"]["out_of_order_count"]
        totals["duplicate_timestamp_instants"] += report["timestamp_quality"]["duplicate_instant_count"]
        totals["records_marked_executable"] += report["marked_executable_count"]
        totals["invalid_verified_flag_types"] += report["invalid_boolean_flag_types"]["verified"]
        totals["invalid_executable_flag_types"] += report["invalid_boolean_flag_types"]["executable"]
        if name == "recommendations":
            association = report.get("turn_association_status", {})
            totals["recommendation_context_mismatches"] += association.get("context_mismatch_count", 0)
            totals["recommendation_association_status_invalid"] += association.get("invalid_type_or_empty_count", 0)

    for pair_report in identity_consistency.values():
        counts = pair_report.get("status_counts", {})
        totals["identity_mismatch_pairs"] += counts.get("mismatch", 0)
        totals["identity_unavailable_pairs"] += counts.get("identity_unavailable", 0)

    membership_counts = command_membership.get("status_counts", {})
    totals["request_commands_absent_from_snapshots"] += membership_counts.get("absent_from_all_same_turn_snapshots", 0)
    totals["request_commands_inconsistent_across_snapshots"] += membership_counts.get("inconsistent_across_same_turn_snapshots", 0)
    totals["requests_without_same_turn_observation"] += membership_counts.get("no_same_turn_observation", 0)
    totals["request_command_ids_invalid"] += membership_counts.get("invalid_or_missing_request_command_id", 0)
    totals["snapshot_command_lists_unavailable"] += membership_counts.get("snapshot_command_list_unavailable", 0)

    anomalies = {key: value for key, value in sorted(totals.items()) if value > 0}
    if record_count == 0 or valid_turn_count == 0:
        status = "insufficient_data"
    elif anomalies:
        status = "audit_warnings"
    else:
        status = "no_reported_anomalies"

    # Fetch one extra record sample to distinguish exactly-at-limit from truncated output.
    parse_error_samples_all = [
        {"stream": name, **error}
        for name, report in stream_reports.items()
        for error in report.get("parse_errors", [])
    ]
    parse_error_total = sum(report.get("parse_error_count", 0) for report in stream_reports.values())
    parse_error_samples = parse_error_samples_all[:20]
    parse_error_samples_truncated = parse_error_total > len(parse_error_samples)
    record_samples_with_sentinel = collect_record_anomaly_samples(loaded, stream_reports, limit=51)
    record_samples_truncated = len(record_samples_with_sentinel) > 50
    record_samples = record_samples_with_sentinel[:50]
    identity_samples_all = [
        {"issue": "identity_mismatch", "stream_pair": pair, **sample}
        for pair, pair_report in identity_consistency.items()
        for sample in pair_report.get("mismatch_samples", [])
    ]
    identity_samples = identity_samples_all[:20]
    total_identity_mismatches = sum(
        pair_report.get("status_counts", {}).get("mismatch", 0)
        for pair_report in identity_consistency.values()
    )
    command_samples_all = [
        {"issue": "request_command_membership", **sample}
        for sample in command_membership.get("non_present_samples", [])
    ]
    command_samples = command_samples_all[:20]
    membership_counts = command_membership.get("status_counts", {})
    total_non_present_requests = sum(
        membership_counts.get(key, 0)
        for key in (
            "absent_from_all_same_turn_snapshots",
            "inconsistent_across_same_turn_snapshots",
            "no_same_turn_observation",
            "invalid_or_missing_request_command_id",
            "snapshot_command_list_unavailable",
        )
    )

    return {
        "status": status,
        "record_count": record_count,
        "valid_turn_records_across_streams": valid_turn_count,
        "anomaly_counts": anomalies,
        "record_anomaly_samples": record_samples,
        "parse_error_samples": parse_error_samples,
        "identity_mismatch_samples": identity_samples,
        "request_command_anomaly_samples": command_samples,
        "sample_coverage": {
            "record_sample_limit": 50,
            "record_samples_truncated": record_samples_truncated,
            "parse_error_sample_limit": 20,
            "parse_error_samples_truncated": parse_error_samples_truncated,
            "identity_mismatch_sample_limit": 20,
            "identity_mismatch_samples_truncated": total_identity_mismatches > len(identity_samples),
            "request_command_sample_limit": 20,
            "request_command_samples_truncated": total_non_present_requests > len(command_samples),
            "interpretation": "Truncation flags mean additional anomalies exist beyond the displayed samples; anomaly_counts remain aggregate counts.",
        },
        "interpretation": (
            "This is a data-quality summary only. 'no_reported_anomalies' does not prove records describe the same state, "
            "establish causality, validate live provenance, or authorize execution. "
            "A zero count can also reflect missing coverage."
        ),
        "same_state_verified": False,
        "causal_link_verified": False,
        "executable": False,
    }


def build_report(paths: dict[str, Path]) -> dict[str, Any]:
    loaded: dict[str, list[dict[str, Any]]] = {}
    reports: dict[str, Any] = {}
    turns_by_stream: dict[str, set[int]] = {}

    for name, path in paths.items():
        records, errors = read_jsonl(path)
        records = [normalize_record(name, record) for record in records]
        loaded[name] = records
        reports[name] = analyze_stream(name, records, errors)
        turn_field = STREAMS[name]["turn_field"]
        turns_by_stream[name] = {
            record[turn_field] for record in records
            if type(record.get(turn_field)) is int and record[turn_field] >= 0
        }

    observed_turns = turns_by_stream["observations"]
    request_turns = turns_by_stream["requests"]
    recommendation_turns = turns_by_stream["recommendations"]
    timing_comparisons = compare_recommendations_and_requests(
        loaded["recommendations"], loaded["requests"]
    )
    valid_recommendations = sum(
        1 for record in loaded["recommendations"]
        if type(record.get("turn")) is int and record["turn"] >= 0
    )
    valid_requests = sum(
        1 for record in loaded["requests"]
        if type(record.get("current_turn")) is int and record["current_turn"] >= 0
    )
    shared_observation_request = observed_turns & request_turns
    shared_observation_recommendation = observed_turns & recommendation_turns
    shared_request_recommendation = request_turns & recommendation_turns

    def coverage(shared: set[int], denominator: set[int]) -> dict[str, Any]:
        return {
            "shared_turn_count": len(shared),
            "denominator_turn_count": len(denominator),
            "coverage_ratio": round(len(shared) / len(denominator), 4) if denominator else None,
        }

    identity_consistency = build_identity_consistency(loaded)
    request_command_membership = audit_request_command_membership(loaded["observations"], loaded["requests"])
    data_quality_summary = summarize_data_quality(
        loaded, reports, identity_consistency, request_command_membership
    )

    return {
        "mode": "read_only_replay_report",
        "executable": False,
        "data_quality_summary": data_quality_summary,
        "streams": reports,
        "turn_coverage": {
            "observations_with_request_turn": coverage(shared_observation_request, observed_turns),
            "requests_with_observation_turn": coverage(shared_observation_request, request_turns),
            "observations_with_recommendation_turn": coverage(shared_observation_recommendation, observed_turns),
            "recommendations_with_observation_turn": coverage(shared_observation_recommendation, recommendation_turns),
            "requests_with_recommendation_turn": coverage(shared_request_recommendation, request_turns),
            "recommendations_with_request_turn": coverage(shared_request_recommendation, recommendation_turns),
        },
        "timing_comparison_coverage": {
            "recommendations_with_valid_turn": valid_recommendations,
            "requests_with_valid_turn": valid_requests,
            "same_turn_pairs_compared": len(timing_comparisons),
            "recommendations_without_valid_turn_excluded": len(loaded["recommendations"]) - valid_recommendations,
            "requests_without_valid_turn_excluded": len(loaded["requests"]) - valid_requests,
        },
        "turn_overlap": {
            "observation_request_shared_turns": sorted(shared_observation_request),
            "observation_recommendation_shared_turns": sorted(shared_observation_recommendation),
            "request_recommendation_shared_turns": sorted(shared_request_recommendation),
            "observation_turns_without_request": sorted(observed_turns - request_turns),
            "observation_turns_without_recommendation": sorted(observed_turns - recommendation_turns),
        },
        "same_turn_timing_comparisons": timing_comparisons,
        "identity_consistency": identity_consistency,
        "request_command_membership": request_command_membership,
        "limitations": [
            "Turn overlap and timestamp order are correlation evidence only; they do not establish causality.",
            "The 2-second timestamp proximity label is diagnostic only; it does not prove same-state alignment or recommendation ownership.",
            "Shared-turn identity comparison checks only fields explicitly present in both records; missing identity is not inferred and matching values do not prove that records describe the same state.",
            "Request command-ID membership in a same-turn observation is a consistency check only; it does not prove request-time state alignment or causality.",
            "Recommendation records with null turn cannot be associated by turn.",
            "The report does not infer action IDs, verify live provenance, or authorize execution.",
        ],
    }


def main() -> int:
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument("--observations", required=True, type=Path, help="URA observations.jsonl")
    parser.add_argument("--requests", required=True, type=Path, help="observed action-requests JSONL")
    parser.add_argument("--recommendations", required=True, type=Path, help="LegendAI recommendations JSONL")
    args = parser.parse_args()
    paths = {
        "observations": args.observations,
        "requests": args.requests,
        "recommendations": args.recommendations,
    }
    try:
        for path in paths.values():
            if not path.is_file():
                raise OSError(f"not a file: {path}")
        report = build_report(paths)
    except (OSError, UnicodeError) as exc:
        print(json.dumps({"mode": "read_only_replay_report", "executable": False,
                          "error": str(exc)}, ensure_ascii=False))
        return 2
    print(json.dumps(report, ensure_ascii=False, separators=(",", ":")))
    has_parse_errors = any(stream["parse_error_count"] for stream in report["streams"].values())
    has_missing_fields = any(stream["missing_required_fields"] for stream in report["streams"].values())
    return 1 if has_parse_errors or has_missing_fields else 0


if __name__ == "__main__":
    raise SystemExit(main())
