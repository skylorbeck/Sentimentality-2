package website.skylorbeck.sentimentality2;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.LightType;
import net.minecraft.world.World;

import java.util.List;

public class PDDItem extends Item {
    //both must be private or all the PDD overwrite each other
    private boolean mode = false;//daylight or torchlight modes
    private int light = 0;//current light level

    public PDDItem(Settings settings) {
        super(settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        CompoundTag compoundTag = stack.getOrCreateTag();
        mode = compoundTag.getBoolean("mode");
        if(mode){//gets the light level for the block the item is in depending on the mode set in the NBT
            light = world.getLightLevel(entity.getBlockPos());
            stack.setCustomName(new TranslatableText("item.sentimentality2.pdd_day"));
        } else {
            light = world.getLightLevel(LightType.BLOCK,entity.getBlockPos());
            stack.setCustomName(new TranslatableText("item.sentimentality2.pdd_block"));
        }
        int bool = mode ? 2 : 1;//must be 2 or 1 as NBT remove all leading zeros
        compoundTag.putInt("CustomModelData",Integer.parseInt(bool+""+light));//stores the mode and the light level as an int in the NBT for dynamic model calculations

    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
            ItemStack itemStack = user.getStackInHand(hand);
            CompoundTag compoundTag = itemStack.getOrCreateTag();
            boolean mode2 = compoundTag.getBoolean("mode");
            mode2 = !mode2;//invert mode
            compoundTag.putBoolean("mode",mode2);
            return TypedActionResult.success(itemStack);
    }
    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
        tooltip.add(new TranslatableText("item.sentimentality2.pdd_tip"));

    }
}
