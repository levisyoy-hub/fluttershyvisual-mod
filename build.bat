@echo off
REM FluttershyVisual Build Script
REM Minecraft 1.21.4 Fabric Mod

echo.
echo ====================================================
echo FluttershyVisual - Fabric 1.21.4 Mod Builder
echo ====================================================
echo.

REM Check if Gradle wrapper exists
if not exist gradlew.bat (
    echo ERROR: gradlew.bat not found!
    echo Please ensure you're in the correct directory.
    pause
    exit /b 1
)

REM Check Java version
java -version >nul 2>&1
if errorlevel 1 (
    echo ERROR: Java not found!
    echo Please install Java 21 JDK from https://www.oracle.com/java/
    pause
    exit /b 1
)

echo [1/5] Cleaning previous builds...
call gradlew clean

if errorlevel 1 (
    echo ERROR: Clean failed!
    pause
    exit /b 1
)

echo [2/5] Downloading dependencies...
call gradlew --refresh-dependencies

if errorlevel 1 (
    echo ERROR: Dependency download failed!
    pause
    exit /b 1
)

echo [3/5] Compiling Java classes...
call gradlew compileJava

if errorlevel 1 (
    echo ERROR: Compilation failed!
    pause
    exit /b 1
)

echo [4/5] Building JAR file...
call gradlew build

if errorlevel 1 (
    echo ERROR: Build failed!
    pause
    exit /b 1
)

echo [5/5] Build complete!
echo.
echo ====================================================
echo BUILD SUCCESSFUL!
echo ====================================================
echo.
echo JAR Location: build\libs\fluttershyvisual-1.0.0.jar
echo.
echo Installation:
echo 1. Copy the JAR file to %%APPDATA%%\.minecraft\mods\
echo 2. Launch Minecraft with Fabric Loader
echo 3. Press RIGHT SHIFT to open ClickGUI
echo.
echo For testing, run: gradlew runClient
echo.
pause
