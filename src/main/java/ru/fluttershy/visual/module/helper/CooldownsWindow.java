package ru.fluttershy.visual.module.helper;

import ru.fluttershy.visual.module.Category;
import ru.fluttershy.visual.module.Module;
import ru.fluttershy.visual.setting.BooleanSetting;

public class CooldownsWindow extends Module {
    public final BooleanSetting draggable = new BooleanSetting("Draggable", "Enable drag and drop", true);

    public CooldownsWindow() {
        super("COOLDOWNS WINDOW", "Floating cooldown list", Category.HELPER);
        addSetting(draggable);
    }
}
