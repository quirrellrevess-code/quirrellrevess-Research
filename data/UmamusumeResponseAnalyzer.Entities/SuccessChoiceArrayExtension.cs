using System;
using System.Collections.Generic;
using System.Linq;

namespace UmamusumeResponseAnalyzer.Entities;

public static class SuccessChoiceArrayExtension
{
	public static IEnumerable<SuccessChoice> WithSelectIndex(this IEnumerable<SuccessChoice> arr, int selectIndex)
	{
		if (!arr.Any())
		{
			return Array.Empty<SuccessChoice>();
		}
		return arr.Where((SuccessChoice x) => x.SelectIndex == selectIndex);
	}

	public static IEnumerable<SuccessChoice> WithScenarioId(this IEnumerable<SuccessChoice> arr, int scenarioId)
	{
		if (!arr.Any())
		{
			return Array.Empty<SuccessChoice>();
		}
		IEnumerable<SuccessChoice> enumerable = arr.Where((SuccessChoice x) => x.Scenario == scenarioId);
		if (!enumerable.Any())
		{
			return arr.Where((SuccessChoice x) => x.Scenario == 0);
		}
		return enumerable;
	}

	public static bool TryGet(this IEnumerable<SuccessChoice> arr, out SuccessChoice choice)
	{
		choice = null;
		if (!arr.Any())
		{
			return false;
		}
		if (arr.Count() > 1)
		{
			throw new Exception($"SuccessChoice最终应该只有1个，但是实际有{arr.Count()}个");
		}
		choice = arr.First();
		return true;
	}
}
