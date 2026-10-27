using MessagePack;

namespace Gallop;

[MessagePackObject(false)]
public class CharaRaceReward
{
	[Key("result_rank")]
	public int result_rank;

	[Key("result_time")]
	public int result_time;

	[Key("race_reward")]
	public RaceRewardData[] race_reward;

	[Key("race_reward_bonus")]
	public RaceRewardData[] race_reward_bonus;

	[Key("race_reward_plus_bonus")]
	public RaceRewardData[] race_reward_plus_bonus;

	[Key("race_reward_bonus_win")]
	public RaceRewardData[] race_reward_bonus_win;

	[Key("gained_fans")]
	public int gained_fans;

	[Key("campaign_id_array")]
	public int[] campaign_id_array;
}
