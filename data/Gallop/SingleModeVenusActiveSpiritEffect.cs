using MessagePack;

namespace Gallop;

[MessagePackObject(false)]
public class SingleModeVenusActiveSpiritEffect
{
	[Key("chara_id")]
	public int chara_id;

	[Key("effect_group_id")]
	public int effect_group_id;

	[Key("begin_turn")]
	public int begin_turn;

	[Key("end_turn")]
	public int end_turn;
}
