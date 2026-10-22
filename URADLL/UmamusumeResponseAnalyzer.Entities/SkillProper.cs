namespace UmamusumeResponseAnalyzer.Entities;

public class SkillProper
{
	public enum GroundType
	{
		None,
		Turf,
		Dirt
	}

	public enum DistanceType
	{
		None,
		Short,
		Mile,
		Middle,
		Long
	}

	public enum StyleType
	{
		None,
		Nige,
		Senko,
		Sashi,
		Oikomi
	}

	public GroundType Ground { get; set; }

	public DistanceType Distance { get; set; }

	public StyleType Style { get; set; }
}
