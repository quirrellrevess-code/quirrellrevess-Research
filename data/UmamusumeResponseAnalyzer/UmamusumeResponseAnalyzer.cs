using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Globalization;
using System.IO;
using System.IO.Compression;
using System.Linq;
using System.Reflection;
using System.Runtime.InteropServices;
using System.Text;
using System.Threading;
using System.Threading.Tasks;
using Newtonsoft.Json;
using Spectre.Console;
using UmamusumeResponseAnalyzer.Localization;
using UmamusumeResponseAnalyzer.Plugin;

namespace UmamusumeResponseAnalyzer;

public static class UmamusumeResponseAnalyzer
{
	internal static Task _database_initialize_task = null;

	internal static Task _plugin_initialize_task = null;

	private const string PORTABLE_WORKING_DIRECTORY = "./.portable";

	public static readonly string WORKING_DIRECTORY = (Directory.Exists("./.portable") ? "./.portable" : Path.Combine(Environment.GetFolderPath(Environment.SpecialFolder.LocalApplicationData), "UmamusumeResponseAnalyzer"));

	public static bool Started => Server.IsRunning;

	public static async Task Main(string[] args)
	{
		ConsoleHelper.HandlerRoutine handlerRoutine = ConsoleHelper.ConsoleCtrlCheck;
		GC.KeepAlive(handlerRoutine);
		ConsoleHelper.SetConsoleCtrlHandler(handlerRoutine, Add: true);
		ConsoleHelper.DisableQuickEditMode();
		Console.Title = $"UmamusumeResponseAnalyzer v{Assembly.GetExecutingAssembly().GetName().Version}";
		Console.OutputEncoding = Encoding.UTF8;
		Environment.SetEnvironmentVariable("DOTNET_SYSTEM_NET_DISABLEIPV6", "true");
		if (!Directory.Exists(WORKING_DIRECTORY))
		{
			Directory.CreateDirectory(WORKING_DIRECTORY);
		}
		Directory.SetCurrentDirectory(WORKING_DIRECTORY);
		await ParseArguments(args);
		Config.Initialize();
		if (Config.Core.ShowFirstRunPrompt)
		{
			ShowFirstLaunchPrompt();
			Config.Core.ShowFirstRunPrompt = false;
			Config.Save();
		}
		_plugin_initialize_task = Task.Run((Action)PluginManager.Init);
		_ = string.Empty;
		while (await ShowMenu() != LaunchMenu.I18N_Start)
		{
		}
		_database_initialize_task = Database.Initialize();
		_003C_003Ey__InlineArray2<Task> buffer = default;
		buffer[0] = _database_initialize_task;
		buffer[1] = _plugin_initialize_task;
		Task.WaitAll(buffer);
		Server.Start();
		Task.WaitAll(new ReadOnlySpan<Task>(PluginManager.LoadedPlugins.Select((IPlugin x) => Task.Run((Action)x.Initialize)).ToArray()));
		for (int i = 0; i < 30; i++)
		{
			if (Server.IsRunning)
			{
				break;
			}
			await Task.Delay(100);
		}
		if (!Server.IsRunning)
		{
			AnsiConsole.WriteLine(LaunchMenu.I18N_LaunchFail);
			Console.ReadLine();
			Environment.Exit(1);
		}
		AnsiConsole.MarkupLine(LaunchMenu.I18N_Start_Started);
		AutoResetEvent _closingEvent = new AutoResetEvent(initialState: false);
		Console.CancelKeyPress += (object? _, ConsoleCancelEventArgs _) =>
		{
			Server.Stop();
			foreach (IPlugin loadedPlugin in PluginManager.LoadedPlugins)
			{
				loadedPlugin.Dispose();
			}
			ResourceUpdater.HttpClient.Dispose();
			_closingEvent.Set();
		};
		_closingEvent.WaitOne();
	}

