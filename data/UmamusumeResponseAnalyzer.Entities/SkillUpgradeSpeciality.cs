using System.Collections.Generic;

namespace UmamusumeResponseAnalyzer.Entities;

public class SkillUpgradeSpeciality
{
	public int ScenarioId;

	public int BaseSkillId;

	public int SkillId;

	public Dictionary<int, TalentSkillData.UpgradeCondition[]> UpgradeSkills = new Dictionary<int, TalentSkillData.UpgradeCondition[]>();
}
