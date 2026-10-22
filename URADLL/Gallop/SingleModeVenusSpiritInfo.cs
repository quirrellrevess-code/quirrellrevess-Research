using MessagePack;

namespace Gallop;

[MessagePackObject(false)]
public class SingleModeVenusSpiritInfo
{
	[Key("spirit_num")]
	public int spirit_num;

	[Key("spirit_id")]
	public int spirit_id;

	[Key("effect_group_id")]
	public int effect_group_id;
}
