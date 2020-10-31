package website.skylorbeck.sentimentality2.mixins;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.FurnaceOutputSlot;
import net.minecraft.screen.slot.Slot;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import website.skylorbeck.sentimentality2.ExtraBlastFurnaceBlockEntity;
import website.skylorbeck.sentimentality2.ExtraFurnaceBlockEntity;
import website.skylorbeck.sentimentality2.ExtraSmokerBlockEntity;

@Mixin(FurnaceOutputSlot.class)
public class XPFixMixin extends Slot {
    @Shadow
    @Final
    private PlayerEntity player;
    public XPFixMixin(Inventory inventory, int index, int x, int y) {
        super(inventory, index, x, y);
    }
    @Inject(at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;onCraft(Lnet/minecraft/world/World;Lnet/minecraft/entity/player/PlayerEntity;I)V"), method = "onCrafted(Lnet/minecraft/item/ItemStack;)V")
    private void craft(ItemStack stack, CallbackInfo ci) {
        if (!this.player.world.isClient && this.inventory instanceof ExtraFurnaceBlockEntity) {
            ((ExtraFurnaceBlockEntity) this.inventory).dropExperience(this.player);
        }
        if (!this.player.world.isClient && this.inventory instanceof ExtraBlastFurnaceBlockEntity ) {
            ((ExtraBlastFurnaceBlockEntity) this.inventory).dropExperience(this.player);
        }
        if (!this.player.world.isClient && this.inventory instanceof ExtraSmokerBlockEntity) {
            ((ExtraSmokerBlockEntity) this.inventory).dropExperience(this.player);
        }
    }
}
