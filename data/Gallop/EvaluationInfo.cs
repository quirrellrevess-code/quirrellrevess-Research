using MessagePack;

namespace Gallop;

[MessagePackObject(false)]
public class EvaluationInfo
{
	[Key("target_id")]
	public int target_id;

	[Key("evaluation")]
	public int evaluation;

	[Key("is_outing")]
	public int is_outing;

	[Key("story_step")]
	public int story_step;

	[Key("is_appear")]
	public int is_appear;

	[Key("group_outing_info_array")]
	public GroupOutingInfo[] group_outing_info_array;
}
