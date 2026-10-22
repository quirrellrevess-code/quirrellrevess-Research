using MessagePack;

namespace Gallop;

[MessagePackObject(false)]
public class SingleModeNpcResult
{
	[Key("npc_id")]
	public int npc_id;

	[Key("result_rank")]
	public int result_rank;
}
