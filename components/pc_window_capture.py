#!/usr/bin/env python3
"""Read-only Windows client-area capture bounds for a selected HWND."""
from __future__ import annotations

import ctypes
import sys
from ctypes import wintypes


def get_client_capture_rect(hwnd: int, *, expected_pid: int | None = None) -> tuple[int, int, int, int]:
    if sys.platform != "win32":
        raise RuntimeError("Windows only")
    if type(hwnd) is not int or hwnd <= 0:
        raise ValueError("invalid_hwnd")
    user32 = ctypes.WinDLL("user32", use_last_error=True)
    user32.IsWindow.argtypes = [wintypes.HWND]
    user32.IsWindow.restype = wintypes.BOOL
    user32.IsWindowVisible.argtypes = [wintypes.HWND]
    user32.IsWindowVisible.restype = wintypes.BOOL
    user32.GetWindowThreadProcessId.argtypes = [wintypes.HWND, ctypes.POINTER(wintypes.DWORD)]
    user32.GetWindowThreadProcessId.restype = wintypes.DWORD
    user32.GetClientRect.argtypes = [wintypes.HWND, ctypes.POINTER(wintypes.RECT)]
    user32.GetClientRect.restype = wintypes.BOOL
    user32.ClientToScreen.argtypes = [wintypes.HWND, ctypes.POINTER(wintypes.POINT)]
    user32.ClientToScreen.restype = wintypes.BOOL

    handle = wintypes.HWND(hwnd)
    if not user32.IsWindow(handle):
        raise ValueError("invalid_window")
    if not user32.IsWindowVisible(handle):
        raise ValueError("window_not_visible")
    pid = wintypes.DWORD()
    if not user32.GetWindowThreadProcessId(handle, ctypes.byref(pid)) or pid.value <= 0:
        raise ValueError("pid_unavailable")
    if expected_pid is not None and pid.value != expected_pid:
        raise ValueError("pid_mismatch")
    client = wintypes.RECT()
    if not user32.GetClientRect(handle, ctypes.byref(client)):
        raise ctypes.WinError(ctypes.get_last_error())
    width, height = client.right - client.left, client.bottom - client.top
    if width < 100 or height < 100 or width > 8192 or height > 8192:
        raise ValueError("invalid_client_size")
    origin = wintypes.POINT(0, 0)
    if not user32.ClientToScreen(handle, ctypes.byref(origin)):
        raise ctypes.WinError(ctypes.get_last_error())
    return (origin.x, origin.y, origin.x + width, origin.y + height)


def capture_client_area(hwnd: int, *, expected_pid: int | None = None):
    """Capture selected window client area. Returns (PIL image, screen rect)."""
    rect = get_client_capture_rect(hwnd, expected_pid=expected_pid)
    try:
        from PIL import ImageGrab
    except ImportError as exc:
        raise RuntimeError("Pillow is required for screen capture") from exc
    image = ImageGrab.grab(bbox=rect)
    if image.size != (rect[2] - rect[0], rect[3] - rect[1]):
        raise RuntimeError("capture_dimensions_mismatch")
    return image, rect


__all__ = ["get_client_capture_rect", "capture_client_area"]
