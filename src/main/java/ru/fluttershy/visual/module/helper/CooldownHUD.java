package ru.fluttershy.visual.module.helper;

import ru.fluttershy.visual.module.Category;
import ru.fluttershy.visual.module.Module;
import ru.fluttershy.visual.setting.BooleanSetting;

public class CooldownHUD extends Module {
    public final BooleanSetting showNumbers = new BooleanSetting("Show Numbers", "Display cooldown numbers", true);
    public final BooleanSetting showBar = new BooleanSetting("Show Bar", "Display cooldown bar", true);

    public CooldownHUD() {
        super("COOLDOWN HUD", "Show item cooldown on hotbar", Category.HELPER);
        addSetting(showNumbers);
        addSetting(showBar);
    }
}
