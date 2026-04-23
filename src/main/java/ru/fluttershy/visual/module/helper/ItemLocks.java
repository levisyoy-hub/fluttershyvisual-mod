package ru.fluttershy.visual.module.helper;

import ru.fluttershy.visual.module.Category;
import ru.fluttershy.visual.module.Module;
import ru.fluttershy.visual.setting.BooleanSetting;

public class ItemLocks extends Module {
    public final BooleanSetting protectDrop = new BooleanSetting("Protect Drop", "Prevent dropping", true);
    public final BooleanSetting protectCraft = new BooleanSetting("Protect Craft", "Prevent crafting", true);
    public final BooleanSetting protectInventory = new BooleanSetting("Protect Inventory", "Prevent moving items", true);

    public ItemLocks() {
        super("ITEMLOCKS", "Protect items from removal", Category.HELPER);
        addSetting(protectDrop);
        addSetting(protectCraft);
        addSetting(protectInventory);
    }
}
