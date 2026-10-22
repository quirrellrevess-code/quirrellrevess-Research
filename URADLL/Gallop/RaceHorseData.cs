using MessagePack;

namespace Gallop;

[MessagePackObject(false)]
public class RaceHorseData
{
	[Key("viewer_id")]
	public long viewer_id;

	[Key("owner_viewer_id")]
	public long owner_viewer_id;

	[Key("trainer_name")]
	public string trainer_name;

	[Key("owner_trainer_name")]
	public string owner_trainer_name;

	[Key("single_mode_chara_id")]
	public int single_mode_chara_id;

	[Key("trained_chara_id")]
	public int trained_chara_id;

	[Key("nickname_id")]
	public int nickname_id;

	[Key("card_id")]
	public int? card_id;

	[Key("chara_id")]
	public int chara_id;

	[Key("rarity")]
	public int rarity;

	[Key("talent_level")]
	public int talent_level;

	[Key("frame_order")]
	public int frame_order;

	[Key("skill_array")]
	public SkillData[] skill_array;

	[Key("stamina")]
	public int stamina;

	[Key("speed")]
	public int speed;

	[Key("pow")]
	public int pow;

	[Key("guts")]
	public int guts;

	[Key("wiz")]
	public int wiz;

	[Key("running_style")]
	public int running_style;

	[Key("race_dress_id")]
	public int race_dress_id;

	[Key("chara_color_type")]
	public int chara_color_type;

	[Key("npc_type")]
	public int npc_type;

	[Key("final_grade")]
	public int final_grade;

	[Key("popularity")]
	public int popularity;

	[Key("popularity_mark_rank_array")]
	public int[] popularity_mark_rank_array;

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

	[Key("motivation")]
	public int motivation;

	[Key("mob_id")]
	public int mob_id;

	[Key("win_saddle_id_array")]
	public int[] win_saddle_id_array;

	[Key("race_result_array")]
	public RaceHorseDataRaceResult[] race_result_array;

	[Key("team_id")]
	public int team_id;

	[Key("team_member_id")]
	public int team_member_id;

	[Key("item_id_array")]
	public int[] item_id_array;

	[Key("motivation_change_flag")]
	public int motivation_change_flag;

	[Key("frame_order_change_flag")]
	public int frame_order_change_flag;

	[Key("team_rank")]
	public int team_rank;

	[Key("single_mode_win_count")]
	public int single_mode_win_count;
}
