using System.Collections.Frozen;
using System.Collections.Generic;
using System.Linq;
using Gallop;

namespace UmamusumeResponseAnalyzer.Game.TurnInfo;

public class TurnInfoBreeders : TurnInfo
{
	public static readonly int[] TrainIds = new int[10] { 101, 105, 102, 103, 106, 601, 602, 603, 604, 605 };

	public static readonly FrozenDictionary<int, int> ToTrainId = new Dictionary<int, int>
	{
		[101] = 101,
		[105] = 105,
		[102] = 102,
		[103] = 103,
		[106] = 106,
		[601] = 101,
		[602] = 105,
		[603] = 102,
		[604] = 103,
		[605] = 106
	}.ToFrozenDictionary();

	public static readonly FrozenDictionary<int, int> ToTrainIndex = new Dictionary<int, int>
	{
		[101] = 0,
		[105] = 1,
		[102] = 2,
		[103] = 3,
		[106] = 4,
		[601] = 0,
		[602] = 1,
		[603] = 2,
		[604] = 3,
		[605] = 4
	}.ToFrozenDictionary();

	public static readonly FrozenDictionary<int, int> XiahesuIds = new Dictionary<int, int>
	{
		[101] = 601,
		[105] = 602,
		[102] = 603,
		[103] = 604,
		[106] = 605
	}.ToFrozenDictionary();

	public static string[] TeamMemberRank = new string[17]
	{
		"G", "F", "E", "D", "C", "B", "A", "S", "SS", "UG",
		"UF", "UE", "UD", "UC", "UB", "UA", "US"
	};

	public int SpecialTrainingStock;

	public int SpecialTrainingMax;

	public bool SpecialTrainingActivated;

	public List<CommandInfo> CommandInfoArray { get; private set; } = new List<CommandInfo>();

	public Dictionary<int, int> PointGainInfoDictionary { get; private set; } = new Dictionary<int, int>();

	public Dictionary<int, SingleModeBreedersTeamMemberInfo> TeamMemberInfoDictionary { get; private set; } = new Dictionary<int, SingleModeBreedersTeamMemberInfo>();

	public Dictionary<int, SingleModeBreedersCommandTeamMemberInfo[]> CommandTeamMemberInfoDictionary { get; private set; } = new Dictionary<int, SingleModeBreedersCommandTeamMemberInfo[]>();

	public TurnInfoBreeders(SingleModeCheckEventResponse.CommonResponse resp)
		: base(resp)
	{
		SingleModeBreedersDataSet breeders_data_set = resp.breeders_data_set;
		foreach (SingleModeBreedersCommandInfo item2 in breeders_data_set.command_info_array.Where((SingleModeBreedersCommandInfo x) => x.command_type == 1))
		{
			CommandInfo item = new CommandInfo(resp, this, item2.command_id, ToTrainIndex, ToTrainId);
			CommandInfoArray.Add(item);
		}
		SpecialTrainingStock = breeders_data_set.team_sp_training_info.stock_num;
		SpecialTrainingMax = breeders_data_set.team_sp_training_info.stock_max;
		SpecialTrainingActivated = breeders_data_set.team_sp_training_info.activated_state == 1;
		TeamMemberInfoDictionary = breeders_data_set.team_member_info_array.ToDictionary((SingleModeBreedersTeamMemberInfo x) => x.chara_id, (SingleModeBreedersTeamMemberInfo x) => x);
		CommandTeamMemberInfoDictionary = breeders_data_set.command_info_array.ToDictionary((SingleModeBreedersCommandInfo x) => x.command_id, (SingleModeBreedersCommandInfo x) => x.team_member_info_array);
	}
}
