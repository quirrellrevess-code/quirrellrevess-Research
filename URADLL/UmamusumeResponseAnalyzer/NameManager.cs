using System;
using System.Collections.Generic;
using System.Linq;
using UmamusumeResponseAnalyzer.Entities;
using UmamusumeResponseAnalyzer.Localization;

namespace UmamusumeResponseAnalyzer;

public class NameManager
{
	private static readonly BaseName nullBaseName = new BaseName(int.MinValue, global::UmamusumeResponseAnalyzer.Localization.NameManager.I18N_Unknown);

	private static readonly SupportCardName nullSupportCardName = new SupportCardName(int.MinValue, global::UmamusumeResponseAnalyzer.Localization.NameManager.I18N_Unknown, int.MinValue, int.MinValue);

	private static readonly UmaName nullUmaName = new UmaName(int.MinValue, global::UmamusumeResponseAnalyzer.Localization.NameManager.I18N_Unknown, int.MinValue);

	private readonly Dictionary<int, BaseName> names;

	public string this[int id] => GetSimpleName(id);

	public NameManager(List<BaseName> data)
	{
		names = data.ToDictionary((BaseName x) => x.Id, (BaseName x) => x);
		foreach (KeyValuePair<int, BaseName> item in names.Where((KeyValuePair<int, BaseName> x) => x.Value is SupportCardName))
		{
			item.Value.Nickname = ((SupportCardName)item.Value).TypeName + item.Value.Nickname;
		}
	}

	public BaseName GetCharacter(int id)
	{
		if (!names.TryGetValue(id, out BaseName value))
		{
			return nullBaseName;
		}
		return value;
	}

	public SupportCardName GetSupportCard(int id)
	{
		if (!names.TryGetValue(id, out BaseName value))
		{
			return nullSupportCardName;
		}
		if (!(value is SupportCardName))
		{
			throw new Exception(string.Format(global::UmamusumeResponseAnalyzer.Localization.NameManager.I18N_CastToSupportCardNameFail, value.GetType()));
		}
		return (SupportCardName)value;
	}

	public UmaName GetUmamusume(int id)
	{
		if (!names.TryGetValue(id, out BaseName value))
		{
			return nullUmaName;
		}
		if (!(value is UmaName))
		{
			throw new Exception(string.Format(global::UmamusumeResponseAnalyzer.Localization.NameManager.I18N_CastToUmaNameFail, value.GetType()));
		}
		return (UmaName)value;
	}

	private string GetSimpleName(int id)
	{
		if (!names.TryGetValue(id, out BaseName value))
		{
			return global::UmamusumeResponseAnalyzer.Localization.NameManager.I18N_Unknown;
		}
		if (!(value is SupportCardName supportCardName))
		{
			if (value is UmaName umaName)
			{
				return umaName.CharacterName;
			}
			return value.Name;
		}
		return supportCardName.SimpleName;
	}

	public int GetRSupportCardTypeByCharaId(int charaId)
	{
		if (!names.Values.OfType<SupportCardName>().Any((SupportCardName card) => card.Id >= 10000 && card.Id <= 12000 && card.CharaId == charaId))
		{
			return -1;
		}
		List<SupportCardName> list = (from card in names.Values.OfType<SupportCardName>()
			where card.Id >= 10000 && card.Id <= 12000 && card.CharaId == charaId
			select card).ToList();
		if (list.Count == 0)
		{
			return -1;
		}
		if (list.Count > 1)
		{
			throw new Exception($"找到多个CharaId为{charaId}且ID介于10000和12000之间的SupportCardName。");
		}
		return list[0].Type;
	}
}
