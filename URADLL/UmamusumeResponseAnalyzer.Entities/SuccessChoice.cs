namespace UmamusumeResponseAnalyzer.Entities;

public class SuccessChoice
{
	public int SelectIndex { get; set; }

	public State State { get; set; }

	public int Scenario { get; set; }

	public string Effect { get; set; } = string.Empty;
}
