# 🚀 КОМАНДЫ ДЛЯ КОМПИЛЯЦИИ И ИСПОЛЬЗОВАНИЯ

## ⚡ БЫСТРАЯ КОМАНДА (Windows)

```batch
cd c:\Users\Admin\Desktop\fsv
build.bat
```

**Это сделает всё автоматически!**

---

## 🔧 АЛЬТЕРНАТИВНЫЕ СПОСОБЫ

### Способ 1: Gradle wrapper (Windows)
```bash
cd c:\Users\Admin\Desktop\fsv
.\gradlew.bat build
```

### Способ 2: Gradle wrapper (Linux/Mac)
```bash
cd /путь/к/fsv
./gradlew build
```

### Способ 3: Если установлен gradle в системе
```bash
cd c:\Users\Admin\Desktop\fsv
gradle build
```

### Способ 4: Только компиляция (без упаковки)
```bash
.\gradlew.bat compileJava
```

### Способ 5: Очистка перед сборкой
```bash
.\gradlew.bat clean build
```

### Способ 6: С обновлением зависимостей
```bash
.\gradlew.bat clean build --refresh-dependencies
```

---

## 🎮 ЗАПУСК В РЕЖИМЕ РАЗРАБОТКИ

### Запустить тестовый клиент Minecraft
```bash
.\gradlew.bat runClient
```

### Запустить тестовый сервер Minecraft
```bash
.\gradlew.bat runServer
```

---

## 📦 ГЕНЕРАЦИЯ ИСХОДНИКОВ

### Декомпилировать Minecraft
```bash
.\gradlew.bat genSources
```

### Сгенерировать IDE конфиги (IntelliJ)
```bash
.\gradlew.bat idea
```

### Сгенерировать IDE конфиги (Eclipse)
```bash
.\gradlew.bat eclipse
```

---

## 🧪 ПРОВЕРКА ПРОЕКТА

### Проверить целостность (Windows)
```bash
.\verify.bat
```

### Проверить целостность (Linux/Mac)
```bash
bash verify.sh
```

### Показать помощь Gradle
```bash
.\gradlew.bat help
```

---

## 📍 РЕЗУЛЬТАТ СБОРКИ

После успешной сборки JAR находится здесь:

```
c:\Users\Admin\Desktop\fsv\build\libs\fluttershyvisual-1.0.0.jar
```

### Проверить наличие JAR
```bash
dir build\libs\*.jar
```

### Скопировать JAR в mods папку
```batch
copy build\libs\fluttershyvisual-1.0.0.jar %APPDATA%\.minecraft\mods\
```

Или на Linux/Mac:
```bash
cp build/libs/fluttershyvisual-1.0.0.jar ~/.minecraft/mods/
```

---

## 🎮 ЗАПУСК ИГРЫ

### 1. Выпустить из IDE (в режиме разработки)
```bash
.\gradlew.bat runClient
```

### 2. Запустить Minecraft с мод-лаунчером
- Откройте Minecraft Launcher
- Выберите профиль **Fabric**
- Запустите игру
- Мод загрузится автоматически

### 3. Открыть ClickGUI
- Нажмите **RIGHT SHIFT** в игре
- Откроется интерфейс с 4 категориями модулей

---

## 🔍 ОТЛАДКА

### Если сборка не удаётся

**Шаг 1: Очистить кэш**
```bash
.\gradlew.bat clean
```

**Шаг 2: Обновить зависимости**
```bash
.\gradlew.bat --refresh-dependencies
```

**Шаг 3: Пересобрать**
```bash
.\gradlew.bat build
```

### Если Java не найдена
```bash
# Проверить версию Java
java -version

# Должна быть Java 21 или выше!
# Скачайте: https://www.oracle.com/java/technologies/downloads/
```

### Если Gradle не найден
```bash
# Убедитесь, что вы в правильной папке
cd c:\Users\Admin\Desktop\fsv

# Используйте батник вместо прямого gradle
.\gradlew.bat build
```

---

## 📊 ВЫВОД КОМПИЛЯЦИИ

Успешная сборка должна показать:
```
BUILD SUCCESSFUL

Total time: X.XXXs
Finished 'build' in XXms
```

JAR создаётся в:
```
build/libs/fluttershyvisual-1.0.0.jar
```

---

## 🛠️ РАСШИРЕННЫЕ ОПЦИИ

### Параллельная сборка (быстрее)
```bash
.\gradlew.bat build --parallel
```

### Без демона (медленнее, но безопаснее)
```bash
.\gradlew.bat build --no-daemon
```

### Максимум логирования
```bash
.\gradlew.bat build --debug
```

### Минимум логирования
```bash
.\gradlew.bat build --quiet
```

---

## 📝 СКРИПТЫ

### Windows Batch файлы
- **build.bat** - Автоматическая сборка
- **verify.bat** - Проверка проекта

### Запустить сборку
```batch
build.bat
```

### Запустить проверку
```batch
verify.bat
```

---

## 🎯 ТИПИЧНЫЙ РАБОЧИЙ ПРОЦЕСС

### 1-й раз (Первая сборка)
```bash
cd c:\Users\Admin\Desktop\fsv
.\gradlew.bat build
# Ждите 2-5 минут (загрузка зависимостей)
```

### Последующие сборки
```bash
cd c:\Users\Admin\Desktop\fsv
build.bat
# Или: .\gradlew.bat build
```

### Быстрая проверка
```bash
.\gradlew.bat compileJava
```

### Установка
```bash
copy build\libs\fluttershyvisual-1.0.0.jar %APPDATA%\.minecraft\mods\
```

### Запуск
```bash
# Запустите Minecraft с Fabric
# Нажмите RIGHT SHIFT в игре
```

---

## ✨ ГОТОВО!

**Выберите одну из команд выше и начните сборку!**

```
Рекомендуемый способ:
cd c:\Users\Admin\Desktop\fsv
build.bat
```

Просто, быстро, эффективно! 🚀

---

## 📞 ВОПРОСЫ?

- 📖 Смотрите **BUILD_GUIDE.md** для подробной инструкции
- 🔍 Смотрите **DEVELOPMENT.md** для разработки
- 📋 Смотрите **FILE_LIST.md** для списка всех файлов

---

**Удачи в разработке! 🎮✨**
