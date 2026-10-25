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


### 10. sendCmd(8) 的 Java 侧分发已追到事件 99

新增证据：
- `qianye-export/sources/I1I/I1I/ILil/iIilII1.java`（`sendCmd` 实现，约 1621 行起）
- `qianye-export/sources/I1I/I1I/ILil/LLL.java`
- `qianye-export/sources/com/main/engine/CoreProvider.java`
- `qianye-export/sources/android/app/INXCoreNative.java`

更新后的结论：
- `L11I.m942LlLLL(source)` 先把输入文件写到核心服务文件路径，再调用 `ILL.I11L(8, 0, 0, destinationPath)`。
- `ILL.I11L(...)` 通过 Binder 接口转到 `INXCoreNative.sendCmd(...)`；Java 侧可见实现位于 `iIilII1.sendCmd`。当第一个参数 `i == 8` 时，它调用 `p051lLi1LL.ILil.IL1Iii.I1I.I1I().ILL(new IIi(99, str, ""))`，随后返回解码后字符串 `"0"`。因此可确认：该调用在 Java 侧把目标文件路径作为参数转发给事件编号 99，并立即返回成功码；这也解释了 `m942LlLLL` 为什么比较返回值是否为 `"0"`。
- 这比“未知操作码”更具体，但事件 99 的最终消费者/处理器仍未确认。当前证据只支持“事件分发并返回成功码”，不支持声称文件已经被 Lua 解析或执行。
- `L11I.m942LlLLL` 在返回码为 `"0"` 时还会同步 `Thread.sleep(600000L)`，即等待约 10 分钟后才返回 true；这是可见的阻塞行为，不能把它误读为脚本执行耗时的测量。

状态：
- `PASS`（静态）：确认 installLR 文件传输 → Binder sendCmd(8) → Java 侧事件 99（参数为目标文件路径）→ 返回 `"0"`。
- `NOT_VERIFIED`：事件 99 的订阅者与业务语义、该路径对应文件格式、是否触发 Lua 加载/执行、JNI/native 层是否另有处理。
- 下一步：追踪事件总线 `p051lLi1LL.ILil.IL1Iii.I1I.I1I().ILL(...)` 的事件 99 消费端及相关监听注册。仍仅做 GitHub 只读分析，不运行 APK/游戏，不触发 Actions。


## 2026-10-25 补充：事件 99 的事件类型确认

- 已定位事件对象源码：`qianye-export/sources/I1I/I1I/ILil/IIi.java`，反编译注释标记原始类名为 `MessageEvent`。构造参数依次写入整数事件码、字符串参数 1、字符串参数 2；对应 getter 分别返回这三个字段。
- `iIilII1.sendCmd(...)` 的 code=8 分支发布 `new IIi(99, str, BuildConfig.FLAVOR)`，因此事件 99 的第二字段是刚复制到 Core 文件区的目标路径，第三字段是构建 flavor（当前反编译表达式为 `BuildConfig.FLAVOR`，不能直接假定其运行值为空）。
- 事件总线 `p051lLi1LL.ILil.IL1Iii.I1I` 的 `ILL(Object)` 是通用同步/队列式发布入口；这只是分发机制，不等于已找到事件 99 的业务订阅者。
- **当前结论：** 已确认“文件复制 → sendCmd(8) → MessageEvent(code=99, path, flavor) 发布 → 返回字符串 0”的 Java 侧链路；尚未定位订阅者，也未证明该路径会被 Lua 读取、解析或执行。继续静态搜索 `I1I.I1I.ILil.IIi` 的订阅方法/注册位置，不触发 Actions、不运行 APK。


