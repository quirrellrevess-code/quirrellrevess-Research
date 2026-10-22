using System.Collections.Generic;

namespace UmamusumeResponseAnalyzer;

public class NullableIntStringDictionary : Dictionary<int, string>
{
	public new string this[int key]
	{
		get
		{
			if (!TryGetValue(key, out string value))
			{
				return "未知";
			}
			return value;
		}
		set
		{
			base[key] = value;
		}
	}
}
