using MessagePack;

namespace Gallop;

[MessagePackObject(false)]
public class TeamStadiumOpponentListResponse
{
	[MessagePackObject(false)]
	public class CommonResponse
	{
		[Key("opponent_info_array")]
		public TeamStadiumOpponent[] opponent_info_array;

		[Key("opponent_info_copy")]
		public TeamStadiumOpponent? opponent_info_copy;
	}

	[Key("data")]
	public CommonResponse data;
}
