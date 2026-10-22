using MessagePack;

namespace Gallop;

[MessagePackObject(false)]
public class SingleModeSportTraining
{
	[Key("command_type")]
	public int command_type;

	[Key("command_id")]
	public int command_id;

	[Key("sport_rank")]
	public int sport_rank;
}
