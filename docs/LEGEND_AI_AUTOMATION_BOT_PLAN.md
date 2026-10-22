# LegendAI 驱动的自动化育成 Bot：实施方案

## 已确定的产品边界

以现有 UmaAI 的传奇杯 AI（LegendAI/UmaAi.exe）作为唯一决策引擎。**LegendAI 自己读取游戏数据并产生行动建议；Bot 只负责把建议付诸实施。**

本项目不重写传奇杯训练策略，不复刻 AI 的状态读取，不自行计算训练评分，也不将传奇杯策略泛化到其他剧本。只有在执行安全校验或确认结果确有必要时，Bot 才可读取最少量的当前回合/合法行动/执行结果信息；这不是第二套决策输入管线。

## 目标架构

1. **LegendAI Recommendation Bridge**：现有公开 AIRedirector 源码已确认会启动 `UmaAI.exe`，以 UTF-8 读取 stdout/stderr；`LegendAiOutputBuffer` 识别 `AI建议...` 行并解析部分训练/心得评分。先复用这条既有进程输出，不要启动第二份 AI；需要增加本地 IPC 或原子 JSONL 导出，让 Bot 获得原始建议及其回合上下文。当前 AIRedirector 的已证实行为是显示到 URA UI，而不是向外部 Bot 提供接口。
2. **Recommendation Guard**：检查建议是否完整、是否仍属于当前回合、动作是否可执行。只做安全校验，不更改或重新排序 AI 的决策。
3. **Action Executor**：通过已确认的游戏操作通道提交 AI 建议。一次只执行一项，具备回合去重、超时保护和紧急停止。
4. **Result Verifier**：等待游戏端响应或可观测状态变化，确认建议确实执行；遇到超时先核实状态，不盲目重发。
5. **Audit Log**：记录原始 AI 建议、提交参数、响应和执行结果，方便定位协议/操作失败。

当前实际环境是赛马娘 PC 客户端 + Hachimi Edge 转发功能；Hachimi 主要用于文本替换和图形解锁。本次检查结合 `ai.zip` 与仓库 `main/hachimi/` 目录：`hachimi/httpforward.json` 明确将转发通知目标设为 `http://127.0.0.1:4693`，与 URA 配置的监听端口一致；`config.json` 中 `enable_ipc=false`，因此不应把 Hachimi IPC 视为当前已启用的通信方案。优先复用 URA 已有转发/建议展示链路，不把开发 Hachimi 插件当成首要路线。转发游戏流量只证明数据可被转交/观察，不等于可以通过同一通道提交育成操作。具体记录见 `docs/HACHIMI_EDGE_INTEGRATION_RESEARCH.md`。

## 源码调查已确认的事实

- `URADLL/UmamusumeResponseAnalyzer/Server.cs` 注册了 `/notify/request`、`/notify/response` 和 `/notify/ping`。前两个入口解析已经经过的游戏请求/响应，再调用分析器；它们不是游戏动作提交接口。
- `URADLL/Gallop/SingleModeExecCommandRequest.cs` 描述了操作请求字段：`command_type`、`command_id`、`command_group_id`、`select_id`、`current_turn`、`current_vital`。这只能证明请求数据模型存在，不能证明插件可直接发出请求。
- URADLL 的路由注册能力和请求/响应分析器能力已存在，但尚未从当前仓库确认游戏请求真正由哪段代码发送、请求头/会话如何构造，以及怎样等待对应响应。
- 本次上传的本地 `ai.zip` 包含 `LegendAI/UmaAi.exe`、AIRedirector/SendGameStatusPlugin 部署文件，以及 turn0–turn71 状态样本；这些私有/客户端材料没有提交到 GitHub。公开 AIRedirector 源码确认 AI 通过子进程 stdout 输出文本建议，解析器识别 `AI建议...`。本地 `aiConfig_cpu.json` 未启用明确的 `communicationMode`，副本配置则含 `urafile`，所以 AI 输入通道的实际启用模式仍需运行时确认。状态快照是 AI 输入/游戏状态，不是 AI 建议输出。
- 当前仍未确认实际游戏操作的提交路径；AIRedirector 显示建议不等于自动点击或提交游戏操作。



### Hachimi HTTP 转发链路：源码已确认（2026-10-22）

