using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.InteropServices;
using System.Threading;
using Microsoft.Win32;
using Spectre.Console;

namespace UmamusumeResponseAnalyzer;

public static class UraCoreHelper
{
	private const string GameExeName = "umamusume.exe";

	private static readonly Lazy<List<string>> _lazyGamePaths = new Lazy<List<string>>(LoadGamePaths, LazyThreadSafetyMode.ExecutionAndPublication);

	private static List<string> _overrideGamePaths = new List<string>();

	public static List<string> GamePaths
	{
		get
		{
			if (_overrideGamePaths.Count == 0)
			{
				return _lazyGamePaths.Value;
			}
			return _overrideGamePaths;
		}
		set
		{
			_overrideGamePaths = value;
		}
	}

	private static List<string> LoadGamePaths()
	{
		if (!RuntimeInformation.IsOSPlatform(OSPlatform.Windows))
		{
			return new List<string>();
		}
		HashSet<string> hashSet = new HashSet<string>(StringComparer.OrdinalIgnoreCase);
		TryExtractFromValueNames("Software\\Classes\\Local Settings\\Software\\Microsoft\\Windows\\Shell\\MuiCache", Registry.CurrentUser, hashSet);
		TryExtractFromValueNames("Software\\Microsoft\\Windows\\CurrentVersion\\Explorer\\FeatureUsage\\AppSwitched", Registry.CurrentUser, hashSet);
		TryExtractFromValueNames("Software\\Microsoft\\Windows NT\\CurrentVersion\\AppCompatFlags\\Compatibility Assistant\\Store", Registry.CurrentUser, hashSet);
		TryExtractFromGameConfigStore(hashSet);
		return hashSet.ToList();
	}

	private static void TryExtractFromValueNames(string subKeyPath, RegistryKey hive, HashSet<string> results)
	{
		try
		{
			using RegistryKey registryKey = OpenSubKey(hive, subKeyPath);
			if (registryKey == null)
			{
				return;
			}
			string[] valueNames = registryKey.GetValueNames();
			foreach (string text in valueNames)
			{
				int num = text.IndexOf("umamusume.exe", StringComparison.OrdinalIgnoreCase);
				if (num >= 0)
				{
					results.Add(text.Substring(0, num));
				}
			}
		}
		catch
		{
		}
	}

	private static void TryExtractFromGameConfigStore(HashSet<string> results)
	{
		try
		{
			using RegistryKey registryKey = OpenSubKey(Registry.CurrentUser, "System\\GameConfigStore\\Children");
			if (registryKey == null)
			{
				return;
			}
			string[] subKeyNames = registryKey.GetSubKeyNames();
			foreach (string name in subKeyNames)
			{
				try
				{
					using RegistryKey registryKey2 = registryKey.OpenSubKey(name);
					if (registryKey2?.GetValue("MatchedExeFullPath") is string text)
					{
						int num = text.IndexOf("umamusume.exe", StringComparison.OrdinalIgnoreCase);
						if (num >= 0)
						{
							results.Add(text.Substring(0, num));
						}
					}
				}
				catch
				{
				}
			}
		}
		catch
		{
		}
	}

	private static RegistryKey? OpenSubKey(RegistryKey hive, string relativePath)
	{
		RegistryKey registryKey = hive;
		string[] array = relativePath.Split('\\');
		foreach (string name in array)
		{
			RegistryKey? registryKey2 = registryKey?.OpenSubKey(name);
			if (registryKey != hive)
			{
				registryKey?.Dispose();
			}
			registryKey = registryKey2;
			if (registryKey == null)
			{
				return null;
			}
		}
		return registryKey;
	}

	public static void EnableDllRedirection()
	{
		using RegistryKey registryKey = Registry.LocalMachine.CreateSubKey("SOFTWARE\\Microsoft\\Windows NT\\CurrentVersion\\Image File Execution Options", writable: true);
		if (registryKey == null)
		{
			AnsiConsole.WriteLine("打开注册表失败，请手动操作：https://learn.microsoft.com/en-us/windows/win32/dlls/dynamic-link-library-redirection#optional-configure-the-registry");
			Thread.Sleep(int.MaxValue);
		}
		else if (registryKey.GetValue("DevOverrideEnable") is int num && num == 1)
		{
			AnsiConsole.WriteLine("注册表已启用DLL重定向，将在三秒后自动关闭。没有做任何改动。");
		}
		else if (AnsiConsole.Prompt(new ConfirmationPrompt("该行为具有一定风险，将注册表HKLM\\\\SOFTWARE\\\\Microsoft\\\\Windows NT\\\\CurrentVersion\\\\Image File Execution Options\\\\DevOverrideEnable的值改为1。\n请仔细阅读https://learn.microsoft.com/en-us/windows/win32/dlls/dynamic-link-library-redirection 了解其风险后再做决定，我们不对此负责。")))
		{
			registryKey.SetValue("DevOverrideEnable", 1, RegistryValueKind.DWord);
			if (registryKey.GetValue("DevOverrideEnable") is int num2 && num2 == 1)
			{
				AnsiConsole.WriteLine("已启用DLL重定向，请手动重启Windows使其生效。");
				return;
			}
			AnsiConsole.WriteLine("注册表启用DLL重定向失败，请手动检查。");
			Environment.ExitCode = 1;
		}
	}
}
