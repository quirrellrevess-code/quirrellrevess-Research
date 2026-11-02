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


def _valid_action_allowlist(value: Any) -> bool:
    return (
        type(value) in (set, frozenset)
        and all(
            type(action) is str and bool(action) and action == action.strip()
            for action in value
        )
    )


def _valid_completion_ledger(value: Any) -> bool:
    return (
        type(value) in (set, frozenset)
        and all(
            type(entry) is tuple
            and len(entry) == 2
            and type(entry[0]) is str
            and bool(entry[0])
            and entry[0] == entry[0].strip()
            and type(entry[1]) is int
            and entry[1] >= 0
            for entry in value
        )
    )


def check_action(
    recommendation: Mapping[str, Any],
    state: Mapping[str, Any],
    *,
    supported_actions: set[str] | frozenset[str],
    completed_turns: set[tuple[str, int]] | frozenset[tuple[str, int]],
) -> GuardResult:
    """Reject stale, ambiguous, duplicate, or unsupported actions.

    completed_turns is a caller-owned ledger and is not persisted here.
    An allowed result means only that the supplied evidence is eligible for a
    separately verified executor; it does not provide or prove an action
    submission channel.
    """
    if not isinstance(recommendation, Mapping) or not isinstance(state, Mapping):
        return GuardResult(False, "invalid_input")
    if not _valid_action_allowlist(supported_actions):
        return GuardResult(False, "invalid_action_allowlist")
    if not _valid_completion_ledger(completed_turns):
        return GuardResult(False, "invalid_completion_ledger")

    run_id = recommendation.get("run_id")
    state_run_id = state.get("run_id")
    turn = recommendation.get("turn")
    state_turn = state.get("turn")
    action = recommendation.get("action_id")
    if (
        type(run_id) is not str
        or not run_id
        or run_id != run_id.strip()
        or type(state_run_id) is not str
        or not state_run_id
        or state_run_id != state_run_id.strip()
        or run_id != state_run_id
    ):
        return GuardResult(False, "run_mismatch")
    if type(turn) is not int or type(state_turn) is not int or turn < 0 or turn != state_turn:
        return GuardResult(False, "stale_or_missing_turn")
    if (
        type(action) is not str
        or not action
        or action != action.strip()
        or action not in supported_actions
    ):
        return GuardResult(False, "unsupported_action")
    if recommendation.get("verified") is not True:
        return GuardResult(False, "unverified_recommendation")
    if state.get("ready") is not True:
        return GuardResult(False, "state_not_ready")
    if (run_id, turn) in completed_turns:
        return GuardResult(False, "turn_already_completed")
    return GuardResult(True, "eligible_for_executor")


__all__ = ["GuardResult", "check_action"]
