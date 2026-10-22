using MessagePack;

namespace Gallop;

[MessagePackObject(false)]
public class SingleModeSportCompetitionResult
{
	[Key("compe_type")]
	public int compe_type;

	[Key("result_state")]
	public int result_state;

	[Key("win_command_id_array")]
	public int[] win_command_id_array;

	[Key("prize_command_id_array")]
	public int[] prize_command_id_array;
}
