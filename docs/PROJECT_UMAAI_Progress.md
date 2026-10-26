# UmaAI-Research 项目进度与自动归档规则

- 仓库：`wosafety0/UmaAI-Research`（Private）
- 仓库地址：https://github.com/wosafety0/UmaAI-Research
- 本文档：`docs/PROJECT_UMAAI_Progress.md`
- 本轮归档日期：2026-10-25（+08:00）
- 当前研究分支：`analysis/qianye-reverse-engineering-20261025`
- 本地工作目录：`D:\Games\ai\UmaAI-Research`
- 归档原则：聊天不是长期项目档案；每轮有持久价值的结论都应及时提交到 GitHub，并远端回读验证。

## 1. 项目专属目标与边界

### 主要目标

将现有赛马娘游戏数据链与 LegendAI/传奇杯 AI 的建议连接起来，减少人工逐步操作。优先复用现有 AI 的决策，不另行重造其训练策略。

### 目标平台与研究范围

- 台服：主要实机验证和功能开发目标。
- 日服：用于提前研究未来内容、页面和识别变化。
- 国服：排除在项目目标之外。
- 目前的自动化技术路线以 Windows Python 控制器、Android 模拟器 ADB、截图/OCR/OpenCV、育成状态机为一条可选执行路径；具体工作应以当前任务分支及已验证的部署条件为准，不把架构计划误报为已实现功能。
- LegendAI/传奇杯 AI 是当前核心决策源，但其策略按脚本/模式适用，不应泛化为所有剧本的通用决策器。
- Hachimi Edge 的 HTTP 转发已被源码研究确认是游戏请求/响应的旁路观察链，不是已确认的动作提交接口。
- AIRedirector 的现有 UmaAI stdout 处理路径是推荐输出桥接的优先研究接入点；尚未完成端到端连接前，不得声称外部 Bot 已能稳定读取建议。
- 默认影子模式和只读研究。未知协议、未知动作、回合不匹配、执行结果不确定时必须 fail-closed；未经独立验证不得发送或重放游戏操作。

## 2. 每轮自动归档规则

每轮工作结束时，自动将可长期复用的结论、已验证结果、阻塞原因、安全状态和下一步计划记录到本仓库。不得依赖用户再次提醒。

### Step A — 读取远端最新文档

1. 使用当前环境可用的 GitHub 连接器，读取本文件在目标分支上的完整内容及 Blob SHA。
2. 如本轮更新另一份专题文档，也必须先读取该文件的远端最新版本与 Blob SHA。
3. 以实际任务所在分支为准；不要把其他项目（尤其 KancolleBot）的仓库、分支或文档路径混入本项目。
4. 如果目标分支或文件不存在，先核实仓库 tree 和分支状态，再决定创建新文件；不能把“读取不到”直接解释为文件或分支不存在。

### Step B — 整理本轮结果

采用固定结构记录：

- 日期和任务名称
- 仓库、分支、目标路径及基线 commit
- 执行模式：`READ_ONLY` / `WRITE` / `TEST`
- 检查对象、实际执行的步骤和证据文件
- 状态：`PASS` / `FAILED` / `NOT_VERIFIED`
- 错误、阻塞原因和资源限制
- 安全边界、未执行事项及未验证假设
- 结论适用范围和局限
- 下一步优先级

必须明确区分：

- 已执行与仅计划执行
- 本地成功与 GitHub 远端成功
- 预检通过与实际功能验证通过
- 没有发现匹配项与证明目标不存在
- 静态代码/字符串证据与运行时行为证据
- 文件/接口存在与接口可复用、功能可用
- 代码编译成功与游戏端到端测试成功

### Step C — 更新 GitHub 文档

1. 优先更新相关专题文档；跨任务的稳定结论再汇总到本进度文档，避免复制整篇报告造成多个事实源。
2. 对已有文件，使用 Step A 读取到的当前 Blob SHA 进行更新，提交完整的新文件内容，而不是仅提交片段。
3. 对确实不存在的新文件，使用创建文件操作；创建前先检查远端 tree。
4. 提交信息应简洁说明研究主题与结果；不要把计划中的动作写成已经执行。
5. 若 Blob SHA 冲突或远端版本已变化，重新读取最新文件并合并后再更新；不得覆盖未读取的版本。
6. 不因归档需要而触发 GitHub Actions。当前已知 Actions 额度耗尽；除非明确核实额度恢复，否则只采用静态 GitHub 文件/源码读取和必要的文件提交。
7. GitHub 网络操作沿用项目已确定的 Clash HTTP 代理 `http://127.0.0.1:7890`；不测试其他端口，不改全局代理设置，不重复失败上传尝试。

