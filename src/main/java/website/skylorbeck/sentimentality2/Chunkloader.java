package website.skylorbeck.sentimentality2;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import org.apache.commons.lang3.ArrayUtils;

public class Chunkloader extends Item {
    public static long[] chunks = new long[]{};

    public Chunkloader(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        CompoundTag compoundTag = itemStack.getOrCreateTag();
        BlockPos blockPos = user.getBlockPos();
        Chunk chunk = world.getChunk(blockPos);
        ChunkPos chunkPos = chunk.getPos();
        MinecraftServer server = world.getServer();
        if (server != null) {
            long chunkLong = chunkPos.toLong();
            chunks = compoundTag.getLongArray("chunks");
            boolean toLoad = true;
            for (int i = 0; i < chunks.length; i++) {
                if (chunks[i] == chunkLong) {
                    server.getCommandManager().execute(new ServerCommandSource(server, new Vec3d(user.getX(), user.getY(), user.getZ()), Vec2f.ZERO, (ServerWorld) world, 4, "Chunk Loader", new LiteralText("Chunk Loader"), server, null),
                            String.format("forceload %s %s %s", "remove", blockPos.getX(), blockPos.getZ()));
                    chunks = ArrayUtils.remove(chunks, i);
                    user.sendMessage(Text.of("Chunk Unloaded"), true);
                    toLoad = false;
                }
            }
            if (toLoad) {
                server.getCommandManager().execute(new ServerCommandSource(server, new Vec3d(user.getX(), user.getY(), user.getZ()), Vec2f.ZERO, (ServerWorld) world, 4, "Chunk Loader", new LiteralText("Chunk Loader"), server, null),
                        String.format("forceload %s %s %s", "add", blockPos.getX(), blockPos.getZ()));
                chunks = ArrayUtils.add(chunks, chunkLong);
                user.sendMessage(Text.of("Chunk Loaded"), true);
            }
            compoundTag.putLongArray("chunks", chunks);
        }
        return TypedActionResult.success(itemStack);
    }
}