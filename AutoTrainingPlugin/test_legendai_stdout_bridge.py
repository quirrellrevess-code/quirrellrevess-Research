"""Offline tests for the passive LegendAI recommendation bridge."""
import io
import json
import tempfile
import unittest
from pathlib import Path
from legendai_stdout_bridge import extract_recommendation, record_stream


class LegendAiBridgeTests(unittest.TestCase):
    def test_preserves_original_line(self):
        self.assertEqual(extract_recommendation("  AI建议：训练速度\n"), "  AI建议：训练速度")
        self.assertIsNone(extract_recommendation("普通日志\n"))

    def test_writes_only_recommendations_and_never_marks_executable(self):
        with tempfile.TemporaryDirectory() as directory:
            target = Path(directory) / "out.jsonl"
            count = record_stream(io.StringIO("debug\nAI建议：休息\nAI建议：训练\n"), target)
            self.assertEqual(count, 2)
            rows = [json.loads(line) for line in target.read_text(encoding="utf-8").splitlines()]
            self.assertEqual([r["raw"] for r in rows], ["AI建议：休息", "AI建议：训练"])
            self.assertTrue(all(r["executable"] is False and r["turn"] is None for r in rows))


if __name__ == "__main__":
    unittest.main()
