using System;
using System.Collections.Frozen;
using System.Linq;
using Gallop;
using UmamusumeResponseAnalyzer.Entities;

namespace UmamusumeResponseAnalyzer.Game.TurnInfo;

public class TurnInfo(SingleModeCheckEventResponse.CommonResponse resp)
{
	public int TotalTurns = 78;

	private SingleModeChara CharaInfo => resp.chara_info;

	public int CharacterId => int.Parse(CharaInfo.card_id.ToString().Substring(0, 4));

	public int SpeedRevised => ReviseOver1200(CharaInfo.speed);

	public int StaminaRevised => ReviseOver1200(CharaInfo.stamina);

	public int PowerRevised => ReviseOver1200(CharaInfo.power);

	public int GutsRevised => ReviseOver1200(CharaInfo.guts);

	public int WizRevised => ReviseOver1200(CharaInfo.wiz);

	public int[] Stats => new int[5] { CharaInfo.speed, CharaInfo.stamina, CharaInfo.power, CharaInfo.guts, CharaInfo.wiz };

	public int[] StatsRevised => new int[5] { SpeedRevised, StaminaRevised, PowerRevised, GutsRevised, WizRevised };

	public int[] MaxStatsRevised => new int[5]
	{
		ReviseOver1200(CharaInfo.max_speed),
		ReviseOver1200(CharaInfo.max_stamina),
		ReviseOver1200(CharaInfo.max_power),
		ReviseOver1200(CharaInfo.max_guts),
		ReviseOver1200(CharaInfo.max_wiz)
	};

	public ScenarioType Scenario => (ScenarioType)CharaInfo.scenario_id;

	public int Turn => CharaInfo.turn;

	public int TotalStats => StatsRevised.Sum();

	public int Year => (Turn - 1) / 24 + 1;

	public Motivation Motivation => new Motivation(CharaInfo.motivation);

	public int Vital => CharaInfo.vital;

	public int MaxVital => CharaInfo.max_vital;

	public FrozenDictionary<int, int> SupportCards => CharaInfo.support_card_array.ToDictionary((SingleModeSupportCard x) => x.position, (SingleModeSupportCard x) => x.support_card_id).ToFrozenDictionary();

	public FrozenDictionary<int, EvaluationInfo> Evaluations => CharaInfo.evaluation_info_array.ToDictionary((EvaluationInfo x) => x.target_id, (EvaluationInfo x) => x).ToFrozenDictionary();

	public int Month => (Turn - 1) % 24 / 2 + 1;

	public string HalfMonth
	{
		get
		{
			if (Turn % 2 != 0)
			{
				return "前半";
			}
			return "后半";
		}
	}

	public bool IsFreeContinueAvailable => resp.home_info.free_continue_time < DateTimeOffset.Now.ToUnixTimeSeconds();

	public bool IsGoldenSuccession => resp.unchecked_event_array.Any((SingleModeEventInfo x) => x.succession_event_info.effect_type == 2);

	public bool IsScenario<T>(ScenarioType type, out T? turnInfo) where T : TurnInfo
	{
		bool flag = type == Scenario;
		turnInfo = null;
		if (flag)
		{
			turnInfo = (T)(typeof(T).GetConstructor(new Type[1] { resp.GetType() })?.Invoke(new object[1] { resp }));
		}
		return flag;
	}

	public bool IsScenario(ScenarioType type)
	{
		TurnInfo turnInfo;
		return IsScenario<TurnInfo>(type, out turnInfo);
	}

	public SingleModeCheckEventResponse.CommonResponse GetCommonResponse()
	{
		return resp;
	}

	private static int ReviseOver1200(int x)
	{
		if (x <= 1200)
		{
			return x;
		}
		return x * 2 - 1200;
	}
}
