using System.Collections.Generic;
using System.Linq;
using System.Reflection;
using Spectre.Console;
using UmamusumeResponseAnalyzer.Localization;
using UmamusumeResponseAnalyzer.Plugin;

namespace UmamusumeResponseAnalyzer;

public class PluginConfig
{
	public Dictionary<string, Dictionary<string, object>> PluginSettings { get; set; } = new Dictionary<string, Dictionary<string, object>>();

	public void Prompt()
	{
		UmamusumeResponseAnalyzer._plugin_initialize_task.Wait();
		string empty = string.Empty;
		Dictionary<string, IPlugin> dictionary = PluginManager.LoadedPlugins.ToDictionary((IPlugin x) => x.GetType().GetProperty("Name")?.GetCustomAttribute<PluginDescriptionAttribute>()?.Description ?? x.Name, (IPlugin x) => x);
		do
		{
			empty = AnsiConsole.Prompt(new SelectionPrompt<string>().Title(global::UmamusumeResponseAnalyzer.Localization.Config.Tabs_Plugin_Title).WrapAround().AddChoices(dictionary.Keys)
				.AddChoices(global::UmamusumeResponseAnalyzer.Localization.Config.Return)
				.PageSize(30));
			if (empty != global::UmamusumeResponseAnalyzer.Localization.Config.Return)
			{
				dictionary[empty].ConfigPrompt();
				Config.Save();
			}
		}
		while (empty != global::UmamusumeResponseAnalyzer.Localization.Config.Return);
	}
}
