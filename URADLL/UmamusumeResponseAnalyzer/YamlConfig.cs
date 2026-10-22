namespace UmamusumeResponseAnalyzer;

public class YamlConfig
{
	public CoreConfig Core { get; set; }

	public RepositoryConfig Repository { get; set; }

	public PluginConfig Plugin { get; set; }

	public UpdaterConfig Updater { get; set; }

	public LanguageConfig Language { get; set; }

	public MiscConfig Misc { get; set; }
}
