using MessagePack;

namespace Gallop;

[MessagePackObject(false)]
public class SingleModeVenusRaceHistory
{
	[Key("race_num")]
	public int race_num;

	[Key("turn")]
	public int turn;

	[Key("result_rank")]
	public int result_rank;
}
