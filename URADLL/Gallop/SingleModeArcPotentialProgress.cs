using MessagePack;

namespace Gallop;

[MessagePackObject(false)]
public class SingleModeArcPotentialProgress
{
	[Key("condition_id")]
	public int condition_id;

	[Key("total_count")]
	public int total_count;

	[Key("current_count")]
	public int current_count;
}
