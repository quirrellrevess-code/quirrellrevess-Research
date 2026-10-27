using MessagePack;

namespace Gallop;

[MessagePackObject(false)]
public class GroupOutingInfo
{
	[Key("chara_id")]
	public int chara_id;

	[Key("is_outing")]
	public int is_outing;

	[Key("story_step")]
	public int story_step;
}
