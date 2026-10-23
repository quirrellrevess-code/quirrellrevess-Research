import json
import subprocess
import sys
import tempfile
import unittest
from pathlib import Path

from observation_replay_report import build_report


SCRIPT = Path(__file__).with_name("observation_replay_report.py")


class ObservationReplayReportTests(unittest.TestCase):
    def write_jsonl(self, path, rows):
        path.write_text("".join(json.dumps(row) + "\n" for row in rows), encoding="utf-8")

    def setUp(self):
        self.temp = tempfile.TemporaryDirectory()
        self.root = Path(self.temp.name)
        self.observations = self.root / "observations.jsonl"
        self.requests = self.root / "requests.jsonl"
        self.recommendations = self.root / "recommendations.jsonl"
        self.write_jsonl(self.observations, [
            {"captured_at_utc": "2026-01-01T00:00:00Z", "turn": 4, "command_count": 2, "commands": []},
            {"captured_at_utc": "2026-01-01T00:01:00Z", "turn": 5, "command_count": 1, "commands": []},
        ])
        self.write_jsonl(self.requests, [
            {"captured_at_utc": "2026-01-01T00:00:30Z", "current_turn": 4, "command_type": 1, "command_id": 2},
        ])
        self.write_jsonl(self.recommendations, [
            {"captured_at_utc": "2026-01-01T00:00:20Z", "source": "legendai_stdout",
             "recommendation_text": "速", "turn": None, "verified": False, "executable": False},
            {"captured_at_utc": "2026-01-01T00:01:20Z", "source": "legendai_stdout",
             "recommendation_text": "休息", "turn": 5, "verified": False, "executable": False},
        ])

    def tearDown(self):
        self.temp.cleanup()

    def test_reports_turn_overlap_without_claiming_causality(self):
        report = build_report({
            "observations": self.observations,
            "requests": self.requests,
            "recommendations": self.recommendations,
        })
        self.assertEqual(report["mode"], "read_only_replay_report")
        self.assertFalse(report["executable"])
        self.assertEqual(report["turn_overlap"]["observation_request_shared_turns"], [4])
        self.assertEqual(report["turn_overlap"]["observation_recommendation_shared_turns"], [5])
        self.assertEqual(report["streams"]["recommendations"]["records_without_valid_turn"], 1)
        self.assertIn("does not establish causality", report["limitations"][0])

    def test_accepts_actual_csharp_sink_field_names(self):
        self.write_jsonl(self.recommendations, [
            {"timestamp_utc": "2026-01-01T00:00:20Z", "source": "AIRedirector.Legend.stdout",
             "single_mode_chara_id": 123, "turn": 4, "recommendation": "训练速度",
             "category": "training", "verified": False, "executable": False},
        ])
        report = build_report({
            "observations": self.observations,
            "requests": self.requests,
            "recommendations": self.recommendations,
        })
        recommendation_report = report["streams"]["recommendations"]
        self.assertEqual(recommendation_report["missing_required_fields"], {})
        self.assertEqual(recommendation_report["turns"], [4])
        self.assertEqual(report["turn_overlap"]["observation_recommendation_shared_turns"], [4])
        timing = report["same_turn_timing_comparisons"]
        self.assertEqual(len(timing), 1)
        self.assertEqual(timing[0]["request_minus_recommendation_seconds"], 10.0)
        self.assertEqual(timing[0]["timestamp_order"], "recommendation_timestamp_before_request")
        self.assertFalse(timing[0]["causal_link_verified"])

    def test_invalid_json_is_reported_and_cli_exits_one(self):
        self.observations.write_text('{"turn":4}\n{broken\n', encoding="utf-8")
        result = subprocess.run([
            sys.executable, str(SCRIPT),
            "--observations", str(self.observations),
            "--requests", str(self.requests),
            "--recommendations", str(self.recommendations),
        ], text=True, capture_output=True, check=False)
        self.assertEqual(result.returncode, 1)
        report = json.loads(result.stdout)
        self.assertEqual(report["streams"]["observations"]["parse_error_count"], 1)
        self.assertTrue(report["streams"]["observations"]["missing_required_fields"])

    def test_missing_file_returns_structured_error_code_two(self):
        result = subprocess.run([
            sys.executable, str(SCRIPT),
            "--observations", str(self.root / "missing.jsonl"),
            "--requests", str(self.requests),
            "--recommendations", str(self.recommendations),
        ], text=True, capture_output=True, check=False)
        self.assertEqual(result.returncode, 2)
        self.assertFalse(json.loads(result.stdout)["executable"])


if __name__ == "__main__":
    unittest.main()
