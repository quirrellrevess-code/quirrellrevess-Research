using MessagePack;

namespace Gallop;

[MessagePackObject(false)]
public class NotUpArcParameterInfo
{
	[Key("rival_boost_chara_id_array")]
	public int[] rival_boost_chara_id_array;

	[Key("all_rival_boost_flag")]
	public bool all_rival_boost_flag;
}
