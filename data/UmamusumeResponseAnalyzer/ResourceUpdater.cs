using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.IO;
using System.Net.Http;
using System.Net.Http.Headers;
using System.Reflection;
using System.Security.Cryptography;
using System.Threading.Tasks;
using Newtonsoft.Json;
using Newtonsoft.Json.Linq;
using Spectre.Console;
using UmamusumeResponseAnalyzer.Localization;
using UmamusumeResponseAnalyzer.Plugin;

namespace UmamusumeResponseAnalyzer;

public static class ResourceUpdater
{
	public static HttpClient HttpClient = new HttpClient
	{
		DefaultRequestHeaders = 
		{
			UserAgent = 
			{
				new ProductInfoHeaderValue("UmamusumeResponseAnalyzer", Assembly.GetExecutingAssembly().GetName().Version?.ToString() ?? "Unknown Version")
			}
		}
	};

	public static async Task<IEnumerable<PluginInformation>> GetPluginsFromRepository(string repositoryUrl)
	{
		IEnumerable<PluginInformation> enumerable = JsonConvert.DeserializeObject<IEnumerable<PluginInformation>>(await HttpClient.GetStringAsync(repositoryUrl));
		return enumerable ?? Array.Empty<PluginInformation>();
	}

	public static async Task<bool> NeedUpdate()
	{
		return !(JObject.Parse(await HttpClient.GetStringAsync("https://api.github.com/repos/UmamusumeResponseAnalyzer/UmamusumeResponseAnalyzer/releases/latest"))["tag_name"]?.ToString() ?? string.Empty).Equals("v" + Assembly.GetExecutingAssembly().GetName().Version);
	}

	public static async Task UpdateProgram()
	{
		if (!(await NeedUpdate()))
		{
			Console.WriteLine(global::UmamusumeResponseAnalyzer.Localization.ResourceUpdater.I18N_AlreadyLatestInstruction);
			Console.WriteLine(LaunchMenu.I18N_Options_BackToMenuInstruction);
			Console.ReadKey();
			return;
		}
		string path = Path.Combine(Path.GetTempPath(), "latest-UmamusumeResponseAnalyzer.exe");
		await AnsiConsole.Progress().Columns(new TaskDescriptionColumn(), new ProgressBarColumn(), new PercentageColumn(), new RemainingTimeColumn(), new SpinnerColumn()).StartAsync(async (ProgressContext ctx) =>
		{
			List<Task> list = new List<Task>();
			Task item = Download(ctx, global::UmamusumeResponseAnalyzer.Localization.ResourceUpdater.I18N_DownloadProgramInstruction, path);
			list.Add(item);
			await Task.WhenAll(list);
		});
		Console.WriteLine(global::UmamusumeResponseAnalyzer.Localization.ResourceUpdater.I18N_BeginUpdateProgramInstruction);
		Console.ReadKey();
		CloseToUpdate();
	}

	public static void CloseToUpdate()
	{
		using (Process process = new Process())
		{
			string value = string.Empty;
			try
			{
				process.StartInfo = new ProcessStartInfo
				{
					FileName = Path.Combine(Path.GetTempPath(), "latest-UmamusumeResponseAnalyzer.exe"),
					Arguments = "-v",
					UseShellExecute = false,
					RedirectStandardOutput = true,
					CreateNoWindow = true
				};
				process.Start();
				while (!process.StandardOutput.EndOfStream)
				{
					value = process.StandardOutput.ReadLine();
				}
			}
			catch
			{
			}
			if (string.IsNullOrEmpty(value))
			{
				AnsiConsole.MarkupLine(global::UmamusumeResponseAnalyzer.Localization.ResourceUpdater.I18N_UpdatedFileCorrupted);
				File.Delete(Path.Combine(Path.GetTempPath(), "latest-UmamusumeResponseAnalyzer.exe"));
				return;
			}
		}
		using Process process2 = new Process
		{
			StartInfo = new ProcessStartInfo
			{
				FileName = Path.Combine(Path.GetTempPath(), "latest-UmamusumeResponseAnalyzer.exe"),
				Arguments = "--update \"" + Environment.ProcessPath + "\"",
				UseShellExecute = true
			}
		};
		process2.Start();
		Environment.Exit(0);
	}

	public static async Task TryUpdateProgram(string savepath = null)
	{
		string text = Path.Combine(Path.GetTempPath(), "latest-UmamusumeResponseAnalyzer.exe");
		bool flag = File.Exists(text);
		if (!string.IsNullOrEmpty(savepath))
		{
			text = savepath;
			File.Copy(Environment.ProcessPath, text, overwrite: true);
			using Process process = new Process
			{
				StartInfo = new ProcessStartInfo
				{
					FileName = text,
					UseShellExecute = true
				}
			};
			process.Start();
			Environment.Exit(0);
		}
		else if (flag && !SHA256.HashData(File.ReadAllBytes(Environment.ProcessPath)).SequenceEqual(SHA256.HashData(File.ReadAllBytes(text))))
		{
			CloseToUpdate();
			flag = false;
		}
		if (flag)
		{
			File.Delete(text);
			await UpdateAssets();
			AnsiConsole.Clear();
		}
	}

