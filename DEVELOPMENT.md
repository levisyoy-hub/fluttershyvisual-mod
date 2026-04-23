# FluttershyVisual Development Guide

## Project Setup for Development

### IDE Setup (IntelliJ IDEA)
1. Open project in IntelliJ
2. Wait for Gradle sync to complete
3. Run `./gradlew idea` to generate IDE files
4. Refresh Gradle project (Gradle panel → Refresh)

### IDE Setup (VS Code)
1. Install "Extension Pack for Java" by Microsoft
2. Install "Gradle for Java" by Microsoft
3. Open project folder
4. Trust the workspace when prompted

## Building the Mod

```bash
# Build JAR for testing
./gradlew build

# Run development client
./gradlew runClient

# Run development server
./gradlew runServer
```

## Project Architecture

### Core Systems

#### 1. Module System
- **Base Class**: `Module.java`
- **Manager**: `ModuleManager.java`
- **Categories**: `Category.java` (enum)

All modules extend `Module` and are registered in `FsvMod.java`

#### 2. Settings System
- **Base**: `Setting.java` (generic)
- **Types**:
  - `BooleanSetting` - true/false
  - `IntegerSetting` - integer with min/max
  - `ColorSetting` - RGBA color values

#### 3. Configuration System
- **Manager**: `ConfigManager.java`
- **Format**: JSON (GSON)
- **Location**: `config/fluttershyvisual/config.json`
- Auto-save on world unload

#### 4. UI System
- **Main GUI**: `ClickGUI.java`
- **Components**: `ui/components/`
- **Renderer**: `HudRenderer.java`
- **Shortcut**: RIGHT SHIFT key

### Module Development

#### Creating a New Module

1. **Choose Category** (render, helper, visuals, gameplay)
2. **Create Class**:

```java
package ru.fluttershy.visual.module.render;

import ru.fluttershy.visual.module.Category;
import ru.fluttershy.visual.module.Module;
import ru.fluttershy.visual.setting.*;

public class MyModule extends Module {
    public final BooleanSetting enabled = new BooleanSetting("Enabled", "Enable feature", true);
    public final IntegerSetting intensity = new IntegerSetting("Intensity", "Effect intensity", 50, 0, 100);
    public final ColorSetting color = new ColorSetting("Color", "Effect color", 0xFF00FF00);

    public MyModule() {
        super("MY MODULE", "My awesome module", Category.RENDER);
        addSetting(enabled);
        addSetting(intensity);
        addSetting(color);
    }

    @Override
    public void onEnable() {
        // Called when module is enabled
    }

    @Override
    public void onDisable() {
        // Called when module is disabled
    }

    @Override
    public void onUpdate() {
        // Called every tick (server-side compatible)
    }

    @Override
    public void onRender() {
        // Called every frame (client-side only)
    }
}
```

3. **Register in FsvMod.java**:

```java
manager.registerModule(new MyModule());
```

### Mixin System

Mixins allow deep integration with Minecraft's code. Located in `mixin/` package.

#### Available Mixins
- `MixinInGameHud` - HUD rendering
- `MixinEntityRenderer` - Entity rendering
- `MixinItemRenderer` - Item rendering
- `MixinGameRenderer` - Camera/rendering
- `MixinWorldRenderer` - World rendering
- `MixinClientPlayerEntity` - Player logic
- `MixinClientPlayNetworkHandler` - Network
- `MixinHandledScreen` - Screen/GUI
- `MixinKeyboard` - Keyboard input
- `MixinMouse` - Mouse input
- `MixinLivingEntityRenderer` - Living entity rendering

#### Creating a Mixin

```java
package ru.fluttershy.visual.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import net.minecraft.client.render.GameRenderer;

@Mixin(GameRenderer.class)
public class MixinGameRenderer {
    @Inject(method = "render", at = @At("HEAD"))
    private void onRender(float tickDelta, long startTime, boolean tick, CallbackInfo ci) {
        // Your code here
    }
}
```

### Network & Packet Handling

For packet-based features like ItemSwap:

```java
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.packet.c2s.play.ClickSlotC2SPacket;

ClientPlayNetworkHandler handler = client.getNetworkHandler();
int syncId = client.player.playerContainer.syncId;

handler.sendPacket(new ClickSlotC2SPacket(
    syncId, 0, slot, 0, SlotActionType.PICKUP,
    ItemStack.EMPTY, Int2ObjectMaps.emptyMap()
));
```

## Debugging

### Enable Debug Logging
- Check console output for log messages
- Use `FsvMod.LOGGER.info()` for logging

### Run Tests
```bash
./gradlew test
```

### Check for Compile Errors
```bash
./gradlew compileJava
```

## Performance Tips

1. **Use `onUpdate()` sparingly** - runs every tick
2. **Cache calculations** in module fields
3. **Minimize garbage creation** - use object pooling
4. **Batch rendering** operations in `onRender()`
5. **Profile with VisualVM** for performance analysis

## File Modifications Best Practices

### Accessing Game Objects
```java
MinecraftClient client = MinecraftClient.getInstance();
ClientPlayerEntity player = client.player;
ClientWorld world = client.world;
```

### Safe Null Checks
```java
if (client.player != null && client.world != null) {
    // Safe to access game objects
}
```

### Configuration Persistence
```java
// Save
ConfigManager.getInstance().save();

// Load
ConfigManager.getInstance().load();
```

## Common Issues & Solutions

### Issue: Module not appearing in GUI
- Ensure it's registered in `FsvMod.java`
- Check category is correct
- Verify module class extends `Module`

### Issue: Settings not saving
- Call `ConfigManager.getInstance().save()`
- Ensure settings are added with `addSetting()`
- Check config file path

### Issue: Mixin not applying
- Verify class name in `fluttershyvisual.mixins.json`
- Check `@Mixin` annotation targets correct class
- Ensure method signature is correct

## Contributing

1. Fork repository
2. Create feature branch (`feature/my-feature`)
3. Commit changes with clear messages
4. Push to branch
5. Create Pull Request

## Resources

- [Fabric Documentation](https://fabricmc.net/wiki/)
- [Mixin Documentation](https://github.com/SpongePowered/Mixin/wiki)
- [Minecraft Wiki](https://minecraft.wiki/)
- [Minecraft Mappings](https://mappings.dev/)

## Support

Questions? Issues? Open a GitHub issue or contact the development team!
