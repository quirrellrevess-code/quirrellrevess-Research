#!/usr/bin/env python3
"""Read-only LegendAI stdout bridge.

Reads UTF-8 lines from stdin (e.g. from the existing AIRedirector process
output stream), records raw recommendation lines to JSONL. This script does
not start a second LegendAI process, infer action IDs, or click/send actions.
"""
from __future__ import annotations

import argparse
import json
import os
import sys
import time
from datetime import datetime, timezone
from pathlib import Path


def extract_recommendation(line: str) -> str | None:
    """Preserve the complete raw recommendation, without guessing action IDs."""
    text = line.rstrip("\r\n")
    return text if "AI建议" in text else None


def record_stream(lines, destination: Path) -> int:
    destination.parent.mkdir(parents=True, exist_ok=True)
    count = 0
    with destination.open("a", encoding="utf-8", newline="\n") as out:
        for line in lines:
            recommendation = extract_recommendation(line)
            if recommendation is None:
                continue
            record = {
                "captured_at_utc": datetime.now(timezone.utc).isoformat(),
                "source": "legendai_stdout",
                "raw": recommendation,
                "turn": None,
                "action_id": None,
                "executable": False,
            }
            out.write(json.dumps(record, ensure_ascii=False, separators=(",", ":")) + "\n")
            out.flush()
            count += 1
    return count


def main() -> int:
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument(
        "--output",
        type=Path,
        default=Path("PluginData/UmaAutoTraining/legendai-recommendations.jsonl"),
        help="append-only JSONL destination",
    )
    args = parser.parse_args()
    try:
        record_stream(sys.stdin, args.output)
    except (OSError, UnicodeError) as exc:
        print(f"LegendAI bridge failed: {exc}", file=sys.stderr)
        return 1
    return 0


if __name__ == "__main__":
    raise SystemExit(main())
