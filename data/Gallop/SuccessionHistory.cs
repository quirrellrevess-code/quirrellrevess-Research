using MessagePack;

namespace Gallop;

[MessagePackObject(false)]
public class SuccessionHistory
{
	[Key("id")]
	public int id;

	[Key("viewer_id")]
	public long viewer_id;

	[Key("trained_chara_id")]
	public int trained_chara_id;

	[Key("hisotry_type")]
	public int hisotry_type;

	[Key("succession_card_id")]
	public int succession_card_id;

	[Key("date")]
	public int date;

	[Key("user_name")]
	public string user_name;

	[Key("circle_name")]
	public string circle_name;
}
