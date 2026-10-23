import unittest

from pc_live_screen_stream import build_failure_record, build_observation_record


class FakeEnvelope:
    def __init__(self):
        self.states = []

    def record_capture(self, state):
        self.states.append(dict(state))
        return {
            "observation_seq": len(self.states),
            "capture_monotonic_ns": 123456,
            "capture_source": "local_observer_unverified",
            "ready": True,
            "verified": True,
            "executable": True,
            **state,
        }


class FakeEvidence:
    phase = "training"
    confidence = 0.97
    verified = True
    reason = "template_match"


class LiveScreenStreamRecordTests(unittest.TestCase):
    def test_observation_record_forces_non_executable_flags(self):
        envelope = FakeEnvelope()
        record = build_observation_record(envelope, FakeEvidence(), (10, 20, 640, 480))
        self.assertEqual(record["mode"], "read_only")
        self.assertEqual(record["phase"], "training")
        self.assertEqual(record["phase_confidence"], 0.97)
        self.assertEqual(record["capture_rect"], [10, 20, 640, 480])
        self.assertFalse(record["ready"])
        self.assertFalse(record["verified"])
        self.assertFalse(record["executable"])
        self.assertEqual(record["capture_source"], "local_observer_unverified")
        self.assertFalse(envelope.states[0]["ready"])
        self.assertFalse(envelope.states[0]["executable"])

    def test_failure_record_never_claims_verified_state(self):
        record = build_failure_record(RuntimeError("sensitive details"))
        self.assertEqual(record["mode"], "read_only")
        self.assertEqual(record["phase"], "unknown")
        self.assertEqual(record["reason"], "capture_or_detection_failed")
        self.assertEqual(record["error_type"], "RuntimeError")
        self.assertFalse(record["ready"])
        self.assertFalse(record["verified"])
        self.assertFalse(record["executable"])
        self.assertNotIn("sensitive details", str(record))

    def test_failure_record_rejects_unusual_exception_type_safely(self):
        class OddError(BaseException):
            pass
        record = build_failure_record(OddError())
        self.assertEqual(record["error_type"], "OddError")
        self.assertFalse(record["executable"])


if __name__ == "__main__":
    unittest.main()
