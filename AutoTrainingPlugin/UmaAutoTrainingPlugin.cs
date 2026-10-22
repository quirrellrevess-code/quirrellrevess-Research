using System.Globalization;
using Newtonsoft.Json;
using Newtonsoft.Json.Linq;
using Spectre.Console;
using UmamusumeResponseAnalyzer.Plugin;

namespace UmaAutoTrainingPlugin;

/// <summary>
/// Passive observer for training-state responses and known action-request fields.
/// It never submits game actions.
/// </summary>
public sealed class UmaAutoTrainingPlugin : IPlugin
{
    private readonly object _fileLock = new();
    private string _logPath = string.Empty;
    private string _requestLogPath = string.Empty;

    public string Name => "UmaAutoTraining";
    public string Author => "UmaAI-Research";
    public string[] Targets => Array.Empty<string>();

    [PluginSetting]
    [PluginDescription("Record response snapshots to JSONL")]
    public bool RecordSnapshots { get; set; } = true;

    [PluginSetting]
    [PluginDescription("Write a concise console summary for each training state")]
    public bool ShowConsoleSummary { get; set; } = true;

    [PluginSetting]
    [PluginDescription("Passively record observed training action request fields; never sends requests")]
    public bool RecordActionRequests { get; set; } = true;

    public void Initialize()
    {
        Directory.CreateDirectory(Path.Combine("PluginData", Name));
        _logPath = Path.Combine("PluginData", Name, "observations.jsonl");
        _requestLogPath = Path.Combine("PluginData", Name, "action-requests-observed.jsonl");
        Console.WriteLine($"[{Name}] Initialized. Passive observation only; no game actions will be submitted.");
    }

    [Analyzer(response: true, priority: 1000)]
    public void AnalyzeResponse(JObject root)
    {
        try
        {
            var data = root["data"] as JObject ?? root;
            var chara = data["chara_info"] as JObject;
            var home = data["home_info"] as JObject;
            if (chara is null) return;

            var commands = home?["command_info_array"] as JArray;
            var snapshot = new JObject
            {
                ["captured_at_utc"] = DateTimeOffset.UtcNow.ToString("O", CultureInfo.InvariantCulture),
                ["turn"] = ReadInt(chara, "turn"),
                ["scenario_id"] = ReadInt(chara, "scenario_id"),
                ["vital"] = ReadInt(chara, "vital"),
                ["max_vital"] = ReadInt(chara, "max_vital"),
                ["motivation"] = ReadInt(chara, "motivation"),
                ["speed"] = ReadInt(chara, "speed"),
                ["stamina"] = ReadInt(chara, "stamina"),
                ["power"] = ReadInt(chara, "power"),
                ["guts"] = ReadInt(chara, "guts"),
                ["wiz"] = ReadInt(chara, "wiz"),
                ["command_count"] = commands?.Count ?? 0,
                ["commands"] = commands is null ? new JArray() : new JArray(commands.OfType<JObject>().Select(c => new JObject
                {
                    ["command_id"] = c["command_id"]?.DeepClone(),
                    ["failure_rate"] = c["failure_rate"]?.DeepClone(),
                    ["training_partner_count"] = (c["training_partner_array"] as JArray)?.Count ?? 0
                }))
            };

            if (RecordSnapshots)
            {
                Directory.CreateDirectory(Path.GetDirectoryName(_logPath)!);
                lock (_fileLock) File.AppendAllText(_logPath, snapshot.ToString(Formatting.None) + Environment.NewLine);
            }

            if (ShowConsoleSummary)
            {
                Console.WriteLine($"[UmaAutoTraining] turn={snapshot["turn"] ?? "?"}, vital={snapshot["vital"] ?? "?"}/{snapshot["max_vital"] ?? "?"}, " +
                    $"stats={snapshot["speed"] ?? "?"}/{snapshot["stamina"] ?? "?"}/{snapshot["power"] ?? "?"}/{snapshot["guts"] ?? "?"}/{snapshot["wiz"] ?? "?"}, commands={snapshot["command_count"]}");
            }
        }
        catch (Exception ex)
        {
            Console.Error.WriteLine($"[UmaAutoTraining] State capture failed: {ex.Message}");
        }
    }

    [Analyzer(response: false, priority: 1000)]
    public void AnalyzeRequest(JObject root)
    {
        if (!RecordActionRequests) return;

        try
        {
            // Only record the known command payload. Do not persist the full request,
            // which may contain unrelated or sensitive request metadata.
            var common = root["single_mode_exec_command_request_common"] as JObject
                ?? root.SelectToken("data.single_mode_exec_command_request_common") as JObject;
            if (common is null) return;

            var observed = new JObject
            {
                ["captured_at_utc"] = DateTimeOffset.UtcNow.ToString("O", CultureInfo.InvariantCulture),
                ["command_type"] = ReadInt(common, "command_type"),
                ["command_id"] = ReadInt(common, "command_id"),
                ["command_group_id"] = ReadInt(common, "command_group_id"),
                ["select_id"] = ReadInt(common, "select_id"),
                ["current_turn"] = ReadInt(common, "current_turn"),
                ["current_vital"] = ReadInt(common, "current_vital"),
                ["exec_auto_play_plan_id"] = ReadInt(common, "exec_auto_play_plan_id")
            };

            Directory.CreateDirectory(Path.GetDirectoryName(_requestLogPath)!);
            lock (_fileLock) File.AppendAllText(_requestLogPath, observed.ToString(Formatting.None) + Environment.NewLine);
            Console.WriteLine($"[UmaAutoTraining] Observed action request: turn={observed["current_turn"] ?? "?"}, type={observed["command_type"] ?? "?"}, id={observed["command_id"] ?? "?"}, group={observed["command_group_id"] ?? "?"}, select={observed["select_id"] ?? "?"}");
        }
        catch (Exception ex)
        {
            Console.Error.WriteLine($"[UmaAutoTraining] Action request observation failed: {ex.Message}");
        }
    }

    public Task UpdatePlugin(ProgressContext ctx) => Task.CompletedTask;
    public void Dispose() { }

    private static int? ReadInt(JObject obj, string key)
    {
        var token = obj[key];
        if (token is null || token.Type is JTokenType.Null or JTokenType.Undefined) return null;
        return int.TryParse(token.ToString(), NumberStyles.Integer, CultureInfo.InvariantCulture, out var value) ? value : null;
    }
}