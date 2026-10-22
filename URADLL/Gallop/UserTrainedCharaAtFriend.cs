using MessagePack;

namespace Gallop;

[MessagePackObject(false)]
public class UserTrainedCharaAtFriend
{
	[Key("viewer_id")]
	public long viewer_id;

	[Key("trained_chara_id")]
	public int trained_chara_id;

	[Key("card_id")]
	public int card_id;

	[Key("rank_score")]
	public int rank_score;

	[Key("rank")]
	public int rank;

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

	[Key("rarity")]
	public int rarity;

	[Key("talent_level")]
	public int talent_level;

	[Key("register_time")]
	public string register_time;

	[Key("factor_id_array")]
	public int[] factor_id_array;

	[Key("factor_info_array")]
	public FactorInfo[] factor_info_array;

	[Key("skill_count")]
	public int skill_count;
}
