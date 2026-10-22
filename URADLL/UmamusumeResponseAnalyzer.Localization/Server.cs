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
internal class Server
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
				resourceMan = new ResourceManager("UmamusumeResponseAnalyzer.Localization.Server", typeof(Server).Assembly);
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

	internal static string I18N_AvailableEndpointTip => ResourceManager.GetString("I18N_AvailableEndpointTip", resourceCulture);

	internal static string I18N_LoginRequestDetected => ResourceManager.GetString("I18N_LoginRequestDetected", resourceCulture);

	internal static string I18N_NormalServerStarted => ResourceManager.GetString("I18N_NormalServerStarted", resourceCulture);

	internal static string I18N_PingReceived => ResourceManager.GetString("I18N_PingReceived", resourceCulture);

	internal static string I18N_ResponseAnalyzeFail => ResourceManager.GetString("I18N_ResponseAnalyzeFail", resourceCulture);

	internal static string I18N_ServerStartFail => ResourceManager.GetString("I18N_ServerStartFail", resourceCulture);

	internal static string I18N_TrainingFailed => ResourceManager.GetString("I18N_TrainingFailed", resourceCulture);

	internal static string I18N_WebSocket_CommandNotFound => ResourceManager.GetString("I18N_WebSocket_CommandNotFound", resourceCulture);

	internal static string I18N_WebSocket_CommandTypeNone => ResourceManager.GetString("I18N_WebSocket_CommandTypeNone", resourceCulture);

	internal static string I18N_WebSocket_ConstructorNotFound => ResourceManager.GetString("I18N_WebSocket_ConstructorNotFound", resourceCulture);

	internal static string I18N_WebSocket_DeserializeRequestFail => ResourceManager.GetString("I18N_WebSocket_DeserializeRequestFail", resourceCulture);

	internal static string I18N_WildcardServerStarted => ResourceManager.GetString("I18N_WildcardServerStarted", resourceCulture);

	internal Server()
	{
	}
}
