#!/usr/bin/env python3
"""Read-only UI target candidate detector; it never clicks or submits input.

Each allowed target uses a trusted local <target_id>.png template. Results are
candidate screen rectangles only, not proof that clicking is safe or correct.
"""
from __future__ import annotations

import argparse
import json
import math
from pathlib import Path

from pc_window_capture import capture_client_area


def detect_targets(
    image,
    templates_dir: Path,
    *,
    allowed_targets: set[str],
    cv2,
    screen_origin: tuple[int, int] = (0, 0),
    threshold: float = 0.92,
    ambiguity_margin: float = 0.035,
):
    if not allowed_targets:
        raise ValueError("no allowed targets")
    if not 0.0 < threshold <= 1.0 or not 0.0 <= ambiguity_margin <= 1.0:
        raise ValueError("invalid confidence policy")
    candidates = []
    for target_id in sorted(allowed_targets):
        path = templates_dir / (target_id + ".png")
        if not path.is_file():
            continue
        template = cv2.imread(str(path), cv2.IMREAD_COLOR)
        if template is None or template.size == 0:
            continue
        height, width = template.shape[:2]
        if height < 8 or width < 8 or height > image.shape[0] or width > image.shape[1]:
            continue
        try:
            spread = float(template.std())
        except (AttributeError, TypeError, ValueError):
            continue
        if not math.isfinite(spread) or spread < 1.0:
            continue
        result = cv2.matchTemplate(image, template, cv2.TM_CCOEFF_NORMED)
        _, best_score, best_loc, _ = cv2.minMaxLoc(result)
        best_score = float(best_score)
        if not math.isfinite(best_score) or not -1.0 <= best_score <= 1.0:
            continue

        # Look for a second spatially distinct hit. A repeated button/template
        # match is ambiguous, even if the best hit itself is high confidence.
        try:
            search = result.copy()
            x, y = best_loc
            search[y:y + height, x:x + width] = -1.0
            _, second_score, _, _ = cv2.minMaxLoc(search)
            second_score = float(second_score)
        except (AttributeError, TypeError, ValueError, IndexError):
            continue
        if not math.isfinite(second_score):
            continue
        ambiguous = second_score >= threshold and best_score - second_score < ambiguity_margin
        verified = best_score >= threshold and not ambiguous
        left = screen_origin[0] + int(best_loc[0])
        top = screen_origin[1] + int(best_loc[1])
        candidates.append({
            "target_id": target_id,
            "confidence": best_score,
            "bbox": [left, top, left + width, top + height],
            "verified": verified,
            "reason": "ambiguous_multiple_matches" if ambiguous else (
                "target_candidate" if verified else "low_confidence"
            ),
            "executable": False,
        })
    return candidates


def main() -> int:
    parser = argparse.ArgumentParser(description=__doc__)
    capture = parser.add_mutually_exclusive_group(required=True)
    capture.add_argument("--bbox", type=int, nargs=4, metavar=("LEFT", "TOP", "RIGHT", "BOTTOM"))
    capture.add_argument("--hwnd", type=lambda value: int(value, 0))
    parser.add_argument("--expected-pid", type=int)
    parser.add_argument("--templates", type=Path, required=True)
    parser.add_argument("--targets", nargs="+", required=True)
    args = parser.parse_args()
    if args.bbox:
        left, top, right, bottom = args.bbox
        if right <= left or bottom <= top or right - left > 8192 or bottom - top > 8192:
            parser.error("invalid capture bounds")
    if args.expected_pid is not None and args.expected_pid <= 0:
        parser.error("--expected-pid must be positive")
    if args.expected_pid is not None and args.hwnd is None:
        parser.error("--expected-pid requires --hwnd")
    if len(set(args.targets)) != len(args.targets) or not all(t.isidentifier() for t in args.targets):
        parser.error("invalid target identifiers")
    try:
        import cv2
        import numpy as np
        from PIL import ImageGrab
    except ImportError as exc:
        parser.error(f"optional screenshot dependencies missing: {exc}")
    try:
        if args.hwnd is not None:
            shot, rect = capture_client_area(args.hwnd, expected_pid=args.expected_pid)
        else:
            rect = (left, top, right, bottom)
            shot = ImageGrab.grab(bbox=rect)
        frame = cv2.cvtColor(np.array(shot), cv2.COLOR_RGB2BGR)
        candidates = detect_targets(
            frame, args.templates, allowed_targets=set(args.targets), cv2=cv2,
            screen_origin=(rect[0], rect[1]))
    except (OSError, RuntimeError, ValueError, cv2.error):
        print(json.dumps({"mode": "read_only", "verified": False, "reason": "capture_or_detection_failed",
                          "targets": []}))
        return 2
    print(json.dumps({"mode": "read_only", "capture_rect": rect, "verified": False,
                      "reason": "candidates_require_action_mapping_and_state_validation",
                      "targets": candidates}, ensure_ascii=False))
    # Even high-confidence target candidates are never treated as executable.
    return 0


if __name__ == "__main__":
    raise SystemExit(main())
