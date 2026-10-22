# UmaAutoTrainingPlugin

## Current milestone: passive state collection

This is the first development milestone for an original Uma Musume auto-training plugin based on the uploaded URADLL source.

It implements URADLL's `IPlugin` and response `AnalyzerAttribute` extension points. When a response contains `data.chara_info`, it records a normalized snapshot of the turn, scenario, vitality, motivation, five core stats, and available command IDs / failure rates / training-partner counts.

By default, snapshots are appended to `PluginData/UmaAutoTraining/observations.jsonl`.

The plugin does **not** submit actions. The observed `/notify/request` and `/notify/response` routes are inbound notification endpoints; they do not establish a verified way to issue game commands. Automatic action execution will be implemented only after the actual request format, action IDs, and a valid execution channel have been verified.

## Build

Requirements: .NET 10 SDK and the matching URA runtime assemblies.

```powershell
dotnet build .\AutoTrainingPlugin.csproj -c Release -p:UraReferenceDir="D:\path\to\URA"
```

Set `UraReferenceDir` to the directory containing `UmamusumeResponseAnalyzer.dll`, `Newtonsoft.Json.dll`, and `Spectre.Console.dll`.

To copy the built DLL into an installed URA Plugins directory during build, add:

```powershell
-p:UraPluginDir="D:\path\to\UmamusumeResponseAnalyzer\Plugins"
```

The plugin's target framework and references must match the actual URA runtime. Build and runtime verification have not yet been performed.

## Next milestones

1. Verify that the plugin loads in the exact URA version and captures representative responses.
2. Inspect captured response shapes for each supported training scenario.
3. Implement a testable decision engine with an explainable score per available action.
4. Validate recommendations with offline replay.
5. Research and verify a supported action-execution channel before adding automated actions.