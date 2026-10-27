using System;
using System.Collections.Generic;
using System.Linq;
using Gallop;

namespace UmamusumeResponseAnalyzer.Entities;

public class TalentSkillData
{
	public class UpgradeCondition
	{
		public enum ConditionType
		{
			None,
			Proper,
			Specific,
			Speed,
			Acceleration,
			Recovery,
			Lane,
			Stat
		}

		public int ConditionId;

		public int Group;

		public ConditionType Type;

		public int Requirement;

		public int AdditionalRequirement;

		public bool IsArchived(SingleModeChara chara_info, IEnumerable<SkillData> skills)
		{
			SkillUpgradeInfo skillUpgradeInfo = chara_info.skill_upgrade_info_array.FirstOrDefault((SkillUpgradeInfo x) => x.condition_id == ConditionId);
			if (skillUpgradeInfo?.current_count == skillUpgradeInfo?.total_count)
			{
				return true;
			}
			int num = skillUpgradeInfo?.current_count ?? 0;
			switch (Type)
			{
			case ConditionType.Proper:
				if (Requirement >= 1 && Requirement <= 4)
				{
					int requirement = Requirement;
					SkillProper.StyleType properType = requirement switch
					{
						1 => SkillProper.StyleType.Nige, 
						2 => SkillProper.StyleType.Senko, 
						3 => SkillProper.StyleType.Sashi, 
						4 => SkillProper.StyleType.Oikomi, 
					};
					return num + skills.Count((SkillData x) => x.Propers.Any((SkillProper y) => y.Style == properType)) >= AdditionalRequirement;
				}
				if (Requirement >= 5 && Requirement <= 8)
				{
					int requirement = Requirement;
					SkillProper.DistanceType properType2 = requirement switch
					{
						5 => SkillProper.DistanceType.Short, 
						6 => SkillProper.DistanceType.Mile, 
						7 => SkillProper.DistanceType.Middle, 
						8 => SkillProper.DistanceType.Long, 
					};
					return num + skills.Count((SkillData x) => x.Propers.Any((SkillProper y) => y.Distance == properType2)) >= AdditionalRequirement;
				}
				if (Requirement == 9)
				{
					SkillProper.GroundType properType3 = SkillProper.GroundType.Dirt;
					return num + skills.Count((SkillData x) => x.Propers.Any((SkillProper y) => y.Ground == properType3)) >= AdditionalRequirement;
				}
				throw new Exception("出现了预料外的Requirement");
			case ConditionType.Specific:
				return skills.Any((SkillData x) => x.Id == Requirement);
			case ConditionType.Speed:
				return num + skills.Count((SkillData x) => x.Category == SkillCategory.Speed) >= Requirement;
			case ConditionType.Acceleration:
				return num + skills.Count((SkillData x) => x.Category == SkillCategory.Acceleration) >= Requirement;
			case ConditionType.Recovery:
				return num + skills.Count((SkillData x) => x.Category == SkillCategory.Recovery) >= Requirement;
			case ConditionType.Lane:
				return num + skills.Count((SkillData x) => x.Category == SkillCategory.Lane) >= Requirement;
			case ConditionType.Stat:
				return num + skills.Count((SkillData x) => x.Category == SkillCategory.Stat) >= Requirement;
			default:
				return false;
			}
		}
	}

	public static IEnumerable<(int ScenarioId, int Rank, int ConditionId)> SCENARIO_CONDITIONS = new int[4] { 6030101, 6030201, 6050101, 6050201 }.Select((int x) =>
	{
		string text = x.ToString();
		return ((int)char.GetNumericValue(text[0]), (int)char.GetNumericValue(text[2]), x: x);
	});

	public int SkillId;

	public int Rank;

	public Dictionary<int, UpgradeCondition[]> UpgradeSkills = new Dictionary<int, UpgradeCondition[]>();

	public bool CanUpgrade(SingleModeChara chara_info, out int upgradedSkillId, IEnumerable<SkillData> skills)
	{
		upgradedSkillId = 0;
		if (chara_info.skill_upgrade_info_array == null)
		{
			return false;
		}
		if (chara_info.talent_level < Rank)
		{
			return false;
		}
		IEnumerable<(int ScenarioId, int Rank, int ConditionId)> currentScenarioConditions = SCENARIO_CONDITIONS.Where(((int ScenarioId, int Rank, int ConditionId) x) => x.ScenarioId == chara_info.scenario_id && x.Rank == Rank);
		if (currentScenarioConditions.Any() && chara_info.skill_upgrade_info_array.Where((SkillUpgradeInfo x) => currentScenarioConditions.Any(((int ScenarioId, int Rank, int ConditionId) y) => y.ConditionId == x.condition_id)).All((SkillUpgradeInfo x) => x.current_count == x.total_count))
		{
			upgradedSkillId = UpgradeSkills.Keys.First();
			return true;
		}
		foreach (KeyValuePair<int, UpgradeCondition[]> upgradeSkill in UpgradeSkills)
		{
			if ((from x in upgradeSkill.Value
				group x by x.Group).All((IGrouping<int, UpgradeCondition> x) => x.Any((UpgradeCondition y) => y.IsArchived(chara_info, skills))))
			{
				upgradedSkillId = upgradeSkill.Key;
				return true;
			}
		}
		return false;
	}
}
