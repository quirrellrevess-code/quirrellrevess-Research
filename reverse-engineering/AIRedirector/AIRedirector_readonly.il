
//  Microsoft (R) .NET Framework IL Disassembler.  Version 4.8.3928.0
//  Copyright (c) Microsoft Corporation.  All rights reserved.



// Metadata version: v4.0.30319
.module extern kernel32.dll
.assembly extern System.Runtime
{
  .publickeytoken = (B0 3F 5F 7F 11 D5 0A 3A )                         // .?_....:
  .ver 10:0:0:0
}
.assembly extern System.Diagnostics.Process
{
  .publickeytoken = (B0 3F 5F 7F 11 D5 0A 3A )                         // .?_....:
  .ver 10:0:0:0
}
.assembly extern UmamusumeResponseAnalyzer
{
  .ver 1:14:4:0
}
.assembly extern System.Collections
{
  .publickeytoken = (B0 3F 5F 7F 11 D5 0A 3A )                         // .?_....:
  .ver 10:0:0:0
}
.assembly extern Spectre.Console
{
  .publickeytoken = (17 0F E2 7F 8A F9 8A 30 )                         // .......0
  .ver 0:0:0:0
}
.assembly extern Newtonsoft.Json
{
  .publickeytoken = (30 AD 4F E6 B2 A6 AE ED )                         // 0.O.....
  .ver 13:0:0:0
}
.assembly extern System.IO.Compression
{
  .publickeytoken = (B7 7A 5C 56 19 34 E0 89 )                         // .z\V.4..
  .ver 10:0:0:0
}
.assembly extern System.Net.Http
{
  .publickeytoken = (B0 3F 5F 7F 11 D5 0A 3A )                         // .?_....:
  .ver 10:0:0:0
}
.assembly extern System.Runtime.InteropServices
{
  .publickeytoken = (B0 3F 5F 7F 11 D5 0A 3A )                         // .?_....:
  .ver 10:0:0:0
}
.assembly extern Microsoft.Win32.Primitives
{
  .publickeytoken = (B0 3F 5F 7F 11 D5 0A 3A )                         // .?_....:
  .ver 10:0:0:0
}
.assembly extern System.Text.Encoding.CodePages
{
  .publickeytoken = (B0 3F 5F 7F 11 D5 0A 3A )                         // .?_....:
  .ver 10:0:0:0
}
.assembly extern System.Diagnostics.TraceSource
{
  .publickeytoken = (B0 3F 5F 7F 11 D5 0A 3A )                         // .?_....:
  .ver 10:0:0:0
}
.assembly extern System.ComponentModel.Primitives
{
  .publickeytoken = (B0 3F 5F 7F 11 D5 0A 3A )                         // .?_....:
  .ver 10:0:0:0
}
.assembly extern System.Console
{
  .publickeytoken = (B0 3F 5F 7F 11 D5 0A 3A )                         // .?_....:
  .ver 10:0:0:0
}
.assembly extern System.IO.Compression.ZipFile
{
  .publickeytoken = (B7 7A 5C 56 19 34 E0 89 )                         // .z\V.4..
  .ver 10:0:0:0
}
.assembly AIRedirector
{
  .custom instance void [System.Runtime]System.Runtime.CompilerServices.CompilationRelaxationsAttribute::.ctor(int32) = ( 01 00 08 00 00 00 00 00 ) 
  .custom instance void [System.Runtime]System.Runtime.CompilerServices.RuntimeCompatibilityAttribute::.ctor() = ( 01 00 01 00 54 02 16 57 72 61 70 4E 6F 6E 45 78   // ....T..WrapNonEx
                                                                                                                   63 65 70 74 69 6F 6E 54 68 72 6F 77 73 01 )       // ceptionThrows.

  // --- The following custom attribute is added automatically, do not uncomment -------
  //  .custom instance void [System.Runtime]System.Diagnostics.DebuggableAttribute::.ctor(valuetype [System.Runtime]System.Diagnostics.DebuggableAttribute/DebuggingModes) = ( 01 00 02 00 00 00 00 00 ) 

  .custom instance void [System.Runtime]System.Runtime.Versioning.TargetFrameworkAttribute::.ctor(string) = ( 01 00 19 2E 4E 45 54 43 6F 72 65 41 70 70 2C 56   // ....NETCoreApp,V
                                                                                                              65 72 73 69 6F 6E 3D 76 31 30 2E 30 01 00 54 0E   // ersion=v10.0..T.
                                                                                                              14 46 72 61 6D 65 77 6F 72 6B 44 69 73 70 6C 61   // .FrameworkDispla
                                                                                                              79 4E 61 6D 65 09 2E 4E 45 54 20 31 30 2E 30 )    // yName..NET 10.0
  .custom instance void [System.Runtime]System.Reflection.AssemblyCompanyAttribute::.ctor(string) = ( 01 00 0C 41 49 52 65 64 69 72 65 63 74 6F 72 00   // ...AIRedirector.
                                                                                                      00 ) 
  .custom instance void [System.Runtime]System.Reflection.AssemblyConfigurationAttribute::.ctor(string) = ( 01 00 07 52 65 6C 65 61 73 65 00 00 )             // ...Release..
  .custom instance void [System.Runtime]System.Reflection.AssemblyFileVersionAttribute::.ctor(string) = ( 01 00 07 31 2E 31 2E 31 2E 30 00 00 )             // ...1.1.1.0..
  .custom instance void [System.Runtime]System.Reflection.AssemblyInformationalVersionAttribute::.ctor(string) = ( 01 00 05 31 2E 31 2E 31 00 00 )                   // ...1.1.1..
  .custom instance void [System.Runtime]System.Reflection.AssemblyProductAttribute::.ctor(string) = ( 01 00 0C 41 49 52 65 64 69 72 65 63 74 6F 72 00   // ...AIRedirector.
                                                                                                      00 ) 
  .custom instance void [System.Runtime]System.Reflection.AssemblyTitleAttribute::.ctor(string) = ( 01 00 0C 41 49 52 65 64 69 72 65 63 74 6F 72 00   // ...AIRedirector.
                                                                                                    00 ) 
  .hash algorithm 0x00008004
  .ver 1:1:1:0
}
.module AIRedirector.dll
// MVID: {2A0E6635-9357-4988-8BF8-F8E2F8EAD0ED}
.custom instance void [System.Runtime]System.Runtime.CompilerServices.RefSafetyRulesAttribute::.ctor(int32) = ( 01 00 0B 00 00 00 00 00 ) 
.imagebase 0x10000000
.file alignment 0x00000200
.stackreserve 0x00100000
.subsystem 0x0003       // WINDOWS_CUI
.corflags 0x00000001    //  ILONLY
// Image base: 0x05CF0000


// =============== CLASS MEMBERS DECLARATION ===================

.class private auto ansi sealed beforefieldinit AIRedirector.ChildProcessManager
       extends [System.Runtime]System.Object
       implements [System.Runtime]System.IDisposable
{
  .class auto ansi sealed nested private JobObjectInfoType
         extends [System.Runtime]System.Enum
  {
    .field public specialname rtspecialname int32 value__
    .field public static literal valuetype AIRedirector.ChildProcessManager/JobObjectInfoType ExtendedLimitInformation = int32(0x00000009)
  } // end of class JobObjectInfoType

  .class sequential ansi sealed nested private beforefieldinit JOBOBJECT_BASIC_LIMIT_INFORMATION
         extends [System.Runtime]System.ValueType
  {
    .field public int64 PerProcessUserTimeLimit
    .field public int64 PerJobUserTimeLimit
    .field public uint32 LimitFlags
    .field public native uint MinimumWorkingSetSize
    .field public native uint MaximumWorkingSetSize
    .field public uint32 ActiveProcessLimit
    .field public int64 Affinity
    .field public uint32 PriorityClass
    .field public uint32 SchedulingClass
  } // end of class JOBOBJECT_BASIC_LIMIT_INFORMATION

  .class sequential ansi sealed nested private beforefieldinit IO_COUNTERS
         extends [System.Runtime]System.ValueType
  {
    .field public uint64 ReadOperationCount
    .field public uint64 WriteOperationCount
    .field public uint64 OtherOperationCount
    .field public uint64 ReadTransferCount
    .field public uint64 WriteTransferCount
    .field public uint64 OtherTransferCount
  } // end of class IO_COUNTERS

  .class sequential ansi sealed nested private beforefieldinit JOBOBJECT_EXTENDED_LIMIT_INFORMATION
         extends [System.Runtime]System.ValueType
  {
    .field public valuetype AIRedirector.ChildProcessManager/JOBOBJECT_BASIC_LIMIT_INFORMATION BasicLimitInformation
    .field public valuetype AIRedirector.ChildProcessManager/IO_COUNTERS IoInfo
    .field public native uint ProcessMemoryLimit
    .field public native uint JobMemoryLimit
    .field public native uint PeakProcessMemoryUsed
    .field public native uint PeakJobMemoryUsed
  } // end of class JOBOBJECT_EXTENDED_LIMIT_INFORMATION

  .field private initonly native int _jobHandle
  .field private bool _disposed
  .field private static literal uint32 JOB_OBJECT_LIMIT_KILL_ON_JOB_CLOSE = uint32(0x00002000)
  .method public hidebysig specialname rtspecialname 
          instance void  .ctor() cil managed
  {
    // Code size       165 (0xa5)
    .maxstack  4
    .locals init (valuetype AIRedirector.ChildProcessManager/JOBOBJECT_EXTENDED_LIMIT_INFORMATION V_0,
             int32 V_1,
             native int V_2,
             valuetype AIRedirector.ChildProcessManager/JOBOBJECT_EXTENDED_LIMIT_INFORMATION V_3,
             valuetype AIRedirector.ChildProcessManager/JOBOBJECT_BASIC_LIMIT_INFORMATION V_4)
    IL_0000:  ldarg.0
    IL_0001:  call       instance void [System.Runtime]System.Object::.ctor()
    IL_0006:  ldarg.0
    IL_0007:  ldsfld     native int [System.Runtime]System.IntPtr::Zero
    IL_000c:  ldnull
    IL_000d:  call       native int AIRedirector.ChildProcessManager::CreateJobObject(native int,
                                                                                      string)
    IL_0012:  stfld      native int AIRedirector.ChildProcessManager::_jobHandle
    IL_0017:  ldarg.0
    IL_0018:  ldfld      native int AIRedirector.ChildProcessManager::_jobHandle
    IL_001d:  ldsfld     native int [System.Runtime]System.IntPtr::Zero
    IL_0022:  bne.un.s   IL_0034

    IL_0024:  call       int32 [System.Runtime.InteropServices]System.Runtime.InteropServices.Marshal::GetLastWin32Error()
    IL_0029:  ldstr      bytearray (E0 65 D5 6C 1B 52 FA 5E 20 00 4A 00 6F 00 62 00   // .e.l.R.^ .J.o.b.
                                    20 00 4F 00 62 00 6A 00 65 00 63 00 74 00 )       //  .O.b.j.e.c.t.
    IL_002e:  newobj     instance void [Microsoft.Win32.Primitives]System.ComponentModel.Win32Exception::.ctor(int32,
                                                                                                               string)
    IL_0033:  throw

    IL_0034:  ldloca.s   V_3
    IL_0036:  initobj    AIRedirector.ChildProcessManager/JOBOBJECT_EXTENDED_LIMIT_INFORMATION
    IL_003c:  ldloca.s   V_3
    IL_003e:  ldloca.s   V_4
    IL_0040:  initobj    AIRedirector.ChildProcessManager/JOBOBJECT_BASIC_LIMIT_INFORMATION
    IL_0046:  ldloca.s   V_4
    IL_0048:  ldc.i4     0x2000
    IL_004d:  stfld      uint32 AIRedirector.ChildProcessManager/JOBOBJECT_BASIC_LIMIT_INFORMATION::LimitFlags
    IL_0052:  ldloc.s    V_4
    IL_0054:  stfld      valuetype AIRedirector.ChildProcessManager/JOBOBJECT_BASIC_LIMIT_INFORMATION AIRedirector.ChildProcessManager/JOBOBJECT_EXTENDED_LIMIT_INFORMATION::BasicLimitInformation
    IL_0059:  ldloc.3
    IL_005a:  stloc.0
    IL_005b:  ldtoken    AIRedirector.ChildProcessManager/JOBOBJECT_EXTENDED_LIMIT_INFORMATION
    IL_0060:  call       class [System.Runtime]System.Type [System.Runtime]System.Type::GetTypeFromHandle(valuetype [System.Runtime]System.RuntimeTypeHandle)
    IL_0065:  call       int32 [System.Runtime.InteropServices]System.Runtime.InteropServices.Marshal::SizeOf(class [System.Runtime]System.Type)
    IL_006a:  stloc.1
    IL_006b:  ldloc.1
    IL_006c:  call       native int [System.Runtime.InteropServices]System.Runtime.InteropServices.Marshal::AllocHGlobal(int32)
    IL_0071:  stloc.2
    .try
    {
      IL_0072:  ldloc.0
      IL_0073:  ldloc.2
      IL_0074:  ldc.i4.0
      IL_0075:  call       void [System.Runtime.InteropServices]System.Runtime.InteropServices.Marshal::StructureToPtr<valuetype AIRedirector.ChildProcessManager/JOBOBJECT_EXTENDED_LIMIT_INFORMATION>(!!0,
                                                                                                                                                                                                        native int,
                                                                                                                                                                                                        bool)
      IL_007a:  ldarg.0
      IL_007b:  ldfld      native int AIRedirector.ChildProcessManager::_jobHandle
      IL_0080:  ldc.i4.s   9
      IL_0082:  ldloc.2
      IL_0083:  ldloc.1
      IL_0084:  call       bool AIRedirector.ChildProcessManager::SetInformationJobObject(native int,
                                                                                          valuetype AIRedirector.ChildProcessManager/JobObjectInfoType,
                                                                                          native int,
                                                                                          uint32)
      IL_0089:  brtrue.s   IL_009b

      IL_008b:  call       int32 [System.Runtime.InteropServices]System.Runtime.InteropServices.Marshal::GetLastWin32Error()
      IL_0090:  ldstr      bytearray (E0 65 D5 6C BE 8B 6E 7F 20 00 4A 00 6F 00 62 00   // .e.l..n. .J.o.b.
                                      20 00 4F 00 62 00 6A 00 65 00 63 00 74 00 20 00   //  .O.b.j.e.c.t. .
                                      E1 4F 6F 60 )                                     // .Oo`
      IL_0095:  newobj     instance void [Microsoft.Win32.Primitives]System.ComponentModel.Win32Exception::.ctor(int32,
                                                                                                                 string)
      IL_009a:  throw

      IL_009b:  leave.s    IL_00a4

    }  // end .try
    finally
    {
      IL_009d:  ldloc.2
      IL_009e:  call       void [System.Runtime.InteropServices]System.Runtime.InteropServices.Marshal::FreeHGlobal(native int)
      IL_00a3:  endfinally
    }  // end handler
    IL_00a4:  ret
  } // end of method ChildProcessManager::.ctor

  .method public hidebysig instance void 
          AddProcess(class [System.Diagnostics.Process]System.Diagnostics.Process process) cil managed
  {
    .custom instance void [System.Runtime]System.Runtime.CompilerServices.NullableContextAttribute::.ctor(uint8) = ( 01 00 01 00 00 ) 
    // Code size       96 (0x60)
    .maxstack  4
    .locals init (valuetype [System.Runtime]System.Runtime.CompilerServices.DefaultInterpolatedStringHandler V_0)
    IL_0000:  ldarg.1
    IL_0001:  ldstr      "process"
    IL_0006:  call       void [System.Runtime]System.ArgumentNullException::ThrowIfNull(object,
                                                                                        string)
    IL_000b:  ldarg.0
    IL_000c:  ldfld      native int AIRedirector.ChildProcessManager::_jobHandle
    IL_0011:  ldarg.1
    IL_0012:  callvirt   instance native int [System.Diagnostics.Process]System.Diagnostics.Process::get_Handle()
    IL_0017:  call       bool AIRedirector.ChildProcessManager::AssignProcessToJobObject(native int,
                                                                                         native int)
    IL_001c:  brtrue.s   IL_005f

    IL_001e:  call       int32 [System.Runtime.InteropServices]System.Runtime.InteropServices.Marshal::GetLastWin32Error()
    IL_0023:  ldloca.s   V_0
    IL_0025:  ldc.i4.s   21
    IL_0027:  ldc.i4.1
    IL_0028:  call       instance void [System.Runtime]System.Runtime.CompilerServices.DefaultInterpolatedStringHandler::.ctor(int32,
                                                                                                                               int32)
    IL_002d:  ldloca.s   V_0
    IL_002f:  ldstr      bytearray (E0 65 D5 6C 06 5C DB 8F 0B 7A 20 00 )             // .e.l.\...z .
    IL_0034:  call       instance void [System.Runtime]System.Runtime.CompilerServices.DefaultInterpolatedStringHandler::AppendLiteral(string)
    IL_0039:  ldloca.s   V_0
    IL_003b:  ldarg.1
    IL_003c:  callvirt   instance int32 [System.Diagnostics.Process]System.Diagnostics.Process::get_Id()
    IL_0041:  call       instance void [System.Runtime]System.Runtime.CompilerServices.DefaultInterpolatedStringHandler::AppendFormatted<int32>(!!0)
    IL_0046:  ldloca.s   V_0
    IL_0048:  ldstr      bytearray (20 00 06 52 4D 91 30 52 20 00 4A 00 6F 00 62 00   //  ..RM.0R .J.o.b.
                                    20 00 4F 00 62 00 6A 00 65 00 63 00 74 00 )       //  .O.b.j.e.c.t.
    IL_004d:  call       instance void [System.Runtime]System.Runtime.CompilerServices.DefaultInterpolatedStringHandler::AppendLiteral(string)
    IL_0052:  ldloca.s   V_0
    IL_0054:  call       instance string [System.Runtime]System.Runtime.CompilerServices.DefaultInterpolatedStringHandler::ToStringAndClear()
    IL_0059:  newobj     instance void [Microsoft.Win32.Primitives]System.ComponentModel.Win32Exception::.ctor(int32,
                                                                                                               string)
    IL_005e:  throw

    IL_005f:  ret
  } // end of method ChildProcessManager::AddProcess

  .method public hidebysig newslot virtual final 
          instance void  Dispose() cil managed
  {
    // Code size       42 (0x2a)
    .maxstack  8
    IL_0000:  ldarg.0
    IL_0001:  ldfld      bool AIRedirector.ChildProcessManager::_disposed
    IL_0006:  brfalse.s  IL_0009

    IL_0008:  ret

    IL_0009:  ldarg.0
    IL_000a:  ldc.i4.1
    IL_000b:  stfld      bool AIRedirector.ChildProcessManager::_disposed
    IL_0010:  ldarg.0
    IL_0011:  ldfld      native int AIRedirector.ChildProcessManager::_jobHandle
    IL_0016:  ldsfld     native int [System.Runtime]System.IntPtr::Zero
    IL_001b:  beq.s      IL_0029

    IL_001d:  ldarg.0
    IL_001e:  ldfld      native int AIRedirector.ChildProcessManager::_jobHandle
    IL_0023:  call       bool AIRedirector.ChildProcessManager::CloseHandle(native int)
    IL_0028:  pop
    IL_0029:  ret
  } // end of method ChildProcessManager::Dispose

  .method private hidebysig static pinvokeimpl("kernel32.dll" unicode lasterr winapi) 
          native int  CreateJobObject(native int lpJobAttributes,
                                      string lpName) cil managed preservesig
  {
    .custom instance void [System.Runtime]System.Runtime.CompilerServices.NullableContextAttribute::.ctor(uint8) = ( 01 00 02 00 00 ) 
  }
  .method private hidebysig static pinvokeimpl("kernel32.dll" lasterr winapi) 
          bool  marshal( bool)  SetInformationJobObject(native int hJob,
                                                        valuetype AIRedirector.ChildProcessManager/JobObjectInfoType infoType,
                                                        native int lpJobObjectInfo,
                                                        uint32 cbJobObjectInfoLength) cil managed preservesig
  {
  }
  .method private hidebysig static pinvokeimpl("kernel32.dll" lasterr winapi) 
          bool  marshal( bool)  AssignProcessToJobObject(native int hJob,
                                                         native int hProcess) cil managed preservesig
  {
  }
  .method private hidebysig static pinvokeimpl("kernel32.dll" lasterr winapi) 
          bool  marshal( bool)  CloseHandle(native int hObject) cil managed preservesig
  {
  }
} // end of class AIRedirector.ChildProcessManager

