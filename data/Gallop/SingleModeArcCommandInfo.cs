using MessagePack;

namespace Gallop;

[MessagePackObject(false)]
public class SingleModeArcCommandInfo
{
	[Key("command_type")]
	public int command_type;

	[Key("command_id")]
	public int command_id;

	[Key("params_inc_dec_info_array")]
	public SingleModeParamsIncDecInfo[] params_inc_dec_info_array;

	[Key("add_global_exp")]
	public int add_global_exp;
}
