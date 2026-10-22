using MessagePack;

namespace Gallop;

[MessagePackObject(false)]
public class SingleModeTwikleRaceNpcResult
{
	[Key("turn")]
	public int turn;

	[Key("program_id")]
	public int program_id;

	[Key("race_result_array")]
	public SingleModeNpcResult[] race_result_array;
}
