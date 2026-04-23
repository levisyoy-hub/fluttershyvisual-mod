package ru.fluttershy.visual;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;
import ru.fluttershy.visual.config.ConfigManager;
import ru.fluttershy.visual.module.ModuleManager;
import ru.fluttershy.visual.ui.ClickGUI;

public class FsvClientMod implements ClientModInitializer {
	public static final KeyBinding OPEN_GUI_KEY = KeyBindingHelper.registerKeyBinding(
		new KeyBinding("key.fluttershyvisual.gui", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_RIGHT_SHIFT, "category.fluttershyvisual")
	);

	@Override
	public void onInitializeClient() {
		FsvMod.LOGGER.info("Initializing FluttershyVisual client");
		
		ClientTickEvents.END_CLIENT_TICK.register(client -> {
			if (client.player != null && OPEN_GUI_KEY.wasPressed()) {
				client.setScreen(new ClickGUI());
			}
		});
		
		// Save config on client shutdown
		ClientTickEvents.END_CLIENT_TICK.register(client -> {
			if (client.isRunning() && client.world == null) {
				// When world is unloaded, save config
				ConfigManager.getInstance().save();
			}
		});
		
		FsvMod.LOGGER.info("FluttershyVisual client initialized successfully!");
	}
}

