namespace UmamusumeResponseAnalyzer.Entities;

public class Motivation(int m)
{
	private readonly int motivation = m;

	private readonly string enumString = m switch
	{
		1 => "绝不调", 
		2 => "不调", 
		3 => "普通", 
		4 => "好调", 
		5 => "绝好调", 
	};

	public static Motivation Best => new Motivation(5);

	public static Motivation Good => new Motivation(4);

	public static Motivation Normal => new Motivation(3);

	public static Motivation Bad => new Motivation(2);

	public static Motivation Worst => new Motivation(1);

	public static implicit operator int(Motivation m)
	{
		return m.motivation;
	}

	public static implicit operator string(Motivation m)
	{
		return m.enumString;
	}

	public string ToColoredString()
	{
		int num = motivation;
		return num switch
		{
			5 => $"[green]{this}[/]", 
			4 => $"[yellow]{this}[/]", 
			3 => $"[red]{this}[/]", 
			2 => $"[red]{this}[/]", 
			1 => $"[red]{this}[/]", 
		};
	}
}
