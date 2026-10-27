using System.Reflection;
using System.Threading;

namespace UmamusumeResponseAnalyzer.LocalizedLayout.Handlers;

public class CommandInfoLayout
{
	public static CommandInfoLayout SimplifiedChinese = new CommandInfoLayout(17);

	public static CommandInfoLayout Japanese = new CommandInfoLayout(18);

	public static CommandInfoLayout English = new CommandInfoLayout(16);

	public static CommandInfoLayout Current
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
			return (CommandInfoLayout)typeof(CommandInfoLayout).GetField(name, BindingFlags.Static | BindingFlags.Public).GetValue(null);
		}
	}

	public int TrainingCardWidth { get; init; }

	public int MainSectionWidth => TrainingCardWidth * 5 + 10;

	public CommandInfoLayout(int tcw)
	{
		TrainingCardWidth = tcw;
	}
}
