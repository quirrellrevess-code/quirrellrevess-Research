#!/usr/bin/env python3
"""Read-only LegendAI stdout bridge.

Consumes lines from the existing AIRedirector Legend AI stdout stream and
records recommendation candidates. This is an observation adapter only:
it does not start another AI process, invent game command IDs, or submit input.
"""
from __future__ import annotations

import argparse
import json
import sys
from datetime import datetime, timezone
from pathlib import Path


def parse_recommendation(line: str) -> dict[str, str] | None:
    """Extract a conservative human-readable candidate, never a game command ID."""
    raw = line.rstrip("\r\n")
    normalized = raw.strip()
    if not normalized.startswith("AI建议"):
        return None

    separator = next((i for i, char in enumerate(normalized) if char in ":："), -1)
    if separator < 0:
        return None
    body = normalized[separator + 1 :].strip()
    if not body:
        return None

    # These are labels for later mapping, not executable game action identifiers.
    first = body[0]
    if first in "速耐力根智":
        kind, value = "training", first
    elif body in {"休息", "外出", "普通外出", "比赛", "不选"}:
        kind, value = "named_action", body
    elif body.startswith("选") and any(color in body for color in ("蓝色", "绿色", "红色")):
        kind, value = "selection_text", body
    else:
        kind, value = "unknown", body

    return {"raw": raw, "recommendation_text": body, "candidate_kind": kind, "candidate_value": value}


def extract_recommendation(line: str) -> str | None:
    """Compatibility helper preserving the original raw recommendation line."""
    parsed = parse_recommendation(line)
    return parsed["raw"] if parsed else None


def record_stream(lines, destination: Path) -> int:
    destination.parent.mkdir(parents=True, exist_ok=True)
    count = 0
    with destination.open("a", encoding="utf-8", newline="\n") as out:
        for line in lines:
            parsed = parse_recommendation(line)
            if parsed is None:
                continue
            record = {
                "captured_at_utc": datetime.now(timezone.utc).isoformat(),
                "source": "legendai_stdout",
                **parsed,
                "turn": None,
                "single_mode_chara_id": None,
                "action_id": None,
                "verified": False,
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
