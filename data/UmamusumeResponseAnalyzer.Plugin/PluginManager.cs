using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Reflection;
using System.Runtime.Loader;
using System.Threading.Tasks;
using Spectre.Console;
using WatsonWebserver.Core;

namespace UmamusumeResponseAnalyzer.Plugin;

public static class PluginManager
{
	internal class PluginLoadContext : AssemblyLoadContext
	{
		public PluginLoadContext(string contextName)
			: base(contextName, isCollectible: true)
		{
		}

		protected override Assembly? Load(AssemblyName assemblyName)
		{
			Assembly assembly = Assemblies.FirstOrDefault((Assembly a) => a.GetName().Name == assemblyName.Name);
			if (assembly != null)
			{
				return assembly;
			}
			Assembly assembly2 = AssemblyLoadContext.Default.Assemblies.FirstOrDefault((Assembly a) => a.GetName().Name == assemblyName.Name);
			if (assembly2 != null)
			{
				return assembly2;
			}
			string path = Metadatas.FirstOrDefault((KeyValuePair<string, PluginMetadata> x) => x.Value.FilePath.EndsWith(assemblyName.Name + ".dll")).Value?.FilePath;
			if (!File.Exists(path))
			{
				return null;
			}
			return LoadFromStream(LoadStreamIndependent(path));
		}

		internal static MemoryStream LoadStreamIndependent(string path)
		{
			MemoryStream memoryStream = new MemoryStream();
			using FileStream fileStream = File.Open(path, FileMode.Open, FileAccess.Read, FileShare.Read | FileShare.Delete);
			fileStream.CopyTo(memoryStream);
			memoryStream.Position = 0L;
			return memoryStream;
		}
	}

	internal class PluginMetadata(string path, string name, bool loadInHost, List<string> sharedContextsWith)
	{
		public string FilePath { get; } = path;

		public string PluginName { get; } = name;

		public bool LoadInHost { get; } = loadInHost;

		public List<string> SharedContextsWith { get; } = sharedContextsWith;
	}

	internal static List<string> PLUGIN_FILES => (from x in new DirectoryInfo("Plugins").GetFiles("*.dll", SearchOption.AllDirectories)
		select x.FullName).ToList();

	private static Dictionary<string, PluginMetadata> Metadatas { get; } = new Dictionary<string, PluginMetadata>();

	internal static List<string> FailedPlugins { get; } = new List<string>();

	public static List<IPlugin> LoadedPlugins { get; } = new List<IPlugin>();

	internal static SortedDictionary<int, List<(IPlugin Self, MethodInfo Method)>> RequsetAnalyzerMethods { get; } = new SortedDictionary<int, List<(IPlugin, MethodInfo)>>();

	internal static SortedDictionary<int, List<(IPlugin Self, MethodInfo Method)>> ResponseAnalyzerMethods { get; } = new SortedDictionary<int, List<(IPlugin, MethodInfo)>>();

	internal static List<HashSet<string>> ContextGroups { get; } = new List<HashSet<string>>();

	internal static Dictionary<string, PluginLoadContext> Contexts { get; } = new Dictionary<string, PluginLoadContext>();

	internal static List<Assembly> Assemblies { get; } = new List<Assembly>();

