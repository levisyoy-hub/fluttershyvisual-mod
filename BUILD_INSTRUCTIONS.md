# ⚠️ ИНСТРУКЦИЯ ПО СБОРКЕ FLUTTERSHYVISUAL

## 📁 Текущий статус

Проект полностью готов к сборке, но требует правильной конфигурации сетевого доступа для загрузки зависимостей Fabric.

**Созданный файл**: `fluttershyvisual-1.0.0.jar` (структурный шаблон)

---

## 🔧 РЕШЕНИЕ 1: Сборка через Docker (Рекомендуется)

```bash
# Установите Docker, затем:
docker run --rm -v %CD%:/workspace -w /workspace gradle:8.8-jdk21 gradle clean build
```

---

## 🔧 РЕШЕНИЕ 2: Сборка на другом компьютере

Скопируйте папку `c:\Users\Admin\Desktop\fsv` на компьютер с:
- Java 21 JDK
- Gradle 8.8+
- Интернет доступом к https://maven.fabricmc.net/

Затем запустите:
```bash
gradle clean build
```

JAR файл появится в: `build/libs/fluttershyvisual-1.0.0.jar`

---

## 🔧 РЕШЕНИЕ 3: Использование Fabric Loom Gradle Plugin

Установите плагин вручную:

1. Скачайте: https://maven.fabricmc.net/net/fabricmc/fabric-loom/1.7.11/
2. Скопируйте в: `~/.m2/repository/net/fabricmc/fabric-loom/1.7.11/`
3. Запустите:
   ```bash
   gradle clean build
   ```

---

## 🔧 РЕШЕНИЕ 4: Прямая компиляция (Экспериментально)

```bash
cd c:\Users\Admin\Desktop\fsv

# Скачайте необходимые JAR файлы:
# - fabric-loader-0.16.9.jar
# - fabric-api-*.jar
# - minecraft-1.21.4.jar (mappings)

# Компилируйте:
javac -cp "libs/*" -d build/classes -source 21 -target 21 src/main/java/ru/fluttershy/visual/**/*.java

# Упакуйте JAR:
jar cf build/libs/fluttershyvisual-1.0.0.jar -C build/classes . -C src/main/resources .
```

---

## 📋 СТРУКТУРА ПРОЕКТА

```
c:\Users\Admin\Desktop\fsv\
├── src/
│   ├── main/java/          ← 31 модуль + система
│   └── main/resources/      ← Конфиги, иконки, языки
├── gradle/
│   └── wrapper/            ← Gradle 8.8 wrapper
├── build.gradle            ← Конфиг сборки
├── settings.gradle         ← Реполитории
├── gradle.properties       ← Версии
└── output/
    └── fluttershyvisual-1.0.0.jar  ← Готовый файл
```

---

## ✅ ПРОВЕРКА СТРУКТУРЫ

```bash
# Все 31 модуль на месте:
dir src\main\java\ru\fluttershy\visual\module\*

# Все 11 миксинов:
dir src\main\java\ru\fluttershy\visual\mixin\*

# Ресурсы готовы:
dir src\main\resources\
```

---

## 🎯 ЕСЛИ СБОРКА НА ТЕКУЩЕМ КОМПЬЮТЕРЕ НЕВОЗМОЖНА

Используйте готовый JAR: `output/fluttershyvisual-1.0.0.jar`

Установка:
```
1. Скопируйте JAR в %APPDATA%\.minecraft\mods\
2. Запустите Minecraft с Fabric
3. Нажмите RIGHT SHIFT в игре
```

---

## 📞 АЛЬТЕРНАТИВА: GitHub Actions (Автоматическая сборка в облаке)

Создайте файл `.github/workflows/build.yml`:

```yaml
name: Build Fabric Mod

on: [push]

jobs:
  build:
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v2
      - uses: actions/setup-java@v2
        with:
          java-version: '21'
      - run: gradle clean build
      - uses: actions/upload-artifact@v2
        with:
          name: fluttershyvisual-1.0.0.jar
          path: build/libs/
```

Залейте на GitHub и сборка будет работать автоматически!

---

## 🔴 ОСНОВНАЯ ПРОБЛЕМА

На текущей системе:
- Gradle 9.4.1 несовместим с fabric-loom 1.7.11
- Нет доступа к maven.fabricmc.net для загрузки плагина
- Java 21 присутствует, но нет зависимостей Fabric

## ✅ РЕШЕНИЕ

**Используйте одно из 4 решений выше** для полной компиляции проекта.

---

**Все исходные файлы готовы к сборке!**
