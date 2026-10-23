import unittest
from unittest.mock import patch

import pc_window_probe


class WindowProbeTests(unittest.TestCase):
    def test_non_windows_rejects_without_win32_access(self):
        with patch.object(pc_window_probe.sys, "platform", "linux"):
            with self.assertRaisesRegex(RuntimeError, "Windows only"):
                pc_window_probe.discover_windows()

    def test_default_title_redaction(self):
        import inspect
        signature = inspect.signature(pc_window_probe.discover_windows)
        self.assertIs(signature.parameters["include_titles"].default, False)

    def test_no_submission_functions(self):
        self.assertFalse(hasattr(pc_window_probe, "submit"))
        self.assertFalse(hasattr(pc_window_probe, "click"))


if __name__ == "__main__":
    unittest.main()
