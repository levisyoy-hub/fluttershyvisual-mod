package ru.fluttershy.visual.module.helper;

import ru.fluttershy.visual.module.Category;
import ru.fluttershy.visual.module.Module;
import ru.fluttershy.visual.setting.IntegerSetting;

public class Freecam extends Module {
    public final IntegerSetting radius = new IntegerSetting("Radius", "Max distance from player", 50, 10, 200);
    public final IntegerSetting speed = new IntegerSetting("Speed", "Movement speed", 5, 1, 20);

    public Freecam() {
        super("FREECAM", "Detached camera flight", Category.HELPER);
        addSetting(radius);
        addSetting(speed);
    }
}
