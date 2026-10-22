using System;

namespace UmamusumeResponseAnalyzer.Plugin;

[AttributeUsage(AttributeTargets.Method)]
public class AnalyzerAttribute(bool response = true, int priority = 0) : Attribute
{
	public int Priority { get; } = priority;

	public bool Response { get; } = response;
}
