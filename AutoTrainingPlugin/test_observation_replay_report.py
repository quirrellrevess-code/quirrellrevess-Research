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
             "recommendation_text": "速", "turn": None, "turn_association_status": "unavailable_in_stdout_only",
             "verified": False, "executable": False},
            {"captured_at_utc": "2026-01-01T00:01:20Z", "source": "legendai_stdout",
             "recommendation_text": "休息", "turn": 5, "turn_association_status": "unavailable_in_stdout_only",
             "verified": False, "executable": False},
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
        self.assertEqual(report["turn_coverage"]["observations_with_request_turn"], {
            "shared_turn_count": 1, "denominator_turn_count": 2, "coverage_ratio": 0.5,
        })
        self.assertEqual(report["turn_coverage"]["requests_with_observation_turn"]["coverage_ratio"], 1.0)
        self.assertEqual(report["turn_coverage"]["recommendations_with_observation_turn"]["coverage_ratio"], 1.0)
        self.assertEqual(report["streams"]["recommendations"]["records_without_valid_turn"], 1)
        self.assertEqual(report["streams"]["recommendations"]["turn_quality"]["null_count"], 1)
        self.assertEqual(report["streams"]["recommendations"]["turn_association_status"], {
            "missing_field_count": 0,
            "null_count": 0,
            "invalid_type_or_empty_count": 0,
            "context_mismatch_count": 1,
            "values": {"unavailable_in_stdout_only": 2},
        })
        self.assertEqual(report["timing_comparison_coverage"]["recommendations_without_valid_turn_excluded"], 1)
        self.assertEqual(report["timing_comparison_coverage"]["same_turn_pairs_compared"], 0)
        self.assertIn("establish causality", report["limitations"][0])

    def test_accepts_actual_csharp_sink_field_names(self):
        self.write_jsonl(self.recommendations, [
            {"timestamp_utc": "2026-01-01T00:00:20Z", "source": "AIRedirector.Legend.stdout",
             "single_mode_chara_id": 123, "turn": 4,
             "turn_association_status": "target_context_available_unverified",
             "recommendation": "训练速度", "category": "training", "verified": False, "executable": False},
        ])
        report = build_report({
            "observations": self.observations,
            "requests": self.requests,
            "recommendations": self.recommendations,
        })
        recommendation_report = report["streams"]["recommendations"]
        self.assertEqual(recommendation_report["missing_required_fields"], {})
        self.assertEqual(recommendation_report["turns"], [4])
        self.assertEqual(recommendation_report["turn_association_status"], {
            "missing_field_count": 0,
            "null_count": 0,
            "invalid_type_or_empty_count": 0,
            "context_mismatch_count": 0,
            "values": {"target_context_available_unverified": 1},
        })
        self.assertEqual(report["turn_overlap"]["observation_recommendation_shared_turns"], [4])
        timing = report["same_turn_timing_comparisons"]
        self.assertEqual(len(timing), 1)
        self.assertEqual(timing[0]["request_minus_recommendation_seconds"], 10.0)
        self.assertEqual(timing[0]["timestamp_order"], "recommendation_timestamp_before_request")
        self.assertFalse(timing[0]["causal_link_verified"])
        self.assertFalse(timing[0]["same_state_verified"])
        self.assertEqual(timing[0]["timestamp_proximity_2s"], "outside_2s_diagnostic_window")
        self.assertEqual(report["timing_comparison_coverage"]["same_turn_pairs_compared"], 1)
        self.assertEqual(report["streams"]["recommendations"]["turn_quality"]["null_count"], 0)


    def test_timestamp_proximity_is_diagnostic_not_state_proof(self):
        recommendations = [{
            "captured_at_utc": "2026-01-01T00:00:00Z", "turn": 4,
            "recommendation_text": "速",
        }]
        requests = [{
            "captured_at_utc": "2026-01-01T00:00:01Z", "current_turn": 4,
            "command_type": 1, "command_id": 2,
        }]
        comparison = __import__("observation_replay_report").compare_recommendations_and_requests(
            recommendations, requests
        )[0]
        self.assertEqual(comparison["timestamp_proximity_2s"], "within_2s_diagnostic_window")
        self.assertFalse(comparison["same_state_verified"])
        self.assertFalse(comparison["causal_link_verified"])

    def test_context_status_inconsistency_is_reported(self):
        self.write_jsonl(self.recommendations, [
            {"captured_at_utc": "2026-01-01T00:00:20Z", "source": "test",
             "recommendation_text": "休息", "turn": None, "single_mode_chara_id": 123,
             "turn_association_status": "target_context_available_unverified",
             "verified": False, "executable": False},
        ])
        report = build_report({
            "observations": self.observations,
            "requests": self.requests,
            "recommendations": self.recommendations,
        })
        status = report["streams"]["recommendations"]["turn_association_status"]
        self.assertEqual(status["context_mismatch_count"], 1)
        self.assertFalse(report["executable"])

    def test_unknown_association_status_is_invalid(self):
        self.write_jsonl(self.recommendations, [
            {"captured_at_utc": "2026-01-01T00:00:20Z", "source": "test",
             "recommendation_text": "休息", "turn": None, "single_mode_chara_id": None,
             "turn_association_status": "verified_by_magic", "verified": False, "executable": False},
        ])
        report = build_report({
            "observations": self.observations,
            "requests": self.requests,
            "recommendations": self.recommendations,
        })
        status = report["streams"]["recommendations"]["turn_association_status"]
        self.assertEqual(status["invalid_type_or_empty_count"], 1)
        self.assertEqual(status["values"], {})
        self.assertFalse(report["executable"])

    def test_reports_timestamp_order_duplicates_and_timezone_quality(self):
        self.write_jsonl(self.observations, [
            {"captured_at_utc": "2026-01-01T00:00:10Z", "turn": 1, "command_count": 0, "commands": []},
            {"captured_at_utc": "2026-01-01T01:00:10+01:00", "turn": 2, "command_count": 0, "commands": []},
            {"captured_at_utc": "2026-01-01T00:00:05Z", "turn": 3, "command_count": 0, "commands": []},
            {"captured_at_utc": "2026-01-01T00:00:20", "turn": 4, "command_count": 0, "commands": []},
            {"captured_at_utc": None, "turn": 5, "command_count": 0, "commands": []},
        ])
        report = build_report({
            "observations": self.observations,
            "requests": self.requests,
            "recommendations": self.recommendations,
        })
        quality = report["streams"]["observations"]["timestamp_quality"]
        self.assertEqual(quality, {
            "missing_or_null_count": 1,
            "invalid_format_or_timezone_count": 1,
            "out_of_order_count": 1,
            "duplicate_instant_count": 1,
        })
        self.assertEqual(report["streams"]["observations"]["invalid_or_unavailable_timestamp_count"], 2)

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
