using MessagePack;

namespace Gallop;

[MessagePackObject(false)]
public class ArcPotential
{
	[Key("potential_id")]
	public int potential_id;

	[Key("level")]
	public int level;

	[Key("progress_array")]
	public SingleModeArcPotentialProgress[] progress_array;
}
