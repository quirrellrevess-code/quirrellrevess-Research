using MessagePack;

namespace Gallop;

[MessagePackObject(false)]
public class ArcSelectionPeff
{
	[Key("effect_num")]
	public int effect_num;

	[Key("effect_group_id")]
	public int effect_group_id;

	[Key("effect_value")]
	public int effect_value;
}
