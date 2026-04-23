package ru.fluttershy.visual.module.render;

import ru.fluttershy.visual.module.Category;
import ru.fluttershy.visual.module.Module;
import ru.fluttershy.visual.setting.BooleanSetting;
import ru.fluttershy.visual.setting.ColorSetting;

public class TopkaTags extends Module {
    public final BooleanSetting showHealth = new BooleanSetting("Show Health", "Display health bar", true);
    public final BooleanSetting showDistance = new BooleanSetting("Show Distance", "Display distance", true);
    public final BooleanSetting throughWalls = new BooleanSetting("Through Walls", "See through walls", false);
    public final ColorSetting healthColor = new ColorSetting("Health Color", "Color of health bar", 0xFF00FF00);
    public final ColorSetting nameColor = new ColorSetting("Name Color", "Color of player name", 0xFFFFFFFF);

    public TopkaTags() {
        super("TOPKATAGS", "Nameplate with player info", Category.RENDER);
        addSetting(showHealth);
        addSetting(showDistance);
        addSetting(throughWalls);
        addSetting(healthColor);
        addSetting(nameColor);
    }
}
