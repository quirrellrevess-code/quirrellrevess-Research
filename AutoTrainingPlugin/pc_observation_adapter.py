#!/usr/bin/env python3
"""Trusted observer-side stamping and submission-boundary tracking.

This adapter only stamps observer-produced mappings. A caller must invoke
mark_submission immediately before its single input attempt and feed each
newly captured state through capture(). It does not capture pixels or submit
game input itself.
"""
from __future__ import annotations

from collections.abc import Mapping
from threading import Lock
from typing import Any

from pc_observation_sequence import ObservationSequencer


class PcObservationAdapter:
    def __init__(self, *, start_sequence: int = 0) -> None:
        self._sequencer = ObservationSequencer(start=start_sequence)
        self._lock = Lock()
        self._submission_sequence: int | None = None

    @property
    def current_sequence(self) -> int:
        return self._sequencer.current

    def capture(self, observation: Mapping[str, Any]) -> dict[str, Any]:
        """Stamp one newly captured state; caller-provided freshness is ignored."""
        stamped = self._sequencer.stamp(observation)
        with self._lock:
            baseline = self._submission_sequence
        stamped["fresh_after_submission"] = (
            baseline is not None and stamped["observation_seq"] > baseline
        )
        return stamped

    def mark_submission(self) -> int:
        """Mark the current sequence as the pre-submit baseline."""
        with self._lock:
            self._submission_sequence = self._sequencer.current
            return self._submission_sequence


__all__ = ["PcObservationAdapter"]
