using MessagePack;

namespace Gallop;

[MessagePackObject(false)]
public class SingleModeArcSelectionInfo
{
	[Key("all_win_approval_point")]
	public int all_win_approval_point;

	[Key("params_inc_dec_info_array")]
	public SingleModeParamsIncDecInfo[] params_inc_dec_info_array;

	[Key("selection_rival_info_array")]
	public SingleModeArcSelectionRivalInfo[] selection_rival_info_array;

	[Key("is_special_match")]
	public int is_special_match;

	[Key("bonus_params_inc_dec_info_array")]
	public SingleModeParamsIncDecInfo[] bonus_params_inc_dec_info_array;
}
