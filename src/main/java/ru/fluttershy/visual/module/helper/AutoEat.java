package ru.fluttershy.visual.module.helper;

import ru.fluttershy.visual.module.Category;
import ru.fluttershy.visual.module.Module;
import ru.fluttershy.visual.setting.IntegerSetting;

public class AutoEat extends Module {
    public final IntegerSetting hungerThreshold = new IntegerSetting("Hunger Threshold", "Start eating at hunger level", 6, 0, 20);

    public AutoEat() {
        super("AUTOEAT + CHESTSTEAL", "Auto-eat when hungry", Category.HELPER);
        addSetting(hungerThreshold);
    }
}
