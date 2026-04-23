package ru.fluttershy.visual;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.fluttershy.visual.config.ConfigManager;
import ru.fluttershy.visual.module.ModuleManager;
import ru.fluttershy.visual.module.render.*;
import ru.fluttershy.visual.module.helper.*;
import ru.fluttershy.visual.module.visuals.*;
import ru.fluttershy.visual.module.gameplay.*;

public class FsvMod implements ModInitializer {
	public static final String MOD_ID = "fluttershyvisual";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Initializing FluttershyVisual mod for Minecraft 1.21.4");
		
		ModuleManager manager = ModuleManager.getInstance();
		
		// Register RENDER modules
		manager.registerModule(new ESP3D());
		manager.registerModule(new Trajectory());
		manager.registerModule(new TopkaTags());
		manager.registerModule(new DamageNumbers());
		manager.registerModule(new PotionGlintRemover());
		manager.registerModule(new MotionBlur());
		manager.registerModule(new CustomSky());
		manager.registerModule(new RedOverlay());
		
		// Register HELPER modules
		manager.registerModule(new CooldownHUD());
		manager.registerModule(new CooldownsWindow());
		manager.registerModule(new PotionsArmorHUD());
		manager.registerModule(new TargetHUD());
		manager.registerModule(new ItemLocks());
		manager.registerModule(new AntiGhost());
		manager.registerModule(new AutoEat());
		manager.registerModule(new MiddleClickFriend());
		manager.registerModule(new Freecam());
		manager.registerModule(new ToolSwitcherPreview());
		manager.registerModule(new AutoFish());
		manager.registerModule(new HotbarRefiller());
		manager.registerModule(new ANChecker());
		
		// Register VISUALS modules
		manager.registerModule(new ViewModel());
		manager.registerModule(new NoHurtCam());
		manager.registerModule(new HitFlash());
		manager.registerModule(new ShulkerVisual());
		
		// Register GAMEPLAY modules
		manager.registerModule(new GPS());
		manager.registerModule(new ItemSwap());
		manager.registerModule(new InviteUse());
		manager.registerModule(new InventoryCleaner());
		manager.registerModule(new AutoTool());
		manager.registerModule(new BindsConfig());
		
		// Load config
		ConfigManager.getInstance().load();
		
		LOGGER.info("FluttershyVisual mod initialized successfully!");
	}
}
