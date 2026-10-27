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
internal class UAF
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
				resourceMan = new ResourceManager("UmamusumeResponseAnalyzer.Localization.CommandInfo.UAF", typeof(UAF).Assembly);
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

	internal static string I18N_ActualBestEffectiveTalk => ResourceManager.GetString("I18N_ActualBestEffectiveTalk", resourceCulture);

	internal static string I18N_AllRankOK => ResourceManager.GetString("I18N_AllRankOK", resourceCulture);

	internal static string I18N_BestEffectiveTalk => ResourceManager.GetString("I18N_BestEffectiveTalk", resourceCulture);

	internal static string I18N_BestEffectiveWithoutTalk => ResourceManager.GetString("I18N_BestEffectiveWithoutTalk", resourceCulture);

	internal static string I18N_CurrentRemainStat => ResourceManager.GetString("I18N_CurrentRemainStat", resourceCulture);

	internal static string I18N_LowestSportRank => ResourceManager.GetString("I18N_LowestSportRank", resourceCulture);

	internal static string I18N_LowSportRank => ResourceManager.GetString("I18N_LowSportRank", resourceCulture);

	internal static string I18N_MinimumSportRank => ResourceManager.GetString("I18N_MinimumSportRank", resourceCulture);

	internal static string I18N_MoritaRanking => ResourceManager.GetString("I18N_MoritaRanking", resourceCulture);

	internal static string I18N_MoritaTrained => ResourceManager.GetString("I18N_MoritaTrained", resourceCulture);

	internal static string I18N_MoritaVitalGainTimes => ResourceManager.GetString("I18N_MoritaVitalGainTimes", resourceCulture);

	internal static string I18N_RankGain => ResourceManager.GetString("I18N_RankGain", resourceCulture);

	internal static string I18N_RankGainIncreased => ResourceManager.GetString("I18N_RankGainIncreased", resourceCulture);

	internal static string I18N_RememberUseTalk => ResourceManager.GetString("I18N_RememberUseTalk", resourceCulture);

	internal static string I18N_RepeatTurn => ResourceManager.GetString("I18N_RepeatTurn", resourceCulture);

	internal static string I18N_TalkToGetBlueBuff => ResourceManager.GetString("I18N_TalkToGetBlueBuff", resourceCulture);

	internal static string I18N_TalkToGetRedBuff => ResourceManager.GetString("I18N_TalkToGetRedBuff", resourceCulture);

	internal static string I18N_TalkToGetYellowBuff => ResourceManager.GetString("I18N_TalkToGetYellowBuff", resourceCulture);

	internal static string I18N_WrongTurnAlert => ResourceManager.GetString("I18N_WrongTurnAlert", resourceCulture);

	internal UAF()
	{
	}
}
