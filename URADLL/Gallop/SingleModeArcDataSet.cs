using MessagePack;

namespace Gallop;

[MessagePackObject(false)]
public class SingleModeArcDataSet
{
	[Key("arc_info")]
	public SingleModeArcInfo arc_info;

	[Key("arc_rival_array")]
	public SingleModeArcRival[] arc_rival_array;

	[Key("rival_race_info_array")]
	public SingleModeRivalRaceInfo[] rival_race_info_array;

	[Key("selection_info")]
	public SingleModeArcSelectionInfo selection_info;

	[Key("race_history_array")]
	public SingleModeArcRaceHistory[] race_history_array;

	[Key("command_info_array")]
	public SingleModeArcCommandInfo[] command_info_array;

	[Key("evaluation_info_array")]
	public ArcEvaluationInfo[] evaluation_info_array;

	[Key("not_up_arc_parameter_info")]
	public NotUpArcParameterInfo not_up_arc_parameter_info;
}
