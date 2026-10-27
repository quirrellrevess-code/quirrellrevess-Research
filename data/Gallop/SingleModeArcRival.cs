using MessagePack;

namespace Gallop;

[MessagePackObject(false)]
public class SingleModeArcRival
{
	[Key("chara_id")]
	public int chara_id;

	[Key("speed")]
	public int speed;

	[Key("stamina")]
	public int stamina;

	[Key("power")]
	public int power;

	[Key("guts")]
	public int guts;

	[Key("wiz")]
	public int wiz;

	[Key("command_id")]
	public int command_id;

	[Key("rival_boost")]
	public int rival_boost;

	[Key("star_lv")]
	public int star_lv;

	[Key("rank")]
	public int rank;

	[Key("approval_point")]
	public int approval_point;

	[Key("potential_array")]
	public ArcRivalPotential[] potential_array;

	[Key("selection_peff_array")]
	public ArcSelectionPeff[] selection_peff_array;
}
