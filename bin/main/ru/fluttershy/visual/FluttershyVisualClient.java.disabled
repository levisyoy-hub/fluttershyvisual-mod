package ru.fluttershy.visual;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class FsvClientMod implements ClientModInitializer {
	public static final KeyBinding OPEN_GUI_KEY = KeyBindingHelper.registerKeyBinding(
		new KeyBinding("key.fluttershyvisual.gui", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_RIGHT_SHIFT, "category.fluttershyvisual")
	);

	@Override
	public void onInitializeClient() {
		FsvMod.LOGGER.info("Initializing FluttershyVisual client");
		
		ClientTickEvents.END_CLIENT_TICK.register(client -> {
			if (OPEN_GUI_KEY.wasPressed()) {
				// Will open GUI when implemented
				FsvMod.LOGGER.info("ClickGUI key pressed");
			}
		});
	}
}