	public static async Task UpdateAssets()
	{
		await AnsiConsole.Progress().Columns(new TaskDescriptionColumn(), new ProgressBarColumn(), new PercentageColumn(), new RemainingTimeColumn(), new SpinnerColumn()).StartAsync(async (ProgressContext ctx) =>
		{
			List<Task> list = new List<Task>();
			Task item = Download(ctx, global::UmamusumeResponseAnalyzer.Localization.ResourceUpdater.I18N_DownloadEventsInstruction, Database.EVENT_NAME_FILEPATH);
			list.Add(item);
			Task item2 = Download(ctx, global::UmamusumeResponseAnalyzer.Localization.ResourceUpdater.I18N_DownloadSuccessEventsInstruction, Database.SUCCESS_EVENT_FILEPATH);
			list.Add(item2);
			Task item3 = Download(ctx, global::UmamusumeResponseAnalyzer.Localization.ResourceUpdater.I18N_DownloadNamesInstruction, Database.NAMES_FILEPATH);
			list.Add(item3);
			Task item4 = Download(ctx, global::UmamusumeResponseAnalyzer.Localization.ResourceUpdater.I18N_DownloadSkillDataInstruction, Database.SKILLS_FILEPATH);
			list.Add(item4);
			Task item5 = Download(ctx, global::UmamusumeResponseAnalyzer.Localization.ResourceUpdater.I18N_DownloadTalentSkillInstruction, Database.TALENT_SKILLS_FILEPATH);
			list.Add(item5);
			Task item6 = Download(ctx, global::UmamusumeResponseAnalyzer.Localization.ResourceUpdater.I18N_DownloadFactorIdsInstruction, Database.FACTOR_IDS_FILEPATH);
			list.Add(item6);
			Task item7 = Download(ctx, global::UmamusumeResponseAnalyzer.Localization.ResourceUpdater.I18N_DownloadSkillUpgradeSpecialityInstruction, Database.SKILL_UPGRADE_SPECIALITY_FILEPATH);
			list.Add(item7);
			Task item8 = Download(ctx, Database.SADDLE_IDS_FILEPATH, Database.SADDLE_IDS_FILEPATH);
			list.Add(item8);
			Task item9 = Download(ctx, Database.SUCCESSION_RELATION_FILEPATH, Database.SUCCESSION_RELATION_FILEPATH);
			list.Add(item9);
			await Task.WhenAll(list);
		});
		AnsiConsole.MarkupLine(global::UmamusumeResponseAnalyzer.Localization.ResourceUpdater.I18N_DownloadedInstruction);
		Console.ReadKey();
	}

	private static string GetDownloadUrl(string filepath)
	{
		string text = "https://github.com/UmamusumeResponseAnalyzer/UmamusumeResponseAnalyzer/releases/latest/download/UmamusumeResponseAnalyzer.exe".AllowMirror();
		string value = (string.IsNullOrEmpty(Config.Updater.CustomDatabaseRepository) ? "https://github.com/UmamusumeResponseAnalyzer/Assets/raw/refs/heads/main/".AllowMirror() : Config.Updater.CustomDatabaseRepository);
		string extension = Path.GetExtension(filepath);
		string fileName = Path.GetFileName(filepath);
		return extension switch
		{
			".br" => $"{value}/GameData/{Config.Updater.DatabaseLanguage}/{fileName}", 
			".exe" => text, 
		};
	}

	public static async Task Download(ProgressContext ctx = null, string instruction = null, string path = null)
	{
		string downloadURL = GetDownloadUrl(path);
		try
		{
			await HttpClient.SendAsync(new HttpRequestMessage(HttpMethod.Head, downloadURL));
		}
		catch
		{
			if (new Uri(downloadURL).Host == "raw.githubusercontent.com")
			{
				AnsiConsole.MarkupLine(global::UmamusumeResponseAnalyzer.Localization.ResourceUpdater.I18N_AccessGithubFail, downloadURL);
			}
			else
			{
				AnsiConsole.MarkupLine(global::UmamusumeResponseAnalyzer.Localization.ResourceUpdater.I18N_AccessMirrorFail, downloadURL);
			}
			return;
		}
		HttpResponseMessage httpResponseMessage = await HttpClient.SendAsync(new HttpRequestMessage(HttpMethod.Get, downloadURL), HttpCompletionOption.ResponseHeadersRead);
		ProgressTask task = ctx?.AddTask(instruction, autoStart: false);
		task?.MaxValue(httpResponseMessage.Content.Headers.ContentLength.GetValueOrDefault());
		task?.StartTask();
		using Stream contentStream = await httpResponseMessage.Content.ReadAsStreamAsync();
		using FileStream fileStream = new FileStream(path, FileMode.Create, FileAccess.Write, FileShare.None, 8192, useAsync: true);
		byte[] buffer = new byte[8192];
		while (true)
		{
			int num = await contentStream.ReadAsync(buffer);
			if (num != 0)
			{
				task?.Increment(num);
				await fileStream.WriteAsync(buffer.AsMemory(0, num));
				continue;
			}
			break;
		}
	}
}
