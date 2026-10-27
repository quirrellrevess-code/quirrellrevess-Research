using MessagePack;

namespace Gallop;

[MessagePackObject(false)]
public class RoomMatchRaceStartResponse
{
	[MessagePackObject(false)]
	public class CommonResponse
	{
		[Key("race_scenario")]
		public string race_scenario;

		[Key("random_seed")]
		public int random_seed;

		[Key("race_horse_data_array")]
		public RaceHorseData[] race_horse_data_array;

		[Key("trained_chara_array")]
		public TrainedChara[] trained_chara_array;

		[Key("season")]
		public int season;

		[Key("weather")]
		public int weather;

		[Key("ground_condition")]
		public int ground_condition;
	}

	[Key("data")]
	public CommonResponse data;
}
