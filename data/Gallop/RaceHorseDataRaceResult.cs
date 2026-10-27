using MessagePack;

namespace Gallop;

[MessagePackObject(false)]
public class RaceHorseDataRaceResult
{
	[Key("turn")]
	public int turn;

	[Key("program_id")]
	public int program_id;

	[Key("result_rank")]
	public int result_rank;
}
