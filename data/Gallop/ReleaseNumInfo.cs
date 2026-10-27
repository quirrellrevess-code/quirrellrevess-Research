using MessagePack;

namespace Gallop;

[MessagePackObject(false)]
public class ReleaseNumInfo
{
	[Key("voice_num")]
	public int voice_num;

	[Key("act_num")]
	public int act_num;

	[Key("good_end_num")]
	public int good_end_num;

	[Key("music_num")]
	public int music_num;

	[Key("main_story_num")]
	public int main_story_num;

	[Key("chara_story_num")]
	public int chara_story_num;

	[Key("card_num")]
	public int card_num;

	[Key("support_card_num")]
	public int support_card_num;

	[Key("chara_event_num")]
	public int chara_event_num;

	[Key("support_event_num")]
	public int support_event_num;

	[Key("scenario_event_num")]
	public int scenario_event_num;

	[Key("home_event_num")]
	public int home_event_num;
}
