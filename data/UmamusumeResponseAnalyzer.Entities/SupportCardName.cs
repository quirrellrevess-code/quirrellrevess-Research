namespace UmamusumeResponseAnalyzer.Entities;

public class SupportCardName(int id, string name, int type, int charaId) : BaseName(id, name)
{
	public int CharaId { get; set; } = charaId;

	public int Type { get; set; } = type;

	public string CharacterName => Database.Names[CharaId];

	public string TypeName => Type switch
	{
		101 => "[速]", 
		102 => "[力]", 
		103 => "[根]", 
		105 => "[耐]", 
		106 => "[智]", 
		0 => "[友]", 
		_ => "", 
	};

	public string FullName => Name + CharacterName;

	public string SimpleName => TypeName + CharacterName;
}
