using System;
using System.Collections.Generic;
using System.Linq;
using Gallop;
using UmamusumeResponseAnalyzer.Entities;

namespace UmamusumeResponseAnalyzer;

public class SkillManager(List<global::UmamusumeResponseAnalyzer.Entities.SkillData> list)
{
	public global::UmamusumeResponseAnalyzer.Entities.SkillData[] this[(int GroupId, int Rarity) tuple] => list.Where((global::UmamusumeResponseAnalyzer.Entities.SkillData x) => x.GroupId == tuple.GroupId && x.Rarity == tuple.Rarity).ToArray();

	public global::UmamusumeResponseAnalyzer.Entities.SkillData this[int Id]
	{
		get
		{
			return list.FirstOrDefault((global::UmamusumeResponseAnalyzer.Entities.SkillData x) => x.Id == Id);
		}
		set
		{
			if (list.FirstOrDefault((global::UmamusumeResponseAnalyzer.Entities.SkillData x) => x.Id == Id) == null && value != null)
			{
				list.Add(value);
			}
		}
	}

	public (int GroupId, int Rarity, int Rate) Deconstruction(int Id)
	{
		return this[Id].Deconstruction();
	}

	public global::UmamusumeResponseAnalyzer.Entities.SkillData[] GetAllByGroupId(int groupId)
	{
		return list.Where((global::UmamusumeResponseAnalyzer.Entities.SkillData x) => x.GroupId == groupId).ToArray();
	}

	public global::UmamusumeResponseAnalyzer.Entities.SkillData? GetSkillByName(string name)
	{
		return list.FirstOrDefault((global::UmamusumeResponseAnalyzer.Entities.SkillData x) => x.Name == name);
	}

	public void Evolve(SingleModeChara chara_info, IEnumerable<global::UmamusumeResponseAnalyzer.Entities.SkillData> willLearnSkills = null)
	{
		list.ForEach((global::UmamusumeResponseAnalyzer.Entities.SkillData x) =>
		{
			x.Upgrades.Clear();
		});
		if (Database.TalentSkill.TryGetValue(chara_info.card_id, out TalentSkillData[] value))
		{
			foreach (TalentSkillData item in value.Where((TalentSkillData x) => x.Rank <= chara_info.talent_level))
			{
				if (!item.CanUpgrade(chara_info, out var _, willLearnSkills ?? Array.Empty<global::UmamusumeResponseAnalyzer.Entities.SkillData>()))
				{
					continue;
				}
				foreach (int key in item.UpgradeSkills.Keys)
				{
					global::UmamusumeResponseAnalyzer.Entities.SkillData skillData = SkillManagerGenerator.Default[key].Clone();
					SkillManagerGenerator.ApplyProper(skillData, chara_info);
					skillData.Cost = this[item.SkillId].Cost;
					skillData.IsScenarioEvolution = false;
					this[item.SkillId].Upgrades.Add(skillData);
				}
			}
		}
		foreach (SkillUpgradeSpeciality upgraded in Database.SkillUpgradeSpeciality.Values)
		{
			global::UmamusumeResponseAnalyzer.Entities.SkillData skillData2 = this[upgraded.BaseSkillId];
			if (skillData2 == null || chara_info.scenario_id != upgraded.ScenarioId)
			{
				continue;
			}
			foreach (KeyValuePair<int, TalentSkillData.UpgradeCondition[]> upgradeSkill in upgraded.UpgradeSkills)
			{
				if ((from x in upgradeSkill.Value
					group x by x.Group).All((IGrouping<int, TalentSkillData.UpgradeCondition> x) => x.Any((TalentSkillData.UpgradeCondition y) => y.IsArchived(chara_info, willLearnSkills ?? Array.Empty<global::UmamusumeResponseAnalyzer.Entities.SkillData>()))))
				{
					global::UmamusumeResponseAnalyzer.Entities.SkillData skillData3 = SkillManagerGenerator.Default[upgradeSkill.Key].Clone();
					SkillManagerGenerator.ApplyProper(skillData3, chara_info);
					skillData3.Cost = list.First((global::UmamusumeResponseAnalyzer.Entities.SkillData x) => x.Id == upgraded.BaseSkillId).Cost;
					skillData3.IsScenarioEvolution = true;
					skillData2.Upgrades.Add(skillData3);
				}
			}
		}
	}

	public void RemoveLearned(SingleModeChara chara_info)
	{
		list.RemoveAll((global::UmamusumeResponseAnalyzer.Entities.SkillData x) => chara_info.skill_array.Any((Gallop.SkillData y) => y.skill_id == x.Id));
	}

	public IEnumerator<global::UmamusumeResponseAnalyzer.Entities.SkillData> GetEnumerator()
	{
		return list.GetEnumerator();
	}

	public List<global::UmamusumeResponseAnalyzer.Entities.SkillData> GetSkills()
	{
		return list;
	}
}
