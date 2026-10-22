using System;
using System.Collections.Generic;
using System.Linq;
using System.Reflection;
using Spectre.Console;
using UmamusumeResponseAnalyzer.Localization;

namespace UmamusumeResponseAnalyzer;

public class RepositoryConfig
{
	public List<string> Targets { get; set; } = new List<string>();

	public Dictionary<string, string> AdditionalPluginRepositories { get; set; } = new Dictionary<string, string>();

	public void Prompt()
	{
		IEnumerable<PropertyInfo> source = from x in GetType().GetProperties(BindingFlags.Instance | BindingFlags.Public)
			where x.Name != "AdditionalPluginRepositories"
			select x;
		Dictionary<string, string> translated = source.Select((PropertyInfo x) => x.Name).ToDictionary((string x) => x, (string x) => global::UmamusumeResponseAnalyzer.Localization.Config.ResourceManager.GetString("Tabs_Repository_" + x, global::UmamusumeResponseAnalyzer.Localization.Config.Culture));
		string empty = string.Empty;
		do
		{
			empty = AnsiConsole.Prompt(new SelectionPrompt<string>().Title(global::UmamusumeResponseAnalyzer.Localization.Config.Tabs_Repository_Title).WrapAround().AddChoices(source.Select((PropertyInfo x) => x.AppendValue(this, translated)))
				.AddChoices(AdditionalPluginRepositories.Select((KeyValuePair<string, string> x) => x.Key + ": " + x.Value))
				.AddChoices(global::UmamusumeResponseAnalyzer.Localization.Config.Add, global::UmamusumeResponseAnalyzer.Localization.Config.Return)).Split(':')[0];
			if (empty == global::UmamusumeResponseAnalyzer.Localization.Config.Tabs_Repository_Targets)
			{
				string text = AnsiConsole.Prompt(new TextPrompt<string>(global::UmamusumeResponseAnalyzer.Localization.Config.Tabs_Repository_TargetsPrompt).AllowEmpty());
				Targets = (string.IsNullOrEmpty(text) ? new List<string>() : text.Replace('，', ',').Split(',').ToList());
				AnsiConsole.Clear();
			}
			else if (empty == global::UmamusumeResponseAnalyzer.Localization.Config.Add)
			{
				TextPrompt<string> prompt = new TextPrompt<string>(global::UmamusumeResponseAnalyzer.Localization.Config.Tabs_Repository_AdditionalPluginRepositoriesPrompt).AllowEmpty();
				while (true)
				{
					string text2 = AnsiConsole.Prompt(prompt);
					if (string.IsNullOrEmpty(text2))
					{
						break;
					}
					if (Uri.TryCreate(text2, UriKind.Absolute, out Uri _))
					{
						string text3 = AnsiConsole.Prompt(new TextPrompt<string>(global::UmamusumeResponseAnalyzer.Localization.Config.Tabs_Repository_AdditionalPluginRepositoriesNamePrompt).AllowEmpty());
						if (string.IsNullOrEmpty(text3))
						{
							text3 = text2.GetHashCode().ToString();
						}
						AdditionalPluginRepositories.Add(text3, text2);
						break;
					}
				}
				AnsiConsole.Clear();
			}
			else
			{
				AdditionalPluginRepositories.Remove(empty);
			}
			Config.Save();
		}
		while (empty != global::UmamusumeResponseAnalyzer.Localization.Config.Return);
	}
}
