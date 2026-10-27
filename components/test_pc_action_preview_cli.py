import json
import subprocess
import sys
import tempfile
import unittest
from pathlib import Path

from pc_action_preview import preview_payload


SCRIPT = Path(__file__).with_name("pc_action_preview.py")


class PreviewCliTests(unittest.TestCase):
    def setUp(self):
        self.payload = {
            "recommendation": {"run_id": "run1", "turn": 7, "action_id": "train_speed", "verified": True},
            "state": {"run_id": "run1", "turn": 7, "ready": True, "phase": "training"},
            "candidates": [{"target_id": "train_speed_button", "bbox": [100, 200, 160, 240],
                            "verified": True, "reason": "target_candidate", "confidence": 0.99, "executable": False}],
            "mapping": [{"phase": "training", "action_id": "train_speed",
                         "target_id": "train_speed_button"}]
        }

    def run_cli(self, args=(), stdin_text=None):
        return subprocess.run(
            [sys.executable, str(SCRIPT), *args],
            input=stdin_text, text=True, capture_output=True, check=False,
        )

    def test_stdin_success_outputs_non_executable_json(self):
        result = self.run_cli(stdin_text=json.dumps(self.payload))
        self.assertEqual(result.returncode, 0, result.stderr)
        parsed = json.loads(result.stdout)
        self.assertTrue(parsed["matched"])
        self.assertFalse(parsed["executable"])
        self.assertEqual(parsed["mode"], "dry_run")

    def test_file_input_success(self):
        with tempfile.TemporaryDirectory() as directory:
            path = Path(directory) / "preview.json"
            path.write_text(json.dumps(self.payload), encoding="utf-8")
            result = self.run_cli((str(path),))
        self.assertEqual(result.returncode, 0, result.stderr)
        self.assertFalse(json.loads(result.stdout)["executable"])

    def test_invalid_json_returns_structured_failure(self):
        result = self.run_cli(stdin_text="{invalid")
        self.assertEqual(result.returncode, 2)
        parsed = json.loads(result.stdout)
        self.assertFalse(parsed["matched"])
        self.assertFalse(parsed["executable"])
        self.assertEqual(parsed["reason"], "input_read_failed")

    def test_unmatched_payload_returns_nonzero_and_json(self):
        payload = {**self.payload, "mapping": []}
        result = self.run_cli(stdin_text=json.dumps(payload))
        self.assertEqual(result.returncode, 1)
        parsed = json.loads(result.stdout)
        self.assertFalse(parsed["matched"])
        self.assertFalse(parsed["executable"])


if __name__ == "__main__":
    unittest.main()
