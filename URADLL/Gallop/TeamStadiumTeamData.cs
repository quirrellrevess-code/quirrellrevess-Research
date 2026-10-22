using MessagePack;

namespace Gallop;

[MessagePackObject(false)]
public class TeamStadiumTeamData
{
	[Key("distance_type")]
	public int distance_type;

	[Key("member_id")]
	public int member_id;

	[Key("trained_chara_id")]
	public int trained_chara_id;

	[Key("running_style")]
	public int running_style;
}
