import unittest

from pc_capture_envelope import PcCaptureEnvelope


class FakeClock:
    def __init__(self, *values):
        self.values = iter(values)

    def __call__(self):
        return next(self.values)


class CaptureEnvelopeTests(unittest.TestCase):
    def test_stamps_sequence_timestamp_and_overrides_untrusted_fields(self):
        envelope = PcCaptureEnvelope(clock_ns=FakeClock(100, 200))
        source = {"turn": 4, "capture_monotonic_ns": 999, "capture_source": "trusted",
                  "ready": True, "executable": True, "fresh_after_submission": True}
        first = envelope.record_capture(source)
        self.assertEqual(first["observation_seq"], 1)
        self.assertEqual(first["capture_monotonic_ns"], 100)
        self.assertEqual(first["capture_source"], "local_observer_unverified")
        self.assertFalse(first["fresh_after_submission"])
        self.assertFalse(first["ready"])
        self.assertFalse(first["executable"])
        self.assertEqual(source["capture_monotonic_ns"], 999)
        envelope.mark_submission()
        second = envelope.record_capture({"turn": 4})
        self.assertEqual(second["observation_seq"], 2)
        self.assertEqual(second["capture_monotonic_ns"], 200)
        self.assertTrue(second["fresh_after_submission"])
        self.assertFalse(second["ready"])

    def test_rejects_backward_clock_without_consuming_sequence(self):
        envelope = PcCaptureEnvelope(clock_ns=FakeClock(200, 100, 300))
        self.assertEqual(envelope.record_capture({})["observation_seq"], 1)
        with self.assertRaises(ValueError):
            envelope.record_capture({})
        self.assertEqual(envelope.record_capture({})["observation_seq"], 2)

    def test_rejects_invalid_clock_readings(self):
        for value in (True, -1, 1.0, "5"):
            with self.subTest(value=value):
                with self.assertRaises(ValueError):
                    PcCaptureEnvelope(clock_ns=FakeClock(value)).record_capture({})

    def test_rejects_non_mapping(self):
        with self.assertRaises(TypeError):
            PcCaptureEnvelope().record_capture(None)


if __name__ == "__main__":
    unittest.main()
