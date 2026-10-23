"""Offline tests for the passive LegendAI recommendation bridge."""
import io
import json
import tempfile
import unittest
from pathlib import Path
from legendai_stdout_bridge import extract_recommendation, parse_recommendation, record_stream


class LegendAiBridgeTests(unittest.TestCase):
    def test_preserves_original_line_and_parses_training(self):
        self.assertEqual(extract_recommendation("  AI建议：速\n"), "  AI建议：速")
        parsed = parse_recommendation("AI建议：速")
        self.assertEqual(parsed["candidate_kind"], "training")
        self.assertEqual(parsed["candidate_value"], "速")
        self.assertIsNone(extract_recommendation("普通日志\n"))

    def test_classifies_named_action_without_inventing_action_id(self):
        parsed = parse_recommendation("AI建议：休息")
        self.assertEqual(parsed["candidate_kind"], "named_action")
        self.assertEqual(parsed["candidate_value"], "休息")

    def test_classifies_selection_as_text_only(self):
        parsed = parse_recommendation("AI建议：选蓝色第2个")
        self.assertEqual(parsed["candidate_kind"], "selection_text")
        self.assertIsNone(parse_recommendation("AI建议："))

    def test_writes_only_recommendations_and_never_marks_executable(self):
        with tempfile.TemporaryDirectory() as directory:
            target = Path(directory) / "out.jsonl"
            count = record_stream(io.StringIO("debug\nAI建议：休息\nAI建议：速\n"), target)
            self.assertEqual(count, 2)
            rows = [json.loads(line) for line in target.read_text(encoding="utf-8").splitlines()]
            self.assertEqual([r["raw"] for r in rows], ["AI建议：休息", "AI建议：速"])
            self.assertTrue(all(r["executable"] is False and r["verified"] is False for r in rows))
            self.assertTrue(all(r["turn"] is None and r["action_id"] is None for r in rows))


if __name__ == "__main__":
    unittest.main()
