using MessagePack;

namespace Gallop;

[MessagePackObject(false)]
public class ChampionsUserChara
{
	[Key("chara_id")]
	public int chara_id;

	[Key("race_cloth_id")]
	public int race_cloth_id;

	[Key("nick_name_id")]
	public int nick_name_id;

	[Key("team_member_id")]
	public int team_member_id;
}
