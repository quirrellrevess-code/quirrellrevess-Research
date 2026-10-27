import unittest

from pc_observation_sequence import ObservationSequencer


class ObservationSequencerTests(unittest.TestCase):
    def test_assigns_strictly_increasing_process_local_sequences(self):
        seq = ObservationSequencer()
        self.assertEqual(seq.stamp({"phase": "training"})["observation_seq"], 1)
        self.assertEqual(seq.stamp({"phase": "event"})["observation_seq"], 2)
        self.assertEqual(seq.current, 2)

    def test_overwrites_caller_supplied_sequence(self):
        seq = ObservationSequencer(start=8)
        result = seq.stamp({"observation_seq": 999, "turn": 4})
        self.assertEqual(result["observation_seq"], 9)
        self.assertEqual(result["turn"], 4)

    def test_does_not_mutate_input(self):
        seq = ObservationSequencer()
        source = {"phase": "training"}
        seq.stamp(source)
        self.assertNotIn("observation_seq", source)

    def test_invalid_start_rejected_including_bool(self):
        for value in (-1, True, 1.5, "2"):
            with self.subTest(value=value), self.assertRaises(ValueError):
                ObservationSequencer(start=value)

    def test_non_mapping_rejected(self):
        with self.assertRaises(TypeError):
            ObservationSequencer().stamp(None)


if __name__ == "__main__":
    unittest.main()
