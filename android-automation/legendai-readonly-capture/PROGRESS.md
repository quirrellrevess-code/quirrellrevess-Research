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
