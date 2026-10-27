using System;
using System.Collections.Generic;
using System.Linq;
using Gallop;
using Gallop.Mecha;

namespace UmamusumeResponseAnalyzer.Game.TurnInfo;

public class MechaCommandInfo : CommandInfo
{
	public IEnumerable<(int StatusType, int Value)> PointUpInfoArray { get; set; } = Array.Empty<(int, int)>();

	public bool IsRecommend { get; set; }

	public int EnergyNum { get; set; }

	public MechaCommandInfo(SingleModeCheckEventResponse.CommonResponse resp, TurnInfo turn, int commandId)
		: base(resp, turn, commandId)
	{
		SingleModeMechaCommandInfo singleModeMechaCommandInfo = resp.mecha_data_set.command_info_array.First((SingleModeMechaCommandInfo x) => x.command_id == commandId);
		PointUpInfoArray = singleModeMechaCommandInfo.point_up_info_array.Select((SingleModeMechaPointUpInfo x) => (status_type: x.status_type, value: x.value));
		IsRecommend = singleModeMechaCommandInfo.is_recommend;
		EnergyNum = singleModeMechaCommandInfo.energy_num;
	}
}
