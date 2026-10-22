using MessagePack;

namespace Gallop;

[MessagePackObject(false)]
public class SingleModeArcInfo
{
	[Key("approval_rate")]
	public int approval_rate;

	[Key("potential_array")]
	public ArcPotential[] potential_array;

	[Key("global_exp")]
	public int global_exp;

	[Key("sp_tag_boost_type")]
	public int sp_tag_boost_type;
}
