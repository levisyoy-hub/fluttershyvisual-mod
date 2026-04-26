package ru.fluttershy.visual.ui.components;

import net.minecraft.client.gui.DrawContext;
import ru.fluttershy.visual.module.Module;

public class ModuleButton {
    private final Module module;
    private int x;
    private int y;
    private int width;
    private int height;
    private boolean hovered;

    public ModuleButton(Module module, int x, int y, int width, int height) {
        this.module = module;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void render(DrawContext context, int mouseX, int mouseY) {
        hovered = isMouseOver(mouseX, mouseY);
        
        int backgroundColor = module.isEnabled() ? 0xFF00FF00 : 0xFFFF0000;
        if (hovered) {
            backgroundColor = module.isEnabled() ? 0xFF00AA00 : 0xFFAA0000;
        }

        context.fill(x, y, x + width, y + height, backgroundColor);
        
        String text = module.getName() + " [" + (module.isEnabled() ? "ON" : "OFF") + "]";
        if (context.getMinecraftClient().textRenderer != null) {
            context.drawCenteredTextWithShadow(
                context.getMinecraftClient().textRenderer,
                text,
                x + width / 2,
                y + height / 2 - 4,
                0xFFFFFF
            );
        }
    }

    public boolean mouseClicked(int mouseX, int mouseY, int button) {
        if (isMouseOver(mouseX, mouseY) && button == 0) {
            module.setEnabled(!module.isEnabled());
            return true;
        }
        return false;
    }

    private boolean isMouseOver(int mouseX, int mouseY) {
        return mouseX >= x && mouseX < x + width && mouseY >= y && mouseY < y + height;
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
