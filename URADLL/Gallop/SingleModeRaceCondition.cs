using MessagePack;

namespace Gallop;

[MessagePackObject(false)]
public class SingleModeRaceCondition
{
	[Key("program_id")]
	public int program_id;

	[Key("weather")]
	public int weather;

	[Key("ground_condition")]
	public int ground_condition;
}