公开的 [hachimi-httpforward-plugin](https://github.com/UmamusumeResponseAnalyzer/hachimi-httpforward-plugin) 源码确认，它 hook `Cute.Http` 层：请求侧从 `WWWRequest.Post` 取得 URL/请求头并匹配请求 body；响应侧从 `HttpHelper.DecompressResponse` 取得响应 body，再通过 FIFO 关联原始 URL/请求头。随后分别 POST 到 URA 的 `/notify/request` 与 `/notify/response`，携带 `X-Hachimi-Game-Url` 和带 `X-Hachimi-` 前缀的部分游戏请求头。URA 的 `Server.cs` 接收 body 并分发给分析器，返回空响应。

这证明了游戏 HTTP 流量可以被旁路观察和解析；**没有证明、也不提供从 URA 通知入口向游戏提交新操作的路径**。请求体与 URL 无法配对、队列溢出等情况会导致丢包。下一步不再花时间猜测 Hachimi 通知 API，而是沿 URA/客户端源码查找实际动作请求的构造、序列化、会话头与发送调用链。

源码：
- https://github.com/UmamusumeResponseAnalyzer/hachimi-httpforward-plugin/blob/main/src/lib.rs
- https://github.com/UmamusumeResponseAnalyzer/UmamusumeResponseAnalyzer/blob/main/UmamusumeResponseAnalyzer/Server.cs


### 本轮实现：只读动作请求观察器

- `AutoTrainingPlugin/UmaAutoTrainingPlugin.cs` 已新增 `[Analyzer(response: false)]` 请求观察方法。
- 它只筛选 `single_mode_exec_command_request_common`，把 `command_type`、`command_id`、`command_group_id`、`select_id`、`current_turn`、`current_vital`、`exec_auto_play_plan_id` 写入 `PluginData/UmaAutoTraining/action-requests-observed.jsonl`；不会保存完整请求，也不会发送/重放请求。
- 这一步用于让真实游戏客户端先自行完成一次操作，从被动观察中确认动作参数和建议映射。源码已提交，但尚未在实际 URA 部署中编译或运行，必须先验证请求 analyzer 收到的 JSON 结构是否与预期一致。

## 实施阶段

### L0：确认两个真实协议（当前阶段）

**协议 A：AI 建议输出（部分已确认）**
- 已确认：AIRedirector 启动现有 `UmaAi.exe` 子进程，读取 UTF-8 stdout/stderr；建议以 `AI建议` 文本行输出，另有训练评分、休息/外出评分及心得评分。
- 未确认：所有建议文案的完整枚举、各动作到游戏 command ID 的映射、每条建议与育成 ID/回合的严格关联，以及 AI 完成/异常信号。
- 下一步：给 AIRedirector 增加明确的外部输出桥接，保存原始建议并带上由 URA 侧确认的育成 ID/回合；先做影子模式测试。不要仅靠回合状态 JSON 猜测 AI 建议。

**协议 B：游戏动作提交**
- 从 URADLL 调用链和现有客户端代码确认动作请求发送方式、序列化、会话/请求头及响应关联方式。
- 明确超时后如何查询状态，避免重复执行。
- 在此协议确认前，只允许观察或影子模式，禁止发送猜测的操作请求。

### L1：影子模式

- 读取真实 LegendAI 建议，但不提交动作。
- 对每条建议执行格式、回合与合法性检查，并记录拒绝原因。
- 用真实运行记录验证从 AI 输出到动作参数的映射。

### L2：单步受控执行

- 仅在两个协议都得到证据支持后启用。
- 每次只提交一项 AI 建议，确认结果后再处理下一项。
- 超时、响应拒绝、状态不一致、未知动作或 AI 输出损坏时立即暂停。

### L3：自动育成

- 增加总开关、紧急停止、回合去重、日志轮转与可恢复错误报告。
- 默认影子模式；自动执行必须显式开启。
- 只执行 LegendAI 明确给出的行动；不以自创策略作为回退。

## 验收标准

- Bot 不生成训练决策、不替换 LegendAI 的建议。
- 能从实际输出协议读取建议，并保留原始内容供审计。
- 发送前能阻止过期、缺字段或无法验证的建议。
- 每个回合不会因重试而重复提交同一动作。
- 只有确认操作结果后才继续；不确定时安全停止。
- 影子模式和自动执行模式明确隔离，且默认影子模式。
