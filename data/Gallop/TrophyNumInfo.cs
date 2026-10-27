using MessagePack;

namespace Gallop;

[MessagePackObject(false)]
public class TrophyNumInfo
{
	[Key("grade_1")]
	public int grade_1;

	[Key("grade_2")]
	public int grade_2;

	[Key("grade_3")]
	public int grade_3;

	[Key("grade_ex")]
	public int grade_ex;
}
