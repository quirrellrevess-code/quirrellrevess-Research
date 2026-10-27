using System;
using System.Collections.Generic;
using System.Linq;
using Gallop;

namespace UmamusumeResponseAnalyzer.Game.TurnInfo;

public class TurnInfoCook : TurnInfo
{
	public SingleModeCookMaterialHarvestInfo[] Harvests { get; set; } = Array.Empty<SingleModeCookMaterialHarvestInfo>();

	public SingleModeCookCareHistoryInfo[] Cares { get; set; } = Array.Empty<SingleModeCookCareHistoryInfo>();

	public SingleModeCookMaterialInfo[] Materials { get; set; } = Array.Empty<SingleModeCookMaterialInfo>();

	public SingleModeCookFacilityInfo[] Facilities { get; set; } = Array.Empty<SingleModeCookFacilityInfo>();

	public SingleModeCookCommandMaterialCareInfo[] CommandMaterials { get; set; } = Array.Empty<SingleModeCookCommandMaterialCareInfo>();

	public IEnumerable<CommandInfo> CommandInfoArray { get; set; } = Array.Empty<CommandInfo>();

	public TurnInfoCook(SingleModeCheckEventResponse.CommonResponse resp)
		: base(resp)
	{
		TurnInfoCook turn = this;
		SingleModeCookDataSet cook_data_set = resp.cook_data_set;
		Harvests = cook_data_set.material_harvest_info_array;
		Cares = cook_data_set.care_history_info_array;
		Materials = cook_data_set.material_info_array;
		Facilities = cook_data_set.facility_info_array;
		CommandMaterials = cook_data_set.command_material_care_info_array;
		CommandInfoArray = cook_data_set.command_info_array.Select((SingleModeCookCommandInfo x) => new CommandInfo(resp, turn, x.command_id));
		CommandInfoArray = CommandInfoArray.Where((CommandInfo x) => x.TrainIndex != 0);
	}
}
