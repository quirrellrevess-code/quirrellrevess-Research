using System.Collections.Frozen;
using System.Collections.Generic;
using System.Linq;
using Gallop;
using UmamusumeResponseAnalyzer.Entities;
using UmamusumeResponseAnalyzer.Game.TurnInfo;

namespace UmamusumeResponseAnalyzer.Game;

public class CommandInfo
{
	private static readonly FrozenDictionary<int, int> ToTrainIndex = new Dictionary<int, int>
	{
		{ 1101, 0 },
		{ 1102, 1 },
		{ 1103, 2 },
		{ 1104, 3 },
		{ 1105, 4 },
		{ 601, 0 },
		{ 602, 1 },
		{ 603, 2 },
		{ 604, 3 },
		{ 605, 4 },
		{ 101, 0 },
		{ 105, 1 },
		{ 102, 2 },
		{ 103, 3 },
		{ 106, 4 },
		{ 2101, 0 },
		{ 2201, 0 },
		{ 2301, 0 },
		{ 2102, 1 },
		{ 2202, 1 },
		{ 2302, 1 },
		{ 2103, 2 },
		{ 2203, 2 },
		{ 2303, 2 },
		{ 2104, 3 },
		{ 2204, 3 },
		{ 2304, 3 },
		{ 2105, 4 },
		{ 2205, 4 },
		{ 2305, 4 },
		{ 901, 0 },
		{ 902, 2 },
		{ 906, 4 }
	}.ToFrozenDictionary();

	public int CommandId { get; }

	public int TrainIndex { get; set; }

	public int TrainLevel { get; }

	public IEnumerable<TrainingPartner> TrainingPartners { get; }

	public CommandInfo(SingleModeCheckEventResponse.CommonResponse resp, global::UmamusumeResponseAnalyzer.Game.TurnInfo.TurnInfo turn, int commandId, IDictionary<int, int> trainIndexDictionary = null, IDictionary<int, int> toTrainIdDictionary = null)
	{
		CommandInfo commandInfo = this;
		CommandId = commandId;
		if ((trainIndexDictionary ?? ToTrainIndex).TryGetValue(commandId, out var value))
		{
			TrainIndex = value + 1;
		}
		TrainLevel = resp.chara_info.training_level_info_array.FirstOrDefault((TrainingLevelInfo x) => x.command_id == commandInfo.CommandId)?.level ?? 0;
		SingleModeCommandInfo normalCommand = resp.home_info.command_info_array.First((SingleModeCommandInfo x) => x.command_id == commandInfo.CommandId);
		TrainingPartners = from x in normalCommand.training_partner_array
			select new TrainingPartner(turn, x, normalCommand, toTrainIdDictionary) into x
			orderby x.Priority
			select x;
	}
}
