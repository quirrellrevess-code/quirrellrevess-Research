using MessagePack;

namespace Gallop;

[MessagePackObject(false)]
public class MinigameResult
{
	[Key("result_state")]
	public int result_state;

	[Key("result_value")]
	public int result_value;

	[Key("result_detail_array")]
	public MinigameResultDetail[] result_detail_array;
}