	private static void ShowFirstLaunchPrompt()
	{
		AnsiConsole.WriteLine("检测到是第一次运行，将进行一些初始设置。使用方向键↑与↓切换选项，使用回车[Enter]确认。");
		AnsiConsole.WriteLine("推荐使用Windows终端(Windows Terminal)，并将启动大小设置为120列35行以获得更好的体验。");
		AnsiConsole.WriteLine();
		if (AnsiConsole.Prompt(new SelectionPrompt<string>().Title("请选择运行UM:PD的设备").AddChoices("手机/模拟器以及此计算机", "此计算机")) == "手机/模拟器以及此计算机")
		{
			Config.Core.ListenAddress = "0.0.0.0";
			AnsiConsole.WriteLine("已配置URA为接受来自其他设备的请求。在初次启动时可能会提示防火墙放行，请务必同意，否则可能无法正常连接。如果因某种原因没有同意，请自行搜索如何在Windows中放行应用程序");
		}
		else
		{
			AnsiConsole.WriteLine("已配置URA为仅接受来自此计算机的请求。如需要使模拟器连入，需从选项->核心中将监听地址更改为0.0.0.0并在启动时放行防火墙。");
		}
		AnsiConsole.WriteLine();
		foreach (string item in AnsiConsole.Prompt(new MultiSelectionPrompt<string>().Title("请选择你所使用的UM:PD版本，只选择繁中服的话就不会显示未来才能使用的插件防止报错。").AddChoices("日服(Cygames)", "繁中服(Komoe)")))
		{
			if (!(item == "日服(Cygames)"))
			{
				if (item == "繁中服(Komoe)")
				{
					Config.Repository.Targets.Add("Komoe");
				}
			}
			else
			{
				Config.Repository.Targets.Add("Cygames");
			}
		}
		string text = AnsiConsole.Prompt(new SelectionPrompt<string>().Title("请选择事件数据语言，选择繁中等将会使用对应客户端已实装的内容翻译。不会影响实际效果及数据库总大小。").AddChoices("日文", "繁中"));
		Config.Updater.DatabaseLanguage = ((text == "繁中") ? "zh-TW" : "ja-JP");
		string text2 = AnsiConsole.Prompt(new SelectionPrompt<string>().Title("请选择训练员性别，用于精确显示事件选项。").AddChoices("男", "女"));
		Config.Updater.TrainerIsMale = text2 == "男";
		AnsiConsole.MarkupLine("在正式开始使用之前，请先[green]更新数据文件[/]并根据需求[green]前往[[插件仓库]]安装自己需要的插件[/]。");
		AnsiConsole.MarkupLine("否则URA将[red]没有任何功能[/]。");
	}

