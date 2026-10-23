# UmaAutoTrainingPlugin

## Current milestone: passive observation and guarded execution boundary

This repository contains three separate layers:

- **URA observations:** the C# plugin uses URADLL's `IPlugin` and response analyzer extension points to record normalized state snapshots to `PluginData/UmaAutoTraining/observations.jsonl`.
- **LegendAI recommendations:** the optional AIRedirector patch writes enriched recommendation telemetry to `legendai-recommendations.jsonl`, using the target character/turn context known to AIRedirector. The standalone Python stdout bridge is a fallback observer and writes to the separate `legendai-stdout-recommendations.jsonl` by default. Do not point both writers at the same file or treat the Python bridge's null turn as an association.
- **PC visual observation:** read-only helpers enumerate visible windows, capture a selected window's client-area screen rectangle, and classify a screen phase against user-supplied templates. The controller defines postconditions but has no verified input backend by default.

**No automated game actions are enabled.** The observed URA `/notify/request` and `/notify/response` routes are notification/dispatch paths, not proof of a supported command-submission channel. Do not treat a successful screenshot match, a backend's input acceptance, or a LegendAI recommendation as proof that an in-game action succeeded.

## Read-only PC window discovery

From the `AutoTrainingPlugin` directory on Windows:

```powershell
python .\\pc_window_probe.py
```

The output includes visible windows' HWND, PID, class name, and outer rectangle. Window titles are omitted unless `--include-titles` is explicitly supplied. Use the output to identify the intended client window; do not assume the first listed window is the game.

## Read-only phase observation

Optional dependencies: Python packages `opencv-python`, `numpy`, and `Pillow`. The offline CI suite does not require these packages because it uses deterministic test doubles.

Provide a local directory of phase templates named exactly for the phase identifiers, for example `training.png`, `event.png`, and `event_result.png`. Templates must come from a trusted, manually captured source; the observer never downloads templates.

Window-bound capture (replace the sample values with the actual HWND and PID reported by the probe):

```powershell
python .\\pc_screen_observer.py --hwnd 0x123456 --expected-pid 1234 --templates .\\templates --phases training event event_result
```

Or use an explicit desktop-coordinate bounding box:

```powershell
python .\\pc_screen_observer.py --bbox 100 100 1380 820 --templates .\\templates --phases training event event_result
```

The output is JSON with `mode=read_only`, capture rectangle, phase, confidence, verification flag, and reason. It returns an unknown/unverified result when evidence is missing, weak, malformed, or ambiguous. The numeric confidence threshold is a conservative initial heuristic, not a calibrated probability; templates and threshold must be validated against real screenshots before relying on classification.

## Read-only UI target candidates

Use `pc_target_observer.py` with manually prepared button/choice templates named by stable identifiers, such as `train_speed.png` or `event_choice.png`:

```powershell
python .\\pc_target_observer.py --hwnd 0x123456 --expected-pid 1234 --templates .\\target-templates --targets train_speed train_stamina event_choice
```

Each result contains a candidate bounding box in screen coordinates, confidence, and a reason. Similar high-confidence matches at distinct positions are rejected as ambiguous. Even a high-confidence candidate is always marked `executable=false`; target recognition alone does not authorize input, establish which target the policy intended, or prove that an action succeeded. Template matching is resolution/theme sensitive and must be checked against real screenshots before further integration. The separate `pc_action_target_mapping.py` module can resolve an explicit local `(phase, action_id) -> target_id` mapping only when the recommendation, run/turn, readiness, and unique target evidence all pass checks. Its output remains `executable=false`; free-form LegendAI text is not promoted into a verified action ID.

For offline inspection, `pc_action_preview.py` accepts a JSON file (or stdin) containing `recommendation`, `state`, `candidates`, and a `mapping` list of `phase/action_id/target_id` records. It prints a dry-run JSON result and never interacts with the game or submits input:

```powershell
python .\\pc_action_preview.py .\\sample-preview.json
Get-Content .\\sample-preview.json -Raw | python .\\pc_action_preview.py
```

A successful preview means only that the supplied evidence satisfies the mapping checks. It does not prove the supplied data came from a trusted live observer and does not authorize execution.

The window helper captures the selected client rectangle through desktop screenshot APIs. This is not a hidden/off-screen capture method: occlusion, minimized windows, display scaling, or desktop changes can affect the captured image. A visible HWND and matching PID guard selection, but do not prove the pixels belong exclusively to the game.

