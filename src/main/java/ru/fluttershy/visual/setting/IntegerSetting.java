package ru.fluttershy.visual.setting;

public class IntegerSetting extends Setting<Integer> {
    private int min;
    private int max;

    public IntegerSetting(String name, String description, Integer defaultValue, int min, int max) {
        super(name, description, defaultValue);
        this.min = min;
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    @Override
    public String getStringValue() {
        return String.valueOf(value);
    }

    @Override
    public void setStringValue(String value) {
        try {
            int parsed = Integer.parseInt(value);
            this.value = Math.clamp(parsed, min, max);
        } catch (NumberFormatException e) {
            // Ignore invalid input
        }
    }
}
