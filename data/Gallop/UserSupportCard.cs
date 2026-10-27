using MessagePack;

namespace Gallop;

[MessagePackObject(false)]
public class UserSupportCard
{
	[Key("viewer_id")]
	public long viewer_id;

	[Key("support_card_id")]
	public int support_card_id;

	[Key("exp")]
	public int exp;

	[Key("limit_break_count")]
	public int limit_break_count;

	[Key("favorite_flag")]
	public int favorite_flag;

	[Key("stock")]
	public int stock;

	[Key("possess_time")]
	public string possess_time;
}
