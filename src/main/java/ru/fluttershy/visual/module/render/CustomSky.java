package ru.fluttershy.visual.module.render;

import ru.fluttershy.visual.module.Category;
import ru.fluttershy.visual.module.Module;
import ru.fluttershy.visual.setting.BooleanSetting;
import ru.fluttershy.visual.setting.ColorSetting;
import ru.fluttershy.visual.setting.IntegerSetting;

public class CustomSky extends Module {
    public final ColorSetting skyColor = new ColorSetting("Sky Color", "Custom sky color", 0xFF87CEEB);
    public final ColorSetting cloudColor = new ColorSetting("Cloud Color", "Custom cloud color", 0xFFFFFFFF);
    public final IntegerSetting cloudAlpha = new IntegerSetting("Cloud Alpha", "Cloud transparency", 200, 0, 255);
    public final BooleanSetting showStars = new BooleanSetting("Show Stars", "Display stars", true);
    public final BooleanSetting animation = new BooleanSetting("Animation", "Enable animation", true);

    public CustomSky() {
        super("CUSTOM SKY", "Customize sky appearance", Category.RENDER);
        addSetting(skyColor);
        addSetting(cloudColor);
        addSetting(cloudAlpha);
        addSetting(showStars);
        addSetting(animation);
    }
}
