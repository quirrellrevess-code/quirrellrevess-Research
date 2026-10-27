using MessagePack;

namespace Gallop;

[MessagePackObject(false)]
public class GuestOutingInfo
{
	[Key("support_card_id")]
	public int support_card_id;

	[Key("story_step")]
	public int story_step;

	[Key("group_outing_info_array")]
	public GroupOutingInfo[] group_outing_info_array;
}
