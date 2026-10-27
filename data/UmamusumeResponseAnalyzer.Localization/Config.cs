using System.CodeDom.Compiler;
using System.ComponentModel;
using System.Diagnostics;
using System.Globalization;
using System.Resources;
using System.Runtime.CompilerServices;

namespace UmamusumeResponseAnalyzer.Localization;

[GeneratedCode("System.Resources.Tools.StronglyTypedResourceBuilder", "18.0.0.0")]
[DebuggerNonUserCode]
[CompilerGenerated]
internal class Config
{
	private static ResourceManager resourceMan;

	private static CultureInfo resourceCulture;

	[EditorBrowsable(EditorBrowsableState.Advanced)]
	internal static ResourceManager ResourceManager
	{
		get
		{
			if (resourceMan == null)
			{
				resourceMan = new ResourceManager("UmamusumeResponseAnalyzer.Localization.Config", typeof(Config).Assembly);
			}
			return resourceMan;
		}
	}

	[EditorBrowsable(EditorBrowsableState.Advanced)]
	internal static CultureInfo Culture
	{
		get
		{
			return resourceCulture;
		}
		set
		{
			resourceCulture = value;
		}
	}

	internal static string Add => ResourceManager.GetString("Add", resourceCulture);

	internal static string Return => ResourceManager.GetString("Return", resourceCulture);

	internal static string Settings_Title => ResourceManager.GetString("Settings_Title", resourceCulture);

	internal static string Tabs_Core_ListenAddress => ResourceManager.GetString("Tabs_Core_ListenAddress", resourceCulture);

	internal static string Tabs_Core_ListenAddressPrompt => ResourceManager.GetString("Tabs_Core_ListenAddressPrompt", resourceCulture);

	internal static string Tabs_Core_ListenPort => ResourceManager.GetString("Tabs_Core_ListenPort", resourceCulture);

	internal static string Tabs_Core_ListenPortPrompt => ResourceManager.GetString("Tabs_Core_ListenPortPrompt", resourceCulture);

	internal static string Tabs_Core_RequestAdditionalHeader => ResourceManager.GetString("Tabs_Core_RequestAdditionalHeader", resourceCulture);

	internal static string Tabs_Core_Title => ResourceManager.GetString("Tabs_Core_Title", resourceCulture);

	internal static string Tabs_Debug_SaveResponseForDebug => ResourceManager.GetString("Tabs_Debug_SaveResponseForDebug", resourceCulture);

	internal static string Tabs_Debug_Title => ResourceManager.GetString("Tabs_Debug_Title", resourceCulture);

	internal static string Tabs_Language_AutoDetect => ResourceManager.GetString("Tabs_Language_AutoDetect", resourceCulture);

	internal static string Tabs_Language_English => ResourceManager.GetString("Tabs_Language_English", resourceCulture);

	internal static string Tabs_Language_Japanese => ResourceManager.GetString("Tabs_Language_Japanese", resourceCulture);

	internal static string Tabs_Language_SimplifiedChinese => ResourceManager.GetString("Tabs_Language_SimplifiedChinese", resourceCulture);

	internal static string Tabs_Language_Title => ResourceManager.GetString("Tabs_Language_Title", resourceCulture);

	internal static string Tabs_Localization_InputPath => ResourceManager.GetString("Tabs_Localization_InputPath", resourceCulture);

	internal static string Tabs_Localization_Path => ResourceManager.GetString("Tabs_Localization_Path", resourceCulture);

	internal static string Tabs_Localization_Title => ResourceManager.GetString("Tabs_Localization_Title", resourceCulture);

	internal static string Tabs_Misc_Title => ResourceManager.GetString("Tabs_Misc_Title", resourceCulture);

	internal static string Tabs_Misc_WriteAIInfo => ResourceManager.GetString("Tabs_Misc_WriteAIInfo", resourceCulture);

	internal static string Tabs_Plugin_Title => ResourceManager.GetString("Tabs_Plugin_Title", resourceCulture);

	internal static string Tabs_Repository_AdditionalPluginRepositoriesNamePrompt => ResourceManager.GetString("Tabs_Repository_AdditionalPluginRepositoriesNamePrompt", resourceCulture);

	internal static string Tabs_Repository_AdditionalPluginRepositoriesPrompt => ResourceManager.GetString("Tabs_Repository_AdditionalPluginRepositoriesPrompt", resourceCulture);

	internal static string Tabs_Repository_Targets => ResourceManager.GetString("Tabs_Repository_Targets", resourceCulture);

	internal static string Tabs_Repository_TargetsPrompt => ResourceManager.GetString("Tabs_Repository_TargetsPrompt", resourceCulture);

	internal static string Tabs_Repository_Title => ResourceManager.GetString("Tabs_Repository_Title", resourceCulture);

	internal static string Tabs_Updater_ForceUseGithubToUpdate => ResourceManager.GetString("Tabs_Updater_ForceUseGithubToUpdate", resourceCulture);

	internal static string Tabs_Updater_Title => ResourceManager.GetString("Tabs_Updater_Title", resourceCulture);

	internal Config()
	{
	}
}
