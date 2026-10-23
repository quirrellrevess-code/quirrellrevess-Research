#!/usr/bin/env python3
"""Fail-closed merger of independent URA state and PC phase evidence.

This module only normalizes observations; it does not prove temporal alignment,
authorize input, or infer run/turn identifiers from pixels.
"""
from __future__ import annotations

from collections.abc import Mapping
from typing import Any


def normalize_observation(
    ura_state: Mapping[str, Any] | None,
    phase_evidence: Mapping[str, Any] | None,
) -> dict[str, Any]:
    """Return a non-executable state; ready only with independently verified inputs."""
    result: dict[str, Any] = {
        "run_id": None, "turn": None, "phase": "unknown",
        "ready": False, "verified": False, "executable": False,
        "reason": "missing_or_invalid_evidence",
    }
    if not isinstance(ura_state, Mapping) or not isinstance(phase_evidence, Mapping):
        return result

    run_id, turn = ura_state.get("run_id"), ura_state.get("turn")
    if not isinstance(run_id, str) or not run_id or type(turn) is not int or turn < 0:
        result["reason"] = "invalid_ura_identity"
        return result
    result["run_id"], result["turn"] = run_id, turn

    phase = phase_evidence.get("phase")
    if phase_evidence.get("verified") is not True or not isinstance(phase, str) or not phase or phase == "unknown":
        result["reason"] = "unverified_pc_phase"
        return result
    result["phase"] = phase

    # A verified phase and valid turn are not enough to establish that the
    # sources refer to the same instant or that input is safe.
    result["reason"] = "temporal_alignment_unverified"
    return result


__all__ = ["normalize_observation"]
