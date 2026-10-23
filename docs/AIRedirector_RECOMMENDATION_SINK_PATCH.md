# AIRedirector 只读推荐 sink 接入补丁说明

状态：**源码已提交到 UmaAI-Research；尚未合入或编译 AIRedirector 本体。**

适用的上游源码基线：`URA-Plugins/AIRedirector`，提交
`6e31c415e5774aaab3d5203432f5133c41e47b57`。本仓库新增
`AutoTrainingPlugin/AIRedirectorIntegration/LegendAiRecommendationSink.cs`。
该文件应加入 AIRedirector 项目编译，或复制到其项目目录；它不属于 URA 的普通 Analyzer 插件，单独放在本仓库不会自动运行。

## 最小接入位置

以下是针对已核实的 `Class1.cs` 结构的手动接入步骤。只改 AIRedirector 源码副本/分支，不改 `main`，也不启动第二个 UmaAi.exe。

### 1. 引入 sink 和字段

在 `Class1.cs` 顶部增加：

```csharp
using UmaAutoTraining.AIRedirectorIntegration;
```

在 `AIRedirector` 类现有字段区增加：

```csharp
readonly LegendAiRecommendationSink recommendationSink = new();
```

如果该类文件被直接复制到 AIRedirector 项目，确认项目的目标框架支持 `System.Text.Json` 与 C# nullable 语法。

### 2. 仅在既有 Legend stdout 消费路径记录

在 `ConsumeProcessOutputAsync` 中，现有条件判断成功后，代码会执行：

```csharp
cancellationToken.ThrowIfCancellationRequested();
_ = bridge.ApplyTargetDisplay(cancellationToken);
```

在这两行之间插入：

```csharp
_ = recommendationSink.TryRecord(output.Line);
```

由于这段路径已经通过 `output.ApplyToLegend`、`gameStarted` 和
`bridge.ProcessLine(output.Line)` 的过滤，因此不会读取其他场景的 stdout。
sink 只接受 `AI建议:` / `AI建议：` 格式；普通日志会被忽略。

### 3. 在目标更新处同步角色育成 ID 和回合

在 `SetLegendDisplayId(SingleModeChara? chara)` 内，现有的：

```csharp
Volatile.Read(ref legendOutput)?.SetTarget(
    chara.single_mode_chara_id,
    chara.turn);
```

之后追加：

```csharp
recommendationSink.SetTarget(chara.single_mode_chara_id, chara.turn);
```

并将方法调整为在 `chara is null` 时明确清除 sink target，避免把旧回合误关联到新输出：

```csharp
ValueTask SetLegendDisplayId(SingleModeChara? chara)
{
    if (chara is not null)
    {
        Volatile.Read(ref legendOutput)?.SetTarget(
            chara.single_mode_chara_id,
            chara.turn);
        recommendationSink.SetTarget(chara.single_mode_chara_id, chara.turn);
    }
    else
    {
        recommendationSink.SetTarget(null, null);
    }

    return ValueTask.CompletedTask;
}
```

### 4. 清理

在 `DisposeAsync` 的清理流程中，确保调用：

```csharp
recommendationSink.Dispose();
```

可以放在现有 `rawOutput.Dispose()` 附近，并使用现有的 `Capture` 包装方式，以免一个清理异常跳过其余清理步骤。

## 输出与安全保证

输出文件：`PluginData/UmaAutoTraining/legendai-recommendations.jsonl`。

每条记录包含 UTC 时间、来源、`single_mode_chara_id`、`turn`、原始行、建议正文、文本类别，以及固定的 `verified=false`、`executable=false`。不记录请求头、viewer/device/keychain/token 等凭据。

**这只是推荐文本与回合的只读观测，不是自动执行。** 文本分类不是合法 command ID，sink 没有游戏请求发送代码。执行功能必须继续等待经证实的合法动作通道、回合匹配验证和状态变化确认。

## 验收状态

- [x] sink 源码已提交到 `feature/auto-training-plugin`
- [ ] 将 sink 接入 AIRedirector 的实际源码分支
- [ ] 编译 AIRedirector 并检查 nullable / target framework 兼容性
- [ ] 用离线 stdout 样本验证 JSONL、回合关联、空 target 与无关行
- [ ] 单独证实合法动作提交通道并设计 fail-closed 状态确认
- [ ] 游戏端到端测试

以上未完成项不能视为通过。
