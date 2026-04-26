package ru.fluttershy.visual.ui;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.text.Text;
import ru.fluttershy.visual.module.Category;
import ru.fluttershy.visual.module.Module;
import ru.fluttershy.visual.module.ModuleManager;

import java.util.ArrayList;
import java.util.List;

public class ClickGUI extends Screen {
    private Category selectedCategory = Category.RENDER;
    private final List<Module> visibleModules = new ArrayList<>();
    private int scrollOffset = 0;
    private static final int MODULE_HEIGHT = 25;
    private static final int BUTTON_WIDTH = 100;
    private static final int BUTTON_HEIGHT = 20;

    public ClickGUI() {
        super(Text.literal("FluttershyVisual ClickGUI"));
        updateVisibleModules();
    }

    private void updateVisibleModules() {
        visibleModules.clear();
        visibleModules.addAll(ModuleManager.getInstance().getModulesByCategory(selectedCategory));
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        this.renderBackground(context, mouseX, mouseY, delta);

        // Draw title
        context.drawCenteredTextWithShadow(this.textRenderer, "FluttershyVisual", this.width / 2, 10, 0xFFFFFF);

        // Draw category buttons
        int categoryButtonX = 20;
        for (Category cat : Category.values()) {
            int buttonColor = cat == selectedCategory ? 0xFF00FF : 0x666666;
            drawFilledRect(context, categoryButtonX, 30, BUTTON_WIDTH, BUTTON_HEIGHT, buttonColor);
            context.drawCenteredTextWithShadow(this.textRenderer, cat.name, categoryButtonX + BUTTON_WIDTH / 2, 37, 0xFFFFFF);
            categoryButtonX += BUTTON_WIDTH + 5;
        }

        // Draw modules
        int moduleY = 60;
        for (Module module : visibleModules) {
            int moduleColor = module.isEnabled() ? 0x00FF00 : 0xFF0000;
            drawFilledRect(context, 20, moduleY, this.width - 40, MODULE_HEIGHT, 0x333333);
            drawRect(context, 20, moduleY, this.width - 40, MODULE_HEIGHT, moduleColor, 1);
            
            context.drawTextWithShadow(this.textRenderer, module.getName(), 25, moduleY + 5, moduleColor);
            context.drawTextWithShadow(this.textRenderer, module.isEnabled() ? "[ON]" : "[OFF]", this.width - 60, moduleY + 5, moduleColor);
            
            moduleY += MODULE_HEIGHT + 5;
        }
    }

    private void drawFilledRect(DrawContext context, int x, int y, int width, int height, int color) {
        context.fill(x, y, x + width, y + height, color);
    }

    private void drawRect(DrawContext context, int x, int y, int width, int height, int color, int thickness) {
        for (int i = 0; i < thickness; i++) {
            context.drawHorizontalLine(x + i, x + width - i, y + i, color);
            context.drawHorizontalLine(x + i, x + width - i, y + height - 1 - i, color);
            context.drawVerticalLine(x + i, y + i, y + height - i, color);
            context.drawVerticalLine(x + width - 1 - i, y + i, y + height - i, color);
        }
    }

    @Override
    public boolean mouseScrolled(double mouseX, double mouseY, double horizontalAmount, double verticalAmount) {
        scrollOffset += (int) verticalAmount;
        return true;
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        // Handle category button clicks
        int categoryButtonX = 20;
        for (Category cat : Category.values()) {
            if (mouseX >= categoryButtonX && mouseX < categoryButtonX + BUTTON_WIDTH &&
                mouseY >= 30 && mouseY < 30 + BUTTON_HEIGHT) {
                selectedCategory = cat;
                updateVisibleModules();
                scrollOffset = 0;
                return true;
            }
            categoryButtonX += BUTTON_WIDTH + 5;
        }

        // Handle module button clicks
        int moduleY = 60;
        for (Module module : visibleModules) {
            if (mouseX >= 20 && mouseX < this.width - 40 &&
                mouseY >= moduleY && mouseY < moduleY + MODULE_HEIGHT) {
                module.setEnabled(!module.isEnabled());
                return true;
            }
            moduleY += MODULE_HEIGHT + 5;
        }

        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public boolean shouldCloseOnEsc() {
        return true;
    }

    @Override
    public void close() {
        super.close();
    }
}
