import unittest

from pc_action_target_mapping import resolve_target


class MappingTests(unittest.TestCase):
    def setUp(self):
        self.rec = {"run_id": "run1", "turn": 7, "action_id": "train_speed", "verified": True}
        self.state = {"run_id": "run1", "turn": 7, "ready": True, "phase": "training"}
        self.mapping = {("training", "train_speed"): "train_speed_button"}
        self.candidate = {
            "target_id": "train_speed_button", "bbox": [100, 200, 160, 240],
            "verified": True, "confidence": 0.97, "reason": "target_candidate", "executable": False,
        }

    def resolve(self, rec=None, state=None, candidates=None, mapping=None):
        return resolve_target(
            self.rec if rec is None else rec,
            self.state if state is None else state,
            [self.candidate] if candidates is None else candidates,
            mapping=self.mapping if mapping is None else mapping,
        )

    def test_explicit_mapping_is_resolved_but_never_executable(self):
        result = self.resolve()
        self.assertTrue(result["matched"])
        self.assertFalse(result["executable"])
        self.assertEqual(result["target"]["bbox"], [100, 200, 160, 240])

    def test_unverified_recommendation_rejected(self):
        self.assertEqual(self.resolve(rec={**self.rec, "verified": False})["reason"],
                         "unverified_recommendation")

    def test_stale_turn_rejected(self):
        self.assertEqual(self.resolve(state={**self.state, "turn": 8})["reason"],
                         "stale_or_missing_turn")

    def test_not_ready_rejected(self):
        self.assertEqual(self.resolve(state={**self.state, "ready": False})["reason"],
                         "state_not_ready")

    def test_no_mapping_rejected(self):
        self.assertEqual(self.resolve(mapping={})["reason"], "mapping_not_found")

    def test_invalid_mapping_rejected(self):
        self.assertEqual(self.resolve(mapping="not-a-mapping")["reason"], "invalid_mapping")

    def test_missing_target_rejected(self):
        self.assertEqual(self.resolve(candidates=[])["reason"], "target_not_detected")

    def test_ambiguous_duplicate_target_rejected(self):
        self.assertEqual(self.resolve(candidates=[self.candidate, self.candidate])["reason"],
                         "duplicate_target_candidates")

    def test_unverified_target_rejected(self):
        bad = {**self.candidate, "verified": False}
        self.assertEqual(self.resolve(candidates=[bad])["reason"], "target_not_verified")

    def test_preflagged_executable_candidate_rejected(self):
        bad = {**self.candidate, "executable": True}
        self.assertEqual(self.resolve(candidates=[bad])["reason"],
                         "candidate_execution_flag_inconsistent")

    def test_missing_or_nonfinite_confidence_rejected(self):
        for confidence in (None, float("nan"), float("inf"), True, -0.1, 1.1):
            with self.subTest(confidence=confidence):
                bad = {k: v for k, v in self.candidate.items() if k != "confidence"}
                bad["confidence"] = confidence
                self.assertEqual(self.resolve(candidates=[bad])["reason"], "invalid_target_confidence")

    def test_low_confidence_rejected(self):
        bad = {**self.candidate, "confidence": 0.91}
        self.assertEqual(self.resolve(candidates=[bad])["reason"], "target_confidence_below_policy")

    def test_invalid_confidence_policy_rejected(self):
        self.assertEqual(resolve_target(self.rec, self.state, [self.candidate], mapping=self.mapping,
                                        min_confidence=float("nan"))["reason"], "invalid_confidence_policy")

    def test_invalid_bounds_rejected(self):
        bad = {**self.candidate, "bbox": [1, 2, 1, 4]}
        self.assertEqual(self.resolve(candidates=[bad])["reason"], "invalid_target_bounds")

    def test_boolean_turn_is_not_integer(self):
        self.assertEqual(self.resolve(rec={**self.rec, "turn": True})["reason"],
                         "stale_or_missing_turn")


if __name__ == "__main__":
    unittest.main()
