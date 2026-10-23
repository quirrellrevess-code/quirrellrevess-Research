import unittest

from pc_observation_adapter import PcObservationAdapter


class PcObservationAdapterTests(unittest.TestCase):
    def test_freshness_is_derived_from_submission_boundary(self):
        adapter = PcObservationAdapter()
        before = adapter.capture({"run_id": "r1", "turn": 4, "fresh_after_submission": True})
        self.assertEqual(before["observation_seq"], 1)
        self.assertFalse(before["fresh_after_submission"])

        baseline = adapter.mark_submission()
        self.assertEqual(baseline, 1)
        after = adapter.capture({"run_id": "r1", "turn": 4, "fresh_after_submission": False})
        self.assertEqual(after["observation_seq"], 2)
        self.assertTrue(after["fresh_after_submission"])

    def test_each_capture_gets_unique_sequence(self):
        adapter = PcObservationAdapter(start_sequence=10)
        a = adapter.capture({"turn": 1})
        b = adapter.capture({"turn": 1})
        self.assertEqual((a["observation_seq"], b["observation_seq"]), (11, 12))

    def test_caller_cannot_override_sequence_or_freshness(self):
        adapter = PcObservationAdapter()
        adapter.mark_submission()
        state = adapter.capture({"observation_seq": 999, "fresh_after_submission": True})
        self.assertEqual(state["observation_seq"], 1)
        self.assertTrue(state["fresh_after_submission"])

    def test_input_mapping_is_not_mutated(self):
        adapter = PcObservationAdapter()
        source = {"turn": 4}
        adapter.capture(source)
        self.assertEqual(source, {"turn": 4})

    def test_invalid_start_rejected(self):
        with self.assertRaises(ValueError):
            PcObservationAdapter(start_sequence=True)


if __name__ == "__main__":
    unittest.main()
