using MessagePack;

namespace Gallop;

[MessagePackObject(false)]
public class DirectoryCard
{
	[Key("card_id")]
	public int card_id;

	[Key("directory_ranking")]
	public int directory_ranking;

	[Key("trained_chara")]
	public TrainedChara trained_chara;
}
