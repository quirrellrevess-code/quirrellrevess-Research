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


### 5. APK assets 到运行时 OCR 目录的复制链（静态确认）

新增证据文件：
- `android-automation/apk-analysis/qianye-export/sources/I1I/I1I/p008IL/lIlii.java`
- `android-automation/apk-analysis/qianye-export/sources/com/main/engine/Engine.java`
- `android-automation/apk-analysis/qianye-export/sources/I1I/IL1Iii.java`

观察：
- 解混淆后确认 `lIlii.L1ii1(Context)` 会以 `Context.getFilesDir()` 为根创建 `assets`、`assets/tessdata` 和 `assets/paddle` 目录。
- 该方法调用 `lIlii.m1192lL(Context, String, File)`：通过 `context.getAssets().open(sourcePath)` 读取 APK AssetManager 中的指定资源，再写入目标文件。这是明确的 APK assets → app 私有文件目录复制实现，而不是 native library 加载。
- 静态解码得到它计划复制的 OCR 资源路径包括 `assets/paddle/det.bin`、`assets/paddle/det.param`、`assets/paddle/rec.bin`、`assets/paddle/rec.param`、`assets/paddle/keys.txt`，以及 `assets/paddle/det.onnx`、`assets/paddle/cls.onnx`、`assets/paddle/rec.onnx`。同一方法还处理 `assets/models.zip`、`assets/lua.zip` 和 Tesseract 字典文件。
- 这解释了 OCR 代码所需运行时目录的预期来源：由 APK AssetManager 复制到 `filesDir/assets/paddle/`。但当前导出 Git tree 的 `resources/assets/paddle/` 仍只显示 `keys.txt`，没有这些模型二进制文件；因此只能确认 Java 复制逻辑和所引用的资源路径，不能确认导出包中实际含有所有资源，也不能确认该方法在正常启动流程中一定被调用。
- `Engine.extractApkAssets(...)` 走另一条 ZIP/归档读取路径，调用 `lIlii.m1184L1l(...)`；其实现遍历归档条目并按前缀匹配写入目录。当前没有证据证明它是 OCR 模型的主复制入口。此前检查的 `m1194llI11I(...)` 仍属于 native library 加载辅助路径，不应混为模型资源复制。

## 更新后的状态与下一步

- `PASS`（静态）：发现 AssetManager 复制函数、解码出 OCR 资源源路径及其目标目录关系。
- `NOT_VERIFIED`：模型二进制是否确实存在于原 APK 的 AssetManager、`L1ii1(Context)` 的启动调用点及调用时机、模型复制后能否成功加载。
- 下一步优先追踪 `L1ii1(Context)` 的调用者/初始化生命周期，并核对 `resources/assets` 导出是否遗漏大文件；随后继续 Lua 初始化与 `PaddleOcr.loadModel` 调用链。仍只读 GitHub，不触发 Actions，不运行 APK 或游戏。


### 6. 资源复制函数的启动调用点

新增证据文件：
- `android-automation/apk-analysis/qianye-export/sources/com/main/app/App.java`
- `android-automation/apk-analysis/qianye-export/sources/I1I/I1I/p008IL/lIlii.java`

观察：
- `App.onCreate()` 调用 `lIlii.IL1Iii(this)`。
- `lIlii.IL1Iii(Application)` 完成若干初始化与门控检查后，明确调用 `L1ii1(application)`；因此资源复制函数不是完全孤立的死代码，而是应用正常初始化路径上的一个调用点。若前面的 `m1188iIIi1(application)` 检查失败，该初始化方法会提前返回，后续复制流程不会执行。
- `L1ii1(Context)` 在源 APK 文件存在时创建 `filesDir/assets` 及子目录，并对多个 AssetManager 资源调用 `m1192lL(...)`。但复制调用返回值在可见代码中未用于统一失败判定，不能仅凭调用存在就断言每个资源复制成功。
- 递归 Git tree 对 `resources/assets/paddle/` 的检查仍只列出 `keys.txt`。因此，代码引用模型资源与仓库导出中缺少模型文件是并存的证据；应继续核查导出流程/原 APK AssetManager 实际资源，而不是推断模型一定存在或一定不存在。