### Step D — 远端回读核验

更新或创建后，重新读取同一分支、同一路径，核对：

1. 本轮记录标记及关键结论完整存在。
2. 远端回读内容与提交的完整内容一致。
3. 远端回读的 Blob SHA 与更新/创建后实际文件 Blob SHA 一致。
4. Commit SHA 由实际工具返回，并通过 GitHub 远端 commit 元数据或等价可用证据核实。
5. 如果工具无法提供某一项验证，明确写为 `NOT_VERIFIED`，不能以提交请求成功代替远端核验。

只有远端内容、Blob SHA 和 Commit SHA 的可核实检查均通过，才报告 `GITHUB_ARCHIVE: PASS`。提交失败、回读不一致或工具不可用时，报告 `FAILED` 或 `NOT_VERIFIED`，并说明具体原因。

### Step E — 输出简洁结果

每轮完成后至少输出：

- 仓库、分支、文档路径
- Commit SHA、Blob SHA
- 远端回读核验状态
- 本轮最重要的已验证结论
- 未解决问题、阻塞原因和下一步

如果本轮没有值得归档的新结论，也要明确说明本轮未更新 GitHub 的原因；不得为了形式而制造虚假进度。

## 3. 当前已知 GitHub 归档状态

### Qianye APK 静态分析记录

- 专题记录：`android-automation/apk-analysis/reports/QIANYE_REVERSE_ENGINEERING_PROGRESS_20261025.md`
- 分支：`analysis/qianye-reverse-engineering-20261025`
- 分析基线：`1a66f92f9058849735649cd37a9d18816b9965f5`
- 已知提交：`c3abc55400f158151880f6ac69debdceef31d3e9`
- 已知文件 Blob SHA：`020b248f091aab01ee254a12c30280a1b49e83b4`
- 已记录内容：OCR Java 接口、相关资源和原生库清单、JNI 声明线索、适用范围、未验证事项及后续优先级。
- 以上是先前工具回读验证过的专题记录；每次后续更新前仍须重新读取目标文件的当前远端版本和 SHA。

### 近期静态分析的核心结论

- APK Java 层存在截图区域、OCR 调用和带文本/置信度/矩形坐标的 JSON 结果接口线索；尚未证明外部 Python 可直接调用，也未验证台服截图识别精度。
- `resources/assets/paddle/keys.txt` 存在；静态解码确认 OCR 代码期望的运行时模型目录为应用 `filesDir/assets/paddle/`，但打包资源如何进入该目录、模型是否实际部署仍未确认。
- `script.lrj` 格式/用途未明，`lua.zip` 内容待查。
- `libpaddleocr.so`、`libonnxruntime.so`、`libncnn.so`、`libopencv_java4.so`、`libengine.so` 等原生库存在于导出清单；具体调用链仍待核实。
- 当前结论属于仓库静态证据，不代表已执行 APK、已调用原生库、已完成模拟器测试或已连接 LegendAI。

## 4. 当前阻塞与后续优先级

1. 继续追踪 `LuaEngine.java` 及调用者，确认 Lua 初始化、脚本加载、截图与 OCR 生命周期。
2. 只读检查 `lua.zip` 的目录清单，并追踪 `script.lrj` 的读取入口和格式；在证据不足时不假定其为普通 Lua 源码。
3. 已确认 Java 层通过 `lIlii.m1192lL(Context, String, File)` 从 APK AssetManager 复制 `assets/paddle/det.bin`、`det.param`、`rec.bin`、`rec.param`、`keys.txt` 及 ONNX 变体到 `filesDir/assets/paddle/`。已追到 `App.onCreate()` → `lIlii.IL1Iii(Application)` → `L1ii1(application)` 的静态调用路径；该路径受初始化门控 `m1188iIIi1(application)` 影响，且各资源复制返回值未统一检查。下一步核对实际资源存在性/复制结果，并追踪 Lua 绑定与 OCR 模型加载调用链。
4. 关联 Java JNI 声明与原生库实现；静态证据不足时标记需要本地只读二进制分析。
5. 分开推进 LegendAI 建议输出桥接与游戏操作提交协议研究；Hachimi 的 `/notify/request`、`/notify/response` 不得视为动作提交 API。
6. 在协议边界有证据后，才设计独立的影子模式/动作守卫验证；最终用台服实际截图或手动操作样本做单独的运行时验证。
7. 在后续研究中持续更新专题报告，并把跨任务的持久结论汇总回本文件。

