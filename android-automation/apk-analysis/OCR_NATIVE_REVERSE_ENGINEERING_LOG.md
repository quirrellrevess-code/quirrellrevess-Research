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


## Follow-up: direct Base64 retrieval of smaller native resources

A second pass used the GitHub Contents API's Base64 representation for smaller native libraries and lua.zip, then decoded the returned bytes in-session before scanning printable strings / ZIP central-directory names. This succeeded for the following files (returned byte counts match Git tree sizes):

- lib/arm64-v8a/libyolo.so: 59,592 bytes.
- lib/arm64-v8a/libpaddleocr.so: 952,688 bytes.
- lua.zip: 23,821 bytes.

### New directly observed libpaddleocr.so strings

In addition to the JNI symbols above, printable strings include:

- PADDLEOCR
- keys size(%d)
- CrnnNet and DbNet
- nBitmapToMat and bitmapToMat
- jni/paddlenew/src/ch/BitmapUtils.cpp
- AndroidBitmap_getInfo(env, bitmap, &info) >= 0
- AndroidBitmap_lockPixels(env, bitmap, &pixels) >= 0
- info.format == ANDROID_BITMAP_FORMAT_RGBA_8888 || info.format == ANDROID_BITMAP_FORMAT_RGB_565
- nBitmapToMat: RGBA_8888 -> CV_8UC4 and nBitmapToMat: RGB_565 -> CV_8UC4
- <load_dbNet_param failed, load_crnnNet_param failed, load_dbNet_model failed, and load_crnnNet_model failed

**Updated interpretation (evidence-backed):** the PaddleOCR native library includes an Android Bitmap-to-OpenCV-matrix conversion path and contains a string explicitly reporting a keys collection size. This strengthens the hypothesis that the bundled keys.txt character table is consumed by this OCR stack, but the string alone does not prove the exact file path, character ordering semantics, or the mapping between keys.txt and any smn*Dict.txt files. DBNet/CRNN names and model-loading error strings are also present.

### ZIP inventory for lua.zip

The ZIP central directory lists only LuaSocket-related modules/directories:

- ltn12.lua, mime.lua, mysql.lua
- socket.lua, socket/ftp.lua, socket/headers.lua, socket/http.lua, socket/mbox.lua, socket/smtp.lua, socket/tp.lua, socket/url.lua
- ssl.lua, ssl/https.lua

No OCR or smn*Dict script appears in this ZIP filename inventory. This does not rule out Lua code embedded elsewhere (for example, in script.lrj) or references in DEX/native code.

### Retrieval limitation update

The smaller and mid-sized native libraries can be retrieved as Base64 through the Contents API and scanned in-session. This corrects the earlier broad limitation: retrieval is not universally blocked, but large blobs may still be truncated/empty or impractical through this API. The large libocrapi.so, libengine.so, libopencv_java4.so, and classes.dex remain unanalyzed at bytecode/disassembly level.


### Follow-up string-context observation

A byte-offset/context scan around the native string table shows these strings adjacent in the binary:

`CrnnNet` → `PADDLEOCR` → `keys size(%d)` → ` txt file not found` → `DbNet`

The library also contains C++ input-file stream type names (`basic_ifstream`, `basic_filebuf`, and `basic_istream`). This supports that some text-file reading path exists near the OCR/key-related code, but printable-string adjacency is not proof of control-flow adjacency and does not reveal the requested filename or parser. No `smn*Dict` filename was found in the scanned printable strings.


## Follow-up: binary AndroidManifest.xml string-pool scan

The uploaded AndroidManifest.xml is Android binary XML rather than UTF-8 text. Requesting it as Base64 succeeded (19,168 decoded bytes); a UTF-16LE printable-string scan recovered these manifest strings:

