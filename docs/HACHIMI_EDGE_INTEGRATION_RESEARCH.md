# Hachimi Edge 接入研究：LegendAI 自动育成 Bot

## 目标

优先评估“赛马娘 PC 客户端 + Hachimi Edge”作为运行基础。现有传奇杯 LegendAI 仍是唯一决策者；本项目只负责读取其建议并将建议安全地执行到游戏中。

## 目前从公开源码确认的事实

- Hachimi Edge 是游戏增强/翻译 mod，仓库使用 Rust，并提供插件机制；官方 README 的主要功能介绍聚焦翻译、配置界面和画质设置，并未承诺通用的游戏动作控制 API。
- 公开插件 `SparkCollectPlugin` 展示了 Hachimi 插件可以通过 SDK 查找 IL2CPP 类、安装函数 hook，并拦截 `Gallop.HttpHelper.DecompressResponse`。该插件读取的是游戏已经解密、解压的响应数据，并对指定育成响应进行解析。
- 因此 Hachimi Edge 插件机制可能是观察游戏响应的可行入口，但这**不等于**已有公开的当前育成状态 API，更不等于可以通过插件直接提交育成操作。
- URADLL 中的 `/notify/request`、`/notify/response` 是通知/分析入口，不应被当成动作提交 API。`SingleModeExecCommandRequest` 只是请求数据模型，不能单独证明发送路径。

## 推荐架构

1. **LegendAI**：继续负责读取它需要的游戏数据，并独立生成传奇杯行动建议。
2. **AI 建议适配器**：研究 UmaAi.exe/LegendAI 的真实启动方式、输入输出与建议格式；不预设文件、JSON、stdout 或 IPC 协议。
3. **Hachimi Edge 适配层（候选）**：只在确有必要时提供游戏响应观察、动作结果确认或经证据验证的调用能力。避免重复实现 LegendAI 已经拥有的读取逻辑。
4. **执行器**：将 AI 建议映射到经验证的游戏动作提交通道；执行前校验回合与动作，执行后确认结果，避免重复提交。
5. **安全控制**：默认影子模式；未知动作、协议错误、回合不匹配或执行结果不确定时停止。

## 接下来必须验证

- Hachimi Edge 当前版本的插件 SDK 与插件加载目录、日志和生命周期。
- `Gallop.HttpHelper.DecompressResponse` 对应响应中，传奇杯建议执行后可观察到哪些确认信号；只做结果核验，不复制完整状态采集管线。
- 游戏客户端的操作请求如何构造、序列化、发送，以及请求与响应如何关联。不能仅凭响应 hook 反推提交能力。
- LegendAI 实际如何向宿主返回行动建议，宿主能否在不改写决策逻辑的前提下读取该建议。
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
