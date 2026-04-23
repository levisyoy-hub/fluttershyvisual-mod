package ru.fluttershy.visual.setting;

public class BooleanSetting extends Setting<Boolean> {
    public BooleanSetting(String name, String description, Boolean defaultValue) {
        super(name, description, defaultValue);
    }

    @Override
    public String getStringValue() {
        return String.valueOf(value);
    }

    @Override
    public void setStringValue(String value) {
        this.value = Boolean.parseBoolean(value);
    }
}
