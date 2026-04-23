package ru.fluttershy.visual.module;

import ru.fluttershy.visual.setting.Setting;
import java.util.ArrayList;
import java.util.List;

public abstract class Module {
    protected String name;
    protected String description;
    protected Category category;
    protected boolean enabled = false;
    protected List<Setting<?>> settings = new ArrayList<>();

    public Module(String name, String description, Category category) {
        this.name = name;
        this.description = description;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Category getCategory() {
        return category;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
        if (enabled) {
            onEnable();
        } else {
            onDisable();
        }
    }

    public List<Setting<?>> getSettings() {
        return settings;
    }

    protected void addSetting(Setting<?> setting) {
        settings.add(setting);
    }

    public void onEnable() {
    }

    public void onDisable() {
    }

    public void onUpdate() {
    }

    public void onRender() {
    }
}
