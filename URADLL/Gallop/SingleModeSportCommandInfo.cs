using MessagePack;

namespace Gallop;

[MessagePackObject(false)]
public class SingleModeSportCommandInfo
{
	[MessagePackObject(false)]
	public class SingleModeSportGainRank
	{
		[Key("command_id")]
		public int command_id;

		[Key("gain_rank")]
		public int gain_rank;
	}

	[Key("command_type")]
	public int command_type;

	[Key("command_id")]
	public int command_id;

	[Key("params_inc_dec_info_array")]
	public SingleModeParamsIncDecInfo[] params_inc_dec_info_array;

	[Key("gain_sport_rank_array")]
	public SingleModeSportGainRank[] gain_sport_rank_array;
}
