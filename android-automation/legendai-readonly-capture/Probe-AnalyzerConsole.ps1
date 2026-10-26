# Read-only probe for UmamusumeResponseAnalyzer console output.
# Run in a separate PowerShell process: AttachConsole/FreeConsole changes the calling process console attachment.
# PowerShell 5.1 compatible. Does not send input, click, restart, or modify configuration.
$ErrorActionPreference = 'Stop'
$reportPath = Join-Path $env:TEMP ('UmaAI-AnalyzerConsoleProbe-' + (Get-Date -Format 'yyyyMMdd-HHmmss') + '.txt')
$lines = New-Object System.Collections.Generic.List[string]
$lines.Add('TASK: UMAAI_ANALYZER_CONSOLE_READONLY_PROBE')
$lines.Add(('TIME: {0:yyyy-MM-dd HH:mm:ss zzz}' -f (Get-Date)))
$lines.Add('MODE: READ_ONLY')
$lines.Add('GAME_ACTIONS: NONE')
$lines.Add('CONFIG_CHANGES: NONE')
$lines.Add('')

$statePath = 'D:\Games\ai\LegendAI\.portable\PluginData\SendGameStatusPlugin\GameStatusSend_Legend\thisTurn.json'
$before = $null
$after = $null
try {
    if (Test-Path -LiteralPath $statePath) {
        $before = Get-Content -LiteralPath $statePath -Raw -Encoding UTF8
        $state = $before | ConvertFrom-Json
        $lines.Add(('STATE_BEFORE: turn={0}; isRacing={1}; scenarioId={2}' -f $state.turn, $state.isRacing, $state.scenarioId))
    } else {
        $lines.Add(('STATE_BEFORE: MISSING: {0}' -f $statePath))
    }
} catch {
    $lines.Add(('STATE_BEFORE_ERROR: {0}' -f $_.Exception.Message))
}

$target = Get-CimInstance Win32_Process -Filter "Name = 'UmamusumeResponseAnalyzer.exe'" |
    Where-Object { $_.ExecutablePath -eq 'D:\Games\ai\LegendAI\UmamusumeResponseAnalyzer.exe' } |
    Select-Object -First 1