## Offline observation replay report

Use `observation_replay_report.py` to compare the three JSONL streams emitted by the passive URA plugin and one selected LegendAI recommendation writer. The report checks parse/schema quality, lists overlapping turns, and compares timestamps for recommendation/request records sharing a turn. Per-stream diagnostics distinguish missing, null, and invalid turn values, count unavailable/invalid timestamps, summarize timing-comparison coverage, and count recommendation `turn_association_status` values separately from missing/null/invalid status fields. These status labels describe the writer's available context only; `target_context_available_unverified` is not proof of turn ownership. The report does not claim that a request was caused by a recommendation; timestamp order is correlation evidence only.

The AIRedirector sink records `turn_association_status=target_context_available_unverified` only when both character and turn context are present; this indicates context availability, not proof that the recommendation belongs to that turn. When context is missing, it writes `unavailable_in_airredirector_context`. The standalone Python stdout bridge cannot infer this safely and marks `turn=null` with `turn_association_status=unavailable_in_stdout_only`. Never fill that turn using nearest timestamps. Use one writer's output for a report, e.g.:

```powershell
# AIRedirector patch sink output
python .\\observation_replay_report.py --observations .\\PluginData\\UmaAutoTraining\\observations.jsonl --requests .\\PluginData\\UmaAutoTraining\\action-requests-observed.jsonl --recommendations .\\PluginData\\UmaAutoTraining\\legendai-recommendations.jsonl

# Or standalone Python bridge output
python .\\observation_replay_report.py --observations .\\PluginData\\UmaAutoTraining\\observations.jsonl --requests .\\PluginData\\UmaAutoTraining\\action-requests-observed.jsonl --recommendations .\\PluginData\\UmaAutoTraining\\legendai-stdout-recommendations.jsonl
```

Exit code `0` means the streams parsed and required fields were present; `1` means malformed JSON lines or missing required fields were reported; `2` means an input file could not be read. The JSON output is always marked `executable=false`. This is an offline evidence report only: turn overlap is not causal proof, action IDs are not inferred, and no input is sent to the game.

## Guarded controller contract

`pc_turn_controller.py` allows at most one pending action and requires a fresh observation matching an explicit postcondition (`turn_advance` or `phase_change`) before confirming completion. Unsupported actions, stale recommendations, run mismatches, unexpected transitions, backend exceptions, or unconfirmed submissions halt or block execution. With no backend configured, requests are blocked with `pc_backend_unverified`.

These checks are defense-in-depth, not authorization to enable a real input backend. Before implementation, establish a supported input method and verify UI target detection, action-to-control mapping, focus handling, and post-action state evidence. No fixed-coordinate clicks, blind retries, memory injection, or protocol replay are used.

## Build

Requirements: .NET 10 SDK and the matching URA runtime assemblies.

```powershell
dotnet build .\\AutoTrainingPlugin.csproj -c Release -p:UraReferenceDir="D:\\path\\to\\URA"
```

Set `UraReferenceDir` to the directory containing `UmamusumeResponseAnalyzer.dll`, `Newtonsoft.Json.dll`, and `Spectre.Console.dll`.

To copy the built DLL into an installed URA Plugins directory during build, add:

```powershell
-p:UraPluginDir="D:\\path\\to\\UmamusumeResponseAnalyzer\\Plugins"
```

The plugin target framework and references must match the actual URA runtime. Full plugin build/load verification and live game-window capture have not yet been performed.

## Offline validation

GitHub Actions checks Python syntax and offline unit tests, validates the AIRedirector patch against a pinned upstream source revision, and compiles/runs a standalone .NET 10 smoke test for the passive recommendation sink. These checks do not prove that the plugin loads in the game or that visual recognition works against live client screenshots.

## Next milestones

1. Build and load the URA plugin against the exact installed URA assemblies.
2. Validate captured URA state and LegendAI recommendation association over representative turns.
3. Validate phase templates against real screenshots, including resolution/scaling and occlusion cases.
4. Validate read-only UI target detection against representative real screenshots, including repeated controls, uniform/blank frames, resolution changes, and display scaling.
5. Validate dry-run recommendation-to-target association against recorded observations; keep it non-executable.
6. Replay observations offline and verify action-to-control mapping before considering a real input backend.
7. Verify a supported, permitted execution channel and end-to-end postconditions before enabling any automated actions.
