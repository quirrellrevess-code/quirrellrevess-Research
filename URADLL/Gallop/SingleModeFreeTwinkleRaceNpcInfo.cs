using MessagePack;

namespace Gallop;

[MessagePackObject(false)]
public class SingleModeFreeTwinkleRaceNpcInfo
{
	[Key("npc_id")]
	public int npc_id;

	[Key("chara_id")]
	public int chara_id;

	[Key("dress_id")]
	public int dress_id;

	[Key("talent_level")]
	public int talent_level;

	[Key("win_points")]
	public int win_points;

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

	[Key("proper_distance_short")]
	public int proper_distance_short;

	[Key("proper_distance_mile")]
	public int proper_distance_mile;

	[Key("proper_distance_middle")]
	public int proper_distance_middle;

	[Key("proper_distance_long")]
	public int proper_distance_long;

	[Key("proper_running_style_nige")]
	public int proper_running_style_nige;

	[Key("proper_running_style_senko")]
	public int proper_running_style_senko;

	[Key("proper_running_style_sashi")]
	public int proper_running_style_sashi;

	[Key("proper_running_style_oikomi")]
	public int proper_running_style_oikomi;

	[Key("proper_ground_turf")]
	public int proper_ground_turf;

	[Key("proper_ground_dirt")]
	public int proper_ground_dirt;

	[Key("skill_array")]
	public SkillData[] skill_array;
}
