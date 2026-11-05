# AIRedirector 推荐事件桥接接入点

日期：2026-10-23
目标分支：`feature/auto-training-plugin`

## 源码核实

在公开仓库 `URA-Plugins/AIRedirector` 的提交 `6e31c415e5774aaab3d5203432f5133c41e47b57` 中：

- `Class1.cs` 的 `StartProcess` 已为现有 UmaAI 子进程订阅 `OutputDataReceived`。
- `HandleOutput` 将原始行写入单消费者 `processOutput` Channel。
- `ConsumeProcessOutputAsync` 依序把输出送给 `UmaAiRawOutputWorkspace.PublishLine`，再由 `LegendAiOutputBuffer.ProcessLine` 解析并更新显示。
- `RegisterLegendDisplayIdAnalyzers` 从 Legend 响应中读取 `single_mode_chara_id` 与 `turn`，传入 `SetTarget`。

这意味着正确的推荐读取点是 **AIRedirector 现有 stdout 的单消费者处理路径**，不是再启动第二个 UmaAi.exe，也不是依赖当前尚未连接的 Python stdin 桥。

## 推荐的最小接入设计

1. 在 AIRedirector 的输出消费者中，对 `output.ApplyToLegend` 且通过 `bridge.ProcessLine(output.Line)` 的原始行调用一个独立的只读推荐 sink。
2. sink 仅接受以 `AI建议` 开头且具有明确中英文冒号和非空正文的行；保留原始行和解析后的正文。
3. 从当前 `LegendTrainingDisplayId` 关联 `single_mode_chara_id` 与 `turn`。没有有效 target 时，不把建议关联到任何回合。
4. JSONL 记录写入 `PluginData/UmaAutoTraining/legendai-recommendations.jsonl`，只保存时间、来源、角色育成 ID、回合、原始建议和候选文本类别；不保存请求头、viewer/device/keychain/token 等字段。
5. 初始版本必须标记 `verified=false`、`executable=false`。训练名、休息/外出文本和「选蓝色第2个」等选项文本都不是游戏请求中的 command ID。
6. 后续只有在通过离线样本证明推荐与回合关联准确，并单独证实合法执行通道后，才允许把它交给 fail-closed action guard。

## 当前仓库状态

- `legendai_stdout_bridge.py` 已实现只读文本分类和 JSONL 输出，可用于离线测试；它本身仍需被 AIRedirector 输出流调用，当前没有与 AIRedirector 自动连接。
- `legendai_action_guard.py` 只校验候选动作是否具备执行资格，不执行动作。
- URA 的 Hachimi `/notify/request` 与 `/notify/response` 仍然只被证实为观测入口；本设计不把它们当成动作 API。
- 尚未编译 AIRedirector fork、尚未运行游戏端到端测试，也尚未证明任何动作提交通道。

## 安全停止条件

遇到缺失 target、回合不一致、重复建议、未知建议格式、状态不就绪或执行后状态未变化，必须停止自动操作；不得猜测 command ID、重放未知协议请求或退回固定坐标盲点。

## 2026-11-02 — Python fallback prefix guard

- Static review found that the standalone Python stdout fallback accepted any line beginning with `AI建议` if a later colon appeared. Malformed text such as `AI建议debug:休息` could therefore be misclassified as a recommendation.
- The parser now requires the exact `AI建议` prefix followed only by optional whitespace and an ASCII or full-width colon, matching the C# sink's prefix boundary. The recommendation body remains descriptive text only; it still creates no action ID and always records `verified=false` / `executable=false`.
- Offline tests cover malformed prefix variants and accepted optional whitespace. This is a parser-quality fix only; it does not establish run/turn association, Taiwan-server behavior, or an action submission path.


## 2026-11-05 — Bound passive Python stdout records

- The standalone Python fallback now accepts only exact built-in strings up to 4,096 UTF-16 code units. Non-string and overlong lines are ignored before normalization, classification, and JSONL persistence.
- The boundary is tested at exactly 4,096 UTF-16 code units and one character over; a stream regression confirms that skipping an oversized line does not prevent a later valid recommendation from being recorded.
- This caps the accepted/persisted record payload; it does not claim to cap memory already used by the upstream text stream to materialize a line.
- The bridge remains passive: no process launch, turn correlation, action-ID inference, game input, or action submission.


### C# AIRedirector sink parity

- The integrated `LegendAiRecommendationSink` now applies the same 4,096-UTF-16-code-unit limit before regex matching or JSONL persistence.
- The .NET 10 passive-sink smoke test covers an accepted record exactly at the limit and rejects one character over; it also checks that the accepted record remains `verified=false` and `executable=false`.
- This is a source-level/.NET smoke check only. It does not establish that the AIRedirector fork was deployed or exercised in a live Taiwan-server session.


### Cross-runtime boundary parity

- Python excludes the terminal stdin line delimiter before applying the limit and counts UTF-16 code units, matching .NET `string.Length`. This avoids rejecting an exact-limit record merely because `sys.stdin` supplied its newline and avoids disagreement for supplementary Unicode characters.
- Python unit tests cover the exact/over UTF-16-unit boundary and an exact-limit stdin line. The .NET 10 smoke test covers the same boundary with supplementary Unicode input.


## 2026-11-06 — Single-physical-line input boundary

- The Python fallback removes at most one terminal LF, CRLF, or CR delimiter before applying the 4,096 UTF-16-code-unit payload bound. Any remaining CR/LF inside the payload, including a newline after the recommendation prefix or a second recommendation on the same input string, is rejected.
- The C# AIRedirector sink rejects CR/LF before regex matching. `DataReceivedEventArgs.Data` is already a single line without its delimiter, so this prevents the regex's whitespace handling from spanning line breaks.
- Both runtimes therefore classify only one physical recommendation line per record. This is input-shape validation only; it does not associate the recommendation with a verified turn or create an executable action.