## 5. 安全与环境约束

- 默认只读优先；不擅自安装软件，不泄露凭据，不修改系统级代理。
- 不运行未知 APK/EXE/DLL，不因静态研究需要自动触发游戏动作。
- 不保存不必要的会话凭据、请求头、ViewerID、token 或其他敏感字段。
- 不将游戏缓存、回合数据、AI 程序或二进制上传到仓库，除非用户对特定对象明确授权并已评估必要性。
- 不把预期、假设、待办或工具返回的未核实内容写成已完成事实。
- 本文是项目进度与归档流程文档，不替代具体模块的实现说明、测试报告或安全门。

## 6. 本轮归档记录

### 2026-10-25 — 为 UmaAI-Research 建立项目进度与自动归档规则

- 执行模式：`WRITE`
- 目标：创建本项目的统一进度归档文档，并将通用归档流程适配为 UmaAI-Research 专属约束。
- 已执行：读取目标分支远端 Git tree；读取现有 Hachimi/LegendAI 集成、核心架构、执行器契约和 Qianye 静态分析专题文档；据此整理项目目标、现有证据、边界和后续步骤。
- 远端核验：PASS；创建后已回读本文件，归档标记和关键规则存在，Commit SHA 已通过 GitHub commit 元数据确认，commit 中该文件的 Blob SHA 与回读 Blob SHA 一致。
- 安全边界：本轮仅处理 GitHub 文档；不运行 APK/原生库、不运行游戏、不触发 Actions、不提交任何游戏操作。


### 2026-10-25 — Qianye OCR 模型路径与初始化检查静态追踪

- 执行模式：`READ_ONLY`
- 研究分支：`analysis/qianye-reverse-engineering-20261025`
- 证据文件：`qianye-export/sources/com/p000nx/assist/lua/PaddleOcr.java`、`qianye-export/sources/I1I/I1I/ILil/L11I.java`、`qianye-export/sources/I1I/I1I/ILil/l1IIi1.java`、`qianye-export/sources/I1I/I1I/p008IL/lIlii.java`。
- 已核实：`L11I.m9501()` 将 `I11li1()` 指向应用 `filesDir/assets`；`PaddleOcr.loadModel(...)` 继续拼接 `paddle`。运行时模型路径为 `filesDir/assets/paddle/`。ONNX 文件名为 `det.onnx`、`cls.onnx`、`rec.onnx`、`keys.txt`；NNCC 文件名为 `det.param`、`rec.param`、`det.bin`、`rec.bin`、`keys.txt`。
- 静态代码疑点：ONNX 存在性检查重复检查第一个模型路径，未检查 `cls.onnx`；NNCC 检查未覆盖 `rec.param`。影响尚未通过运行时验证。
- 重要限制：`lIlii.m1194llI11I(...)` 的实现围绕 native library 文件与 `System.load(...)`，不能据此视为 OCR 模型下载/解压入口。仓库中存在 `resources/assets/paddle/keys.txt`，但尚未追踪它及模型到 `filesDir/assets/paddle/` 的完整部署链。
- 归档状态：专题报告更新后待远端回读；本文件更新后也须分别核验。未运行 APK/游戏、未运行 GitHub Actions。


### 2026-10-25 — Qianye APK AssetManager → OCR 模型目录复制链

- 执行模式：READ_ONLY；仓库/分支：wosafety0/UmaAI-Research / analysis/qianye-reverse-engineering-20261025。
- 证据：qianye-export/sources/I1I/I1I/p008IL/lIlii.java、qianye-export/sources/com/main/engine/Engine.java、qianye-export/sources/com/p000nx/assist/lua/PaddleOcr.java、qianye-export/sources/I1I/IL1Iii.java，并检查本分支递归 Git tree。
- 静态 PASS：解混淆确认 lIlii.L1ii1(Context) 创建 filesDir/assets、filesDir/assets/tessdata、filesDir/assets/paddle；m1192lL(Context,String,File) 通过 context.getAssets().open(sourcePath) 读取 APK AssetManager 资源并写入指定目标文件。
- 已解码的 OCR 资源源路径包括 assets/paddle/det.bin、det.param、rec.bin、rec.param、keys.txt 及 det.onnx、cls.onnx、rec.onnx。方法也复制 assets/models.zip、assets/lua.zip 等其他资源。
- 限制：当前导出 Git tree 的 resources/assets/paddle/ 仅列出 keys.txt；不能由此证明原 APK 的 AssetManager 也缺少模型，因为导出资源可能不完整。尚未确认 L1ii1(Context) 的实际调用点/启动时机、模型资源在 APK 中的存在性或模型成功加载。Engine.extractApkAssets(...) 是另一种归档条目复制路径，尚无证据认定它是 OCR 模型主入口；m1194llI11I(...) 与 native library 加载相关，不应混同。
- 安全/额度：仅只读 GitHub 文件与 tree；未运行 APK、原生库或游戏，未触发 GitHub Actions（额度仍按已知状态视为耗尽）。
- 下一步：追踪 L1ii1(Context) 调用者和初始化时序；确认导出资源缺项情况；继续追踪 Lua 初始化与 PaddleOcr.loadModel 的调用链。


