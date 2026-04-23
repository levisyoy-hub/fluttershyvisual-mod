package ru.fluttershy.visual.module.helper;

import ru.fluttershy.visual.module.Category;
import ru.fluttershy.visual.module.Module;
import ru.fluttershy.visual.setting.BooleanSetting;

public class PotionsArmorHUD extends Module {
    public final BooleanSetting showPotions = new BooleanSetting("Show Potions", "Display active potions", true);
    public final BooleanSetting showArmor = new BooleanSetting("Show Armor", "Display armor durability", true);

    public PotionsArmorHUD() {
        super("POTIONS + ARMOR HUD", "Show potions and armor", Category.HELPER);
        addSetting(showPotions);
        addSetting(showArmor);
    }
}
