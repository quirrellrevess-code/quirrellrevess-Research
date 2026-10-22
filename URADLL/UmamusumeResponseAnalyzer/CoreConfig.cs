using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Reflection;
using Spectre.Console;
using UmamusumeResponseAnalyzer.Localization;

namespace UmamusumeResponseAnalyzer;

public class CoreConfig
{
	public string ListenAddress { get; set; } = "127.0.0.1";

	public int ListenPort { get; set; } = 4693;

	public bool RequestAdditionalHeader { get; set; }

	public bool ShowFirstRunPrompt { get; set; } = true;

	public void Prompt()
	{
		PropertyInfo[] properties = GetType().GetProperties(BindingFlags.Instance | BindingFlags.Public);
		Dictionary<string, string> translated = properties.Select((PropertyInfo x) => x.Name).ToDictionary((string x) => x, (string x) => global::UmamusumeResponseAnalyzer.Localization.Config.ResourceManager.GetString("Tabs_Core_" + x, global::UmamusumeResponseAnalyzer.Localization.Config.Culture));
		string empty = string.Empty;
		do
		{
			empty = AnsiConsole.Prompt(new SelectionPrompt<string>().Title(global::UmamusumeResponseAnalyzer.Localization.Config.Tabs_Core_Title).WrapAround().AddChoices(properties.Select((PropertyInfo x) => x.AppendValue(this, translated)))
				.AddChoices(global::UmamusumeResponseAnalyzer.Localization.Config.Return)).Split(':')[0];
			if (empty == global::UmamusumeResponseAnalyzer.Localization.Config.Tabs_Core_ListenAddress)
			{
				string empty2 = string.Empty;
				IPAddress address;
				do
				{
					empty2 = AnsiConsole.Prompt(new TextPrompt<string>(global::UmamusumeResponseAnalyzer.Localization.Config.Tabs_Core_ListenAddressPrompt));
				}
				while (!IPAddress.TryParse(empty2, out address));
				ListenAddress = empty2;
				AnsiConsole.Clear();
				Config.Save();
			}
			else if (empty == global::UmamusumeResponseAnalyzer.Localization.Config.Tabs_Core_ListenPort)
			{
				_ = string.Empty;
				int result;
				while (!int.TryParse(AnsiConsole.Prompt(new TextPrompt<string>(global::UmamusumeResponseAnalyzer.Localization.Config.Tabs_Core_ListenPortPrompt)), out result))
				{
				}
				ListenPort = result;
				AnsiConsole.Clear();
				Config.Save();
			}
			else if (empty == global::UmamusumeResponseAnalyzer.Localization.Config.Tabs_Core_RequestAdditionalHeader)
			{
				RequestAdditionalHeader = !RequestAdditionalHeader;
			}
			else if (empty == "ShowFirstRunPrompt")
			{
				ShowFirstRunPrompt = !ShowFirstRunPrompt;
			}
			Config.Save();
		}
		while (empty != global::UmamusumeResponseAnalyzer.Localization.Config.Return);
	}
}
