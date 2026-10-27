using MessagePack;

namespace Gallop;

[MessagePackObject(false)]
public class SingleModeVenusCharaInfo
{
	[Key("chara_id")]
	public int chara_id;

	[Key("venus_level")]
	public int venus_level;
}
