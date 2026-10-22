# LegendAI 执行器：实现边界与协议调查

## 明确的职责分工

- LegendAI/UmaAi.exe 是决策方：自行读取游戏数据并计算当前行动建议。
- 本项目 Bot 是执行方：获取 AI 已经产生的建议，验证建议仍然对应当前回合，再通过已确认的游戏操作通道执行。
- Bot 不重复采集 AI 已经能读取的数据、不重新计算训练评分，也不把传奇杯策略泛化到其他剧本。

## URADLL 已确认的能力与限制

- 插件可用 `[Analyzer(response: true)]` 接收解析后的游戏响应，也可用 `response: false` 观察请求。当前 `AutoTrainingPlugin` 已增加被动请求观察器：只记录 `single_mode_exec_command_request_common` 中的 command 字段到 `PluginData/UmaAutoTraining/action-requests-observed.jsonl`，不保存完整请求，也不发送任何操作。此改动尚未在用户的实际 URA 部署中编译/运行验证。
- 插件可用 `[Route(HttpMethod, path)]` 注册 URADLL 内部 HTTP 路由；路由处理器必须符合宿主的静态 `Task`/`HttpContextBase` 注册约定。
- `Server.cs` 中 `/notify/request` 和 `/notify/response` 是游戏通信的通知入口：它们读取并分析已发生的请求/响应，然后返回空响应。它们不是已确认的游戏操作提交端点。
- 目前已找到 `Gallop.SingleModeExecCommandRequest` 数据结构，含 `command_type`、`command_id`、`command_group_id`、`select_id`、`current_turn`、`current_vital`。它只能证明存在相应请求模型，不能单凭此模型推断可直接从插件发送该请求。

## 执行器最小流程

1. 读取 LegendAI 当前建议及其原始输出，不自行推导建议。
2. 将建议解析成明确的动作类型、动作 ID、回合标识和必要参数；字段含义以 LegendAI 实际输出契约为准。
3. 在发送前检查建议是否过期、是否与当前游戏回合匹配、是否存在合法候选；任何关键字段未知或不合法都停止执行。
4. 通过已验证的游戏操作通道提交一次操作；对每个回合使用幂等/去重保护。
5. 等待服务端响应并检查游戏状态是否实际变化。网络超时不能直接重发同一操作，必须先查询当前状态以避免双重执行。
6. 记录 AI 原始建议、发送参数、响应、前后状态与结果。提供总开关和立即停止能力。

## 新增的只读验证步骤

- 在真实游戏里手动执行训练、休息、外出、技能/比赛等操作，确认 URA 的 request analyzer 是否收到 `single_mode_exec_command_request_common`。
- 对比 LegendAI 的原始建议与 `action-requests-observed.jsonl`，逐项建立有证据的建议文本到命令字段映射；不从单个样本泛化未覆盖的动作。
- 如果日志始终为空，先检查当前 URA 版本是否启用请求分析、转发是否成功、请求体 JSON 的真实结构；不要直接假定字段路径正确。
- 该观察器只用于逆向确认现有游戏客户端本身如何发出动作请求。它不构造请求、不重放请求、不修改游戏行为。

## 当前待确认的两个协议

### A. LegendAI 建议输出协议

需要从 LegendAI 实际程序、调用它的宿主代码、配置或运行日志中确定：输出位置、格式、字段名、动作 ID、完成信号、错误和超时处理。没有证据之前，不得假定它输出 JSON、命名管道或特定文件。

### B. 游戏操作提交协议

需要从 URADLL 的调用链或现有客户端代码中确认：谁向游戏服务端发送 `single_mode/exec_command` 一类操作请求、如何序列化、如何设置必要请求头/会话信息，以及如何等待响应。不得将 `/notify/*` 通知端点当作提交端点。

## 完成定义

- 只执行 LegendAI 已明确给出的行动，不内置另一套训练策略。
- 发送前可以拒绝过期或无法验证的建议。
- 每回合最多提交一次，且只有在状态确认后才继续下一回合。
- 影子模式和自动执行模式可以切换；默认影子模式。
- 对未知动作、AI 输出损坏、超时或服务端拒绝，安全停止而非猜测动作。