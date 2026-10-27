using MessagePack;

namespace Gallop;

[MessagePackObject(false)]
public class TrainedCharaSupportCardList
{
	[Key("position")]
	public int position;

	[Key("support_card_id")]
	public int support_card_id;

	[Key("exp")]
	public int exp;

	[Key("limit_break_count")]
	public int limit_break_count;
}
