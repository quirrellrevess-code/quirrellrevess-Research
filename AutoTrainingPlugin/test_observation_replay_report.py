import json
import subprocess
import sys
import tempfile
import unittest
from pathlib import Path

from observation_replay_report import build_report, compare_shared_identity, audit_request_command_membership


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


    def test_data_quality_summary_aggregates_anomalies_without_claiming_verification(self):
        self.write_jsonl(self.observations, [
            {"captured_at_utc": None, "turn": 4, "command_count": 0, "commands": []},
            {"captured_at_utc": "bad-time", "turn": 4, "command_count": 0, "commands": []},
        ])
        self.write_jsonl(self.requests, [
            {"captured_at_utc": "2026-01-01T00:00:30Z", "current_turn": 4,
             "command_type": 1, "command_id": 99},
        ])
        self.write_jsonl(self.recommendations, [
            {"captured_at_utc": "2026-01-01T00:00:20Z", "source": "test",
             "recommendation_text": "训练", "turn": 4, "turn_association_status": "target_context_available_unverified",
             "verified": False, "executable": False, "scenario_id": 1},
        ])
        report = build_report({
            "observations": self.observations,
            "requests": self.requests,
            "recommendations": self.recommendations,
        })
        summary = report["data_quality_summary"]
        self.assertEqual(summary["status"], "audit_warnings")
        self.assertEqual(summary["anomaly_counts"]["timestamps_missing_or_invalid"], 2)
        self.assertEqual(summary["anomaly_counts"]["request_commands_absent_from_snapshots"], 1)
        self.assertFalse(summary["same_state_verified"])
        self.assertFalse(summary["causal_link_verified"])
        self.assertFalse(summary["executable"])

    def test_data_quality_summary_anomaly_samples_identify_source_records(self):
        self.write_jsonl(self.observations, [
            {"captured_at_utc": "bad-time", "turn": 7, "command_count": 0, "commands": []},
        ])
        self.write_jsonl(self.requests, [
            {"captured_at_utc": "2026-01-01T00:00:30Z", "current_turn": 7,
             "command_type": 1, "command_id": 99},
        ])
        self.write_jsonl(self.recommendations, [
            {"captured_at_utc": "2026-01-01T00:00:20Z", "source": "test",
             "recommendation_text": "训练", "turn": None, "turn_association_status": "unavailable_in_stdout_only",
             "verified": False, "executable": False},
        ])
        report = build_report({
            "observations": self.observations,
            "requests": self.requests,
            "recommendations": self.recommendations,
        })
        summary = report["data_quality_summary"]
        sample_keys = {(row["stream"], row["record_index"], row["issue"])
                       for row in summary["record_anomaly_samples"]}
        self.assertIn(("observations", 0, "timestamp_invalid"), sample_keys)
        self.assertIn(("recommendations", 0, "invalid_or_missing_turn"), sample_keys)
        self.assertTrue(any(
            row.get("request_index") == 0 and row.get("issue") == "request_command_membership"
            for row in summary["request_command_anomaly_samples"]
        ))
        self.assertFalse(summary["executable"])

    def test_timestamp_order_and_duplicate_counts_have_record_samples(self):
        self.write_jsonl(self.observations, [
            {"captured_at_utc": "2026-01-01T00:00:02Z", "turn": 1, "command_count": 0, "commands": []},
            {"captured_at_utc": "2026-01-01T00:00:01Z", "turn": 1, "command_count": 0, "commands": []},
            {"captured_at_utc": "2026-01-01T00:00:01Z", "turn": 1, "command_count": 0, "commands": []},
        ])
        self.write_jsonl(self.requests, [])
        self.write_jsonl(self.recommendations, [])
        report = build_report({
            "observations": self.observations,
            "requests": self.requests,
            "recommendations": self.recommendations,
        })
        samples = report["data_quality_summary"]["record_anomaly_samples"]
        self.assertTrue(any(row["stream"] == "observations" and row["record_index"] == 1
                            and row["issue"] == "timestamp_out_of_order" for row in samples))
        self.assertTrue(any(row["stream"] == "observations" and row["record_index"] == 2
                            and row["issue"] == "duplicate_timestamp_instant" for row in samples))

    def test_sample_coverage_flags_truncated_record_identity_and_request_samples(self):
        observations = [
            {"captured_at_utc": "2026-01-01T00:00:01Z", "turn": 1,
             "command_count": 0, "commands": []}
            for _ in range(55)
        ]
        requests = [
            {"captured_at_utc": f"2026-01-01T00:00:{i % 60:02d}Z", "current_turn": 1,
             "command_type": 1, "command_id": 999}
            for i in range(25)
        ]
        recommendations = [
            {"captured_at_utc": f"2026-01-01T00:01:{i % 60:02d}Z", "source": "test",
             "recommendation_text": "训练", "turn": 1, "single_mode_chara_id": i + 100,
             "turn_association_status": "target_context_available_unverified",
             "verified": False, "executable": False}
            for i in range(25)
        ]
        self.write_jsonl(self.observations, observations)
        self.write_jsonl(self.requests, requests)
        self.write_jsonl(self.recommendations, recommendations)
        report = build_report({
            "observations": self.observations,
            "requests": self.requests,
            "recommendations": self.recommendations,
        })
        coverage = report["data_quality_summary"]["sample_coverage"]
        self.assertTrue(coverage["record_samples_truncated"])
        self.assertTrue(coverage["identity_mismatch_samples_truncated"])
        self.assertTrue(coverage["request_command_samples_truncated"])
        self.assertEqual(50, len(report["data_quality_summary"]["record_anomaly_samples"]))
        self.assertEqual(20, len(report["data_quality_summary"]["identity_mismatch_samples"]))
        self.assertEqual(20, len(report["data_quality_summary"]["request_command_anomaly_samples"]))

    def test_data_quality_summary_empty_inputs_are_insufficient(self):
        for path in (self.observations, self.requests, self.recommendations):
            path.write_text("", encoding="utf-8")
        report = build_report({
            "observations": self.observations,
            "requests": self.requests,
            "recommendations": self.recommendations,
        })
        self.assertEqual(report["data_quality_summary"]["status"], "insufficient_data")
        self.assertFalse(report["data_quality_summary"]["executable"])

    def test_request_command_membership_is_consistency_only(self):
        result = audit_request_command_membership(
            [{"turn": 4, "commands": [{"command_id": 2}, {"command_id": 3}]}],
            [{"current_turn": 4, "command_id": 2},
             {"current_turn": 4, "command_id": 8}],
        )
        self.assertEqual(result["request_count_compared"], 2)
        self.assertEqual(result["status_counts"], {
            "absent_from_all_same_turn_snapshots": 1,
            "present_in_all_same_turn_snapshots": 1,
        })
        self.assertFalse(result["same_state_verified"])
        self.assertFalse(result["causal_link_verified"])

    def test_multiple_snapshots_with_conflicting_membership_are_not_collapsed(self):
        result = audit_request_command_membership(
            [{"turn": 4, "commands": [{"command_id": 2}]},
             {"turn": 4, "commands": [{"command_id": 3}]}],
            [{"current_turn": 4, "command_id": 2}],
        )
        self.assertEqual(result["status_counts"], {
            "inconsistent_across_same_turn_snapshots": 1,
        })

    def test_explicit_identity_mismatch_is_reported_without_claiming_state_proof(self):
        result = compare_shared_identity(
            {"scenario_id": 1, "chara_id": 123},
            {"scenario_id": 2, "chara_id": 123},
        )
        self.assertEqual(result["status"], "mismatch")
        self.assertEqual(result["mismatch_fields"], ["scenario_id"])
        self.assertFalse(result["same_state_verified"])

    def test_missing_identity_is_not_inferred(self):
        result = compare_shared_identity(
            {"turn": 4},
            {"turn": 4, "single_mode_chara_id": 123},
        )
        self.assertEqual(result["status"], "identity_unavailable")
        self.assertEqual(result["compared_fields"], {})
        self.assertFalse(result["same_state_verified"])

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
