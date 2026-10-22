using System;
using System.Collections.Generic;
using System.Linq;
using Gallop;
using UmamusumeResponseAnalyzer.Entities;

namespace UmamusumeResponseAnalyzer;

public class SkillManagerGenerator
{
	public static SkillManager Default;

	private static void ApplyHint(global::UmamusumeResponseAnalyzer.Entities.SkillData skill, SingleModeChara chara_info, int level)
	{
		int num = (chara_info.chara_effect_id_array.Contains(7) ? 10 : 0);
		int num2 = level switch
		{
			0 => 0, 
			1 => 10, 
			2 => 20, 
			3 => 30, 
			4 => 35, 
			5 => 40, 
		};
		skill.Cost = skill.Cost * (100 - num2 - num) / 100;
		if (skill.Rarity == 2)
		{
			int num3 = skill.Inferior?.HintLevel ?? 0;
			skill.HintLevel = ((num3 > level) ? num3 : level);
		}
		else
		{
			skill.HintLevel = level;
		}
	}

	internal static void ApplyProper(global::UmamusumeResponseAnalyzer.Entities.SkillData skill, SingleModeChara chara_info)
	{
		if (skill.Propers.Length == 0)
		{
			return;
		}
		skill.Grade = skill.Propers.Max((SkillProper i) =>
		{
			int num = skill.Grade;
			switch (i.Style)
			{
			case SkillProper.StyleType.Nige:
				num = applyProperLevel(num, chara_info.proper_running_style_nige);
				break;
			case SkillProper.StyleType.Senko:
				num = applyProperLevel(num, chara_info.proper_running_style_senko);
				break;
			case SkillProper.StyleType.Sashi:
				num = applyProperLevel(num, chara_info.proper_running_style_sashi);
				break;
			case SkillProper.StyleType.Oikomi:
				num = applyProperLevel(num, chara_info.proper_running_style_oikomi);
				break;
			}
			switch (i.Distance)
			{
			case SkillProper.DistanceType.Short:
				num = applyProperLevel(num, chara_info.proper_distance_short);
				break;
			case SkillProper.DistanceType.Mile:
				num = applyProperLevel(num, chara_info.proper_distance_mile);
				break;
			case SkillProper.DistanceType.Middle:
				num = applyProperLevel(num, chara_info.proper_distance_middle);
				break;
			case SkillProper.DistanceType.Long:
				num = applyProperLevel(num, chara_info.proper_distance_long);
				break;
			}
			return num;
		});
		static int applyProperLevel(int grade, int level)
		{
			switch (level)
			{
			case 7:
			case 8:
				return (int)Math.Round((double)grade * 1.1);
			case 5:
			case 6:
				return (int)Math.Round((double)grade * 0.9);
			case 2:
			case 3:
			case 4:
				return (int)Math.Round((double)grade * 0.8);
			case 1:
				return (int)Math.Round((double)grade * 0.7);
			default:
				return 0;
			}
		}
	}

	public SkillManager Apply(SingleModeChara chara_info)
	{
		List<global::UmamusumeResponseAnalyzer.Entities.SkillData> list = (from x in chara_info.skill_tips_array.SelectMany((SkillTips x) => Default[(GroupId: x.group_id, Rarity: x.rarity)])
			select x.Clone() into x
			where x.Rate > 0
			select x).ToList();
		if (Database.TalentSkill.TryGetValue(chara_info.card_id, out TalentSkillData[] value))
		{
			foreach (TalentSkillData talent in value.Where((TalentSkillData x) => x.Rank <= chara_info.talent_level))
			{
				if (!list.Any((global::UmamusumeResponseAnalyzer.Entities.SkillData x) => x.Id == talent.SkillId) && !chara_info.skill_array.Any((Gallop.SkillData y) => y.skill_id == talent.SkillId))
				{
					list.Add(Default[talent.SkillId].Clone());
				}
			}
		}
		Gallop.SkillData[] skill_array = chara_info.skill_array;
		foreach (Gallop.SkillData skillData in skill_array)
		{
			list.Add(Default[skillData.skill_id].Clone());
		}
		foreach (IGrouping<int, global::UmamusumeResponseAnalyzer.Entities.SkillData> group in from x in list
			group x by x.GroupId)
		{
			IEnumerable<global::UmamusumeResponseAnalyzer.Entities.SkillData> source = (from x in Default.GetAllByGroupId(@group.Key)
				where x.Rarity <= @group.Max((global::UmamusumeResponseAnalyzer.Entities.SkillData y) => y.Rarity)
				where x.Rate > 0
				select x).ExceptBy(list.Select((global::UmamusumeResponseAnalyzer.Entities.SkillData x) => x.Id), (global::UmamusumeResponseAnalyzer.Entities.SkillData x) => x.Id);
			list.AddRange(source.Select((global::UmamusumeResponseAnalyzer.Entities.SkillData x) => x.Clone()));
		}
		foreach (global::UmamusumeResponseAnalyzer.Entities.SkillData skill in list)
		{
			global::UmamusumeResponseAnalyzer.Entities.SkillData skillData2 = list.FirstOrDefault((global::UmamusumeResponseAnalyzer.Entities.SkillData x) => x.GroupId == skill.GroupId && x.Rarity == skill.Rarity && x.Rate == skill.Rate + 1);
			global::UmamusumeResponseAnalyzer.Entities.SkillData skillData3 = list.FirstOrDefault((global::UmamusumeResponseAnalyzer.Entities.SkillData x) => x.GroupId == skill.GroupId && x.Rarity == skill.Rarity + 1 && x.Rate == skill.Rate + 1);
			if (skillData2 != null)
			{
				skill.Superior = skillData2;
			}
			else if (skillData3 != null)
			{
				skill.Superior = skillData3;
			}
			global::UmamusumeResponseAnalyzer.Entities.SkillData skillData4 = list.FirstOrDefault((global::UmamusumeResponseAnalyzer.Entities.SkillData x) => x.GroupId == skill.GroupId && x.Rarity == skill.Rarity && x.Rate == skill.Rate - 1);
			global::UmamusumeResponseAnalyzer.Entities.SkillData skillData5 = list.FirstOrDefault((global::UmamusumeResponseAnalyzer.Entities.SkillData x) => x.GroupId == skill.GroupId && x.Rarity == skill.Rarity - 1 && x.Rate == skill.Rate - 1);
			if (skillData4 != null)
			{
				skill.Inferior = skillData4;
			}
			else if (skillData5 != null)
			{
				skill.Inferior = skillData5;
			}
		}
		foreach (global::UmamusumeResponseAnalyzer.Entities.SkillData i in list)
		{
			ApplyHint(i, chara_info, chara_info.skill_tips_array.FirstOrDefault((SkillTips x) => x.group_id == i.GroupId && x.rarity == i.Rarity)?.level ?? 0);
			ApplyProper(i, chara_info);
		}
		foreach (global::UmamusumeResponseAnalyzer.Entities.SkillData item in list.OrderByDescending((global::UmamusumeResponseAnalyzer.Entities.SkillData x) => x.Rate))
		{
			global::UmamusumeResponseAnalyzer.Entities.SkillData inferior;
			for (inferior = item.Inferior; inferior != null; inferior = inferior.Inferior)
			{
				if (chara_info.skill_array.Any((Gallop.SkillData x) => x.skill_id == inferior.Id))
				{
					item.Grade -= inferior.Grade;
					break;
				}
				item.Cost += inferior.Cost;
			}
		}
		return new SkillManager(list);
	}
}
