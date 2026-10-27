using System;
using System.Collections.Generic;
using System.Linq;
using Gallop;
using Gallop.Mecha;

namespace UmamusumeResponseAnalyzer.Game.TurnInfo;

public class TurnInfoMecha : TurnInfo
{
	public IEnumerable<MechaCommandInfo> CommandInfoArray { get; set; } = Array.Empty<MechaCommandInfo>();

	public TurnInfoMecha(SingleModeCheckEventResponse.CommonResponse resp)
		: base(resp)
	{
		TurnInfoMecha turn = this;
		SingleModeMechaDataSet mecha_data_set = resp.mecha_data_set;
		CommandInfoArray = mecha_data_set.command_info_array.Select((SingleModeMechaCommandInfo x) => new MechaCommandInfo(resp, turn, x.command_id)).ToList();
		CommandInfoArray = CommandInfoArray.Where((MechaCommandInfo x) => x.TrainIndex != 0).ToList();
	}
}