	internal static void Init()
	{
		Directory.CreateDirectory("Plugins");
		foreach (string pLUGIN_FILE in PLUGIN_FILES)
		{
			if (!pLUGIN_FILE.EndsWith(".resources.dll") || pLUGIN_FILE.Contains(LanguageConfig.GetCulture()))
			{
				PluginMetadata pluginMetadata = LoadMetadata(pLUGIN_FILE);
				Metadatas.Add(pluginMetadata.PluginName, pluginMetadata);
			}
		}
		foreach (PluginMetadata item in Metadatas.Values.Where((PluginMetadata x) => x.SharedContextsWith.Count != 0))
		{
			item.SharedContextsWith.RemoveAll((string x) => Metadatas[x].LoadInHost);
			foreach (string share in item.SharedContextsWith)
			{
				HashSet<string> hashSet = ContextGroups.FirstOrDefault((HashSet<string> x) => x.Contains(share));
				if (hashSet != null)
				{
					hashSet.Add(item.PluginName);
					continue;
				}
				ContextGroups.Add(new HashSet<string> { share, item.PluginName });
			}
		}
		foreach (PluginMetadata metadata in Metadatas.Values.Where((PluginMetadata x) => !x.LoadInHost && x.SharedContextsWith.Count == 0))
		{
			if (ContextGroups.FirstOrDefault((HashSet<string> x) => x.Contains(metadata.PluginName)) == null)
			{
				ContextGroups.Add(new HashSet<string> { metadata.PluginName });
			}
		}
		foreach (KeyValuePair<string, PluginMetadata> item2 in Metadatas.Where((KeyValuePair<string, PluginMetadata> x) => x.Value.LoadInHost))
		{
			Assembly assembly = AssemblyLoadContext.Default.LoadFromStream(PluginLoadContext.LoadStreamIndependent(item2.Value.FilePath));
			AssemblyName[] referencedAssemblies = assembly.GetReferencedAssemblies();
			foreach (AssemblyName reference in referencedAssemblies)
			{
				string text = Metadatas.FirstOrDefault((KeyValuePair<string, PluginMetadata> x) => x.Value.FilePath.EndsWith(reference.Name + ".dll")).Value?.FilePath;
				if (text != null && !AssemblyLoadContext.Default.Assemblies.Any((Assembly x) => x.GetName().Name == reference.Name))
				{
					AssemblyLoadContext.Default.LoadFromStream(PluginLoadContext.LoadStreamIndependent(text));
				}
			}
			if (Activator.CreateInstance(assembly.GetExportedTypes().FirstOrDefault((Type x) => typeof(IPlugin).IsAssignableFrom(x)) ?? throw new TypeLoadException()) is IPlugin plugin)
			{
				RegisterHandlers(plugin);
				Assemblies.Add(assembly);
			}
			else
			{
				FailedPlugins.Add(item2.Value.FilePath);
			}
			Assemblies.Add(assembly);
		}
		foreach (HashSet<string> contextGroup in ContextGroups)
		{
			LoadContextGroup(contextGroup);
		}
	}

	internal static PluginMetadata LoadMetadata(string pluginPath)
	{
		PluginLoadContext pluginLoadContext = new PluginLoadContext("LoadMetadataContext");
		Assembly assembly = pluginLoadContext.LoadFromAssemblyPath(pluginPath);
		bool loadInHost = assembly.GetCustomAttribute<LoadInHostContextAttribute>() != null;
		List<string> sharedContextsWith = assembly.GetCustomAttributes<SharedContextWithAttribute>().SelectMany((SharedContextWithAttribute x) => x.PluginNames).ToList();
		PluginMetadata result = new PluginMetadata(pluginPath, assembly.GetName().Name ?? string.Empty, loadInHost, sharedContextsWith);
		pluginLoadContext.Unload();
		return result;
	}

	internal static void LoadContextGroup(HashSet<string> group)
	{
		string text = string.Join("&", group);
		if (!Contexts.TryGetValue(text, out PluginLoadContext value))
		{
			value = new PluginLoadContext(text);
			Contexts.Add(text, value);
		}
		foreach (string item in group)
		{
			LoadPlugin(value, Metadatas[item].FilePath);
		}
	}

