package ru.fluttershy.visual.module.render;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import ru.fluttershy.visual.module.Category;
import ru.fluttershy.visual.module.Module;
import ru.fluttershy.visual.setting.BooleanSetting;
import ru.fluttershy.visual.setting.ColorSetting;
import ru.fluttershy.visual.setting.IntegerSetting;

public class ESP3D extends Module {
    public final BooleanSetting friends = new BooleanSetting("Friends Different", "Show friends with different color", false);
    public final ColorSetting fillColor = new ColorSetting("Fill Color", "Color of ESP box fill", 0x4400FF00);
    public final ColorSetting outlineColor = new ColorSetting("Outline Color", "Color of ESP box outline", 0xFFFF0000);
    public final IntegerSetting thickness = new IntegerSetting("Thickness", "Line thickness", 2, 1, 10);
    public final IntegerSetting alpha = new IntegerSetting("Alpha", "Transparency (0-255)", 128, 0, 255);

    public ESP3D() {
        super("ESP 3D HITBOX", "3D hitbox around players", Category.RENDER);
        addSetting(friends);
        addSetting(fillColor);
        addSetting(outlineColor);
        addSetting(thickness);
        addSetting(alpha);
    }

    @Override
    public void onRender() {
        // ESP rendering logic will be handled by mixin
    }

    public boolean shouldRenderPlayer(Entity entity) {
        return entity instanceof LivingEntity && entity != null;
    }
}
