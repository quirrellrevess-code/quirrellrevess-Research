using System;

namespace UmamusumeResponseAnalyzer.Plugin;

[AttributeUsage(AttributeTargets.Property)]
public class PluginDescriptionAttribute(string description) : Attribute
{
	public string Description { get; } = description ?? string.Empty;
}
