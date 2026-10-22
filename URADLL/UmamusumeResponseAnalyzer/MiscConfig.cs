using System.Collections.Generic;
using System.Linq;
using System.Reflection;
using Spectre.Console;
using UmamusumeResponseAnalyzer.Localization;

namespace UmamusumeResponseAnalyzer;

public class MiscConfig
{
	public bool SaveResponseForDebug { get; set; }

	public void Prompt()
	{
		PropertyInfo[] properties = GetType().GetProperties(BindingFlags.Instance | BindingFlags.Public);
		Dictionary<string, string> dictionary = properties.Select((PropertyInfo x) => x.Name).ToDictionary((string x) => x, (string x) => global::UmamusumeResponseAnalyzer.Localization.Config.ResourceManager.GetString("Tabs_Debug_" + x, global::UmamusumeResponseAnalyzer.Localization.Config.Culture));
		MultiSelectionPrompt<string> multiSelectionPrompt = new MultiSelectionPrompt<string>().Title(global::UmamusumeResponseAnalyzer.Localization.Config.Tabs_Debug_Title).WrapAround().Required(required: false)
			.AddChoices(dictionary.Values);
		PropertyInfo[] array = properties;
		foreach (PropertyInfo propertyInfo in array)
		{
			if ((bool)propertyInfo.GetValue(this))
			{
				multiSelectionPrompt.Select(dictionary[propertyInfo.Name]);
			}
		}
		List<string> list = AnsiConsole.Prompt(multiSelectionPrompt);
		array = properties;
		foreach (PropertyInfo propertyInfo2 in array)
		{
			propertyInfo2.SetValue(this, list.Contains(dictionary[propertyInfo2.Name]));
		}
		Config.Save();
	}
}
