namespace UmamusumeResponseAnalyzer.Entities;

public class Choice
{
	public StoryEffectValue? SuccessEffectValue;

	public StoryEffectValue? FailedEffectValue;

	public string Option { get; set; } = string.Empty;

	public string SuccessEffect { get; set; } = string.Empty;

	public string FailedEffect { get; set; } = string.Empty;
}
