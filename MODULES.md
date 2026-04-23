# FluttershyVisual - 31 Modules Reference

## RENDER Category (8 modules)

### 1. ESP 3D HITBOX
**Description**: Renders 3D box around players with customizable colors and transparency.

**Settings**:
- `Friends Different` - Show friends with different color
- `Fill Color` - Box fill color (RGBA)
- `Outline Color` - Box border color
- `Thickness` - Border line thickness (1-10 px)
- `Alpha` - Transparency (0-255)

**Use Cases**: PvP preparation, player detection, visual awareness

---

### 2. TRAJECTORY
**Description**: Displays flight path of projectiles in real-time.

**Settings**:
- `Line Color` - Trajectory line color
- `Thickness` - Line thickness
- `Alpha` - Line transparency

**Detects**: Pearls, snowballs, arrows, eggs, experience bottles

---

### 3. TOPKATAGS
**Description**: Shows player nameplates above heads with health info.

**Settings**:
- `Show Health` - Display health bar
- `Show Distance` - Show distance to player
- `Through Walls` - Visible through blocks
- `Health Color` - Health bar color
- `Name Color` - Player name color

---

### 4. DAMAGE NUMBERS
**Description**: Floating numbers appear above hit entities.

**Settings**:
- `Melee Color` - Regular damage (white)
- `Magic Color` - Magical damage (blue)
- `Fire Color` - Fire damage (red)
- `Poison Color` - Poison damage (green)

**Color Coding**:
- White: Physical/melee damage
- Blue: Magic/enchanted damage
- Red: Fire/lava damage
- Green: Poison/wither damage

---

### 5. POTION GLINT REMOVER
**Description**: Removes the purple shimmering effect on enchanted items.

**Use**: Cleaner visuals, less visual clutter

---

### 6. MOTION BLUR
**Description**: Adds blur effect when camera moves quickly.

**Settings**:
- `Intensity` - Blur strength (0-100%)

**Use Cases**: Cinematic footage, visual polish

---

### 7. CUSTOM SKY
**Description**: Customize sky color, clouds, stars, and sun/moon texture.

**Settings**:
- `Sky Color` - Main sky color (RGB)
- `Cloud Color` - Cloud color
- `Cloud Alpha` - Cloud transparency (0-255)
- `Show Stars` - Toggle star visibility
- `Animation` - Enable sky animation

---

### 8. RED OVERLAY
**Description**: Highlights valuable dropped items on ground.

**Valuable Items**:
- Netherite armor/tools
- Talismans (Crusader, Slayer)
- Enchanted gear

**Settings**:
- `Highlight Color` - Color of highlight
- `Alpha` - Highlight transparency

---

## HELPER Category (13 modules)

### 9. COOLDOWN HUD
**Description**: Shows cooldown bars and timers on hotbar items.

**Settings**:
- `Show Numbers` - Display timer numbers
- `Show Bar` - Display progress bar

**Display**: In hotbar, inventory

---

### 10. COOLDOWNS WINDOW
**Description**: Floating window listing all active cooldowns.

**Settings**:
- `Draggable` - Enable drag & drop positioning

**Features**: Drag to move, persistent position

---

### 11. POTIONS + ARMOR HUD
**Description**: Display active potion effects and armor durability.

**Settings**:
- `Show Potions` - List active potions
- `Show Armor` - Show armor health %

---

### 12. TARGET HUD
**Description**: Information panel for currently targeted player.

**Info Displayed**:
- Player skin preview
- Nickname
- Health & absorption
- Hunger level
- Armor rating
- Active cooldowns

**Settings**:
- `Show Health` - Display health
- `Show Armor` - Display armor
- `Show Cooldowns` - Display cooldowns

---

### 13. ITEMLOCKS
**Description**: Protect items from accidental loss.

**Settings**:
- `Protect Drop` - Prevent Q key drop
- `Protect Craft` - Prevent recipe crafting
- `Protect Inventory` - Prevent moving items

**Visual**: Lock icon appears on protected items

---

### 14. ANTIGHOST
**Description**: Fixes phantom (ghost) blocks that appear but don't exist server-side.

**How**: Sends synchronization requests to server

---

### 15. AUTOEAT + CHESTSTEAL
**Description**: Auto-eat when hungry + grab all chest contents with one click.

**Settings**:
- `Hunger Threshold` - Start eating at hunger level (0-20)

---

### 16. MIDDLECLICK FRIEND
**Description**: Middle-click players to send `/friend add [name]` command.

**Keybind**: Middle mouse button

**Feature**: Quick friend adding in-game

---

### 17. FREECAM
**Description**: Detach camera from player and fly around.

**Settings**:
- `Radius` - Max distance from player (10-200 blocks)
- `Speed` - Movement speed multiplier (1-20x)

**Note**: Spectator-like flight mode

---

