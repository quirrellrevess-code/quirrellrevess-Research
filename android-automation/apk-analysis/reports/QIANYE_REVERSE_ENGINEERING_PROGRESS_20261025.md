# Qianye APK 静态分析进度记录

- 日期：2026-10-25（+08:00）
- 分支：`analysis/qianye-reverse-engineering-20261025`
- 基线提交：`1a66f92f9058849735649cd37a9d18816b9965f5`
- 方法：只读 GitHub 仓库文件与 Git tree；未执行 APK、原生库或游戏代码；未运行 GitHub Actions；本记录只反映静态证据。

## 本轮已核实

### 1. OCR Java 接口

证据文件：
- `android-automation/apk-analysis/qianye-export/sources/com/p000nx/assist/lua/PaddleOcr.java`
- `android-automation/apk-analysis/qianye-export/sources/com/p000nx/assist/lua/LuaEngine.java`
- `android-automation/apk-analysis/java/com/p000nx/assist/lua/PaddleOcr.java`

观察：
- `LuaEngine.snapShot(int,int,int,int)` 调用 `LuaNative.snapShotJava(...)`，是截图能力的 Java 包装入口。
- `PaddleOcr.detect(...)` 可从截图区域取得 Bitmap 并执行识别；另有基于 Bitmap 的重载。
- 识别结果由 `nativeDetect(...)` 返回对象数组，再序列化成 JSON；对象字段包含 `label`、`prob` 和矩形边界坐标。
- `loadNnccModel(...)` 与 `loadOnnxModel(...)` 汇入 `loadModeImp(...)`，通过 `nativeLoadMode(...)` 加载模型。
- 以上仅证明 APK 内存在相应接口，不能证明可从外部 Python 直接调用，也没有验证它对赛马娘台服画面的识别准确率。

### 2. OCR 资源和原生库清单

从本分支递归 Git tree 核实到：
- `android-automation/apk-analysis/qianye-export/resources/assets/paddle/keys.txt` 存在，文件大小 26,249 bytes。内容以逐行字符为主，初步判断可能是识别字典；与具体模型的绑定关系尚未确认。
- `android-automation/apk-analysis/qianye-export/resources/assets/script.lrj` 存在，大小 80,925,066 bytes，格式及用途尚未解明。
- `android-automation/apk-analysis/qianye-export/resources/assets/lua.zip` 存在，大小 23,821 bytes；尚未检查其内容。
- `resources/assets/paddle/` 当前树中只找到 `keys.txt`，没有在该目录看到模型文件。模型可能在别处、运行时路径或其他打包形式中；目前不能据此断言 APK 不包含模型。
- 原生库导出中存在 `libpaddleocr.so`、`libonnxruntime.so`、`libncnn.so`、`libopencv_java4.so`、`libengine.so` 等，覆盖多个 ABI。库名只能作为组件线索，尚未确认实际加载链及调用关系。

### 3. JNI/引擎边界

证据文件：`android-automation/apk-analysis/java/com/main/engine/Engine.java`

可见的 native 声明包括 `init`、`onTouchEvent`、`paddleOcr`、`pause`、`resume`、`reset`、`sendEvent`。Java 层另有截图字节、XML、事件和回调包装逻辑。具体参数语义、native 实现及能否从 APK 外部复用，仍需进一步追踪。

混淆辅助文件 `android-automation/apk-analysis/java/obfuscation/IL1Iii.java` 中，`IL1Iii(byte[], String)` 对字节数组按循环密钥执行 XOR 后构造字符串。这可用于后续解混淆字符串分析，但本轮未系统解码所有常量。

## 对项目目标的意义

- Qianye 导出代码具备“截图区域 → 原生 OCR → 文本/置信度/坐标 JSON”的潜在能力链，方向上可为自动化界面识别提供参考。
- 尚无证据证明该 OCR 对台服赛马娘 UI 有效；不能把 Qianye 内部接口当作已验证的通用 API。
- 与 LegendAI 的整合仍应区分：游戏状态来源、AI 决策输出、执行器动作接口。当前这轮没有确认 Qianye OCR 与 LegendAI 之间存在直接连接。

## 后续工作（优先级顺序）

1. 阅读 `LuaEngine.java` 及其调用者，追踪 Lua 脚本加载、初始化、截图与 OCR 调用生命周期。
2. 检查 `lua.zip` 内部目录/脚本清单，并追踪 `script.lrj` 的读取入口与格式；在格式未明前不假设其为普通 Lua 源码。
3. 追踪 OCR 模型路径的字符串解码、文件创建/下载/解压调用，定位模型实际存放位置和 `keys.txt` 传入参数。
4. 将 `Engine`/OCR 的 JNI 声明与 `libengine.so`、`libpaddleocr.so` 等对应起来；若静态证据不足，标记为需要本地只读二进制分析，而不是臆测。
5. 最后才评估可复用边界，并以台服实际截图单独验证 OCR 准确率；不能因库存在就宣称验证通过。

### 4. OCR 模型运行时路径与初始化检查

新增证据文件：
- `android-automation/apk-analysis/qianye-export/sources/I1I/I1I/ILil/L11I.java`
- `android-automation/apk-analysis/qianye-export/sources/I1I/I1I/ILil/l1IIi1.java`
- `android-automation/apk-analysis/qianye-export/sources/I1I/I1I/p008IL/lIlii.java`
- `android-automation/apk-analysis/qianye-export/sources/com/p000nx/assist/lua/PaddleOcr.java`

观察：
- `L11I.m9501()` 将 `I11li1()` 返回的目录设为应用 `filesDir/assets`；`PaddleOcr.loadModel(...)` 在该目录下再拼接 `paddle`。因此 Java 层期望的模型运行时目录为 **`Context.getFilesDir()/assets/paddle/`**，不是仓库导出目录的直接路径。
- ONNX 模式期望 `det.onnx`、`cls.onnx`、`rec.onnx`、`keys.txt`；NNCC 模式期望 `det.param`、`rec.param`、`det.bin`、`rec.bin`、`keys.txt`。这是由混淆字符串解码与路径拼接直接得到的文件名。
- `L11I.I11L().I11li1()` 返回的是运行时 `assets` 目录。仓库导出树中 `resources/assets/paddle/keys.txt` 的存在不能单独证明模型文件已复制到上述运行时目录。
- `loadModeImp(...)` 的存在性检查存在疑似遗漏：ONNX 分支重复检查第一个路径而未检查 `cls.onnx`；NNCC 分支未检查 `rec.param`。这只是静态代码问题，运行时影响尚未验证。
- `lIlii.m1194llI11I(...)` 的已读实现围绕 native library 文件、临时文件/标记文件及 `System.load(...)` 展开，不能据此将其认定为 OCR 模型文件的下载或解压入口。

## 本轮结论与限制

- 状态：路径构造与文件名解码 `PASS`（静态）；模型实际部署来源 `NOT_VERIFIED`。
- 尚未定位：将 APK 打包资源 `resources/assets/paddle/keys.txt` 或模型文件复制到 `filesDir/assets/paddle/` 的完整调用链；也未确认模型是否由其他目录、动态下载或原生组件提供。
- 本轮仅只读 GitHub 源码；未执行 APK、原生库或游戏，没有运行 GitHub Actions。

## 状态

- 已完成：Java OCR 接口、模型文件名解码、运行时目录构造的静态核查。
- 未完成：模型文件从打包资源到运行时目录的来源链、Lua 调用链、JNI 原生实现映射、台服截图准确率验证。
- 限制：GitHub Actions 额度耗尽；后续优先使用 GitHub 文件读取和静态分析，不触发 Actions。
