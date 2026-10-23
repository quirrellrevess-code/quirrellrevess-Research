import tempfile
import unittest
from pathlib import Path
from unittest.mock import Mock

from pc_target_observer import detect_targets


class MatchMap:
    def __init__(self, best, second):
        self.best = best
        self.second = second
        self.suppressed = False

    def copy(self):
        return MatchMap(self.best, self.second)

    def __setitem__(self, key, value):
        self.suppressed = True


class FakeCv2:
    IMREAD_COLOR = 1
    TM_CCOEFF_NORMED = 5

    def __init__(self, best=0.97, second=0.40, *, spread=20.0):
        self.best = best
        self.second = second
        self.spread = spread
        self.imread_calls = []

    def imread(self, path, mode):
        self.imread_calls.append(path)
        template = Mock(shape=(20, 30, 3), size=1800)
        template.std.return_value = self.spread
        return template

    def matchTemplate(self, image, template, method):
        return MatchMap(self.best, self.second)

    def minMaxLoc(self, result):
        if isinstance(result, MatchMap):
            return (0.0, result.second if result.suppressed else result.best,
                    (0, 0), (10, 15))
        raise AssertionError("unexpected match map")


class TargetObserverTests(unittest.TestCase):
    def test_confident_match_reports_screen_bbox_but_not_executable(self):
        with tempfile.TemporaryDirectory() as temp:
            (Path(temp) / "train_speed.png").write_bytes(b"fake")
            found = detect_targets(
                Mock(shape=(200, 300, 3)), Path(temp),
                allowed_targets={"train_speed"}, cv2=FakeCv2(),
                screen_origin=(100, 200))
            self.assertEqual(len(found), 1)
            self.assertEqual(found[0]["bbox"], [110, 215, 140, 235])
            self.assertTrue(found[0]["verified"])
            self.assertFalse(found[0]["executable"])

    def test_repeated_similar_matches_are_ambiguous(self):
        with tempfile.TemporaryDirectory() as temp:
            (Path(temp) / "event_choice.png").write_bytes(b"fake")
            found = detect_targets(
                Mock(shape=(200, 300, 3)), Path(temp),
                allowed_targets={"event_choice"}, cv2=FakeCv2(0.97, 0.95))
            self.assertFalse(found[0]["verified"])
            self.assertEqual(found[0]["reason"], "ambiguous_multiple_matches")

    def test_low_confidence_is_not_verified(self):
        with tempfile.TemporaryDirectory() as temp:
            (Path(temp) / "train_speed.png").write_bytes(b"fake")
            found = detect_targets(
                Mock(shape=(200, 300, 3)), Path(temp),
                allowed_targets={"train_speed"}, cv2=FakeCv2(0.75, 0.2))
            self.assertFalse(found[0]["verified"])
            self.assertEqual(found[0]["reason"], "low_confidence")

    def test_unknown_templates_are_not_loaded(self):
        with tempfile.TemporaryDirectory() as temp:
            (Path(temp) / "unlisted.png").write_bytes(b"fake")
            fake = FakeCv2()
            found = detect_targets(
                Mock(shape=(200, 300, 3)), Path(temp),
                allowed_targets={"train_speed"}, cv2=fake)
            self.assertEqual(found, [])
            self.assertEqual(fake.imread_calls, [])

    def test_degenerate_template_rejected(self):
        with tempfile.TemporaryDirectory() as temp:
            (Path(temp) / "train_speed.png").write_bytes(b"fake")
            found = detect_targets(
                Mock(shape=(200, 300, 3), std=Mock(return_value=20.0)), Path(temp),
                allowed_targets={"train_speed"}, cv2=FakeCv2(spread=0.2))
            self.assertEqual(found, [])

    def test_uniform_frame_rejected(self):
        with tempfile.TemporaryDirectory() as temp:
            (Path(temp) / "train_speed.png").write_bytes(b"fake")
            frame = Mock(shape=(200, 300, 3), std=Mock(return_value=0.0))
            self.assertEqual(detect_targets(
                frame, Path(temp), allowed_targets={"train_speed"}, cv2=FakeCv2()), [])


if __name__ == "__main__":
    unittest.main()
