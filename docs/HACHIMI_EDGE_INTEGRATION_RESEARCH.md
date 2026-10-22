# Hachimi Edge 接入研究：LegendAI 自动育成 Bot

## 目标

运行环境为“赛马娘 PC 客户端 + Hachimi Edge 转发功能”。Hachimi 的主要用途是文本替换与图形解锁；本项目使用其转发能力作为现有数据链路的一部分，而不是把自研 Hachimi 插件作为首要方案。现有传奇杯 LegendAI 仍是唯一决策者；Bot 只读取其建议并将建议安全地执行到游戏中。

## 上传包与现有部署的静态检查

检查对象：会话附件 `ai.zip`（1,890 个条目，约 187 MB 解压数据）。只读取归档目录、配置和 JSON 样本；未执行任何 EXE/DLL，也未将游戏二进制、AI 程序、缓存或回合数据上传到项目仓库。

- 该归档实际包含 `.portable/`（URADLL/UmamusumeResponseAnalyzer 部署结构）、`LegendAI/`、`MechaAI/`、`CookAI/`；在归档清单中未发现 `UnityPlayer_orig.rar`、`UnityPlayer_orig.dll` 或明确的 Hachimi 安装目录/配置。因此本次附件足以研究 URA/LegendAI 侧，但还不能据此验证 Hachimi 转发端的具体设置。
- `.portable/config.yaml` 显示 URA 监听配置为 `0.0.0.0:4693`，启用了 `AIRedirector` 的 Legend 项，路径为 `../LegendAI/UmaAI.exe`，同时启用了 `SendGameStatusPlugin`。`0.0.0.0` 是全网卡绑定配置；实际部署时应确认防火墙和监听范围，不要默认把本地分析端口暴露给不可信网络。
- `LegendAI/aiConfig_cpu.json` 的 `communicationMode` 是注释状态；同目录副本配置含 `"communicationMode": "urafile"`。所以当前实际运行使用哪一种模式仍未由配置唯一确定。`UmaAi.exe` 静态字符串同时出现 `http://127.0.0.1:4693`、`/UmamusumeResponseAnalyzer/GameData/thisTurn.json`、`gamedata/thisTurn.json` 和 `urafile`，说明程序包含本地 HTTP/文件通信相关路径，但仅靠字符串不能确认当前会走哪条路径。
- `.portable/PluginData/SendGameStatusPlugin/GameStatusSend_Legend/turn0.json` 及 `LegendAI/log/turn0_2.json` 等样本包含传奇杯每回合状态字段；归档中有 turn0–turn71 一系列样本。这些是状态/输入样本，不是 AI 行动建议本身。
- 公开的 [AIRedirector 源码](https://github.com/URA-Plugins/AIRedirector) 已明确其会启动配置的 `UmaAI.exe`，以 UTF-8 读取子进程 stdout/stderr；`LegendAiOutputBuffer` 解析 `AI建议...`、五项训练评分、休息/外出评分、心得选项评分和部分摘要，再交给 URA UI 显示。它目前的已证实用途是展示建议，不等于已经提供给外部 Bot 的 IPC/API。
- 公开的 [SendGameStatusPlugin 源码](https://github.com/URA-Plugins/SendGameStatusPlugin) 与本地目录相符：它按剧本输出状态 JSON，包括 `thisTurn.json` 和 `turn{turn}.json`。不要把这些 JSON 文件误认为 AI 决策结果。

## 目前从公开源码确认的事实

- 本项目实际使用 Hachimi Edge 的转发功能；Hachimi 本身主要用于文本替换和图形解锁，不应把它误认为训练决策 AI。
- Hachimi 的转发链路可用于将游戏请求/响应交给 URADLL 等接收端分析；需要以本机实际配置确认转发目标、协议与覆盖范围。转发收到的游戏流量不等于已具备向游戏提交新动作的能力。
- Hachimi Edge 也有插件机制，但这属于备用研究方向，不是当前首选集成路线。
- 公开插件 `SparkCollectPlugin` 展示了 Hachimi 插件可以通过 SDK 查找 IL2CPP 类、安装函数 hook，并拦截 `Gallop.HttpHelper.DecompressResponse`。该插件读取的是游戏已经解密、解压的响应数据，并对指定育成响应进行解析。
- 因此 Hachimi Edge 插件机制可能是观察游戏响应的可行入口，但这**不等于**已有公开的当前育成状态 API，更不等于可以通过插件直接提交育成操作。
- URADLL 中的 `/notify/request`、`/notify/response` 是通知/分析入口，不应被当成动作提交 API。`SingleModeExecCommandRequest` 只是请求数据模型，不能单独证明发送路径。

## 推荐架构

1. **LegendAI**：继续作为唯一决策者，使用现有 URA/Hachimi 数据链路读取游戏状态并生成传奇杯行动建议。
2. **建议桥接层**：现有 AIRedirector 已启动 `UmaAi.exe` 并读取 UTF-8 stdout；其解析器识别以 `AI建议` 开头的行，但当前已证实功能是将建议显示在 URA UI。优先给现有输出增加一个明确、可审计的外部桥接（例如本地命名管道或原子写入的 JSONL 文件），避免另起一个 AI 进程与现有实例争用数据通道。输出应保留原始行和回合/育成 ID 关联；不得凭自由文本猜测未支持的动作。
3. **转发接收/结果核验层**：复用现有 Hachimi 转发链路及 URA 接收端，必要时只取最少的回合标识和执行结果；不另造一套决策状态管线。转发链路是否能用于动作提交必须单独验证。
4. **执行器**：把已识别的建议映射到经验证的游戏操作通道；执行前校验回合与动作，执行后确认结果，避免重复提交。
5. **安全控制**：默认影子模式；未知动作、协议错误、回合不匹配或执行结果不确定时停止。

## 接下来必须验证

- 本机 Hachimi 转发的实际配置、目标地址、转发的请求/响应类型，以及 URADLL 接收端的协议与运行方式。
- 仅当转发链路无法满足确有必要的结果核验需求时，再调查 Hachimi Edge 插件 SDK 与 hook。
- `Gallop.HttpHelper.DecompressResponse` 对应响应中，传奇杯建议执行后可观察到哪些确认信号；只做结果核验，不复制完整状态采集管线。
- 游戏客户端的操作请求如何构造、序列化、发送，以及请求与响应如何关联。不能仅凭响应 hook 反推提交能力。
- 在当前 URA 版本中，AIRedirector 的 stdout 解析结果如何安全地暴露给 Bot；当前源码确认的是 UI 展示，尚无已验证的外部 IPC/API。
- 本次附件没有 Hachimi 配置或 UnityPlayer_orig 文件，仍需后续对照实际 Hachimi 转发配置确认转发目标与请求/响应覆盖范围。
- PC 客户端版本、Unity/IL2CPP 架构和 Hachimi 插件 SDK 必须以实际安装版本为准，不能直接照搬针对其他客户端版本的二进制或偏移。

## 边界与风险

- Hachimi Edge 项目 README 提醒该 mod 可能违反游戏服务条款；使用者应自行评估账号、服务条款和安全风险。
- 不在协议未经验证前提交操作，不自动重试未知结果的动作。
- 不在本项目中重新实现 LegendAI 的训练评分或把传奇杯策略泛化到其他剧本。

## 参考源码

- Hachimi Edge: https://github.com/kairusds/Hachimi-Edge
- Hachimi Edge 简体中文 README: https://github.com/kairusds/Hachimi-Edge/blob/main/README-zh_cn.md
- 示例插件 SparkCollectPlugin: https://github.com/xialight/SparkCollectPlugin
- 现有执行器契约: `docs/LEGEND_AI_EXECUTOR_CONTRACT.md`
- 现有开发方案: `docs/LEGEND_AI_AUTOMATION_BOT_PLAN.md`
