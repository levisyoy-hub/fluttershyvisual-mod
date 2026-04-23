package ru.fluttershy.visual.config;

import com.google.gson.*;
import ru.fluttershy.visual.FsvMod;
import ru.fluttershy.visual.module.Module;
import ru.fluttershy.visual.module.ModuleManager;
import ru.fluttershy.visual.setting.Setting;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ConfigManager {
    private static final ConfigManager INSTANCE = new ConfigManager();
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private final Path configDir;
    private final File configFile;

    public static ConfigManager getInstance() {
        return INSTANCE;
    }

    public ConfigManager() {
        String mcDir = System.getProperty("user.dir");
        this.configDir = Paths.get(mcDir, "config", "fluttershyvisual");
        this.configFile = configDir.resolve("config.json").toFile();

        try {
            Files.createDirectories(configDir);
        } catch (IOException e) {
            FsvMod.LOGGER.error("Failed to create config directory", e);
        }
    }

    public void save() {
        try {
            JsonObject root = new JsonObject();
            ModuleManager manager = ModuleManager.getInstance();

            for (Module module : manager.getModules()) {
                JsonObject moduleObj = new JsonObject();
                moduleObj.addProperty("enabled", module.isEnabled());

                JsonObject settingsObj = new JsonObject();
                for (Setting<?> setting : module.getSettings()) {
                    settingsObj.addProperty(setting.getName(), setting.getStringValue());
                }

                moduleObj.add("settings", settingsObj);
                root.add(module.getName(), moduleObj);
            }

            try (FileWriter writer = new FileWriter(configFile)) {
                GSON.toJson(root, writer);
            }

            FsvMod.LOGGER.info("Config saved to " + configFile.getAbsolutePath());
        } catch (IOException e) {
            FsvMod.LOGGER.error("Failed to save config", e);
        }
    }

    public void load() {
        if (!configFile.exists()) {
            FsvMod.LOGGER.info("Config file not found, creating default config");
            return;
        }

        try {
            JsonObject root = JsonParser.parseReader(new FileReader(configFile)).getAsJsonObject();
            ModuleManager manager = ModuleManager.getInstance();

            for (Module module : manager.getModules()) {
                if (root.has(module.getName())) {
                    JsonObject moduleObj = root.getAsJsonObject(module.getName());

                    if (moduleObj.has("enabled")) {
                        module.setEnabled(moduleObj.get("enabled").getAsBoolean());
                    }

                    if (moduleObj.has("settings")) {
                        JsonObject settingsObj = moduleObj.getAsJsonObject("settings");
                        for (Setting<?> setting : module.getSettings()) {
                            if (settingsObj.has(setting.getName())) {
                                setting.setStringValue(settingsObj.get(setting.getName()).getAsString());
                            }
                        }
                    }
                }
            }

            FsvMod.LOGGER.info("Config loaded from " + configFile.getAbsolutePath());
        } catch (IOException e) {
            FsvMod.LOGGER.error("Failed to load config", e);
        }
    }

    public Path getConfigDir() {
        return configDir;
    }

    public File getConfigFile() {
        return configFile;
    }
}
