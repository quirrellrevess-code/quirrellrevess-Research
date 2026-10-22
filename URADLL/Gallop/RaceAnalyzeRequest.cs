using MessagePack;

namespace Gallop;

[MessagePackObject(false)]
public class RaceAnalyzeRequest
{
	[Key("program_id")]
	public int program_id;

	[Key("current_turn")]
	public int current_turn;
}
