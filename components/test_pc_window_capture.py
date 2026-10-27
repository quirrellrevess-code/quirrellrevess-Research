import unittest
from unittest.mock import patch
import pc_window_capture


class WindowCaptureTests(unittest.TestCase):
    def test_non_windows_fails_closed(self):
        with patch.object(pc_window_capture.sys, "platform", "linux"):
            with self.assertRaisesRegex(RuntimeError, "Windows only"):
                pc_window_capture.get_client_capture_rect(123)

    def test_invalid_handle_rejected_before_api(self):
        with patch.object(pc_window_capture.sys, "platform", "win32"):
            with patch.object(pc_window_capture.ctypes, "WinDLL", side_effect=AssertionError("should not call API"), create=True):
                with self.assertRaisesRegex(ValueError, "invalid_hwnd"):
                    pc_window_capture.get_client_capture_rect(0)

    def test_pid_argument_is_explicit(self):
        import inspect
        self.assertIn("expected_pid", inspect.signature(pc_window_capture.get_client_capture_rect).parameters)


if __name__ == "__main__":
    unittest.main()
