using MessagePack;

namespace Gallop;

[MessagePackObject(false)]
public class SingleModeLiveDataSet
{
	[Key("command_info_array")]
	public SingleModeLiveCommandInfo[] command_info_array;
}
