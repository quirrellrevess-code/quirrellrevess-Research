using MessagePack;

namespace Gallop;

[MessagePackObject(false)]
public class SingleModeArcSelectionRivalInfo
{
	[Key("chara_id")]
	public int chara_id;

	[Key("mark")]
	public int mark;

	[Key("win_approval_point")]
	public int win_approval_point;

	[Key("lose_approval_point")]
	public int lose_approval_point;

	[Key("rival_win_approval_point")]
	public int rival_win_approval_point;

	[Key("rival_lose_approval_point")]
	public int rival_lose_approval_point;
}
