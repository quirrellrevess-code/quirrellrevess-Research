using MessagePack;

namespace Gallop;

[MessagePackObject(false)]
public class UserInfoAtFriend
{
	[Key("viewer_id")]
	public long viewer_id;

	[Key("name")]
	public string name;

	[Key("honor_id")]
	public int honor_id;

	[Key("last_login_time")]
	public string last_login_time;

	[Key("leader_chara_id")]
	public int leader_chara_id;

	[Key("support_card_id")]
	public int support_card_id;

	[Key("comment")]
	public string comment;

	[Key("fan")]
	public ulong fan;

	[Key("directory_level")]
	public int directory_level;

	[Key("rank_score")]
	public int rank_score;

	[Key("team_stadium_win_count")]
	public int team_stadium_win_count;

	[Key("single_mode_play_count")]
	public int single_mode_play_count;

	[Key("team_evaluation_point")]
	public int team_evaluation_point;

	[Key("best_team_evaluation_point")]
	public int best_team_evaluation_point;

	[Key("friend_state")]
	public int friend_state;

	[Key("circle_info")]
	public CircleInfoAtFriend circle_info;

	[Key("circle_user")]
	public CircleUser circle_user;

	[Key("user_support_card")]
	public UserSupportCardAtFriend user_support_card;

	[Key("leader_chara_dress_id")]
	public int leader_chara_dress_id;

	[Key("user_trained_chara")]
	public UserTrainedCharaAtFriend user_trained_chara;

	[Key("user_trained_chara_array")]
	public UserTrainedCharaAtFriend[] user_trained_chara_array;

	[Key("total_login_day_count")]
	public int total_login_day_count;
}
