using System.Collections.Frozen;
using System.Collections.Generic;
using System.Linq;
using Gallop;

namespace UmamusumeResponseAnalyzer.Game.TurnInfo;

public class TurnInfoPioneer : TurnInfo
{
	public static readonly int[] TrainIds = new int[10] { 101, 105, 102, 103, 106, 3601, 3602, 3603, 3604, 3605 };

	public static readonly FrozenDictionary<int, int> ToTrainId = new Dictionary<int, int>
	{
		[101] = 101,
		[105] = 105,
		[102] = 102,
		[103] = 103,
		[106] = 106,
		[3601] = 101,
		[3602] = 105,
		[3603] = 102,
		[3604] = 103,
		[3605] = 106
	}.ToFrozenDictionary();

	public static readonly FrozenDictionary<int, int> ToTrainIndex = new Dictionary<int, int>
	{
		[101] = 0,
		[105] = 1,
		[102] = 2,
		[103] = 3,
		[106] = 4,
		[3601] = 0,
		[3602] = 1,
		[3603] = 2,
		[3604] = 3,
		[3605] = 4
	}.ToFrozenDictionary();

	public static readonly FrozenDictionary<int, int> XiahesuIds = new Dictionary<int, int>
	{
		[101] = 3601,
		[105] = 3602,
		[102] = 3603,
		[103] = 3604,
		[106] = 3605
	}.ToFrozenDictionary();

	public List<CommandInfo> CommandInfoArray { get; private set; } = new List<CommandInfo>();

	public Dictionary<int, int> PointGainInfoDictionary { get; private set; } = new Dictionary<int, int>();

	public TurnInfoPioneer(SingleModeCheckEventResponse.CommonResponse resp)
		: base(resp)
	{
		SingleModePioneerDataSet pioneer_data_set = resp.pioneer_data_set;
		SingleModePioneerCommandInfo[] command_info_array = pioneer_data_set.command_info_array;
		foreach (SingleModePioneerCommandInfo singleModePioneerCommandInfo in command_info_array)
		{
			CommandInfo item = new CommandInfo(resp, this, singleModePioneerCommandInfo.command_id, ToTrainIndex, ToTrainId);
			if (singleModePioneerCommandInfo.command_id != 3101)
			{
				CommandInfoArray.Add(item);
			}
		}
		PointGainInfoDictionary = pioneer_data_set.pioneer_point_gain_info_array.ToDictionary((SingleModePioneerPointGainInfo x) => x.command_id, (SingleModePioneerPointGainInfo x) => x.gain_num);
	}
}