- Package: `com.qyzs.smn2`
- Application class: `com.main.app.App`
- Activities include `com.main.app.SplashActivity`, `com.main.app.MainActivity`, `com.main.app.ScriptActivity`, `com.main.app.SettingsActivity`, `com.main.app.LogListActivity`, and `com.main.app.LogActivity`.
- Services include `com.main.app.MainService`, `com.main.app.NativeService`, `com.main.app.X5ProcessInitService`, and `com.nx.uiauto.accessibility.AccessibilityService`.
- Providers include `com.qyzs.smn2.CoreProvider` and `com.main.engine.CoreProvider`.
- `android.permission.INTERNET` and a broad set of device, overlay, storage, SMS, phone, and accessibility-related permission strings are present in the manifest string pool. Presence in the string pool alone does not always establish the final merged permission state, so exact permission declarations should be parsed from the binary XML structure before making policy conclusions.

This gives concrete Java component names for later DEX call-site tracing. However, the GitHub Contents API returned an empty Base64 body for the 6,339,288-byte classes.dex and the 3,278,648-byte x86 libocrapi.so, so those files remain unavailable through this route for direct in-session bytecode/disassembly analysis. The 19,168-byte manifest was readable after Base64 decoding.


## 2026-10-24 follow-up: call-chain traceability and source-of-truth check

### Repository inspection performed

- Inspected the branch tree and the current reverse-engineering log.
- Confirmed the repository contains `classes.dex` (6,339,288 bytes; blob SHA `e41759e70ba4e0469f5d4d3131291db52ee1d009`), `script.lrj` (80,925,066 bytes), and the OCR/native resource set.
- Searched repository code for `PaddleOcr nativeLoadMode` and `smnJcDict`; GitHub code search returned no matches. This is not evidence that the strings are absent from DEX or binary payloads, because those artifacts are not indexed as ordinary source text.
- The uploaded resource tree does **not** currently contain files whose paths match `smn*Dict.txt`. Their names remain leads from the earlier local scan; their actual bytes and repository provenance have not been established.

### What can and cannot be concluded about PaddleOCR loading

**Confirmed from previously retrieved native strings:**
- JNI entry points named `Java_com_nx_assist_lua_PaddleOcr_nativeLoadMode` and `Java_com_nx_assist_lua_PaddleOcr_nativeDetect` exist in `libpaddleocr.so`.
- Native strings include `keys size(%d)`, `txt file not found`, `CrnnNet`, `DbNet`, and DBNet/CRNN parameter/model load failure messages.
- The library includes Android Bitmap-to-OpenCV-matrix conversion strings and C++ input-file stream type names.

**Supported but not proven:**
- The OCR library likely loads a character-key collection and text/model resources through a file-reading path.
- `assets/paddle/keys.txt` is structurally consistent with a character table (6,623 nonempty unique one-character lines), and is a plausible candidate for the collection whose size is logged.

**Unknown / not established:**
- The runtime path/name used to open `keys.txt`, whether it is copied from APK assets or loaded from another location, and how keys map to model output indices.
- The Java/Lua call sites, parameter order, and invocation order for `nativeLoadMode` and `nativeDetect`.
- Whether `ScriptActivity` invokes PaddleOCR directly or delegates through Lua/native service code.
- Whether `smn*Dict.txt` is consumed by PaddleOCR, another native library, Lua script payload, or a separate image-matching subsystem. No `smn*Dict` filename was found in the scanned printable strings of `libpaddleocr.so`.
- The custom dictionary record layout, encoding, dimensions, or matching algorithm.

### Retrieval constraint and next falsifiable step

The standard GitHub Contents fetch returned empty Base64 content for the 6.3 MB DEX and the 80.9 MB script payload is too large for this current retrieval path. Do not claim DEX call-chain tracing is complete. Next, try alternate *repository-backed* routes that can return actual bytes or a targeted decompilation/extraction artifact, prioritizing:
1. a small, locally generated DEX string/method/class report or JADX/smali output if any such artifact already exists in the repository;
2. DEX-related names and OCR method references inside any accessible script/config payload;
3. retrieving the original `smn*Dict.txt` files or a bounded sample with hashes from already uploaded materials.

Do not ask for local execution until these direct routes have been exhausted. Any new conclusion must be added to this log and committed before reporting it.



## 2026-10-24 follow-up: alternate DEX / native payload retrieval attempts

