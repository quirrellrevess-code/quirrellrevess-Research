using MessagePack;

namespace Gallop;

[MessagePackObject(false)]
public class SkillData
{
	[Key("skill_id")]
	public int skill_id;

	[Key("level")]
	public int level;
}
