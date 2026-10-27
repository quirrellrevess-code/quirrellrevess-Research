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
internal class LaunchMenu
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
				resourceMan = new ResourceManager("UmamusumeResponseAnalyzer.Localization.LaunchMenu", typeof(LaunchMenu).Assembly);
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

	internal static string I18N_ConsoleSizeSmall => ResourceManager.GetString("I18N_ConsoleSizeSmall", resourceCulture);

	internal static string I18N_InstallUraCore => ResourceManager.GetString("I18N_InstallUraCore", resourceCulture);

	internal static string I18N_Instruction => ResourceManager.GetString("I18N_Instruction", resourceCulture);

	internal static string I18N_LaunchFail => ResourceManager.GetString("I18N_LaunchFail", resourceCulture);

	internal static string I18N_LocalizationData_FileCorrupt => ResourceManager.GetString("I18N_LocalizationData_FileCorrupt", resourceCulture);

	internal static string I18N_LocalizationData_FormatRequirement => ResourceManager.GetString("I18N_LocalizationData_FormatRequirement", resourceCulture);

	internal static string I18N_LocalizationData_InputPathPrompt => ResourceManager.GetString("I18N_LocalizationData_InputPathPrompt", resourceCulture);

	internal static string I18N_ManageDMMService => ResourceManager.GetString("I18N_ManageDMMService", resourceCulture);

	internal static string I18N_Options => ResourceManager.GetString("I18N_Options", resourceCulture);

	internal static string I18N_Options_BackToMenuInstruction => ResourceManager.GetString("I18N_Options_BackToMenuInstruction", resourceCulture);

	internal static string I18N_Options_Instruction => ResourceManager.GetString("I18N_Options_Instruction", resourceCulture);

	internal static string I18N_Options_MultipleLanguagesSelected => ResourceManager.GetString("I18N_Options_MultipleLanguagesSelected", resourceCulture);

	internal static string I18N_SetLocalizedDataFilePath => ResourceManager.GetString("I18N_SetLocalizedDataFilePath", resourceCulture);

	internal static string I18N_Start => ResourceManager.GetString("I18N_Start", resourceCulture);

	internal static string I18N_Start_Started => ResourceManager.GetString("I18N_Start_Started", resourceCulture);

	internal static string I18N_UpdateAssets => ResourceManager.GetString("I18N_UpdateAssets", resourceCulture);

	internal static string I18N_UpdateProgram => ResourceManager.GetString("I18N_UpdateProgram", resourceCulture);

	internal static string I18N_UraCoreHelper_FoundAvailablePath => ResourceManager.GetString("I18N_UraCoreHelper_FoundAvailablePath", resourceCulture);

	internal static string I18N_UraCoreHelper_FoundPaths => ResourceManager.GetString("I18N_UraCoreHelper_FoundPaths", resourceCulture);

	internal static string I18N_UraCoreHelper_InstallPrompt => ResourceManager.GetString("I18N_UraCoreHelper_InstallPrompt", resourceCulture);

	internal static string I18N_UraCoreHelper_InstallSuccess => ResourceManager.GetString("I18N_UraCoreHelper_InstallSuccess", resourceCulture);

	internal static string I18N_UraCoreHelper_NoInstalledModuleFound => ResourceManager.GetString("I18N_UraCoreHelper_NoInstalledModuleFound", resourceCulture);

	internal LaunchMenu()
	{
	}
}