### 2026-10-25 — Qianye OCR 资源复制启动调用点

- 执行模式：READ_ONLY；分支：analysis/qianye-reverse-engineering-20261025。
- 证据：qianye-export/sources/com/main/app/App.java、qianye-export/sources/I1I/I1I/p008IL/lIlii.java、qianye-export/sources/com/p000nx/assist/lua/LuaEngine.java、qianye-export/sources/com/p000nx/assist/lua/PaddleOcr.java。
- 静态 PASS：`App.onCreate()` 调用 `lIlii.IL1Iii(this)`；`lIlii.IL1Iii(Application)` 在初始化门控 `m1188iIIi1(application)` 通过后调用 `L1ii1(application)`；`L1ii1(Context)` 再执行 AssetManager 到应用私有目录的资源复制。故复制方法有可见的启动调用点，不是完全孤立代码。
- 限制：门控是否在实际运行中通过、AssetManager 中各 OCR 模型文件是否存在、各复制是否成功、OCR 是否最终加载均未验证；复制返回值没有被统一汇总为明确失败判定。导出 Git tree 中 `resources/assets/paddle/` 仍只看到 `keys.txt`，不能直接推断原 APK 资源必然缺失或存在。
- Java 源码直接搜索尚未找到 `PaddleOcr.loadModel(...)` 调用点；已确认 `LuaNative.checkMethod(...)` / `callMethod(...)` 具备通用 Java 反射调用机制，因此不能排除 Lua 动态调用，但仍未找到实际脚本调用证据。下一步研究 Lua VM 类绑定规则、`L11I.m942LlLLL(...)` 以及 `script.lrj`/`lua.zip` 的读取入口。未执行 APK/游戏，未触发 Actions。


### 2026-10-25 — Qianye Lua → Java 动态反射能力

- 执行模式：READ_ONLY；分支：analysis/qianye-reverse-engineering-20261025。
- 证据：qianye-export/sources/com/p000nx/assist/lua/LuaNative.java、LuaEngine.java、com/main/engine/Engine.java、I1I/I1I/ILil/L11I.java。
- 静态 PASS：`LuaNative.checkMethod(...)` 枚举目标类的 declared/public methods 并缓存；`callMethod(...)` 将 Lua 参数转换为 Java 参数后使用 `Method.invoke(...)`。这证明桥接层具备通用反射调用能力。
- 相关线索：`Engine` 有 `paddleOcr(Object)` native 声明、截图字节获取包装和 `installLR(String)`；后者调用 `L11I.I11L().m942LlLLL(str)`。但尚未确认该安装入口对应 `script.lrj`，也没有证据证明实际 Lua 脚本调用 `PaddleOcr.loadModel(...)`。
- 限制：反射能力存在不等于某个类已暴露给 Lua，更不等于脚本实际调用；Lua VM 类绑定表、脚本加载链和 OCR 模型成功加载仍未验证。未执行 APK/游戏，未触发 Actions。
- 下一步：追踪 `L11I.m942LlLLL` 的代理/核心实现、`script.lrj` 与 `lua.zip` 的读取点，并检查 native/JNI 的 Lua 类绑定机制。


### 2026-10-25 — Qianye installLR 文件传递链（只读静态）

