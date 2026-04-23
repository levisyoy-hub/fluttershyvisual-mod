package ru.fluttershy.visual.module.render;

import ru.fluttershy.visual.module.Category;
import ru.fluttershy.visual.module.Module;
import ru.fluttershy.visual.setting.ColorSetting;
import ru.fluttershy.visual.setting.IntegerSetting;

public class Trajectory extends Module {
    public final ColorSetting lineColor = new ColorSetting("Line Color", "Color of trajectory line", 0xFFFF0000);
    public final IntegerSetting thickness = new IntegerSetting("Thickness", "Line thickness", 2, 1, 5);
    public final IntegerSetting alpha = new IntegerSetting("Alpha", "Transparency (0-255)", 200, 0, 255);

    public Trajectory() {
        super("TRAJECTORY", "Shows trajectory of projectiles", Category.RENDER);
        addSetting(lineColor);
        addSetting(thickness);
        addSetting(alpha);
    }
}
