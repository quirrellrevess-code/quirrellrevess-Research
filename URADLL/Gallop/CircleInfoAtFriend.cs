using MessagePack;

namespace Gallop;

[MessagePackObject(false)]
public class CircleInfoAtFriend
{
	[Key("circle_id")]
	public int circle_id;

	[Key("name")]
	public string name;

	[Key("monthly_rank")]
	public int monthly_rank;
}