### Retrieval routes tested

Using the repository's current branch and the known DEX blob SHA, attempted:
- GitHub raw URL for `classes.dex`: rejected by the connected fetch interface as too large or unsupported.
- GitHub Git Blob API for the DEX SHA: rejected because the response is binary/non-UTF-8.
- GitHub Contents API with `encoding=base64` for `classes.dex`: returned an empty content field while still returning the expected blob SHA.
- The same Base64 Contents route for ARM64 `libocrapi.so`, ARMv7 `libocrapi.so`, and ARM64 `libengine.so`: all returned empty content fields.
- The same raw URL strategy for `script.lrj`: rejected as too large or unsupported.
- Repository code searches for `jadx`, `dex decompile`, `smnDict`, `nativeLoadMode`, and `ScriptActivity`: no indexed source matches returned.

These results reproduce the retrieval blocker across more than one API route. They do not mean the content is absent from the repository: the Git tree still lists each blob and its size/SHA.

### Small-file control check

The Base64 Contents route successfully returned `assets/paddle/keys.txt` (26,249 bytes; Base64 response length 35,584; blob SHA `84b885d8352226e49b1d5d791b8f43a663e246aa`). This control check confirms the route works for small files, but not for the large binary payloads above.

### Current conclusion

No Java call-site evidence was recovered in this pass. The relationship between `ScriptActivity`, `PaddleOcr.nativeLoadMode`, and `PaddleOcr.nativeDetect` remains **unresolved**. No real `smn*Dict.txt` file contents have been located in the uploaded repository tree. The next viable direct route needs to produce a smaller, derived artifact (for example, a DEX class/method/string report or disassembly excerpt) from the existing binary; no such artifact is currently present in the repository tree. Avoid repeating the same large-file API attempts without a changed retrieval mechanism.


## 2026-10-24 follow-up: JADX decompilation of `com.nx.assist.lua.PaddleOcr`

### Evidence source
A decompiled Java class body for `com.nx.assist.lua.PaddleOcr` was provided in the project conversation. The observations below are based on that pasted class, not on an independent re-fetch of DEX bytecode.

### Directly confirmed from the class
- `loadModel(boolean)` chooses between an ONNX path (`loadOnnxModel`) and an NNCC path (`loadNnccModel`) based on the boolean argument.
- `loadOnnxModel(String, String, String, String)` calls `loadModeImp(true, str, str2, str3, BuildConfig.FLAVOR, str4)`; therefore the fourth native string parameter is an empty string in this branch, and the fifth is the supplied `str4`.
- `loadNnccModel(String, String, String, String, String)` calls `loadModeImp(false, str, str2, str3, str4, str5)`.
- `loadModeImp` performs Java-side file-existence checks before calling native code. It checks `str`, `str3`, and `str5` (with a duplicated check of `str`); for the non-ONNX branch it additionally checks `str4`. It does not explicitly check `str2` in the visible Java body.
- After native-library setup and instance initialization, `loadModeImp` calls `nativeLoadMode(Obj.class, str, str2, str3, str4, str5, z)`.
- `detect(Bitmap, ...)` calls `nativeDetect` only when `sInstance` is non-null, then serializes returned objects to JSON. The visible fields include bounding-box-derived values, `label`, and `prob`; this class does not implement the OCR recognition algorithm itself.
- `Obj` contains string `label`, float `prob`, and integer coordinate fields `x0`, `x1`, `x2`, `y0`, `y1`.

### Interpretation and limits
This confirms a Java-to-JNI model-loading and inference wrapper, plus a JSON result adapter. The visible Java body does **not** show a reference to `smn*Dict.txt`, does not decode the obfuscated path/name constants passed to `new File(...)`, and does not reveal how native code interprets the five string parameters. It therefore does not establish that the `smn*Dict.txt` custom dictionaries belong to PaddleOCR. The keys-file hypothesis remains separate: native strings such as `keys size(%d)` and `txt file not found` suggest a native text-file/key-loading path, but its exact input path and mapping remain unconfirmed.

