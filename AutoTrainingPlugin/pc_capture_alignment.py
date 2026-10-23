#!/usr/bin/env python3
"""Read-only temporal alignment diagnostics for independently captured evidence.

Timestamps must be issued by the same trusted monotonic clock in the capture
process. JSONL wall-clock timestamps, AI-provided values, and cross-process
monotonic readings cannot establish alignment through this function.
"""
from __future__ import annotations

from dataclasses import dataclass


@dataclass(frozen=True)
class AlignmentResult:
    aligned: bool
    reason: str
    skew_ns: int | None = None


def assess_capture_alignment(
    ura_capture_ns: int,
    pc_capture_ns: int,
    *,
    max_skew_ns: int = 250_000_000,
) -> AlignmentResult:
    """Check same-clock capture proximity, without authorizing game actions."""
    if (type(ura_capture_ns) is not int or type(pc_capture_ns) is not int
            or ura_capture_ns < 0 or pc_capture_ns < 0):
        return AlignmentResult(False, "invalid_capture_timestamp")
    if type(max_skew_ns) is not int or max_skew_ns < 0:
        return AlignmentResult(False, "invalid_skew_policy")
    skew = abs(ura_capture_ns - pc_capture_ns)
    if skew > max_skew_ns:
        return AlignmentResult(False, "capture_skew_exceeded", skew)
    return AlignmentResult(True, "capture_times_proximate_unverified", skew)


__all__ = ["AlignmentResult", "assess_capture_alignment"]
