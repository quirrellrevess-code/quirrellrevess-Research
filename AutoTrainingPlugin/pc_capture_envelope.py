#!/usr/bin/env python3
"""Read-only observation envelope issued by one long-lived capture process.

The caller must perform real capture before calling record_capture(). The
timestamp is sampled locally, never accepted from a state payload. No game
input is performed or authorized by this module.
"""
from __future__ import annotations

from collections.abc import Callable, Mapping
from threading import Lock
from time import monotonic_ns
from typing import Any

from pc_observation_adapter import PcObservationAdapter


class PcCaptureEnvelope:
    def __init__(self, *, clock_ns: Callable[[], int] = monotonic_ns) -> None:
        self._adapter = PcObservationAdapter()
        self._clock_ns = clock_ns
        self._lock = Lock()
        self._last_capture_ns: int | None = None

    def record_capture(self, state: Mapping[str, Any]) -> dict[str, Any]:
        """Record a completed capture; do not pass untrusted AI-produced state."""
        if not isinstance(state, Mapping):
            raise TypeError("state must be a mapping")
        with self._lock:
            timestamp = self._clock_ns()
            if type(timestamp) is not int or timestamp < 0:
                raise ValueError("invalid trusted clock reading")
            if self._last_capture_ns is not None and timestamp < self._last_capture_ns:
                raise ValueError("trusted clock moved backwards")
            stamped = self._adapter.capture(state)
            self._last_capture_ns = timestamp
            stamped["capture_monotonic_ns"] = timestamp
            stamped["capture_source"] = "local_observer_unverified"
            stamped["ready"] = False
            stamped["executable"] = False
            return stamped

    def mark_submission(self) -> int:
        """Mark a boundary for offline testing, not permission to submit input."""
        with self._lock:
            return self._adapter.mark_submission()


__all__ = ["PcCaptureEnvelope"]
