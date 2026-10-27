using MessagePack;

namespace Gallop;

[MessagePackObject(false)]
public class ChampionsRoomUser
{
	[Key("room_id")]
	public long room_id;

	[Key("viewer_id")]
	public long viewer_id;

	[Key("name")]
	public string name;

	[Key("honor_id")]
	public int honor_id;

	[Key("team_id")]
	public int team_id;

	[Key("entry_chara_array")]
	public ChampionsUserChara[] entry_chara_array;
}
