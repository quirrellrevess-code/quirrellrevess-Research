using MessagePack;

namespace Gallop;

[MessagePackObject(false)]
public class SingleModeExecCommandRequest
{
	[Key("command_type")]
	public int command_type;

	[Key("command_id")]
	public int command_id;

	[Key("command_group_id")]
	public int command_group_id;

	[Key("select_id")]
	public int select_id;

	[Key("current_turn")]
	public int current_turn;

	[Key("current_vital")]
	public int current_vital;
}
