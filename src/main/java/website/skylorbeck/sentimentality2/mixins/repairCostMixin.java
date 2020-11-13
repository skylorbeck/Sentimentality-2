package website.skylorbeck.sentimentality2.mixins;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;


@Mixin(ItemStack.class)
public abstract class repairCostMixin {
    @Shadow public abstract CompoundTag getOrCreateTag();
    /**
     * @author SkylorBeck
     * @reason remove repair cost increase
     */
    @Overwrite
    public void setRepairCost(int repairCost) {
        this.getOrCreateTag().putInt("RepairCost", 0);
    }
}