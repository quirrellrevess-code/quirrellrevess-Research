using MessagePack;

namespace Gallop;

[MessagePackObject(false)]
public class SingleModeParamsIncDecInfo
{
	[Key("target_type")]
	public int target_type;

	[Key("value")]
	public int value;
}
