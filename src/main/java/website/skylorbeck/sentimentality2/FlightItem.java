package website.skylorbeck.sentimentality2;

import dev.emi.trinkets.api.SlotGroups;
import dev.emi.trinkets.api.Slots;
import dev.emi.trinkets.api.TrinketItem;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import top.theillusivec4.caelus.api.CaelusApi;


public class FlightItem extends TrinketItem {
    private int tickcount = 0;
    public FlightItem(Settings settings) {
        super(settings);
    }

    @Override
    public void tick(PlayerEntity player, ItemStack stack) {
        EntityAttributeInstance attribute = player.getAttributeInstance(CaelusApi.ELYTRA_FLIGHT);
        if (player.isFallFlying() && !player.isCreative()) {
            if (tickcount >= 20) {
                int curdam = stack.getDamage();
                stack.setDamage(curdam + 1);
                tickcount = 0;
            } else {
                tickcount++;
            }
        }
        if (stack.getDamage() < stack.getMaxDamage() - 1){
            attribute.setBaseValue(1);
        }else{
            attribute.setBaseValue(0);
        }
    }
    @Override
    public boolean canWearInSlot(String group, String slot) {
        return group.equals(SlotGroups.CHEST) && slot.equals(Slots.CAPE);
    }

    @Override
    public void onEquip(PlayerEntity player, ItemStack stack) {

    }
    @Override
    public void onUnequip(PlayerEntity player, ItemStack stack) {
        EntityAttributeInstance attribute = player.getAttributeInstance(CaelusApi.ELYTRA_FLIGHT);
        attribute.setBaseValue(0);
    }

}
