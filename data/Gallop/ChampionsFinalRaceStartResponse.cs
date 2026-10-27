using MessagePack;

namespace Gallop;

[MessagePackObject(false)]
public class ChampionsFinalRaceStartResponse
{
	[MessagePackObject(false)]
	public class CommonResponse
	{
		[Key("room_info")]
		public ChampionsRoomInfo room_info;

		[Key("room_user_array")]
		public ChampionsRoomUser[] room_user_array;

		[Key("race_horse_data_array")]
		public RaceHorseData[] race_horse_data_array;

		[Key("trained_chara_array")]
		public TrainedChara[] trained_chara_array;

		[Key("state")]
		public int state;
	}

	[Key("data")]
	public CommonResponse data;
}
