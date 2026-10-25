#!/usr/bin/env python3
"""Template-free semantic UI locator over OCR detections.

This module does not capture screens, load OCR models, click, or submit input.
It converts OCR text + bounding boxes into semantic target candidates without
PNG templates or hand-authored pixel coordinates. A concrete OCR backend must
supply detections in one of the accepted shapes.
"""
from __future__ import annotations

import argparse
import difflib
import json
import math
import re
import unicodedata
from pathlib import Path
from typing import Any, Iterable


def _normalise_text(value: Any) -> str:
    if not isinstance(value, str):
        return ""
    value = unicodedata.normalize("NFKC", value).casefold()
    return re.sub(r"[\s\W_]+", "", value, flags=re.UNICODE)


def _number(value: Any) -> float | None:
    if isinstance(value, bool):
        return None
    try:
        result = float(value)
    except (TypeError, ValueError, OverflowError):
        return None
    return result if math.isfinite(result) else None


def _bbox(item: dict[str, Any]) -> tuple[float, float, float, float] | None:
    raw = item.get("bbox")
    if isinstance(raw, (list, tuple)) and len(raw) == 4:
        values = [_number(v) for v in raw]
        if any(v is None for v in values):
            return None
        left, top, third, fourth = values
        # Canonical bbox list is [left, top, right, bottom].
        right, bottom = third, fourth
    elif all(k in item for k in ("x0", "y0", "x1", "y1")):
        values = [_number(item.get(k)) for k in ("x0", "y0", "x1", "y1")]
        if any(v is None for v in values):
            return None
        left, top, right, bottom = values
    elif all(k in item for k in ("x", "y", "w", "h")):
        values = [_number(item.get(k)) for k in ("x", "y", "w", "h")]
        if any(v is None for v in values):
            return None
        left, top, width, height = values
        right, bottom = left + width, top + height
    else:
        return None
    if right <= left or bottom <= top:
        return None
    return left, top, right, bottom


def _text(item: dict[str, Any]) -> str:
    for key in ("text", "label", "value", "content"):
        value = item.get(key)
        if isinstance(value, str) and value.strip():
            return value.strip()
    return ""


def _confidence(item: dict[str, Any]) -> float | None:
    for key in ("confidence", "score", "prob", "probability"):
        if key in item:
            return _number(item[key])
    # Unknown confidence is not silently promoted to a trusted detection.
    return None


def _match_score(observed: str, phrases: Iterable[str]) -> tuple[float, str | None]:
    observed_n = _normalise_text(observed)
    if not observed_n:
        return 0.0, None
    best_score, best_phrase = 0.0, None
    for phrase in phrases:
        phrase_n = _normalise_text(phrase)
        if not phrase_n:
            continue
        if observed_n == phrase_n:
            score = 1.0
        elif phrase_n in observed_n or observed_n in phrase_n:
            score = min(len(observed_n), len(phrase_n)) / max(len(observed_n), len(phrase_n))
        else:
            score = difflib.SequenceMatcher(None, observed_n, phrase_n).ratio()
        if score > best_score:
            best_score, best_phrase = score, phrase
    return best_score, best_phrase


