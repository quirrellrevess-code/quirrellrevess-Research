using MessagePack;

namespace Gallop;

[MessagePackObject(false)]
public class TrainingLevelInfo
{
	[Key("command_id")]
	public int command_id;

	[Key("level")]
	public int level;
}
