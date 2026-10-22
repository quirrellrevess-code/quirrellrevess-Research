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
internal class ResourceUpdater
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
				resourceMan = new ResourceManager("UmamusumeResponseAnalyzer.Localization.ResourceUpdater", typeof(ResourceUpdater).Assembly);
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

	internal static string I18N_AccessGithubFail => ResourceManager.GetString("I18N_AccessGithubFail", resourceCulture);

	internal static string I18N_AccessMirrorFail => ResourceManager.GetString("I18N_AccessMirrorFail", resourceCulture);

	internal static string I18N_AlreadyLatestInstruction => ResourceManager.GetString("I18N_AlreadyLatestInstruction", resourceCulture);

	internal static string I18N_BeginUpdateProgramInstruction => ResourceManager.GetString("I18N_BeginUpdateProgramInstruction", resourceCulture);

	internal static string I18N_DecompressCmder => ResourceManager.GetString("I18N_DecompressCmder", resourceCulture);

	internal static string I18N_DownloadedInstruction => ResourceManager.GetString("I18N_DownloadedInstruction", resourceCulture);

	internal static string I18N_DownloadEventsInstruction => ResourceManager.GetString("I18N_DownloadEventsInstruction", resourceCulture);

	internal static string I18N_DownloadFactorIdsInstruction => ResourceManager.GetString("I18N_DownloadFactorIdsInstruction", resourceCulture);

	internal static string I18N_DownloadingCmder => ResourceManager.GetString("I18N_DownloadingCmder", resourceCulture);

	internal static string I18N_DownloadingUraCore => ResourceManager.GetString("I18N_DownloadingUraCore", resourceCulture);

	internal static string I18N_DownloadNamesInstruction => ResourceManager.GetString("I18N_DownloadNamesInstruction", resourceCulture);

	internal static string I18N_DownloadProgramInstruction => ResourceManager.GetString("I18N_DownloadProgramInstruction", resourceCulture);

	internal static string I18N_DownloadSkillDataInstruction => ResourceManager.GetString("I18N_DownloadSkillDataInstruction", resourceCulture);

	internal static string I18N_DownloadSkillUpgradeSpecialityInstruction => ResourceManager.GetString("I18N_DownloadSkillUpgradeSpecialityInstruction", resourceCulture);

	internal static string I18N_DownloadSuccessEventsInstruction => ResourceManager.GetString("I18N_DownloadSuccessEventsInstruction", resourceCulture);

	internal static string I18N_DownloadTalentSkillInstruction => ResourceManager.GetString("I18N_DownloadTalentSkillInstruction", resourceCulture);

	internal static string I18N_UpdatedFileCorrupted => ResourceManager.GetString("I18N_UpdatedFileCorrupted", resourceCulture);

	internal ResourceUpdater()
	{
	}
}
