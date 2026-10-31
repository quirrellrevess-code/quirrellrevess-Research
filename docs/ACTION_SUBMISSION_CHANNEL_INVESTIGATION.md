# Legend Cup 自动执行通道调查记录

日期：2026-10-22
分支：`feature/auto-training-plugin`
目标：让现有 LegendAI 自动完成传奇杯育成；用户不需要逐条手动点击 AI 提示。

## 本轮核实

检查了公开仓库 `UmamusumeResponseAnalyzer` 中的以下实现：

- `UmamusumeResponseAnalyzer/Server.cs`
- `UmamusumeResponseAnalyzer/Gallop/RequestBase.cs`
- `UmamusumeResponseAnalyzer/Gallop/RequestCommon.cs`
- `UmamusumeResponseAnalyzer/Gallop/SingleModeExecCommandRequest.cs`
- `UmamusumeResponseAnalyzer/Gallop/SingleModeExecCommandRequestCommon.cs`

### 已证实

1. URA 的 `/notify/request` 和 `/notify/response` 是 Hachimi 转发已发生游戏流量的通知入口。服务器从请求中取出原始 payload、游戏 URL 和部分头字段，再调用 Analyzer；处理完后返回空响应。
2. `SingleModeExecCommandRequest` 是 MessagePack 请求 DTO。其 common 字段包括命令类型、命令 ID、分组 ID、选择 ID、回合和体力等。
3. `RequestCommon` 还包含 viewer/device 等客户端请求字段。仅构造 command common 不等于构造了可被服务端接受的完整请求。
4. 这些源文件没有证明 URA 插件可以直接提交新的游戏动作，也没有证明 `/notify/*` 能执行动作。

## 结论

**当前不能安全地把 URA 通知接口当作动作提交 API，也不能仅凭 DTO 直接伪造请求。** 若要走协议提交路线，必须先确定游戏客户端的实际发送调用、序列化方式、必需请求头/会话上下文，以及请求响应关联方法。未确定前，不实现猜测性的请求重放。

## 接下来的开发顺序

1. 继续追踪 Hachimi hook 的游戏请求发送层及可扩展点，确认是否能在客户端进程内以与原生操作相同的方式触发动作。
2. 并行评估桌面输入自动化作为执行后备：只有在能稳定识别游戏窗口、控件位置和当前页面时才采用，不能靠固定坐标盲点。
3. LegendAI 输出桥接与执行器都围绕唯一 MVP 实现：收到真实建议、检查其仍对应当前育成状态、执行一项、验证状态已变化，再继续。
4. 继续保留影子模式和紧急停止；未知动作或状态不一致时停止，不能改用另一套策略。

## 当前状态

- 被动响应观察器与请求观察器已提交到本分支。
- AI 建议的外部读取桥接尚未实现。
- 游戏动作提交尚未实现。
- 本轮为源码调查，没有在本机编译或运行 URA/游戏，因此不代表端到端验证通过。



## 2026-11-01 — Upstream LegendAI / AIRedirector / URA action-channel boundary recheck

### Source revisions inspected

This is a public-source reference audit, not a claim that these repositories or revisions match the user's installed binaries:

