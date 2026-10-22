using System.Reflection;
using System.Threading;

namespace UmamusumeResponseAnalyzer.LocalizedLayout;

public class RecommendTerminalSize
{
	public class TerminalSize
	{
		public int Width { get; }

		public int Height { get; }

		public TerminalSize(int width, int height)
		{
			Width = width;
			Height = height;
		}
	}

	public static TerminalSize SimplifiedChinese = new TerminalSize(110, 35);

	public static TerminalSize Japanese = new TerminalSize(135, 35);

	public static TerminalSize English = new TerminalSize(110, 35);

	public static TerminalSize Current
	{
		get
		{
			string name = Thread.CurrentThread.CurrentUICulture.Name switch
			{
				"zh-CN" => "SimplifiedChinese", 
				"en-US" => "English", 
				"ja-JP" => "Japanese", 
				_ => "English", 
			};
			return (TerminalSize)typeof(RecommendTerminalSize).GetField(name, BindingFlags.Static | BindingFlags.Public).GetValue(null);
		}
	}
}
