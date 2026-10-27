using Cute.Http;
using MessagePack;

namespace Gallop;

[MessagePackObject(false)]
public class ResponseCommon
{
	[Key("data_headers")]
	public DataHeader data_headers;
}
