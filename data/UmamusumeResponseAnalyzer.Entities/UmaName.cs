namespace UmamusumeResponseAnalyzer.Entities;

public class UmaName(int id, string name, int charaId = 0) : BaseName(id, name)
{
	public int CharaId { get; set; } = (charaId == 0) ? int.Parse((id.ToString()[0] == '9') ? id.ToString().Substring(1, 4) : id.ToString().Substring(0, 4)) : charaId;

	public string CharacterName => Database.Names[CharaId];

	public string FullName => Name + CharacterName;
}
