using MessagePack;

namespace Gallop;

[MessagePackObject(false)]
public class NotGainCharaEffect
{
	[Key("effected_chara_effect_id")]
	public int effected_chara_effect_id;

	[Key("not_gain_chara_effect_id")]
	public int not_gain_chara_effect_id;
}