### Event 99 subscriber trace update (2026-10-25)
- Confirmed event payload class: `android-automation/apk-analysis/qianye-export/sources/I1I/I1I/ILil/IIi.java`, JADX identifies it as `MessageEvent`; constructor accepts `int, String, String`, matching the dispatch `new IIi(99, targetPath, BuildConfig.FLAVOR)`.
- The event bus implementation is `p051lLi1LL.ILil.IL1Iii.I1I` (JADX identifies it as EventBus); its `ILL(Object)` method posts events and dispatches to registered subscribers.
- Current static source pass has not yet located a subscriber method whose parameter type is `IIi`, nor confirmed any handler for code 99. Therefore, whether the copied file is parsed or executed remains NOT_VERIFIED. Do not infer execution from the command's `"0"` response.
- Method: GitHub source inspection only; no APK execution, local PowerShell, game interaction, or GitHub Actions run.


### Event 99 subscriber search pass 2 (2026-10-25)
- Rechecked the exported Java tree (2,159 Java source files) and the likely obfuscated event-bus/package candidates on GitHub. The event class `I1I.I1I.ILil.IIi` is confirmed as `MessageEvent`; the EventBus implementation is present, but this pass did not produce a confirmed subscriber method for `IIi` or a handler branch for event code 99.
- This is a bounded static search, not proof that no subscriber exists: obfuscation, reflection, omitted export files, or handlers in native/script assets may hide the consumer. File parsing/execution remains NOT_VERIFIED.
- Next evidence target: enumerate EventBus registration call sites and inspect candidates that register runtime/core objects, then follow the registered subscriber methods. Do not claim the file is executed until a concrete consumer path is identified.
- No local execution, PowerShell, game actions, or GitHub Actions were used.



### Event 99 subscriber search pass 3 (2026-10-25)
- Read the EventBus dispatch and subscriber-discovery implementation directly:
  - `I1I.ILL(Object)` queues/posts an event.
  - Dispatch checks the event object's runtime class (and, when enabled, its superclass/interface hierarchy) against the registered subscriber map; it does not itself interpret the numeric `MessageEvent` code.
  - `I1I.Lil(Object)` is the registration path: it asks the subscriber-method finder to inspect the object's class and registers discovered handlers.
  - The finder `llL1ii` identifies public, non-static, non-abstract methods with exactly one parameter and the custom `@Subscribe` annotation; it can also use generated subscriber metadata when available.
  - The dispatch invokes the annotated method for the event class `IIi`; therefore a consumer may branch on `event.I1I() == 99` inside a generic `MessageEvent` handler rather than declare a method specifically for code 99.
- This narrows the next search: find call sites of `I1I.I1I().Lil(object)` / equivalent registration calls and inspect registered objects for `@Subscribe` methods accepting `IIi`; then look for a code-99 branch and path handling.
- This pass still has not identified a concrete registered consumer or proved file parsing/execution. Event 99 remains a generic event dispatch, and the earlier `"0"` return is not evidence that the file ran.
- Evidence was read from `qianye-export/sources/p051lLi1LL/ILil/IL1Iii/I1I.java` and `qianye-export/sources/p051lLi1LL/ILil/IL1Iii/llL1ii.java` on the target branch.
- GitHub source inspection only; no local PowerShell, APK/game execution, game interaction, or GitHub Actions run.



