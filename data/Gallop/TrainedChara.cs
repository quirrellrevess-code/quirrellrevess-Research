using MessagePack;

namespace Gallop;

[MessagePackObject(false)]
public class TrainedChara
{
	[Key("viewer_id")]
	public long viewer_id;

	[Key("trained_chara_id")]
	public int trained_chara_id;

	[Key("owner_viewer_id")]
	public long owner_viewer_id;

	[Key("use_type")]
	public int use_type;

	[Key("card_id")]
	public int card_id;

	[Key("name")]
	public string name;

	[Key("stamina")]
	public int stamina;

	[Key("speed")]
	public int speed;

	[Key("power")]
	public int power;

	[Key("guts")]
	public int guts;

	[Key("wiz")]
	public int wiz;

	[Key("fans")]
	public int fans;

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

	[Key("succession_num")]
	public int succession_num;

	[Key("is_locked")]
	public int is_locked;

	[Key("rarity")]
	public int rarity;

	[Key("talent_level")]
	public int talent_level;

	[Key("chara_grade")]
	public int chara_grade;

	[Key("running_style")]
	public int running_style;

	[Key("nickname_id")]
	public int nickname_id;

	[Key("wins")]
	public int wins;

	[Key("skill_array")]
	public SkillData[] skill_array;

	[Key("support_card_list")]
	public TrainedCharaSupportCardList[] support_card_list;

	[Key("is_saved")]
	public int is_saved;

	[Key("race_result_list")]
	public TrainedCharaRaceResult[] race_result_list;

	[Key("win_saddle_id_array")]
	public int[] win_saddle_id_array;

	[Key("nickname_id_array")]
	public int[] nickname_id_array;

	[Key("factor_info_array")]
	public FactorInfo[] factor_info_array;

	[Key("factor_extend_array")]
	public FactorExtendInfo[] factor_extend_array;

	[Key("succession_chara_array")]
	public SuccessionChara[] succession_chara_array;

	[Key("succession_history_array")]
	public SuccessionHistory[] succession_history_array;

	[Key("scenario_id")]
	public int scenario_id;

	[Key("create_time")]
	public string create_time;
}
