package ru.fluttershy.visual.setting;

public class ColorSetting extends Setting<Integer> {
    public ColorSetting(String name, String description, Integer defaultValue) {
        super(name, description, defaultValue);
    }

    public int getRed() {
        return (value >> 16) & 0xFF;
    }

    public int getGreen() {
        return (value >> 8) & 0xFF;
    }

    public int getBlue() {
        return value & 0xFF;
    }

    public int getAlpha() {
        return (value >> 24) & 0xFF;
    }

    public void setRGB(int r, int g, int b) {
        this.value = ((r & 0xFF) << 16) | ((g & 0xFF) << 8) | (b & 0xFF) | (getAlpha() << 24);
    }

    public void setRGBA(int r, int g, int b, int a) {
        this.value = ((a & 0xFF) << 24) | ((r & 0xFF) << 16) | ((g & 0xFF) << 8) | (b & 0xFF);
    }

    @Override
    public String getStringValue() {
        return Integer.toHexString(value);
    }

    @Override
    public void setStringValue(String value) {
        try {
            this.value = (int) Long.parseLong(value, 16);
        } catch (NumberFormatException e) {
            // Ignore invalid input
        }
    }
}
