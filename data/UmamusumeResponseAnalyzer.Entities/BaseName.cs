namespace UmamusumeResponseAnalyzer.Entities;

public class BaseName(int id, string name)
{
	public int Id { get; set; } = id;

	public string Name { get; set; } = name;

	public string Nickname { get; set; } = "未知";
}
