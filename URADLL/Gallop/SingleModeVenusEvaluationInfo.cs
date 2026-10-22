using MessagePack;

namespace Gallop;

[MessagePackObject(false)]
public class SingleModeVenusEvaluationInfo
{
	[Key("target_id")]
	public int target_id;

	[Key("chara_id")]
	public int chara_id;

	[Key("member_state")]
	public int member_state;
}
