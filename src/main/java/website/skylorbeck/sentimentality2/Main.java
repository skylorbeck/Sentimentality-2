package website.skylorbeck.sentimentality2;


import io.netty.buffer.Unpooled;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.server.ServerTickCallback;
import net.fabricmc.fabric.api.network.ClientSidePacketRegistry;
import net.fabricmc.fabric.api.network.ServerSidePacketRegistry;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.Identifier;

public class Main implements ModInitializer {
    public ExtraHUD extraHUD;
    public static final Identifier sentimentality2_get_seed= new Identifier("sentimentality2", "get_seed");
    public static final Identifier sentimentality2_send_seed = new Identifier("sentimentality2","send_seed");
    @Override
    public void onInitialize() {
        ServerSidePacketRegistry.INSTANCE.register(sentimentality2_get_seed, (packetContext, attachedData) -> {
            packetContext.getTaskQueue().execute(() -> {
                PacketByteBuf data = new PacketByteBuf(Unpooled.buffer());
                data.writeLong(packetContext.getPlayer().getEntityWorld().getServer().getOverworld().getSeed());
                ServerSidePacketRegistry.INSTANCE.sendToPlayer(packetContext.getPlayer(), Main.sentimentality2_send_seed, data);
            });
        });
        ClientSidePacketRegistry.INSTANCE.register(sentimentality2_send_seed, (packetContext, attachedData) -> {
            long seed = attachedData.readLong();
            packetContext.getTaskQueue().execute(() -> {
                SlimeChunkLocator.receivedSeed(seed);
            });
        });
        Registrar.register();
        extraHUD = new ExtraHUD();
        ServerTickCallback.EVENT.register((server)->{
            SleepEventManager.onTick(server);
        });
    }

}
