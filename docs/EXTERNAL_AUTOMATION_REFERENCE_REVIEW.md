# 外服自动化参考项目技术评估（2026-10-23）

## 来源
- https://github.com/skkwowee/uma-musume-pc-automation （公开 Python 源码，main）
- https://github.com/Remezzo/Umamusume-Icarus （公开仓库主要为 README/CHANGELOG，核心实现未公开）

## PC automation：已在源码中观察到
- `uma_automation.py` 使用 `ImageGrab` 截图、OpenCV `matchTemplate`、Tesseract OCR 和 `pyautogui.click`。
- `window_detector.py` 包含窗口定位、聚焦与相对/绝对坐标换算。
- 其训练界面按模板顺序选第一个训练，事件选项可默认第一项；这不是我们所需的 AI 决策。
- README 要求自行提供模板图；默认配置含重试。不可直接照搬盲重试、全屏回退或未验证点击。

## Icarus：README 声称，未验证
- 声称 headless 直连游戏 API，不依赖 OCR/窗口。
- 声称多剧本、自动训练、事件、比赛及恢复能力。
- 公开 main 文件树只有 README、CHANGELOG、LICENSE、图片等；没有公开可审计的核心执行器。
- 国际服与当前目标服务器兼容性未知。不要复用登录凭据、协议重放或未经证实的接口。

## 结合现有 UmaAI 的推荐架构
1. 保留 URA/AIRedirector/Hachimi 的现有只读状态观测，作为育成回合和任务 ID 的权威来源。
2. 保留 LegendAI 决策；不要采用“第一个训练/第一个事件选项”。
3. PC 视觉层只负责定位当前游戏窗口、识别页面和控件、确定点击目标。优先固定窗口客户端区域，支持 DPI/缩放校准；无法识别时停止。
4. 独立执行层必须校验窗口 PID、前台焦点、界面状态、唯一匹配目标、run_id 和 turn。单次提交，之后等待新鲜游戏状态确认；禁止盲重试。
5. `PcTurnController` 当前要求成功提交后 turn+1；事件、确认、比赛流程可能不推进 turn，需要将来扩展为按 action 类型的后置条件，不能提前假设。
6. 初期先做纯观察/截图验证和离线模板测试；通过后再接入有明确权限边界的 PC 点击后端。
7. Icarus 仅作系统设计参考：幂等操作、异常停机、可观测性、阶段恢复；其实际协议实现不可验证。

## 现状
本文件是静态源码/README 评估；未运行两款外服工具，也未在用户游戏客户端上测试。