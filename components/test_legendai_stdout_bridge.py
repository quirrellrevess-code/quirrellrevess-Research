"""Offline tests for the passive LegendAI recommendation bridge."""
import io
import json
import tempfile
import unittest
from pathlib import Path
from legendai_stdout_bridge import (
    extract_recommendation,
    iter_bounded_lines,
    parse_recommendation,
    record_stream,
)


class RecordingStringIO(io.StringIO):
    def __init__(self, value):
        super().__init__(value)
        self.requested_sizes = []

    def readline(self, size=-1):
        self.requested_sizes.append(size)
        return super().readline(size)


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
            self.assertTrue(all(r["turn_association_status"] == "unavailable_in_stdout_only" for r in rows))


    def test_requires_exact_recommendation_prefix_before_separator(self):
        invalid_lines = (
            "AI建议debug:休息",
            "AI建议 extra:休息",
            "AI建议foo：速",
            "AI建议",
            "AI建议：",
        )
        for line in invalid_lines:
            with self.subTest(line=line):
                self.assertIsNone(parse_recommendation(line))

    def test_accepts_only_optional_whitespace_before_colon(self):
        for line in ("AI建议:休息", "AI建议 ：休息", "  AI建议   : 速  "):
            with self.subTest(line=line):
                self.assertIsNotNone(parse_recommendation(line))

    def test_rejects_non_string_and_overlong_lines(self):
        self.assertIsNone(parse_recommendation(None))
        self.assertIsNone(parse_recommendation(1))
        prefix = "AI建议："
        at_limit = prefix + "x" * (4096 - len(prefix))
        self.assertIsNotNone(parse_recommendation(at_limit))
        self.assertIsNone(parse_recommendation(at_limit + "x"))

    def test_limit_counts_utf16_code_units_like_dotnet_string_length(self):
        prefix = "AI建议："
        exact = prefix + "😀" * 2045 + "x"
        over = prefix + "😀" * 2046
        self.assertEqual(len(exact.encode("utf-16-le")) // 2, 4096)
        self.assertEqual(len(over.encode("utf-16-le")) // 2, 4097)
        self.assertIsNotNone(parse_recommendation(exact))
        self.assertIsNone(parse_recommendation(over))

    def test_strips_only_one_terminal_line_delimiter(self):
        for line in ("AI建议：速\n", "AI建议：速\r\n", "AI建议：速\r"):
            with self.subTest(line=repr(line)):
                parsed = parse_recommendation(line)
                self.assertIsNotNone(parsed)
                self.assertEqual(parsed["raw"], "AI建议：速")
        self.assertIsNone(parse_recommendation("AI建议：速\n\n"))

    def test_rejects_embedded_line_breaks_before_classification(self):
        invalid_lines = (
            "AI建议：\n速",
            "AI建议：速\nAI建议：休息",
            "AI建议：速\r\nAI建议：休息",
            "AI建议：速\r休息",
        )
        for line in invalid_lines:
            with self.subTest(line=repr(line)):
                self.assertIsNone(parse_recommendation(line))

    def test_rejects_unicode_line_separators_as_non_physical_lines(self):
        separators = ("\v", "\f", "\x1c", "\x1d", "\x1e", "\x85", "\u2028", "\u2029")
        for separator in separators:
            invalid_lines = (
                f"AI建议{separator}:休息",
                f"AI建议：速{separator}休息",
                f"AI建议：休息{separator}",
            )
            for line in invalid_lines:
                with self.subTest(separator=repr(separator), line=repr(line)):
                    self.assertIsNone(parse_recommendation(line))

    def test_record_stream_accepts_exact_limit_with_line_terminator(self):
        with tempfile.TemporaryDirectory() as directory:
            target = Path(directory) / "out.jsonl"
            prefix = "AI建议："
            at_limit = prefix + "x" * (4096 - len(prefix)) + "\n"
            count = record_stream(io.StringIO(at_limit), target)
            self.assertEqual(count, 1)
            rows = [json.loads(line) for line in target.read_text(encoding="utf-8").splitlines()]
            self.assertEqual(len(rows[0]["raw"]), 4096)

    def test_bounded_reader_discards_large_line_in_fixed_chunks(self):
        valid = "AI建议：休息\n"
        stream = RecordingStringIO("x" * 50000 + "\n" + valid)

        lines = list(iter_bounded_lines(stream))

        self.assertEqual(lines, [None, valid])
        self.assertEqual(stream.requested_sizes[0], 4099)
        self.assertIn(1024, stream.requested_sizes)
        self.assertLessEqual(max(stream.requested_sizes), 4099)

    def test_bounded_reader_keeps_exact_limit_crlf_line(self):
        prefix = "AI建议："
        exact = prefix + "x" * (4096 - len(prefix)) + "\r\n"
        stream = RecordingStringIO(exact)

        lines = list(iter_bounded_lines(stream))

        self.assertEqual(lines, [exact])
        self.assertIsNotNone(parse_recommendation(lines[0]))

    def test_bounded_reader_discards_overlong_final_line_without_newline(self):
        stream = RecordingStringIO("x" * 50000)

        self.assertEqual(list(iter_bounded_lines(stream)), [None])
        self.assertLessEqual(max(stream.requested_sizes), 4099)

    def test_record_stream_uses_bounded_reader_and_preserves_next_line(self):
        with tempfile.TemporaryDirectory() as directory:
            target = Path(directory) / "out.jsonl"
            stream = RecordingStringIO("x" * 50000 + "\nAI建议：休息\n")

            count = record_stream(iter_bounded_lines(stream), target)

            self.assertEqual(count, 1)
            rows = [json.loads(line) for line in target.read_text(encoding="utf-8").splitlines()]
            self.assertEqual([row["recommendation_text"] for row in rows], ["休息"])
            self.assertLessEqual(max(stream.requested_sizes), 4099)

    def test_record_stream_skips_overlong_line_and_continues(self):
        with tempfile.TemporaryDirectory() as directory:
            target = Path(directory) / "out.jsonl"
            overlong = "AI建议：" + "x" * 4096
            count = record_stream(
                io.StringIO(overlong + "\nAI建议：休息\n"),
                target,
            )
            self.assertEqual(count, 1)
            rows = [json.loads(line) for line in target.read_text(encoding="utf-8").splitlines()]
            self.assertEqual([row["recommendation_text"] for row in rows], ["休息"])

if __name__ == "__main__":
    unittest.main()
