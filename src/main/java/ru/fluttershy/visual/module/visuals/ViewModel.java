package ru.fluttershy.visual.module.visuals;

import ru.fluttershy.visual.module.Category;
import ru.fluttershy.visual.module.Module;
import ru.fluttershy.visual.setting.IntegerSetting;

public class ViewModel extends Module {
    public final IntegerSetting posX = new IntegerSetting("X Position", "Item X position", 0, -10, 10);
    public final IntegerSetting posY = new IntegerSetting("Y Position", "Item Y position", 0, -10, 10);
    public final IntegerSetting posZ = new IntegerSetting("Z Position", "Item Z position", 0, -10, 10);
    public final IntegerSetting rotX = new IntegerSetting("Rotation X", "Item X rotation", 0, -180, 180);
    public final IntegerSetting rotY = new IntegerSetting("Rotation Y", "Item Y rotation", 0, -180, 180);
    public final IntegerSetting scale = new IntegerSetting("Scale", "Item scale", 100, 50, 200);

    public ViewModel() {
        super("VIEWMODEL", "Customize item in hand", Category.VISUALS);
        addSetting(posX);
        addSetting(posY);
        addSetting(posZ);
        addSetting(rotX);
        addSetting(rotY);
        addSetting(scale);
    }
}