### Event 99 subscriber located: MainService (2026-10-25)
- **Confirmed consumer:** `android-automation/apk-analysis/qianye-export/sources/com/main/app/MainService.java`.
- In `MainService.onCreate()` (around line 502), the service registers itself with `p051lLi1LL.ILil.IL1Iii.I1I.I1I().Lil(this)`. It unregisters itself in `onDestroy()` via `m3670llL1ii(this)`.
- `MainService.onMessageEvent(IIi)` is annotated with the custom `@Subscribe` annotation and runs on `ThreadMode.MAIN`. Its event-code-99 branch calls `m3464lIiI(iIi.IL1Iii())`, passing the path field from `MessageEvent`.
- `m3464lIiI(path)` checks for a non-empty path and whether the file exists. If it exists, it attempts `renameTo(new File(this.f2875iILLL1))`. On rename failure it logs and calls `mo1027il(7)`; on success it updates a timestamp/observer through `llL1ii.IL1Iii().Ilil(new File(this.f2875iILLL1).lastModified(), this)`. After the file-handling branch it sets `this.f2872IiL = true` and calls `mo1027il(9)`. If the source path is missing, it calls `mo1027il(8)` and returns.
- The destination field `f2875iILLL1` is initialized in `MainService.onCreate()` using `lIlii.m1132LIl(this, ... , false)`; the exact decoded path is not asserted in this note because the obfuscated string expression has not been independently decoded.
- **Meaning of this evidence:** event 99 is not an unhandled generic event. A registered Java consumer receives the transferred path and attempts to move/replace the file at the service's configured destination, then signals state/status 9 after the file-handling path. This establishes a concrete file-install/activation handoff.
- **Still NOT_VERIFIED:** whether the destination file is a Lua/script payload, whether a watcher or native runtime subsequently reads/parses/executes it, and what status 9 means beyond the visible call path. The `renameTo` and status call alone do not prove script execution.
- Sources read: `com/main/app/MainService.java` (registration, annotated handler, `m3464lIiI`, destination initialization), `p051lLi1LL/ILil/IL1Iii/I1I.java` (EventBus registration/dispatch), and `I1I/I1I/ILil/IIi.java` (`MessageEvent` fields).
- GitHub-only static analysis; no local PowerShell, APK/game execution, game interaction, or GitHub Actions run.


### Event 99 destination and timestamp helper clarified (2026-10-25)

新增静态证据：
- `qianye-export/sources/I1I/I1I/p008IL/lIlii.java`（`m1132LIl(Context,String,boolean)`）
- `qianye-export/sources/I1I/I1I/ILil/llL1ii.java`（文件头注释：`FileChangeMgr`）
- `qianye-export/sources/com/main/app/NativeService.java`
- `qianye-export/sources/com/main/engine/ScriptMain.java`
- `qianye-export/sources/com/p000nx/assist/lua/LuaEngine.java`

观察与修正：
- `lIlii.m1132LIl(context, name, false)` 的可见实现仅构造 `new File(context.getFilesDir(), name)` 并返回其绝对路径；参数为 `false` 时不要求文件已存在。由此确认 `MainService.f2875iILLL1` 指向应用私有 filesDir 下的一个文件，但混淆字符串所代表的文件名尚未解码确认。
- 需要区分两个包名不同、简单类名相同的 `llL1ii`：
  - `p051lLi1LL.ILil.IL1Iii.llL1ii` 是 EventBus 的订阅方法发现器（JADX 注释为 `SubscriberMethodFinder`），不是文件监听器。
  - `I1I.I1I.ILil.llL1ii` 是 `FileChangeMgr`。其 `Ilil(long, Context)` 忽略传入的 long 值，调用 `m1033IL(context, System.currentTimeMillis())`，把当前时间写入 `context.getFilesDir()` 下的序列化记录文件。当前源码没有显示它监听目标文件、调用 Lua 或触发脚本执行。
- 已确认 `NativeService.onCreate()` 调用 `LuaEngine.Init(this)`；其线程入口创建 `ScriptMain` 并调用 `ScriptMain.main(...) `。当参数首项为 1 时，`ScriptMain.main` 初始化 `LuaEngine`、创建 `L11I` 核心脚本对象并进入 Looper。这证明应用存在独立的 Lua/核心脚本运行时启动路径，但尚未把事件 99 替换的目标文件与该运行时的实际读取/解析函数连接起来。
- 因此，事件 99 的已证实语义应表述为“Java 服务收到路径并尝试重命名替换私有目录目标文件，随后更新时间戳记录并发出状态通知”；不能表述为“文件变更监听器启动脚本”或“Lua 执行成功”。

