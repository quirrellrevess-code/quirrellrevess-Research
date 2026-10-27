using System.Collections.Generic;

namespace UmamusumeResponseAnalyzer.Entities;

public class Story
{
	public int Id { get; set; }

	public string Name { get; set; } = string.Empty;

	public string TriggerName { get; set; } = string.Empty;

	public List<List<Choice>> Choices { get; set; } = new List<List<Choice>>();
}