- 执行模式：READ_ONLY；分支：analysis/qianye-reverse-engineering-20261025。
- 证据：qianye-export/sources/com/main/engine/Engine.java、I1I/I1I/ILil/L11I.java、I1I/I1I/ILil/ILL.java、android/app/INXCoreNative.java、com/p000nx/assist/lua/LuaEngine.java。
- 静态 PASS：`Engine.installLR(String)` 转调 `L11I.m942LlLLL(String)`；该方法以输入路径为源，经 `ILL.m868lIlii(String,String)` 将文件复制到核心服务文件路径，再调用 `ILL.I11L(8,0,0,path)`，并按返回字符串是否等于 `"0"` 决定结果。可见成功分支会 sleep 600000 ms。
- 静态 PASS：`ILL.m868lIlii` 使用 `FileInputStream` 读取源文件，并经 `INXCoreNative.openFile/writeFile/closeFile` 写入服务端文件句柄，确认这是核心服务文件传输机制；该函数本身不解析脚本格式。
- 限制：操作码 8 的服务端语义、混淆目标文件名、`script.lrj` 与 installLR 的对应关系仍未验证。LuaEngine 的可见接口包含插件对象、资源路径与截图包装，但尚未找到 `script.lrj` / `lua.zip` 的直接消费者。LuaNative 反射能力不能单独证明 OCR 类对 Lua 可见或被实际调用。
- 下一步：定位 INXCoreNative 服务端实现/native 注册表与脚本文件消费者；若当前导出缺少相关二进制/服务端证据，记录边界而不猜测。未运行 APK/游戏，未触发 GitHub Actions。


### 2026-10-25 — Lua 运行时初始化与 JNI 证据边界

- 执行模式：READ_ONLY；分支：analysis/qianye-reverse-engineering-20261025。
- 证据：qianye-export/sources/com/main/app/NativeService.java、com/main/engine/ScriptMain.java、com/main/engine/Engine.java、com/p000nx/assist/lua/LuaEngine.java、LuaNative.java；resources/lib 下多个 ABI 的 libengine.so、libnative.so、libpaddleocr.so。
- 静态 PASS：NativeService 调用 ScriptMain.main；ScriptMain 在特定启动参数分支初始化 LuaEngine 与相关上下文，然后创建 L11I 核心脚本对象并进入 Looper。导出树包含多个 ABI 的 engine/native/paddleocr 原生库。
- 限制：当前可检索代码中未发现 script.lrj / lua.zip 的直接读取调用点；native 侧只有共享库文件，当前未获得可检索的 JNI C/C++ 实现或注册表。因此不能确认 JNI 注册映射、脚本读取/执行点、Lua 实际暴露的 Java 类清单，也不能确认 OCR 模型被成功加载。
- 下一步：继续沿 L11I/核心服务的文件 API 找消费者；若证据最终落在共享库内部，需专门静态分析该库后再下结论。未运行 APK/游戏，未触发 GitHub Actions。


### 2026-10-25 — installLR 的 sendCmd(8) 追到事件 99

- 新证据：`qianye-export/sources/I1I/I1I/ILil/iIilII1.java`、`LLL.java`、`CoreProvider.java`、`android/app/INXCoreNative.java`。
- 静态 PASS：`L11I.m942LlLLL` 将输入文件复制到核心服务路径后调用 `ILL.I11L(8,0,0,path)`；Binder `sendCmd` 转到 `iIilII1.sendCmd`。当 `i == 8` 时，Java 侧派发 `IIi(99, path, "")` 并返回解码后的 `"0"`，与上游成功码比较一致。
- 重要限制：事件 99 的订阅者/处理器尚未定位；这只能证明路径被派发给事件总线，不能证明 Lua 已读取、解析或执行文件。成功码分支还会同步等待约 600000 ms（10 分钟），这是代码的阻塞等待，不是执行时间测量。
- 下一步：追踪 `p051lLi1LL.ILil.IL1Iii.I1I.I1I().ILL(...)` 的事件 99 消费者和监听注册。仍然只读 GitHub，不运行 APK/游戏，不触发 Actions。


### 2026-10-25：MessageEvent / event 99 进一步静态确认

- 事件类型定位到 `android-automation/apk-analysis/qianye-export/sources/I1I/I1I/ILil/IIi.java`；反编译注释显示原始类名 `MessageEvent`。对象携带三个字段：整数事件码、字符串参数 1、字符串参数 2。
- Core native Binder 的 `sendCmd` 在 code=8 时发布 `MessageEvent(99, targetPath, BuildConfig.FLAVOR)`，随后返回字符串 `0`。因此此前 `installLR` 对返回值 `0` 的判断仅证明命令处理器接受/分发了事件，不能证明脚本文件已被消费或执行。
- 自定义 EventBus 的 `ILL(Object)` 是通用事件发布入口；事件 99 的具体订阅者和脚本执行语义仍未确认。后续继续仅通过 GitHub 源码静态追踪订阅者与注册过程；不消耗 Actions 额度、不执行 APK。

### 2026-10-25 — LegendAI 当前故障日志排查（等待用户次日实测）

