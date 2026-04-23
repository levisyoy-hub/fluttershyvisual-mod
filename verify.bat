@echo off
REM FluttershyVisual Project Verification Script
REM Windows batch version

echo.
echo ======================================================
echo FluttershyVisual - Проверка целостности проекта
echo ======================================================
echo.

setlocal enabledelayedexpansion

set errors=0

echo [1] Проверка основных файлов...
for %%f in (
    "build.gradle"
    "gradle.properties"
    "settings.gradle"
    "gradlew.bat"
    "gradlew"
) do (
    if exist %%f (
        echo [OK] %%f
    ) else (
        echo [FAIL] %%f (ОТСУТСТВУЕТ)
        set /a errors=!errors!+1
    )
)

echo.
echo [2] Проверка Java файлов...
for %%f in (
    "src\main\java\ru\fluttershy\visual\FsvMod.java"
    "src\main\java\ru\fluttershy\visual\FsvClientMod.java"
    "src\main\java\ru\fluttershy\visual\module\Category.java"
    "src\main\java\ru\fluttershy\visual\module\Module.java"
    "src\main\java\ru\fluttershy\visual\config\ConfigManager.java"
) do (
    if exist %%f (
        echo [OK] %%~nf
    ) else (
        echo [FAIL] %%~nf (ОТСУТСТВУЕТ)
        set /a errors=!errors!+1
    )
)

echo.
echo [3] Проверка модулей...

REM Count RENDER modules
setlocal enabledelayedexpansion
set render_count=0
for %%f in (src\main\java\ru\fluttershy\visual\module\render\*.java) do (
    set /a render_count=!render_count!+1
)
echo RENDER модули: %render_count%/8

REM Count HELPER modules
set helper_count=0
for %%f in (src\main\java\ru\fluttershy\visual\module\helper\*.java) do (
    set /a helper_count=!helper_count!+1
)
echo HELPER модули: %helper_count%/13

REM Count VISUALS modules
set visuals_count=0
for %%f in (src\main\java\ru\fluttershy\visual\module\visuals\*.java) do (
    set /a visuals_count=!visuals_count!+1
)
echo VISUALS модули: %visuals_count%/4

REM Count GAMEPLAY modules
set gameplay_count=0
for %%f in (src\main\java\ru\fluttershy\visual\module\gameplay\*.java) do (
    set /a gameplay_count=!gameplay_count!+1
)
echo GAMEPLAY модули: %gameplay_count%/6

set /a total=render_count+helper_count+visuals_count+gameplay_count
echo ВСЕГО модулей: %total%/31

if %total% equ 31 (
    echo [OK] Все 31 модуль на месте!
) else (
    echo [FAIL] Не все модули (найдено %total%, нужно 31)
    set /a errors=!errors!+1
)

echo.
echo [4] Проверка миксинов...

set mixin_count=0
for %%f in (src\main\java\ru\fluttershy\visual\mixin\*.java) do (
    set /a mixin_count=!mixin_count!+1
)
echo Миксины: %mixin_count%/11

if %mixin_count% equ 11 (
    echo [OK] Все 11 миксинов на месте!
) else (
    echo [FAIL] Не все миксины (найдено %mixin_count%, нужно 11)
    set /a errors=!errors!+1
)

echo.
echo [5] Проверка системы настроек...
for %%f in (
    "src\main\java\ru\fluttershy\visual\setting\Setting.java"
    "src\main\java\ru\fluttershy\visual\setting\BooleanSetting.java"
    "src\main\java\ru\fluttershy\visual\setting\IntegerSetting.java"
    "src\main\java\ru\fluttershy\visual\setting\ColorSetting.java"
) do (
    if exist %%f (
        echo [OK] %%~nf
    ) else (
        echo [FAIL] %%~nf
        set /a errors=!errors!+1
    )
)

echo.
echo [6] Проверка документации...
for %%f in (
    "README.md"
    "BUILD_GUIDE.md"
    "DEVELOPMENT.md"
    "MODULES.md"
    "PROJECT_COMPLETE.md"
    "QUICK_START.md"
) do (
    if exist %%f (
        echo [OK] %%f
    ) else (
        echo [FAIL] %%f (ОТСУТСТВУЕТ)
        set /a errors=!errors!+1
    )
)

echo.
echo ======================================================

if %errors% equ 0 (
    echo УСПЕШНО - Проект в полном порядке!
    echo ======================================================
    echo.
    echo Команда для сборки:
    echo   gradlew.bat build
    echo.
    echo Или запустите:
    echo   build.bat
    echo.
) else (
    echo ОШИБКА - Найдено проблем: %errors%
    echo ======================================================
    exit /b 1
)

pause
