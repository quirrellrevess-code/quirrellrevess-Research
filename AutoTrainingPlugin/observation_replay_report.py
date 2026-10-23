#!/usr/bin/env python3
"""Read-only cross-stream report for recorded URA/LegendAI JSONL telemetry.

This tool validates record shapes and reports turn-level overlap. It does not
infer that a request was caused by a recommendation and never executes input.
"""
from __future__ import annotations

import argparse
import json
from datetime import datetime
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
    if name == "recommendations":
        if "captured_at_utc" not in normalized and "timestamp_utc" in normalized:
            normalized["captured_at_utc"] = normalized["timestamp_utc"]
        if "recommendation_text" not in normalized and "recommendation" in normalized:
            normalized["recommendation_text"] = normalized["recommendation"]
    return normalized


def analyze_stream(name: str, records: list[dict[str, Any]], parse_errors: list[dict[str, Any]]) -> dict[str, Any]:
    schema = STREAMS[name]
    records = [normalize_record(name, record) for record in records]
    missing = Counter()
    invalid_turns = 0
    missing_turns = 0
    null_turns = 0
    invalid_turn_types = 0
    invalid_timestamps = 0
    valid_turns: set[int] = set()
    unverified = 0
    executable_marked = 0
    association_status_values: Counter[str] = Counter()
    association_status_missing = 0
    association_status_null = 0
    association_status_invalid = 0
    association_context_mismatch = 0

    for record in records:
        for field in schema["required"]:
            if field not in record:
                missing[field] += 1
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
        if parse_timestamp(record) is None:
            invalid_timestamps += 1
        if record.get("verified") is False:
            unverified += 1
        if record.get("executable") is True:
            executable_marked += 1
        if name == "recommendations":
            if "turn_association_status" not in record:
                association_status_missing += 1
            elif record["turn_association_status"] is None:
                association_status_null += 1
            elif not isinstance(record["turn_association_status"], str) or not record["turn_association_status"].strip():
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
        "explicitly_unverified_count": unverified,
        "marked_executable_count": executable_marked,
    }
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
    for request in requests:
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
            comparisons.append({
                "turn": turn,
                "recommendation": recommendation.get("recommendation_text"),
                "request_command_type": request.get("command_type"),
                "request_command_id": request.get("command_id"),
                "request_minus_recommendation_seconds": delta,
                "timestamp_order": relation,
                "causal_link_verified": False,
            })
    comparisons.sort(key=lambda item: (
        item["turn"],
        item["request_minus_recommendation_seconds"] is None,
        item["request_minus_recommendation_seconds"] or 0,
    ))
    return comparisons


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
    return {
        "mode": "read_only_replay_report",
        "executable": False,
        "streams": reports,
        "timing_comparison_coverage": {
            "recommendations_with_valid_turn": valid_recommendations,
            "requests_with_valid_turn": valid_requests,
            "same_turn_pairs_compared": len(timing_comparisons),
            "recommendations_without_valid_turn_excluded": len(loaded["recommendations"]) - valid_recommendations,
            "requests_without_valid_turn_excluded": len(loaded["requests"]) - valid_requests,
        },
        "turn_overlap": {
            "observation_request_shared_turns": sorted(observed_turns & request_turns),
            "observation_recommendation_shared_turns": sorted(observed_turns & recommendation_turns),
            "request_recommendation_shared_turns": sorted(request_turns & recommendation_turns),
            "observation_turns_without_request": sorted(observed_turns - request_turns),
            "observation_turns_without_recommendation": sorted(observed_turns - recommendation_turns),
        },
        "same_turn_timing_comparisons": timing_comparisons,
        "limitations": [
            "Turn overlap and timestamp order are correlation evidence only; they do not establish causality.",
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
