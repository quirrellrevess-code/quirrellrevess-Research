using MessagePack;

namespace Gallop;

[MessagePackObject(false)]
public class SingleModeSportDataSet
{
	[Key("training_array")]
	public SingleModeSportTraining[] training_array;

	[Key("command_info_array")]
	public SingleModeSportCommandInfo[] command_info_array;

	[Key("item_id_array")]
	public int[] item_id_array;

	[Key("effected_item_id_array")]
	public int[] effected_item_id_array;

	[Key("competition_result_array")]
	public SingleModeSportCompetitionResult[] competition_result_array;

	[Key("effected_stance_array")]
	public SingleModeSportEffectedStance[] effected_stance_array;

	[Key("compe_effect_id_array")]
	public int[] compe_effect_id_array;
}
