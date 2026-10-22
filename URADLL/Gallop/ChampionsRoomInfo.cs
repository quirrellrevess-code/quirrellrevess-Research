using MessagePack;

namespace Gallop;

[MessagePackObject(false)]
public class ChampionsRoomInfo
{
	[Key("room_id")]
	public long room_id;

	[Key("user_entry_num")]
	public int user_entry_num;

	[Key("race_start_time")]
	public string race_start_time;

	[Key("race_instance_id")]
	public int race_instance_id;

	[Key("season")]
	public int season;

	[Key("weather")]
	public int weather;

	[Key("ground_condition")]
	public int ground_condition;

	[Key("random_seed")]
	public int random_seed;

	[Key("race_scenario")]
	public string race_scenario;
}
