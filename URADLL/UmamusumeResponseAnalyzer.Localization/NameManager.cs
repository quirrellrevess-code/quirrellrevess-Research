using System.CodeDom.Compiler;
using System.ComponentModel;
using System.Diagnostics;
using System.Globalization;
using System.Resources;
using System.Runtime.CompilerServices;

namespace UmamusumeResponseAnalyzer.Localization;

[GeneratedCode("System.Resources.Tools.StronglyTypedResourceBuilder", "17.0.0.0")]
[DebuggerNonUserCode]
[CompilerGenerated]
internal class NameManager
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
				resourceMan = new ResourceManager("UmamusumeResponseAnalyzer.Localization.NameManager", typeof(NameManager).Assembly);
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

	internal static string I18N_CastToSupportCardNameFail => ResourceManager.GetString("I18N_CastToSupportCardNameFail", resourceCulture);

	internal static string I18N_CastToUmaNameFail => ResourceManager.GetString("I18N_CastToUmaNameFail", resourceCulture);

	internal static string I18N_Unknown => ResourceManager.GetString("I18N_Unknown", resourceCulture);

	internal NameManager()
	{
	}
}
