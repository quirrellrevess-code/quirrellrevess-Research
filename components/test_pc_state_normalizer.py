import unittest

from pc_state_normalizer import normalize_observation


class PcStateNormalizerTests(unittest.TestCase):
    def test_matching_sources_remain_non_executable(self):
        result = normalize_observation(
            {"run_id": "r1", "turn": 4, "phase": "training", "ready": True},
            {"phase": "training", "verified": True, "ready": True},
        )
        self.assertEqual((result["run_id"], result["turn"], result["phase"]), ("r1", 4, "training"))
        self.assertEqual(result["reason"], "temporal_alignment_unverified")
        self.assertFalse(result["ready"])
        self.assertFalse(result["verified"])
        self.assertFalse(result["executable"])

    def test_phase_conflict_fails_closed(self):
        result = normalize_observation(
            {"run_id": "r1", "turn": 4, "phase": "event"},
            {"phase": "training", "verified": True},
        )
        self.assertEqual(result["reason"], "phase_source_conflict")
        self.assertFalse(result["ready"])

    def test_unverified_phase_fails_closed(self):
        result = normalize_observation(
            {"run_id": "r1", "turn": 4},
            {"phase": "training", "verified": False},
        )
        self.assertEqual(result["reason"], "unverified_pc_phase")

    def test_invalid_turn_and_missing_source_fail_closed(self):
        for turn in (True, -1, "4"):
            with self.subTest(turn=turn):
                result = normalize_observation(
                    {"run_id": "r1", "turn": turn},
                    {"phase": "training", "verified": True},
                )
                self.assertEqual(result["reason"], "invalid_ura_identity")
        self.assertEqual(normalize_observation(None, {})["reason"], "missing_or_invalid_evidence")

    def test_injected_ready_and_executable_flags_are_ignored(self):
        result = normalize_observation(
            {"run_id": "r1", "turn": 4, "ready": True, "verified": True, "executable": True},
            {"phase": "training", "verified": True, "executable": True},
        )
        self.assertFalse(result["ready"])
        self.assertFalse(result["executable"])


if __name__ == "__main__":
    unittest.main()
