package website.skylorbeck.sentimentality2;

import io.netty.buffer.Unpooled;
import net.fabricmc.fabric.api.network.ClientSidePacketRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.world.World;

import java.util.Random;

//todo ui implementation, models, textures, the works.
public class SlimeChunkLocator extends Item {
    private static long seed;
    private static boolean hasSeed = false;


    public SlimeChunkLocator(Settings settings) {
        super(settings);

    }
    public static void receivedSeed(long worldSeed){
        hasSeed=true;
        seed=worldSeed;
    }

    private boolean findChunk(long worldseed, double x, double y) {
        Random rnd = new Random(
                worldseed +
                        (int) (x * x * 0x4c1906) +
                        (int) (x * 0x5ac0db) +
                        (int) (y * y) * 0x4307a7L +
                        (int) (y * 0x5f24f) ^ 0x3ad8025fL
        );
        return rnd.nextInt(10) == 0;

    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (entity instanceof PlayerEntity && world.isClient) {
            if (!hasSeed) {
                PacketByteBuf data = new PacketByteBuf(Unpooled.buffer());
                ClientSidePacketRegistry.INSTANCE.sendToServer(Main.sentimentality2_get_seed, data);
            }
            if(hasSeed){
                CompoundTag compoundTag = stack.getOrCreateTag();
                //compoundTag.putLong("seed",seed);//if the user has an NBT viewing mod, they could get the seed too easily with this
                int bool = findChunk(seed,entity.chunkX,entity.chunkZ) ? 1: 0;
                compoundTag.putInt("CustomModelData", bool);
            }
        }
    }
}
