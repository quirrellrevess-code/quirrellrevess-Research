using MessagePack;

namespace Gallop;

[MessagePackObject(false)]
public class RaceRewardData
{
	[Key("item_type")]
	public int item_type;

	[Key("item_id")]
	public int item_id;

	[Key("item_num")]
	public int item_num;
}
