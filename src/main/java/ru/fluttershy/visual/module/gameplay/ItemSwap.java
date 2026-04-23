package ru.fluttershy.visual.module.gameplay;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.network.packet.c2s.play.ClickSlotC2SPacket;
import it.unimi.dsi.fastutil.ints.Int2ObjectMaps;
import ru.fluttershy.visual.module.Category;
import ru.fluttershy.visual.module.Module;
import ru.fluttershy.visual.setting.BooleanSetting;

public class ItemSwap extends Module {
    public final BooleanSetting swapTotem = new BooleanSetting("Swap Totem", "Auto-swap to totem", true);
    public final BooleanSetting swapGapple = new BooleanSetting("Swap Gapple", "Auto-swap to golden apple", true);
    public final BooleanSetting swapPearl = new BooleanSetting("Swap Pearl", "Auto-swap to ender pearl", false);

    public ItemSwap() {
        super("ITEM SWAP (PACKET)", "Instant item swap via packets", Category.GAMEPLAY);
        addSetting(swapTotem);
        addSetting(swapGapple);
        addSetting(swapPearl);
    }

    public void swapToSlot(int fromSlot) {
        MinecraftClient client = MinecraftClient.getInstance();
        if (client.player == null || client.getNetworkHandler() == null) return;

        ClientPlayNetworkHandler handler = client.getNetworkHandler();
        int syncId = client.player.playerContainer.syncId;

        // Pickup item from slot
        handler.sendPacket(new ClickSlotC2SPacket(
            syncId, 0, fromSlot, 0, SlotActionType.PICKUP, 
            ItemStack.EMPTY, Int2ObjectMaps.emptyMap()
        ));

        // Place in offhand (slot 40)
        handler.sendPacket(new ClickSlotC2SPacket(
            syncId, 0, 40, 0, SlotActionType.PICKUP, 
            ItemStack.EMPTY, Int2ObjectMaps.emptyMap()
        ));
    }

    private String getItemDisplayName(ItemStack stack) {
        if (stack.hasCustomName()) {
            return stack.getName().getString();
        }
        return "";
    }

    private boolean isProtectedItem(ItemStack stack) {
        String name = getItemDisplayName(stack);
        return name.contains("Крушитель") || name.contains("Каратель");
    }
}
