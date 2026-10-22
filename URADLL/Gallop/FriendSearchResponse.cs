using MessagePack;

namespace Gallop;

[MessagePackObject(false)]
public class FriendSearchResponse
{
	[MessagePackObject(false)]
	public class CommonResponse
	{
		[Key("friend_info")]
		public UserFriend friend_info;

		[Key("user_info_summary")]
		public UserInfoAtFriend user_info_summary;

		[Key("practice_partner_info")]
		public TrainedChara practice_partner_info;

		[Key("partner_chara_info_array")]
		public TrainedChara[] partner_chara_info_array;

		[Key("directory_chara_info")]
		public TrainedChara[] directory_chara_info;

		[Key("directory_card_array")]
		public DirectoryCard[] directory_card_array;

		[Key("support_card_data")]
		public UserSupportCard support_card_data;

		[Key("support_card_data_array")]
		public UserSupportCard[] support_card_data_array;

		[Key("trophy_num_info")]
		public TrophyNumInfo trophy_num_info;

		[Key("release_num_info")]
		public ReleaseNumInfo release_num_info;

		[Key("team_stadium_user")]
		public TeamStadiumUser team_stadium_user;

		[Key("follower_num")]
		public int follower_num;

		[Key("own_follow_num")]
		public int own_follow_num;

		[Key("enable_circle_scout")]
		public int enable_circle_scout;
	}

	[Key("data")]
	public CommonResponse data;
}
