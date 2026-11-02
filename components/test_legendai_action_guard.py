import unittest

from legendai_action_guard import check_action


class GuardTests(unittest.TestCase):
    def setUp(self):
        self.rec = {"run_id": "run1", "turn": 3, "action_id": "train_speed", "verified": True}
        self.state = {"run_id": "run1", "turn": 3, "ready": True}

    def check(self, rec=None, state=None, done=None, actions=None):
        return check_action(
            self.rec if rec is None else rec,
            self.state if state is None else state,
            supported_actions={"train_speed"} if actions is None else actions,
            completed_turns=set() if done is None else done,
        )

    def test_valid_action(self):
        self.assertTrue(self.check().allowed)

    def test_frozenset_allowlist_and_ledger_are_supported(self):
        result = self.check(actions=frozenset({"train_speed"}), done=frozenset())
        self.assertTrue(result.allowed)

    def test_unverified_rejected(self):
        self.assertEqual(self.check({**self.rec, "verified": False}).reason, "unverified_recommendation")

    def test_stale_rejected(self):
        self.assertEqual(self.check(state={**self.state, "turn": 4}).reason, "stale_or_missing_turn")

    def test_duplicate_rejected(self):
        self.assertEqual(self.check(done={("run1", 3)}).reason, "turn_already_completed")

    def test_wrong_run_rejected(self):
        self.assertEqual(self.check(state={**self.state, "run_id": "other"}).reason, "run_mismatch")

    def test_state_run_id_must_be_a_string(self):
        self.assertEqual(self.check(state={**self.state, "run_id": 1}).reason, "run_mismatch")

    def test_run_id_must_not_have_surrounding_whitespace(self):
        self.assertEqual(self.check({**self.rec, "run_id": " run1"}).reason, "run_mismatch")

    def test_unknown_action_rejected(self):
        self.assertEqual(self.check({**self.rec, "action_id": "unknown"}).reason, "unsupported_action")

    def test_action_id_must_not_have_surrounding_whitespace(self):
        self.assertEqual(self.check({**self.rec, "action_id": " train_speed"}).reason, "unsupported_action")

    def test_bool_turn_rejected(self):
        self.assertEqual(self.check({**self.rec, "turn": True}).reason, "stale_or_missing_turn")

    def test_negative_turn_rejected(self):
        self.assertEqual(self.check({**self.rec, "turn": -1}).reason, "stale_or_missing_turn")

    def test_state_not_ready_rejected(self):
        self.assertEqual(self.check(state={**self.state, "ready": 1}).reason, "state_not_ready")

    def test_non_set_action_allowlist_rejected(self):
        self.assertEqual(self.check(actions=["train_speed"]).reason, "invalid_action_allowlist")

    def test_non_string_action_allowlist_member_rejected(self):
        self.assertEqual(self.check(actions={"train_speed", 1}).reason, "invalid_action_allowlist")

    def test_non_set_completion_ledger_rejected(self):
        self.assertEqual(self.check(done=[("run1", 3)]).reason, "invalid_completion_ledger")

    def test_completion_ledger_rejects_boolean_turn(self):
        self.assertEqual(self.check(done={("run1", True)}).reason, "invalid_completion_ledger")

    def test_completion_ledger_rejects_malformed_entry(self):
        self.assertEqual(self.check(done={("run1", 3, "extra")}).reason, "invalid_completion_ledger")


if __name__ == "__main__":
    unittest.main()
