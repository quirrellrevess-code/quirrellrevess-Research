using MessagePack;

namespace Gallop;

[MessagePackObject(false)]
public class MinigameResultDetail
{
	[Key("get_id")]
	public int get_id;

	[Key("chara_id")]
	public int chara_id;

	[Key("dress_id")]
	public int dress_id;

	[Key("motion")]
	public string motion;

	[Key("face")]
	public string face;
}
