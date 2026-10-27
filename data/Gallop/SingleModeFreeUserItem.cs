using MessagePack;

namespace Gallop;

[MessagePackObject(false)]
public class SingleModeFreeUserItem
{
	[Key("item_id")]
	public int item_id;

	[Key("num")]
	public int num;
}