状态：
- PASS（静态）：目标文件位于 `Context.getFilesDir()` 下；文件变更管理类仅被确认写入时间戳记录；确认 `NativeService → ScriptMain → LuaEngine.Init → L11I` 的运行时初始化链。
- NOT_VERIFIED：目标文件的真实文件名/格式、替换后文件的消费者、`L11I` 读取或解释该文件的具体函数、状态 9 的业务含义、Lua/native 实际执行链。
- 下一步：从 `I1I.I1I.ILil.L11I` 的构造函数和 `m940LlIl()` 开始追踪，结合 `m942LlLLL` 使用的目标路径及 `INXCoreNative` 文件接口，寻找读取/解码/执行入口；同时检查 `NativeService` 的调用参数如何传入 `L11I`。若证据进入仅有二进制的 native 库，应明确标注边界，不推测补齐。
- 执行边界：仅 GitHub 源码只读检查；未运行 APK/游戏、未使用本地 PowerShell、未触发 GitHub Actions。


### installLR 目标文件与核心脚本启动分支进一步连接 (2026-10-25)

新增证据：
- `qianye-export/sources/I1I/I1I/ILil/L11I.java`：构造函数、`m940LlIl()`、核心线程中的文件检查/解压/启动逻辑。
- `qianye-export/sources/com/main/app/NativeService.java`：`IL1Iii.run()` 向 `ScriptMain.main(...)` 传入六个参数，其中第六项来自该线程持有的字符串参数。
- `qianye-export/sources/com/main/engine/ScriptMain.java`：读取六个参数并用第六项构造 `L11I` 的最后一个参数。
- `qianye-export/sources/com/main/engine/Engine.java`：声明 native `Engine.start(long, int, String, String)`。

已证实的运行时分支：
- `L11I(int,int,int,String,String,String)` 将第六个参数赋给字段 `f975iILLL1`，并执行初始化。
- `L11I.m940LlIl()` 启动该对象的工作线程；线程中的相关逻辑检查 `new File(this.f975iILLL1).exists()`。
- 若该文件存在，代码调用 `Native.unZip(new File(this.f975iILLL1).getAbsolutePath(), this.ILL.getAbsolutePath())`，检查返回码；成功后调用 `Engine.start(0L, this.f972IiL, this.ILL.getAbsolutePath(), file2.getAbsolutePath())`。可见这是“文件存在 → native 解压到工作目录 → Engine.start” 的明确执行路径。
- 若该文件不存在，代码改走 `this.f971IL.m860ILl(this.f975iILLL1, new IiL(file2))` 的核心服务文件获取分支；在成功后同样会调用 `Engine.start(...)`。该分支的完整 native/服务端行为仍需进一步确认。
- `NativeService.IL1Iii.run()` 将持有的路径字符串作为 `ScriptMain.main` 的第六个参数；`ScriptMain.main` 将第六个参数传入 `new L11I(..., str3)`。因此可以确认，传给 `NativeService` 的路径会成为 `L11I.f975iILLL1`，而该字段确实被后续文件存在性检查、解压和引擎启动逻辑使用。
- `Engine.start` 本身是 native 声明，当前 Java 源码只证明调用发生；未凭 Java 声明推断 native 内部的 Lua 解释执行细节。

证据边界：
- 已证实：`f975iILLL1` 指向的文件若存在，会进入 `Native.unZip → Engine.start` 路径；`NativeService → ScriptMain → L11I` 的参数传递链成立。
- 尚未完全闭合：本轮未通过字符串解码/完整调用参数逐一比对，证明事件 99 中 `MainService.f2875iILLL1` 与某一次 `L11I.f975iILLL1` 在运行时必然是同一绝对路径；代码说明二者有明确的文件交接意图，但严格的路径同一性仍应标记为待验证。
- 尚未确认：归档内部文件的类型、`Engine.start` 在 native 层如何加载脚本、Lua 虚拟机实际执行哪个入口，以及状态 9 的精确定义。

