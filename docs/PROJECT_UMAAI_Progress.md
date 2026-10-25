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
3. 已确认 Java 层通过 `lIlii.m1192lL(Context, String, File)` 从 APK AssetManager 复制 `assets/paddle/det.bin`、`det.param`、`rec.bin`、`rec.param`、`keys.txt` 及 ONNX 变体到 `filesDir/assets/paddle/`。下一步追踪 `lIlii.L1ii1(Context)` 的调用者/启动时机，并核对当前导出是否遗漏模型二进制；继续区分 native library 加载辅助方法与 OCR 模型资源处理。
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
