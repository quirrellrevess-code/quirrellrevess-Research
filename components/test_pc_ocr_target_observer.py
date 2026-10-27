import unittest

from pc_ocr_target_observer import locate_targets


class OcrTargetObserverTests(unittest.TestCase):
    def setUp(self):
        self.targets = [
            {"target_id": "training", "phrases": ["训练", "トレーニング", "Training"]},
            {"target_id": "race", "phrases": ["比赛", "レース", "Race"]},
        ]

    def test_finds_text_bbox_without_template_or_pixel_map(self):
        result = locate_targets(
            [{"text": "トレーニング", "prob": 0.97, "bbox": [100, 200, 220, 250]}],
            self.targets, image_width=1280, image_height=720,
        )
        training = result["targets"][0]
        self.assertTrue(training["verified"])
        self.assertFalse(training["executable"])
        self.assertEqual(training["best"]["center"], [160.0, 225.0])
        self.assertEqual(training["best"]["center_normalized"], [0.125, 0.3125])

    def test_rejects_ambiguous_repeated_labels(self):
        result = locate_targets(
            [
                {"text": "Race", "prob": 0.9, "bbox": [10, 10, 60, 30]},
                {"text": "Race", "prob": 0.9, "bbox": [10, 60, 60, 80]},
            ],
            self.targets, image_width=100, image_height=100,
        )
        race = result["targets"][1]
        self.assertFalse(race["verified"])
        self.assertEqual(race["reason"], "ambiguous_multiple_text_matches")

    def test_rejects_bad_or_out_of_bounds_detections(self):
        result = locate_targets(
            [
                {"text": "Training", "prob": 0.99, "bbox": [-1, 0, 10, 10]},
                {"text": "Training", "prob": 0.2, "bbox": [0, 0, 10, 10]},
                {"text": "Training", "prob": 0.99, "bbox": [0, 0, 10, 10]},
            ],
            self.targets, image_width=100, image_height=100,
        )
        self.assertEqual(result["rejected_detection_count"], 1)
        self.assertFalse(result["targets"][0]["verified"])

    def test_accepts_xywh_boxes(self):
        result = locate_targets(
            [{"label": "训练", "confidence": 0.99, "x": 20, "y": 30, "w": 40, "h": 20}],
            self.targets, image_width=200, image_height=100,
        )
        self.assertEqual(result["targets"][0]["best"]["bbox"], [20.0, 30.0, 60.0, 50.0])

    def test_invalid_dimensions_fail_closed(self):
        with self.assertRaises(ValueError):
            locate_targets([], self.targets, image_width=0, image_height=100)


if __name__ == "__main__":
    unittest.main()
