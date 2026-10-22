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
