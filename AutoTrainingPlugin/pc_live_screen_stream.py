#!/usr/bin/env python3
"""Long-running, read-only PC screen observation stream (Windows only).

Captures a visible HWND repeatedly and emits JSONL phase evidence with a
process-local sequence and monotonic capture timestamp. It never submits input.
"""
from __future__ import annotations

import argparse
import json
import time
from pathlib import Path

from pc_capture_envelope import PcCaptureEnvelope
from pc_screen_observer import detect_phase
from pc_window_capture import capture_client_area


def build_observation_record(envelope, evidence, rect):
    """Build a JSONL record while preserving the read-only execution boundary."""
    record = envelope.record_capture({
        "phase": evidence.phase,
        "phase_confidence": evidence.confidence,
        "phase_verified": evidence.verified,
        "phase_reason": evidence.reason,
        "capture_rect": list(rect),
        "ready": False,
        "verified": False,
        "executable": False,
    })
    record["mode"] = "read_only"
    record["verified"] = False
    record["ready"] = False
    record["executable"] = False
    return record


def build_failure_record(exc):
    """Return a minimal fail-closed error record without leaking exception text."""
    return {
        "mode": "read_only",
        "phase": "unknown",
        "verified": False,
        "ready": False,
        "executable": False,
        "reason": "capture_or_detection_failed",
        "error_type": type(exc).__name__,
    }


def main() -> int:
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument("--hwnd", type=lambda value: int(value, 0), required=True)
    parser.add_argument("--expected-pid", type=int, required=True)
    parser.add_argument("--templates", type=Path, required=True)
    parser.add_argument("--phases", nargs="+", required=True)
    parser.add_argument("--interval-ms", type=int, default=500)
    args = parser.parse_args()
    if args.hwnd <= 0 or args.expected_pid <= 0:
        parser.error("HWND and PID must be positive")
    if args.interval_ms < 100 or args.interval_ms > 10000:
        parser.error("--interval-ms must be between 100 and 10000")
    if len(set(args.phases)) != len(args.phases) or not all(p.isidentifier() for p in args.phases):
        parser.error("invalid phase identifiers")
    try:
        import cv2
        import numpy as np
    except ImportError as exc:
        parser.error(f"optional screenshot dependencies missing: {exc}")

    envelope = PcCaptureEnvelope()
    try:
        while True:
            started = time.monotonic()
            shot, rect = capture_client_area(args.hwnd, expected_pid=args.expected_pid)
            frame = cv2.cvtColor(np.array(shot), cv2.COLOR_RGB2BGR)
            evidence = detect_phase(frame, args.templates, allowed_phases=set(args.phases), cv2=cv2)
            # The timestamp marks this completed observation envelope, not exact
            # pixel-exposure time. Record builder always forces execution flags off.
            record = build_observation_record(envelope, evidence, rect)
            print(json.dumps(record, separators=(",", ":"), allow_nan=False), flush=True)
            elapsed = time.monotonic() - started
            time.sleep(max(0.0, args.interval_ms / 1000.0 - elapsed))
    except KeyboardInterrupt:
        return 0
    except (OSError, RuntimeError, ValueError, cv2.error) as exc:
        print(json.dumps(build_failure_record(exc), separators=(",", ":")), flush=True)
        return 2


if __name__ == "__main__":
    raise SystemExit(main())
