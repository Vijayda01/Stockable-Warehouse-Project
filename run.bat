@echo off
setlocal
cd /d "%~dp0"
where javac >nul 2>&1
if errorlevel 1 (
    echo JDK missing from PATH. Install JDK 17 or newer and enable Add to PATH.
    pause
    exit /b 1
)
javac -d out src/Stockable.java src/WarehouseItem.java src/Main.java
if errorlevel 1 (
    echo Compilation failed. See the error above.
    pause
    exit /b 1
)
java -cp out Main
pause
