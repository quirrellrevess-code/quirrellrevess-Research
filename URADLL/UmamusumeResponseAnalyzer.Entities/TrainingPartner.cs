using System.Collections.Frozen;
using System.Collections.Generic;
using System.Linq;
using Gallop;
using Spectre.Console;
using UmamusumeResponseAnalyzer.Game.TurnInfo;

namespace UmamusumeResponseAnalyzer.Entities;

public class TrainingPartner
{
	private static readonly FrozenDictionary<int, int> ToTrainId = new Dictionary<int, int>
	{
		[1101] = 101,
		[1102] = 105,
		[1103] = 102,
		[1104] = 103,
		[1105] = 106,
		[601] = 101,
		[602] = 105,
		[603] = 102,
		[604] = 103,
		[605] = 106,
		[101] = 101,
		[105] = 105,
		[102] = 102,
		[103] = 103,
		[106] = 106,
		[2101] = 101,
		[2201] = 101,
		[2301] = 101,
		[2102] = 105,
		[2202] = 105,
		[2302] = 105,
		[2103] = 102,
		[2203] = 102,
		[2303] = 102,
		[2104] = 103,
		[2204] = 103,
		[2304] = 103,
		[2105] = 106,
		[2205] = 106,
		[2305] = 106,
		[901] = 101,
		[902] = 102,
		[906] = 106
	}.ToFrozenDictionary();

	public PartnerPriority Priority { get; private set; } = PartnerPriority.默认;

	public int Position { get; }

	public int CardId { get; }

	public string Name { get; }

	public int Friendship { get; }

	public bool IsArcPartner { get; }

	public bool IsNpc
	{
		get
		{
			int position = Position;
			return position < 1 || position > 6;
		}
	}

	public string NameColor { get; } = "[#ffffff]";

	public string NameAppend { get; } = string.Empty;

	public bool Shining { get; }

	public TrainingPartner(TurnInfo turn, int partner, SingleModeCommandInfo command, IDictionary<int, int> toTrainIdDictionary = null)
	{
		Position = partner;
		Friendship = turn.Evaluations[Position].evaluation;
		IsArcPartner = turn.IsScenario<TurnInfoArc>(ScenarioType.LArc, out TurnInfoArc turnInfo) && (partner > 1000 || (partner >= 1 && partner <= 7)) && turnInfo.EvaluationInfoArray.Any((ArcEvaluationInfo x) => x.target_id == partner);
		int num;
		if (!IsNpc)
		{
			CardId = turn.SupportCards[Position];
			Name = Database.Names.GetSupportCard(CardId).Nickname.EscapeMarkup();
			if (Name.Contains("[友]"))
			{
				Priority = PartnerPriority.友人;
				NameColor = "[green]";
			}
			else if (Friendship < 80)
			{
				Priority = PartnerPriority.羁绊不足;
				NameColor = "[yellow]";
			}
			bool flag = Friendship >= 80;
			if (flag)
			{
				string name = Name;
				num = (toTrainIdDictionary ?? ToTrainId)[command.command_id];
				flag = name.Contains(num switch
				{
					101 => "[速]", 
					105 => "[耐]", 
					102 => "[力]", 
					103 => "[根]", 
					106 => "[智]", 
				});
			}
			Shining = flag;
			if (turn.IsScenario(ScenarioType.GrandMasters) && turn.GetCommonResponse().venus_data_set.venus_spirit_active_effect_info_array.Any((SingleModeVenusActiveSpiritEffect x) => x.chara_id == 9042 && x.effect_group_id == 421) && (Name.Contains("[速]") || Name.Contains("[耐]") || Name.Contains("[力]") || Name.Contains("[根]") || Name.Contains("[智]")))
			{
				Shining = true;
			}
			if ((CardId == 30137 && turn.GetCommonResponse().chara_info.chara_effect_id_array.Any((int x) => x == 102)) || (CardId == 30067 && turn.GetCommonResponse().chara_info.chara_effect_id_array.Any((int x) => x == 101)) || (CardId == 30081 && turn.GetCommonResponse().chara_info.chara_effect_id_array.Any((int x) => x == 100)))
			{
				Shining = true;
				NameColor = "[#80ff00]";
			}
			if (Shining)
			{
				if (Name.Contains("[友]"))
				{
					Priority = PartnerPriority.友人;
					NameColor = "[#80ff00]";
				}
				else
				{
					Priority = PartnerPriority.闪;
					NameColor = "[aqua]";
				}
			}
		}
		else
		{
			Name = Database.Names.GetCharacter(Position).Nickname.EscapeMarkup();
			num = Position;
			if (num >= 100 && num < 1000)
			{
				Priority = PartnerPriority.关键NPC;
				NameColor = "[#008080]";
			}
			else if (IsArcPartner)
			{
				Priority = PartnerPriority.无用NPC;
				NameColor = "[#a166ff]";
			}
		}
		num = Position;
		if (num < 1 || num > 7)
		{
			num = Position;
			if (num < 100 || num >= 1000)
			{
				goto IL_046c;
			}
		}
		if (Friendship < 100)
		{
			NameAppend += $"[red]{Friendship}[/]";
		}
		goto IL_046c;
		IL_046c:
		Name = NameColor + Name + "[/]" + NameAppend;
		if (command.tips_event_partner_array.Intersect(command.training_partner_array).Contains(Position))
		{
			Name = "[red]![/]" + Name;
		}
	}
}
