using System.CodeDom.Compiler;
using System.ComponentModel;
using System.Diagnostics;
using System.Globalization;
using System.Resources;
using System.Runtime.CompilerServices;

namespace UmamusumeResponseAnalyzer.Localization.CommandInfo;

[GeneratedCode("System.Resources.Tools.StronglyTypedResourceBuilder", "17.0.0.0")]
[DebuggerNonUserCode]
[CompilerGenerated]
internal class Cook
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
				resourceMan = new ResourceManager("UmamusumeResponseAnalyzer.Localization.CommandInfo.Cook", typeof(Cook).Assembly);
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

	internal static string I18N_Berry => ResourceManager.GetString("I18N_Berry", resourceCulture);

	internal static string I18N_Carrot => ResourceManager.GetString("I18N_Carrot", resourceCulture);

	internal static string I18N_Chili => ResourceManager.GetString("I18N_Chili", resourceCulture);

	internal static string I18N_Garlic => ResourceManager.GetString("I18N_Garlic", resourceCulture);

	internal static string I18N_Harvest => ResourceManager.GetString("I18N_Harvest", resourceCulture);

	internal static string I18N_Potato => ResourceManager.GetString("I18N_Potato", resourceCulture);

	internal Cook()
	{
	}
}
