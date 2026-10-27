using MessagePack;

namespace Gallop;

[MessagePackObject(false)]
public class TrainedCharaLoadResponse : ResponseCommon
{
	[MessagePackObject(false)]
	public class CommonResponse
	{
		[Key("trained_chara_array")]
		public TrainedChara[] trained_chara_array;

		[Key("trained_chara_favorite_array")]
		public TrainedCharaFavorite[] trained_chara_favorite_array;

		[Key("room_match_entry_chara_id_array")]
		public int[] room_match_entry_chara_id_array;
	}

	[Key("data")]
	public CommonResponse data;
}
