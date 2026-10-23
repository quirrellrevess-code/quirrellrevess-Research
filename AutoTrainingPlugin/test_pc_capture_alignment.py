import unittest

from pc_capture_alignment import assess_capture_alignment


class CaptureAlignmentTests(unittest.TestCase):
    def test_nearby_timestamps_report_diagnostic_only(self):
        result = assess_capture_alignment(1_000_000_000, 1_120_000_000)
        self.assertTrue(result.aligned)
        self.assertEqual(result.skew_ns, 120_000_000)
        self.assertEqual(result.reason, "capture_times_proximate_unverified")

    def test_excessive_skew_rejected(self):
        result = assess_capture_alignment(1_000_000_000, 1_300_000_000)
        self.assertFalse(result.aligned)
        self.assertEqual(result.reason, "capture_skew_exceeded")

    def test_exact_threshold_accepted(self):
        self.assertTrue(assess_capture_alignment(100, 110, max_skew_ns=10).aligned)

    def test_invalid_timestamps_rejected(self):
        for value in (True, -1, 1.5, "123", None):
            with self.subTest(value=value):
                self.assertEqual(
                    assess_capture_alignment(value, 100).reason,
                    "invalid_capture_timestamp",
                )

    def test_invalid_policy_rejected(self):
        for value in (True, -1, 0.5):
            with self.subTest(value=value):
                self.assertEqual(
                    assess_capture_alignment(100, 100, max_skew_ns=value).reason,
                    "invalid_skew_policy",
                )


if __name__ == "__main__":
    unittest.main()
