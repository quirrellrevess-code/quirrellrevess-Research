using System;
using System.Collections.Generic;
using System.Globalization;
using System.Linq;
using System.Reflection;
using Spectre.Console;
using UmamusumeResponseAnalyzer.Localization;

namespace UmamusumeResponseAnalyzer;

public class UpdaterConfig
{
	public bool IsGithubBlocked { get; set; } = RegionInfo.CurrentRegion.Name == "CN" || CultureInfo.CurrentUICulture.Name == "zh-CN";

	public bool TrainerIsMale { get; set; } = true;

	public string DatabaseLanguage { get; set; } = "ja-JP";

	public string CustomDatabaseRepository { get; set; }

	public bool ForceUseGithubToUpdate { get; set; }

	public void Prompt()
	{
		IEnumerable<PropertyInfo> source = from x in GetType().GetProperties(BindingFlags.Instance | BindingFlags.Public)
			where x.Name != "IsGithubBlocked"
			select x;
		Dictionary<string, string> translated = source.Select((PropertyInfo x) => x.Name).ToDictionary((string x) => x, (string x) => global::UmamusumeResponseAnalyzer.Localization.Config.ResourceManager.GetString("Tabs_Updater_" + x, global::UmamusumeResponseAnalyzer.Localization.Config.Culture));
		string empty = string.Empty;
		do
		{
			empty = AnsiConsole.Prompt(new SelectionPrompt<string>().Title(global::UmamusumeResponseAnalyzer.Localization.Config.Tabs_Updater_Title).WrapAround().AddChoices(source.Select((PropertyInfo x) => x.AppendValue(this, translated)))
				.AddChoices(global::UmamusumeResponseAnalyzer.Localization.Config.Return)).Split(':')[0];
			switch (empty)
			{
			case "TrainerIsMale":
				TrainerIsMale = !TrainerIsMale;
				break;
			case "DatabaseLanguage":
			{
				string databaseLanguage = AnsiConsole.Prompt(new SelectionPrompt<string>().Title("DatabaseLanguage").WrapAround().AddChoices("ja-JP", "zh-TW", "zh-CN"));
				DatabaseLanguage = databaseLanguage;
				AnsiConsole.Clear();
				break;
			}
			case "CustomDatabaseRepository":
			{
				TextPrompt<string> prompt = new TextPrompt<string>(global::UmamusumeResponseAnalyzer.Localization.Config.Tabs_Repository_AdditionalPluginRepositoriesPrompt).AllowEmpty();
				while (true)
				{
					string text = AnsiConsole.Prompt(prompt);
					if (string.IsNullOrEmpty(text))
					{
						CustomDatabaseRepository = string.Empty;
						break;
					}
					if (Uri.TryCreate(text, UriKind.Absolute, out Uri _))
					{
						CustomDatabaseRepository = text;
						break;
					}
				}
				AnsiConsole.Clear();
				break;
			}
			default:
				if (empty == global::UmamusumeResponseAnalyzer.Localization.Config.Tabs_Updater_ForceUseGithubToUpdate)
				{
					ForceUseGithubToUpdate = !ForceUseGithubToUpdate;
				}
				break;
			}
		}
		while (empty != global::UmamusumeResponseAnalyzer.Localization.Config.Return);
		Config.Save();
	}
}
