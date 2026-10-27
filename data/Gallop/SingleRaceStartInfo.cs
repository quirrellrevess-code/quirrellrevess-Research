using MessagePack;

namespace Gallop;

[MessagePackObject(false)]
public class SingleRaceStartInfo
{
	[Key("program_id")]
	public int program_id;

	[Key("random_seed")]
	public int random_seed;

	[Key("weather")]
	public int weather;

	[Key("ground_condition")]
	public int ground_condition;

	[Key("race_horse_data")]
	public RaceHorseData[] race_horse_data;

	[Key("continue_num")]
	public int continue_num;
}
