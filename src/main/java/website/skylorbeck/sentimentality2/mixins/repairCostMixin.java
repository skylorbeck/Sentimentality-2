package website.skylorbeck.sentimentality2.mixins;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import website.skylorbeck.sentimentality2.ModConfig;
import website.skylorbeck.sentimentality2.Registrar;


@Mixin(ItemStack.class)
public abstract class repairCostMixin {
    @Shadow public abstract CompoundTag getOrCreateTag();
    @Inject(method = "setRepairCost",at = @At("HEAD"),cancellable = true)
    public void sentimentalSetRepairCost(CallbackInfo ci) {
        if (Registrar.getConfig().repairCost) {
            this.getOrCreateTag().putInt("RepairCost", 0);//always set repair cost to 0, then cancel
            ci.cancel();
        }
    }
}