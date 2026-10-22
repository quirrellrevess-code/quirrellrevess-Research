using System;
using WatsonWebserver.Core;

namespace UmamusumeResponseAnalyzer.Plugin;

[AttributeUsage(AttributeTargets.Method)]
public class RouteAttribute(HttpMethod method, string path) : Attribute
{
	public HttpMethod Method { get; } = method;

	public string Path { get; } = path;
}
