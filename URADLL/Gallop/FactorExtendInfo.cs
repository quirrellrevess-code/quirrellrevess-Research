using MessagePack;

namespace Gallop;

[MessagePackObject(false)]
public class FactorExtendInfo
{
	[Key("position_id")]
	public int position_id;

	[Key("base_factor_id")]
	public int base_factor_id;

	[Key("factor_id")]
	public int factor_id;

	[Key("register_time")]
	public string register_time;
}
