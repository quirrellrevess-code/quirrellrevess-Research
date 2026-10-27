using MessagePack;

namespace Gallop;

[MessagePackObject(false)]
public class ArcEvaluationInfo
{
	[Key("target_id")]
	public int target_id;

	[Key("chara_id")]
	public int chara_id;
}