def locate_targets(
    detections: Any,
    targets: list[dict[str, Any]],
    *,
    image_width: int,
    image_height: int,
    min_ocr_confidence: float = 0.50,
    min_text_match: float = 0.78,
    ambiguity_margin: float = 0.08,
) -> dict[str, Any]:
    """Map semantic phrase definitions to OCR boxes; output is never executable."""
    if not isinstance(detections, list):
        raise ValueError("detections must be a JSON list")
    if image_width <= 0 or image_height <= 0:
        raise ValueError("image dimensions must be positive")
    for value in (min_ocr_confidence, min_text_match, ambiguity_margin):
        if not math.isfinite(value) or not 0 <= value <= 1:
            raise ValueError("thresholds must be finite values in [0, 1]")

    parsed = []
    rejected = 0
    for index, item in enumerate(detections):
        if not isinstance(item, dict):
            rejected += 1
            continue
        text = _text(item)
        box = _bbox(item)
        confidence = _confidence(item)
        if not text or box is None or confidence is None or not 0 <= confidence <= 1:
            rejected += 1
            continue
        left, top, right, bottom = box
        # Reject boxes outside the screenshot instead of silently clamping them.
        if left < 0 or top < 0 or right > image_width or bottom > image_height:
            rejected += 1
            continue
        if confidence < min_ocr_confidence:
            continue
        parsed.append({
            "index": index, "text": text, "bbox": [left, top, right, bottom],
            "ocr_confidence": confidence,
        })

    results = []
    seen_ids = set()
    for target in targets:
        if not isinstance(target, dict):
            continue
        target_id = target.get("target_id")
        phrases = target.get("phrases")
        if not isinstance(target_id, str) or not target_id or target_id in seen_ids:
            continue
        seen_ids.add(target_id)
        if not isinstance(phrases, list) or not phrases or not all(isinstance(p, str) for p in phrases):
            results.append({
                "target_id": target_id, "verified": False, "executable": False,
                "reason": "invalid_target_phrases", "candidates": [],
            })
            continue
        target_min = _number(target.get("min_text_match"))
        if target_min is None:
            target_min = min_text_match
        if not 0 <= target_min <= 1:
            raise ValueError("target min_text_match must be in [0, 1]")

        candidates = []
        for detection in parsed:
            score, matched_phrase = _match_score(detection["text"], phrases)
            if score < target_min:
                continue
            left, top, right, bottom = detection["bbox"]
            candidates.append({
                **detection,
                "text_match": round(score, 4),
                "matched_phrase": matched_phrase,
                "center": [round((left + right) / 2, 2), round((top + bottom) / 2, 2)],
                "center_normalized": [
                    round((left + right) / (2 * image_width), 6),
                    round((top + bottom) / (2 * image_height), 6),
                ],
            })
        candidates.sort(
            key=lambda c: (c["text_match"] * c["ocr_confidence"], c["ocr_confidence"]),
            reverse=True,
        )
        best = candidates[0] if candidates else None
        second = candidates[1] if len(candidates) > 1 else None
        ambiguous = bool(
            best and second
            and best["text_match"] * best["ocr_confidence"]
            - second["text_match"] * second["ocr_confidence"] < ambiguity_margin
        )
        verified = bool(best and not ambiguous)
        results.append({
            "target_id": target_id,
            "verified": verified,
            "executable": False,
            "reason": (
                "no_matching_text" if not best else
                "ambiguous_multiple_text_matches" if ambiguous else
                "semantic_text_candidate_only"
            ),
            "best": best,
            "candidates": candidates[:10],
        })

    return {
        "mode": "read_only",
        "method": "ocr_text_and_bounding_boxes_no_templates",
        "image_size": {"width": image_width, "height": image_height},
        "verified": False,
        "executable": False,
        "rejected_detection_count": rejected,
        "targets": results,
        "limitations": [
            "requires an OCR backend to supply detections",
            "text match does not prove the region is clickable",
            "icon-only controls and visual state are not detected by text matching",
            "all candidates require state/postcondition validation before any future action",
        ],
    }


def main() -> int:
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument("--detections", type=Path, required=True,
                        help="JSON list of OCR detections, not a screenshot")
    parser.add_argument("--targets", type=Path, required=True,
                        help="JSON list: [{target_id, phrases, optional min_text_match}]")
    parser.add_argument("--width", type=int, required=True)
    parser.add_argument("--height", type=int, required=True)
    parser.add_argument("--min-ocr-confidence", type=float, default=0.50)
    parser.add_argument("--min-text-match", type=float, default=0.78)
    parser.add_argument("--ambiguity-margin", type=float, default=0.08)
    args = parser.parse_args()
    try:
        detections = json.loads(args.detections.read_text(encoding="utf-8"))
        targets = json.loads(args.targets.read_text(encoding="utf-8"))
        result = locate_targets(
            detections, targets, image_width=args.width, image_height=args.height,
            min_ocr_confidence=args.min_ocr_confidence,
            min_text_match=args.min_text_match,
            ambiguity_margin=args.ambiguity_margin,
        )
    except (OSError, json.JSONDecodeError, ValueError) as exc:
        print(json.dumps({"mode": "read_only", "verified": False, "executable": False,
                          "reason": "invalid_input", "detail": str(exc)}, ensure_ascii=False))
        return 2
    print(json.dumps(result, ensure_ascii=False, separators=(",", ":")))
    return 0


if __name__ == "__main__":
    raise SystemExit(main())
