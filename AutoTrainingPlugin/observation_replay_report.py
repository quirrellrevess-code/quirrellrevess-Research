#!/usr/bin/env python3
"""Read-only cross-stream report for recorded URA/LegendAI JSONL telemetry.

This tool validates record shapes and reports turn-level overlap. It does not
infer that a request was caused by a recommendation and never executes input.
"""
from __future__ import annotations

import argparse
import json
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
    valid_turns: set[int] = set()
    unverified = 0
    executable_marked = 0

    for record in records:
        for field in schema["required"]:
            if field not in record:
                missing[field] += 1
        turn = record.get(schema["turn_field"])
        if type(turn) is int and turn >= 0:
            valid_turns.add(turn)
        else:
            invalid_turns += 1
        if record.get("verified") is False:
            unverified += 1
        if record.get("executable") is True:
            executable_marked += 1

    return {
        "record_count": len(records),
        "parse_error_count": len(parse_errors),
        "parse_errors": parse_errors[:20],
        "missing_required_fields": dict(sorted(missing.items())),
        "valid_turn_count": len(valid_turns),
        "turns": sorted(valid_turns),
        "records_without_valid_turn": invalid_turns,
        "explicitly_unverified_count": unverified,
        "marked_executable_count": executable_marked,
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
    return {
        "mode": "read_only_replay_report",
        "executable": False,
        "streams": reports,
        "turn_overlap": {
            "observation_request_shared_turns": sorted(observed_turns & request_turns),
            "observation_recommendation_shared_turns": sorted(observed_turns & recommendation_turns),
            "request_recommendation_shared_turns": sorted(request_turns & recommendation_turns),
            "observation_turns_without_request": sorted(observed_turns - request_turns),
            "observation_turns_without_recommendation": sorted(observed_turns - recommendation_turns),
        },
        "limitations": [
            "Turn overlap is correlation evidence only; it does not establish causality.",
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
