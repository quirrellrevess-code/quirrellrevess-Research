using MessagePack;

namespace Gallop;

[MessagePackObject(false)]
public class SingleModeTeamDataSet
{
	[Key("command_info_array")]
	public SingleModeTeamCommandInfo[] command_info_array;
}
