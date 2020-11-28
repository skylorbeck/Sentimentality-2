package website.skylorbeck.sentimentality2;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.screen.CraftingScreenHandler;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.collection.DefaultedList;
import org.jetbrains.annotations.Nullable;

import java.util.Iterator;


public class ExtraCraftingTableEntity extends BlockEntity implements ExtraInventory, NamedScreenHandlerFactory {
    private final DefaultedList<ItemStack> items = DefaultedList.ofSize(9,ItemStack.EMPTY);

    public ExtraCraftingTableEntity() {
        super(Declarer.CRAFTING_TABLE_ENTITY);
    }
    @Override
    public Text getDisplayName() {
        return  new TranslatableText("container.crafting");
    }

    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory pInv, PlayerEntity player) {
        return new ExtraCraftingScreenHandler(syncId, pInv, ScreenHandlerContext.create(world, pos),this);
    }
    @Override
    public CompoundTag toTag(CompoundTag tag){
        Inventories.toTag(tag,items);
        return super.toTag(tag);
    }
    @Override
    public void fromTag(BlockState state, CompoundTag tag){
        super.fromTag(state,tag);
        Inventories.fromTag(tag,items);
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return items;
    }


    @Override
    public boolean isValid(int slot, ItemStack stack) {
        return true;
    }

    public void dropItems(){
        double x = this.pos.getX()+0.5;
        double y = this.pos.getY()+1;
        double z = this.pos.getZ()+0.5;
        for (int i = 0; i < items.size(); i++) {
            world.spawnEntity(new ItemEntity(world,x,y,z,items.get(i)));
        }
    }
}
