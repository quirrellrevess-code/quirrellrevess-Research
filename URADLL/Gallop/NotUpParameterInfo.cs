using MessagePack;

namespace Gallop;

[MessagePackObject(false)]
public class NotUpParameterInfo
{
	[Key("status_type_array")]
	public int[] status_type_array;

	[Key("chara_effect_id_array")]
	public int[] chara_effect_id_array;

	[Key("skill_id_array")]
	public int[] skill_id_array;

	[Key("skill_tips_array")]
	public SkillTips[] skill_tips_array;

	[Key("skill_lv_id_array")]
	public int[] skill_lv_id_array;

	[Key("evaluation_chara_id_array")]
	public int[] evaluation_chara_id_array;

	[Key("command_lv_array")]
	public int[] command_lv_array;

	[Key("has_chara_effect_id_array")]
	public int[] has_chara_effect_id_array;

	[Key("unsupported_evaluation_chara_id_array")]
	public int[] unsupported_evaluation_chara_id_array;

	[Key("not_gain_chara_effect_array")]
	public NotGainCharaEffect[] not_gain_chara_effect_array;
}