## 更新后的状态

- `PASS`（静态）：已追到 `App.onCreate()` → `lIlii.IL1Iii(Application)` → `L1ii1(application)` 的初始化调用路径。
- `NOT_VERIFIED`：初始化门控在实际运行中是否通过、各 AssetManager 资源是否存在及复制成功、OCR 模型是否被调用加载。
- 下一步：检查 `PaddleOcr` 是否由 Lua 绑定/反射调用、`LuaEngine` 如何加载脚本，以及 `script.lrj` / `lua.zip` 的实际加载入口；静态 Java 搜索未发现直接的 `PaddleOcr.loadModel(...)` 调用点，不能排除 Lua 侧动态调用。


### 7. Lua 到 Java 的动态反射能力边界

新增证据文件：
- `android-automation/apk-analysis/qianye-export/sources/com/p000nx/assist/lua/LuaNative.java`
- `android-automation/apk-analysis/qianye-export/sources/com/p000nx/assist/lua/LuaEngine.java`
- `android-automation/apk-analysis/qianye-export/sources/com/main/engine/Engine.java`
- `android-automation/apk-analysis/qianye-export/sources/I1I/I1I/ILil/L11I.java`

观察：
- `LuaNative.checkMethod(...)` 会通过反射枚举目标对象/类的 declared methods 与 public methods，并缓存匹配的方法；`LuaNative.callMethod(...)` 将 Lua 栈参数转换为 Java 参数，再通过 `Method.invoke(...)` 执行。这证明该 Lua bridge 具备动态调用 Java 方法的通用机制。
- `LuaEngine` 提供截图、插件加载等 Java 包装接口；`Engine` 也暴露 `paddleOcr(Object)` native 声明，并通过 `LuaEngine.snapShot(...)` 提供截图字节获取路径。
- 因此，直接 Java 源码搜索没有找到 `PaddleOcr.loadModel(...)` 调用点，并不能排除 Lua 侧通过动态反射/绑定调用 OCR 类的可能性。但当前尚未找到实际 Lua 脚本中调用该类或方法的证据，也未确认原生 Lua VM 如何向脚本暴露类名与对象。
- `Engine.installLR(String)` 调用 `L11I.I11L().m942LlLLL(str)`，表明存在一个脚本/规则安装入口；当前未完成对该方法所处理文件格式与 `script.lrj` 的对应关系验证，不能把它直接认定为 OCR 脚本加载入口。

## 状态与下一步

- `PASS`（静态）：确认 LuaNative 的通用 Java 反射调用能力；确认 `Engine.installLR` 的调用链入口。
- `NOT_VERIFIED`：Lua 脚本是否实际调用 `PaddleOcr.loadModel`、Lua VM 的类绑定规则、`script.lrj` 格式与加载关系。
- 下一步：追踪 `L11I.m942LlLLL` 的核心代理调用与 `script.lrj`/`lua.zip` 的文件读取点；同时检查 native/JNI 注册或脚本绑定表，确认 Java 类是否对 Lua 可见。仍不运行 APK/游戏，不触发 Actions。


### 8. installLR 文件传递链与核心服务边界（静态）

新增/复核证据：
- `qianye-export/sources/com/main/engine/Engine.java`
- `qianye-export/sources/I1I/I1I/ILil/L11I.java`
- `qianye-export/sources/I1I/I1I/ILil/ILL.java`
- `qianye-export/sources/android/app/INXCoreNative.java`
- `qianye-export/sources/com/p000nx/assist/lua/LuaEngine.java`

