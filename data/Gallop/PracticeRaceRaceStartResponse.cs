using MessagePack;

namespace Gallop;

[MessagePackObject(false)]
public class PracticeRaceRaceStartResponse
{
	[MessagePackObject(false)]
	public class CommonResponse
	{
		[Key("trained_chara_array")]
		public TrainedChara[] trained_chara_array;

		[Key("race_result_info")]
		public RaceResultInfo race_result_info;

		[Key("entry_info_array")]
		public PracticeRaceEntryInfo[] entry_info_array;

		[Key("practice_race_id")]
		public int practice_race_id;

		[Key("state")]
		public int state;

		[Key("practice_partner_owner_info_array")]
		public PracticePartnerOwnerInfo[] practice_partner_owner_info_array;
	}

	[Key("data")]
	public CommonResponse data;
}
