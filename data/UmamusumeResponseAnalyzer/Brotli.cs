using System.IO;
using System.IO.Compression;

namespace UmamusumeResponseAnalyzer;

public static class Brotli
{
	public static byte[] Decompress(byte[] input)
	{
		using MemoryStream stream = new MemoryStream(input);
		using MemoryStream memoryStream = new MemoryStream();
		using (BrotliStream brotliStream = new BrotliStream(stream, CompressionMode.Decompress))
		{
			brotliStream.CopyTo(memoryStream);
		}
		return memoryStream.ToArray();
	}
}
