import unittest
from pc_action_preview import preview_payload


class PreviewTests(unittest.TestCase):
    def setUp(self):
        self.payload = {
            "recommendation": {"run_id": "run1", "turn": 7, "action_id": "train_speed", "verified": True},
            "state": {"run_id": "run1", "turn": 7, "ready": True, "phase": "training"},
            "candidates": [{"target_id": "train_speed_button", "bbox": [100, 200, 160, 240],
                            "verified": True, "reason": "target_candidate", "confidence": 0.99, "executable": False}],
            "mapping": [{"phase": "training", "action_id": "train_speed",
                         "target_id": "train_speed_button"}]
        }

    def test_preview_is_always_non_executable(self):
        result = preview_payload(self.payload)
        self.assertEqual(result["mode"], "dry_run")
        self.assertTrue(result["matched"])
        self.assertFalse(result["executable"])

    def test_non_object_payload_blocked(self):
        self.assertEqual(preview_payload([])["reason"], "invalid_payload")

    def test_duplicate_mapping_key_blocked(self):
        payload = {**self.payload, "mapping": self.payload["mapping"] * 2}
        self.assertEqual(preview_payload(payload)["reason"], "duplicate_mapping_key")

    def test_malformed_mapping_row_blocked(self):
        payload = {**self.payload, "mapping": [{"phase": "training"}]}
        self.assertEqual(preview_payload(payload)["reason"], "invalid_mapping_row")

    def test_missing_mapping_blocked(self):
        payload = {**self.payload, "mapping": None}
        self.assertEqual(preview_payload(payload)["reason"], "invalid_mapping")

    def test_unverified_recommendation_remains_blocked(self):
        payload = {**self.payload, "recommendation": {**self.payload["recommendation"], "verified": False}}
        result = preview_payload(payload)
        self.assertFalse(result["matched"])
        self.assertFalse(result["executable"])


if __name__ == "__main__":
    unittest.main()
