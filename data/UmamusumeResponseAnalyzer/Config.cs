using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Reflection;
using Spectre.Console;
using UmamusumeResponseAnalyzer.Localization;
using YamlDotNet.Serialization;
using YamlDotNet.Serialization.NamingConventions;

namespace UmamusumeResponseAnalyzer;

public static class Config
{
	internal static string CONFIG_FILEPATH = "config.yaml";

	private static readonly ISerializer _serializer = new SerializerBuilder().WithQuotingNecessaryStrings().WithNamingConvention(HyphenatedNamingConvention.Instance).Build();

	private static readonly IDeserializer _deserializer = new DeserializerBuilder().IgnoreUnmatchedProperties().WithNamingConvention(HyphenatedNamingConvention.Instance).Build();

	private static YamlConfig Current { get; set; }

	public static CoreConfig Core => Current.Core;

	public static RepositoryConfig Repository => Current.Repository;

	public static PluginConfig Plugin => Current.Plugin;

	public static UpdaterConfig Updater => Current.Updater;

	public static LanguageConfig Language => Current.Language;

	public static MiscConfig Misc => Current.Misc;

	internal static void Initialize()
	{
		if (File.Exists(CONFIG_FILEPATH))
		{
			Current = _deserializer.Deserialize<YamlConfig>(File.ReadAllText(CONFIG_FILEPATH));
			PropertyInfo[] properties = Current.GetType().GetProperties();
			foreach (PropertyInfo propertyInfo in properties)
			{
				if (propertyInfo.GetValue(Current) == null)
				{
					propertyInfo.SetValue(Current, propertyInfo.PropertyType.GetConstructor(Type.EmptyTypes).Invoke(Array.Empty<object>()));
				}
			}
			UmamusumeResponseAnalyzer.ApplyCultureInfo(Language.Selected);
		}
		else
		{
			Current = new YamlConfig
			{
				Core = new CoreConfig(),
				Repository = new RepositoryConfig(),
				Plugin = new PluginConfig(),
				Updater = new UpdaterConfig(),
				Language = new LanguageConfig(),
				Misc = new MiscConfig()
			};
			Save();
		}
	}

	public static void Save()
	{
		File.WriteAllText(CONFIG_FILEPATH, _serializer.Serialize(Current));
	}

	public static void Prompt()
	{
		while (true)
		{
			string empty = string.Empty;
			Dictionary<string, string> dictionary = (from x in typeof(YamlConfig).GetProperties(BindingFlags.Instance | BindingFlags.Public)
				select x.Name).ToDictionary((string x) => global::UmamusumeResponseAnalyzer.Localization.Config.ResourceManager.GetString("Tabs_" + x + "_Title", global::UmamusumeResponseAnalyzer.Localization.Config.Culture), (string x) => x);
			empty = AnsiConsole.Prompt(new SelectionPrompt<string>().Title(global::UmamusumeResponseAnalyzer.Localization.Config.Settings_Title).WrapAround().AddChoices(dictionary.Keys)
				.AddChoices(global::UmamusumeResponseAnalyzer.Localization.Config.Return)
				.PageSize(30));
			if (!(empty == global::UmamusumeResponseAnalyzer.Localization.Config.Return))
			{
				object obj = typeof(Config).GetProperty(dictionary[empty])?.GetValue(null);
				obj?.GetType()?.GetMethod("Prompt")?.Invoke(obj, null);
				continue;
			}
			break;
		}
	}
}
