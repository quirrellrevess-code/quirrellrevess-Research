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
