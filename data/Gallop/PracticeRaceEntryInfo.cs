using MessagePack;

namespace Gallop;

[MessagePackObject(false)]
public class PracticeRaceEntryInfo
{
	[Key("entry_id")]
	public int entry_id;

	[Key("frame_order")]
	public int frame_order;
}
