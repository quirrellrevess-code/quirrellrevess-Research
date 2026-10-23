#!/usr/bin/env python3
"""Read-only PC screenshot phase observer; no clicks or process injection.

Requires explicit --bbox and user-supplied template directory. Templates are
never downloaded automatically. Fails closed on missing/ambiguous evidence.
"""
from __future__ import annotations

import argparse
import json
import math
from pathlib import Path

from pc_phase_evidence import classify_phase


def detect_phase(image, templates_dir: Path, *, allowed_phases: set[str], cv2):
    matches = []
    if not allowed_phases:
        raise ValueError("no allowed phases")
    for phase in sorted(allowed_phases):
        path = templates_dir / (phase + ".png")
        if not path.is_file():
            continue
        template = cv2.imread(str(path), cv2.IMREAD_COLOR)
        if template is None or template.size == 0:
            continue
        if template.shape[0] > image.shape[0] or template.shape[1] > image.shape[1]:
            continue
        if template.shape[0] < 8 or template.shape[1] < 8:
            continue
        # Constant/near-constant templates produce meaningless normalized
        # correlation scores (often 1.0 everywhere). Reject them rather than
        # treating a visually uninformative patch as phase evidence.
        try:
            template_spread = float(template.std())
        except (AttributeError, TypeError, ValueError):
            template_spread = None
        if template_spread is not None and (not math.isfinite(template_spread) or template_spread < 1.0):
            continue

        result = cv2.matchTemplate(image, template, cv2.TM_CCOEFF_NORMED)
        _, score, _, _ = cv2.minMaxLoc(result)
        score = float(score)
        # OpenCV can emit NaN for degenerate inputs. Do not pass invalid
        # values to the classifier or accidentally promote them to evidence.
        if not math.isfinite(score) or not -1.0 <= score <= 1.0:
            continue
        matches.append({"phase": phase, "confidence": score})
    return classify_phase(matches, allowed_phases=allowed_phases)


def main() -> int:
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument("--bbox", type=int, nargs=4, required=True, metavar=("LEFT", "TOP", "RIGHT", "BOTTOM"))
    parser.add_argument("--templates", type=Path, required=True)
    parser.add_argument("--phases", nargs="+", required=True)
    args = parser.parse_args()
    left, top, right, bottom = args.bbox
    if right <= left or bottom <= top or right - left > 8192 or bottom - top > 8192:
        parser.error("invalid capture bounds")
    if len(set(args.phases)) != len(args.phases) or not all(p.isidentifier() for p in args.phases):
        parser.error("invalid phase identifiers")
    try:
        import cv2
        import numpy as np
        from PIL import ImageGrab
    except ImportError as exc:
        parser.error(f"optional screenshot dependencies missing: {exc}")
    try:
        shot = ImageGrab.grab(bbox=(left, top, right, bottom))
        frame = cv2.cvtColor(np.array(shot), cv2.COLOR_RGB2BGR)
        evidence = detect_phase(frame, args.templates, allowed_phases=set(args.phases), cv2=cv2)
    except (OSError, ValueError, cv2.error) as exc:
        print(json.dumps({"mode": "read_only", "phase": "unknown", "verified": False, "reason": "capture_or_detection_failed"}))
        return 2
    print(json.dumps({"mode": "read_only", "phase": evidence.phase, "confidence": evidence.confidence,
                      "verified": evidence.verified, "reason": evidence.reason}))
    return 0 if evidence.verified else 1


if __name__ == "__main__":
    raise SystemExit(main())
