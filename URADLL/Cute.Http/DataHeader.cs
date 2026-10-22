using MessagePack;

namespace Cute.Http;

[MessagePackObject(false)]
public class DataHeader
{
	[Key("result_code")]
	public int result_code;
}