	private static async Task<string> ShowMenu()
	{
		SelectionPrompt<string> selectionPrompt = new SelectionPrompt<string>().Title(LaunchMenu.I18N_Instruction).WrapAround().AddChoices(LaunchMenu.I18N_Start, LaunchMenu.I18N_Options, "插件仓库", LaunchMenu.I18N_UpdateAssets, LaunchMenu.I18N_UpdateProgram, "加入QQ群（号被封过之后在频道里说话会概率被夹");
		if (RuntimeInformation.IsOSPlatform(OSPlatform.Windows))
		{
			selectionPrompt.AddChoice(LaunchMenu.I18N_InstallUraCore);
		}
		string prompt = AnsiConsole.Prompt(selectionPrompt);
		if (prompt == LaunchMenu.I18N_Options)
		{
			Config.Prompt();
		}
		else if (prompt == "插件仓库")
		{
			string value = "https://raw.githubusercontent.com/URA-Plugins/PluginMaster/refs/heads/master/PluginMaster/manifests.json".AllowMirror();
			Dictionary<string, string> dictionary = new Dictionary<string, string> { ["默认仓库"] = value };
			string key;
			string value2;
			foreach (KeyValuePair<string, string> additionalPluginRepository in Config.Repository.AdditionalPluginRepositories)
			{
				additionalPluginRepository.Deconstruct(out value2, out key);
				string key2 = value2;
				string value3 = key;
				dictionary.Add(key2, value3);
			}
			Dictionary<string, (string Description, PluginInformation PluginInfo)> plugins = new Dictionary<string, (string, PluginInformation)>();
			foreach (KeyValuePair<string, string> item in dictionary)
			{
				item.Deconstruct(out key, out value2);
				string repositoryName = key;
				string requestUri = value2;
				AnsiConsole.WriteLine("正在从" + repositoryName + "获取插件信息");
				List<PluginInformation> list = JsonConvert.DeserializeObject<List<PluginInformation>>(await ResourceUpdater.HttpClient.GetStringAsync(requestUri));
				if (list == null)
				{
					continue;
				}
				foreach (PluginInformation item2 in list.Where((PluginInformation x) => x.Targets.Length == 0 || x.Targets.Intersect(Config.Repository.Targets).Any()))
				{
					if (repositoryName == "默认仓库" && Uri.TryCreate(item2.DownloadUrl, UriKind.Absolute, out Uri result) && result.Host.EndsWith("github.com"))
					{
						item2.DownloadUrl = item2.DownloadUrl.AllowMirror();
					}
					if (plugins.ContainsKey(item2.Name))
					{
						plugins.Add(item2.Name + "(" + repositoryName + ")", (item2.Description, item2));
					}
					plugins.Add(item2.Name, (item2.Description, item2));
				}
			}
			AnsiConsole.Clear();
			MultiSelectionPrompt<string> prompt2 = new MultiSelectionPrompt<string>().Title("选择要安装的插件").WrapAround().AddChoices(plugins.Select((KeyValuePair<string, (string Description, PluginInformation PluginInfo)> x) => x.Key + ": " + x.Value.Description))
				.PageSize(30)
				.NotRequired();
			List<PluginInformation> selectedPlugins = (from x in AnsiConsole.Prompt(prompt2)
				select plugins[x.Split(':')[0]].PluginInfo).ToList();
			if (selectedPlugins.Count == 0)
			{
				AnsiConsole.Clear();
				return prompt;
			}
			string[] array = selectedPlugins.SelectMany((PluginInformation x) => x.Dependencies).Distinct().ToArray();
			foreach (string dependency in array)
			{
				if (selectedPlugins.Any((PluginInformation x) => x.InternalName == dependency))
				{
					continue;
				}
				KeyValuePair<string, (string, PluginInformation)> keyValuePair = plugins.FirstOrDefault((KeyValuePair<string, (string Description, PluginInformation PluginInfo)> x) => x.Value.PluginInfo.InternalName == dependency);
				if (keyValuePair.Key != null)
				{
					PluginInformation pluginInformation;
					(value2, pluginInformation) = keyValuePair.Value;
					if (!(value2 == null) || pluginInformation != null)
					{
						selectedPlugins.Add(keyValuePair.Value.Item2);
						continue;
					}
				}
				AnsiConsole.WriteLine("没有在任何插件仓库中找到依赖项" + dependency);
			}
			foreach (PluginInformation plugin in selectedPlugins)
			{
				AnsiConsole.WriteLine("[" + plugin.Name + "] 正在下载");
				using Stream stream = await ResourceUpdater.HttpClient.GetStreamAsync(plugin.DownloadUrl);
				using ZipArchive source = new ZipArchive(stream);
				AnsiConsole.WriteLine("[" + plugin.Name + "] 正在解压");
				source.ExtractToDirectory("./", overwriteFiles: true);
				AnsiConsole.WriteLine("[" + plugin.Name + "] 安装完成");
			}
			if (selectedPlugins.Count > 0)
			{
				AnsiConsole.WriteLine("插件安装已全部完成，按任意键重新启动。");
				Console.ReadKey();
				Restart();
			}
			Console.ReadKey();
		}
		else if (prompt == LaunchMenu.I18N_UpdateAssets)
		{
			await ResourceUpdater.UpdateAssets();
		}
		else if (prompt == LaunchMenu.I18N_UpdateProgram)
		{
			await ResourceUpdater.UpdateProgram();
		}
		else if (prompt == LaunchMenu.I18N_InstallUraCore && UraCoreHelper.GamePaths.Count != 0)
		{
			AnsiConsole.Clear();
			string repositoryName = AnsiConsole.Prompt(new TextPrompt<string>("请选择想要安装的Mod: ").AddChoices(new _003C_003Ez__ReadOnlyArray<string>(new string[2] { "umamusume-localify", "Hachimi" })).DefaultValue("Hachimi"));
			AnsiConsole.WriteLine(LaunchMenu.I18N_UraCoreHelper_FoundPaths, UraCoreHelper.GamePaths.Count);
			foreach (string i in UraCoreHelper.GamePaths)
			{
				AnsiConsole.WriteLine(LaunchMenu.I18N_UraCoreHelper_FoundAvailablePath, i);
				if (!AnsiConsole.Prompt(new ConfirmationPrompt($"是否需要将{repositoryName}安装到{i}？该操作需要管理员权限。")))
				{
					continue;
				}
				using Process proc = new Process();
				ProcessStartInfo startInfo = new ProcessStartInfo
				{
					FileName = Environment.ProcessPath,
					Arguments = "--enable-dll-redirection",
					CreateNoWindow = true,
					UseShellExecute = true,
					Verb = "runas"
				};
				proc.StartInfo = startInfo;
				proc.Start();
				proc.WaitForExit();
				if (proc.ExitCode != 0)
				{
					continue;
				}
				string requestUri2 = ((repositoryName == "Hachimi") ? "https://github.com/UmamusumeResponseAnalyzer/Hachimi/releases/latest/download/Hachimi.zip" : "https://github.com/UmamusumeResponseAnalyzer/Hachimi/releases/latest/download/UmamusumeLocalify.zip").AllowMirror();
				using Stream stream2 = await ResourceUpdater.HttpClient.GetStreamAsync(requestUri2);
				using ZipArchive source2 = new ZipArchive(stream2);
				source2.ExtractToDirectory(i, overwriteFiles: true);
				AnsiConsole.WriteLine(LaunchMenu.I18N_UraCoreHelper_InstallSuccess, i);
			}
			Console.ReadKey();
		}
		else if (prompt == "加入QQ群（号被封过之后在频道里说话会概率被夹")
		{
			Process.Start(new ProcessStartInfo
			{
				FileName = "https://qm.qq.com/q/4z6xHQ908w",
				UseShellExecute = true
			});
			AnsiConsole.WriteLine("https://qm.qq.com/q/4z6xHQ908w");
			AnsiConsole.WriteLine("按任意键返回到主菜单...");
			Console.ReadKey();
		}
		AnsiConsole.Clear();
		return prompt;
	}

