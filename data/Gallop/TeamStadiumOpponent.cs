using MessagePack;

namespace Gallop;

[MessagePackObject(false)]
public class TeamStadiumOpponent
{
	[Key("strength")]
	public int strength;

	[Key("opponent_viewer_id")]
	public long opponent_viewer_id;

	[Key("evaluation_point")]
	public int evaluation_point;

	[Key("user_info")]
	public UserInfoAtFriend user_info;

	[Key("team_data_array")]
	public TeamStadiumTeamData[] team_data_array;

	[Key("trained_chara_array")]
	public TrainedChara[] trained_chara_array;

	[Key("winning_reward_guarantee_status")]
	public int winning_reward_guarantee_status;
}
