#!/usr/bin/env python3
"""Fail-closed handoff guard for future LegendAI action execution.

This module never chooses an action or submits game input. An upstream
adapter must provide a verified turn and an explicit, supported action ID.
"""
from __future__ import annotations

from dataclasses import dataclass
from typing import Any, Mapping


@dataclass(frozen=True)
class GuardResult:
    allowed: bool
    reason: str


def check_action(
    recommendation: Mapping[str, Any],
    state: Mapping[str, Any],
    *,
    supported_actions: set[str],
    completed_turns: set[tuple[str, int]],
) -> GuardResult:
    """Reject stale, ambiguous, duplicate, or unsupported actions."""
    if not isinstance(recommendation, Mapping) or not isinstance(state, Mapping):
        return GuardResult(False, "invalid_input")

    run_id = recommendation.get("run_id")
    state_run_id = state.get("run_id")
    turn = recommendation.get("turn")
    state_turn = state.get("turn")
    action = recommendation.get("action_id")
    if not isinstance(run_id, str) or not run_id or run_id != state_run_id:
        return GuardResult(False, "run_mismatch")
    if type(turn) is not int or type(state_turn) is not int or turn < 0 or turn != state_turn:
        return GuardResult(False, "stale_or_missing_turn")
    if not isinstance(action, str) or not action or action not in supported_actions:
        return GuardResult(False, "unsupported_action")
    if recommendation.get("verified") is not True:
        return GuardResult(False, "unverified_recommendation")
    if state.get("ready") is not True:
        return GuardResult(False, "state_not_ready")
    if (run_id, turn) in completed_turns:
        return GuardResult(False, "turn_already_completed")
    return GuardResult(True, "eligible_for_executor")


__all__ = ["GuardResult", "check_action"]
