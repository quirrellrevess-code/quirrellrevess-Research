# LegendAI 驱动的自动化育成 Bot：实施方案

## 目标

以现有 UmaAI 的 `LegendAI/UmaAi.exe` 传奇杯 AI 作为首选决策引擎，开发围绕它运行的自动化育成 Bot。首阶段不是重写 AI，也不是训练一个跨剧本通用评分器，而是打通：游戏状态采集 → 传奇杯状态适配 → 调用现有 LegendAI → 解析决策 → 安全执行 → 结果核验。

## 已知依据与当前缺口

- 历史环境记录中存在 `LegendAI/UmaAi.exe`，配置曾显示 LegendAI 默认启用；`CookAI/UmaAi.pdb` 记录了 `UmaSimulator` 路径。这说明应优先调查现有 AI 程序及其原有调用协议，而不是直接替代它。
- 历史记录中有 72 份传奇杯状态快照（`turn0`–`turn71`），字段包括 `turn`、`vital`、`motivation`、`fiveStatus`、`cardId`、`personDistribution`、若干 `lg_*` 字段和 `islegal`。这些字段是还原旧 AI 输入输出契约的重要证据，但尚未在当前 GitHub 分支中找到这些快照文件。
- 当前仓库 `main` 分支已检查到 URADLL 反编译源码和运行时 DLL，但未发现 `LegendAI/UmaAi.exe`、`UmaAI` 策略源码、72 份快照或其协议说明。因此暂时无法声称已调用或复现传奇杯 AI。
- URADLL 的 `TurnInfoLegend` 可从 `SingleModeCheckEventResponse.CommonResponse.legend_data_set` 读取传奇杯数据；`SingleModeLegendDataSet` 暴露 `command_info_array`、`evaluation_info_array`、`gauge_count_array`、`buff_info_array`、`obtainable_buff_id_array`、`masterly_bonus_info`、`race_history_array`、限制参数与 buff 参数等字段。`SingleModeLegendCommandInfo` 提供 `command_id`、`legend_id`、`gain_gauge`、属性增减和 friend gauge gain 等数据。

## 目标架构

1. **URADLL Adapter**：解析当前游戏响应，保留原始 JSON，并规范化当前回合、体力、干劲、五维属性、支援卡、训练伙伴分布、合法行动及传奇杯专属字段。
2. **LegendAI Adapter**：把规范化状态转换成旧 LegendAI 的确切输入格式；以隔离进程方式调用旧程序（具体命令行/标准输入输出/文件协议必须先从实际文件或运行记录确认）。
3. **Decision Validator**：校验输出格式、回合一致性、`islegal`/候选行动合法性、超时和空输出；校验失败时不得提交游戏操作。
4. **Action Executor**：只在 URADLL 的请求/操作调用链被确认后，提交决策并等待服务器响应。不得把 `/notify/request` 或 `/notify/response` 通知路由误当成已证实的操作接口。
5. **Result Recorder**：将输入快照、AI 输出、实际执行的行动、响应和后续状态按回合关联保存，支持回放与对比。

## 开发阶段

### L0：找回旧 AI 契约（前置）

- 获取 `LegendAI/UmaAi.exe`、相关配置文件、输入/输出样本和 `turn0`–`turn71` 快照。
- 查明 AI 是由谁启动、接收什么参数、从哪里读取输入、输出写到哪里、错误码与超时行为。
- 从多份快照确认字段类型、必需字段、可选字段、`lg_*` 字段含义和 `islegal` 的准确语义。

### L1：状态适配与只读影子模式

- 由 URADLL 收集真实传奇杯状态。
- 生成旧 AI 输入并与已知快照结构进行字段级比对。
- 调用旧 AI 但不提交游戏动作，记录其推荐行动与输出。

### L2：决策与游戏状态对账

- 校验 AI 推荐是否属于当前可选且合法的行动。
- 对比实际训练结果与状态变化，建立按回合的审计日志。
- 只有连续回放通过后才允许开启受控执行。

### L3：自动育成

- 加入单回合防重复提交、超时恢复、状态变化确认、异常停止和手动紧急停止。
- 不认识的剧本、输入契约不匹配或决策非法时停止自动操作，不回退到未经验证的通用策略。

## 安全与正确性约束

- 传奇杯 AI 与其他剧本 AI 隔离；不得把 LegendAI 的规则直接套用于其他剧本。
- 保留旧 AI 作为决策引擎时，先忠实适配它的输入输出，不能自行重命名或猜测字段含义。
- `islegal` 的含义需从样本/调用代码验证后才能用作执行门禁。
- 任何一回合都必须记录：状态指纹、输入数据、AI 输出、最终行动、服务端结果和策略/程序版本。
- 未确认操作调用链之前，Bot 只运行在观察或影子模式，不发送猜测的操作请求。

## 当前可执行的下一步

先把历史环境中的 `LegendAI` 目录和传奇杯快照纳入可读取的研究材料，尤其是 `LegendAI/UmaAi.exe`、配置、调用它的程序/脚本，以及 `turn0`–`turn71`。当前仓库只包含 URADLL 参考源码，缺少这些文件，无法凭空还原旧 AI 的输入输出契约。拿到这些材料后，优先做协议逆向与影子模式适配，而不是先写一个新的训练评分公式。