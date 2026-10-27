using MessagePack;

namespace Gallop;

[MessagePackObject(false)]
public class TrainedCharaFavorite
{
	[Key("trained_chara_id")]
	public int trained_chara_id;

	[Key("icon_type")]
	public int icon_type;

	[Key("memo")]
	public string memo;
}
