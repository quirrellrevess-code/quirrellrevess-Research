# UmaAI-Research Progress: LegendAI Suggestion Capture

Date: 2026-10-26
Branch: `analysis/qianye-reverse-engineering-20261025`
Mode: Read-only investigation; no game actions or configuration changes.

## Confirmed

- The project reuses the existing LegendAI/UmaAi decision engine. The user has confirmed that LegendAI's computed recommendations are already delivered to `UmamusumeResponseAnalyzer.exe` (the “small blackboard”). Do not spend time re-verifying this link.
- LegendAI game-state snapshots are available as structured JSON under `D:\\Games\\ai\\LegendAI\\.portable\\PluginData\\SendGameStatusPlugin\\GameStatusSend_Legend\\thisTurn.json`; a previously inspected sample was valid JSON and contained turn/scenario/training state.
- Analyzer process previously observed at `D:\\Games\\ai\\LegendAI\\UmamusumeResponseAnalyzer.exe`, listening on TCP port 4693.
- Hachimi HTTP forward plugin: `hachimi_httpforward_plugin.dll`; game root `D:\\KOMOE Game\\komoemumamusume\\komoemumamusume Game`.
- The plugin's documented role is forwarding game HTTP request/response bodies to the analyzer/notifier. This is a game-network-data path and must not be confused with the separate, already-confirmed LegendAI recommendation path.
- The supplied Hachimi config currently has `enable_ipc: false`, `ipc_listen_all: false`, and loads `hachimi_httpforward_plugin.dll`. The notifier defaults/settings are documented as `http://127.0.0.1:4693` with a 100 ms timeout; current on-disk values still need read-only verification.
- The analyzer's visible output has included recommendation text such as `AI建议：速98`, `AI建议：智46`, `AI建议：休息`, and event-choice suggestions. This proves human-visible text exists, but not yet a machine-readable extraction interface or reliable turn association.

## Current blocker

The missing link is a safe, machine-readable way to capture the analyzer's existing recommendation output and associate it with the matching `thisTurn.json` state. Port 4693 is a listener, but it has not been established as a general HTTP GET API or a recommendation-output endpoint. Do not probe it with guessed protocols or treat Hachimi's forwarded game traffic as the AI recommendation stream.

## Next steps

1. Read-only inspect whether `hachimi\\httpforward.json` exists; otherwise read the compatibility notifier fields from the actual `hachimi\\config.json`.
2. Read-only inspect the analyzer process metadata, modules, listener connections, and existing logs/files for an output/IPC interface.
3. If no existing machine-readable output interface is found, report the evidence and feasibility plainly before considering any further reverse engineering.

## Constraints and safety

- MVP-01 remains: reuse LegendAI's decision, automatically capture the suggestion and correlate it to the current turn, execute one verified speed-training action through a verifiable executor, then confirm the turn advanced.
- No manual screenshot collection, manually made PNG templates, or manual button-coordinate labeling. If the only viable route requires that work, stop and report infeasibility.
- No game input, configuration edits, process restarts, or other state-changing actions during this investigation without explicit approval.
- Taiwan server first; Japan only as reference; China server excluded.
- No GitHub Actions.
- No repository files or local configuration were changed during the investigation described above.


## Source-level findings added 2026-10-26

The public URA source repository `UmamusumeResponseAnalyzer/UmamusumeResponseAnalyzer` was inspected read-only:

- `Server.cs` registers only three relevant routes: `POST /notify/request`, `POST /notify/response`, and `GET /notify/ping`. The first two ingest game request/response MessagePack payloads; `/notify/ping` returns `pong`. No recommendation-read endpoint is documented or registered there.
- The project README describes URA as a local Terminal.Gui TUI host. The process expects an interactive terminal and exits when stdin/stdout are redirected. Therefore, the earlier observation of no ordinary window handle/UI Automation controls is consistent with a terminal UI and does not rule out reading its console screen buffer.
- The Hachimi plugin source explicitly POSTs game traffic to `/notify/request` and `/notify/response`; it does not implement a recommendation retrieval endpoint.
- This narrows the next low-cost experiment: use a read-only Windows console-buffer probe against the existing analyzer process (attach to its console, read the current screen buffer, detach), and pair any extracted recommendation with a stable snapshot of `thisTurn.json`. Do not send HTTP POSTs, touch game state, change settings, restart processes, or use screenshots/templates.
- Feasibility is not yet proven. Console attachment may fail if the process is hosted in a pseudoconsole or another incompatible terminal setup. If so, inspect only the existing process/terminal setup next rather than guessing network APIs.


## Probe script committed 2026-10-26