	private static async Task ParseArguments(string[] args)
	{
		switch (args.Length)
		{
		case 0:
			await ResourceUpdater.TryUpdateProgram();
			break;
		case 1:
			switch (args[0])
			{
			case "-v":
			case "--version":
				Console.Write(Assembly.GetExecutingAssembly().GetName().Version);
				Environment.Exit(0);
				break;
			case "--enable-dll-redirection":
				UraCoreHelper.EnableDllRedirection();
				Task.Run(async () =>
				{
					await Task.Delay(3000);
					Environment.Exit(Environment.ExitCode);
				});
				Console.ReadLine();
				Environment.Exit(Environment.ExitCode);
				break;
			}
			break;
		case 2:
		{
			string text = args[0];
			if (!(text == "--update"))
			{
				if (text == "--update-data")
				{
					ZipFile.ExtractToDirectory(args[1], "./");
				}
			}
			else
			{
				await ResourceUpdater.TryUpdateProgram(args[1]);
			}
			break;
		}
		}
	}

	internal static void ApplyCultureInfo(LanguageConfig.Language culture)
	{
		Thread.CurrentThread.CurrentCulture = CultureInfo.GetCultureInfo(LanguageConfig.GetCulture());
		Thread.CurrentThread.CurrentUICulture = CultureInfo.GetCultureInfo(LanguageConfig.GetCulture());
		foreach (Type item in from x in Assembly.GetExecutingAssembly().GetTypes()
			where x.IsClass && (x.Namespace?.StartsWith("UmamusumeResponseAnalyzer.Localization") ?? false)
			select x)
		{
			FieldInfo fieldInfo = item?.GetField("resourceCulture", BindingFlags.Static | BindingFlags.NonPublic);
			if (!(fieldInfo == null))
			{
				fieldInfo.SetValue(fieldInfo, Thread.CurrentThread.CurrentUICulture);
			}
		}
	}

	internal static void Restart()
	{
		string processPath = Environment.ProcessPath;
		Process.Start(new ProcessStartInfo(processPath)
		{
			UseShellExecute = true,
			WorkingDirectory = Path.GetDirectoryName(processPath)
		});
		Environment.Exit(0);
	}
}
