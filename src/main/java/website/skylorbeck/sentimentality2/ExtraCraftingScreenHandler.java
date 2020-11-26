package website.skylorbeck.sentimentality2;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.inventory.CraftingResultInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.screen.CraftingScreenHandler;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.slot.CraftingResultSlot;
import net.minecraft.screen.slot.Slot;
import net.minecraft.util.collection.DefaultedList;

public class ExtraCraftingScreenHandler extends CraftingScreenHandler {
    private final Inventory inventory;
    private final CraftingInventory input;
    private final ScreenHandlerContext context;
    private final ExtraCraftingTableEntity extraCraftingTableEntity;



    public ExtraCraftingScreenHandler(int syncId, PlayerInventory playerInventory, CraftingInventory input, ScreenHandlerContext context,ExtraCraftingTableEntity entity) {
        super(syncId, playerInventory, context);
        this.input = new CraftingInventory(this, 3, 3);
        this.context = context;
        extraCraftingTableEntity = entity;
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return true;
    }

    @Override
    public void close(PlayerEntity player) {
        //super.close(player);
        PlayerInventory playerInventory = player.inventory;
        if (!playerInventory.getCursorStack().isEmpty()) {
            player.dropItem(playerInventory.getCursorStack(), false);
            playerInventory.setCursorStack(ItemStack.EMPTY);
        }
    }

/*    @Override
    public void onContentChanged(Inventory inventory) {
        this.context.run((world, blockPos) -> {
            updateResult(this.syncId, world, this.player, this.input, this.result);
        });
    }*/
}
