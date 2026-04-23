package ru.fluttershy.visual.module.render;

import ru.fluttershy.visual.module.Category;
import ru.fluttershy.visual.module.Module;
import ru.fluttershy.visual.setting.IntegerSetting;

public class MotionBlur extends Module {
    public final IntegerSetting intensity = new IntegerSetting("Intensity", "Blur strength", 50, 0, 100);

    public MotionBlur() {
        super("MOTION BLUR", "Blur effect when moving", Category.RENDER);
        addSetting(intensity);
    }
}
