package website.skylorbeck.sentimentality2.mixins;

import net.fabricmc.fabric.api.network.ServerSidePacketRegistry;
import net.minecraft.block.BeehiveBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BeehiveBlockEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.packet.s2c.play.TitleS2CPacket;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BeehiveBlock.class)
public class BeehiveMixin {
    @Inject(at = @At("HEAD"), method = "onUse")
    public void showBees(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit, CallbackInfoReturnable<ActionResult> cir) {
        if (!world.isClient && player.getStackInHand(hand).isEmpty()) {
            BeehiveBlockEntity beehiveBlockEntity = (BeehiveBlockEntity) world.getBlockEntity(pos);
            int beeCount = beehiveBlockEntity.getBeeCount();
            if (beeCount == 1){
                ServerSidePacketRegistry.INSTANCE.sendToPlayer(player, (new TitleS2CPacket(TitleS2CPacket.Action.ACTIONBAR, Text.of("This hive contains " + beeCount + " bee"))));
            }else{
                ServerSidePacketRegistry.INSTANCE.sendToPlayer(player, (new TitleS2CPacket(TitleS2CPacket.Action.ACTIONBAR, Text.of("This hive contains " + beeCount + " bees"))));
            }
        }
    }
}
