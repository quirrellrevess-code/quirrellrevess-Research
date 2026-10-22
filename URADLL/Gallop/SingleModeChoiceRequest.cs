using MessagePack;

namespace Gallop;

[MessagePackObject(false)]
public class SingleModeChoiceRequest
{
	[Key("event_id")]
	public int event_id;

	[Key("chara_id")]
	public int chara_id;

	[Key("choice_number")]
	public int choice_number;

	[Key("current_turn")]
	public int current_turn;
}
