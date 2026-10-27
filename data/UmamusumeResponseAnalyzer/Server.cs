using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Net.NetworkInformation;
using System.Net.Sockets;
using System.Reflection;
using System.Threading.Tasks;
using MessagePack;
using Newtonsoft.Json;
using Newtonsoft.Json.Linq;
using Spectre.Console;
using UmamusumeResponseAnalyzer.Localization;
using UmamusumeResponseAnalyzer.Plugin;
using WatsonWebserver.Core;
using WatsonWebserver.Lite;

namespace UmamusumeResponseAnalyzer;

public static class Server
{
	internal static WebserverLite Instance = new WebserverLite(new WebserverSettings(Config.Core.ListenAddress, Config.Core.ListenPort), (HttpContextBase ctx) => ctx.Response.Send(string.Empty));

	public static bool IsRunning => Instance.IsListening;

	internal static void Start()
	{
		Instance.Routes.PreAuthentication.Static.Add(HttpMethod.POST, "/notify/response", (HttpContextBase ctx) =>
		{
			byte[] buffer = ctx.Request.DataAsBytes;
			if (Config.Misc.SaveResponseForDebug)
			{
				if (Directory.Exists("packets"))
				{
					string[] files = Directory.GetFiles("packets");
					for (int i = 0; i < files.Length; i++)
					{
						FileInfo fileInfo = new FileInfo(files[i]);
						if (fileInfo.CreationTime.AddDays(1.0) < DateTime.Now)
						{
							fileInfo.Delete();
						}
					}
				}
				else
				{
					Directory.CreateDirectory("packets");
				}
				File.WriteAllBytes($"packets/{DateTime.Now:yy-MM-dd HH-mm-ss-fff}R.msgpack", buffer);
			}
			Task.Run(() =>
			{
				ParseResponse(buffer);
			});
			return ctx.Response.Send(string.Empty);
		});
		Instance.Routes.PreAuthentication.Static.Add(HttpMethod.POST, "/notify/request", (HttpContextBase ctx) =>
		{
			byte[] buffer = ctx.Request.DataAsBytes;
			if (Config.Core.RequestAdditionalHeader)
			{
				Task.Run(() =>
				{
					ParseRequest(buffer[170..]);
				});
			}
			else
			{
				Task.Run(() =>
				{
					ParseRequest(buffer);
				});
			}
			return ctx.Response.Send(string.Empty);
		});
		Instance.Routes.PreAuthentication.Static.Add(HttpMethod.GET, "/notify/ping", (HttpContextBase ctx) =>
		{
			AnsiConsole.MarkupLine(global::UmamusumeResponseAnalyzer.Localization.Server.I18N_PingReceived);
			return ctx.Response.Send("pong");
		});
		Instance.Start();
		foreach (IPlugin loadedPlugin in PluginManager.LoadedPlugins)
		{
			AnsiConsole.MarkupLine($"插件{loadedPlugin.Name} v{loadedPlugin.Version}[lightgreen]加载成功[/]");
		}
		foreach (string failedPlugin in PluginManager.FailedPlugins)
		{
			AnsiConsole.MarkupLine($"插件{Path.GetFileName(failedPlugin)}[red]加载失败[/] ({failedPlugin})");
		}
		if (!(Config.Core.ListenAddress == "0.0.0.0"))
		{
			return;
		}
		foreach (string item in (from x in (from x in NetworkInterface.GetAllNetworkInterfaces()
				where x.OperationalStatus == OperationalStatus.Up && x.NetworkInterfaceType != NetworkInterfaceType.Loopback
				select x).SelectMany((NetworkInterface x) => x.GetIPProperties().UnicastAddresses)
			where x.Address.AddressFamily == AddressFamily.InterNetwork
			select x.Address.ToString()).ToList())
		{
			AnsiConsole.WriteLine(global::UmamusumeResponseAnalyzer.Localization.Server.I18N_AvailableEndpointTip, item, Config.Core.ListenPort);
		}
	}

	internal static void Stop()
	{
		Instance.Dispose();
	}

