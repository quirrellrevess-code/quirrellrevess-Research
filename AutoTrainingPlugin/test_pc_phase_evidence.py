import unittest
from pc_phase_evidence import classify_phase


class PhaseEvidenceTests(unittest.TestCase):
    def classify(self, matches):
        return classify_phase(matches, allowed_phases={"event", "event_result", "training"})

    def test_single_confident_match(self):
        self.assertEqual(self.classify([{"phase": "event", "confidence": .96}]).phase, "event")

    def test_ambiguous(self):
        self.assertEqual(self.classify([{"phase": "event", "confidence": .96}, {"phase": "training", "confidence": .94}]).reason, "ambiguous_phase")

    def test_low_confidence(self):
        self.assertFalse(self.classify([{"phase": "event", "confidence": .75}]).verified)

    def test_unknown(self):
        self.assertEqual(self.classify([{"phase": "unknown", "confidence": .99}]).phase, "unknown")

    def test_invalid_confidence(self):
        self.assertEqual(self.classify([{"phase": "event", "confidence": True}]).reason, "invalid_confidence")

    def test_duplicate_same_phase(self):
        self.assertTrue(self.classify([{"phase": "event", "confidence": .99}, {"phase": "event", "confidence": .98}]).verified)


if __name__ == "__main__":
    unittest.main()
