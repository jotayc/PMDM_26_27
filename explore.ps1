# ==============================
# Exporta TODAS las clases Java
# de un proyecto Android
# en UN TXT por rama remota
# ==============================

Set-StrictMode -Version Latest
$ErrorActionPreference = "Stop"

# Carpeta de salida
$exportDir = Join-Path (Get-Location) "exports"
New-Item -ItemType Directory -Force -Path $exportDir | Out-Null

Write-Host "Obteniendo ramas remotas..."
git fetch --all | Out-Null

$remoteBranches = git branch -r |
    Where-Object {
        $_ -notmatch "HEAD" -and
        $_ -notmatch "->"
    } |
    ForEach-Object { $_.Trim() }

foreach ($branch in $remoteBranches) {

    Write-Host "`nProcesando rama: $branch"

    # Nombre limpio para fichero
    $safeBranchName = $branch -replace "[/\\]", "_"
    $outputFile = Join-Path $exportDir "$safeBranchName.txt"

    # Cabecera del fichero
    @"
====================================================
RAMA: $branch
EXPORTACIÓN DE CLASES JAVA
FECHA: $(Get-Date)
====================================================

"@ | Out-File -FilePath $outputFile -Encoding UTF8

    # Listar todos los .java de la rama
    $javaFiles = git ls-tree -r --name-only $branch |
                 Where-Object { $_ -like "*.java" }

    if (-not $javaFiles) {
        Add-Content $outputFile "⚠ No se encontraron ficheros .java en esta rama.`n"
        continue
    }

    foreach ($javaFile in $javaFiles) {

        Add-Content $outputFile @"
----------------------------------------------------
FICHERO: $javaFile
----------------------------------------------------

"@

        try {
            git show "$branch:$javaFile" |
                Out-File -FilePath $outputFile -Append -Encoding UTF8
        }
        catch {
            Add-Content $outputFile "❌ Error al leer el fichero.`n"
        }

        Add-Content $outputFile "`n"
    }

    Write-Host "✔ Exportado: $outputFile"
}

Write-Host "`nProceso finalizado. Revisa la carpeta 'exports'."
