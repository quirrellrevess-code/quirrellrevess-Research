import unittest

from legendai_action_guard import check_action


class GuardTests(unittest.TestCase):
    def setUp(self):
        self.rec = {"run_id": "run1", "turn": 3, "action_id": "train_speed", "verified": True}
        self.state = {"run_id": "run1", "turn": 3, "ready": True}

    def check(self, rec=None, state=None, done=None):
        return check_action(
            self.rec if rec is None else rec,
            self.state if state is None else state,
            supported_actions={"train_speed"},
            completed_turns=set() if done is None else done,
        )

    def test_valid_action(self):
        self.assertTrue(self.check().allowed)

    def test_unverified_rejected(self):
        self.assertEqual(self.check({**self.rec, "verified": False}).reason, "unverified_recommendation")

    def test_stale_rejected(self):
        self.assertEqual(self.check(state={**self.state, "turn": 4}).reason, "stale_or_missing_turn")

    def test_duplicate_rejected(self):
        self.assertEqual(self.check(done={("run1", 3)}).reason, "turn_already_completed")

    def test_wrong_run_rejected(self):
        self.assertEqual(self.check(state={**self.state, "run_id": "other"}).reason, "run_mismatch")

    def test_unknown_action_rejected(self):
        self.assertEqual(self.check({**self.rec, "action_id": "unknown"}).reason, "unsupported_action")

    def test_bool_turn_rejected(self):
        self.assertEqual(self.check({**self.rec, "turn": True}).reason, "stale_or_missing_turn")


if __name__ == "__main__":
    unittest.main()
