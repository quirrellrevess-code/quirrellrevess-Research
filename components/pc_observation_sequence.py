#!/usr/bin/env python3
"""Process-local monotonic sequence issuer for trusted observation adapters.

Instantiate one sequencer inside the long-lived observer process. Do not accept
sequence numbers from recommendations, JSON payloads, or caller metadata.
This utility assigns sequence numbers; it does not itself capture or verify pixels.
"""
from __future__ import annotations

from collections.abc import Mapping
from threading import Lock
from typing import Any


class ObservationSequencer:
    def __init__(self, *, start: int = 0) -> None:
        if type(start) is not int or start < 0:
            raise ValueError("start must be a non-negative integer")
        self._sequence = start
        self._lock = Lock()

    @property
    def current(self) -> int:
        with self._lock:
            return self._sequence

    def stamp(self, observation: Mapping[str, Any]) -> dict[str, Any]:
        """Copy an observer-produced state and overwrite any supplied sequence."""
        if not isinstance(observation, Mapping):
            raise TypeError("observation must be a mapping")
        with self._lock:
            self._sequence += 1
            sequence = self._sequence
        result = dict(observation)
        # Sequence is always assigned here, never trusted from the payload.
        result["observation_seq"] = sequence
        return result


__all__ = ["ObservationSequencer"]
