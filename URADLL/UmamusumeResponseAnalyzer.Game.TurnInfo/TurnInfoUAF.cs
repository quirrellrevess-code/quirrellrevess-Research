using System;
using System.Collections.Generic;
using System.Linq;
using Gallop;
using UmamusumeResponseAnalyzer.Entities;

namespace UmamusumeResponseAnalyzer.Game.TurnInfo;

public class TurnInfoUAF : TurnInfo
{
	public class ParsedSingleModeSportCommandInfo : CommandInfo
	{
		private int ActualGainRankWithoutBuff { get; }

		public SportColor Color { get; }

		public int SportRank { get; }

		public int GainRank { get; }

		public int ActualGainRank
		{
			get
			{
				if (IsRankGainIncreased)
				{
					return ActualGainRankWithoutBuff + 3;
				}
				return ActualGainRankWithoutBuff;
			}
		}

		public int TotalGainRank { get; }

		public bool IsCurrentRankGainIncreased { get; }

		public bool IsRankGainIncreased { get; }

		public ParsedSingleModeSportCommandInfo(SingleModeCheckEventResponse.CommonResponse resp, TurnInfoUAF turn, int commandId)
			: base(resp, turn, commandId)
		{
			TrainIndex = int.Parse(CommandId.ToString()[3].ToString());
			Color = (SportColor)int.Parse(CommandId.ToString()[1].ToString());
			SportRank = resp.sport_data_set.training_array.First((SingleModeSportTraining x) => x.command_id == CommandId).sport_rank;
			SingleModeSportCommandInfo.SingleModeSportGainRank[] gain_sport_rank_array = resp.sport_data_set.command_info_array[TrainIndex - 1].gain_sport_rank_array;
			GainRank = gain_sport_rank_array.First((SingleModeSportCommandInfo.SingleModeSportGainRank x) => x.command_id == CommandId).gain_rank;
			TotalGainRank = resp.sport_data_set.command_info_array[TrainIndex - 1].gain_sport_rank_array.Sum((SingleModeSportCommandInfo.SingleModeSportGainRank x) => x.gain_rank);
			IsRankGainIncreased = turn.IsRankGainIncreased;
			IEnumerable<TrainingPartner> source = TrainingPartners.Where((TrainingPartner x) => !x.IsNpc);
			int num = ((!TrainingPartners.Any((TrainingPartner x) => x.Shining)) ? 1 : 2);
			int num2 = source.Count();
			int num3 = num2 switch
			{
				0 => 0, 
				1 => 1, 
				2 => 2, 
				3 => 2, 
				4 => 3, 
				5 => 3, 
			};
			IEnumerable<int> source2 = TrainingPartners.Select((TrainingPartner x) => Database.Names.GetSupportCard(x.CardId).CharaId).Intersect(LinkCharacterIds);
			ActualGainRankWithoutBuff = num * (3 + num3) + source2.Count();
			IsCurrentRankGainIncreased = GainRank - ActualGainRankWithoutBuff == 3;
		}
	}

	public class TrainingSport
	{
		public int CommandType { get; }

		public int CommandId { get; }

		public int SportRank { get; }

		public SportColor Color { get; }

		public string ColoredText { get; }

		public int TrainIndex { get; }

		public TrainingSport(SingleModeSportTraining train)
		{
			CommandType = train.command_type;
			CommandId = train.command_id;
			SportRank = train.sport_rank;
			Color = (SportColor)int.Parse(CommandId.ToString()[1].ToString());
			ColoredText = Color switch
			{
				SportColor.Blue => "[blue]蓝[/]", 
				SportColor.Red => "[red]红[/]", 
				SportColor.Yellow => "[yellow]黄[/]", 
				_ => throw new NotImplementedException(), 
			};
			TrainIndex = int.Parse(CommandId.ToString()[3].ToString());
		}
	}

	public enum SportColor
	{
		Blue = 1,
		Red,
		Yellow
	}

	public static readonly IReadOnlyList<int> LinkCharacterIds = Array.AsReadOnly(new int[6] { 1035, 1027, 1048, 1072, 1077, 9044 });

	public IEnumerable<TrainingSport> TrainingArray { get; }

	public IEnumerable<ParsedSingleModeSportCommandInfo> CommandInfoArray { get; }

	public int AvailableTalkCount { get; }

	public Dictionary<SportColor, List<TrainingSport>> SportsByColor { get; }

	public int BlueLevel { get; }

	public int RedLevel { get; }

	public int YellowLevel { get; }

	public bool IsRankGainIncreased { get; }

	public TurnInfoUAF(SingleModeCheckEventResponse.CommonResponse resp)
		: base(resp)
	{
		TurnInfoUAF turn = this;
		SingleModeSportDataSet sport_data_set = resp.sport_data_set;
		TrainingArray = sport_data_set.training_array.Select((SingleModeSportTraining x) => new TrainingSport(x));
		CommandInfoArray = from x in sport_data_set.command_info_array
			where x.command_id > 1000
			select new ParsedSingleModeSportCommandInfo(resp, turn, x.command_id);
		AvailableTalkCount = sport_data_set.item_id_array.Count((int x) => x == 6);
		SportsByColor = (from x in TrainingArray
			group x by x.Color).ToDictionary((IGrouping<SportColor, TrainingSport> x) => x.Key, (IGrouping<SportColor, TrainingSport> x) => x.ToList());
		BlueLevel = SportsByColor[SportColor.Blue].Sum((TrainingSport x) => x.SportRank);
		RedLevel = SportsByColor[SportColor.Red].Sum((TrainingSport x) => x.SportRank);
		YellowLevel = SportsByColor[SportColor.Yellow].Sum((TrainingSport x) => x.SportRank);
		IsRankGainIncreased = CommandInfoArray.Any((ParsedSingleModeSportCommandInfo x) => x.IsCurrentRankGainIncreased);
	}
}
