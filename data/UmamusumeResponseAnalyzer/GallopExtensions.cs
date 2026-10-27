using System.Linq;
using Gallop;

namespace UmamusumeResponseAnalyzer;

public static class GallopExtensions
{
	public static int GetCommandInfoStage(this SingleModeCheckEventResponse @event)
	{
		if (@event.data.chara_info.playing_state == 1 && (@event.data.unchecked_event_array == null || @event.data.unchecked_event_array.Length == 0))
		{
			return 2;
		}
		if (@event.data.chara_info.playing_state == 5 && @event.data.unchecked_event_array.Any((SingleModeEventInfo x) => x.story_id == 400010112))
		{
			return 5;
		}
		if (@event.data.chara_info.playing_state == 5 && @event.data.unchecked_event_array.Any((SingleModeEventInfo x) => x.story_id == 830241003))
		{
			return 3;
		}
		return 0;
	}
}
