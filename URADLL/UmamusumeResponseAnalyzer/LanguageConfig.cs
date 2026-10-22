using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading;
using Spectre.Console;
using UmamusumeResponseAnalyzer.Localization;

namespace UmamusumeResponseAnalyzer;

public class LanguageConfig
{
	public enum Language
	{
		AutoDetect,
		SimplifiedChinese,
		Japanese,
		English
	}

	public Language Selected { get; private set; }

	public void Prompt()
	{
		Dictionary<string, string> dictionary = Enum.GetNames(typeof(Language)).ToDictionary((string x) => global::UmamusumeResponseAnalyzer.Localization.Config.ResourceManager.GetString("Tabs_Language_" + x, global::UmamusumeResponseAnalyzer.Localization.Config.Culture), (string x) => x);
		string key = AnsiConsole.Prompt(new SelectionPrompt<string>().Title(global::UmamusumeResponseAnalyzer.Localization.Config.Tabs_Language_Title).AddChoices(dictionary.Keys));
		if (dictionary.TryGetValue(key, out var value) && Enum.TryParse<Language>(value, out var result))
		{
			Selected = result;
		}
		Config.Save();
		UmamusumeResponseAnalyzer.Restart();
	}

	public static string GetCulture()
	{
		return Config.Language.Selected switch
		{
			Language.SimplifiedChinese => "zh-CN", 
			Language.Japanese => "ja-JP", 
			Language.English => "en-US", 
			_ => Thread.CurrentThread.CurrentCulture.Name, 
		};
	}
}
