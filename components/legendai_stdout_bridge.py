#!/usr/bin/env python3
"""Read-only LegendAI stdout bridge.

Consumes lines from the existing AIRedirector Legend AI stdout stream and
records recommendation candidates. This is an observation adapter only:
it does not start another AI process, invent game command IDs, or submit input.
The stdout-only path cannot reliably associate a recommendation with a turn.
"""
from __future__ import annotations

import argparse
import json
import sys
from datetime import datetime, timezone
from pathlib import Path


_MAX_RECOMMENDATION_LINE_CHARS = 4096
_LINE_BREAK_CHARACTERS = "\r\n\v\f\x1c\x1d\x1e\x85\u2028\u2029"


def _within_utf16_limit(value: str) -> bool:
    """Match .NET string.Length by counting UTF-16 code units, not Python code points."""
    if len(value) > _MAX_RECOMMENDATION_LINE_CHARS:
        return False
    units = 0
    for character in value:
        units += 2 if ord(character) > 0xFFFF else 1
        if units > _MAX_RECOMMENDATION_LINE_CHARS:
            return False
    return True


def parse_recommendation(line: str) -> dict[str, str] | None:
    """Extract a bounded human-readable candidate, never a game command ID."""
    if type(line) is not str or len(line) > _MAX_RECOMMENDATION_LINE_CHARS + 2:
        return None
    # stdin lines include at most one terminal LF, CRLF, or CR delimiter.
    # Remove only that delimiter; embedded or repeated line breaks are malformed
    # and must not be folded into one recommendation record.
    if line.endswith("\r\n"):
        raw = line[:-2]
    elif line.endswith("\n") or line.endswith("\r"):
        raw = line[:-1]
    else:
        raw = line
    if any(character in _LINE_BREAK_CHARACTERS for character in raw):
        return None
    if not _within_utf16_limit(raw):
        return None
    normalized = raw.strip()
    prefix = "AI建议"
    if not normalized.startswith(prefix):
        return None
    remainder = normalized[len(prefix):].lstrip()
    if not remainder or remainder[0] not in ":：":
        return None
    body = remainder[1:].strip()
    if not body:
        return None

    # These are labels for later mapping, not executable game action identifiers.
    first = body[0]
    training_labels = {
        "速", "耐", "力", "根", "智",
        "速度", "耐力", "力量", "根性", "智力",
    }
    if body in training_labels or any(
        marker in body for marker in ("训练", "訓練", "トレーニング")
    ):
        kind = "training"
        value = first if first in "速耐力根智" else body
    elif any(
        marker in body
        for marker in ("休息", "外出", "保健室", "休む", "比赛", "比賽", "不选", "不選")
    ):
        kind, value = "named_action", body
    elif any(marker in body for marker in ("第", "选", "選", "个", "個", "番")):
        kind, value = "selection_text", body
    else:
        kind, value = "unknown", body

    return {"raw": raw, "recommendation_text": body, "candidate_kind": kind, "candidate_value": value}


def extract_recommendation(line: str) -> str | None:
    """Compatibility helper preserving the original raw recommendation line."""
    parsed = parse_recommendation(line)
    return parsed["raw"] if parsed else None


def iter_bounded_lines(stream, *, max_line_chars: int = _MAX_RECOMMENDATION_LINE_CHARS):
    """Yield bounded stdin lines; oversized physical lines are discarded in chunks.

    The payload limit is enforced after removing at most one terminal LF,
    CRLF, or CR delimiter. The first read is capped at max_line_chars + 3 to
    allow a maximum-size payload plus CRLF and one overflow character. If that
    cap is reached without LF, the rest of that physical line is discarded in
    1,024-character chunks. None marks an oversized line and is ignored by
    parse_recommendation.
    """
    if (
        type(max_line_chars) is not int
        or not 1 <= max_line_chars <= _MAX_RECOMMENDATION_LINE_CHARS
    ):
        raise ValueError(
            "max_line_chars must be a built-in int between 1 and "
            f"{_MAX_RECOMMENDATION_LINE_CHARS}"
        )
    readline = getattr(stream, "readline", None)
    if not callable(readline):
        raise TypeError("stream must provide readline(size)")

    first_read_size = max_line_chars + 3
    while True:
        line = readline(first_read_size)
        if line == "":
            return
        if len(line) < first_read_size or line.endswith(("\n", "\r")):
            if line.endswith("\r\n"):
                payload = line[:-2]
            elif line.endswith("\n") or line.endswith("\r"):
                payload = line[:-1]
            else:
                payload = line
            yield line if len(payload) <= max_line_chars else None
            if not line.endswith(("\n", "\r")):
                return
            continue

        # The physical line exceeded the bounded first read. Never accumulate
        # the remainder: consume it in fixed-size chunks through the next LF.
        yield None
        while True:
            remainder = readline(1024)
            if remainder == "":
                return
            if remainder.endswith(("\n", "\r")):
                break


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
                "turn_association_status": "unavailable_in_stdout_only",
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
        default=Path("PluginData/UmaAutoTraining/legendai-stdout-recommendations.jsonl"),
        help="append-only JSONL destination (separate from AIRedirector sink output)",
    )
    args = parser.parse_args()
    try:
        record_stream(iter_bounded_lines(sys.stdin), args.output)
    except (OSError, UnicodeError) as exc:
        print(f"LegendAI bridge failed: {exc}", file=sys.stderr)
        return 1
    return 0


if __name__ == "__main__":
    raise SystemExit(main())
