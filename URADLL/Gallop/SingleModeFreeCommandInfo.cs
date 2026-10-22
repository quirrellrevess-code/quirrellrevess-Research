using MessagePack;

namespace Gallop;

[MessagePackObject(false)]
public class SingleModeFreeCommandInfo
{
	[Key("command_type")]
	public int command_type;

	[Key("command_id")]
	public int command_id;

	[Key("params_inc_dec_info_array")]
	public SingleModeParamsIncDecInfo[] params_inc_dec_info_array;
}
