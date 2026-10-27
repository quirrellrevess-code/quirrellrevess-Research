using MessagePack;

namespace Gallop;

[MessagePackObject(false)]
public class SingleModeFreeItemEffect
{
	[Key("use_id")]
	public int use_id;

	[Key("item_id")]
	public int item_id;

	[Key("effect_type")]
	public int effect_type;

	[Key("effect_value_1")]
	public int effect_value_1;

	[Key("effect_value_2")]
	public int effect_value_2;

	[Key("effect_value_3")]
	public int effect_value_3;

	[Key("effect_value_4")]
	public int effect_value_4;

	[Key("begin_turn")]
	public int begin_turn;

	[Key("end_turn")]
	public int end_turn;
}