if (-not $target) {
    $lines.Add('ANALYZER: NOT_FOUND at expected executable path')
} else {
    $lines.Add(('ANALYZER_PID: {0}' -f $target.ProcessId))
    try {
        if (-not ('UmaAiConsoleProbe.Native' -as [type])) {
            Add-Type -TypeDefinition @'
using System;
using System.Text;
using System.Runtime.InteropServices;
namespace UmaAiConsoleProbe {
  public static class Native {
    [StructLayout(LayoutKind.Sequential)]
    public struct COORD { public short X; public short Y; }
    [StructLayout(LayoutKind.Sequential)]
    public struct SMALL_RECT { public short Left; public short Top; public short Right; public short Bottom; }
    [StructLayout(LayoutKind.Sequential)]
    public struct CONSOLE_SCREEN_BUFFER_INFO {
      public COORD dwSize;
      public COORD dwCursorPosition;
      public short wAttributes;
      public SMALL_RECT srWindow;
      public COORD dwMaximumWindowSize;
    }
    [DllImport("kernel32.dll", SetLastError=true)] public static extern bool FreeConsole();
    [DllImport("kernel32.dll", SetLastError=true)] public static extern bool AttachConsole(uint dwProcessId);
    [DllImport("kernel32.dll", CharSet=CharSet.Unicode, SetLastError=true)]
    public static extern IntPtr CreateFile(string name, uint access, uint share, IntPtr security, uint creation, uint flags, IntPtr template);
    [DllImport("kernel32.dll", SetLastError=true)]
    public static extern bool GetConsoleScreenBufferInfo(IntPtr hConsoleOutput, out CONSOLE_SCREEN_BUFFER_INFO info);
    [DllImport("kernel32.dll", CharSet=CharSet.Unicode, SetLastError=true)]
    public static extern bool ReadConsoleOutputCharacter(IntPtr hConsoleOutput, StringBuilder output, uint length, COORD coord, out uint read);
    [DllImport("kernel32.dll", SetLastError=true)] public static extern bool CloseHandle(IntPtr handle);
  }
}
'@
        }
        [void][UmaAiConsoleProbe.Native]::FreeConsole()
        if (-not [UmaAiConsoleProbe.Native]::AttachConsole([uint32]$target.ProcessId)) {
            $err = [Runtime.InteropServices.Marshal]::GetLastWin32Error()
            $lines.Add(("CONSOLE_ATTACH: FAILED; Win32Error={0}" -f $err))
            $lines.Add('INTERPRETATION: Analyzer may use a pseudoconsole or have no attachable Win32 console.')
        } else {
            $handle = [UmaAiConsoleProbe.Native]::CreateFile('CONOUT$', ([uint32]0x80000000), [uint32]3, [IntPtr]::Zero, [uint32]3, [uint32]0, [IntPtr]::Zero)
            if ($handle -eq [IntPtr](-1)) {
                $err = [Runtime.InteropServices.Marshal]::GetLastWin32Error()
                $lines.Add(("CONSOLE_OPEN: FAILED; Win32Error={0}" -f $err))
            } else {
                try {
                    $info = New-Object UmaAiConsoleProbe.Native+CONSOLE_SCREEN_BUFFER_INFO
                    if (-not [UmaAiConsoleProbe.Native]::GetConsoleScreenBufferInfo($handle, [ref]$info)) {
                        $err = [Runtime.InteropServices.Marshal]::GetLastWin32Error()
                        $lines.Add(("BUFFER_INFO: FAILED; Win32Error={0}" -f $err))
                    } else {
                        $width = [int]$info.dwSize.X
                        $lines.Add(("BUFFER_SIZE: {0}x{1}" -f $width, [int]$info.dwSize.Y))
                        $startY = [Math]::Max(0, [int]$info.dwSize.Y - 80)
                        for ($y = $startY; $y -lt [int]$info.dwSize.Y; $y++) {
                            $sb = New-Object System.Text.StringBuilder ($width + 2)
                            $read = [uint32]0
                            $coord = New-Object UmaAiConsoleProbe.Native+COORD
                            $coord.X = 0; $coord.Y = [int16]$y
                            if ([UmaAiConsoleProbe.Native]::ReadConsoleOutputCharacter($handle, $sb, [uint32]$width, $coord, [ref]$read) -and $read -gt 0) {
                                $row = $sb.ToString().TrimEnd()
                                if (-not [string]::IsNullOrWhiteSpace($row)) { $lines.Add(('SCREEN[{0}]: {1}' -f $y, $row)) }
                            }
                        }
                    }
                } finally {
                    [void][UmaAiConsoleProbe.Native]::CloseHandle($handle)
                }
            }
        }
    } catch {
        $lines.Add(('CONSOLE_PROBE_ERROR: {0}' -f $_.Exception.Message))
    } finally {
        [void][UmaAiConsoleProbe.Native]::FreeConsole()
    }
}

try {
    if (Test-Path -LiteralPath $statePath) {
        $after = Get-Content -LiteralPath $statePath -Raw -Encoding UTF8
        $state2 = $after | ConvertFrom-Json
        $lines.Add(('STATE_AFTER: turn={0}; isRacing={1}; scenarioId={2}' -f $state2.turn, $state2.isRacing, $state2.scenarioId))
        $lines.Add(('STATE_FILE_UNCHANGED_DURING_PROBE: {0}' -f ($before -ceq $after)))
    }
} catch {
    $lines.Add(('STATE_AFTER_ERROR: {0}' -f $_.Exception.Message))
}

$lines.Add('')
$lines.Add('NOTE: Empty/no suggestion text is inconclusive; this probe only reads the current console buffer.')
$report = $lines -join [Environment]::NewLine
Set-Content -LiteralPath $reportPath -Value $report -Encoding UTF8
$clipboardStatus = 'NOT_VERIFIED'
try {
    Set-Clipboard -Value $report
    if ((Get-Clipboard -Raw) -ceq $report) { $clipboardStatus = 'VERIFIED_EXACT_MATCH' }
    else { $clipboardStatus = 'MISMATCH' }
} catch {
    $clipboardStatus = ('FAILED: ' + $_.Exception.Message)
}
Clear-Host
Write-Host 'UmaAI analyzer console probe' -ForegroundColor Magenta
Write-Host ('Report: {0}' -f $reportPath) -ForegroundColor Magenta
Write-Host ('Clipboard: {0}' -f $clipboardStatus) -ForegroundColor Magenta
Write-Host ('Analyzer found: {0}' -f [bool]$target) -ForegroundColor Magenta
Write-Host 'Read-only: no game input, clicks, restarts, or config changes.' -ForegroundColor Magenta
Write-Host ''
Write-Host 'Report content:' -ForegroundColor Magenta
$report -split '\r?\n' | Select-Object -Last 45 | ForEach-Object { Write-Host $_ -ForegroundColor Magenta }
