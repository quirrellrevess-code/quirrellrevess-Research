using MessagePack;

namespace Gallop;

[MessagePackObject(false)]
public class TeamStadiumUser
{
	[Key("team_class")]
	public int team_class;

	[Key("best_team_class")]
	public int best_team_class;

	[Key("best_point")]
	public int best_point;
}
