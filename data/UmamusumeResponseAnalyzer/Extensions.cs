using System;
using System.Collections.Generic;
using System.Linq;
using System.Reflection;
using Gallop;
using Newtonsoft.Json.Linq;

namespace UmamusumeResponseAnalyzer;

public static class Extensions
{
	public static byte[] Replace(this byte[] input, byte[] pattern, byte[] replacement)
	{
		if (pattern.Length == 0)
		{
			return input;
		}
		List<byte> list = new List<byte>();
		int i;
		for (i = 0; i <= input.Length - pattern.Length; i++)
		{
			bool flag = true;
			for (int j = 0; j < pattern.Length; j++)
			{
				if (input[i + j] != pattern[j])
				{
					flag = false;
					break;
				}
			}
			if (flag)
			{
				list.AddRange(replacement);
				i += pattern.Length - 1;
			}
			else
			{
				list.Add(input[i]);
			}
		}
		for (; i < input.Length; i++)
		{
			list.Add(input[i]);
		}
		return list.ToArray();
	}

	public static bool Contains<T>(this IEnumerable<T> list, Predicate<T> predicate)
	{
		if (list == null || !list.Any())
		{
			return false;
		}
		foreach (T item in list)
		{
			if (!EqualityComparer<T>.Default.Equals(item, default) && predicate(item))
			{
				return true;
			}
		}
		return false;
	}

	public static bool IsScenario(this SingleModeCheckEventResponse @event, ScenarioType type)
	{
		SingleModeCheckEventResponse.CommonResponse data = @event.data;
		return type switch
		{
			ScenarioType.Ura => data.chara_info.scenario_id == 1, 
			ScenarioType.Aoharu => data.chara_info.scenario_id == 2, 
			ScenarioType.GrandLive => data.chara_info.scenario_id == 3, 
			ScenarioType.MakeANewTrack => data.chara_info.scenario_id == 4 && data.free_data_set.pick_up_item_info_array != null, 
			ScenarioType.GrandMasters => data.chara_info.scenario_id == 5 && data.venus_data_set != null, 
			ScenarioType.LArc => data.chara_info.scenario_id == 6 && data.arc_data_set != null, 
			ScenarioType.UAF => data.chara_info.scenario_id == 7 && data.sport_data_set != null, 
			ScenarioType.Cook => data.chara_info.scenario_id == 8 && data.cook_data_set != null, 
			ScenarioType.Mecha => data.chara_info.scenario_id == 9 && data.mecha_data_set != null, 
			ScenarioType.Legend => data.chara_info.scenario_id == 10 && data.legend_data_set != null, 
			ScenarioType.Pioneer => data.chara_info.scenario_id == 11 && data.pioneer_data_set != null, 
			ScenarioType.Onsen => data.chara_info.scenario_id == 12 && data.onsen_data_set != null, 
			ScenarioType.Unknown => true, 
			_ => false, 
		};
	}

	public static string AllowMirror(this string? url)
	{
		if (url == null)
		{
			return string.Empty;
		}
		if (Config.Updater.IsGithubBlocked && !Config.Updater.ForceUseGithubToUpdate)
		{
			url = url.Replace("https://", "https://gh.shuise.dev/");
		}
		return url;
	}

	public static string AppendValue(this PropertyInfo property, object? obj, Dictionary<string, string> translatedDic = null)
	{
		object value = property.GetValue(obj);
		string empty = string.Empty;
		if (value is IEnumerable<string> source)
		{
			empty = string.Join(",", source.Select((string x) => x.Replace("[", "[[").Replace("]", "]]")));
		}
		else
		{
			empty = ((!(value is IDictionary<string, string> dictionary)) ? (value?.ToString()?.Replace("[", "[[").Replace("]", "]]") ?? string.Empty) : string.Join(',', dictionary.Keys));
		}
		if (translatedDic == null)
		{
			return property.Name + ": " + empty;
		}
		translatedDic.TryGetValue(property.Name, out string value2);
		return (value2 ?? property.Name) + ": " + empty;
	}

	public static bool HasCharaInfo(this JObject? jo)
	{
		if (jo != null && jo.ContainsKey("data"))
		{
			return jo["data"].ContainsKey("chara_info");
		}
		return false;
	}

	public static bool ContainsKey(this JToken? jt, string key)
	{
		if (jt != null && jt is JObject jObject)
		{
			return jObject.ContainsKey(key);
		}
		return false;
	}

	public static int ToInt(this JToken? jt)
	{
		return jt?.ToObject<int>() ?? 0;
	}

	public static bool IsNull(this JToken? jt)
	{
		if (jt != null)
		{
			return jt.Type == JTokenType.Null;
		}
		return true;
	}
}
