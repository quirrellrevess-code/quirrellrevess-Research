using System.Collections.Generic;

namespace UmamusumeResponseAnalyzer.Entities;

public class SkillData
{
	private string translatedName;

	public bool? IsScenarioEvolution { get; set; }

	public List<SkillData> Upgrades { get; set; } = new List<SkillData>();

	public SkillData? Superior { get; set; }

	public SkillData? Inferior { get; set; }

	public string Name { get; set; }

	public string DisplayName
	{
		get
		{
			return translatedName ?? Name;
		}
		set
		{
			translatedName = value;
		}
	}

	public int Id { get; init; }

	public int GroupId { get; init; }

	public int Rarity { get; init; }

	public int Rate { get; init; }

	public int Grade { get; set; }

	public int Cost { get; set; }

	public int HintLevel { get; set; }

	public int DisplayOrder { get; init; }

	public SkillProper[] Propers { get; init; }

	public SkillCategory Category { get; init; }

	public (int GroupId, int Rarity, int Rate) Deconstruction()
	{
		return (GroupId: GroupId, Rarity: Rarity, Rate: Rate);
	}

	public SkillData Clone()
	{
		return (SkillData)MemberwiseClone();
	}
}
