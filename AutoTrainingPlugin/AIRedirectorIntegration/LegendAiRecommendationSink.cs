using System;
using System.Globalization;
using System.IO;
using System.Text.Json;
using System.Text.RegularExpressions;

namespace UmaAutoTraining.AIRedirectorIntegration;

/// <summary>
/// Passive sink to be called from AIRedirector's existing single-consumer stdout path.
/// It records recommendations only; it never submits game commands.
/// </summary>
public sealed class LegendAiRecommendationSink : IDisposable
{
    private static readonly Regex RecommendationPrefix = new(
        @"^\s*AI建议\s*[:：]\s*(?<body>\S.*)$",
        RegexOptions.Compiled | RegexOptions.CultureInvariant);

    private readonly object _gate = new();
    private readonly string _filePath;
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
    /// Call only for a line from the Legend UmaAI process. The target is a snapshot
    /// obtained from AIRedirector's existing Legend output bridge; pass nulls when
    /// no target is known. This method never infers a turn from recommendation text.
    /// </summary>
    public bool TryRecord(
        string? rawLine,
        int? singleModeCharaId,
        int? turn,
        string source = "AIRedirector.Legend.stdout")
    {
        if (string.IsNullOrWhiteSpace(rawLine))
            return false;

        var match = RecommendationPrefix.Match(rawLine);
        if (!match.Success)
            return false;

        var body = match.Groups["body"].Value.Trim();
        if (body.Length == 0)
            return false;

        var record = new
        {
            timestamp_utc = DateTimeOffset.UtcNow.ToString("O", CultureInfo.InvariantCulture),
            source,
            single_mode_chara_id = singleModeCharaId,
            turn,
            raw_line = rawLine,
            recommendation = body,
            category = Classify(body),
            verified = false,
            executable = false
        };

        var json = JsonSerializer.Serialize(record);
        lock (_gate)
        {
            ObjectDisposedException.ThrowIf(_disposed, this);
            File.AppendAllText(_filePath, json + Environment.NewLine);
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