- `Akkarriin/UmaAi` HEAD `e855d52e6bf7284269df84ab61aca4f687c19b26`: [README](https://github.com/Akkarriin/UmaAi/blob/e855d52e6bf7284269df84ab61aca4f687c19b26/README.md), [MainAi.cpp](https://github.com/Akkarriin/UmaAi/blob/e855d52e6bf7284269df84ab61aca4f687c19b26/UmaSimulator/MainCommands/MainAi.cpp).
- `URA-Plugins/AIRedirector` HEAD `c18c17716fb9f94efd68e50d3c493e13c8693123`: [AGENTS.md](https://github.com/URA-Plugins/AIRedirector/blob/c18c17716fb9f94efd68e50d3c493e13c8693123/AGENTS.md), [Class1.cs](https://github.com/URA-Plugins/AIRedirector/blob/c18c17716fb9f94efd68e50d3c493e13c8693123/Class1.cs), [UmaAiRawOutputWorkspace.cs](https://github.com/URA-Plugins/AIRedirector/blob/c18c17716fb9f94efd68e50d3c493e13c8693123/UmaAiRawOutputWorkspace.cs), [LegendAiOutputBuffer.cs](https://github.com/URA-Plugins/AIRedirector/blob/c18c17716fb9f94efd68e50d3c493e13c8693123/LegendAiOutputBuffer.cs).
- `UmamusumeResponseAnalyzer/UmamusumeResponseAnalyzer` HEAD `af5f2a37372fa7ad5a7c30553b1c8443e35908fa`: [Server.cs](https://github.com/UmamusumeResponseAnalyzer/UmamusumeResponseAnalyzer/blob/af5f2a37372fa7ad5a7c30553b1c8443e35908fa/UmamusumeResponseAnalyzer/Server.cs), [RequestBase.cs](https://github.com/UmamusumeResponseAnalyzer/UmamusumeResponseAnalyzer/blob/af5f2a37372fa7ad5a7c30553b1c8443e35908fa/UmamusumeResponseAnalyzer/Gallop/RequestBase.cs), [RequestCommon.cs](https://github.com/UmamusumeResponseAnalyzer/UmamusumeResponseAnalyzer/blob/af5f2a37372fa7ad5a7c30553b1c8443e35908fa/UmamusumeResponseAnalyzer/Gallop/RequestCommon.cs), [SingleModeExecCommandRequestCommon.cs](https://github.com/UmamusumeResponseAnalyzer/UmamusumeResponseAnalyzer/blob/af5f2a37372fa7ad5a7c30553b1c8443e35908fa/UmamusumeResponseAnalyzer/Gallop/SingleModeExecCommandRequestCommon.cs).

### Verified source behavior

1. **Akkarriin/UmaAi is a simulator/decision-analysis program, not the game-action executor.** Its README says it consumes already structured game state, computes and displays recommendations, and leaves state acquisition and actual action execution to the user or an external frontend. It documents `localfile`, `urafile`, and `websocket` input modes. `MainAi.cpp` reads the URA `thisTurn.json` path in `urafile` mode or receives state through the local `127.0.0.1:4693` WebSocket mode; this path emits decision output and does not establish a game-action submission channel. The README also says this repository is no longer maintained. Do not equate this public repository with the exact LegendAI executable installed locally.

2. **Current upstream AIRedirector routes process stdout to UI, not to an external structured recommendation bridge.** `Class1.cs` starts the configured UmaAI child process, reads UTF-8 stdout/stderr, publishes raw lines to `UmaAiRawOutputWorkspace`, and, when Legend is available, passes recognized lines to `LegendAiOutputBuffer` to update Legend's training/selection display. `UmaAiRawOutputWorkspace` retains at most 300 lines in an in-memory list for the workspace; the inspected path does not write a JSONL recommendation stream or expose a named-pipe/WebSocket consumer. This confirms the current upstream UI-display path only; it does not prove what the user's older installed DLL contains.

3. **Current upstream AIRedirector has a startup side effect on state files.** During `Initialize`, if `PluginData/SendGameStatusPlugin` exists, `Class1.cs` enumerates its JSON files and overwrites every file named `thisTurn.json` with `{}`. This is an observed behavior in the inspected upstream revision, not proof that the user's installed DLL has the same code or that it caused a reported local failure. The project progress record previously identified the local `AIRedirector.dll` as dated 2026-07-05; its exact source revision/hash has not been matched to this upstream HEAD.

4. **URA notification endpoints are receive-and-analyze hooks, not an action sender.** In `Server.cs`, `/notify/request` and `/notify/response` accept already-forwarded payloads and selected headers, then call `DispatchPacket`. `DispatchPacket` resolves an endpoint and invokes registered analyzers; the HTTP handler returns an empty response. The inspected `RequestBase` / `RequestCommon` / `SingleModeExecCommandRequestCommon` types are protocol DTOs. Their existence and command fields do not establish a supported way to originate a new authenticated game request; the common request model also contains client/session identity fields.

### Conclusion and scope

- No supported game-action submission path was established by these public sources. Do not treat `/notify/request`, `/notify/response`, a DTO, or the local WebSocket state feed as an action API; do not synthesize or replay requests.
- The current upstream source gives a concrete stdout/UI integration model, but the installed DLL identity, actual local output, same-run/turn correlation, and any Taiwan-server-specific behavior remain unverified.
- These sources are generic upstream references. Taiwan remains the primary research target; Japan is reference-only; China is excluded. No Taiwan-server protocol conclusion is inferred from this audit.
- Next useful evidence is a read-only comparison of the installed DLL version/hash with a source revision, plus sanitized natural-run stdout and state samples with run/turn identifiers. Until that is available, keep the recommendation bridge in shadow/read-only mode and keep action submission blocked.

### Execution boundary

Static public-source inspection only. No local files/configuration were read or changed in this round, no game was launched, no game input or account operation was performed, no request was constructed or sent, and no deployment or upstream repository change was made.
