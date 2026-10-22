using System;

namespace UmamusumeResponseAnalyzer.Plugin;

[AttributeUsage(AttributeTargets.Assembly, AllowMultiple = true)]
public class SharedContextWithAttribute(params string[] pluginNames) : Attribute
{
	public string[] PluginNames { get; } = pluginNames;
}