	private static void ParseRequest(byte[] buffer)
	{
		try
		{
			JObject jObject = JsonConvert.DeserializeObject<JObject>(MessagePackSerializer.ConvertToJson(buffer));
			if (jObject == null)
			{
				return;
			}
			foreach (KeyValuePair<int, List<(IPlugin, MethodInfo)>> requsetAnalyzerMethod in PluginManager.RequsetAnalyzerMethods)
			{
				requsetAnalyzerMethod.Deconstruct(out var _, out var value);
				foreach (var (obj, methodInfo) in value)
				{
					try
					{
						methodInfo.Invoke(obj, new object[1] { jObject });
					}
					catch (Exception exception)
					{
						AnsiConsole.WriteException(exception);
					}
				}
			}
		}
		catch
		{
			if (!Config.Core.RequestAdditionalHeader)
			{
				buffer = buffer[170..];
			}
			Config.Core.RequestAdditionalHeader = !Config.Core.RequestAdditionalHeader;
			Config.Save();
		}
	}

	private static void ParseResponse(byte[] buffer)
	{
		try
		{
			JObject jObject = JsonConvert.DeserializeObject<JObject>(MessagePackSerializer.ConvertToJson(buffer));
			if (jObject == null)
			{
				return;
			}
			JObject jObject2 = jObject["data"] as JObject;
			if (jObject2 != null)
			{
				if (jObject2["single_mode_load_common"] is JObject jObject3)
				{
					string text = jObject2.Properties().FirstOrDefault((JProperty x) => x.Name.EndsWith("_data_set"))?.Name;
					if (text != null)
					{
						jObject3[text] = jObject2[text];
					}
					string text2 = jObject2.Properties().FirstOrDefault((JProperty x) => x.Name.EndsWith("_data_set_load"))?.Name;
					if (text2 != null)
					{
						jObject3[text2] = jObject2[text2];
					}
					jObject.Remove("data");
					jObject.Add("data", jObject3);
					jObject2 = jObject3;
				}
				if (jObject2["chara_info"] is JObject jObject4)
				{
					int num = jObject4["scenario_id"].ToInt();
					if (num == 5 && jObject2.TryGetValue("venus_data_set", out JToken value))
					{
						if (value["race_start_info"] is JArray)
						{
							value["race_start_info"] = null;
						}
						if (value["venus_race_condition"] is JArray)
						{
							value["venus_race_condition"] = null;
						}
						jObject["data"]["venus_data_set"] = value;
					}
					if (num == 8 && jObject2.TryGetValue("cook_data_set", out value))
					{
						if (value["dish_skill_info"] is JArray)
						{
							value["dish_skill_info"] = null;
						}
						if (value["gain_material_info"] is JArray)
						{
							value["gain_material_info"] = null;
						}
						if (value["last_command_info"] is JArray)
						{
							value["last_command_info"] = null;
						}
						jObject["data"]["cook_data_set"] = value;
					}
					if (num == 10 && jObject2.TryGetValue("legend_data_set", out value))
					{
						if (value["cm_info"] is JObject jObject5 && jObject5["race_result_info"] is JArray)
						{
							jObject5["race_result_info"] = null;
						}
						if (value["popularity_info"] is JArray)
						{
							value["popularity_info"] = null;
						}
						else if (value["popularity_info"] is JObject jObject6 && jObject6["poster_race_result_info"] is JArray)
						{
							jObject6["poster_race_result_info"] = null;
						}
						jObject["data"]["legend_data_set"] = value;
					}
					if (num == 11 && jObject2.TryGetValue("pioneer_data_set", out value))
					{
						if (value["shima_training_info"] is JArray)
						{
							value["shima_training_info"] = null;
						}
						jObject["data"]["pioneer_data_set"] = value;
					}
				}
			}
			foreach (KeyValuePair<int, List<(IPlugin, MethodInfo)>> responseAnalyzerMethod in PluginManager.ResponseAnalyzerMethods)
			{
				responseAnalyzerMethod.Deconstruct(out var _, out var value2);
				foreach (var (obj, methodInfo) in value2)
				{
					try
					{
						methodInfo.Invoke(obj, new object[1] { jObject });
					}
					catch (Exception exception)
					{
						AnsiConsole.WriteException(exception);
					}
				}
			}
		}
		catch (Exception exception2)
		{
			AnsiConsole.MarkupLine(global::UmamusumeResponseAnalyzer.Localization.Server.I18N_ResponseAnalyzeFail);
			AnsiConsole.WriteException(exception2);
		}
	}
}
