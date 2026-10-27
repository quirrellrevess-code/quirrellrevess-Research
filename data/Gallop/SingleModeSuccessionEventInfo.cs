using MessagePack;

namespace Gallop;

[MessagePackObject(false)]
public class SingleModeSuccessionEventInfo
{
	[Key("effect_type")]
	public int effect_type;

	[Key("succession_gain_info_array")]
	public SingleModeSuccessionGainInfo[] succession_gain_info_array;
}
