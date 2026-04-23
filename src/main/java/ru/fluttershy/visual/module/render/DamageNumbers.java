package ru.fluttershy.visual.module.render;

import ru.fluttershy.visual.module.Category;
import ru.fluttershy.visual.module.Module;
import ru.fluttershy.visual.setting.ColorSetting;

public class DamageNumbers extends Module {
    public final ColorSetting meleColor = new ColorSetting("Melee Color", "Color for melee damage", 0xFFFFFFFF);
    public final ColorSetting magicColor = new ColorSetting("Magic Color", "Color for magic damage", 0xFF5555FF);
    public final ColorSetting fireColor = new ColorSetting("Fire Color", "Color for fire damage", 0xFFFF5555);
    public final ColorSetting poisonColor = new ColorSetting("Poison Color", "Color for poison damage", 0xFF55FF55);

    public DamageNumbers() {
        super("DAMAGE NUMBERS", "Show damage numbers above entities", Category.RENDER);
        addSetting(meleColor);
        addSetting(magicColor);
        addSetting(fireColor);
        addSetting(poisonColor);
    }
}