- 执行模式：`READ_ONLY`（本轮仅归档结论；没有修改用户本机文件、配置或进程）。
- 目标：根据用户提供的 Windows 应用事件日志与目录清单，定位 LegendAI 当前使用时的错误线索；暂停自动化开发，等待用户次日完成实测后再继续。
- 已核实的主要错误：2026-10-25 21:52:40，`.NET Runtime` Event ID 1026 记录 `UmamusumeResponseAnalyzer.exe` v1.14.3.2 未处理异常：`KeyNotFoundException: The given key '插件' was not present in the dictionary.` 调用链包含 `UmamusumeResponseAnalyzer.Plugin.IPlugin.ConfigPrompt()`、`PluginConfig.Prompt()`、`Config.Prompt()`、`ShowMenu()`。这强烈指向小黑板显示插件配置提示时访问了缺失的“插件”字典键；具体触发插件、元数据或兼容性原因尚未确定。
- 另一个独立错误：2026-10-25 22:04:07，应用发生 `Environment.FailFast`，消息为 `A callback was made on a garbage collected delegate ... ConsoleHelper+HandlerRoutine::Invoke`，关联 WER exception code `0x80131623`。目前没有证据证明它与前述 `ConfigPrompt()` 异常存在因果关系。
- 游戏状态通道的现有证据：用户目录清单显示 `D:\Games\ai\.portable\PluginData\SendGameStatusPlugin\GameStatusSend_Legend\thisTurn.json` 在 2026-10-25 22:02:21 更新，大小约 4.7 KB；同时存在 turn0–turn71 等历史 JSON。此前检查已看到结构化育成状态且内容变化。这支持状态写入通道曾工作，但不能证明 LegendAI 已成功计算或输出训练建议。
- 插件目录已定位：`D:\Games\ai\.portable\Plugins`，其中包含 `AIRedirector`、`SendGameStatusPlugin`、`LegendScenarioAnalyzer` 等；本轮此前对 `PluginData` 下 JSON/TOML/YAML/INI/CONFIG 文件的关键词搜索没有找到 `ConfigPrompt`、`插件配置` 等匹配。该搜索范围不包含小黑板 EXE 内部实现，也不能据此认定不存在相关配置。
- 配置文件观察：`D:\Games\ai\LegendAI\aiConfig_cpu.json`（620 bytes，修改于 2026-06-28）含 `//` 注释并重复拼接两个顶层对象，因此 PowerShell `ConvertFrom-Json` 无法解析；备份文件也采用类似格式。此现象不证明 LegendAI 自身解析失败，文件长期存在，当前没有证据将其与 2026-10-25 的崩溃关联。**未修改配置，不建议直接覆盖或恢复备份。**
- `D:\Games\ai\LegendAI\lastError.json` 曾与 `thisTurn.json` 内容一致，因此不能仅凭文件名认定它记录的是异常。
- 当前判断：首要可追踪线索是小黑板 `Plugin.IPlugin.ConfigPrompt()` 的缺失键异常；尚未证明它就是用户所说 AI 建议错误的唯一原因。现有 `update.log` 内容未提供明确运行时决策异常，不继续重复检索该日志。
- 安全边界：没有发送 HTTP 请求、执行游戏操作、重启/启动进程、修改文件或配置、安装软件或触发 GitHub Actions。没有把状态 JSON 写入视为 AI 推荐输出验证通过。
- 下一步：等待用户次日实测反馈；优先根据复现时刻的应用事件日志与小黑板插件配置提示异常，进行最小范围只读定位。实测前不继续自动化开发、不擅自修复配置，也不扩大到 APK 逆向任务。


### 2026-10-26 — 统一 UmaAi / LegendAI 身份与外部执行路线线索归档

- 执行模式：WRITE（仅更新 GitHub 项目文档；本轮未操作本地游戏环境）。
- 仓库/分支：wosafety0/UmaAI-Research / analysis/qianye-reverse-engineering-20261025。
- 更新前远端 Blob SHA：c439a827e5e51265eaf002de3104e55d958db3d8。
- 本次目标：纠正项目概念关系，归档用户提供的 AI 群公告与开源仓库线索，明确后续调查重点。

#### 已由用户明确校正的项目事实

