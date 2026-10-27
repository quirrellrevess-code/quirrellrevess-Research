using System;
using System.CodeDom.Compiler;
using System.Runtime.CompilerServices;
using System.Runtime.InteropServices;
using UmamusumeResponseAnalyzer.Plugin;

namespace UmamusumeResponseAnalyzer;

internal static class ConsoleHelper
{
	internal delegate bool HandlerRoutine(CtrlTypes CtrlType);

	internal enum CtrlTypes
	{
		CTRL_C_EVENT = 0,
		CTRL_BREAK_EVENT = 1,
		CTRL_CLOSE_EVENT = 2,
		CTRL_LOGOFF_EVENT = 5,
		CTRL_SHUTDOWN_EVENT = 6
	}

	private const uint ENABLE_QUICK_EDIT_MODE = 64u;

	private const uint ENABLE_MOUSE_INPUT = 16u;

	private const int StdInputHandle = -10;

	[LibraryImport("kernel32.dll", SetLastError = true)]
	[GeneratedCode("Microsoft.Interop.LibraryImportGenerator", "10.0.14.7603")]
	[SkipLocalsInit]
	private static nint GetStdHandle(int nStdHandle)
	{
		Marshal.SetLastSystemError(0);
		nint result = __PInvoke(nStdHandle);
		Marshal.SetLastPInvokeError(Marshal.GetLastSystemError());
		return result;
		[DllImport("kernel32.dll", EntryPoint = "GetStdHandle", ExactSpelling = true)]
		static extern nint __PInvoke(int __nStdHandle_native);
	}

	[LibraryImport("kernel32.dll")]
	[GeneratedCode("Microsoft.Interop.LibraryImportGenerator", "10.0.14.7603")]
	[SkipLocalsInit]
	[return: MarshalAs(UnmanagedType.Bool)]
	private unsafe static bool GetConsoleMode(nint hConsoleHandle, out uint lpMode)
	{
		lpMode = 0u;
		int num;
		fixed (uint* _lpMode_native = &lpMode)
		{
			num = __PInvoke(hConsoleHandle, _lpMode_native);
		}
		return num != 0;
		[DllImport("kernel32.dll", EntryPoint = "GetConsoleMode", ExactSpelling = true)]
		unsafe static extern int __PInvoke(nint __hConsoleHandle_native, uint* __lpMode_native);
	}

	[LibraryImport("kernel32.dll")]
	[GeneratedCode("Microsoft.Interop.LibraryImportGenerator", "10.0.14.7603")]
	[SkipLocalsInit]
	[return: MarshalAs(UnmanagedType.Bool)]
	private static bool SetConsoleMode(nint hConsoleHandle, uint dwMode)
	{
		return __PInvoke(hConsoleHandle, dwMode) != 0;
		[DllImport("kernel32.dll", EntryPoint = "SetConsoleMode", ExactSpelling = true)]
		static extern int __PInvoke(nint __hConsoleHandle_native, uint __dwMode_native);
	}

	internal static bool DisableQuickEditMode()
	{
		nint stdHandle = GetStdHandle(-10);
		if (!GetConsoleMode(stdHandle, out var lpMode))
		{
			return false;
		}
		lpMode &= 0xFFFFFFBFu;
		lpMode &= 0xFFFFFFEFu;
		if (!SetConsoleMode(stdHandle, lpMode))
		{
			return false;
		}
		return true;
	}

	[LibraryImport("Kernel32")]
	[GeneratedCode("Microsoft.Interop.LibraryImportGenerator", "10.0.14.7603")]
	[SkipLocalsInit]
	[return: MarshalAs(UnmanagedType.Bool)]
	internal static bool SetConsoleCtrlHandler(HandlerRoutine Handler, [MarshalAs(UnmanagedType.Bool)] bool Add)
	{
		int num = __PInvoke((Handler != null) ? Marshal.GetFunctionPointerForDelegate(Handler) : 0, Add ? 1 : 0);
		GC.KeepAlive(Handler);
		return num != 0;
		[DllImport("Kernel32", EntryPoint = "SetConsoleCtrlHandler", ExactSpelling = true)]
		static extern int __PInvoke(nint __Handler_native, int __Add_native);
	}

	internal static bool ConsoleCtrlCheck(CtrlTypes ctrlType)
	{
		Server.Stop();
		foreach (IPlugin loadedPlugin in PluginManager.LoadedPlugins)
		{
			loadedPlugin.Dispose();
		}
		ResourceUpdater.HttpClient.Dispose();
		return true;
	}
}
