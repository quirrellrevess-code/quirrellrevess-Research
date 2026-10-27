using MessagePack;

namespace Gallop;

[MessagePackObject(false)]
public class PracticePartnerOwnerInfo
{
	[Key("partner_trained_chara_id")]
	public int partner_trained_chara_id;

	[Key("owner_viewer_id")]
	public long owner_viewer_id;

	[Key("owner_name")]
	public string owner_name;

	[Key("owner_trained_chara_id")]
	public int owner_trained_chara_id;

	[Key("friend_state")]
	public int friend_state;
}
