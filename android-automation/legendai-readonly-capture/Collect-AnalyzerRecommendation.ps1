# Read-only structured collector for the existing Analyzer console probe.
# PowerShell 5.1 compatible. Run this script in the user's ordinary PowerShell window.
# The console-attaching probe runs in a child PowerShell process so console detachment
# cannot detach this launcher from its own console. No game input, clicks, restarts,
# network requests, or configuration changes are performed.
[CmdletBinding()]
param(
    [string]$StatePath = 'D:\Games\ai\LegendAI\.portable\PluginData\SendGameStatusPlugin\GameStatusSend_Legend\thisTurn.json',
    [string]$ProbePath = (Join-Path $PSScriptRoot 'Probe-AnalyzerConsole.ps1'),
    [string]$OutputPath = (Join-Path $env:TEMP ('UmaAI-AnalyzerCapture-' + (Get-Date -Format 'yyyyMMdd-HHmmss') + '.json'))
)

$ErrorActionPreference = 'Stop'
$startedAt = Get-Date
$stdoutPath = Join-Path $env:TEMP ('UmaAI-AnalyzerProbe-stdout-' + $startedAt.ToString('yyyyMMdd-HHmmss') + '.txt')
$stderrPath = Join-Path $env:TEMP ('UmaAI-AnalyzerProbe-stderr-' + $startedAt.ToString('yyyyMMdd-HHmmss') + '.txt')
$probeReport = $null
$stateBefore = $null
$stateAfter = $null
$recommendation = $null
$probeExitCode = $null
$status = 'NOT_VERIFIED'
$errors = New-Object System.Collections.Generic.List[string]

function Read-StateSnapshot([string]$Path) {
    if (-not (Test-Path -LiteralPath $Path -PathType Leaf)) {
        return $null
    }
    $raw = Get-Content -LiteralPath $Path -Raw -Encoding UTF8
    $obj = $raw | ConvertFrom-Json
    return [pscustomobject]@{
        raw = $raw
        turn = $obj.turn
        isRacing = $obj.isRacing
        scenarioId = $obj.scenarioId
    }
}

try {
    if (-not (Test-Path -LiteralPath $ProbePath -PathType Leaf)) {
        throw "Probe script not found: $ProbePath"
    }

    $stateBefore = Read-StateSnapshot -Path $StatePath
    $powershellExe = Join-Path $env:SystemRoot 'System32\WindowsPowerShell\v1.0\powershell.exe'
    $arguments = '-NoProfile -ExecutionPolicy Bypass -File "' + $ProbePath + '"'

    # Redirect child output to files. The child may detach itself from its console while
    # attaching to the Analyzer; the parent PowerShell remains unaffected.
    $child = Start-Process -FilePath $powershellExe -ArgumentList $arguments -PassThru -Wait -WindowStyle Hidden -RedirectStandardOutput $stdoutPath -RedirectStandardError $stderrPath
    $probeExitCode = $child.ExitCode

    $reports = Get-ChildItem -LiteralPath $env:TEMP -Filter 'UmaAI-AnalyzerConsoleProbe-*.txt' -File |
        Where-Object { $_.LastWriteTime -ge $startedAt.AddSeconds(-2) } |
        Sort-Object LastWriteTime -Descending
    if ($reports) {
        $probeReport = $reports | Select-Object -First 1
    }

    if ($probeReport) {
        $reportText = Get-Content -LiteralPath $probeReport.FullName -Raw -Encoding UTF8
        # Use Unicode escapes so Windows PowerShell 5.1 can parse this UTF-8 script even if downloaded without a BOM.
        $marker = 'AI\u5efa\u8bae\uff1a'
        $match = [regex]::Match($reportText, '(?m)^SCREEN\[\d+\]:\s*.*?' + $marker + '([^\r\n]+)')
        if ($match.Success) {
            $recommendation = $match.Groups[1].Value.Trim()
        }
        if (-not $recommendation) {
            $match = [regex]::Match($reportText, '(?m)^SCREEN\[\d+\]:\s*' + $marker + '([^\r\n]+)')
            if ($match.Success) {
                $recommendation = $match.Groups[1].Value.Trim()
            }
        }
    } else {
        $errors.Add('Probe report was not found after child process exit.')
    }

    $stateAfter = Read-StateSnapshot -Path $StatePath
    $sameState = $false
    if ($stateBefore -and $stateAfter) {
        $sameState = ($stateBefore.raw -ceq $stateAfter.raw)
    }

    if ($probeReport -and $recommendation -and $stateBefore -and $stateAfter -and $sameState) {
        $status = 'CAPTURED_SINGLE_SAMPLE_STATE_UNCHANGED'
    } elseif ($probeReport -and $recommendation) {
        $status = 'CAPTURED_BUT_STATE_ASSOCIATION_UNVERIFIED'
    } elseif ($probeReport) {
        $status = 'REPORT_CAPTURED_RECOMMENDATION_NOT_PARSED'
    }
} catch {
    $errors.Add($_.Exception.Message)
}

$result = [ordered]@{
    schemaVersion = 1
    task = 'UMAAI_READONLY_RECOMMENDATION_CAPTURE'
    capturedAt = (Get-Date).ToString('o')
    mode = 'READ_ONLY'
    gameActions = 'NONE'
    configChanges = 'NONE'
    status = $status
    recommendation = $recommendation
    stateBefore = if ($stateBefore) { [ordered]@{ turn = $stateBefore.turn; isRacing = $stateBefore.isRacing; scenarioId = $stateBefore.scenarioId } } else { $null }
    stateAfter = if ($stateAfter) { [ordered]@{ turn = $stateAfter.turn; isRacing = $stateAfter.isRacing; scenarioId = $stateAfter.scenarioId } } else { $null }
    stateFileUnchanged = if ($stateBefore -and $stateAfter) { [bool]($stateBefore.raw -ceq $stateAfter.raw) } else { $null }
    probeExitCode = $probeExitCode
    probeReportPath = if ($probeReport) { $probeReport.FullName } else { $null }
    probeStdoutPath = $stdoutPath
    probeStderrPath = $stderrPath
    errors = @($errors)
    limitations = @(
        'This is one console-buffer sample, not proof of continuous capture.',
        'A matching state snapshot does not prove that the recommendation was generated for that turn unless freshness is independently established.',
        'No game input, click, process restart, network request, or configuration edit is performed.'
    )
}
$result | ConvertTo-Json -Depth 8 | Set-Content -LiteralPath $OutputPath -Encoding UTF8

Clear-Host
Write-Host 'UmaAI read-only recommendation collector' -ForegroundColor Magenta
Write-Host ("Status: {0}" -f $status) -ForegroundColor Magenta
Write-Host ("Recommendation: {0}" -f $(if ($recommendation) { $recommendation } else { 'NOT_PARSED' })) -ForegroundColor Magenta
Write-Host ("JSON: {0}" -f $OutputPath) -ForegroundColor Magenta
Write-Host ("Probe report: {0}" -f $(if ($probeReport) { $probeReport.FullName } else { 'NOT_FOUND' })) -ForegroundColor Magenta
Write-Host 'Read-only: no game input, clicks, restarts, network requests, or config changes.' -ForegroundColor Magenta
