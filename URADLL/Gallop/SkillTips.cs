using MessagePack;

namespace Gallop;

[MessagePackObject(false)]
public class SkillTips
{
	[Key("group_id")]
	public int group_id;

	[Key("rarity")]
	public int rarity;

	[Key("level")]
	public int level;
}
