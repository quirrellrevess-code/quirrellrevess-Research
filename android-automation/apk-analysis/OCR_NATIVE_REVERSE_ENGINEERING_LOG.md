# OCR / Native Reverse-Engineering Log

Date: 2026-10-24  
Repository: `wosafety0/UmaAI-Research`  
Evidence branch: `research/upload-ocr-native-20261024-130222`

## Purpose and scope

Record reproducible observations from the extracted Qianye 7.9.9 APK resources. This log distinguishes directly observed symbols from hypotheses. It is not a claim that the custom `smn*Dict.txt` format has been decoded.

Project priority remains: Taiwan server first for real-device validation; Japanese server as an earlier-version research reference; mainland China server excluded.

## Confirmed observations

### `lib/arm64-v8a/libimgutils.so`

Extracted printable strings include:

- `Java_com_main_engine_ImageUtils_obtainImageBytes`
- `AndroidBitmap_getInfo`
- `AndroidBitmap_lockPixels`
- `AndroidBitmap_unlockPixels`
- `JNI_OnLoad`

Interpretation: the library exposes a JNI image-byte conversion entry point and uses Android bitmap pixel access APIs. The exact output encoding and call semantics are not yet established.

### `lib/arm64-v8a/libyolo.so`

Extracted strings include:

- `Java_com_nx_assist_lua_YoloV5_nativeInit`
- `Java_com_nx_assist_lua_YoloV5_nativeDetect`
- ncnn symbols `Net::load_param` and `Net::load_model`
- `load_param failed`, `load_model failed`, and `%.2fms   detect`

Interpretation: there is a JNI-accessible YOLOv5 detection path and ncnn model loading. This is evidence for an object-detection path, not evidence that this library parses the `smn*Dict` OCR dictionaries.

### `lib/arm64-v8a/libnative.so`

Extracted JNI symbols include:

- `Java_com_main_app_Native_connectService`
- `Java_com_main_app_Native_getResult`
- `Java_com_main_app_Native_sendEvent`
- `Java_com_main_app_Native_takeCaptureFile`
- `Java_com_main_app_Native_initNative`
- `Java_com_main_app_Native_registerService`
- `Java_com_main_app_Native_runRootEngine`

Interpretation: these are candidate entry points for service communication, event delivery, capture-file handling, and native initialization. Their runtime call order and exact behavior have not been verified.

### `lib/arm64-v8a/libpaddleocr.so`

Previously extracted printable strings include:

- `Java_com_nx_assist_lua_PaddleOcr_nativeDetect`
- `Java_com_nx_assist_lua_PaddleOcr_nativeLoadMode`
- `load_dbNet_param`, `load_crnnNet_param`
- `load_dbNet_model`, `load_crnnNet_model`

Interpretation: these names are consistent with a PaddleOCR-related detection/recognition path using DBNet and CRNN model components. Native symbol strings alone do not establish the full algorithm or how custom dictionaries are loaded.

### `assets/paddle/keys.txt`

Observed metadata from the earlier local scan:

- 26,249 bytes
- 6,623 lines
- 6,623 non-empty lines
- 6,623 unique lines
- maximum line length: 1 character

Interpretation: this appears to be a one-character-per-line character table. Its precise role in the OCR model/configuration should be confirmed by tracing its consumer.

## Resource inventory

The companion file `android-automation/apk-analysis/ocr-native-resources/UPLOAD_MANIFEST.md` records the uploaded resource paths, byte sizes, and SHA-256 checksums. The uploaded set contains 24 OCR/native resources across ARM64, ARMv7, and x86 directories plus OCR assets.

## Current blockers and limitations

- GitHub tree and text APIs expose metadata and small text resources, but binary blobs cannot be decoded as UTF-8 through the generic Git blob fetch route.
- The GitHub contents endpoint returned empty content for a large native library when requested as Base64. Therefore, this investigation has **not** extracted complete strings from `libocrapi.so` (3,082,480 bytes, ARM64) or `libengine.so` (7,453,376 bytes).
- `classes.dex` is present in `android-automation/apk-analysis/classes.dex` (6,339,288 bytes; blob SHA previously observed as `e41759e70ba4e0469f5d4d3131291db52ee1d009`), but its bytecode has not been decompiled in this investigation.
- Names such as `res/smnJcDict.txt`, `res/smnBxsxDict.txt`, `res/smnCHHDict.txt`, and other `smn*Dict.txt` files are leads from earlier scans, not proof that their contents are currently available in the uploaded resource set.
- No confirmed dictionary record schema, character dimensions, encoding, matching rule, or parser has been recovered yet.

## Next investigation steps

1. Inspect all readable native-library strings and classify JNI exports separately from imported C++/system symbols.
2. Locate the Java/Kotlin/Lua call sites for `PaddleOcr.nativeLoadMode`, `PaddleOcr.nativeDetect`, and `ImageUtils.obtainImageBytes` when DEX or script content becomes accessible.
3. Search the extracted APK/repository for the actual `smn*Dict.txt` contents and references to their filenames.
4. Once dictionary bytes are available, document byte-level record boundaries, encoding, dimensions, and matching behavior with test vectors before implementing a Python parser.
5. Validate recognition on actual Taiwan-server emulator screenshots only after the offline parser/prototype has a testable hypothesis.

## Evidence status summary

| Claim | Status |
|---|---|
| PaddleOCR JNI entry points exist | Confirmed by extracted strings |
| YOLO JNI entry points and ncnn model loading exist | Confirmed by extracted strings |
| ImageUtils JNI bitmap access exists | Confirmed by extracted strings |
| Native service/event/capture entry points exist | Confirmed by extracted strings; behavior not runtime-verified |
| `keys.txt` is a one-character-per-line table | Supported by prior local scan; consumer not confirmed |
| `smn*Dict.txt` record format is known | Not established |
| OCR dictionary matching algorithm is known | Not established |
| `libocrapi.so` and `libengine.so` fully analyzed | Not established |
