#!/usr/bin/env python3
"""Read-only Windows PC game window discovery.

No input, hooks, memory reads, process injection, or game requests.
Reports window metadata only, to select a future independently verified
input backend. Default output omits window titles to limit data exposure.
"""
from __future__ import annotations

import argparse
import ctypes
import json
import os
import sys
from ctypes import wintypes


def discover_windows(*, include_titles: bool = False) -> list[dict[str, object]]:
    if sys.platform != "win32":
        raise RuntimeError("Windows only; no input attempted")
    user32 = ctypes.WinDLL("user32", use_last_error=True)
    kernel32 = ctypes.WinDLL("kernel32", use_last_error=True)
    hwnd_type = wintypes.HWND
    callback_type = ctypes.WINFUNCTYPE(wintypes.BOOL, hwnd_type, wintypes.LPARAM)
    user32.EnumWindows.argtypes = [callback_type, wintypes.LPARAM]
    user32.EnumWindows.restype = wintypes.BOOL
    user32.IsWindowVisible.argtypes = [hwnd_type]
    user32.IsWindowVisible.restype = wintypes.BOOL
    user32.GetWindowThreadProcessId.argtypes = [hwnd_type, ctypes.POINTER(wintypes.DWORD)]
    user32.GetWindowThreadProcessId.restype = wintypes.DWORD
    user32.GetClassNameW.argtypes = [hwnd_type, wintypes.LPWSTR, ctypes.c_int]
    user32.GetClassNameW.restype = ctypes.c_int
    user32.GetWindowTextLengthW.argtypes = [hwnd_type]
    user32.GetWindowTextLengthW.restype = ctypes.c_int
    user32.GetWindowTextW.argtypes = [hwnd_type, wintypes.LPWSTR, ctypes.c_int]
    user32.GetWindowTextW.restype = ctypes.c_int
    user32.GetWindowRect.argtypes = [hwnd_type, ctypes.POINTER(wintypes.RECT)]
    user32.GetWindowRect.restype = wintypes.BOOL

    records: list[dict[str, object]] = []

    @callback_type
    def callback(hwnd: int, _lparam: int) -> bool:
        if not user32.IsWindowVisible(hwnd):
            return True
        pid = wintypes.DWORD()
        user32.GetWindowThreadProcessId(hwnd, ctypes.byref(pid))
        class_buf = ctypes.create_unicode_buffer(256)
        user32.GetClassNameW(hwnd, class_buf, len(class_buf))
        rect = wintypes.RECT()
        if not user32.GetWindowRect(hwnd, ctypes.byref(rect)):
            return True
        width, height = rect.right - rect.left, rect.bottom - rect.top
        if width <= 0 or height <= 0:
            return True
        record: dict[str, object] = {
            "pid": pid.value,
            "class_name": class_buf.value,
            "rect": [rect.left, rect.top, rect.right, rect.bottom],
            "width": width,
            "height": height,
        }
        if include_titles:
            length = min(user32.GetWindowTextLengthW(hwnd), 4096)
            title = ctypes.create_unicode_buffer(length + 1)
            user32.GetWindowTextW(hwnd, title, len(title))
            record["title"] = title.value
        records.append(record)
        return True

    if not user32.EnumWindows(callback, 0):
        raise ctypes.WinError(ctypes.get_last_error())
    return records


def main() -> int:
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument("--include-titles", action="store_true", help="May expose unrelated window titles")
    parser.add_argument("--output", help="Write JSON to a local path; default stdout")
    args = parser.parse_args()
    try:
        records = discover_windows(include_titles=args.include_titles)
    except RuntimeError as error:
        print(str(error), file=sys.stderr)
        return 2
    payload = json.dumps({"mode": "read_only", "windows": records}, ensure_ascii=False, indent=2)
    if args.output:
        with open(args.output, "w", encoding="utf-8") as stream:
            stream.write(payload + "\n")
    else:
        print(payload)
    return 0


if __name__ == "__main__":
    raise SystemExit(main())
