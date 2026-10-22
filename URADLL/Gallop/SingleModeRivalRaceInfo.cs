using MessagePack;

namespace Gallop;

[MessagePackObject(false)]
public class SingleModeRivalRaceInfo
{
	[Key("program_id")]
	public int program_id;

	[Key("chara_id")]
	public int chara_id;
}
