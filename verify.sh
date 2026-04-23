#!/bin/bash
# FluttershyVisual Project Verification Script
# Проверка целостности проекта

echo "======================================"
echo "FluttershyVisual - Проверка проекта"
echo "======================================"
echo ""

# Colors
RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
NC='\033[0m'

errors=0

# Check main files
echo "[1] Проверка основных файлов..."
files=(
    "build.gradle"
    "gradle.properties"
    "settings.gradle"
    "gradlew.bat"
    "gradlew"
    "src/main/resources/fabric.mod.json"
    "src/main/resources/fluttershyvisual.mixins.json"
)

for file in "${files[@]}"; do
    if [ -f "$file" ]; then
        echo -e "${GREEN}✓${NC} $file"
    else
        echo -e "${RED}✗${NC} $file (ОТСУТСТВУЕТ)"
        errors=$((errors + 1))
    fi
done

# Check Java files structure
echo ""
echo "[2] Проверка Java файлов..."

java_check=(
    "src/main/java/ru/fluttershy/visual/FsvMod.java"
    "src/main/java/ru/fluttershy/visual/FsvClientMod.java"
    "src/main/java/ru/fluttershy/visual/module/Category.java"
    "src/main/java/ru/fluttershy/visual/module/Module.java"
    "src/main/java/ru/fluttershy/visual/module/ModuleManager.java"
    "src/main/java/ru/fluttershy/visual/config/ConfigManager.java"
    "src/main/java/ru/fluttershy/visual/ui/ClickGUI.java"
)

for file in "${java_check[@]}"; do
    if [ -f "$file" ]; then
        echo -e "${GREEN}✓${NC} $(basename $file)"
    else
        echo -e "${RED}✗${NC} $(basename $file) (ОТСУТСТВУЕТ)"
        errors=$((errors + 1))
    fi
done

# Count modules
echo ""
echo "[3] Проверка модулей..."

render_count=$(find src/main/java/ru/fluttershy/visual/module/render -name "*.java" | wc -l)
helper_count=$(find src/main/java/ru/fluttershy/visual/module/helper -name "*.java" | wc -l)
visuals_count=$(find src/main/java/ru/fluttershy/visual/module/visuals -name "*.java" | wc -l)
gameplay_count=$(find src/main/java/ru/fluttershy/visual/module/gameplay -name "*.java" | wc -l)

echo "RENDER модули: $render_count/8"
echo "HELPER модули: $helper_count/13"
echo "VISUALS модули: $visuals_count/4"
echo "GAMEPLAY модули: $gameplay_count/6"

total=$((render_count + helper_count + visuals_count + gameplay_count))
echo "ВСЕГО модулей: $total/31"

if [ $total -eq 31 ]; then
    echo -e "${GREEN}✓ Все 31 модуль на месте!${NC}"
else
    echo -e "${RED}✗ Не все модули найдены (найдено $total, нужно 31)${NC}"
    errors=$((errors + 1))
fi

# Check mixins
echo ""
echo "[4] Проверка миксинов..."

mixin_count=$(find src/main/java/ru/fluttershy/visual/mixin -name "*.java" | wc -l)
echo "Миксины: $mixin_count/11"

if [ $mixin_count -eq 11 ]; then
    echo -e "${GREEN}✓ Все 11 миксинов на месте!${NC}"
else
    echo -e "${RED}✗ Не все миксины найдены (найдено $mixin_count, нужно 11)${NC}"
    errors=$((errors + 1))
fi

# Check settings system
echo ""
echo "[5] Проверка системы настроек..."

setting_files=(
    "src/main/java/ru/fluttershy/visual/setting/Setting.java"
    "src/main/java/ru/fluttershy/visual/setting/BooleanSetting.java"
    "src/main/java/ru/fluttershy/visual/setting/IntegerSetting.java"
    "src/main/java/ru/fluttershy/visual/setting/ColorSetting.java"
)

for file in "${setting_files[@]}"; do
    if [ -f "$file" ]; then
        echo -e "${GREEN}✓${NC} $(basename $file)"
    else
        echo -e "${RED}✗${NC} $(basename $file)"
        errors=$((errors + 1))
    fi
done

# Documentation check
echo ""
echo "[6] Проверка документации..."

docs=(
    "README.md"
    "BUILD_GUIDE.md"
    "DEVELOPMENT.md"
    "MODULES.md"
    "PROJECT_COMPLETE.md"
    "QUICK_START.md"
)

for doc in "${docs[@]}"; do
    if [ -f "$doc" ]; then
        echo -e "${GREEN}✓${NC} $doc"
    else
        echo -e "${RED}✗${NC} $doc (ОТСУТСТВУЕТ)"
        errors=$((errors + 1))
    fi
done

# Final result
echo ""
echo "======================================"
if [ $errors -eq 0 ]; then
    echo -e "${GREEN}✓ ПРОЕКТ В ПОЛНОМ ПОРЯДКЕ!${NC}"
    echo "======================================"
    echo ""
    echo "Готово к компиляции!"
    echo ""
    echo "Используйте команду:"
    echo "  ./gradlew build"
    echo ""
    exit 0
else
    echo -e "${RED}✗ НАЙДЕНО ОШИБОК: $errors${NC}"
    echo "======================================"
    exit 1
fi
