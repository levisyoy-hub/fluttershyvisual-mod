package ru.fluttershy.visual.module.visuals;

import ru.fluttershy.visual.module.Category;
import ru.fluttershy.visual.module.Module;
import ru.fluttershy.visual.setting.ColorSetting;

public class ShulkerVisual extends Module {
    public final ColorSetting fullColor = new ColorSetting("Full Color", "Filled shulker color", 0xFFFF0000);

    public ShulkerVisual() {
        super("SHULKER VISUAL", "Highlight filled shulkers", Category.VISUALS);
        addSetting(fullColor);
    }
}
