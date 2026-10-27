using MessagePack;

namespace Gallop;

[MessagePackObject(false)]
public class CircleUser
{
	[Key("viewer_id")]
	public long viewer_id;

	[Key("circle_id")]
	public int circle_id;

	[Key("membership")]
	public int membership;

	[Key("join_time")]
	public string join_time;

	[Key("penalty_end_time")]
	public string penalty_end_time;

	[Key("item_request_end_time")]
	public string item_request_end_time;
}
