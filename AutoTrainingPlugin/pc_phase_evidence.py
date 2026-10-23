#!/usr/bin/env python3
"""Passive screen-classification evidence adapter.

This does not capture screens or issue input. An independently validated
vision adapter supplies detections; ambiguous/weak evidence stays unknown.
"""
from __future__ import annotations

from dataclasses import dataclass
from typing import Iterable, Mapping, Any


@dataclass(frozen=True)
class PhaseEvidence:
    phase: str
    confidence: float
    verified: bool
    reason: str


def classify_phase(
    detections: Iterable[Mapping[str, Any]],
    *,
    allowed_phases: set[str],
    threshold: float = 0.90,
    margin: float = 0.10,
) -> PhaseEvidence:
    if not 0.0 < threshold <= 1.0 or not 0.0 <= margin <= 1.0:
        raise ValueError("invalid confidence policy")
    candidates: list[tuple[str, float]] = []
    for item in detections:
        if not isinstance(item, Mapping):
            return PhaseEvidence("unknown", 0.0, False, "malformed_detection")
        phase, confidence = item.get("phase"), item.get("confidence")
        if not isinstance(phase, str) or phase not in allowed_phases:
            continue
        if type(confidence) not in (int, float) or not 0.0 <= confidence <= 1.0:
            return PhaseEvidence("unknown", 0.0, False, "invalid_confidence")
        candidates.append((phase, float(confidence)))
    if not candidates:
        return PhaseEvidence("unknown", 0.0, False, "no_known_phase")
    candidates.sort(key=lambda entry: entry[1], reverse=True)
    top_phase, top_confidence = candidates[0]
    if top_confidence < threshold:
        return PhaseEvidence("unknown", top_confidence, False, "low_confidence")
    # Duplicate matches for the same phase do not create ambiguity.
    competing = max((value for phase, value in candidates if phase != top_phase), default=-1.0)
    if top_confidence - competing < margin:
        return PhaseEvidence("unknown", top_confidence, False, "ambiguous_phase")
    return PhaseEvidence(top_phase, top_confidence, True, "phase_recognized")


__all__ = ["PhaseEvidence", "classify_phase"]
