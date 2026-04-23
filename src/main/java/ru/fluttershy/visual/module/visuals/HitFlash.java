package ru.fluttershy.visual.module.visuals;

import ru.fluttershy.visual.module.Category;
import ru.fluttershy.visual.module.Module;
import ru.fluttershy.visual.setting.ColorSetting;
import ru.fluttershy.visual.setting.IntegerSetting;

public class HitFlash extends Module {
    public final ColorSetting flashColor = new ColorSetting("Flash Color", "Critical hit flash color", 0xFFFFAA00);
    public final IntegerSetting duration = new IntegerSetting("Duration", "Flash duration (ticks)", 3, 1, 20);

    public HitFlash() {
        super("HITFLASH", "Critical hit highlight", Category.VISUALS);
        addSetting(flashColor);
        addSetting(duration);
    }
}
