using MessagePack;

namespace Gallop;

[MessagePackObject(false)]
public class SuccessionEffectedFactor
{
	[Key("position")]
	public int position;

	[Key("factor_id_array")]
	public int[] factor_id_array;

	[Key("factor_info_array")]
	public FactorInfo[] factor_info_array;
}
