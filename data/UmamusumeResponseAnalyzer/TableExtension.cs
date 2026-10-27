using System.Collections.Generic;
using System.Linq;
using Spectre.Console;

namespace UmamusumeResponseAnalyzer;

public static class TableExtension
{
	private static readonly Dictionary<Table, Dictionary<(int, int), string>> saved = new Dictionary<Table, Dictionary<(int, int), string>>();

	private static void Prepare(this Table table)
	{
		if (!saved.ContainsKey(table))
		{
			saved.Add(table, new Dictionary<(int, int), string>());
		}
	}

	public static bool Edit(this Table? table, int column, int row, string content)
	{
		if (table == null)
		{
			return false;
		}
		table.Prepare();
		if (saved[table].ContainsKey((column, row)))
		{
			saved[table][(column, row)] = content;
		}
		else
		{
			saved[table].Add((column, row), content);
		}
		return true;
	}

	public static bool AddToRows(this Table? table, int rowIndex, params string[] contents)
	{
		if (table == null)
		{
			return false;
		}
		table.Prepare();
		for (int i = 0; i < contents.Length; i++)
		{
			saved[table].Add((i, rowIndex), contents[i]);
		}
		return true;
	}

	public static bool Finish(this Table? table)
	{
		if (table == null)
		{
			return false;
		}
		foreach (IGrouping<int, KeyValuePair<(int, int), string>> item in from x in saved[table]
			group x by x.Key.Item2)
		{
			table.AddRow(item.Select((KeyValuePair<(int, int), string> x) => x.Value).ToArray());
		}
		saved.Clear();
		return true;
	}
}
