using MessagePack;

namespace Gallop;

[MessagePackObject(false)]
public class ChoiceArray
{
	[Key("select_index")]
	public int select_index;

	[Key("receive_item_id")]
	public int receive_item_id;

	[Key("target_race_id")]
	public int target_race_id;
}
