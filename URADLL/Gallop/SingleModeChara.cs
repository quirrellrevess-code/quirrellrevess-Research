using MessagePack;

namespace Gallop;

[MessagePackObject(false)]
public class SingleModeChara
{
	[Key("single_mode_chara_id")]
	public int single_mode_chara_id;

	[Key("card_id")]
	public int card_id;

	[Key("chara_grade")]
	public int chara_grade;

	[Key("speed")]
	public int speed;

	[Key("stamina")]
	public int stamina;

	[Key("power")]
	public int power;

	[Key("wiz")]
	public int wiz;

	[Key("guts")]
	public int guts;

	[Key("vital")]
	public int vital;

	[Key("max_speed")]
	public int max_speed;

	[Key("max_stamina")]
	public int max_stamina;

	[Key("max_power")]
	public int max_power;

	[Key("max_wiz")]
	public int max_wiz;

	[Key("max_guts")]
	public int max_guts;

	[Key("default_max_speed")]
	public int default_max_speed;

	[Key("default_max_stamina")]
	public int default_max_stamina;

	[Key("default_max_power")]
	public int default_max_power;

	[Key("default_max_wiz")]
	public int default_max_wiz;

	[Key("default_max_guts")]
	public int default_max_guts;

	[Key("max_vital")]
	public int max_vital;

	[Key("motivation")]
	public int motivation;

	[Key("fans")]
	public int fans;

	[Key("rarity")]
	public int rarity;

	[Key("race_program_id")]
	public int race_program_id;

	[Key("reserve_race_program_id")]
	public int reserve_race_program_id;

	[Key("race_running_style")]
	public int race_running_style;

	[Key("is_short_race")]
	public int is_short_race;

	[Key("talent_level")]
	public int talent_level;

	[Key("skill_array")]
	public SkillData[] skill_array;

	[Key("disable_skill_id_array")]
	public int[] disable_skill_id_array;

	[Key("skill_tips_array")]
	public SkillTips[] skill_tips_array;

	[Key("support_card_array")]
	public SingleModeSupportCard[] support_card_array;

	[Key("succession_trained_chara_id_1")]
	public int succession_trained_chara_id_1;

	[Key("succession_trained_chara_id_2")]
	public int succession_trained_chara_id_2;

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

	[Key("turn")]
	public int turn;

	[Key("skill_point")]
	public int skill_point;

	[Key("short_cut_state")]
	public int short_cut_state;

	[Key("state")]
	public int state;

	[Key("playing_state")]
	public int playing_state;

	[Key("scenario_id")]
	public int scenario_id;

	[Key("route_id")]
	public int route_id;

	[Key("start_time")]
	public string start_time;

	[Key("evaluation_info_array")]
	public EvaluationInfo[] evaluation_info_array;

	[Key("training_level_info_array")]
	public TrainingLevelInfo[] training_level_info_array;

	[Key("nickname_id_array")]
	public int[] nickname_id_array;

	[Key("chara_effect_id_array")]
	public int[] chara_effect_id_array;

	[Key("route_race_id_array")]
	public int[] route_race_id_array;

	[Key("guest_outing_info_array")]
	public GuestOutingInfo[] guest_outing_info_array;

	[Key("skill_upgrade_info_array")]
	public SkillUpgradeInfo[] skill_upgrade_info_array;
}
