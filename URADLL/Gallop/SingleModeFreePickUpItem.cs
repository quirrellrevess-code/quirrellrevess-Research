using MessagePack;

namespace Gallop;

[MessagePackObject(false)]
public class SingleModeFreePickUpItem
{
	[Key("shop_item_id")]
	public int shop_item_id;

	[Key("item_id")]
	public int item_id;

	[Key("coin_num")]
	public int coin_num;

	[Key("original_coin_num")]
	public int original_coin_num;

	[Key("item_buy_num")]
	public int item_buy_num;

	[Key("limit_buy_count")]
	public int limit_buy_count;

	[Key("limit_turn")]
	public int limit_turn;
}