状态：
- PASS（静态）：确认核心脚本对象的文件检查、`Native.unZip`、`Engine.start` 以及 `NativeService → ScriptMain → L11I` 的参数传递。
- NOT_VERIFIED：事件 99 目标与核心脚本路径的绝对路径同一性、native 解压后脚本执行细节、状态 9 的语义。
- 下一步：追踪 `iIilII1.m987i1I1I1l(this, str)` 如何启动 `NativeService` 并传入路径；检查 `Engine.start` 的 native 实现是否能从仓库已有的共享库分析材料中得到静态证据。若没有可读的 native 反汇编结果，则将其作为明确阻塞项记录。
- 执行边界：仅 GitHub 静态源码读取与文档归档；未运行 APK/游戏、未使用本地 PowerShell、未触发 GitHub Actions。


### MainService 启动请求到 NativeService 的参数传递链 (2026-10-25)

新增证据：
- `qianye-export/sources/com/main/app/MainService.java`：`m3461ILl(String, boolean)`。
- `qianye-export/sources/I1I/I1I/ILil/iIilII1.java`：`m987i1I1I1l(Context,String)`、内部 `L11I` 回调、`RunnableC0602il.run()`、`m986ill(Context,C1,String)`。
- `qianye-export/sources/com/main/app/NativeService.java`：Binder 绑定与 `ScriptMain.main(...)` 参数传递。

观察：
- `MainService.m3461ILl(str, z)` 在需要启动时把路径字符串传给 `iIilII1.LLL().m987i1I1I1l(this, str)`；空字符串时会先用 `MainService.f2875iILLL1` 作为默认路径。
- `iIilII1.m987i1I1I1l(context,str)` 经核心服务回调对象进入异步流程，最终由 `m986ill(context,c1,str)` 创建用于绑定 `NativeService` 的连接对象；该连接对象构造参数包含原始路径字符串。
- 在满足相关门控的分支中，`RunnableC0602il.run()` 对该路径调用 `Native.chmod(path)`，再调用核心服务接口 `c1.Ilil(3,0,0,path)`。这是可见的路径交接/权限处理行为；尚不能仅凭操作码 3 的调用认定脚本已运行。
- `NativeService` 的启动线程把收到的路径作为 `ScriptMain.main` 第六个参数，`ScriptMain.main` 将其交给 `L11I.f975iILLL1`。在 `L11I` 中，若该路径文件存在，则调用 `Native.unZip(path, workDir)`，随后调用 `Engine.start(..., workDir, file2)`；这建立了 Java 可见的“路径 → NativeService/ScriptMain → L11I → 解压 → Engine.start”调用链。
- 结合事件 99 的 `MainService.m3464lIiI(path)`，已经可以确认：事件处理会把传入文件重命名到 `MainService.f2875iILLL1`，而正常启动入口在路径为空时会默认选用这个字段，并将路径向核心服务/NativeService 传递。不过，事件 99 分支调用的是状态通知 `mo1027il(9)`，而非直接调用 `m3461ILl`；因此，不能声称状态 9 本身必然同步触发启动。严格的事件后续时序/状态机关系仍待追踪。

状态：
- PASS（静态）：确认 MainService 默认路径选择、向 ScriptEngine 管理对象传递路径、路径 chmod/核心服务操作码 3、NativeService 参数传递及 L11I 解压/Engine.start 分支。
- NOT_VERIFIED：事件 99 后状态 9 如何改变服务状态、该事件路径替换后是否在所有情形都会进入启动分支、native 的操作码 3 和 Engine.start 的内部语义。
- 下一步：追踪状态通知 `mo1027il(9)` 对应的核心服务状态更新，以及 `L11I` 的 `Native.unZip`/ `Engine.start` native 声明是否有仓库内可读实现或现成静态分析结果。若只有共享库二进制，则保留为阻塞项，不假定其内部行为。
- 执行边界：GitHub 源码只读检查与进度归档；没有运行 APK/游戏、没有本地 PowerShell、没有触发 GitHub Actions。