- Added `android-automation/legendai-readonly-capture/Probe-AnalyzerConsole.ps1` as a PowerShell 5.1-compatible, read-only console-buffer probe.
- It locates the analyzer by exact executable path, snapshots `thisTurn.json` before and after, attempts to attach to the analyzer console and read up to the last 80 non-empty buffer rows, writes a report under `%TEMP%`, and copies/verifies the report in the clipboard.
- It does not send input, click, restart processes, edit configuration, or change game state. The script has been committed to GitHub but has **not** been executed on the user's PC; success/failure of console attachment remains unverified.
- If it reports `CONSOLE_ATTACH: FAILED`, do not treat that alone as proof that the route is impossible; next inspect whether the analyzer is hosted by a classic Win32 console or a pseudoconsole. If it captures no suggestion text, the current buffer may not contain the desired rows; do not infer that the recommendation path is absent.


## 2026-10-27 — Root path rename impact check

- Static audit found a concrete build-path dependency: the plugin project defaulted to `..\\URA` for reference DLLs, while this branch's root directory is now `hshdbaj/`. The default would point to a missing directory unless overridden externally.
- Repair committed with the path-neutralization follow-up: project reference default now targets `..\\hshdbaj`; the source folder is normalized to `components/`, and workflow source paths/working directory are updated to match.
- Scope: static source/config verification only. No compilation, offline test run, GitHub Actions, game process, or game input was performed. Build/runtime behavior remains `NOT_VERIFIED` pending a permitted local offline test.
- MVP-01 priority unchanged: validate the read-only recommendation capture path and turn association before considering any real action.


## 2026-10-27 — Cross-branch path-reference repair

- Broader static inspection found six additional stale `..\\URA\\*.dll` HintPaths in `data/UmamusumeResponseAnalyzer.csproj`, in addition to the plugin project's default reference directory. They were changed to target the current root alias `hshdbaj/`.
- Repairs were committed and refs updated across all five existing public branches. The upload branch's root source directory was normalized to `components/`; workflow file paths were updated wherever they still referenced the old root source path. One intermediate root-level duplicate project file in the feature branch was removed in a follow-up commit.
- Static readback confirms the repaired paths and expected root entries. No compile, offline unit tests, Actions, game launch, or game input was run; runtime/build outcome remains `NOT_VERIFIED`.
- Next MVP-01 step remains a user-side run of the read-only console-buffer probe, then review the report for recommendation extraction and turn-state association.


## 2026-10-27 — Build dependency boundary

- Baseline comparison against pre-rename commit `6e46e42d340881cc60152ca0f547fd5555a7ec2f` shows that four referenced dependency DLLs (`Spectre.Console.dll`, `YamlDotNet.dll`, `WatsonWebserver.Lite.dll`, `WatsonWebserver.Core.dll`) were already absent from the tracked dependency directory before the rename and remain absent. Do not attribute these missing files to the rename.
- Stale root-relative references and workflow source paths have been repaired across all five branches; all 38 unique source paths referenced by the research branch's offline-test workflow exist in its current tree. Full build/test status remains NOT_VERIFIED because Actions and local builds were not run and the four DLLs are not tracked here.

## 2026-10-27 — First successful console capture and structured collector

- User-run report UmaAI-AnalyzerConsoleProbe-20261027-145753.txt confirms that the probe read a 120x30 console buffer from analyzer PID 21228.
- Captured line SCREEN[27]: AI建议：休息; state before and after remained turn=3, isRacing=False, scenarioId=10; the probe reports STATE_FILE_UNCHANGED_DURING_PROBE: True.
- This proves one successful read of the currently visible console buffer and extraction of one recommendation. It does not prove continuous capture, freshness of the recommendation, or reliable association across turn transitions.
- Added Collect-AnalyzerRecommendation.ps1: a PowerShell 5.1-compatible launcher that runs the console-attaching probe as a child process, redirects child stdout/stderr to TEMP files, parses the report into a JSON record, snapshots thisTurn.json before and after, and labels the result as a single-sample status rather than claiming full MVP acceptance.
- Expected output is a JSON file under %TEMP%. The collector has not yet been executed on the user's PC; PowerShell syntax/runtime behavior and its child-process behavior remain NOT_VERIFIED.
- Safety remains read-only: no game input, clicks, process restarts, network requests, or configuration changes. No GitHub Actions were run.
- Next: perform static review of the new script and regex against the supplied report; then provide one complete download-and-run command. Review the resulting JSON before making further changes. Do not start action execution until repeated capture and turn-association checks pass.

## 2026-10-27 — Collector runtime failure and encoding fix

