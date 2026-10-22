using System.Collections.Generic;
using MessagePack;
using UmamusumeResponseAnalyzer.Localization;

namespace Gallop;

[MessagePackObject(false)]
public class SingleModeSuccessionGainInfo
{
	[Key("lottery_id")]
	public int lottery_id;

	[Key("speed")]
	public int speed;

	[Key("stamina")]
	public int stamina;

	[Key("power")]
	public int power;

	[Key("wiz")]
	public int wiz;

	[Key("guts")]
	public int guts;

	[Key("max_speed")]
	public int max_speed;

	[Key("max_stamina")]
	public int max_stamina;

	[Key("max_power")]
	public int max_power;

	[Key("max_wiz")]
	public int max_wiz;

	[Key("max_guts")]
	public int max_guts;

	[Key("proper_distance_short")]
	public int proper_distance_short;

	[Key("proper_distance_mile")]
	public int proper_distance_mile;

	[Key("proper_distance_middle")]
	public int proper_distance_middle;

	[Key("proper_distance_long")]
	public int proper_distance_long;

	[Key("proper_running_style_nige")]
	public int proper_running_style_nige;

	[Key("proper_running_style_senko")]
	public int proper_running_style_senko;

	[Key("proper_running_style_sashi")]
	public int proper_running_style_sashi;

	[Key("proper_running_style_oikomi")]
	public int proper_running_style_oikomi;

	[Key("proper_ground_turf")]
	public int proper_ground_turf;

	[Key("proper_ground_dirt")]
	public int proper_ground_dirt;

	[Key("skill_point")]
	public int skill_point;

	[Key("skill_tips_array")]
	public SkillTips[] skill_tips_array;

	[Key("effected_factor_array")]
	public SuccessionEffectedFactor[] effected_factor_array;

	[IgnoreMember]
	public int[] FiveStatus => new int[5] { speed, stamina, power, guts, wiz };

	[IgnoreMember]
	public Dictionary<string, int> Proper => new Dictionary<string, int>
	{
		{
			Game.I18N_Short,
			proper_distance_short
		},
		{
			Game.I18N_Mile,
			proper_distance_mile
		},
		{
			Game.I18N_Middle,
			proper_distance_middle
		},
		{
			Game.I18N_Long,
			proper_distance_long
		},
		{
			Game.I18N_Nige,
			proper_running_style_nige
		},
		{
			Game.I18N_Oikomi,
			proper_running_style_oikomi
		},
		{
			Game.I18N_Sashi,
			proper_running_style_sashi
		},
		{
			Game.I18N_Senko,
			proper_running_style_senko
		},
		{
			Game.I18N_Grass,
			proper_ground_turf
		},
		{
			Game.I18N_Dirt,
			proper_ground_dirt
		}
	};
}
