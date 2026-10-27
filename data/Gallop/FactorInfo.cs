using MessagePack;

namespace Gallop;

[MessagePackObject(false)]
public class FactorInfo
{
	[Key("factor_id")]
	public int factor_id;

	[Key("level")]
	public int level;
}
