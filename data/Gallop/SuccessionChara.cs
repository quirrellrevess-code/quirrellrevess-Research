using MessagePack;

namespace Gallop;

[MessagePackObject(false)]
public class SuccessionChara
{
	[Key("position_id")]
	public int position_id;

	[Key("card_id")]
	public int card_id;

	[Key("rank")]
	public int rank;

	[Key("rarity")]
	public int rarity;

	[Key("talent_level")]
	public int talent_level;

	[Key("factor_info_array")]
	public FactorInfo[] factor_info_array;

	[Key("win_saddle_id_array")]
	public int[] win_saddle_id_array;

	[Key("owner_viewer_id")]
	public long owner_viewer_id;

	[Key("user_info_summary")]
	public UserInfoAtFriend user_info_summary;
}
