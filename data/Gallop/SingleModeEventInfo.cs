using MessagePack;

namespace Gallop;

[MessagePackObject(false)]
public class SingleModeEventInfo
{
	[Key("event_id")]
	public int event_id;

	[Key("chara_id")]
	public int chara_id;

	[Key("story_id")]
	public int story_id;

	[Key("play_timing")]
	public int play_timing;

	[Key("event_contents_info")]
	public EventContentsInfo event_contents_info;

	[Key("succession_event_info")]
	public SingleModeSuccessionEventInfo succession_event_info;

	[Key("minigame_result")]
	public MinigameResult minigame_result;
}
