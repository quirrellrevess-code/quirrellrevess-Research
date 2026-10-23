#!/usr/bin/env python3
"""PC-first execution boundary. No game input backend is enabled by default.

A future PC adapter must be independently verified before it can be injected.
This controller only permits one pending action per turn and requires a fresh
state observation before acknowledging success. It never retries blindly.
"""
from __future__ import annotations

from dataclasses import dataclass
from typing import Any, Mapping, Protocol

from legendai_action_guard import check_action


class PcActionBackend(Protocol):
    def submit(self, action_id: str) -> bool:
        """Return True only if the adapter accepted a single input attempt."""


@dataclass(frozen=True)
class ExecutionResult:
    status: str
    reason: str


class PcTurnController:
    def __init__(self, *, supported_actions: set[str], backend: PcActionBackend | None = None):
        self.supported_actions = set(supported_actions)
        self.backend = backend
        self.completed_turns: set[tuple[str, int]] = set()
        self.pending: tuple[str, int, str] | None = None
        self.halted = False

    def request(self, recommendation: Mapping[str, Any], state: Mapping[str, Any]) -> ExecutionResult:
        if self.halted:
            return ExecutionResult("blocked", "halted")
        if self.pending is not None:
            return ExecutionResult("blocked", "awaiting_state_confirmation")
        result = check_action(
            recommendation, state,
            supported_actions=self.supported_actions,
            completed_turns=self.completed_turns,
        )
        if not result.allowed:
            return ExecutionResult("blocked", result.reason)
        if self.backend is None:
            return ExecutionResult("blocked", "pc_backend_unverified")
        run_id = recommendation["run_id"]
        turn = recommendation["turn"]
        action_id = recommendation["action_id"]
        # Reserve before invoking external code; exceptions must never trigger retries.
        self.pending = (run_id, turn, action_id)
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
        run_id, turn, _ = self.pending
        if not isinstance(state, Mapping) or state.get("run_id") != run_id:
            self.halted = True
            return ExecutionResult("halted", "run_changed")
        new_turn = state.get("turn")
        if type(new_turn) is not int:
            self.halted = True
            return ExecutionResult("halted", "invalid_observed_turn")
        if state.get("fresh_after_submission") is not True:
            return ExecutionResult("pending", "waiting_for_fresh_observation")
        if new_turn == turn:
            return ExecutionResult("pending", "turn_unchanged")
        if new_turn != turn + 1:
            self.halted = True
            return ExecutionResult("halted", "unexpected_turn_transition")
        self.completed_turns.add((run_id, turn))
        self.pending = None
        return ExecutionResult("confirmed", "turn_advanced")


__all__ = ["PcActionBackend", "PcTurnController", "ExecutionResult"]