- User-run collector produced a probe report but exited with code 1 while parsing the report: .NET Regex rejected the recommendation marker because the Chinese literal in the PowerShell script was decoded incorrectly by Windows PowerShell 5.1 when downloaded as UTF-8 without a BOM.
- The probe report itself exists; the failure happened in the collector parsing stage, before the post-capture state snapshot was read. Therefore stateAfter=null is a consequence of the parser exception, not evidence that the state file disappeared.
- Fixed the collector to use .NET regex Unicode escapes for the Chinese recommendation marker (AI Unicode code points), avoiding non-ASCII source literals in that regex. Commit: 25eef5a5437146374489d59492865156d9f5e95c.
- The fix is committed but not yet run on the user's PC. The previous run remains a failed collector test; no recommendation JSON was successfully parsed in that run.
- Safety: no game input, clicks, restarts, network requests, config changes, or GitHub Actions.


## 2026-10-27 — Second collector parsing failure and non-regex fix

- The user's second collector run still failed with the same malformed-regex error; its JSON had `probeExitCode=1`, `stateAfter=null`, and no parsed recommendation. The report was found, so this is still a collector parsing failure, not evidence that the state file is missing.
- Read back the committed collector source. It contained .NET regex Unicode escapes, but the observed runtime error still showed the mojibake marker and regex parser failure. The Unicode-escape approach is therefore not accepted as validated.
- Replaced regex-based recommendation extraction with ordinal string matching. The marker is built at runtime from UTF-16 code points (`AI` + U+5EFA + U+8BAE + U+FF1A), avoiding Chinese source literals and regex parsing entirely. Commit: 2928382252ff94f518d4e299e5ff972642ee452a.
- This change is committed but not yet run on the user's PC. For the next test, use a cache-busting query on the raw GitHub collector URL so an old CDN copy is not reused. Do not treat the collector as working until its new JSON is inspected.
- Safety remains read-only; no game actions, process restarts, configuration edits, network requests from the collector, or GitHub Actions were performed.


## 2026-10-27 — First successful structured collector run

- User ran the cache-busted latest collector and reported `CAPTURED_SINGLE_SAMPLE_STATE_UNCHANGED`.
- Captured recommendation: `比赛`; state before and after both show `turn=11`, `isRacing=true`, `scenarioId=10`; `stateFileUnchanged=true`; `errors=[]`.
- This validates the non-regex parser and confirms that the collector can produce a structured single-sample record from the visible analyzer buffer.
- Important unresolved diagnostic: `probeExitCode=1` despite the report being present and recommendation parsing succeeding. The probe source can emit a report after console attach/read, but the nonzero child exit must be diagnosed from the captured stderr/report before calling the subprocess path clean.
- Recommendation freshness and turn association remain unverified. The same state before/after only establishes that the state file did not change during this one sample; it does not prove that `比赛` was generated for turn 11.
- Next step: inspect the reported probe stderr and the full probe report read-only, then perform passive repeated sampling / freshness analysis without advancing the game. No game input, clicks, restarts, config edits, or GitHub Actions.


## 2026-10-27 — Probe report review after successful capture

- User supplied the complete probe report for the successful collector run at 2026-10-27 16:53:55. It shows analyzer PID 16668, a 120x30 buffer, `SCREEN[27]: AI建议：比赛`, and stable state `turn=11; isRacing=True; scenarioId=10` before and after.
- The report contains no explicit console attach, buffer info, or probe exception failure lines. This confirms the console-buffer read succeeded for that sample.
- The collector still recorded child `probeExitCode=1`; this is not explained by the report text alone. The next read-only diagnostic is the associated stderr file. Do not infer the exact source of the nonzero exit code until stderr is inspected.
- Current milestone: single-sample structured extraction works. Continuous capture, recommendation freshness, and turn association remain unverified. No game input or configuration change is authorized or performed.

## 2026-10-27 — Probe exit-code diagnosis and defensive console clear

- The user's stderr file contains only a Win32 error from assigning `$RawUI.CursorPosition`, with error identifier `ExceptionWhenSetting` and Win32 code `0x6` (invalid handle). The probe report itself had no console attach/read exception and contained a valid recommendation row.
- The probe's final `Clear-Host` is the likely trigger because the built-in clear-host operation manipulates console cursor state; the failure occurs after the report has already been written. This explains how a valid report can coexist with child exit code 1, though the fix still needs a user-side runtime check.
- Updated `Probe-AnalyzerConsole.ps1` to make the final `Clear-Host` best-effort inside `try/catch`, so an unsupported console cursor operation should not abort the probe after successful capture. Commit: `2a72642be497f2b677470a4016929ef57b25fc6a`.
- No game actions, clicks, process restarts, network requests, or configuration edits were performed. No GitHub Actions were run.
- Next: run the updated probe/collector once using the cache-busted raw URL, then verify that the recommendation/report still appear and `probeExitCode` is 0. If the exit code remains nonzero, inspect the new stderr rather than assuming the fix succeeded. Continuous capture, recommendation freshness, and turn association remain unverified.
