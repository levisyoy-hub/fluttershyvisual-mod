package ru.fluttershy.visual.module.render;

import ru.fluttershy.visual.module.Category;
import ru.fluttershy.visual.module.Module;
import ru.fluttershy.visual.setting.ColorSetting;
import ru.fluttershy.visual.setting.IntegerSetting;

public class RedOverlay extends Module {
    public final ColorSetting highlightColor = new ColorSetting("Highlight Color", "Valuable item highlight color", 0xFFFF0000);
    public final IntegerSetting alpha = new IntegerSetting("Alpha", "Highlight transparency", 200, 0, 255);

    public RedOverlay() {
        super("RED OVERLAY", "Highlight valuable dropped items", Category.RENDER);
        addSetting(highlightColor);
        addSetting(alpha);
    }
}
