using MessagePack;

namespace Gallop;

[MessagePackObject(false)]
public class SingleModeSportEffectedStance
{
	[Key("stance_id")]
	public int stance_id;

	[Key("remain_count")]
	public int remain_count;
}
