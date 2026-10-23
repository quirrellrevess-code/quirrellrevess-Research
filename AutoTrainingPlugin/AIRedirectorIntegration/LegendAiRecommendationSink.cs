using System;
using System.Globalization;
using System.IO;
using System.Text.Json;
using System.Text.RegularExpressions;

namespace UmaAutoTraining.AIRedirectorIntegration;

/// <summary>
/// Passive sink for AIRedirector's existing single-consumer Legend stdout path.
/// It records recommendations only and never submits game commands.
/// </summary>
public sealed class LegendAiRecommendationSink : IDisposable
{
    private static readonly Regex RecommendationPrefix = new(
        @"^\s*AI建议\s*[:：]\s*(?<body>\S.*)$",
        RegexOptions.Compiled | RegexOptions.CultureInvariant);

    private readonly object _gate = new();
    private readonly string _filePath;
    private int? _singleModeCharaId;
    private int? _turn;
    private bool _disposed;

    public LegendAiRecommendationSink(string? pluginDataRoot = null)
    {
        var root = string.IsNullOrWhiteSpace(pluginDataRoot)
            ? Path.Combine("PluginData", "UmaAutoTraining")
            : pluginDataRoot;
        Directory.CreateDirectory(root);
        _filePath = Path.Combine(root, "legendai-recommendations.jsonl");
    }

    /// <summary>
    /// Call beside AIRedirector's existing Legend output bridge SetTarget call.
    /// A null target deliberately clears association when no valid target is known.
    /// </summary>
    public void SetTarget(int? singleModeCharaId, int? turn)
    {
        lock (_gate)
        {
            ObjectDisposedException.ThrowIf(_disposed, this);
            _singleModeCharaId = singleModeCharaId;
            _turn = turn;
        }
    }

    /// <summary>
    /// Call only for a line from the Legend UmaAI process, after the existing
    /// bridge has accepted the line. Recommendations are always non-executable.
    /// </summary>
    public bool TryRecord(string? rawLine, string source = "AIRedirector.Legend.stdout")
    {
        if (string.IsNullOrWhiteSpace(rawLine))
            return false;

        var match = RecommendationPrefix.Match(rawLine);
        if (!match.Success)
            return false;

        var body = match.Groups["body"].Value.Trim();
        if (body.Length == 0)
            return false;

        lock (_gate)
        {
            ObjectDisposedException.ThrowIf(_disposed, this);
            var record = new
            {
                timestamp_utc = DateTimeOffset.UtcNow.ToString("O", CultureInfo.InvariantCulture),
                source,
                single_mode_chara_id = _singleModeCharaId,
                turn = _turn,
                raw_line = rawLine,
                recommendation = body,
                category = Classify(body),
                verified = false,
                executable = false
            };

            File.AppendAllText(_filePath, JsonSerializer.Serialize(record) + Environment.NewLine);
        }
        return true;
    }

    private static string Classify(string body)
    {
        if (body.Contains("训练", StringComparison.Ordinal) ||
            body.Contains("トレーニング", StringComparison.Ordinal))
            return "training";

        if (body.Contains("休息", StringComparison.Ordinal) ||
            body.Contains("外出", StringComparison.Ordinal) ||
            body.Contains("保健室", StringComparison.Ordinal) ||
            body.Contains("休む", StringComparison.Ordinal))
            return "named_action";

        if (body.Contains("第", StringComparison.Ordinal) ||
            body.Contains("选", StringComparison.Ordinal) ||
            body.Contains("選", StringComparison.Ordinal) ||
            body.Contains("个", StringComparison.Ordinal) ||
            body.Contains("番", StringComparison.Ordinal))
            return "selection_text";

        return "unknown";
    }

    public void Dispose()
    {
        lock (_gate)
            _disposed = true;
    }
}
