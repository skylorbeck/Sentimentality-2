package website.skylorbeck.sentimentality2;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
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


public class ExtraCraftingTableEntity extends BlockEntity implements Inventory, NamedScreenHandlerFactory {
    protected CraftingInventory inventory;

    public ExtraCraftingTableEntity() {
        super(Declarer.CRAFTING_TABLE_ENTITY);
        inventory = new CraftingInventory(this, 3, 3);
    }
    @Override
    public Text getDisplayName() {
        return  new TranslatableText("container.crafting");
    }

    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory pInv, PlayerEntity player) {
        return new ExtraCraftingScreenHandler(syncId, pInv, inventory, ScreenHandlerContext.create(world, pos),this);
    }
    @Override
    public CompoundTag toTag(CompoundTag tag){
        Inventories.toTag(tag,this.inventory);
        return super.toTag(tag);
    }
    @Override
    public void fromTag(BlockState state, CompoundTag tag){
        super.fromTag(state,tag);
        //this.inventory = DefaultedList.ofSize(this.size(),ItemStack.EMPTY);
        Inventories.fromTag(tag,this.inventory);
    }

    @Override
    public int size() {
        return this.inventory.size();
    }

    @Override
    public boolean isEmpty() {
        Iterator var1 = this.inventory.iterator();

        ItemStack itemStack;
        do {
            if (!var1.hasNext()) {
                return true;
            }

            itemStack = (ItemStack)var1.next();
        } while(itemStack.isEmpty());

        return false;
    }

    @Override
    public ItemStack getStack(int slot) {
        return (ItemStack)this.inventory.get(slot);
    }

    @Override
    public ItemStack removeStack(int slot, int amount) {
        return Inventories.splitStack(this.inventory, slot, amount);
    }

    @Override
    public ItemStack removeStack(int slot) {
        return Inventories.removeStack(this.inventory, slot);
    }

    @Override
    public void setStack(int slot, ItemStack stack) {
        ItemStack itemStack = (ItemStack)this.inventory.get(slot);
        boolean bl = !stack.isEmpty() && stack.isItemEqualIgnoreDamage(itemStack) && ItemStack.areTagsEqual(stack, itemStack);
        this.inventory.set(slot, stack);
        if (stack.getCount() > this.getMaxCountPerStack()) {
            stack.setCount(this.getMaxCountPerStack());
        }
        this.markDirty();
    }

    @Override
    public boolean canPlayerUse(PlayerEntity player) {
        return true;
    }

    @Override
    public void onOpen(PlayerEntity player) {

    }

    @Override
    public void onClose(PlayerEntity player) {

    }

    @Override
    public boolean isValid(int slot, ItemStack stack) {
        return true;
    }

    @Override
    public void clear() {
        this.inventory.clear();
    }


}
