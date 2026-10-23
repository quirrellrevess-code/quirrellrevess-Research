#!/usr/bin/env python3
"""Fail-closed PC action boundary with explicit postconditions.

No real input backend is supplied. Freshness must be established by the
observation adapter, never inferred from a timestamp supplied by an AI.
"""
from __future__ import annotations

from dataclasses import dataclass, replace
from typing import Any, Mapping, Protocol

from legendai_action_guard import check_action


class PcActionBackend(Protocol):
    def submit(self, action_id: str) -> bool:
        """True means one input attempt was accepted, not game success."""


@dataclass(frozen=True)
class ExecutionResult:
    status: str
    reason: str


@dataclass(frozen=True)
class PendingAction:
    run_id: str
    turn: int
    action_id: str
    postcondition: str
    expected_phase: str | None
    original_phase: str | None
    observation_seq: int
    last_observation_seq: int


class PcTurnController:
    def __init__(self, *, supported_actions: set[str], backend: PcActionBackend | None = None):
        self.supported_actions = set(supported_actions)
        self.backend = backend
        self.completed_turns: set[tuple[str, int]] = set()
        self.completed_actions: set[tuple[str, int, str, str]] = set()
        self.pending: PendingAction | None = None
        self.halted = False

    def request(self, recommendation: Mapping[str, Any], state: Mapping[str, Any]) -> ExecutionResult:
        if self.halted:
            return ExecutionResult("blocked", "halted")
        if self.pending is not None:
            return ExecutionResult("blocked", "awaiting_state_confirmation")
        if not isinstance(state, Mapping):
            return ExecutionResult("blocked", "invalid_state")
        observation_seq = state.get("observation_seq")
        if type(observation_seq) is not int or observation_seq < 0:
            return ExecutionResult("blocked", "invalid_observation_sequence")
        result = check_action(
            recommendation, state,
            supported_actions=self.supported_actions,
            completed_turns=self.completed_turns,
        )
        if not result.allowed:
            return ExecutionResult("blocked", result.reason)
        mode = recommendation.get("postcondition", "turn_advance")
        if mode not in ("turn_advance", "phase_change"):
            return ExecutionResult("blocked", "unsupported_postcondition")
        expected = recommendation.get("expected_phase")
        original = state.get("phase")
        if mode == "phase_change":
            if not isinstance(expected, str) or not expected or not isinstance(original, str) or not original or expected == original:
                return ExecutionResult("blocked", "invalid_phase_postcondition")
        else:
            expected, original = None, None
        if self.backend is None:
            return ExecutionResult("blocked", "pc_backend_unverified")
        run_id, turn, action_id = (recommendation[k] for k in ("run_id", "turn", "action_id"))
        key = (run_id, turn, action_id, original or "")
        if key in self.completed_actions:
            return ExecutionResult("blocked", "action_already_completed")
        self.pending = PendingAction(run_id, turn, action_id, mode, expected, original, observation_seq, observation_seq)
        try:
            accepted = self.backend.submit(action_id)
        except Exception:
            self.halted = True
            return ExecutionResult("halted", "backend_exception")
        if accepted is not True:
            self.halted = True
            return ExecutionResult("halted", "submission_not_confirmed")
        return ExecutionResult("pending", "awaiting_fresh_state")

    def observe(self, state: Mapping[str, Any]) -> ExecutionResult:
        if self.halted:
            return ExecutionResult("blocked", "halted")
        if self.pending is None:
            return ExecutionResult("blocked", "no_pending_action")
        pending = self.pending
        if not isinstance(state, Mapping) or state.get("run_id") != pending.run_id:
            self.halted = True
            return ExecutionResult("halted", "run_changed")
        new_turn = state.get("turn")
        if type(new_turn) is not int:
            self.halted = True
            return ExecutionResult("halted", "invalid_observed_turn")
        observed_seq = state.get("observation_seq")
        if type(observed_seq) is not int or observed_seq < 0:
            self.halted = True
            return ExecutionResult("halted", "invalid_observation_sequence")
        # Require a strictly newer observer sample each time. Comparing only
        # with the pre-submit sequence would allow the same post-submit sequence
        # to be replayed with different state fields and falsely confirm success.
        if observed_seq <= pending.last_observation_seq:
            return ExecutionResult("pending", "waiting_for_newer_observation")
        if state.get("fresh_after_submission") is not True:
            return ExecutionResult("pending", "waiting_for_fresh_observation")
        pending = replace(pending, last_observation_seq=observed_seq)
        self.pending = pending
        if pending.postcondition == "turn_advance":
            if new_turn == pending.turn:
                return ExecutionResult("pending", "turn_unchanged")
            if new_turn != pending.turn + 1:
                self.halted = True
                return ExecutionResult("halted", "unexpected_turn_transition")
            self.completed_turns.add((pending.run_id, pending.turn))
            reason = "turn_advanced"
        else:
            if new_turn != pending.turn:
                self.halted = True
                return ExecutionResult("halted", "unexpected_turn_transition")
            phase = state.get("phase")
            if not isinstance(phase, str) or not phase:
                self.halted = True
                return ExecutionResult("halted", "invalid_observed_phase")
            if phase == pending.original_phase:
                return ExecutionResult("pending", "phase_unchanged")
            if phase != pending.expected_phase:
                self.halted = True
                return ExecutionResult("halted", "unexpected_phase_transition")
            reason = "phase_changed"
        self.completed_actions.add((pending.run_id, pending.turn, pending.action_id, pending.original_phase or ""))
        self.pending = None
        return ExecutionResult("confirmed", reason)


__all__ = ["PcActionBackend", "PcTurnController", "ExecutionResult", "PendingAction"]
