using MessagePack;

namespace Gallop;

[MessagePackObject(false)]
public class SingleModeVenusDataSet
{
	[Key("race_start_info")]
	public SingleRaceStartInfo race_start_info;

	[Key("race_scenario")]
	public string race_scenario;

	[Key("command_info_array")]
	public SingleModeVenusCommandInfo[] command_info_array;

	[Key("evaluation_info_array")]
	public SingleModeVenusEvaluationInfo[] evaluation_info_array;

	[Key("spirit_info_array")]
	public SingleModeVenusSpiritInfo[] spirit_info_array;

	[Key("venus_spirit_active_effect_info_array")]
	public SingleModeVenusActiveSpiritEffect[] venus_spirit_active_effect_info_array;

	[Key("venus_chara_info_array")]
	public SingleModeVenusCharaInfo[] venus_chara_info_array;

	[Key("venus_chara_command_info_array")]
	public SingleModeVenusCharaCommandInfo[] venus_chara_command_info_array;

	[Key("venus_race_condition")]
	public SingleModeRaceCondition venus_race_condition;

	[Key("venus_race_history_array")]
	public SingleModeVenusRaceHistory[] venus_race_history_array;

	[Key("race_reward_info")]
	public CharaRaceReward race_reward_info;

	[Key("live_item_id")]
	public int live_item_id;
}