.class public auto ansi beforefieldinit AIRedirector.AIRedirector
       extends [System.Runtime]System.Object
       implements [UmamusumeResponseAnalyzer]UmamusumeResponseAnalyzer.Plugin.IPlugin
{
  .custom instance void [System.Runtime]System.Runtime.CompilerServices.NullableContextAttribute::.ctor(uint8) = ( 01 00 01 00 00 ) 
  .custom instance void [System.Runtime]System.Runtime.CompilerServices.NullableAttribute::.ctor(uint8) = ( 01 00 00 00 00 ) 
  .interfaceimpl type [UmamusumeResponseAnalyzer]UmamusumeResponseAnalyzer.Plugin.IPlugin
  .custom instance void [System.Runtime]System.Runtime.CompilerServices.NullableAttribute::.ctor(uint8) = ( 01 00 00 00 00 ) 
  .class auto ansi serializable sealed nested private beforefieldinit '<>c'
         extends [System.Runtime]System.Object
  {
    .custom instance void [System.Runtime]System.Runtime.CompilerServices.CompilerGeneratedAttribute::.ctor() = ( 01 00 00 00 ) 
    .field public static initonly class AIRedirector.AIRedirector/'<>c' '<>9'
    .custom instance void [System.Runtime]System.Runtime.CompilerServices.NullableAttribute::.ctor(uint8) = ( 01 00 00 00 00 ) 
    .field public static class [System.Diagnostics.Process]System.Diagnostics.DataReceivedEventHandler '<>9__41_0'
    .custom instance void [System.Runtime]System.Runtime.CompilerServices.NullableAttribute::.ctor(uint8) = ( 01 00 00 00 00 ) 
    .field public static class [System.Diagnostics.Process]System.Diagnostics.DataReceivedEventHandler '<>9__41_1'
    .custom instance void [System.Runtime]System.Runtime.CompilerServices.NullableAttribute::.ctor(uint8) = ( 01 00 00 00 00 ) 
    .field public static class [System.Diagnostics.Process]System.Diagnostics.DataReceivedEventHandler '<>9__41_2'
    .custom instance void [System.Runtime]System.Runtime.CompilerServices.NullableAttribute::.ctor(uint8) = ( 01 00 00 00 00 ) 
    .field public static class [System.Diagnostics.Process]System.Diagnostics.DataReceivedEventHandler '<>9__41_3'
    .custom instance void [System.Runtime]System.Runtime.CompilerServices.NullableAttribute::.ctor(uint8) = ( 01 00 00 00 00 ) 
    .method private hidebysig specialname rtspecialname static 
            void  .cctor() cil managed
    {
      // Code size       11 (0xb)
      .maxstack  8
      IL_0000:  newobj     instance void AIRedirector.AIRedirector/'<>c'::.ctor()
      IL_0005:  stsfld     class AIRedirector.AIRedirector/'<>c' AIRedirector.AIRedirector/'<>c'::'<>9'
      IL_000a:  ret
    } // end of method '<>c'::.cctor

    .method public hidebysig specialname rtspecialname 
            instance void  .ctor() cil managed
    {
      // Code size       7 (0x7)
      .maxstack  8
      IL_0000:  ldarg.0
      IL_0001:  call       instance void [System.Runtime]System.Object::.ctor()
      IL_0006:  ret
    } // end of method '<>c'::.ctor

    .method assembly hidebysig instance void 
            '<Initialize>b__41_0'(object sender,
                                  class [System.Diagnostics.Process]System.Diagnostics.DataReceivedEventArgs e) cil managed
    {
      // Code size       68 (0x44)
      .maxstack  2
      IL_0000:  call       bool [UmamusumeResponseAnalyzer]UmamusumeResponseAnalyzer.UmamusumeResponseAnalyzer::get_Started()
      IL_0005:  brfalse.s  IL_0043

      IL_0007:  ldarg.2
      IL_0008:  callvirt   instance string [System.Diagnostics.Process]System.Diagnostics.DataReceivedEventArgs::get_Data()
      IL_000d:  call       bool [System.Runtime]System.String::IsNullOrEmpty(string)
      IL_0012:  brtrue.s   IL_0043

      IL_0014:  ldarg.2
      IL_0015:  callvirt   instance string [System.Diagnostics.Process]System.Diagnostics.DataReceivedEventArgs::get_Data()
      IL_001a:  ldstr      bytearray (D0 8F 14 6C 07 63 07 68 )                         // ...l.c.h
      IL_001f:  callvirt   instance bool [System.Runtime]System.String::Contains(string)
      IL_0024:  brtrue.s   IL_0038

      IL_0026:  ldarg.2
      IL_0027:  callvirt   instance string [System.Diagnostics.Process]System.Diagnostics.DataReceivedEventArgs::get_Data()
      IL_002c:  ldstr      bytearray (F8 76 08 8C )                                     // .v..
      IL_0031:  callvirt   instance bool [System.Runtime]System.String::Contains(string)
      IL_0036:  brfalse.s  IL_0043

      IL_0038:  ldarg.2
      IL_0039:  callvirt   instance string [System.Diagnostics.Process]System.Diagnostics.DataReceivedEventArgs::get_Data()
      IL_003e:  call       void [System.Console]System.Console::WriteLine(string)
      IL_0043:  ret
    } // end of method '<>c'::'<Initialize>b__41_0'

    .method assembly hidebysig instance void 
            '<Initialize>b__41_1'(object sender,
                                  class [System.Diagnostics.Process]System.Diagnostics.DataReceivedEventArgs e) cil managed
    {
      // Code size       159 (0x9f)
      .maxstack  2
      IL_0000:  call       bool [UmamusumeResponseAnalyzer]UmamusumeResponseAnalyzer.UmamusumeResponseAnalyzer::get_Started()
      IL_0005:  brfalse    IL_009e

      IL_000a:  ldarg.2
      IL_000b:  callvirt   instance string [System.Diagnostics.Process]System.Diagnostics.DataReceivedEventArgs::get_Data()
      IL_0010:  call       bool [System.Runtime]System.String::IsNullOrEmpty(string)
      IL_0015:  brtrue     IL_009e

      IL_001a:  ldarg.2
      IL_001b:  callvirt   instance string [System.Diagnostics.Process]System.Diagnostics.DataReceivedEventArgs::get_Data()
      IL_0020:  call       bool [System.Runtime]System.String::IsNullOrEmpty(string)
      IL_0025:  brtrue.s   IL_0039

      IL_0027:  ldarg.2
      IL_0028:  callvirt   instance string [System.Diagnostics.Process]System.Diagnostics.DataReceivedEventArgs::get_Data()
      IL_002d:  ldstr      bytearray (4B 62 99 51 3B 90 91 8F )                         // Kb.Q;...
      IL_0032:  callvirt   instance bool [System.Runtime]System.String::Contains(string)
      IL_0037:  brtrue.s   IL_0093

      IL_0039:  ldarg.2
      IL_003a:  callvirt   instance string [System.Diagnostics.Process]System.Diagnostics.DataReceivedEventArgs::get_Data()
      IL_003f:  ldstr      bytearray (99 84 79 72 61 53 1B 6D )                         // ..yraS.m
      IL_0044:  callvirt   instance bool [System.Runtime]System.String::Contains(string)
      IL_0049:  brtrue.s   IL_0093

      IL_004b:  ldarg.2
      IL_004c:  callvirt   instance string [System.Diagnostics.Process]System.Diagnostics.DataReceivedEventArgs::get_Data()
      IL_0051:  ldstr      bytearray (D0 8F 14 6C 07 63 07 68 )                         // ...l.c.h
      IL_0056:  callvirt   instance bool [System.Runtime]System.String::Contains(string)
      IL_005b:  brtrue.s   IL_0093

      IL_005d:  ldarg.2
      IL_005e:  callvirt   instance string [System.Diagnostics.Process]System.Diagnostics.DataReceivedEventArgs::get_Data()
      IL_0063:  ldstr      bytearray (1F 90 3A 00 )                                     // ..:.
      IL_0068:  callvirt   instance bool [System.Runtime]System.String::Contains(string)
      IL_006d:  brfalse.s  IL_0081

      IL_006f:  ldarg.2
      IL_0070:  callvirt   instance string [System.Diagnostics.Process]System.Diagnostics.DataReceivedEventArgs::get_Data()
      IL_0075:  ldstr      bytearray (7C 00 20 00 11 4F 6F 60 3A 00 )                   // |. ..Oo`:.
      IL_007a:  callvirt   instance bool [System.Runtime]System.String::Contains(string)
      IL_007f:  brtrue.s   IL_0093

      IL_0081:  ldarg.2
      IL_0082:  callvirt   instance string [System.Diagnostics.Process]System.Diagnostics.DataReceivedEventArgs::get_Data()
      IL_0087:  ldstr      bytearray (48 51 5A 50 99 65 06 74 )                         // HQZP.e.t
      IL_008c:  callvirt   instance bool [System.Runtime]System.String::Contains(string)
      IL_0091:  brfalse.s  IL_009e

      IL_0093:  ldarg.2
      IL_0094:  callvirt   instance string [System.Diagnostics.Process]System.Diagnostics.DataReceivedEventArgs::get_Data()
      IL_0099:  call       void [System.Console]System.Console::WriteLine(string)
      IL_009e:  ret
    } // end of method '<>c'::'<Initialize>b__41_1'

    .method assembly hidebysig instance void 
            '<Initialize>b__41_2'(object sender,
                                  class [System.Diagnostics.Process]System.Diagnostics.DataReceivedEventArgs e) cil managed
    {
      // Code size       177 (0xb1)
      .maxstack  2
      IL_0000:  call       bool [UmamusumeResponseAnalyzer]UmamusumeResponseAnalyzer.UmamusumeResponseAnalyzer::get_Started()
      IL_0005:  brfalse    IL_00b0

      IL_000a:  ldarg.2
      IL_000b:  callvirt   instance string [System.Diagnostics.Process]System.Diagnostics.DataReceivedEventArgs::get_Data()
      IL_0010:  call       bool [System.Runtime]System.String::IsNullOrEmpty(string)
      IL_0015:  brtrue     IL_00b0

      IL_001a:  ldarg.2
      IL_001b:  callvirt   instance string [System.Diagnostics.Process]System.Diagnostics.DataReceivedEventArgs::get_Data()
      IL_0020:  call       bool [System.Runtime]System.String::IsNullOrEmpty(string)
      IL_0025:  brtrue.s   IL_0039

      IL_0027:  ldarg.2
      IL_0028:  callvirt   instance string [System.Diagnostics.Process]System.Diagnostics.DataReceivedEventArgs::get_Data()
      IL_002d:  ldstr      bytearray (4B 62 99 51 3B 90 91 8F )                         // Kb.Q;...
      IL_0032:  callvirt   instance bool [System.Runtime]System.String::Contains(string)
      IL_0037:  brtrue.s   IL_00a5

      IL_0039:  ldarg.2
      IL_003a:  callvirt   instance string [System.Diagnostics.Process]System.Diagnostics.DataReceivedEventArgs::get_Data()
      IL_003f:  ldstr      bytearray (99 84 79 72 61 53 1B 6D )                         // ..yraS.m
      IL_0044:  callvirt   instance bool [System.Runtime]System.String::Contains(string)
      IL_0049:  brtrue.s   IL_00a5

      IL_004b:  ldarg.2
      IL_004c:  callvirt   instance string [System.Diagnostics.Process]System.Diagnostics.DataReceivedEventArgs::get_Data()
      IL_0051:  ldstr      bytearray (D0 8F 14 6C 07 63 07 68 )                         // ...l.c.h
      IL_0056:  callvirt   instance bool [System.Runtime]System.String::Contains(string)
      IL_005b:  brtrue.s   IL_00a5

      IL_005d:  ldarg.2
      IL_005e:  callvirt   instance string [System.Diagnostics.Process]System.Diagnostics.DataReceivedEventArgs::get_Data()
      IL_0063:  ldstr      bytearray (1F 90 3A 00 )                                     // ..:.
      IL_0068:  callvirt   instance bool [System.Runtime]System.String::Contains(string)
      IL_006d:  brfalse.s  IL_0081

      IL_006f:  ldarg.2
      IL_0070:  callvirt   instance string [System.Diagnostics.Process]System.Diagnostics.DataReceivedEventArgs::get_Data()
      IL_0075:  ldstr      bytearray (7C 00 20 00 11 4F 6F 60 3A 00 )                   // |. ..Oo`:.
      IL_007a:  callvirt   instance bool [System.Runtime]System.String::Contains(string)
      IL_007f:  brtrue.s   IL_00a5

      IL_0081:  ldarg.2
      IL_0082:  callvirt   instance string [System.Diagnostics.Process]System.Diagnostics.DataReceivedEventArgs::get_Data()
      IL_0087:  ldstr      bytearray (00 5F 2F 54 7F 9F 6E 8F )                         // ._/T..n.
      IL_008c:  callvirt   instance bool [System.Runtime]System.String::Contains(string)
      IL_0091:  brtrue.s   IL_00a5

      IL_0093:  ldarg.2
      IL_0094:  callvirt   instance string [System.Diagnostics.Process]System.Diagnostics.DataReceivedEventArgs::get_Data()
      IL_0099:  ldstr      bytearray (A7 7E F8 80 )                                     // .~..
      IL_009e:  callvirt   instance bool [System.Runtime]System.String::Contains(string)
      IL_00a3:  brfalse.s  IL_00b0

      IL_00a5:  ldarg.2
      IL_00a6:  callvirt   instance string [System.Diagnostics.Process]System.Diagnostics.DataReceivedEventArgs::get_Data()
      IL_00ab:  call       void [System.Console]System.Console::WriteLine(string)
      IL_00b0:  ret
    } // end of method '<>c'::'<Initialize>b__41_2'

    .method assembly hidebysig instance void 
            '<Initialize>b__41_3'(object sender,
                                  class [System.Diagnostics.Process]System.Diagnostics.DataReceivedEventArgs e) cil managed
    {
      // Code size       403 (0x193)
      .maxstack  2
      IL_0000:  call       bool [UmamusumeResponseAnalyzer]UmamusumeResponseAnalyzer.UmamusumeResponseAnalyzer::get_Started()
      IL_0005:  brfalse    IL_0192

      IL_000a:  ldarg.2
      IL_000b:  callvirt   instance string [System.Diagnostics.Process]System.Diagnostics.DataReceivedEventArgs::get_Data()
      IL_0010:  call       bool [System.Runtime]System.String::IsNullOrEmpty(string)
      IL_0015:  brtrue     IL_0192

      IL_001a:  ldarg.2
      IL_001b:  callvirt   instance string [System.Diagnostics.Process]System.Diagnostics.DataReceivedEventArgs::get_Data()
      IL_0020:  ldstr      "O"
      IL_0025:  callvirt   instance bool [System.Runtime]System.String::Contains(string)
      IL_002a:  brfalse.s  IL_002d

      IL_002c:  ret

      IL_002d:  ldarg.2
      IL_002e:  callvirt   instance string [System.Diagnostics.Process]System.Diagnostics.DataReceivedEventArgs::get_Data()
      IL_0033:  call       bool [System.Runtime]System.String::IsNullOrEmpty(string)
      IL_0038:  brtrue.s   IL_004f

      IL_003a:  ldarg.2
      IL_003b:  callvirt   instance string [System.Diagnostics.Process]System.Diagnostics.DataReceivedEventArgs::get_Data()
      IL_0040:  ldstr      bytearray (1F 90 20 00 3A 00 )                               // .. .:.
      IL_0045:  callvirt   instance bool [System.Runtime]System.String::Contains(string)
      IL_004a:  brtrue     IL_0187

      IL_004f:  ldarg.2
      IL_0050:  callvirt   instance string [System.Diagnostics.Process]System.Diagnostics.DataReceivedEventArgs::get_Data()
      IL_0055:  ldstr      bytearray (10 80 20 00 3A 00 )                               // .. .:.
      IL_005a:  callvirt   instance bool [System.Runtime]System.String::Contains(string)
      IL_005f:  brtrue     IL_0187

      IL_0064:  ldarg.2
      IL_0065:  callvirt   instance string [System.Diagnostics.Process]System.Diagnostics.DataReceivedEventArgs::get_Data()
      IL_006a:  ldstr      bytearray (9B 52 20 00 3A 00 )                               // .R .:.
      IL_006f:  callvirt   instance bool [System.Runtime]System.String::Contains(string)
      IL_0074:  brtrue     IL_0187

      IL_0079:  ldarg.2
      IL_007a:  callvirt   instance string [System.Diagnostics.Process]System.Diagnostics.DataReceivedEventArgs::get_Data()
      IL_007f:  ldstr      bytearray (39 68 20 00 3A 00 )                               // 9h .:.
      IL_0084:  callvirt   instance bool [System.Runtime]System.String::Contains(string)
      IL_0089:  brtrue     IL_0187

      IL_008e:  ldarg.2
      IL_008f:  callvirt   instance string [System.Diagnostics.Process]System.Diagnostics.DataReceivedEventArgs::get_Data()
      IL_0094:  ldstr      bytearray (7A 66 20 00 3A 00 )                               // zf .:.
      IL_0099:  callvirt   instance bool [System.Runtime]System.String::Contains(string)
      IL_009e:  brtrue     IL_0187

      IL_00a3:  ldarg.2
      IL_00a4:  callvirt   instance string [System.Diagnostics.Process]System.Diagnostics.DataReceivedEventArgs::get_Data()
      IL_00a9:  ldstr      bytearray (11 4F 6F 60 20 00 3A 00 )                         // .Oo` .:.
      IL_00ae:  callvirt   instance bool [System.Runtime]System.String::Contains(string)
      IL_00b3:  brtrue     IL_0187

      IL_00b8:  ldarg.2
      IL_00b9:  callvirt   instance string [System.Diagnostics.Process]System.Diagnostics.DataReceivedEventArgs::get_Data()
      IL_00be:  ldstr      bytearray (41 00 49 00 FA 5E AE 8B )                         // A.I..^..
      IL_00c3:  callvirt   instance bool [System.Runtime]System.String::Contains(string)
      IL_00c8:  brtrue     IL_0187

      IL_00cd:  ldarg.2
      IL_00ce:  callvirt   instance string [System.Diagnostics.Process]System.Diagnostics.DataReceivedEventArgs::get_Data()
      IL_00d3:  ldstr      bytearray (D0 8F 14 6C 07 63 07 68 )                         // ...l.c.h
      IL_00d8:  callvirt   instance bool [System.Runtime]System.String::Contains(string)
      IL_00dd:  brtrue     IL_0187

      IL_00e2:  ldarg.2
      IL_00e3:  callvirt   instance string [System.Diagnostics.Process]System.Diagnostics.DataReceivedEventArgs::get_Data()
      IL_00e8:  ldstr      bytearray (C4 8B 06 52 84 98 4B 6D )                         // ...R..Km
      IL_00ed:  callvirt   instance bool [System.Runtime]System.String::Contains(string)
      IL_00f2:  brtrue     IL_0187

      IL_00f7:  ldarg.2
      IL_00f8:  callvirt   instance string [System.Diagnostics.Process]System.Diagnostics.DataReceivedEventArgs::get_Data()
      IL_00fd:  ldstr      bytearray (09 90 E9 62 C3 5F 97 5F 2D 4E 1A FF )             // ...b._._-N..
      IL_0102:  callvirt   instance bool [System.Runtime]System.String::Contains(string)
      IL_0107:  brtrue.s   IL_0187

      IL_0109:  ldarg.2
      IL_010a:  callvirt   instance string [System.Diagnostics.Process]System.Diagnostics.DataReceivedEventArgs::get_Data()
      IL_010f:  ldstr      bytearray (28 00 A2 7E )                                     // (..~
      IL_0114:  callvirt   instance bool [System.Runtime]System.String::Contains(string)
      IL_0119:  brtrue.s   IL_0187

      IL_011b:  ldarg.2
      IL_011c:  callvirt   instance string [System.Diagnostics.Process]System.Diagnostics.DataReceivedEventArgs::get_Data()
      IL_0121:  ldstr      bytearray (28 00 FF 7E )                                     // (..~
      IL_0126:  callvirt   instance bool [System.Runtime]System.String::Contains(string)
      IL_012b:  brtrue.s   IL_0187

      IL_012d:  ldarg.2
      IL_012e:  callvirt   instance string [System.Diagnostics.Process]System.Diagnostics.DataReceivedEventArgs::get_Data()
      IL_0133:  ldstr      bytearray (28 00 DD 84 )                                     // (...
      IL_0138:  callvirt   instance bool [System.Runtime]System.String::Contains(string)
      IL_013d:  brtrue.s   IL_0187

      IL_013f:  ldarg.2
      IL_0140:  callvirt   instance string [System.Diagnostics.Process]System.Diagnostics.DataReceivedEventArgs::get_Data()
      IL_0145:  ldstr      bytearray (72 82 2C 7B )                                     // r.,{
      IL_014a:  callvirt   instance bool [System.Runtime]System.String::Contains(string)
      IL_014f:  brtrue.s   IL_0187

      IL_0151:  ldarg.2
      IL_0152:  callvirt   instance string [System.Diagnostics.Process]System.Diagnostics.DataReceivedEventArgs::get_Data()
      IL_0157:  ldstr      bytearray (2A 67 E5 77 19 95 EF 8B )                         // *g.w....
      IL_015c:  callvirt   instance bool [System.Runtime]System.String::Contains(string)
      IL_0161:  brtrue.s   IL_0175

      IL_0163:  ldarg.2
      IL_0164:  callvirt   instance string [System.Diagnostics.Process]System.Diagnostics.DataReceivedEventArgs::get_Data()
      IL_0169:  ldstr      bytearray (FB 8B D6 53 38 6E 0F 62 E1 4F 6F 60 6A 00 73 00   // ...S8n.b.Oo`j.s.
                                      6F 00 6E 00 FA 51 19 95 )                         // o.n..Q..
      IL_016e:  callvirt   instance bool [System.Runtime]System.String::Contains(string)
      IL_0173:  brtrue.s   IL_0187

      IL_0175:  ldarg.2
      IL_0176:  callvirt   instance string [System.Diagnostics.Process]System.Diagnostics.DataReceivedEventArgs::get_Data()
      IL_017b:  ldstr      bytearray (41 00 49 00 48 72 2C 67 )                         // A.I.Hr,g
      IL_0180:  callvirt   instance bool [System.Runtime]System.String::Contains(string)
      IL_0185:  brfalse.s  IL_0192

      IL_0187:  ldarg.2
      IL_0188:  callvirt   instance string [System.Diagnostics.Process]System.Diagnostics.DataReceivedEventArgs::get_Data()
      IL_018d:  call       void [System.Console]System.Console::WriteLine(string)
      IL_0192:  ret
    } // end of method '<>c'::'<Initialize>b__41_3'

  } // end of class '<>c'

  .class auto ansi sealed nested private beforefieldinit '<UpdatePlugin>d__6'
         extends [System.Runtime]System.ValueType
         implements [System.Runtime]System.Runtime.CompilerServices.IAsyncStateMachine
  {
    .custom instance void [System.Runtime]System.Runtime.CompilerServices.CompilerGeneratedAttribute::.ctor() = ( 01 00 00 00 ) 
    .interfaceimpl type [System.Runtime]System.Runtime.CompilerServices.IAsyncStateMachine
    .custom instance void [System.Runtime]System.Runtime.CompilerServices.NullableAttribute::.ctor(uint8) = ( 01 00 00 00 00 ) 
    .field public int32 '<>1__state'
    .field public valuetype [System.Runtime]System.Runtime.CompilerServices.AsyncTaskMethodBuilder '<>t__builder'
    .field public class [Spectre.Console]Spectre.Console.ProgressContext ctx
    .custom instance void [System.Runtime]System.Runtime.CompilerServices.NullableAttribute::.ctor(uint8) = ( 01 00 00 00 00 ) 
    .field public class AIRedirector.AIRedirector '<>4__this'
    .custom instance void [System.Runtime]System.Runtime.CompilerServices.NullableAttribute::.ctor(uint8) = ( 01 00 00 00 00 ) 
    .field private class [Spectre.Console]Spectre.Console.ProgressTask '<progress>5__2'
    .custom instance void [System.Runtime]System.Runtime.CompilerServices.NullableAttribute::.ctor(uint8) = ( 01 00 00 00 00 ) 
    .field private class [System.Net.Http]System.Net.Http.HttpClient '<client>5__3'
    .custom instance void [System.Runtime]System.Runtime.CompilerServices.NullableAttribute::.ctor(uint8) = ( 01 00 00 00 00 ) 
    .field private class [System.Net.Http]System.Net.Http.HttpResponseMessage '<resp>5__4'
    .custom instance void [System.Runtime]System.Runtime.CompilerServices.NullableAttribute::.ctor(uint8) = ( 01 00 00 00 00 ) 
    .field private class [System.Net.Http]System.Net.Http.HttpResponseMessage '<msg>5__5'
    .custom instance void [System.Runtime]System.Runtime.CompilerServices.NullableAttribute::.ctor(uint8) = ( 01 00 00 00 00 ) 
    .field private class [System.Runtime]System.IO.Stream '<stream>5__6'
    .custom instance void [System.Runtime]System.Runtime.CompilerServices.NullableAttribute::.ctor(uint8) = ( 01 00 00 00 00 ) 
    .field private uint8[] '<buffer>5__7'
    .custom instance void [System.Runtime]System.Runtime.CompilerServices.NullableAttribute::.ctor(uint8) = ( 01 00 00 00 00 ) 
    .field private valuetype [System.Runtime]System.Runtime.CompilerServices.TaskAwaiter`1<class [System.Net.Http]System.Net.Http.HttpResponseMessage> '<>u__1'
    .custom instance void [System.Runtime]System.Runtime.CompilerServices.NullableAttribute::.ctor(uint8[]) = ( 01 00 02 00 00 00 00 01 00 00 ) 
    .field private valuetype [System.Runtime]System.Runtime.CompilerServices.TaskAwaiter`1<string> '<>u__2'
    .custom instance void [System.Runtime]System.Runtime.CompilerServices.NullableAttribute::.ctor(uint8[]) = ( 01 00 02 00 00 00 00 01 00 00 ) 
    .field private valuetype [System.Runtime]System.Runtime.CompilerServices.TaskAwaiter`1<class [System.Runtime]System.IO.Stream> '<>u__3'
    .custom instance void [System.Runtime]System.Runtime.CompilerServices.NullableAttribute::.ctor(uint8[]) = ( 01 00 02 00 00 00 00 01 00 00 ) 
    .field private valuetype [System.Runtime]System.Runtime.CompilerServices.ValueTaskAwaiter`1<int32> '<>u__4'
    .custom instance void [System.Runtime]System.Runtime.CompilerServices.NullableAttribute::.ctor(uint8) = ( 01 00 00 00 00 ) 
    .method private hidebysig newslot virtual final 
            instance void  MoveNext() cil managed
    {
      .override [System.Runtime]System.Runtime.CompilerServices.IAsyncStateMachine::MoveNext
      // Code size       1362 (0x552)
      .maxstack  5
      .locals init (int32 V_0,
               class AIRedirector.AIRedirector V_1,
               class [Newtonsoft.Json]Newtonsoft.Json.Linq.JObject V_2,
               string V_3,
               class [System.IO.Compression]System.IO.Compression.ZipArchive V_4,
               class [System.Net.Http]System.Net.Http.HttpResponseMessage V_5,
               valuetype [System.Runtime]System.Runtime.CompilerServices.TaskAwaiter`1<class [System.Net.Http]System.Net.Http.HttpResponseMessage> V_6,
               valuetype [System.Runtime]System.Runtime.CompilerServices.TaskAwaiter`1<string> V_7,
               class [System.Runtime]System.IO.Stream V_8,
               valuetype [System.Runtime]System.Runtime.CompilerServices.TaskAwaiter`1<class [System.Runtime]System.IO.Stream> V_9,
               int32 V_10,
               valuetype [System.Runtime]System.Runtime.CompilerServices.ValueTaskAwaiter`1<int32> V_11,
               valuetype [System.Runtime]System.Threading.CancellationToken V_12,
               valuetype [System.Runtime]System.Threading.Tasks.ValueTask`1<int32> V_13,
               valuetype [System.Runtime]System.Nullable`1<int64> V_14,
               int64 V_15,
               valuetype [System.Runtime]System.Nullable`1<int64> V_16,
               valuetype [System.Runtime]System.Nullable`1<int64> V_17,
               class [System.Runtime]System.Exception V_18)
      IL_0000:  ldarg.0
      IL_0001:  ldfld      int32 AIRedirector.AIRedirector/'<UpdatePlugin>d__6'::'<>1__state'
      IL_0006:  stloc.0
      IL_0007:  ldarg.0
      IL_0008:  ldfld      class AIRedirector.AIRedirector AIRedirector.AIRedirector/'<UpdatePlugin>d__6'::'<>4__this'
      IL_000d:  stloc.1
      .try
      {
        IL_000e:  ldloc.0
        IL_000f:  ldc.i4.4
        IL_0010:  ble.un.s   IL_004d

        IL_0012:  ldarg.0
        IL_0013:  ldarg.0
        IL_0014:  ldfld      class [Spectre.Console]Spectre.Console.ProgressContext AIRedirector.AIRedirector/'<UpdatePlugin>d__6'::ctx
        IL_0019:  ldstr      "[["
        IL_001e:  ldloc.1
        IL_001f:  call       instance string AIRedirector.AIRedirector::get_Name()
        IL_0024:  ldstr      bytearray (5D 00 5D 00 20 00 F4 66 B0 65 )                   // ].]. ..f.e
        IL_0029:  call       string [System.Runtime]System.String::Concat(string,
                                                                          string,
                                                                          string)
        IL_002e:  ldc.i4.1
        IL_002f:  ldc.r8     100.
        IL_0038:  callvirt   instance class [Spectre.Console]Spectre.Console.ProgressTask [Spectre.Console]Spectre.Console.ProgressContext::AddTask(string,
                                                                                                                                                    bool,
                                                                                                                                                    float64)
        IL_003d:  stfld      class [Spectre.Console]Spectre.Console.ProgressTask AIRedirector.AIRedirector/'<UpdatePlugin>d__6'::'<progress>5__2'
        IL_0042:  ldarg.0
        IL_0043:  newobj     instance void [System.Net.Http]System.Net.Http.HttpClient::.ctor()
        IL_0048:  stfld      class [System.Net.Http]System.Net.Http.HttpClient AIRedirector.AIRedirector/'<UpdatePlugin>d__6'::'<client>5__3'
        IL_004d:  nop
        .try
        {
          IL_004e:  ldloc.0
          IL_004f:  brfalse.s  IL_00ae

          IL_0051:  ldloc.0
          IL_0052:  ldc.i4.1
          IL_0053:  sub
          IL_0054:  ldc.i4.3
          IL_0055:  ble.un     IL_00dc

          IL_005a:  ldarg.0
          IL_005b:  ldfld      class [System.Net.Http]System.Net.Http.HttpClient AIRedirector.AIRedirector/'<UpdatePlugin>d__6'::'<client>5__3'
          IL_0060:  ldstr      "https://api.github.com/repos/URA-Plugins/"
          IL_0065:  ldloc.1
          IL_0066:  call       instance string AIRedirector.AIRedirector::get_Name()
          IL_006b:  ldstr      "/releases/latest"
          IL_0070:  call       string [System.Runtime]System.String::Concat(string,
                                                                            string,
                                                                            string)
          IL_0075:  callvirt   instance class [System.Runtime]System.Threading.Tasks.Task`1<class [System.Net.Http]System.Net.Http.HttpResponseMessage> [System.Net.Http]System.Net.Http.HttpClient::GetAsync(string)
          IL_007a:  callvirt   instance valuetype [System.Runtime]System.Runtime.CompilerServices.TaskAwaiter`1<!0> class [System.Runtime]System.Threading.Tasks.Task`1<class [System.Net.Http]System.Net.Http.HttpResponseMessage>::GetAwaiter()
          IL_007f:  stloc.s    V_6
          IL_0081:  ldloca.s   V_6
          IL_0083:  call       instance bool valuetype [System.Runtime]System.Runtime.CompilerServices.TaskAwaiter`1<class [System.Net.Http]System.Net.Http.HttpResponseMessage>::get_IsCompleted()
          IL_0088:  brtrue.s   IL_00cb

          IL_008a:  ldarg.0
          IL_008b:  ldc.i4.0
          IL_008c:  dup
          IL_008d:  stloc.0
          IL_008e:  stfld      int32 AIRedirector.AIRedirector/'<UpdatePlugin>d__6'::'<>1__state'
          IL_0093:  ldarg.0
          IL_0094:  ldloc.s    V_6
          IL_0096:  stfld      valuetype [System.Runtime]System.Runtime.CompilerServices.TaskAwaiter`1<class [System.Net.Http]System.Net.Http.HttpResponseMessage> AIRedirector.AIRedirector/'<UpdatePlugin>d__6'::'<>u__1'
          IL_009b:  ldarg.0
          IL_009c:  ldflda     valuetype [System.Runtime]System.Runtime.CompilerServices.AsyncTaskMethodBuilder AIRedirector.AIRedirector/'<UpdatePlugin>d__6'::'<>t__builder'
          IL_00a1:  ldloca.s   V_6
          IL_00a3:  ldarg.0
          IL_00a4:  call       instance void [System.Runtime]System.Runtime.CompilerServices.AsyncTaskMethodBuilder::AwaitUnsafeOnCompleted<valuetype [System.Runtime]System.Runtime.CompilerServices.TaskAwaiter`1<class [System.Net.Http]System.Net.Http.HttpResponseMessage>,valuetype AIRedirector.AIRedirector/'<UpdatePlugin>d__6'>(!!0&,
                                                                                                                                                                                                                                                                                                                                          !!1&)
          IL_00a9:  leave      IL_0551

          IL_00ae:  ldarg.0
          IL_00af:  ldfld      valuetype [System.Runtime]System.Runtime.CompilerServices.TaskAwaiter`1<class [System.Net.Http]System.Net.Http.HttpResponseMessage> AIRedirector.AIRedirector/'<UpdatePlugin>d__6'::'<>u__1'
          IL_00b4:  stloc.s    V_6
          IL_00b6:  ldarg.0
          IL_00b7:  ldflda     valuetype [System.Runtime]System.Runtime.CompilerServices.TaskAwaiter`1<class [System.Net.Http]System.Net.Http.HttpResponseMessage> AIRedirector.AIRedirector/'<UpdatePlugin>d__6'::'<>u__1'
          IL_00bc:  initobj    valuetype [System.Runtime]System.Runtime.CompilerServices.TaskAwaiter`1<class [System.Net.Http]System.Net.Http.HttpResponseMessage>
          IL_00c2:  ldarg.0
          IL_00c3:  ldc.i4.m1
          IL_00c4:  dup
          IL_00c5:  stloc.0
          IL_00c6:  stfld      int32 AIRedirector.AIRedirector/'<UpdatePlugin>d__6'::'<>1__state'
          IL_00cb:  ldloca.s   V_6
          IL_00cd:  call       instance !0 valuetype [System.Runtime]System.Runtime.CompilerServices.TaskAwaiter`1<class [System.Net.Http]System.Net.Http.HttpResponseMessage>::GetResult()
          IL_00d2:  stloc.s    V_5
          IL_00d4:  ldarg.0
          IL_00d5:  ldloc.s    V_5
          IL_00d7:  stfld      class [System.Net.Http]System.Net.Http.HttpResponseMessage AIRedirector.AIRedirector/'<UpdatePlugin>d__6'::'<resp>5__4'
          IL_00dc:  nop
          .try
          {
            IL_00dd:  ldloc.0
            IL_00de:  ldc.i4.1
            IL_00df:  sub
            IL_00e0:  switch     ( 
                                  IL_0139,
                                  IL_026a,
                                  IL_0298,
                                  IL_0298)
            IL_00f5:  ldarg.0
            IL_00f6:  ldfld      class [System.Net.Http]System.Net.Http.HttpResponseMessage AIRedirector.AIRedirector/'<UpdatePlugin>d__6'::'<resp>5__4'
            IL_00fb:  callvirt   instance class [System.Net.Http]System.Net.Http.HttpContent [System.Net.Http]System.Net.Http.HttpResponseMessage::get_Content()
            IL_0100:  callvirt   instance class [System.Runtime]System.Threading.Tasks.Task`1<string> [System.Net.Http]System.Net.Http.HttpContent::ReadAsStringAsync()
            IL_0105:  callvirt   instance valuetype [System.Runtime]System.Runtime.CompilerServices.TaskAwaiter`1<!0> class [System.Runtime]System.Threading.Tasks.Task`1<string>::GetAwaiter()
            IL_010a:  stloc.s    V_7
            IL_010c:  ldloca.s   V_7
            IL_010e:  call       instance bool valuetype [System.Runtime]System.Runtime.CompilerServices.TaskAwaiter`1<string>::get_IsCompleted()
            IL_0113:  brtrue.s   IL_0156

            IL_0115:  ldarg.0
            IL_0116:  ldc.i4.1
            IL_0117:  dup
            IL_0118:  stloc.0
            IL_0119:  stfld      int32 AIRedirector.AIRedirector/'<UpdatePlugin>d__6'::'<>1__state'
            IL_011e:  ldarg.0
            IL_011f:  ldloc.s    V_7
            IL_0121:  stfld      valuetype [System.Runtime]System.Runtime.CompilerServices.TaskAwaiter`1<string> AIRedirector.AIRedirector/'<UpdatePlugin>d__6'::'<>u__2'
            IL_0126:  ldarg.0
            IL_0127:  ldflda     valuetype [System.Runtime]System.Runtime.CompilerServices.AsyncTaskMethodBuilder AIRedirector.AIRedirector/'<UpdatePlugin>d__6'::'<>t__builder'
            IL_012c:  ldloca.s   V_7
            IL_012e:  ldarg.0
            IL_012f:  call       instance void [System.Runtime]System.Runtime.CompilerServices.AsyncTaskMethodBuilder::AwaitUnsafeOnCompleted<valuetype [System.Runtime]System.Runtime.CompilerServices.TaskAwaiter`1<string>,valuetype AIRedirector.AIRedirector/'<UpdatePlugin>d__6'>(!!0&,
                                                                                                                                                                                                                                                                                        !!1&)
            IL_0134:  leave      IL_0551

            IL_0139:  ldarg.0
            IL_013a:  ldfld      valuetype [System.Runtime]System.Runtime.CompilerServices.TaskAwaiter`1<string> AIRedirector.AIRedirector/'<UpdatePlugin>d__6'::'<>u__2'
            IL_013f:  stloc.s    V_7
            IL_0141:  ldarg.0
            IL_0142:  ldflda     valuetype [System.Runtime]System.Runtime.CompilerServices.TaskAwaiter`1<string> AIRedirector.AIRedirector/'<UpdatePlugin>d__6'::'<>u__2'
            IL_0147:  initobj    valuetype [System.Runtime]System.Runtime.CompilerServices.TaskAwaiter`1<string>
            IL_014d:  ldarg.0
            IL_014e:  ldc.i4.m1
            IL_014f:  dup
            IL_0150:  stloc.0
            IL_0151:  stfld      int32 AIRedirector.AIRedirector/'<UpdatePlugin>d__6'::'<>1__state'
            IL_0156:  ldloca.s   V_7
            IL_0158:  call       instance !0 valuetype [System.Runtime]System.Runtime.CompilerServices.TaskAwaiter`1<string>::GetResult()
            IL_015d:  call       class [Newtonsoft.Json]Newtonsoft.Json.Linq.JObject [Newtonsoft.Json]Newtonsoft.Json.Linq.JObject::Parse(string)
            IL_0162:  stloc.2
            IL_0163:  ldstr      "v"
            IL_0168:  ldloc.1
            IL_0169:  callvirt   instance class [System.Runtime]System.Version [UmamusumeResponseAnalyzer]UmamusumeResponseAnalyzer.Plugin.IPlugin::get_Version()
            IL_016e:  callvirt   instance string [System.Runtime]System.Object::ToString()
            IL_0173:  call       string [System.Runtime]System.String::Concat(string,
                                                                              string)
            IL_0178:  ldstr      "v"
            IL_017d:  ldloc.2
            IL_017e:  ldstr      "tag_name"
            IL_0183:  callvirt   instance class [Newtonsoft.Json]Newtonsoft.Json.Linq.JToken [Newtonsoft.Json]Newtonsoft.Json.Linq.JObject::get_Item(string)
            IL_0188:  dup
            IL_0189:  brtrue.s   IL_018f

            IL_018b:  pop
            IL_018c:  ldnull
            IL_018d:  br.s       IL_0194

            IL_018f:  callvirt   instance string [System.Runtime]System.Object::ToString()
            IL_0194:  call       string [System.Runtime]System.String::Concat(string,
                                                                              string)
            IL_0199:  callvirt   instance bool [System.Runtime]System.String::Equals(string)
            IL_019e:  brfalse.s  IL_01c6

            IL_01a0:  ldarg.0
            IL_01a1:  ldfld      class [Spectre.Console]Spectre.Console.ProgressTask AIRedirector.AIRedirector/'<UpdatePlugin>d__6'::'<progress>5__2'
            IL_01a6:  ldarg.0
            IL_01a7:  ldfld      class [Spectre.Console]Spectre.Console.ProgressTask AIRedirector.AIRedirector/'<UpdatePlugin>d__6'::'<progress>5__2'
            IL_01ac:  callvirt   instance float64 [Spectre.Console]Spectre.Console.ProgressTask::get_MaxValue()
            IL_01b1:  callvirt   instance void [Spectre.Console]Spectre.Console.ProgressTask::Increment(float64)
            IL_01b6:  ldarg.0
            IL_01b7:  ldfld      class [Spectre.Console]Spectre.Console.ProgressTask AIRedirector.AIRedirector/'<UpdatePlugin>d__6'::'<progress>5__2'
            IL_01bc:  callvirt   instance void [Spectre.Console]Spectre.Console.ProgressTask::StopTask()
            IL_01c1:  leave      IL_0514

            IL_01c6:  ldarg.0
            IL_01c7:  ldfld      class [Spectre.Console]Spectre.Console.ProgressTask AIRedirector.AIRedirector/'<UpdatePlugin>d__6'::'<progress>5__2'
            IL_01cc:  ldc.r8     25.
            IL_01d5:  callvirt   instance void [Spectre.Console]Spectre.Console.ProgressTask::Increment(float64)
            IL_01da:  ldloc.2
            IL_01db:  ldstr      "assets"
            IL_01e0:  callvirt   instance class [Newtonsoft.Json]Newtonsoft.Json.Linq.JToken [Newtonsoft.Json]Newtonsoft.Json.Linq.JObject::get_Item(string)
            IL_01e5:  ldc.i4.0
            IL_01e6:  box        [System.Runtime]System.Int32
            IL_01eb:  callvirt   instance class [Newtonsoft.Json]Newtonsoft.Json.Linq.JToken [Newtonsoft.Json]Newtonsoft.Json.Linq.JToken::get_Item(object)
            IL_01f0:  ldstr      "browser_download_url"
            IL_01f5:  callvirt   instance class [Newtonsoft.Json]Newtonsoft.Json.Linq.JToken [Newtonsoft.Json]Newtonsoft.Json.Linq.JToken::get_Item(object)
            IL_01fa:  callvirt   instance string [System.Runtime]System.Object::ToString()
            IL_01ff:  stloc.3
            IL_0200:  call       class [UmamusumeResponseAnalyzer]UmamusumeResponseAnalyzer.UpdaterConfig [UmamusumeResponseAnalyzer]UmamusumeResponseAnalyzer.Config::get_Updater()
            IL_0205:  callvirt   instance bool [UmamusumeResponseAnalyzer]UmamusumeResponseAnalyzer.UpdaterConfig::get_IsGithubBlocked()
            IL_020a:  brfalse.s  IL_0229

            IL_020c:  call       class [UmamusumeResponseAnalyzer]UmamusumeResponseAnalyzer.UpdaterConfig [UmamusumeResponseAnalyzer]UmamusumeResponseAnalyzer.Config::get_Updater()
            IL_0211:  callvirt   instance bool [UmamusumeResponseAnalyzer]UmamusumeResponseAnalyzer.UpdaterConfig::get_ForceUseGithubToUpdate()
            IL_0216:  brtrue.s   IL_0229

            IL_0218:  ldloc.3
            IL_0219:  ldstr      "https://"
            IL_021e:  ldstr      "https://gh.shuise.dev/"
            IL_0223:  callvirt   instance string [System.Runtime]System.String::Replace(string,
                                                                                        string)
            IL_0228:  stloc.3
            IL_0229:  ldarg.0
            IL_022a:  ldfld      class [System.Net.Http]System.Net.Http.HttpClient AIRedirector.AIRedirector/'<UpdatePlugin>d__6'::'<client>5__3'
            IL_022f:  ldloc.3
            IL_0230:  ldc.i4.1
            IL_0231:  callvirt   instance class [System.Runtime]System.Threading.Tasks.Task`1<class [System.Net.Http]System.Net.Http.HttpResponseMessage> [System.Net.Http]System.Net.Http.HttpClient::GetAsync(string,
                                                                                                                                                                                                                valuetype [System.Net.Http]System.Net.Http.HttpCompletionOption)
            IL_0236:  callvirt   instance valuetype [System.Runtime]System.Runtime.CompilerServices.TaskAwaiter`1<!0> class [System.Runtime]System.Threading.Tasks.Task`1<class [System.Net.Http]System.Net.Http.HttpResponseMessage>::GetAwaiter()
            IL_023b:  stloc.s    V_6
            IL_023d:  ldloca.s   V_6
            IL_023f:  call       instance bool valuetype [System.Runtime]System.Runtime.CompilerServices.TaskAwaiter`1<class [System.Net.Http]System.Net.Http.HttpResponseMessage>::get_IsCompleted()
            IL_0244:  brtrue.s   IL_0287

            IL_0246:  ldarg.0
            IL_0247:  ldc.i4.2
            IL_0248:  dup
            IL_0249:  stloc.0
            IL_024a:  stfld      int32 AIRedirector.AIRedirector/'<UpdatePlugin>d__6'::'<>1__state'
            IL_024f:  ldarg.0
            IL_0250:  ldloc.s    V_6
            IL_0252:  stfld      valuetype [System.Runtime]System.Runtime.CompilerServices.TaskAwaiter`1<class [System.Net.Http]System.Net.Http.HttpResponseMessage> AIRedirector.AIRedirector/'<UpdatePlugin>d__6'::'<>u__1'
            IL_0257:  ldarg.0
            IL_0258:  ldflda     valuetype [System.Runtime]System.Runtime.CompilerServices.AsyncTaskMethodBuilder AIRedirector.AIRedirector/'<UpdatePlugin>d__6'::'<>t__builder'
            IL_025d:  ldloca.s   V_6
            IL_025f:  ldarg.0
            IL_0260:  call       instance void [System.Runtime]System.Runtime.CompilerServices.AsyncTaskMethodBuilder::AwaitUnsafeOnCompleted<valuetype [System.Runtime]System.Runtime.CompilerServices.TaskAwaiter`1<class [System.Net.Http]System.Net.Http.HttpResponseMessage>,valuetype AIRedirector.AIRedirector/'<UpdatePlugin>d__6'>(!!0&,
                                                                                                                                                                                                                                                                                                                                            !!1&)
            IL_0265:  leave      IL_0551

            IL_026a:  ldarg.0
            IL_026b:  ldfld      valuetype [System.Runtime]System.Runtime.CompilerServices.TaskAwaiter`1<class [System.Net.Http]System.Net.Http.HttpResponseMessage> AIRedirector.AIRedirector/'<UpdatePlugin>d__6'::'<>u__1'
            IL_0270:  stloc.s    V_6
            IL_0272:  ldarg.0
            IL_0273:  ldflda     valuetype [System.Runtime]System.Runtime.CompilerServices.TaskAwaiter`1<class [System.Net.Http]System.Net.Http.HttpResponseMessage> AIRedirector.AIRedirector/'<UpdatePlugin>d__6'::'<>u__1'
            IL_0278:  initobj    valuetype [System.Runtime]System.Runtime.CompilerServices.TaskAwaiter`1<class [System.Net.Http]System.Net.Http.HttpResponseMessage>
            IL_027e:  ldarg.0
            IL_027f:  ldc.i4.m1
            IL_0280:  dup
            IL_0281:  stloc.0
            IL_0282:  stfld      int32 AIRedirector.AIRedirector/'<UpdatePlugin>d__6'::'<>1__state'
            IL_0287:  ldloca.s   V_6
            IL_0289:  call       instance !0 valuetype [System.Runtime]System.Runtime.CompilerServices.TaskAwaiter`1<class [System.Net.Http]System.Net.Http.HttpResponseMessage>::GetResult()
            IL_028e:  stloc.s    V_5
            IL_0290:  ldarg.0
            IL_0291:  ldloc.s    V_5
            IL_0293:  stfld      class [System.Net.Http]System.Net.Http.HttpResponseMessage AIRedirector.AIRedirector/'<UpdatePlugin>d__6'::'<msg>5__5'
            IL_0298:  nop
            .try
            {
              IL_0299:  ldloc.0
              IL_029a:  ldc.i4.3
              IL_029b:  beq.s      IL_02e5

              IL_029d:  ldloc.0
              IL_029e:  ldc.i4.4
              IL_029f:  beq.s      IL_0313

              IL_02a1:  ldarg.0
              IL_02a2:  ldfld      class [System.Net.Http]System.Net.Http.HttpResponseMessage AIRedirector.AIRedirector/'<UpdatePlugin>d__6'::'<msg>5__5'
              IL_02a7:  callvirt   instance class [System.Net.Http]System.Net.Http.HttpContent [System.Net.Http]System.Net.Http.HttpResponseMessage::get_Content()
              IL_02ac:  callvirt   instance class [System.Runtime]System.Threading.Tasks.Task`1<class [System.Runtime]System.IO.Stream> [System.Net.Http]System.Net.Http.HttpContent::ReadAsStreamAsync()
              IL_02b1:  callvirt   instance valuetype [System.Runtime]System.Runtime.CompilerServices.TaskAwaiter`1<!0> class [System.Runtime]System.Threading.Tasks.Task`1<class [System.Runtime]System.IO.Stream>::GetAwaiter()
              IL_02b6:  stloc.s    V_9
              IL_02b8:  ldloca.s   V_9
              IL_02ba:  call       instance bool valuetype [System.Runtime]System.Runtime.CompilerServices.TaskAwaiter`1<class [System.Runtime]System.IO.Stream>::get_IsCompleted()
              IL_02bf:  brtrue.s   IL_0302

              IL_02c1:  ldarg.0
              IL_02c2:  ldc.i4.3
              IL_02c3:  dup
              IL_02c4:  stloc.0
              IL_02c5:  stfld      int32 AIRedirector.AIRedirector/'<UpdatePlugin>d__6'::'<>1__state'
              IL_02ca:  ldarg.0
              IL_02cb:  ldloc.s    V_9
              IL_02cd:  stfld      valuetype [System.Runtime]System.Runtime.CompilerServices.TaskAwaiter`1<class [System.Runtime]System.IO.Stream> AIRedirector.AIRedirector/'<UpdatePlugin>d__6'::'<>u__3'
              IL_02d2:  ldarg.0
              IL_02d3:  ldflda     valuetype [System.Runtime]System.Runtime.CompilerServices.AsyncTaskMethodBuilder AIRedirector.AIRedirector/'<UpdatePlugin>d__6'::'<>t__builder'
              IL_02d8:  ldloca.s   V_9
              IL_02da:  ldarg.0
              IL_02db:  call       instance void [System.Runtime]System.Runtime.CompilerServices.AsyncTaskMethodBuilder::AwaitUnsafeOnCompleted<valuetype [System.Runtime]System.Runtime.CompilerServices.TaskAwaiter`1<class [System.Runtime]System.IO.Stream>,valuetype AIRedirector.AIRedirector/'<UpdatePlugin>d__6'>(!!0&,
                                                                                                                                                                                                                                                                                                                          !!1&)
              IL_02e0:  leave      IL_0551

              IL_02e5:  ldarg.0
              IL_02e6:  ldfld      valuetype [System.Runtime]System.Runtime.CompilerServices.TaskAwaiter`1<class [System.Runtime]System.IO.Stream> AIRedirector.AIRedirector/'<UpdatePlugin>d__6'::'<>u__3'
              IL_02eb:  stloc.s    V_9
              IL_02ed:  ldarg.0
              IL_02ee:  ldflda     valuetype [System.Runtime]System.Runtime.CompilerServices.TaskAwaiter`1<class [System.Runtime]System.IO.Stream> AIRedirector.AIRedirector/'<UpdatePlugin>d__6'::'<>u__3'
              IL_02f3:  initobj    valuetype [System.Runtime]System.Runtime.CompilerServices.TaskAwaiter`1<class [System.Runtime]System.IO.Stream>
              IL_02f9:  ldarg.0
              IL_02fa:  ldc.i4.m1
              IL_02fb:  dup
              IL_02fc:  stloc.0
              IL_02fd:  stfld      int32 AIRedirector.AIRedirector/'<UpdatePlugin>d__6'::'<>1__state'
              IL_0302:  ldloca.s   V_9
              IL_0304:  call       instance !0 valuetype [System.Runtime]System.Runtime.CompilerServices.TaskAwaiter`1<class [System.Runtime]System.IO.Stream>::GetResult()
              IL_0309:  stloc.s    V_8
              IL_030b:  ldarg.0
              IL_030c:  ldloc.s    V_8
              IL_030e:  stfld      class [System.Runtime]System.IO.Stream AIRedirector.AIRedirector/'<UpdatePlugin>d__6'::'<stream>5__6'
              IL_0313:  nop
              .try
              {
                IL_0314:  ldloc.0
                IL_0315:  ldc.i4.4
                IL_0316:  beq.s      IL_0380

                IL_0318:  ldarg.0
                IL_0319:  ldc.i4     0x2000
                IL_031e:  newarr     [System.Runtime]System.Byte
                IL_0323:  stfld      uint8[] AIRedirector.AIRedirector/'<UpdatePlugin>d__6'::'<buffer>5__7'
                IL_0328:  ldarg.0
                IL_0329:  ldfld      class [System.Runtime]System.IO.Stream AIRedirector.AIRedirector/'<UpdatePlugin>d__6'::'<stream>5__6'
                IL_032e:  ldarg.0
                IL_032f:  ldfld      uint8[] AIRedirector.AIRedirector/'<UpdatePlugin>d__6'::'<buffer>5__7'
                IL_0334:  call       valuetype [System.Runtime]System.Memory`1<!0> valuetype [System.Runtime]System.Memory`1<uint8>::op_Implicit(!0[])
                IL_0339:  ldloca.s   V_12
                IL_033b:  initobj    [System.Runtime]System.Threading.CancellationToken
                IL_0341:  ldloc.s    V_12
                IL_0343:  callvirt   instance valuetype [System.Runtime]System.Threading.Tasks.ValueTask`1<int32> [System.Runtime]System.IO.Stream::ReadAsync(valuetype [System.Runtime]System.Memory`1<uint8>,
                                                                                                                                                              valuetype [System.Runtime]System.Threading.CancellationToken)
                IL_0348:  stloc.s    V_13
                IL_034a:  ldloca.s   V_13
                IL_034c:  call       instance valuetype [System.Runtime]System.Runtime.CompilerServices.ValueTaskAwaiter`1<!0> valuetype [System.Runtime]System.Threading.Tasks.ValueTask`1<int32>::GetAwaiter()
                IL_0351:  stloc.s    V_11
                IL_0353:  ldloca.s   V_11
                IL_0355:  call       instance bool valuetype [System.Runtime]System.Runtime.CompilerServices.ValueTaskAwaiter`1<int32>::get_IsCompleted()
                IL_035a:  brtrue.s   IL_039d

                IL_035c:  ldarg.0
                IL_035d:  ldc.i4.4
                IL_035e:  dup
                IL_035f:  stloc.0
                IL_0360:  stfld      int32 AIRedirector.AIRedirector/'<UpdatePlugin>d__6'::'<>1__state'
                IL_0365:  ldarg.0
                IL_0366:  ldloc.s    V_11
                IL_0368:  stfld      valuetype [System.Runtime]System.Runtime.CompilerServices.ValueTaskAwaiter`1<int32> AIRedirector.AIRedirector/'<UpdatePlugin>d__6'::'<>u__4'
                IL_036d:  ldarg.0
                IL_036e:  ldflda     valuetype [System.Runtime]System.Runtime.CompilerServices.AsyncTaskMethodBuilder AIRedirector.AIRedirector/'<UpdatePlugin>d__6'::'<>t__builder'
                IL_0373:  ldloca.s   V_11
                IL_0375:  ldarg.0
                IL_0376:  call       instance void [System.Runtime]System.Runtime.CompilerServices.AsyncTaskMethodBuilder::AwaitUnsafeOnCompleted<valuetype [System.Runtime]System.Runtime.CompilerServices.ValueTaskAwaiter`1<int32>,valuetype AIRedirector.AIRedirector/'<UpdatePlugin>d__6'>(!!0&,
                                                                                                                                                                                                                                                                                                !!1&)
                IL_037b:  leave      IL_0551

                IL_0380:  ldarg.0
                IL_0381:  ldfld      valuetype [System.Runtime]System.Runtime.CompilerServices.ValueTaskAwaiter`1<int32> AIRedirector.AIRedirector/'<UpdatePlugin>d__6'::'<>u__4'
                IL_0386:  stloc.s    V_11
                IL_0388:  ldarg.0
                IL_0389:  ldflda     valuetype [System.Runtime]System.Runtime.CompilerServices.ValueTaskAwaiter`1<int32> AIRedirector.AIRedirector/'<UpdatePlugin>d__6'::'<>u__4'
                IL_038e:  initobj    valuetype [System.Runtime]System.Runtime.CompilerServices.ValueTaskAwaiter`1<int32>
                IL_0394:  ldarg.0
                IL_0395:  ldc.i4.m1
                IL_0396:  dup
                IL_0397:  stloc.0
                IL_0398:  stfld      int32 AIRedirector.AIRedirector/'<UpdatePlugin>d__6'::'<>1__state'
                IL_039d:  ldloca.s   V_11
                IL_039f:  call       instance !0 valuetype [System.Runtime]System.Runtime.CompilerServices.ValueTaskAwaiter`1<int32>::GetResult()
                IL_03a4:  stloc.s    V_10
                IL_03a6:  ldloc.s    V_10
                IL_03a8:  brfalse.s  IL_0418

                IL_03aa:  ldarg.0
                IL_03ab:  ldfld      class [Spectre.Console]Spectre.Console.ProgressTask AIRedirector.AIRedirector/'<UpdatePlugin>d__6'::'<progress>5__2'
                IL_03b0:  ldloc.s    V_10
                IL_03b2:  conv.i8
                IL_03b3:  stloc.s    V_15
                IL_03b5:  ldarg.0
                IL_03b6:  ldfld      class [System.Net.Http]System.Net.Http.HttpResponseMessage AIRedirector.AIRedirector/'<UpdatePlugin>d__6'::'<msg>5__5'
                IL_03bb:  callvirt   instance class [System.Net.Http]System.Net.Http.HttpContent [System.Net.Http]System.Net.Http.HttpResponseMessage::get_Content()
                IL_03c0:  callvirt   instance class [System.Net.Http]System.Net.Http.Headers.HttpContentHeaders [System.Net.Http]System.Net.Http.HttpContent::get_Headers()
                IL_03c5:  callvirt   instance valuetype [System.Runtime]System.Nullable`1<int64> [System.Net.Http]System.Net.Http.Headers.HttpContentHeaders::get_ContentLength()
                IL_03ca:  stloc.s    V_16
                IL_03cc:  ldloca.s   V_16
                IL_03ce:  call       instance bool valuetype [System.Runtime]System.Nullable`1<int64>::get_HasValue()
                IL_03d3:  brtrue.s   IL_03e1

                IL_03d5:  ldloca.s   V_17
                IL_03d7:  initobj    valuetype [System.Runtime]System.Nullable`1<int64>
                IL_03dd:  ldloc.s    V_17
                IL_03df:  br.s       IL_03f0

                IL_03e1:  ldloc.s    V_15
                IL_03e3:  ldloca.s   V_16
                IL_03e5:  call       instance !0 valuetype [System.Runtime]System.Nullable`1<int64>::GetValueOrDefault()
                IL_03ea:  div
                IL_03eb:  newobj     instance void valuetype [System.Runtime]System.Nullable`1<int64>::.ctor(!0)
                IL_03f0:  stloc.s    V_14
                IL_03f2:  ldloca.s   V_14
                IL_03f4:  call       instance bool valuetype [System.Runtime]System.Nullable`1<int64>::get_HasValue()
                IL_03f9:  brtrue.s   IL_0406

                IL_03fb:  ldc.r8     0.5
                IL_0404:  br.s       IL_040e

                IL_0406:  ldloca.s   V_14
                IL_0408:  call       instance !0 valuetype [System.Runtime]System.Nullable`1<int64>::GetValueOrDefault()
                IL_040d:  conv.r8
                IL_040e:  callvirt   instance void [Spectre.Console]Spectre.Console.ProgressTask::Increment(float64)
                IL_0413:  br         IL_0328

                IL_0418:  ldarg.0
                IL_0419:  ldfld      class [System.Runtime]System.IO.Stream AIRedirector.AIRedirector/'<UpdatePlugin>d__6'::'<stream>5__6'
                IL_041e:  newobj     instance void [System.IO.Compression]System.IO.Compression.ZipArchive::.ctor(class [System.Runtime]System.IO.Stream)
                IL_0423:  stloc.s    V_4
                .try
                {
                  IL_0425:  ldloc.s    V_4
                  IL_0427:  ldstr      "Plugins"
                  IL_042c:  ldloc.1
                  IL_042d:  call       instance string AIRedirector.AIRedirector::get_Name()
                  IL_0432:  call       string [System.Runtime]System.IO.Path::Combine(string,
                                                                                      string)
                  IL_0437:  ldc.i4.1
                  IL_0438:  call       void [System.IO.Compression.ZipFile]System.IO.Compression.ZipFileExtensions::ExtractToDirectory(class [System.IO.Compression]System.IO.Compression.ZipArchive,
                                                                                                                                       string,
                                                                                                                                       bool)
                  IL_043d:  ldarg.0
                  IL_043e:  ldfld      class [Spectre.Console]Spectre.Console.ProgressTask AIRedirector.AIRedirector/'<UpdatePlugin>d__6'::'<progress>5__2'
                  IL_0443:  ldc.r8     25.
                  IL_044c:  callvirt   instance void [Spectre.Console]Spectre.Console.ProgressTask::Increment(float64)
                  IL_0451:  ldarg.0
                  IL_0452:  ldfld      class [Spectre.Console]Spectre.Console.ProgressTask AIRedirector.AIRedirector/'<UpdatePlugin>d__6'::'<progress>5__2'
                  IL_0457:  callvirt   instance void [Spectre.Console]Spectre.Console.ProgressTask::StopTask()
                  IL_045c:  leave      IL_0514

                }  // end .try
                finally
                {
                  IL_0461:  ldloc.0
                  IL_0462:  ldc.i4.0
                  IL_0463:  bge.s      IL_0470

                  IL_0465:  ldloc.s    V_4
                  IL_0467:  brfalse.s  IL_0470

                  IL_0469:  ldloc.s    V_4
                  IL_046b:  callvirt   instance void [System.Runtime]System.IDisposable::Dispose()
                  IL_0470:  endfinally
                }  // end handler
              }  // end .try
              finally
              {
                IL_0471:  ldloc.0
                IL_0472:  ldc.i4.0
                IL_0473:  bge.s      IL_0488

                IL_0475:  ldarg.0
                IL_0476:  ldfld      class [System.Runtime]System.IO.Stream AIRedirector.AIRedirector/'<UpdatePlugin>d__6'::'<stream>5__6'
                IL_047b:  brfalse.s  IL_0488

                IL_047d:  ldarg.0
                IL_047e:  ldfld      class [System.Runtime]System.IO.Stream AIRedirector.AIRedirector/'<UpdatePlugin>d__6'::'<stream>5__6'
                IL_0483:  callvirt   instance void [System.Runtime]System.IDisposable::Dispose()
                IL_0488:  endfinally
              }  // end handler
            }  // end .try
            finally
            {
              IL_0489:  ldloc.0
              IL_048a:  ldc.i4.0
              IL_048b:  bge.s      IL_04a0

              IL_048d:  ldarg.0
              IL_048e:  ldfld      class [System.Net.Http]System.Net.Http.HttpResponseMessage AIRedirector.AIRedirector/'<UpdatePlugin>d__6'::'<msg>5__5'
              IL_0493:  brfalse.s  IL_04a0

              IL_0495:  ldarg.0
              IL_0496:  ldfld      class [System.Net.Http]System.Net.Http.HttpResponseMessage AIRedirector.AIRedirector/'<UpdatePlugin>d__6'::'<msg>5__5'
              IL_049b:  callvirt   instance void [System.Runtime]System.IDisposable::Dispose()
              IL_04a0:  endfinally
            }  // end handler
          }  // end .try
          finally
          {
            IL_04a1:  ldloc.0
            IL_04a2:  ldc.i4.0
            IL_04a3:  bge.s      IL_04b8

            IL_04a5:  ldarg.0
            IL_04a6:  ldfld      class [System.Net.Http]System.Net.Http.HttpResponseMessage AIRedirector.AIRedirector/'<UpdatePlugin>d__6'::'<resp>5__4'
            IL_04ab:  brfalse.s  IL_04b8

            IL_04ad:  ldarg.0
            IL_04ae:  ldfld      class [System.Net.Http]System.Net.Http.HttpResponseMessage AIRedirector.AIRedirector/'<UpdatePlugin>d__6'::'<resp>5__4'
            IL_04b3:  callvirt   instance void [System.Runtime]System.IDisposable::Dispose()
            IL_04b8:  endfinally
          }  // end handler
        }  // end .try
        finally
        {
          IL_04b9:  ldloc.0
          IL_04ba:  ldc.i4.0
          IL_04bb:  bge.s      IL_04d0

          IL_04bd:  ldarg.0
          IL_04be:  ldfld      class [System.Net.Http]System.Net.Http.HttpClient AIRedirector.AIRedirector/'<UpdatePlugin>d__6'::'<client>5__3'
          IL_04c3:  brfalse.s  IL_04d0

          IL_04c5:  ldarg.0
          IL_04c6:  ldfld      class [System.Net.Http]System.Net.Http.HttpClient AIRedirector.AIRedirector/'<UpdatePlugin>d__6'::'<client>5__3'
          IL_04cb:  callvirt   instance void [System.Runtime]System.IDisposable::Dispose()
          IL_04d0:  endfinally
        }  // end handler
      }  // end .try
      catch [System.Runtime]System.Exception 
      {
        IL_04d1:  stloc.s    V_18
        IL_04d3:  ldarg.0
        IL_04d4:  ldc.i4.s   -2
        IL_04d6:  stfld      int32 AIRedirector.AIRedirector/'<UpdatePlugin>d__6'::'<>1__state'
        IL_04db:  ldarg.0
        IL_04dc:  ldnull
        IL_04dd:  stfld      class [Spectre.Console]Spectre.Console.ProgressTask AIRedirector.AIRedirector/'<UpdatePlugin>d__6'::'<progress>5__2'
        IL_04e2:  ldarg.0
        IL_04e3:  ldnull
        IL_04e4:  stfld      class [System.Net.Http]System.Net.Http.HttpClient AIRedirector.AIRedirector/'<UpdatePlugin>d__6'::'<client>5__3'
        IL_04e9:  ldarg.0
        IL_04ea:  ldnull
        IL_04eb:  stfld      class [System.Net.Http]System.Net.Http.HttpResponseMessage AIRedirector.AIRedirector/'<UpdatePlugin>d__6'::'<resp>5__4'
        IL_04f0:  ldarg.0
        IL_04f1:  ldnull
        IL_04f2:  stfld      class [System.Net.Http]System.Net.Http.HttpResponseMessage AIRedirector.AIRedirector/'<UpdatePlugin>d__6'::'<msg>5__5'
        IL_04f7:  ldarg.0
        IL_04f8:  ldnull
        IL_04f9:  stfld      class [System.Runtime]System.IO.Stream AIRedirector.AIRedirector/'<UpdatePlugin>d__6'::'<stream>5__6'
        IL_04fe:  ldarg.0
        IL_04ff:  ldnull
        IL_0500:  stfld      uint8[] AIRedirector.AIRedirector/'<UpdatePlugin>d__6'::'<buffer>5__7'
        IL_0505:  ldarg.0
        IL_0506:  ldflda     valuetype [System.Runtime]System.Runtime.CompilerServices.AsyncTaskMethodBuilder AIRedirector.AIRedirector/'<UpdatePlugin>d__6'::'<>t__builder'
        IL_050b:  ldloc.s    V_18
        IL_050d:  call       instance void [System.Runtime]System.Runtime.CompilerServices.AsyncTaskMethodBuilder::SetException(class [System.Runtime]System.Exception)
        IL_0512:  leave.s    IL_0551

      }  // end handler
      IL_0514:  ldarg.0
      IL_0515:  ldc.i4.s   -2
      IL_0517:  stfld      int32 AIRedirector.AIRedirector/'<UpdatePlugin>d__6'::'<>1__state'
      IL_051c:  ldarg.0
      IL_051d:  ldnull
      IL_051e:  stfld      class [Spectre.Console]Spectre.Console.ProgressTask AIRedirector.AIRedirector/'<UpdatePlugin>d__6'::'<progress>5__2'
      IL_0523:  ldarg.0
      IL_0524:  ldnull
      IL_0525:  stfld      class [System.Net.Http]System.Net.Http.HttpClient AIRedirector.AIRedirector/'<UpdatePlugin>d__6'::'<client>5__3'
      IL_052a:  ldarg.0
      IL_052b:  ldnull
      IL_052c:  stfld      class [System.Net.Http]System.Net.Http.HttpResponseMessage AIRedirector.AIRedirector/'<UpdatePlugin>d__6'::'<resp>5__4'
      IL_0531:  ldarg.0
      IL_0532:  ldnull
      IL_0533:  stfld      class [System.Net.Http]System.Net.Http.HttpResponseMessage AIRedirector.AIRedirector/'<UpdatePlugin>d__6'::'<msg>5__5'
      IL_0538:  ldarg.0
      IL_0539:  ldnull
      IL_053a:  stfld      class [System.Runtime]System.IO.Stream AIRedirector.AIRedirector/'<UpdatePlugin>d__6'::'<stream>5__6'
      IL_053f:  ldarg.0
      IL_0540:  ldnull
      IL_0541:  stfld      uint8[] AIRedirector.AIRedirector/'<UpdatePlugin>d__6'::'<buffer>5__7'
      IL_0546:  ldarg.0
      IL_0547:  ldflda     valuetype [System.Runtime]System.Runtime.CompilerServices.AsyncTaskMethodBuilder AIRedirector.AIRedirector/'<UpdatePlugin>d__6'::'<>t__builder'
      IL_054c:  call       instance void [System.Runtime]System.Runtime.CompilerServices.AsyncTaskMethodBuilder::SetResult()
      IL_0551:  ret
    } // end of method '<UpdatePlugin>d__6'::MoveNext

    .method private hidebysig newslot virtual final 
            instance void  SetStateMachine(class [System.Runtime]System.Runtime.CompilerServices.IAsyncStateMachine stateMachine) cil managed
    {
      .custom instance void [System.Runtime]System.Diagnostics.DebuggerHiddenAttribute::.ctor() = ( 01 00 00 00 ) 
      .override [System.Runtime]System.Runtime.CompilerServices.IAsyncStateMachine::SetStateMachine
      // Code size       13 (0xd)
      .maxstack  8
      IL_0000:  ldarg.0
      IL_0001:  ldflda     valuetype [System.Runtime]System.Runtime.CompilerServices.AsyncTaskMethodBuilder AIRedirector.AIRedirector/'<UpdatePlugin>d__6'::'<>t__builder'
      IL_0006:  ldarg.1
      IL_0007:  call       instance void [System.Runtime]System.Runtime.CompilerServices.AsyncTaskMethodBuilder::SetStateMachine(class [System.Runtime]System.Runtime.CompilerServices.IAsyncStateMachine)
      IL_000c:  ret
    } // end of method '<UpdatePlugin>d__6'::SetStateMachine

  } // end of class '<UpdatePlugin>d__6'

  .field private bool '<UAF>k__BackingField'
  .custom instance void [System.Runtime]System.Runtime.CompilerServices.CompilerGeneratedAttribute::.ctor() = ( 01 00 00 00 ) 
  .field private string '<UAF_Path>k__BackingField'
  .custom instance void [System.Runtime]System.Runtime.CompilerServices.CompilerGeneratedAttribute::.ctor() = ( 01 00 00 00 ) 
  .field private bool '<Cook>k__BackingField'
  .custom instance void [System.Runtime]System.Runtime.CompilerServices.CompilerGeneratedAttribute::.ctor() = ( 01 00 00 00 ) 
  .field private string '<Cook_Path>k__BackingField'
  .custom instance void [System.Runtime]System.Runtime.CompilerServices.CompilerGeneratedAttribute::.ctor() = ( 01 00 00 00 ) 
  .field private bool '<Mecha>k__BackingField'
  .custom instance void [System.Runtime]System.Runtime.CompilerServices.CompilerGeneratedAttribute::.ctor() = ( 01 00 00 00 ) 
  .field private string '<Mecha_Path>k__BackingField'
  .custom instance void [System.Runtime]System.Runtime.CompilerServices.CompilerGeneratedAttribute::.ctor() = ( 01 00 00 00 ) 
  .field private bool '<Legend>k__BackingField'
  .custom instance void [System.Runtime]System.Runtime.CompilerServices.CompilerGeneratedAttribute::.ctor() = ( 01 00 00 00 ) 
  .field private string '<Legend_Path>k__BackingField'
  .custom instance void [System.Runtime]System.Runtime.CompilerServices.CompilerGeneratedAttribute::.ctor() = ( 01 00 00 00 ) 
  .field private initonly class [System.Collections]System.Collections.Generic.Dictionary`2<valuetype [UmamusumeResponseAnalyzer]UmamusumeResponseAnalyzer.ScenarioType,class [System.Diagnostics.Process]System.Diagnostics.Process> Processes
  .field private class AIRedirector.ChildProcessManager _childProcessManager
  .custom instance void [System.Runtime]System.Runtime.CompilerServices.NullableAttribute::.ctor(uint8) = ( 01 00 02 00 00 ) 
  .method public hidebysig newslot specialname virtual final 
          instance string  get_Name() cil managed
  {
    // Code size       6 (0x6)
    .maxstack  8
    IL_0000:  ldstr      "AIRedirector"
    IL_0005:  ret
  } // end of method AIRedirector::get_Name

  .method public hidebysig newslot specialname virtual final 
          instance string  get_Author() cil managed
  {
    // Code size       6 (0x6)
    .maxstack  8
    IL_0000:  ldstr      bytearray (BB 79 AB 62 )                                     // .y.b
    IL_0005:  ret
  } // end of method AIRedirector::get_Author

  .method public hidebysig newslot specialname virtual final 
          instance string[]  get_Targets() cil managed
  {
    // Code size       6 (0x6)
    .maxstack  8
    IL_0000:  call       !!0[] [System.Runtime]System.Array::Empty<string>()
    IL_0005:  ret
  } // end of method AIRedirector::get_Targets

  .method public hidebysig newslot virtual final 
          instance class [System.Runtime]System.Threading.Tasks.Task 
          UpdatePlugin(class [Spectre.Console]Spectre.Console.ProgressContext ctx) cil managed
  {
    .custom instance void [System.Runtime]System.Runtime.CompilerServices.AsyncStateMachineAttribute::.ctor(class [System.Runtime]System.Type) = ( 01 00 2C 41 49 52 65 64 69 72 65 63 74 6F 72 2E   // ..,AIRedirector.
                                                                                                                                                   41 49 52 65 64 69 72 65 63 74 6F 72 2B 3C 55 70   // AIRedirector+<Up
                                                                                                                                                   64 61 74 65 50 6C 75 67 69 6E 3E 64 5F 5F 36 00   // datePlugin>d__6.
                                                                                                                                                   00 ) 
    // Code size       63 (0x3f)
    .maxstack  2
    .locals init (valuetype AIRedirector.AIRedirector/'<UpdatePlugin>d__6' V_0)
    IL_0000:  ldloca.s   V_0
    IL_0002:  call       valuetype [System.Runtime]System.Runtime.CompilerServices.AsyncTaskMethodBuilder [System.Runtime]System.Runtime.CompilerServices.AsyncTaskMethodBuilder::Create()
    IL_0007:  stfld      valuetype [System.Runtime]System.Runtime.CompilerServices.AsyncTaskMethodBuilder AIRedirector.AIRedirector/'<UpdatePlugin>d__6'::'<>t__builder'
    IL_000c:  ldloca.s   V_0
    IL_000e:  ldarg.0
    IL_000f:  stfld      class AIRedirector.AIRedirector AIRedirector.AIRedirector/'<UpdatePlugin>d__6'::'<>4__this'
    IL_0014:  ldloca.s   V_0
    IL_0016:  ldarg.1
    IL_0017:  stfld      class [Spectre.Console]Spectre.Console.ProgressContext AIRedirector.AIRedirector/'<UpdatePlugin>d__6'::ctx
    IL_001c:  ldloca.s   V_0
    IL_001e:  ldc.i4.m1
    IL_001f:  stfld      int32 AIRedirector.AIRedirector/'<UpdatePlugin>d__6'::'<>1__state'
    IL_0024:  ldloca.s   V_0
    IL_0026:  ldflda     valuetype [System.Runtime]System.Runtime.CompilerServices.AsyncTaskMethodBuilder AIRedirector.AIRedirector/'<UpdatePlugin>d__6'::'<>t__builder'
    IL_002b:  ldloca.s   V_0
    IL_002d:  call       instance void [System.Runtime]System.Runtime.CompilerServices.AsyncTaskMethodBuilder::Start<valuetype AIRedirector.AIRedirector/'<UpdatePlugin>d__6'>(!!0&)
    IL_0032:  ldloca.s   V_0
    IL_0034:  ldflda     valuetype [System.Runtime]System.Runtime.CompilerServices.AsyncTaskMethodBuilder AIRedirector.AIRedirector/'<UpdatePlugin>d__6'::'<>t__builder'
    IL_0039:  call       instance class [System.Runtime]System.Threading.Tasks.Task [System.Runtime]System.Runtime.CompilerServices.AsyncTaskMethodBuilder::get_Task()
    IL_003e:  ret
  } // end of method AIRedirector::UpdatePlugin

  .method public hidebysig specialname instance bool 
          get_UAF() cil managed
  {
    .custom instance void [System.Runtime]System.Runtime.CompilerServices.CompilerGeneratedAttribute::.ctor() = ( 01 00 00 00 ) 
    // Code size       7 (0x7)
    .maxstack  8
    IL_0000:  ldarg.0
    IL_0001:  ldfld      bool AIRedirector.AIRedirector::'<UAF>k__BackingField'
    IL_0006:  ret
  } // end of method AIRedirector::get_UAF

  .method public hidebysig specialname instance void 
          set_UAF(bool 'value') cil managed
  {
    .custom instance void [System.Runtime]System.Runtime.CompilerServices.CompilerGeneratedAttribute::.ctor() = ( 01 00 00 00 ) 
    // Code size       8 (0x8)
    .maxstack  8
    IL_0000:  ldarg.0
    IL_0001:  ldarg.1
    IL_0002:  stfld      bool AIRedirector.AIRedirector::'<UAF>k__BackingField'
    IL_0007:  ret
  } // end of method AIRedirector::set_UAF

  .method public hidebysig specialname instance string 
          get_UAF_Path() cil managed
  {
    .custom instance void [System.Runtime]System.Runtime.CompilerServices.CompilerGeneratedAttribute::.ctor() = ( 01 00 00 00 ) 
    // Code size       7 (0x7)
    .maxstack  8
    IL_0000:  ldarg.0
    IL_0001:  ldfld      string AIRedirector.AIRedirector::'<UAF_Path>k__BackingField'
    IL_0006:  ret
  } // end of method AIRedirector::get_UAF_Path

  .method public hidebysig specialname instance void 
          set_UAF_Path(string 'value') cil managed
  {
    .custom instance void [System.Runtime]System.Runtime.CompilerServices.CompilerGeneratedAttribute::.ctor() = ( 01 00 00 00 ) 
    // Code size       8 (0x8)
    .maxstack  8
    IL_0000:  ldarg.0
    IL_0001:  ldarg.1
    IL_0002:  stfld      string AIRedirector.AIRedirector::'<UAF_Path>k__BackingField'
    IL_0007:  ret
  } // end of method AIRedirector::set_UAF_Path

  .method public hidebysig specialname instance bool 
          get_Cook() cil managed
  {
    .custom instance void [System.Runtime]System.Runtime.CompilerServices.CompilerGeneratedAttribute::.ctor() = ( 01 00 00 00 ) 
    // Code size       7 (0x7)
    .maxstack  8
    IL_0000:  ldarg.0
    IL_0001:  ldfld      bool AIRedirector.AIRedirector::'<Cook>k__BackingField'
    IL_0006:  ret
  } // end of method AIRedirector::get_Cook

  .method public hidebysig specialname instance void 
          set_Cook(bool 'value') cil managed
  {
    .custom instance void [System.Runtime]System.Runtime.CompilerServices.CompilerGeneratedAttribute::.ctor() = ( 01 00 00 00 ) 
    // Code size       8 (0x8)
    .maxstack  8
    IL_0000:  ldarg.0
    IL_0001:  ldarg.1
    IL_0002:  stfld      bool AIRedirector.AIRedirector::'<Cook>k__BackingField'
    IL_0007:  ret
  } // end of method AIRedirector::set_Cook

  .method public hidebysig specialname instance string 
          get_Cook_Path() cil managed
  {
    .custom instance void [System.Runtime]System.Runtime.CompilerServices.CompilerGeneratedAttribute::.ctor() = ( 01 00 00 00 ) 
    // Code size       7 (0x7)
    .maxstack  8
    IL_0000:  ldarg.0
    IL_0001:  ldfld      string AIRedirector.AIRedirector::'<Cook_Path>k__BackingField'
    IL_0006:  ret
  } // end of method AIRedirector::get_Cook_Path

  .method public hidebysig specialname instance void 
          set_Cook_Path(string 'value') cil managed
  {
    .custom instance void [System.Runtime]System.Runtime.CompilerServices.CompilerGeneratedAttribute::.ctor() = ( 01 00 00 00 ) 
    // Code size       8 (0x8)
    .maxstack  8
    IL_0000:  ldarg.0
    IL_0001:  ldarg.1
    IL_0002:  stfld      string AIRedirector.AIRedirector::'<Cook_Path>k__BackingField'
    IL_0007:  ret
  } // end of method AIRedirector::set_Cook_Path

  .method public hidebysig specialname instance bool 
          get_Mecha() cil managed
  {
    .custom instance void [System.Runtime]System.Runtime.CompilerServices.CompilerGeneratedAttribute::.ctor() = ( 01 00 00 00 ) 
    // Code size       7 (0x7)
    .maxstack  8
    IL_0000:  ldarg.0
    IL_0001:  ldfld      bool AIRedirector.AIRedirector::'<Mecha>k__BackingField'
    IL_0006:  ret
  } // end of method AIRedirector::get_Mecha

  .method public hidebysig specialname instance void 
          set_Mecha(bool 'value') cil managed
  {
    .custom instance void [System.Runtime]System.Runtime.CompilerServices.CompilerGeneratedAttribute::.ctor() = ( 01 00 00 00 ) 
    // Code size       8 (0x8)
    .maxstack  8
    IL_0000:  ldarg.0
    IL_0001:  ldarg.1
    IL_0002:  stfld      bool AIRedirector.AIRedirector::'<Mecha>k__BackingField'
    IL_0007:  ret
  } // end of method AIRedirector::set_Mecha

  .method public hidebysig specialname instance string 
          get_Mecha_Path() cil managed
  {
    .custom instance void [System.Runtime]System.Runtime.CompilerServices.CompilerGeneratedAttribute::.ctor() = ( 01 00 00 00 ) 
    // Code size       7 (0x7)
    .maxstack  8
    IL_0000:  ldarg.0
    IL_0001:  ldfld      string AIRedirector.AIRedirector::'<Mecha_Path>k__BackingField'
    IL_0006:  ret
  } // end of method AIRedirector::get_Mecha_Path

  .method public hidebysig specialname instance void 
          set_Mecha_Path(string 'value') cil managed
  {
    .custom instance void [System.Runtime]System.Runtime.CompilerServices.CompilerGeneratedAttribute::.ctor() = ( 01 00 00 00 ) 
    // Code size       8 (0x8)
    .maxstack  8
    IL_0000:  ldarg.0
    IL_0001:  ldarg.1
    IL_0002:  stfld      string AIRedirector.AIRedirector::'<Mecha_Path>k__BackingField'
    IL_0007:  ret
  } // end of method AIRedirector::set_Mecha_Path

  .method public hidebysig specialname instance bool 
          get_Legend() cil managed
  {
    .custom instance void [System.Runtime]System.Runtime.CompilerServices.CompilerGeneratedAttribute::.ctor() = ( 01 00 00 00 ) 
    // Code size       7 (0x7)
    .maxstack  8
    IL_0000:  ldarg.0
    IL_0001:  ldfld      bool AIRedirector.AIRedirector::'<Legend>k__BackingField'
    IL_0006:  ret
  } // end of method AIRedirector::get_Legend

  .method public hidebysig specialname instance void 
          set_Legend(bool 'value') cil managed
  {
    .custom instance void [System.Runtime]System.Runtime.CompilerServices.CompilerGeneratedAttribute::.ctor() = ( 01 00 00 00 ) 
    // Code size       8 (0x8)
    .maxstack  8
    IL_0000:  ldarg.0
    IL_0001:  ldarg.1
    IL_0002:  stfld      bool AIRedirector.AIRedirector::'<Legend>k__BackingField'
    IL_0007:  ret
  } // end of method AIRedirector::set_Legend

  .method public hidebysig specialname instance string 
          get_Legend_Path() cil managed
  {
    .custom instance void [System.Runtime]System.Runtime.CompilerServices.CompilerGeneratedAttribute::.ctor() = ( 01 00 00 00 ) 
    // Code size       7 (0x7)
    .maxstack  8
    IL_0000:  ldarg.0
    IL_0001:  ldfld      string AIRedirector.AIRedirector::'<Legend_Path>k__BackingField'
    IL_0006:  ret
  } // end of method AIRedirector::get_Legend_Path

  .method public hidebysig specialname instance void 
          set_Legend_Path(string 'value') cil managed
  {
    .custom instance void [System.Runtime]System.Runtime.CompilerServices.CompilerGeneratedAttribute::.ctor() = ( 01 00 00 00 ) 
    // Code size       8 (0x8)
    .maxstack  8
    IL_0000:  ldarg.0
    IL_0001:  ldarg.1
    IL_0002:  stfld      string AIRedirector.AIRedirector::'<Legend_Path>k__BackingField'
    IL_0007:  ret
  } // end of method AIRedirector::set_Legend_Path

  .method public hidebysig newslot virtual final 
          instance void  Initialize() cil managed
  {
    // Code size       947 (0x3b3)
    .maxstack  5
    .locals init (class [System.Runtime]System.Collections.Generic.IEnumerator`1<string> V_0,
             string V_1,
             class [System.Diagnostics.Process]System.Diagnostics.Process V_2,
             class [System.Diagnostics.Process]System.Diagnostics.Process V_3,
             class [System.Diagnostics.Process]System.Diagnostics.Process V_4,
             string V_5,
             class [System.Diagnostics.Process]System.Diagnostics.Process V_6,
             valuetype [System.Collections]System.Collections.Generic.Dictionary`2/Enumerator<valuetype [UmamusumeResponseAnalyzer]UmamusumeResponseAnalyzer.ScenarioType,class [System.Diagnostics.Process]System.Diagnostics.Process> V_7,
             class [System.Diagnostics.Process]System.Diagnostics.Process V_8,
             valuetype [System.Runtime]System.Collections.Generic.KeyValuePair`2<valuetype [UmamusumeResponseAnalyzer]UmamusumeResponseAnalyzer.ScenarioType,class [System.Diagnostics.Process]System.Diagnostics.Process> V_9,
             valuetype [UmamusumeResponseAnalyzer]UmamusumeResponseAnalyzer.ScenarioType V_10,
             class [System.Diagnostics.Process]System.Diagnostics.Process V_11)
    IL_0000:  ldstr      "./PluginData/SendGameStatusPlugin/"
    IL_0005:  ldstr      "*.json"
    IL_000a:  ldc.i4.1
    IL_000b:  call       class [System.Runtime]System.Collections.Generic.IEnumerable`1<string> [System.Runtime]System.IO.Directory::EnumerateFiles(string,
                                                                                                                                                    string,
                                                                                                                                                    valuetype [System.Runtime]System.IO.SearchOption)
    IL_0010:  callvirt   instance class [System.Runtime]System.Collections.Generic.IEnumerator`1<!0> class [System.Runtime]System.Collections.Generic.IEnumerable`1<string>::GetEnumerator()
    IL_0015:  stloc.0
    .try
    {
      IL_0016:  br.s       IL_003c

      IL_0018:  ldloc.0
      IL_0019:  callvirt   instance !0 class [System.Runtime]System.Collections.Generic.IEnumerator`1<string>::get_Current()
      IL_001e:  stloc.1
      IL_001f:  ldloc.1
      IL_0020:  call       string [System.Runtime]System.IO.Path::GetFileName(string)
      IL_0025:  ldstr      "thisTurn.json"
      IL_002a:  call       bool [System.Runtime]System.String::op_Equality(string,
                                                                           string)
      IL_002f:  brfalse.s  IL_003c

      IL_0031:  ldloc.1
      IL_0032:  ldstr      "{}"
      IL_0037:  call       void [System.Runtime]System.IO.File::WriteAllText(string,
                                                                             string)
      IL_003c:  ldloc.0
      IL_003d:  callvirt   instance bool [System.Runtime]System.Collections.IEnumerator::MoveNext()
      IL_0042:  brtrue.s   IL_0018

      IL_0044:  leave.s    IL_0050

    }  // end .try
    finally
    {
      IL_0046:  ldloc.0
      IL_0047:  brfalse.s  IL_004f

      IL_0049:  ldloc.0
      IL_004a:  callvirt   instance void [System.Runtime]System.IDisposable::Dispose()
      IL_004f:  endfinally
    }  // end handler
    IL_0050:  call       class [System.Runtime]System.Text.EncodingProvider [System.Text.Encoding.CodePages]System.Text.CodePagesEncodingProvider::get_Instance()
    IL_0055:  call       void [System.Runtime]System.Text.Encoding::RegisterProvider(class [System.Runtime]System.Text.EncodingProvider)
    IL_005a:  ldarg.0
    IL_005b:  call       instance bool AIRedirector.AIRedirector::get_UAF()
    IL_0060:  brfalse    IL_0110

    IL_0065:  ldarg.0
    IL_0066:  call       instance string AIRedirector.AIRedirector::get_UAF_Path()
    IL_006b:  call       bool [System.Runtime]System.IO.File::Exists(string)
    IL_0070:  brfalse    IL_0110

    IL_0075:  newobj     instance void [System.Diagnostics.Process]System.Diagnostics.Process::.ctor()
    IL_007a:  dup
    IL_007b:  newobj     instance void [System.Diagnostics.Process]System.Diagnostics.ProcessStartInfo::.ctor()
    IL_0080:  dup
    IL_0081:  ldarg.0
    IL_0082:  call       instance string AIRedirector.AIRedirector::get_UAF_Path()
    IL_0087:  callvirt   instance void [System.Diagnostics.Process]System.Diagnostics.ProcessStartInfo::set_FileName(string)
    IL_008c:  dup
    IL_008d:  ldsfld     string [System.Runtime]System.String::Empty
    IL_0092:  callvirt   instance void [System.Diagnostics.Process]System.Diagnostics.ProcessStartInfo::set_Arguments(string)
    IL_0097:  dup
    IL_0098:  ldc.i4.1
    IL_0099:  callvirt   instance void [System.Diagnostics.Process]System.Diagnostics.ProcessStartInfo::set_RedirectStandardOutput(bool)
    IL_009e:  dup
    IL_009f:  ldc.i4.1
    IL_00a0:  callvirt   instance void [System.Diagnostics.Process]System.Diagnostics.ProcessStartInfo::set_RedirectStandardError(bool)
    IL_00a5:  dup
    IL_00a6:  ldc.i4.0
    IL_00a7:  callvirt   instance void [System.Diagnostics.Process]System.Diagnostics.ProcessStartInfo::set_UseShellExecute(bool)
    IL_00ac:  dup
    IL_00ad:  ldc.i4.1
    IL_00ae:  callvirt   instance void [System.Diagnostics.Process]System.Diagnostics.ProcessStartInfo::set_CreateNoWindow(bool)
    IL_00b3:  dup
    IL_00b4:  ldstr      "gbk"
    IL_00b9:  call       class [System.Runtime]System.Text.Encoding [System.Runtime]System.Text.Encoding::GetEncoding(string)
    IL_00be:  callvirt   instance void [System.Diagnostics.Process]System.Diagnostics.ProcessStartInfo::set_StandardOutputEncoding(class [System.Runtime]System.Text.Encoding)
    IL_00c3:  callvirt   instance void [System.Diagnostics.Process]System.Diagnostics.Process::set_StartInfo(class [System.Diagnostics.Process]System.Diagnostics.ProcessStartInfo)
    IL_00c8:  stloc.2
    IL_00c9:  ldloc.2
    IL_00ca:  ldsfld     class [System.Diagnostics.Process]System.Diagnostics.DataReceivedEventHandler AIRedirector.AIRedirector/'<>c'::'<>9__41_0'
    IL_00cf:  dup
    IL_00d0:  brtrue.s   IL_00e9

    IL_00d2:  pop
    IL_00d3:  ldsfld     class AIRedirector.AIRedirector/'<>c' AIRedirector.AIRedirector/'<>c'::'<>9'
    IL_00d8:  ldftn      instance void AIRedirector.AIRedirector/'<>c'::'<Initialize>b__41_0'(object,
                                                                                              class [System.Diagnostics.Process]System.Diagnostics.DataReceivedEventArgs)
    IL_00de:  newobj     instance void [System.Diagnostics.Process]System.Diagnostics.DataReceivedEventHandler::.ctor(object,
                                                                                                                      native int)
    IL_00e3:  dup
    IL_00e4:  stsfld     class [System.Diagnostics.Process]System.Diagnostics.DataReceivedEventHandler AIRedirector.AIRedirector/'<>c'::'<>9__41_0'
    IL_00e9:  callvirt   instance void [System.Diagnostics.Process]System.Diagnostics.Process::add_OutputDataReceived(class [System.Diagnostics.Process]System.Diagnostics.DataReceivedEventHandler)
    IL_00ee:  ldarg.0
    IL_00ef:  ldfld      class [System.Collections]System.Collections.Generic.Dictionary`2<valuetype [UmamusumeResponseAnalyzer]UmamusumeResponseAnalyzer.ScenarioType,class [System.Diagnostics.Process]System.Diagnostics.Process> AIRedirector.AIRedirector::Processes
    IL_00f4:  ldc.i4.7
    IL_00f5:  ldloc.2
    IL_00f6:  callvirt   instance void class [System.Collections]System.Collections.Generic.Dictionary`2<valuetype [UmamusumeResponseAnalyzer]UmamusumeResponseAnalyzer.ScenarioType,class [System.Diagnostics.Process]System.Diagnostics.Process>::Add(!0,
                                                                                                                                                                                                                                                        !1)
    IL_00fb:  ldstr      "UAF Path: "
    IL_0100:  ldarg.0
    IL_0101:  call       instance string AIRedirector.AIRedirector::get_UAF_Path()
    IL_0106:  call       string [System.Runtime]System.String::Concat(string,
                                                                      string)
    IL_010b:  call       void [System.Diagnostics.TraceSource]System.Diagnostics.Trace::WriteLine(string)
    IL_0110:  ldarg.0
    IL_0111:  call       instance bool AIRedirector.AIRedirector::get_Cook()
    IL_0116:  brfalse    IL_01c6

    IL_011b:  ldarg.0
    IL_011c:  call       instance string AIRedirector.AIRedirector::get_Cook_Path()
    IL_0121:  call       bool [System.Runtime]System.IO.File::Exists(string)
    IL_0126:  brfalse    IL_01c6

    IL_012b:  newobj     instance void [System.Diagnostics.Process]System.Diagnostics.Process::.ctor()
    IL_0130:  dup
    IL_0131:  newobj     instance void [System.Diagnostics.Process]System.Diagnostics.ProcessStartInfo::.ctor()
    IL_0136:  dup
    IL_0137:  ldarg.0
    IL_0138:  call       instance string AIRedirector.AIRedirector::get_Cook_Path()
    IL_013d:  callvirt   instance void [System.Diagnostics.Process]System.Diagnostics.ProcessStartInfo::set_FileName(string)
    IL_0142:  dup
    IL_0143:  ldsfld     string [System.Runtime]System.String::Empty
    IL_0148:  callvirt   instance void [System.Diagnostics.Process]System.Diagnostics.ProcessStartInfo::set_Arguments(string)
    IL_014d:  dup
    IL_014e:  ldc.i4.1
    IL_014f:  callvirt   instance void [System.Diagnostics.Process]System.Diagnostics.ProcessStartInfo::set_RedirectStandardOutput(bool)
    IL_0154:  dup
    IL_0155:  ldc.i4.1
    IL_0156:  callvirt   instance void [System.Diagnostics.Process]System.Diagnostics.ProcessStartInfo::set_RedirectStandardError(bool)
    IL_015b:  dup
    IL_015c:  ldc.i4.0
    IL_015d:  callvirt   instance void [System.Diagnostics.Process]System.Diagnostics.ProcessStartInfo::set_UseShellExecute(bool)
    IL_0162:  dup
    IL_0163:  ldc.i4.1
    IL_0164:  callvirt   instance void [System.Diagnostics.Process]System.Diagnostics.ProcessStartInfo::set_CreateNoWindow(bool)
    IL_0169:  dup
    IL_016a:  ldstr      "gbk"
    IL_016f:  call       class [System.Runtime]System.Text.Encoding [System.Runtime]System.Text.Encoding::GetEncoding(string)
    IL_0174:  callvirt   instance void [System.Diagnostics.Process]System.Diagnostics.ProcessStartInfo::set_StandardOutputEncoding(class [System.Runtime]System.Text.Encoding)
    IL_0179:  callvirt   instance void [System.Diagnostics.Process]System.Diagnostics.Process::set_StartInfo(class [System.Diagnostics.Process]System.Diagnostics.ProcessStartInfo)
    IL_017e:  stloc.3
    IL_017f:  ldloc.3
    IL_0180:  ldsfld     class [System.Diagnostics.Process]System.Diagnostics.DataReceivedEventHandler AIRedirector.AIRedirector/'<>c'::'<>9__41_1'
    IL_0185:  dup
    IL_0186:  brtrue.s   IL_019f

    IL_0188:  pop
    IL_0189:  ldsfld     class AIRedirector.AIRedirector/'<>c' AIRedirector.AIRedirector/'<>c'::'<>9'
    IL_018e:  ldftn      instance void AIRedirector.AIRedirector/'<>c'::'<Initialize>b__41_1'(object,
                                                                                              class [System.Diagnostics.Process]System.Diagnostics.DataReceivedEventArgs)
    IL_0194:  newobj     instance void [System.Diagnostics.Process]System.Diagnostics.DataReceivedEventHandler::.ctor(object,
                                                                                                                      native int)
    IL_0199:  dup
    IL_019a:  stsfld     class [System.Diagnostics.Process]System.Diagnostics.DataReceivedEventHandler AIRedirector.AIRedirector/'<>c'::'<>9__41_1'
    IL_019f:  callvirt   instance void [System.Diagnostics.Process]System.Diagnostics.Process::add_OutputDataReceived(class [System.Diagnostics.Process]System.Diagnostics.DataReceivedEventHandler)
    IL_01a4:  ldarg.0
    IL_01a5:  ldfld      class [System.Collections]System.Collections.Generic.Dictionary`2<valuetype [UmamusumeResponseAnalyzer]UmamusumeResponseAnalyzer.ScenarioType,class [System.Diagnostics.Process]System.Diagnostics.Process> AIRedirector.AIRedirector::Processes
    IL_01aa:  ldc.i4.8
    IL_01ab:  ldloc.3
    IL_01ac:  callvirt   instance void class [System.Collections]System.Collections.Generic.Dictionary`2<valuetype [UmamusumeResponseAnalyzer]UmamusumeResponseAnalyzer.ScenarioType,class [System.Diagnostics.Process]System.Diagnostics.Process>::Add(!0,
                                                                                                                                                                                                                                                        !1)
    IL_01b1:  ldstr      "Cook Path: "
    IL_01b6:  ldarg.0
    IL_01b7:  call       instance string AIRedirector.AIRedirector::get_Cook_Path()
    IL_01bc:  call       string [System.Runtime]System.String::Concat(string,
                                                                      string)
    IL_01c1:  call       void [System.Diagnostics.TraceSource]System.Diagnostics.Trace::WriteLine(string)
    IL_01c6:  ldarg.0
    IL_01c7:  call       instance bool AIRedirector.AIRedirector::get_Mecha()
    IL_01cc:  brfalse    IL_0270

    IL_01d1:  ldarg.0
    IL_01d2:  call       instance string AIRedirector.AIRedirector::get_Mecha_Path()
    IL_01d7:  call       bool [System.Runtime]System.IO.File::Exists(string)
    IL_01dc:  brfalse    IL_0270

    IL_01e1:  newobj     instance void [System.Diagnostics.Process]System.Diagnostics.Process::.ctor()
    IL_01e6:  dup
    IL_01e7:  newobj     instance void [System.Diagnostics.Process]System.Diagnostics.ProcessStartInfo::.ctor()
    IL_01ec:  dup
    IL_01ed:  ldarg.0
    IL_01ee:  call       instance string AIRedirector.AIRedirector::get_Mecha_Path()
    IL_01f3:  callvirt   instance void [System.Diagnostics.Process]System.Diagnostics.ProcessStartInfo::set_FileName(string)
    IL_01f8:  dup
    IL_01f9:  ldsfld     string [System.Runtime]System.String::Empty
    IL_01fe:  callvirt   instance void [System.Diagnostics.Process]System.Diagnostics.ProcessStartInfo::set_Arguments(string)
    IL_0203:  dup
    IL_0204:  ldc.i4.1
    IL_0205:  callvirt   instance void [System.Diagnostics.Process]System.Diagnostics.ProcessStartInfo::set_RedirectStandardOutput(bool)
    IL_020a:  dup
    IL_020b:  ldc.i4.1
    IL_020c:  callvirt   instance void [System.Diagnostics.Process]System.Diagnostics.ProcessStartInfo::set_RedirectStandardError(bool)
    IL_0211:  dup
    IL_0212:  ldc.i4.0
    IL_0213:  callvirt   instance void [System.Diagnostics.Process]System.Diagnostics.ProcessStartInfo::set_UseShellExecute(bool)
    IL_0218:  dup
    IL_0219:  ldc.i4.1
    IL_021a:  callvirt   instance void [System.Diagnostics.Process]System.Diagnostics.ProcessStartInfo::set_CreateNoWindow(bool)
    IL_021f:  callvirt   instance void [System.Diagnostics.Process]System.Diagnostics.Process::set_StartInfo(class [System.Diagnostics.Process]System.Diagnostics.ProcessStartInfo)
    IL_0224:  stloc.s    V_4
    IL_0226:  ldloc.s    V_4
    IL_0228:  ldsfld     class [System.Diagnostics.Process]System.Diagnostics.DataReceivedEventHandler AIRedirector.AIRedirector/'<>c'::'<>9__41_2'
    IL_022d:  dup
    IL_022e:  brtrue.s   IL_0247

    IL_0230:  pop
    IL_0231:  ldsfld     class AIRedirector.AIRedirector/'<>c' AIRedirector.AIRedirector/'<>c'::'<>9'
    IL_0236:  ldftn      instance void AIRedirector.AIRedirector/'<>c'::'<Initialize>b__41_2'(object,
                                                                                              class [System.Diagnostics.Process]System.Diagnostics.DataReceivedEventArgs)
    IL_023c:  newobj     instance void [System.Diagnostics.Process]System.Diagnostics.DataReceivedEventHandler::.ctor(object,
                                                                                                                      native int)
    IL_0241:  dup
    IL_0242:  stsfld     class [System.Diagnostics.Process]System.Diagnostics.DataReceivedEventHandler AIRedirector.AIRedirector/'<>c'::'<>9__41_2'
    IL_0247:  callvirt   instance void [System.Diagnostics.Process]System.Diagnostics.Process::add_OutputDataReceived(class [System.Diagnostics.Process]System.Diagnostics.DataReceivedEventHandler)
    IL_024c:  ldarg.0
    IL_024d:  ldfld      class [System.Collections]System.Collections.Generic.Dictionary`2<valuetype [UmamusumeResponseAnalyzer]UmamusumeResponseAnalyzer.ScenarioType,class [System.Diagnostics.Process]System.Diagnostics.Process> AIRedirector.AIRedirector::Processes
    IL_0252:  ldc.i4.s   9
    IL_0254:  ldloc.s    V_4
    IL_0256:  callvirt   instance void class [System.Collections]System.Collections.Generic.Dictionary`2<valuetype [UmamusumeResponseAnalyzer]UmamusumeResponseAnalyzer.ScenarioType,class [System.Diagnostics.Process]System.Diagnostics.Process>::Add(!0,
                                                                                                                                                                                                                                                        !1)
    IL_025b:  ldstr      "Mecha Path: "
    IL_0260:  ldarg.0
    IL_0261:  call       instance string AIRedirector.AIRedirector::get_Mecha_Path()
    IL_0266:  call       string [System.Runtime]System.String::Concat(string,
                                                                      string)
    IL_026b:  call       void [System.Diagnostics.TraceSource]System.Diagnostics.Trace::WriteLine(string)
    IL_0270:  ldarg.0
    IL_0271:  call       instance bool AIRedirector.AIRedirector::get_Legend()
    IL_0276:  brfalse    IL_0344

    IL_027b:  ldarg.0
    IL_027c:  call       instance string AIRedirector.AIRedirector::get_Legend_Path()
    IL_0281:  call       bool [System.Runtime]System.IO.File::Exists(string)
    IL_0286:  brfalse    IL_0344

    IL_028b:  ldarg.0
    IL_028c:  call       instance string AIRedirector.AIRedirector::get_Legend_Path()
    IL_0291:  call       string [System.Runtime]System.IO.Path::GetFullPath(string)
    IL_0296:  call       string [System.Runtime]System.IO.Path::GetDirectoryName(string)
    IL_029b:  stloc.s    V_5
    IL_029d:  newobj     instance void [System.Diagnostics.Process]System.Diagnostics.Process::.ctor()
    IL_02a2:  dup
    IL_02a3:  newobj     instance void [System.Diagnostics.Process]System.Diagnostics.ProcessStartInfo::.ctor()
    IL_02a8:  dup
    IL_02a9:  ldarg.0
    IL_02aa:  call       instance string AIRedirector.AIRedirector::get_Legend_Path()
    IL_02af:  callvirt   instance void [System.Diagnostics.Process]System.Diagnostics.ProcessStartInfo::set_FileName(string)
    IL_02b4:  dup
    IL_02b5:  ldsfld     string [System.Runtime]System.String::Empty
    IL_02ba:  callvirt   instance void [System.Diagnostics.Process]System.Diagnostics.ProcessStartInfo::set_Arguments(string)
    IL_02bf:  dup
    IL_02c0:  ldc.i4.1
    IL_02c1:  callvirt   instance void [System.Diagnostics.Process]System.Diagnostics.ProcessStartInfo::set_RedirectStandardOutput(bool)
    IL_02c6:  dup
    IL_02c7:  ldc.i4.1
    IL_02c8:  callvirt   instance void [System.Diagnostics.Process]System.Diagnostics.ProcessStartInfo::set_RedirectStandardError(bool)
    IL_02cd:  dup
    IL_02ce:  ldc.i4.0
    IL_02cf:  callvirt   instance void [System.Diagnostics.Process]System.Diagnostics.ProcessStartInfo::set_UseShellExecute(bool)
    IL_02d4:  dup
    IL_02d5:  ldc.i4.1
    IL_02d6:  callvirt   instance void [System.Diagnostics.Process]System.Diagnostics.ProcessStartInfo::set_CreateNoWindow(bool)
    IL_02db:  dup
    IL_02dc:  ldloc.s    V_5
    IL_02de:  callvirt   instance void [System.Diagnostics.Process]System.Diagnostics.ProcessStartInfo::set_WorkingDirectory(string)
    IL_02e3:  dup
    IL_02e4:  ldstr      "utf-8"
    IL_02e9:  call       class [System.Runtime]System.Text.Encoding [System.Runtime]System.Text.Encoding::GetEncoding(string)
    IL_02ee:  callvirt   instance void [System.Diagnostics.Process]System.Diagnostics.ProcessStartInfo::set_StandardOutputEncoding(class [System.Runtime]System.Text.Encoding)
    IL_02f3:  callvirt   instance void [System.Diagnostics.Process]System.Diagnostics.Process::set_StartInfo(class [System.Diagnostics.Process]System.Diagnostics.ProcessStartInfo)
    IL_02f8:  stloc.s    V_6
    IL_02fa:  ldloc.s    V_6
    IL_02fc:  ldsfld     class [System.Diagnostics.Process]System.Diagnostics.DataReceivedEventHandler AIRedirector.AIRedirector/'<>c'::'<>9__41_3'
    IL_0301:  dup
    IL_0302:  brtrue.s   IL_031b

    IL_0304:  pop
    IL_0305:  ldsfld     class AIRedirector.AIRedirector/'<>c' AIRedirector.AIRedirector/'<>c'::'<>9'
    IL_030a:  ldftn      instance void AIRedirector.AIRedirector/'<>c'::'<Initialize>b__41_3'(object,
                                                                                              class [System.Diagnostics.Process]System.Diagnostics.DataReceivedEventArgs)
    IL_0310:  newobj     instance void [System.Diagnostics.Process]System.Diagnostics.DataReceivedEventHandler::.ctor(object,
                                                                                                                      native int)
    IL_0315:  dup
    IL_0316:  stsfld     class [System.Diagnostics.Process]System.Diagnostics.DataReceivedEventHandler AIRedirector.AIRedirector/'<>c'::'<>9__41_3'
    IL_031b:  callvirt   instance void [System.Diagnostics.Process]System.Diagnostics.Process::add_OutputDataReceived(class [System.Diagnostics.Process]System.Diagnostics.DataReceivedEventHandler)
    IL_0320:  ldarg.0
    IL_0321:  ldfld      class [System.Collections]System.Collections.Generic.Dictionary`2<valuetype [UmamusumeResponseAnalyzer]UmamusumeResponseAnalyzer.ScenarioType,class [System.Diagnostics.Process]System.Diagnostics.Process> AIRedirector.AIRedirector::Processes
    IL_0326:  ldc.i4.s   10
    IL_0328:  ldloc.s    V_6
    IL_032a:  callvirt   instance void class [System.Collections]System.Collections.Generic.Dictionary`2<valuetype [UmamusumeResponseAnalyzer]UmamusumeResponseAnalyzer.ScenarioType,class [System.Diagnostics.Process]System.Diagnostics.Process>::Add(!0,
                                                                                                                                                                                                                                                        !1)
    IL_032f:  ldstr      "Legend Path: "
    IL_0334:  ldarg.0
    IL_0335:  call       instance string AIRedirector.AIRedirector::get_Legend_Path()
    IL_033a:  call       string [System.Runtime]System.String::Concat(string,
                                                                      string)
    IL_033f:  call       void [System.Diagnostics.TraceSource]System.Diagnostics.Trace::WriteLine(string)
    IL_0344:  ldarg.0
    IL_0345:  newobj     instance void AIRedirector.ChildProcessManager::.ctor()
    IL_034a:  stfld      class AIRedirector.ChildProcessManager AIRedirector.AIRedirector::_childProcessManager
    IL_034f:  ldarg.0
    IL_0350:  ldfld      class [System.Collections]System.Collections.Generic.Dictionary`2<valuetype [UmamusumeResponseAnalyzer]UmamusumeResponseAnalyzer.ScenarioType,class [System.Diagnostics.Process]System.Diagnostics.Process> AIRedirector.AIRedirector::Processes
    IL_0355:  callvirt   instance valuetype [System.Collections]System.Collections.Generic.Dictionary`2/Enumerator<!0,!1> class [System.Collections]System.Collections.Generic.Dictionary`2<valuetype [UmamusumeResponseAnalyzer]UmamusumeResponseAnalyzer.ScenarioType,class [System.Diagnostics.Process]System.Diagnostics.Process>::GetEnumerator()
    IL_035a:  stloc.s    V_7
    .try
    {
      IL_035c:  br.s       IL_0399

      IL_035e:  ldloca.s   V_7
      IL_0360:  call       instance valuetype [System.Runtime]System.Collections.Generic.KeyValuePair`2<!0,!1> valuetype [System.Collections]System.Collections.Generic.Dictionary`2/Enumerator<valuetype [UmamusumeResponseAnalyzer]UmamusumeResponseAnalyzer.ScenarioType,class [System.Diagnostics.Process]System.Diagnostics.Process>::get_Current()
      IL_0365:  stloc.s    V_9
      IL_0367:  ldloca.s   V_9
      IL_0369:  ldloca.s   V_10
      IL_036b:  ldloca.s   V_11
      IL_036d:  call       instance void valuetype [System.Runtime]System.Collections.Generic.KeyValuePair`2<valuetype [UmamusumeResponseAnalyzer]UmamusumeResponseAnalyzer.ScenarioType,class [System.Diagnostics.Process]System.Diagnostics.Process>::Deconstruct(!0&,
                                                                                                                                                                                                                                                                    !1&)
      IL_0372:  ldloc.s    V_11
      IL_0374:  stloc.s    V_8
      IL_0376:  ldloc.s    V_8
      IL_0378:  callvirt   instance bool [System.Diagnostics.Process]System.Diagnostics.Process::Start()
      IL_037d:  pop
      IL_037e:  ldarg.0
      IL_037f:  ldfld      class AIRedirector.ChildProcessManager AIRedirector.AIRedirector::_childProcessManager
      IL_0384:  ldloc.s    V_8
      IL_0386:  callvirt   instance void AIRedirector.ChildProcessManager::AddProcess(class [System.Diagnostics.Process]System.Diagnostics.Process)
      IL_038b:  ldloc.s    V_8
      IL_038d:  callvirt   instance void [System.Diagnostics.Process]System.Diagnostics.Process::BeginOutputReadLine()
      IL_0392:  ldloc.s    V_8
      IL_0394:  callvirt   instance void [System.Diagnostics.Process]System.Diagnostics.Process::BeginErrorReadLine()
      IL_0399:  ldloca.s   V_7
      IL_039b:  call       instance bool valuetype [System.Collections]System.Collections.Generic.Dictionary`2/Enumerator<valuetype [UmamusumeResponseAnalyzer]UmamusumeResponseAnalyzer.ScenarioType,class [System.Diagnostics.Process]System.Diagnostics.Process>::MoveNext()
      IL_03a0:  brtrue.s   IL_035e

      IL_03a2:  leave.s    IL_03b2

    }  // end .try
    finally
    {
      IL_03a4:  ldloca.s   V_7
      IL_03a6:  constrained. valuetype [System.Collections]System.Collections.Generic.Dictionary`2/Enumerator<valuetype [UmamusumeResponseAnalyzer]UmamusumeResponseAnalyzer.ScenarioType,class [System.Diagnostics.Process]System.Diagnostics.Process>
      IL_03ac:  callvirt   instance void [System.Runtime]System.IDisposable::Dispose()
      IL_03b1:  endfinally
    }  // end handler
    IL_03b2:  ret
  } // end of method AIRedirector::Initialize

  .method public hidebysig newslot virtual final 
          instance void  Dispose() cil managed
  {
    // Code size       117 (0x75)
    .maxstack  3
    .locals init (valuetype [System.Collections]System.Collections.Generic.Dictionary`2/Enumerator<valuetype [UmamusumeResponseAnalyzer]UmamusumeResponseAnalyzer.ScenarioType,class [System.Diagnostics.Process]System.Diagnostics.Process> V_0,
             class [System.Diagnostics.Process]System.Diagnostics.Process V_1,
             valuetype [System.Runtime]System.Collections.Generic.KeyValuePair`2<valuetype [UmamusumeResponseAnalyzer]UmamusumeResponseAnalyzer.ScenarioType,class [System.Diagnostics.Process]System.Diagnostics.Process> V_2,
             valuetype [UmamusumeResponseAnalyzer]UmamusumeResponseAnalyzer.ScenarioType V_3,
             class [System.Diagnostics.Process]System.Diagnostics.Process V_4)
    IL_0000:  ldarg.0
    IL_0001:  ldfld      class [System.Collections]System.Collections.Generic.Dictionary`2<valuetype [UmamusumeResponseAnalyzer]UmamusumeResponseAnalyzer.ScenarioType,class [System.Diagnostics.Process]System.Diagnostics.Process> AIRedirector.AIRedirector::Processes
    IL_0006:  callvirt   instance valuetype [System.Collections]System.Collections.Generic.Dictionary`2/Enumerator<!0,!1> class [System.Collections]System.Collections.Generic.Dictionary`2<valuetype [UmamusumeResponseAnalyzer]UmamusumeResponseAnalyzer.ScenarioType,class [System.Diagnostics.Process]System.Diagnostics.Process>::GetEnumerator()
    IL_000b:  stloc.0
    .try
    {
      IL_000c:  br.s       IL_0038

      IL_000e:  ldloca.s   V_0
      IL_0010:  call       instance valuetype [System.Runtime]System.Collections.Generic.KeyValuePair`2<!0,!1> valuetype [System.Collections]System.Collections.Generic.Dictionary`2/Enumerator<valuetype [UmamusumeResponseAnalyzer]UmamusumeResponseAnalyzer.ScenarioType,class [System.Diagnostics.Process]System.Diagnostics.Process>::get_Current()
      IL_0015:  stloc.2
      IL_0016:  ldloca.s   V_2
      IL_0018:  ldloca.s   V_3
      IL_001a:  ldloca.s   V_4
      IL_001c:  call       instance void valuetype [System.Runtime]System.Collections.Generic.KeyValuePair`2<valuetype [UmamusumeResponseAnalyzer]UmamusumeResponseAnalyzer.ScenarioType,class [System.Diagnostics.Process]System.Diagnostics.Process>::Deconstruct(!0&,
                                                                                                                                                                                                                                                                    !1&)
      IL_0021:  ldloc.s    V_4
      IL_0023:  stloc.1
      IL_0024:  ldloc.1
      IL_0025:  callvirt   instance bool [System.Diagnostics.Process]System.Diagnostics.Process::get_HasExited()
      IL_002a:  brtrue.s   IL_0032

      IL_002c:  ldloc.1
      IL_002d:  callvirt   instance void [System.Diagnostics.Process]System.Diagnostics.Process::Kill()
      IL_0032:  ldloc.1
      IL_0033:  callvirt   instance void [System.ComponentModel.Primitives]System.ComponentModel.Component::Dispose()
      IL_0038:  ldloca.s   V_0
      IL_003a:  call       instance bool valuetype [System.Collections]System.Collections.Generic.Dictionary`2/Enumerator<valuetype [UmamusumeResponseAnalyzer]UmamusumeResponseAnalyzer.ScenarioType,class [System.Diagnostics.Process]System.Diagnostics.Process>::MoveNext()
      IL_003f:  brtrue.s   IL_000e

      IL_0041:  leave.s    IL_0051

    }  // end .try
    finally
    {
      IL_0043:  ldloca.s   V_0
      IL_0045:  constrained. valuetype [System.Collections]System.Collections.Generic.Dictionary`2/Enumerator<valuetype [UmamusumeResponseAnalyzer]UmamusumeResponseAnalyzer.ScenarioType,class [System.Diagnostics.Process]System.Diagnostics.Process>
      IL_004b:  callvirt   instance void [System.Runtime]System.IDisposable::Dispose()
      IL_0050:  endfinally
    }  // end handler
    IL_0051:  ldarg.0
    IL_0052:  ldfld      class [System.Collections]System.Collections.Generic.Dictionary`2<valuetype [UmamusumeResponseAnalyzer]UmamusumeResponseAnalyzer.ScenarioType,class [System.Diagnostics.Process]System.Diagnostics.Process> AIRedirector.AIRedirector::Processes
    IL_0057:  callvirt   instance void class [System.Collections]System.Collections.Generic.Dictionary`2<valuetype [UmamusumeResponseAnalyzer]UmamusumeResponseAnalyzer.ScenarioType,class [System.Diagnostics.Process]System.Diagnostics.Process>::Clear()
    IL_005c:  ldarg.0
    IL_005d:  ldfld      class AIRedirector.ChildProcessManager AIRedirector.AIRedirector::_childProcessManager
    IL_0062:  dup
    IL_0063:  brtrue.s   IL_0068

    IL_0065:  pop
    IL_0066:  br.s       IL_006d

    IL_0068:  call       instance void AIRedirector.ChildProcessManager::Dispose()
    IL_006d:  ldarg.0
    IL_006e:  ldnull
    IL_006f:  stfld      class AIRedirector.ChildProcessManager AIRedirector.AIRedirector::_childProcessManager
    IL_0074:  ret
  } // end of method AIRedirector::Dispose

  .method public hidebysig specialname rtspecialname 
          instance void  .ctor() cil managed
  {
    // Code size       62 (0x3e)
    .maxstack  8
    IL_0000:  ldarg.0
    IL_0001:  ldsfld     string [System.Runtime]System.String::Empty
    IL_0006:  stfld      string AIRedirector.AIRedirector::'<UAF_Path>k__BackingField'
    IL_000b:  ldarg.0
    IL_000c:  ldsfld     string [System.Runtime]System.String::Empty
    IL_0011:  stfld      string AIRedirector.AIRedirector::'<Cook_Path>k__BackingField'
    IL_0016:  ldarg.0
    IL_0017:  ldsfld     string [System.Runtime]System.String::Empty
    IL_001c:  stfld      string AIRedirector.AIRedirector::'<Mecha_Path>k__BackingField'
    IL_0021:  ldarg.0
    IL_0022:  ldsfld     string [System.Runtime]System.String::Empty
    IL_0027:  stfld      string AIRedirector.AIRedirector::'<Legend_Path>k__BackingField'
    IL_002c:  ldarg.0
    IL_002d:  newobj     instance void class [System.Collections]System.Collections.Generic.Dictionary`2<valuetype [UmamusumeResponseAnalyzer]UmamusumeResponseAnalyzer.ScenarioType,class [System.Diagnostics.Process]System.Diagnostics.Process>::.ctor()
    IL_0032:  stfld      class [System.Collections]System.Collections.Generic.Dictionary`2<valuetype [UmamusumeResponseAnalyzer]UmamusumeResponseAnalyzer.ScenarioType,class [System.Diagnostics.Process]System.Diagnostics.Process> AIRedirector.AIRedirector::Processes
    IL_0037:  ldarg.0
    IL_0038:  call       instance void [System.Runtime]System.Object::.ctor()
    IL_003d:  ret
  } // end of method AIRedirector::.ctor

  .property instance string Name()
  {
    .custom instance void [UmamusumeResponseAnalyzer]UmamusumeResponseAnalyzer.Plugin.PluginDescriptionAttribute::.ctor(string) = ( 01 00 1D E8 BD AC E5 8F 91 41 49 E7 9A 84 E8 BE   // .........AI.....
                                                                                                                                    93 E5 87 BA E5 88 B0 E6 8E A7 E5 88 B6 E5 8F B0 
                                                                                                                                    00 00 ) 
    .get instance string AIRedirector.AIRedirector::get_Name()
  } // end of property AIRedirector::Name
  .property instance string Author()
  {
    .get instance string AIRedirector.AIRedirector::get_Author()
  } // end of property AIRedirector::Author
  .property instance string[] Targets()
  {
    .get instance string[] AIRedirector.AIRedirector::get_Targets()
  } // end of property AIRedirector::Targets
  .property instance bool UAF()
  {
    .custom instance void [UmamusumeResponseAnalyzer]UmamusumeResponseAnalyzer.Plugin.PluginSettingAttribute::.ctor() = ( 01 00 00 00 ) 
    .get instance bool AIRedirector.AIRedirector::get_UAF()
    .set instance void AIRedirector.AIRedirector::set_UAF(bool)
  } // end of property AIRedirector::UAF
  .property instance string UAF_Path()
  {
    .custom instance void [UmamusumeResponseAnalyzer]UmamusumeResponseAnalyzer.Plugin.PluginSettingAttribute::.ctor() = ( 01 00 00 00 ) 
    .get instance string AIRedirector.AIRedirector::get_UAF_Path()
    .set instance void AIRedirector.AIRedirector::set_UAF_Path(string)
  } // end of property AIRedirector::UAF_Path
  .property instance bool Cook()
  {
    .custom instance void [UmamusumeResponseAnalyzer]UmamusumeResponseAnalyzer.Plugin.PluginSettingAttribute::.ctor() = ( 01 00 00 00 ) 
    .get instance bool AIRedirector.AIRedirector::get_Cook()
    .set instance void AIRedirector.AIRedirector::set_Cook(bool)
  } // end of property AIRedirector::Cook
  .property instance string Cook_Path()
  {
    .custom instance void [UmamusumeResponseAnalyzer]UmamusumeResponseAnalyzer.Plugin.PluginSettingAttribute::.ctor() = ( 01 00 00 00 ) 
    .get instance string AIRedirector.AIRedirector::get_Cook_Path()
    .set instance void AIRedirector.AIRedirector::set_Cook_Path(string)
  } // end of property AIRedirector::Cook_Path
  .property instance bool Mecha()
  {
    .custom instance void [UmamusumeResponseAnalyzer]UmamusumeResponseAnalyzer.Plugin.PluginSettingAttribute::.ctor() = ( 01 00 00 00 ) 
    .get instance bool AIRedirector.AIRedirector::get_Mecha()
    .set instance void AIRedirector.AIRedirector::set_Mecha(bool)
  } // end of property AIRedirector::Mecha
  .property instance string Mecha_Path()
  {
    .custom instance void [UmamusumeResponseAnalyzer]UmamusumeResponseAnalyzer.Plugin.PluginSettingAttribute::.ctor() = ( 01 00 00 00 ) 
    .get instance string AIRedirector.AIRedirector::get_Mecha_Path()
    .set instance void AIRedirector.AIRedirector::set_Mecha_Path(string)
  } // end of property AIRedirector::Mecha_Path
  .property instance bool Legend()
  {
    .custom instance void [UmamusumeResponseAnalyzer]UmamusumeResponseAnalyzer.Plugin.PluginSettingAttribute::.ctor() = ( 01 00 00 00 ) 
    .get instance bool AIRedirector.AIRedirector::get_Legend()
    .set instance void AIRedirector.AIRedirector::set_Legend(bool)
  } // end of property AIRedirector::Legend
  .property instance string Legend_Path()
  {
    .custom instance void [UmamusumeResponseAnalyzer]UmamusumeResponseAnalyzer.Plugin.PluginSettingAttribute::.ctor() = ( 01 00 00 00 ) 
    .get instance string AIRedirector.AIRedirector::get_Legend_Path()
    .set instance void AIRedirector.AIRedirector::set_Legend_Path(string)
  } // end of property AIRedirector::Legend_Path
} // end of class AIRedirector.AIRedirector


// =============================================================

// *********** DISASSEMBLY COMPLETE ***********************
// WARNING: Created Win32 resource file C:\Users\QUIRRE~1\AppData\Local\Temp\AIRedirector_readonly.res
