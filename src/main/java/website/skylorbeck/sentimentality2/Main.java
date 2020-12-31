package website.skylorbeck.sentimentality2;


import io.netty.buffer.Unpooled;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.server.ServerTickCallback;
import net.fabricmc.fabric.api.network.ServerSidePacketRegistry;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.Identifier;

import java.util.Objects;

public class Main implements ModInitializer {
    public static final Identifier sentimentality2_get_seed= new Identifier("sentimentality2", "get_seed");
    @Override
    public void onInitialize() {
        ServerSidePacketRegistry.INSTANCE.register(sentimentality2_get_seed, (packetContext, attachedData) -> {//get blank trigger packet
            packetContext.getTaskQueue().execute(() -> {
                PacketByteBuf data = new PacketByteBuf(Unpooled.buffer());
                data.writeLong(Objects.requireNonNull(packetContext.getPlayer().getEntityWorld().getServer()).getOverworld().getSeed());//send seed back
                ServerSidePacketRegistry.INSTANCE.sendToPlayer(packetContext.getPlayer(), ClientMain.sentimentality2_send_seed, data);
            });
        });
        Registrar.register();//register everything
        ServerTickCallback.EVENT.register(SleepEventManager::onTick);
    }

}
