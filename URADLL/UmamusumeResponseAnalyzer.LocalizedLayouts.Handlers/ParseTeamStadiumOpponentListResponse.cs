using System.Threading;

namespace UmamusumeResponseAnalyzer.LocalizedLayouts.Handlers;

public static class ParseTeamStadiumOpponentListResponse
{
	public static string ColumnWidth = Thread.CurrentThread.CurrentUICulture.Name switch
	{
		"zh-CN" => "\u3000\u3000\u3000", 
		"ja-JP" => "\u3000\u3000\u3000\u3000\u3000", 
		"en-US" => "\u3000\u3000\u3000\u3000", 
		_ => "\u3000\u3000\u3000\u3000", 
	};

	public static int MinimumConsoleWidth => Thread.CurrentThread.CurrentUICulture.Name switch
	{
		"zh-CN" => 160, 
		"ja-JP" => 220, 
		"en-US" => 200, 
		_ => 200, 
	};
}