### Next targeted trace
In JADX, inspect **Find Usage** / callers of `loadNnccModel`, `loadOnnxModel`, and `PaddleOcr.loadModel`; then text-search for `smnJcDict`, `smnDict`, and `Dict.txt` in the decompiled project. Prioritize the caller that supplies the arguments, because the path constants are obfuscated in this class. If no caller is found, inspect `IL1Iii.IL1Iii(byte[], String)` only as needed to decode the constants, and keep that decoding separate from claims about dictionary format.


## 2026-10-24 follow-up: JADX global text search yielded no dictionary-name hits

### User-reported search result
In JADX, global text searches for `smnJcDict`, `smnDict`, and `Dict.txt` returned no matches. Searching for `loadNnccModel` showed only these method entries:
- `com.nx.assist.lua.PaddleOcr.loadModel(boolean):boolean`
- `com.nx.assist.lua.PaddleOcr.loadNnccModel(String, String, String, String, String):boolean`

This is a user-reported GUI result, not an independently reproduced scan of all DEX/smali content. It does not prove that dictionary names are absent from the APK: names may be assembled dynamically, stored in resources/configuration, referenced from Lua/script payloads, or belong to another OCR subsystem.

### Next action
Use JADX **Find Usage** on the declaration of `PaddleOcr.loadNnccModel(String, String, String, String, String)` (rather than global text search) and inspect any callers/argument expressions. If there are no callers, trace `loadOnnxModel` and then inspect the implementation of `IL1Iii.IL1Iii(byte[], String)` to understand the obfuscated constants in `loadModel(boolean)`. Keep the custom `smn*Dict.txt` files unlinked from PaddleOCR until a concrete call/path reference is found.


## 2026-10-24 follow-up: decoded PaddleOcr model filenames

### Evidence
The user supplied the JADX implementation of `I1I.IL1Iii.IL1Iii(byte[], String)`. It XORs each byte with the repeating character sequence from the second argument, then constructs a string. Applying this decoder recursively to the obfuscated constants in the supplied `PaddleOcr.loadModel(boolean)` gives these filenames:

- NNCC branch under the `paddle` subdirectory: `det.param`, `rec.param`, `det.bin`, `rec.bin`, `keys.txt`.
- ONNX branch under the `paddle` subdirectory: `det.onnx`, `cls.onnx`, `rec.onnx`, `keys.txt`.

The common directory component in both branches decodes to `paddle`.

### Interpretation and limits
This establishes that the visible `PaddleOcr` wrapper expects a Paddle OCR model directory and a `keys.txt` file. The APK contains `assets/paddle/keys.txt`, but this alone does not prove the runtime model path points to that packaged asset; the base directory comes from `L11I.I11L().I11li1()`. No direct link to the separate `smn*Dict.txt` resources has been established. The decoder's XOR behavior and the recovered filenames are based on the user-provided Java decompilation and recursive decoding of its constants.

### Next step
Inspect `L11I.I11L().I11li1()` and the caller(s) of `PaddleOcr.loadModel(boolean)` to establish the runtime model directory and whether the model assets are copied/extracted there. Continue treating `smn*Dict.txt` as a separate unresolved dictionary family unless a concrete reference connects it to this wrapper.


## 2026-10-24: L11I model base path trace

User-provided JADX code confirms `L11I.I11li1()` simply returns `this.f57lIiI`. The field is initialized by `m1131()`: when context exists, the base is `getFilesDir()`; otherwise it falls back to the parent directory of `f60lLi1LL`. The method then creates a child directory using an obfuscated string constant and stores it in `f57lIiI`. `PaddleOcr.loadModel(boolean)` appends `paddle` and the decoded model filenames to this returned directory.

This establishes an app-private runtime directory path, not direct loading from APK assets in the visible getter. Still unknown: the decoded child-directory name, how model files (including `keys.txt`) reach that directory, and the callers of `PaddleOcr.loadModel(boolean)`. No link to the separate `smn*Dict.txt` family is established. Next: use JADX Find Usage on `PaddleOcr.loadModel(boolean)` and inspect its callers; decode the obfuscated child-directory constant separately.
