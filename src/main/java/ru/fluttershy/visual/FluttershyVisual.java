package ru.fluttershy.visual;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FsvMod implements ModInitializer {
	public static final String MOD_ID = "fluttershyvisual";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Initializing FluttershyVisual mod for Minecraft 1.21.4");
	}
}
