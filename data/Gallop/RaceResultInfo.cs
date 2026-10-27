using MessagePack;

namespace Gallop;

[MessagePackObject(false)]
public class RaceResultInfo
{
	[Key("race_instance_id")]
	public int race_instance_id;

	[Key("race_horse_data_array")]
	public RaceHorseData[] race_horse_data_array;

	[Key("season")]
	public int season;

	[Key("weather")]
	public int weather;

	[Key("ground_condition")]
	public int ground_condition;

	[Key("random_seed")]
	public int random_seed;

	[Key("race_scenario")]
	public string race_scenario;
}
