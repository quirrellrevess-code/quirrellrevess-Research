using MessagePack;

namespace Gallop;

[MessagePackObject(false)]
public class TrainedCharaRaceResult
{
	[Key("turn")]
	public int turn;

	[Key("program_id")]
	public int program_id;

	[Key("weather")]
	public int weather;

	[Key("ground_condition")]
	public int ground_condition;

	[Key("running_style")]
	public int running_style;

	[Key("result_rank")]
	public int result_rank;
}