观察：
- `Engine.installLR(String)` 仅捕获异常并转调 `L11I.I11L().m942LlLLL(str)`，异常时返回 false。
- `L11I.m942LlLLL(String)` 以输入字符串作为源路径，调用 `this.f971IL.m868lIlii(str, destinationPath)`；复制成功后调用 `this.f971IL.I11L(8, 0, 0, destinationPath)`，并根据返回字符串是否等于解码后的字符 `"0"` 决定 true/false。成功分支还会 sleep 600000 ms，属于该方法可见行为的一部分。
- `ILL.m868lIlii(String,String)` 通过 `FileInputStream` 读取源文件，并经 `INXCoreNative.openFile/writeFile/closeFile` 将内容写到核心服务提供的文件句柄。反向方向的 `ILL` 方法也可从核心服务文件句柄读回内容。由此可确认这里存在跨进程/核心服务文件传输层，而非直接在该方法中解析 Lua。
- `LuaEngine` 暴露 `getPluginApp()`、`getResPath()`、`registerPluginApp(Object)`、`snapShot(...)` 等包装接口；当前可见文件中未找到 `script.lrj` 或 `lua.zip` 的直接加载调用点。
- `LuaNative` 的通用反射能力仍只是“机制存在”。没有证据证明 Lua 脚本已拿到 `PaddleOcr` 类，也没有证明 `installLR` 的输入就是 `script.lrj`。

状态：
- `PASS`（静态）：确认 `installLR → m942LlLLL → m868lIlii → INXCoreNative 文件接口` 的传递链。
- `NOT_VERIFIED`：目标路径的实际解码值、核心服务对操作码 8 的语义、`script.lrj` 与该接口的对应关系、Lua VM 的类绑定/JNI 注册规则、OCR 模型是否实际加载。
- 下一步：优先定位 `INXCoreNative` 的服务端实现或 native 注册表，以及 `script.lrj` / `lua.zip` 的消费者；若仓库导出缺少服务端/native 二进制证据，应明确记录静态分析边界，不用猜测补齐。仅 GitHub 只读分析，不触发 Actions，不运行 APK/游戏。


### 9. Lua 运行时启动链与 JNI 证据边界

新增证据文件：
- `qianye-export/sources/com/main/app/NativeService.java`
- `qianye-export/sources/com/main/engine/ScriptMain.java`
- `qianye-export/sources/com/main/engine/Engine.java`
- `qianye-export/sources/com/p000nx/assist/lua/LuaEngine.java`
- `qianye-export/sources/com/p000nx/assist/lua/LuaNative.java`
- `qianye-export/resources/lib/{arm64-v8a,armeabi-v7a,x86}/libengine.so`
- 同目录各 ABI 的 `libnative.so`、`libpaddleocr.so`

观察：
- `NativeService` 启动流程会调用 `ScriptMain.main(...)`。在 `ScriptMain.main` 中，当第一个参数解析为 1 时，代码调用 `lIlii.ILil()`、`LuaEngine.Init(...)` 及相关上下文初始化；随后创建 `L11I` 核心脚本对象并进入 Looper。由此能确认存在 Lua 运行时/核心脚本服务的初始化路径，但还未追到实际脚本字节的读取与执行函数。
- 导出资源目录确实包含多个 ABI 的 `libengine.so`、`libnative.so`、`libpaddleocr.so`。Java 层的 `Engine` 与 `LuaNative` 有多个 native 方法声明；然而当前 GitHub 文件树中的相关实现是二进制共享库，未见可直接检索的 JNI C/C++ 源码或注册表，因此不能静态确认 native 层如何注册 Lua API、加载 `script.lrj`，或调用 `PaddleOcr.loadModel`。
- 当前可见的 `ScriptMain`、`LuaEngine` 与 `LuaNative` 代码中未找到 `script.lrj` / `lua.zip` 的直接读取调用。文件存在于导出资源树，不等于已证明运行时会读取它们。

状态：
- `PASS`（静态）：确认 NativeService → ScriptMain → LuaEngine.Init 的初始化链；确认仓库导出包含 engine/native/paddleocr 原生库。
- `NOT_VERIFIED`：脚本文件读取/解码/执行点、JNI 注册映射、Lua 脚本可见的 Java 类清单、OCR 模型实际加载与识别效果。
- 下一步：从可读 Java 侧继续追踪 `L11I`/核心服务的脚本文件读取 API；如读取/解释发生在共享库内部，需有针对共享库的静态分析结果才能继续，不能把 Java native 声明当作实现证据。只读 GitHub；不运行 APK/游戏，不触发 Actions。
