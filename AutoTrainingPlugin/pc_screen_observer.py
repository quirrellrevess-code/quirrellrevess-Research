#!/usr/bin/env python3
"""Read-only PC screenshot phase observer; no clicks or process injection.

Use --hwnd to bind capture to a visible window's client area and optionally
validate its PID. --bbox remains available for manual calibration.
"""
from __future__ import annotations

import argparse
import json
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
        result = cv2.matchTemplate(image, template, cv2.TM_CCOEFF_NORMED)
        _, score, _, _ = cv2.minMaxLoc(result)
        matches.append({"phase": phase, "confidence": float(score)})
    return classify_phase(matches, allowed_phases=allowed_phases)


def main() -> int:
    parser = argparse.ArgumentParser(description=__doc__)
    source = parser.add_mutually_exclusive_group(required=True)
    source.add_argument("--bbox", type=int, nargs=4, metavar=("LEFT", "TOP", "RIGHT", "BOTTOM"))
    source.add_argument("--hwnd", type=lambda value: int(value, 0), help="Window handle from pc_window_probe")
    parser.add_argument("--expected-pid", type=int, help="Required PID guard when using --hwnd")
    parser.add_argument("--templates", type=Path, required=True)
    parser.add_argument("--phases", nargs="+", required=True)
    args = parser.parse_args()
    if args.hwnd is None and args.expected_pid is not None:
        parser.error("--expected-pid requires --hwnd")
    if args.expected_pid is not None and args.expected_pid <= 0:
        parser.error("--expected-pid must be positive")
    if args.bbox is not None:
        left, top, right, bottom = args.bbox
        if right <= left or bottom <= top or right - left > 8192 or bottom - top > 8192:
            parser.error("invalid capture bounds")
    if len(set(args.phases)) != len(args.phases) or not all(p.isidentifier() for p in args.phases):
        parser.error("invalid phase identifiers")
    try:
        import cv2
        import numpy as np
        if args.hwnd is not None:
            from pc_window_capture import capture_client_area
            shot, rect = capture_client_area(args.hwnd, expected_pid=args.expected_pid)
        else:
            from PIL import ImageGrab
            rect = tuple(args.bbox)
            shot = ImageGrab.grab(bbox=rect)
        frame = cv2.cvtColor(np.array(shot), cv2.COLOR_RGB2BGR)
        evidence = detect_phase(frame, args.templates, allowed_phases=set(args.phases), cv2=cv2)
    except (OSError, RuntimeError, ValueError, ImportError, cv2.error if "cv2" in locals() else ValueError):
        print(json.dumps({"mode": "read_only", "phase": "unknown", "verified": False,
                          "reason": "capture_or_detection_failed"}))
        return 2
    print(json.dumps({"mode": "read_only", "capture_rect": list(rect), "phase": evidence.phase,
                      "confidence": evidence.confidence, "verified": evidence.verified,
                      "reason": evidence.reason}))
    return 0 if evidence.verified else 1


if __name__ == "__main__":
    raise SystemExit(main())
