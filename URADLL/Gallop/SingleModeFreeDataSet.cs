using MessagePack;

namespace Gallop;

[MessagePackObject(false)]
public class SingleModeFreeDataSet
{
	[Key("shop_id")]
	public int shop_id;

	[Key("sale_value")]
	public int sale_value;

	[Key("win_points")]
	public int win_points;

	[Key("gained_coin_num")]
	public int gained_coin_num;

	[Key("coin_num")]
	public int coin_num;

	[Key("twinkle_race_ranking")]
	public int twinkle_race_ranking;

	[Key("user_item_info_array")]
	public SingleModeFreeUserItem[] user_item_info_array;

	[Key("pick_up_item_info_array")]
	public SingleModeFreePickUpItem[] pick_up_item_info_array;

	[Key("twinkle_race_npc_info_array")]
	public SingleModeFreeTwinkleRaceNpcInfo[] twinkle_race_npc_info_array;

	[Key("item_effect_array")]
	public SingleModeFreeItemEffect[] item_effect_array;

	[Key("twinkle_race_npc_result_array")]
	public SingleModeTwikleRaceNpcResult[] twinkle_race_npc_result_array;

	[Key("rival_race_info_array")]
	public SingleModeRivalRaceInfo[] rival_race_info_array;

	[Key("command_info_array")]
	public SingleModeFreeCommandInfo[] command_info_array;

	[Key("unchecked_event_achievement_id")]
	public int? unchecked_event_achievement_id;
}
