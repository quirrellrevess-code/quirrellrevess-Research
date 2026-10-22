using Gallop;

namespace UmamusumeResponseAnalyzer.Game.TurnInfo;

public class TurnInfoArc : TurnInfo
{
	public new int TotalTurns = 67;

	public SingleModeArcInfo ArcInfo { get; }

	public SingleModeArcRival[] ArcRivalArray { get; }

	public SingleModeRivalRaceInfo[] RivalRaceInfoArray { get; }

	public SingleModeArcSelectionInfo SelectionInfo { get; }

	public SingleModeArcCommandInfo[] CommandInfoArray { get; }

	public SingleModeArcRaceHistory[] RaceHistoryArray { get; }

	public ArcEvaluationInfo[] EvaluationInfoArray { get; }

	public NotUpArcParameterInfo NotUpArcParameterInfo { get; }

	public int ApprovalRate => ArcInfo.approval_rate;

	public bool IsAbroad
	{
		get
		{
			if (Turn < 37 || Turn > 43)
			{
				if (Turn >= 61)
				{
					return Turn <= 67;
				}
				return false;
			}
			return true;
		}
	}

	public TurnInfoArc(SingleModeCheckEventResponse.CommonResponse resp)
		: base(resp)
	{
		SingleModeArcDataSet arc_data_set = resp.arc_data_set;
		ArcInfo = arc_data_set.arc_info;
		ArcRivalArray = arc_data_set.arc_rival_array;
		RivalRaceInfoArray = arc_data_set.rival_race_info_array;
		SelectionInfo = arc_data_set.selection_info;
		CommandInfoArray = arc_data_set.command_info_array;
		RaceHistoryArray = arc_data_set.race_history_array;
		EvaluationInfoArray = arc_data_set.evaluation_info_array;
	}
}
