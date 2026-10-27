#!/usr/bin/env python3
"""Offline dry-run for recommendation-to-UI-target association; never submits input."""
from __future__ import annotations
import argparse
import json
import sys
from pathlib import Path
from typing import Any, Mapping
from pc_action_target_mapping import resolve_target


def preview_payload(payload: Any) -> dict[str, Any]:
    def blocked(reason: str) -> dict[str, Any]:
        return {"mode": "dry_run", "matched": False, "executable": False,
                "reason": reason, "target": None}
    if not isinstance(payload, Mapping):
        return blocked("invalid_payload")
    rows = payload.get("mapping")
    if not isinstance(rows, list):
        return blocked("invalid_mapping")
    mapping: dict[tuple[str, str], str] = {}
    for row in rows:
        if not isinstance(row, Mapping):
            return blocked("invalid_mapping_row")
        phase, action_id, target_id = (row.get(k) for k in ("phase", "action_id", "target_id"))
        if not all(isinstance(v, str) and v for v in (phase, action_id, target_id)):
            return blocked("invalid_mapping_row")
        key = (phase, action_id)
        if key in mapping:
            return blocked("duplicate_mapping_key")
        mapping[key] = target_id
    result = resolve_target(payload.get("recommendation"), payload.get("state"),
                            payload.get("candidates"), mapping=mapping)
    return {"mode": "dry_run", **result, "executable": False}


def main() -> int:
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument("input", nargs="?", type=Path, help="JSON file; defaults to stdin")
    args = parser.parse_args()
    try:
        if args.input is None:
            payload = json.load(sys.stdin)
        else:
            with args.input.open("r", encoding="utf-8") as source:
                payload = json.load(source)
        result = preview_payload(payload)
    except (OSError, UnicodeError, json.JSONDecodeError) as exc:
        print(json.dumps({"mode": "dry_run", "matched": False, "executable": False,
                          "reason": "input_read_failed", "detail": str(exc)}, ensure_ascii=False))
        return 2
    print(json.dumps(result, ensure_ascii=False, separators=(",", ":")))
    return 0 if result.get("matched") else 1


if __name__ == "__main__":
    raise SystemExit(main())
