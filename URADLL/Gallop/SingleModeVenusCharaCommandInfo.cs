using MessagePack;

namespace Gallop;

[MessagePackObject(false)]
public class SingleModeVenusCharaCommandInfo
{
	[Key("command_type")]
	public int command_type;

	[Key("command_id")]
	public int command_id;

	[Key("spirit_id")]
	public int spirit_id;

	[Key("is_boost")]
	public int is_boost;
}
