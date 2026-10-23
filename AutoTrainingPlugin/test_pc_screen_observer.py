import tempfile
import unittest
from pathlib import Path
from unittest.mock import Mock

from pc_screen_observer import detect_phase


class FakeCv2:
    IMREAD_COLOR = 1
    TM_CCOEFF_NORMED = 5

    def __init__(self, scores, *, template_std=20.0):
        self.scores = scores
        self.template_std = template_std
        self.imread_calls = []

    def imread(self, path, mode):
        self.imread_calls.append(path)
        template = Mock(shape=(20, 20), size=400)
        if self.template_std is not None:
            template.std.return_value = self.template_std
        return template

    def matchTemplate(self, image, template, method):
        return self.scores.get("score", 0.97)

    def minMaxLoc(self, result):
        return (0, result, (0, 0), (0, 0))


class ScreenObserverTests(unittest.TestCase):
    def test_empty_templates_fail_closed(self):
        with tempfile.TemporaryDirectory() as temp:
            result = detect_phase(Mock(shape=(200, 200)), Path(temp), allowed_phases={"training"}, cv2=FakeCv2({}))
            self.assertEqual(result.phase, "unknown")
            self.assertFalse(result.verified)

    def test_known_template_can_be_classified(self):
        with tempfile.TemporaryDirectory() as temp:
            (Path(temp) / "training.png").write_bytes(b"fake-image")
            result = detect_phase(Mock(shape=(200, 200)), Path(temp), allowed_phases={"training"}, cv2=FakeCv2({}))
            self.assertEqual(result.phase, "training")
            self.assertTrue(result.verified)

    def test_unlisted_template_is_not_loaded(self):
        with tempfile.TemporaryDirectory() as temp:
            (Path(temp) / "untrusted.png").write_bytes(b"fake-image")
            fake = FakeCv2({})
            result = detect_phase(Mock(shape=(200, 200)), Path(temp), allowed_phases={"training"}, cv2=fake)
            self.assertEqual(result.phase, "unknown")
            self.assertEqual(fake.imread_calls, [])

    def test_near_constant_template_is_not_evidence(self):
        with tempfile.TemporaryDirectory() as temp:
            (Path(temp) / "training.png").write_bytes(b"fake-image")
            result = detect_phase(
                Mock(shape=(200, 200)), Path(temp),
                allowed_phases={"training"}, cv2=FakeCv2({}, template_std=0.2))
            self.assertEqual(result.phase, "unknown")
            self.assertEqual(result.reason, "no_known_phase")

    def test_non_finite_match_is_not_evidence(self):
        with tempfile.TemporaryDirectory() as temp:
            (Path(temp) / "training.png").write_bytes(b"fake-image")
            result = detect_phase(
                Mock(shape=(200, 200)), Path(temp),
                allowed_phases={"training"}, cv2=FakeCv2({"score": float("nan")}))
            self.assertEqual(result.phase, "unknown")
            self.assertEqual(result.reason, "no_known_phase")

    def test_unmeasurable_template_is_rejected(self):
        with tempfile.TemporaryDirectory() as temp:
            (Path(temp) / "training.png").write_bytes(b"fake-image")
            fake = FakeCv2({})
            fake.imread = lambda path, mode: Mock(shape=(20, 20), size=400)
            result = detect_phase(
                Mock(shape=(200, 200)), Path(temp),
                allowed_phases={"training"}, cv2=fake)
            self.assertEqual(result.phase, "unknown")
            self.assertEqual(result.reason, "no_known_phase")


if __name__ == "__main__":
    unittest.main()