- **LegendAI 就是 UmaAi 在传奇杯（Legend）剧本下的运行形态；Legend 是剧本名，不是另一个独立 AI 项目。** 后续不得把 LegendAI 与 UmaAi 当成两个不同决策系统。
- 用户已实测确认：LegendAI/UmaAi 能读取游戏状态并给出合理育成建议；当前项目未因此获得自动执行能力。
- 当前已成熟的自动化执行候选仍是千叶与姬塔。项目目标是把现有决策输出可靠地交给执行器，不重新实现策略，也不把人工逐屏截图、制作 PNG 模板或手工标注按钮坐标作为可接受的最终路线。
- 平台范围保持：台服优先做实机验证；日服用于前瞻研究；国服排除。

#### 用户提供的群公告线索（内容尚未独立验证）

1. “拉面杯 Android 测试版 / 震鲸发布”公告称该插件基于 Hachimi，仅适配日服；需要在游戏内进入拉面杯剧本，再打开 AI App 开始连接，保存育成并重新进入后输出建议。公告提到 8192 计算量、8 线程等设置，并由作者持续修正合宿策略。
2. “温泉杯 0.26”公告称增加事件选项计算；按成功效果估算，未覆盖小黑板中没有收录效果的事件；还提及线程/栈大小、portable 数据目录、game_config.toml、gamedata/constants.json、mcts_selected_onsen 等配置。
3. 以上是用户转述的群公告，归档为待核实的外部线索，不等于已验证的程序行为。它们表明 UmaAi 生态中存在剧本相关策略、配置/数据加载与 Hachimi + 独立 AI App 的连接流程线索；没有证明拉面杯插件具有动作提交或全自动执行接口。
4. 调查 Hachimi/AI App 时要区分游戏状态采集、策略计算、建议回传与游戏动作执行；“能连接并输出建议”不等于“能执行建议”。

#### 开源仓库链接与证据纠正

- 用户提供的开源仓库为 https://github.com/Akkarriin/UmaAi。本轮 GitHub 仓库元数据读取确认仓库存在，默认分支为 master；当前仅确认元数据，尚未完成源码内容核验。
- 先前对话曾引用 hzyhhzy/UmaAi 的 README 作为架构证据，但那不是用户给出的仓库地址。**此前关于该仓库的具体代码结构、thisTurn.json、WebSocket 等描述不得自动视为已核实适用于 Akkarriin/UmaAi；后续应直接读取用户指定仓库再作结论。**
- 不因名称相同或存在 Fork 就假定两个仓库的代码、版本、通信协议和执行能力相同。

#### 对当前技术路线的影响

- 继续优先追踪千叶/姬塔真实动作执行链与可复用接口；千叶包含 OCR/YOLO 包装接口和脚本运行线索，但尚未证明完整识别调用链，也不能据此断言它完全依赖视觉。
- 并行关注 UmaAi/Hachimi 的结构化游戏状态和外部通信边界，作为可能的数据/通信参考；不把它误认为现成的动作执行器。
- 现有项目代码中的 LegendAI 建议 sink 仍属于待集成/待运行验证的桥接资产；必须先确认实际部署中是否启用，并用自然运行产生的脱敏日志验证建议、角色/run、回合与命令候选能否稳定关联。
- /notify/request、/notify/response 仍是已知的通知/观察路径，不能据此认定为受支持的游戏动作提交 API；未验证的命令不得重放。
- 默认只读/影子模式；在动作语义、身份关联和执行通道验证前，不发送真实游戏输入。

#### 状态、限制与下一步

- PASS：用户对 UmaAi / LegendAI / 传奇杯的身份关系已明确校正；用户提供的两类群公告文本已归档为研究线索；指定 GitHub 仓库元数据已读取。
- NOT_VERIFIED：群公告中提及的插件实际通信与执行能力；Akkarriin/UmaAi 源码具体结构及其与其他 UmaAi 仓库的关系；千叶/姬塔外部动作调用接口；推荐与真实游戏命令的稳定关联。
- 本次没有运行游戏、APK 或本地程序，没有触发 GitHub Actions，没有发送游戏输入，没有修改本地文件/配置。
- 下一步优先级：
  1. 直接读取并核对 Akkarriin/UmaAi 的 README、目录树及状态输入/通信/动作输出代码，不再引用未经核实的其他仓库作为替代。
  2. 继续追踪千叶/姬塔的动作分发器、外部调用入口和执行结果确认机制；将视觉识别作为可能的一个环节，而不是预设其为唯一机制。
  3. 确认现有被动记录器和 LegendAI recommendation sink 的真实部署状态；在不发送游戏输入的前提下取得少量自然运行的脱敏样本。
  4. 如果无法找到可复用执行入口，及时报告阻塞与止损判断，不回退到人工模板/坐标制作路线。


