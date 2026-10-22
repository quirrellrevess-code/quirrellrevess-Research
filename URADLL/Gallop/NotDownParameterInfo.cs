using MessagePack;

namespace Gallop;

[MessagePackObject(false)]
public class NotDownParameterInfo
{
	[Key("evaluation_chara_id_array")]
	public int[] evaluation_chara_id_array;
}
