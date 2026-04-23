package ru.fluttershy.visual.module.helper;

import ru.fluttershy.visual.module.Category;
import ru.fluttershy.visual.module.Module;
import ru.fluttershy.visual.setting.BooleanSetting;

public class TargetHUD extends Module {
    public final BooleanSetting showHealth = new BooleanSetting("Show Health", "Display target health", true);
    public final BooleanSetting showArmor = new BooleanSetting("Show Armor", "Display target armor", true);
    public final BooleanSetting showCooldowns = new BooleanSetting("Show Cooldowns", "Display target cooldowns", true);

    public TargetHUD() {
        super("TARGET HUD", "Info about targeted player", Category.HELPER);
        addSetting(showHealth);
        addSetting(showArmor);
        addSetting(showCooldowns);
    }
}
