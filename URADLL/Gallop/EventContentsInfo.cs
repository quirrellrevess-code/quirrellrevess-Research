using MessagePack;

namespace Gallop;

[MessagePackObject(false)]
public class EventContentsInfo
{
	[Key("support_card_id")]
	public int support_card_id;

	[Key("show_clear")]
	public int show_clear;

	[Key("show_clear_sort_id")]
	public int show_clear_sort_id;

	[Key("choice_array")]
	public ChoiceArray[] choice_array;

	[Key("is_effected_multi_chara")]
	public bool is_effected_multi_chara;
}
