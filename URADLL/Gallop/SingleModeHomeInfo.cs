using MessagePack;

namespace Gallop;

[MessagePackObject(false)]
public class SingleModeHomeInfo
{
	[Key("command_info_array")]
	public SingleModeCommandInfo[] command_info_array;

	[Key("race_entry_restriction")]
	public int race_entry_restriction;

	[Key("disable_command_id_array")]
	public int[] disable_command_id_array;

	[Key("available_continue_num")]
	public int available_continue_num;

	[Key("free_continue_time")]
	public long free_continue_time;

	[Key("shortened_race_state")]
	public int shortened_race_state;
}
