using MessagePack;

namespace Gallop;

[MessagePackObject(false)]
public class SingleModeCommandInfo
{
	[Key("command_type")]
	public int command_type;

	[Key("command_id")]
	public int command_id;

	[Key("is_enable")]
	public int is_enable;

	[Key("training_partner_array")]
	public int[] training_partner_array;

	[Key("tips_event_partner_array")]
	public int[] tips_event_partner_array;

	[Key("params_inc_dec_info_array")]
	public SingleModeParamsIncDecInfo[] params_inc_dec_info_array;

	[Key("failure_rate")]
	public int failure_rate;
}
