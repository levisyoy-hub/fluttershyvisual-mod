package ru.fluttershy.visual.module.gameplay;

import ru.fluttershy.visual.module.Category;
import ru.fluttershy.visual.module.Module;
import ru.fluttershy.visual.setting.BooleanSetting;

public class GPS extends Module {
    public final BooleanSetting showArrow = new BooleanSetting("Show Arrow", "Display direction arrow", true);
    public final BooleanSetting showDistance = new BooleanSetting("Show Distance", "Display distance info", true);

    public GPS() {
        super("GPS", "Navigate to coordinates", Category.GAMEPLAY);
        addSetting(showArrow);
        addSetting(showDistance);
    }
}