	internal static void LoadPlugin(PluginLoadContext context, string pluginPath)
	{
		try
		{
			Assembly assembly = context.LoadFromStream(PluginLoadContext.LoadStreamIndependent(pluginPath));
			Type type = assembly.GetExportedTypes().FirstOrDefault((Type x) => typeof(IPlugin).IsAssignableFrom(x));
			if ((object)type == null)
			{
				context.Unload();
			}
			else if (Activator.CreateInstance(type) is IPlugin plugin)
			{
				if (plugin.Targets.Length == 0 || plugin.Targets.Intersect(Config.Repository.Targets).Any() || Config.Repository.Targets.Count == 0)
				{
					Directory.CreateDirectory("./PluginData/" + plugin.Name);
					LoadedPlugins.Add(plugin);
					RegisterSettings(plugin);
					RegisterHandlers(plugin);
					RegisterRoutes(plugin);
				}
				Assemblies.Add(assembly);
			}
			else
			{
				FailedPlugins.Add(pluginPath);
			}
		}
		catch (Exception exception)
		{
			AnsiConsole.WriteException(exception);
			FailedPlugins.Add(pluginPath);
		}
	}

	internal static void RegisterSettings(IPlugin plugin)
	{
		IEnumerable<PropertyInfo> enumerable = from x in plugin.GetType().GetProperties()
			where x.GetCustomAttribute<PluginSettingAttribute>() != null
			select x;
		if (Config.Plugin.PluginSettings.TryGetValue(plugin.Name, out Dictionary<string, object> value))
		{
			foreach (PropertyInfo item in enumerable)
			{
				if (value.TryGetValue(item.Name, out var value2))
				{
					if (value2 is string text && item.PropertyType != typeof(string))
					{
						if (item.PropertyType == typeof(int))
						{
							value2 = int.Parse(text);
						}
						else if (item.PropertyType == typeof(bool))
						{
							value2 = bool.Parse(text);
						}
						else if (item.PropertyType == typeof(double))
						{
							value2 = double.Parse(text);
						}
					}
					item.SetValue(plugin, value2);
				}
			}
			return;
		}
		Config.Plugin.PluginSettings.Add(plugin.Name, new Dictionary<string, object>());
		foreach (PropertyInfo item2 in enumerable)
		{
			Config.Plugin.PluginSettings[plugin.Name].Add(item2.Name, item2.GetValue(plugin));
		}
	}

	internal static void RegisterHandlers(IPlugin plugin)
	{
		MethodInfo[] methods = plugin.GetType().GetMethods();
		foreach (MethodInfo methodInfo in methods)
		{
			AnalyzerAttribute customAttribute = methodInfo.GetCustomAttribute<AnalyzerAttribute>();
			if (customAttribute == null)
			{
				continue;
			}
			if (customAttribute.Response)
			{
				if (!ResponseAnalyzerMethods.ContainsKey(customAttribute.Priority))
				{
					ResponseAnalyzerMethods.Add(customAttribute.Priority, new List<(IPlugin, MethodInfo)>());
				}
				ResponseAnalyzerMethods[customAttribute.Priority].Add((plugin, methodInfo));
			}
			else
			{
				if (!RequsetAnalyzerMethods.ContainsKey(customAttribute.Priority))
				{
					RequsetAnalyzerMethods.Add(customAttribute.Priority, new List<(IPlugin, MethodInfo)>());
				}
				RequsetAnalyzerMethods[customAttribute.Priority].Add((plugin, methodInfo));
			}
		}
	}

	internal static void RegisterRoutes(IPlugin plugin)
	{
		MethodInfo[] methods = plugin.GetType().GetMethods();
		foreach (MethodInfo method in methods)
		{
			RouteAttribute customAttribute = method.GetCustomAttribute<RouteAttribute>();
			if (customAttribute == null)
			{
				continue;
			}
			ParameterInfo[] parameters = method.GetParameters();
			if (parameters.Length == 1 && parameters[0].ParameterType == typeof(HttpContextBase))
			{
				Server.Instance.Routes.PreAuthentication.Static.Add(customAttribute.Method, "/" + plugin.Name + "/" + customAttribute.Path, (HttpContextBase x) => (Task)method.Invoke(null, new object[1] { x }));
				continue;
			}
			AnsiConsole.MarkupLine($"{plugin.Name}注册Route{customAttribute.Path}失败:参数有且只能有一个HttpContextBase，实际为{string.Join(", ", parameters.Select((ParameterInfo x) => x.ParameterType.Name))}");
		}
	}
}
