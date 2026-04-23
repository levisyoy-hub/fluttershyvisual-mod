package ru.fluttershy.visual.ui;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;

public class HudRenderer {
    private static final MinecraftClient CLIENT = MinecraftClient.getInstance();

    public static void renderHud(DrawContext context) {
        if (CLIENT.player == null) return;

        int y = 5;
        context.drawTextWithShadow(CLIENT.textRenderer, "FluttershyVisual v1.0", 5, y, 0xFFFFFF);
    }

    public static void drawString(DrawContext context, String text, int x, int y, int color) {
        if (CLIENT.textRenderer != null) {
            context.drawTextWithShadow(CLIENT.textRenderer, text, x, y, color);
        }
    }

    public static void drawRect(DrawContext context, int x, int y, int width, int height, int color) {
        context.fill(x, y, x + width, y + height, color);
    }

    public static void drawBox(DrawContext context, int x, int y, int width, int height, int color, int borderSize) {
        drawRect(context, x, y, width, height, color);
        
        // Draw border
        for (int i = 0; i < borderSize; i++) {
            context.drawHorizontalLine(x + i, x + width - i, y + i, 0xFF000000);
            context.drawHorizontalLine(x + i, x + width - i, y + height - 1 - i, 0xFF000000);
            context.drawVerticalLine(x + i, y + i, y + height - i, 0xFF000000);
            context.drawVerticalLine(x + width - 1 - i, y + i, y + height - i, 0xFF000000);
        }
    }
}
