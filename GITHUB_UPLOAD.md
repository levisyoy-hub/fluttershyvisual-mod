# 📤 ИНСТРУКЦИЯ ПО ЗАГРУЗКЕ НА GITHUB

## ШАГ 1: Создайте репозиторий на GitHub

1. Откройте https://github.com/new
2. Заполните:
   - Repository name: `fluttershyvisual`
   - Description: `Fabric mod with 31 modules for Minecraft 1.21.4`
   - Visibility: Public
3. Нажмите "Create repository"

## ШАГ 2: Добавьте remote репозиторий

Замените `YOUR_USERNAME` на ваш GitHub логин:

```bash
cd C:\Users\Admin\Desktop\fsv
"C:\Program Files\Git\bin\git.exe" branch -M main
"C:\Program Files\Git\bin\git.exe" remote add origin https://github.com/YOUR_USERNAME/fluttershyvisual.git
```

## ШАГ 3: Загрузите код

Вас попросит ввести credentials. Используйте GitHub Personal Token:

```bash
"C:\Program Files\Git\bin\git.exe" push -u origin main
```

При запросе пароля используйте Personal Access Token (PAT):
- Создайте на https://github.com/settings/tokens
- Выберите `repo` scope
- Скопируйте токен и используйте как пароль

## ШАГ 4: Дождитесь сборки

После push'а GitHub Actions автоматически:
1. Скомпилирует мод
2. Создаст JAR файл
3. Загрузит артефакт

Смотрите на: https://github.com/YOUR_USERNAME/fluttershyvisual/actions

## ШАГ 5: Скачайте JAR

Когда сборка завершится (зеленая галочка):
1. Нажмите на workflow run
2. Прокрутите вниз до "Artifacts"
3. Скачайте "fluttershyvisual"
4. Распакуйте ZIP
5. Найдите .jar файл

---

**После загрузки JAR:**

Скопируйте `fluttershyvisual-1.0.0.jar` в:
```
%APPDATA%\.minecraft\mods\
```

Запустите Minecraft с Fabric профилем!
