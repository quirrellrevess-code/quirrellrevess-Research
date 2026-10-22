using MessagePack;

namespace Gallop;

[MessagePackObject(false)]
public class ArcRivalPotential
{
	[Key("potential_id")]
	public int potential_id;

	[Key("level")]
	public int level;
}
