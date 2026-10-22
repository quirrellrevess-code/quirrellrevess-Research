using MessagePack;

namespace Gallop;

[MessagePackObject(false)]
public class UserFriend
{
	[Key("friend_viewer_id")]
	public long friend_viewer_id;

	[Key("state")]
	public int state;

	[Key("follow_time")]
	public string follow_time;

	[Key("follower_time")]
	public string follower_time;
}
