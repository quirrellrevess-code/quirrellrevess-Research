#!/usr/bin/env python3
"""Fail-closed association of verified recommendations with read-only UI targets.

This module resolves an explicit, locally configured mapping only. It never
submits input, chooses a target heuristically, or marks a result executable.
"""
from __future__ import annotations

import math
from typing import Any, Mapping, Sequence


def resolve_target(
    recommendation: Mapping[str, Any],
    state: Mapping[str, Any],
    candidates: Sequence[Mapping[str, Any]],
    *,
    mapping: Mapping[tuple[str, str], str],
    min_confidence: float = 0.92,
) -> dict[str, Any]:
    """Resolve (phase, action_id) to exactly one verified target candidate."""
    def blocked(reason: str) -> dict[str, Any]:
        return {"matched": False, "executable": False, "reason": reason, "target": None}

    if not isinstance(recommendation, Mapping) or not isinstance(state, Mapping):
        return blocked("invalid_input")
    if not isinstance(mapping, Mapping):
        return blocked("invalid_mapping")
    if (isinstance(min_confidence, bool) or not isinstance(min_confidence, (int, float))
            or not math.isfinite(min_confidence) or not 0.0 <= min_confidence <= 1.0):
        return blocked("invalid_confidence_policy")
    if recommendation.get("verified") is not True:
        return blocked("unverified_recommendation")
    run_id = recommendation.get("run_id")
    turn = recommendation.get("turn")
    if not isinstance(run_id, str) or not run_id or run_id != state.get("run_id"):
        return blocked("run_mismatch")
    if type(turn) is not int or type(state.get("turn")) is not int or turn != state.get("turn"):
        return blocked("stale_or_missing_turn")
    if state.get("ready") is not True:
        return blocked("state_not_ready")
    phase = state.get("phase")
    action_id = recommendation.get("action_id")
    if not isinstance(phase, str) or not phase or not isinstance(action_id, str) or not action_id:
        return blocked("missing_phase_or_action")
    target_id = mapping.get((phase, action_id))
    if not isinstance(target_id, str) or not target_id:
        return blocked("mapping_not_found")
    if not isinstance(candidates, Sequence) or isinstance(candidates, (str, bytes)):
        return blocked("invalid_candidates")
    matches = [
        item for item in candidates
        if isinstance(item, Mapping) and item.get("target_id") == target_id
    ]
    if not matches:
        return blocked("target_not_detected")
    if len(matches) != 1:
        return blocked("duplicate_target_candidates")
    candidate = matches[0]
    if candidate.get("verified") is not True:
        return blocked("target_not_verified")
    if candidate.get("reason") != "target_candidate":
        return blocked("target_evidence_rejected")
    confidence = candidate.get("confidence")
    if (isinstance(confidence, bool) or not isinstance(confidence, (int, float))
            or not math.isfinite(confidence) or not 0.0 <= confidence <= 1.0):
        return blocked("invalid_target_confidence")
    if confidence < min_confidence:
        return blocked("target_confidence_below_policy")
    if candidate.get("executable") is not False:
        return blocked("candidate_execution_flag_inconsistent")
    bbox = candidate.get("bbox")
    if (not isinstance(bbox, list) or len(bbox) != 4
            or any(type(v) is not int for v in bbox)
            or bbox[2] <= bbox[0] or bbox[3] <= bbox[1]):
        return blocked("invalid_target_bounds")
    return {
        "matched": True,
        "executable": False,
        "reason": "explicit_mapping_resolved_non_executable",
        "phase": phase,
        "run_id": run_id,
        "turn": turn,
        "action_id": action_id,
        "target": {"target_id": target_id, "bbox": list(bbox)},
    }


__all__ = ["resolve_target"]
