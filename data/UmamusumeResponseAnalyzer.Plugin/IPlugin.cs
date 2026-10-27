using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Reflection;
using System.Threading.Tasks;
using Spectre.Console;
using UmamusumeResponseAnalyzer.Localization;

namespace UmamusumeResponseAnalyzer.Plugin;

public interface IPlugin
{
	string Name { get; }

	string Author { get; }

	Version Version => GetType().Assembly.GetName().Version ?? new Version(0, 0, 0);

	string[] Targets { get; }

	void Initialize()
	{
		Directory.CreateDirectory(Path.Combine("PluginData", Name));
	}

	void Dispose()
	{
	}

	void ConfigPrompt()
	{
		IEnumerable<PropertyInfo> enumerable = from x in GetType().GetProperties()
			where x.GetCustomAttribute<PluginSettingAttribute>() != null
			select x;
		Dictionary<string, PropertyInfo> dictionary = new Dictionary<string, PropertyInfo>();
		string empty = string.Empty;
		do
		{
			List<string> list = new List<string>
			{
				"插件: " + Name,
				$"版本: {Version}",
				"作者: " + Author
			};
			foreach (PropertyInfo item in enumerable)
			{
				string text = item.GetCustomAttribute<PluginDescriptionAttribute>()?.Description ?? item.Name;
				dictionary.TryAdd(text, item);
				list.Add($"{text}: {item.GetValue(this)}");
			}
			list.Add("Reload");
			list.Add(LaunchMenu.I18N_UpdateProgram);
			list.Add(global::UmamusumeResponseAnalyzer.Localization.Config.Return);
			empty = AnsiConsole.Prompt(new SelectionPrompt<string>().Title(GetType().GetProperty("Name")?.GetCustomAttribute<PluginDescriptionAttribute>()?.Description ?? Name).WrapAround().AddChoices(list)).Split(':')[0];
			if (empty == "Reload")
			{
				Initialize();
			}
			else if (empty == LaunchMenu.I18N_UpdateProgram)
			{
				AnsiConsole.Progress().Start((Func<ProgressContext, Task>)UpdatePlugin);
			}
			else if (empty != global::UmamusumeResponseAnalyzer.Localization.Config.Return)
			{
				PropertyInfo propertyInfo = dictionary[empty];
				if (propertyInfo != null)
				{
					string text2 = propertyInfo.GetCustomAttribute<PluginDescriptionAttribute>()?.Description;
					Type propertyType = propertyInfo.PropertyType;
					if (propertyType == typeof(bool))
					{
						bool flag = (bool)(propertyInfo.GetValue(this) ?? ((object)false));
						propertyInfo.SetValue(this, !flag);
					}
					else if (propertyType.IsPrimitive || propertyType == typeof(decimal))
					{
						object obj = Activator.CreateInstance(typeof(TextPrompt<>).MakeGenericType(propertyType), propertyInfo.Name + ": " + text2, null);
						object value = typeof(AnsiConsole).GetMethod("Prompt").MakeGenericMethod(propertyType).Invoke(null, new object[1] { obj });
						propertyInfo.SetValue(this, value);
					}
					else if (propertyType == typeof(string))
					{
						string value2 = AnsiConsole.Prompt(new TextPrompt<string>(propertyInfo.Name + ": " + text2).AllowEmpty());
						propertyInfo.SetValue(this, value2);
					}
					Config.Plugin.PluginSettings[Name][propertyInfo.Name] = propertyInfo.GetValue(this);
				}
			}
			AnsiConsole.Clear();
		}
		while (empty != global::UmamusumeResponseAnalyzer.Localization.Config.Return);
	}

	Task UpdatePlugin(ProgressContext ctx);
}