### Status 9 语义边界与 native/Lua 执行证据盘点 (2026-10-25)

新增检查：
- `qianye-export/sources/com/main/app/MainService.java` 的 `mo1027il(int)`。
- `qianye-export/sources/I1I/I1I/ILil/iIilII1.java` 的 `m982iI1LI()`。
- `qianye-export/sources/com/main/app/App.java` 的静态初始化块。
- `qianye-export/sources/com/main/app/Native.java`、`com/main/engine/Engine.java`、`com/p000nx/assist/lua/LuaNative.java`。
- 已有报告 `reports/UMA_SCRIPT_LRJ_INVENTORY.txt` 与当前分支资源树。

关键结论：
- 对 `MainService.m3464lIiI(path)` 成功分支，源码会设置 `f2872IiL = true` 并调用 `mo1027il(9)`。但 `mo1027il(int)` 不按参数值分支：它写日志、在必要时清除暂停状态，随后统一调用 `iIilII1.LLL().m982iI1LI()`。
- `iIilII1.m982iI1LI()` 尝试通过现有核心接口发出 `(4,0,0,"")`；没有该接口时，回退到 `InterfaceC0604lIII.mo1027il(12)` 或 `C1.Ilil(4,0,0,"")`。因此，状态 9 是传入的日志/状态编号，不能直接解释为“脚本执行成功”。此处只能证明成功替换文件后会发出通用核心状态通知；具体状态机效果仍未解码。
- `App.java` 的静态块调用三次 `System.loadLibrary(obfuscatedName)`。当前 Java 源码的字符串仍为混淆解码表达式；资源树中存在 `libengine.so` 与 `libnative.so`（以及 OCR/视觉等其他库），但当前仓库检索到的资料没有给出这两个目标 native 函数的反编译实现或 JNI 符号映射。因此 `Native.unZip` 和 `Engine.start` 的内部细节仍然是 native 边界。
- `LuaNative.java` 暴露 Lua C API 风格的 native 方法，包括 `newthread`、`pcall`、`getGlobal`、`setGlobal`、栈操作和类型查询；这是 Java 层与 Lua native runtime 接口存在的直接证据，但本轮未找到把归档中的某个 Lua 入口文件传给这些 API 的具体调用点。
- 现有 `UMA_SCRIPT_LRJ_INVENTORY.txt` 记录了一份 `script.lrj` 的 ZIP 清单，其中包含 `entry.json`、多个 `.lua` 项，且选中 Lua 项以 `1B 4C 75 61`（Lua bytecode 签名）开头。该报告可以证明仓库已有一份 Lua 归档样本的静态清单；**不能单凭文件名相似认定它就是当前 `L11I.f975iILLL1` 指向的同一文件**，路径与 SHA/来源对应关系尚未闭合。

当前证据分级：
- PASS（静态）：事件 99 的文件存在检查与重命名；目标文件存在时的 `Native.unZip → Engine.start` 分支；路径经 `MainService → iIilII1 → NativeService → ScriptMain → L11I` 传递；Java 层存在 Lua native API；状态 9 并非显式“执行成功”分支。
- BLOCKED / NOT_VERIFIED：`Native.unZip`、`Engine.start` 的 native 实现；加载的库名和 JNI 绑定细节；`script.lrj` 样本与目标路径是否同一归档；归档入口是否被 native Lua runtime 实际加载/执行。
- 下一步：在现有仓库静态材料中检查 `libengine.so` / `libnative.so` 是否有已生成的符号表、字符串提取或反汇编报告；若没有，则不再把 Java 声明当成执行证据，并把 native 反编译作为明确阻塞。若能定位现有 `LuaEngine`/ `LuaNative` 的 Java 调用点，再尝试将归档入口与运行时 API 建立静态调用关联。
- 执行边界：仅 GitHub 源码与已提交报告只读检查，更新本进度文档；未运行 APK/游戏、未使用本地 PowerShell、未触发 GitHub Actions。
