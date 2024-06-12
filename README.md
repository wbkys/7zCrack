# 7zCrack
A combination method for cracking 7zip package passwords using PowerShell on Windows. This method includes collecting commonly used combination passwords as well as generating specified character combination passwords, with the ability to set length restrictions.


powershell code:

$7zPath = "C:\Program Files\7-Zip\7z.exe"
$compressedFile = "xxxxxxxxxx.7z"
Get-Content -Path pass.txt | ForEach-Object {
    $password = $_
    $result = & $7zPath "t" -p"$password" $compressedFile 2>&1
    if ($LASTEXITCODE -eq 0) {
        Write-Output "Success! Password is: $password"
    }
}