### 2026-10-26 — 仓库回顾与最小执行闭环优先级调整

- 模式：READ_ONLY 仓库文档回顾 + WRITE 进度归档；目标分支：analysis/qianye-reverse-engineering-20261025。
- 本轮回读：PROJECT_UMAAI_Progress.md、LEGEND_AI_EXECUTOR_CONTRACT.md、UMA_AI_CORE_ARCHITECTURE.md、AIRedirector_RECOMMENDATION_SINK_PATCH.md、Qianye 逆向报告及 AutoTrainingPlugin/README.md。
- 关键结论：UmaAi/LegendAI 的决策已由用户实机验证；仓库具有 URA 结构化状态观察、请求字段观察、建议 sink 源码、千叶 Lua/JNI/OCR 逆向线索及离线控制器。但 sink 尚未证实在用户实际 AIRedirector 部署中集成运行；无已验证的游戏动作执行通道，也没有完整自动育成闭环。
- 决策调整：以“取得真实建议 → 验证当前回合和唯一动作映射 → 找到合法可复用的千叶/姬塔执行入口或独立执行适配器 → 受控执行一个动作并确认状态变化”为最小闭环。先确认执行入口，再按需完善识别、状态机和防护，不继续泛化模板、模型权重、复杂离线校验或重造 UmaAi 策略。
- 千叶研究优先追踪实际动作分发、Lua/核心服务/触摸事件和执行后确认；OCR/YOLO 是否承担全部识别尚未证实。姬塔作为平行候选进行低成本可行性评估。
- 止损：不接受人工逐屏截图、批量制作 PNG 模板或手工坐标；如果没有可复用的合法执行入口，明确 NO-GO/阻塞，不将通知接口或观察到的请求重放成游戏动作。
- NOT_VERIFIED：sink 真实部署、真实日志的 run/turn 关联、千叶/姬塔外部接口、台服执行闭环。
- 安全：本轮未运行 APK/游戏、未执行测试、未触发 Actions、未发送游戏输入、未修改本地文件。
- 下一步：先确认 AIRedirector sink 实际部署与一条真实建议记录；随后集中做执行入口的短期可行性判断。


### 2026-10-26 — MVP-01 路线锁定与偏航提醒规则

- 用户明确要求：后续开发严格遵循 MVP-01；不开展路线之外的开发。若用户后续决策、提议或新线索会使工作偏离该路线，助手必须主动提醒，说明偏离点及其对闭环交付的影响，并优先建议回到当前验收目标；只有用户明确修改项目目标后才调整路线。
- **MVP-01 唯一目标：** 在台服优先、传奇杯剧本下，复用现有 UmaAi/LegendAI 决策能力，完成一次可核验的真实动作闭环：自动获取一条真实建议并关联当前回合 → 映射为唯一合法动作 → 通过已验证的千叶/姬塔执行入口或其他可复用执行接口执行一次速度训练 → 读取新的结构化状态，确认动作生效及回合推进，并保存最小结果记录。
- **阶段范围：** 先验证建议读取与回合关联；再确认执行器真实动作入口；然后验证单动作映射；最后才进行一次受控真实动作与结果确认。若当前回合没有推荐速度训练，不得伪造或篡改建议，只等待自然出现合适回合或报告阻塞。
- **禁止偏航：** MVP 验收前不开发多动作调度、全育成状态机、多剧本支持、模型训练、重做 AI 策略、泛化 OCR/YOLO 或复杂离线测试；不开展与当前阻塞无直接关系的广泛逆向；不制作大量人工 PNG 模板、不逐屏截图、不手工标注按钮坐标。不得把“有源码/接口”“能观察请求”或“通知端点存在”当作已具备动作执行能力。
- **止损规则：** 若在短期、定向调查后仍找不到可复用且可验证的执行入口，必须明确报告阻塞与 NO-GO/替代执行器评估，不以扩大研究范围代替结论。无法确认执行结果时不得继续下一动作或盲目重试。
- **验收标准：** (1) 自动获取真实 LegendAI 建议；(2) 建议与角色/运行及当前回合可靠关联；(3) 唯一映射到速度训练动作；(4) 通过已验证执行入口执行一次；(5) 新状态证明动作生效并推进回合；(6) 生成含成功/失败原因的最小记录。只有全部通过，才允许提出 MVP-02。
- **操作边界：** 在执行入口与动作语义验证前保持只读/影子模式；真实输入前需有明确授权。不得触发 GitHub Actions；归档结果时必须区分 GitHub 远端变更与本地状态，不得虚报。
