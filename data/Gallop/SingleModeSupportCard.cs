using MessagePack;

namespace Gallop;

[MessagePackObject(false)]
public class SingleModeSupportCard
{
	[Key("position")]
	public int position;

	[Key("support_card_id")]
	public int support_card_id;

	[Key("limit_break_count")]
	public int limit_break_count;

	[Key("exp")]
	public int exp;

	[Key("training_partner_state")]
	public int training_partner_state;

	[Key("owner_viewer_id")]
	public long owner_viewer_id;
}
