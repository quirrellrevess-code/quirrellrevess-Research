using System;
using System.Collections.Generic;
using System.Linq;
using Gallop;

namespace UmamusumeResponseAnalyzer.Game.TurnInfo;

public class TurnInfoLegend : TurnInfo
{
	public Dictionary<int, (int Legend, int Gauge)> CommandGauges { get; set; } = new Dictionary<int, (int, int)>();

	public IEnumerable<CommandInfo> CommandInfoArray { get; set; } = Array.Empty<CommandInfo>();

	public Dictionary<int, int> GaugeCountDictonary { get; set; } = new Dictionary<int, int>();

	public TurnInfoLegend(SingleModeCheckEventResponse.CommonResponse resp)
		: base(resp)
	{
		TurnInfoLegend turn = this;
		SingleModeLegendDataSet legend_data_set = resp.legend_data_set;
		SingleModeLegendCommandInfo[] command_info_array = legend_data_set.command_info_array;
		foreach (SingleModeLegendCommandInfo singleModeLegendCommandInfo in command_info_array)
		{
			CommandGauges.TryAdd(singleModeLegendCommandInfo.command_id, (singleModeLegendCommandInfo.legend_id, singleModeLegendCommandInfo.gain_gauge));
		}
		GaugeCountDictonary = legend_data_set.gauge_count_array.ToDictionary((SingleModeLegendGauge x) => x.legend_id, (SingleModeLegendGauge x) => x.count);
		CommandInfoArray = from x in legend_data_set.command_info_array.Where((SingleModeLegendCommandInfo x) =>
			{
				int command_id = x.command_id;
				return command_id != 0 && command_id != 701 && command_id != 401 && command_id != 801;
			})
			select new CommandInfo(resp, turn, x.command_id);
	}
}