### 18. TOOL SWITCHER PREVIEW
**Description**: Shows best tool slot for mining current block.

**Highlights**: Optimal mining tool slot

---

### 19. AUTOFISH (VISUAL)
**Description**: Timer helper for fishing, visual only (no auto-click).

**Display**: Timer over bobber

---

### 20. HOTBARREFILLER
**Description**: Auto-replenish hotbar when items run out.

**Example**: Grabs more blocks when stacks finish

---

### 21. AN CHECKER
**Description**: Parses chat for events and displays timers.

**Events Tracked**:
- Meteor events
- Beacon events
- Event countdown timers

---

## VISUALS Category (4 modules)

### 22. VIEWMODEL
**Description**: Customize held item position, rotation, and scale.

**Settings**:
- `X Position` - Horizontal offset (-10 to 10)
- `Y Position` - Vertical offset (-10 to 10)
- `Z Position` - Depth offset (-10 to 10)
- `Rotation X` - Pitch rotation (-180 to 180°)
- `Rotation Y` - Yaw rotation (-180 to 180°)
- `Scale` - Item size (50-200%)

**Use**: Visual customization, screenshot/recording

---

### 23. NOHURTCAM
**Description**: Removes camera shake when taking damage.

**Effect**: Smooth, stable camera during combat

---

### 24. HITFLASH
**Description**: Screen flash when dealing critical hits.

**Settings**:
- `Flash Color` - Highlight color (RGB)
- `Duration` - Flash duration in ticks (1-20)

**Visual**: Confirms critical hit registration

---

### 25. SHULKER VISUAL
**Description**: Filled shulker boxes appear larger and highlighted.

**Settings**:
- `Full Color` - Color for filled shulkers (RGB)

**Use**: Easy inventory scanning

---

## GAMEPLAY Category (6 modules)

### 26. GPS
**Description**: Navigate to coordinates from chat messages.

**Settings**:
- `Show Arrow` - Display direction indicator
- `Show Distance` - Show distance info (X, Y, Z)

**Parses**: Chat messages with coordinates

---

### 27. ITEM SWAP (PACKET)
**Description**: **CRITICAL** - Instant item swap via network packets.

**Characteristics**:
- **No inventory opening** - Uses ClickSlotC2SPacket
- **Zero delay** - Direct network transmission
- **Smart protection** - Won't swap talismans
- **Whitelist**: Totems, gapples, pearls

**Settings**:
- `Swap Totem` - Auto-swap to totem
- `Swap Gapple` - Auto-swap to golden apple
- `Swap Pearl` - Auto-swap to ender pearl

**Code Path**: `ru.fluttershy.visual.module.gameplay.ItemSwap.java`

**Packet Details**:
```
ClickSlotC2SPacket(syncId, 0, fromSlot, 0, SlotActionType.PICKUP, ItemStack.EMPTY, Int2ObjectMaps.emptyMap())
```

---

### 28. INVITEUSE
**Description**: Use items from inventory via hotkey without opening inventory.

**Example**: Drink potion, eat food, throw pearl

---

### 29. INVENTORYCLEANER
**Description**: Auto-sort and clean inventory.

**Features**:
- Sort by item type
- Remove junk items
- Organize valuables

---

### 30. AUTOTOOL
**Description**: **Visual only** - Highlight best tool slot (NO auto-switching).

**Use**: Manual tool selection helper

---

### 31. BINDS + CONFIG
**Description**: System for managing keybinds and configuration.

**Features**:
- Rebind module hotkeys
- Export/import configs
- Reset to defaults

---

## Module Configuration Examples

### Enable a Module
```json
{
  "ESP 3D HITBOX": {
    "enabled": true,
    "settings": {
      "Friends Different": "false",
      "Fill Color": "ff00ff00",
      "Outline Color": "ffff0000",
      "Thickness": "2",
      "Alpha": "128"
    }
  }
}
```

### Disable a Module
```json
{
  "MOTION BLUR": {
    "enabled": false,
    "settings": {
      "Intensity": "50"
    }
  }
}
```

## Compatibility Notes

- **PvP Servers**: Some modules may be banned (AUTOEAT, ANTIGHOST)
- **Survival Servers**: Most modules are server-safe
- **Multiplayer**: ItemSwap requires server support for packets
- **Single Player**: All modules fully functional

## Performance Impact

**Low Impact** (1-2 FPS):
- ESP, TopkaTags, TargetHUD, DamageNumbers

**Medium Impact** (3-5 FPS):
- MotionBlur, CustomSky, Trajectory

**High Impact** (5-10 FPS)**:
- Freecam with large radius
- All modules enabled simultaneously

## Tips & Tricks

1. **Disable particle effects** for better ESP visibility
2. **Use RGB values for colors** (0-255 per channel)
3. **ItemSwap works best with talismans** in dedicated slot
4. **Freecam useful for building** and design work
5. **Save configs per server** for easy switching
