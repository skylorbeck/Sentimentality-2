package website.skylorbeck.sentimentality2;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.network.ClientSidePacketRegistry;
import net.minecraft.util.Identifier;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientMain implements ClientModInitializer {
    public static final Identifier sentimentality2_send_seed = new Identifier("sentimentality2","send_seed");
    public ExtraHUD extraHUD;

    @Override
    public void onInitializeClient() {
        ClientSidePacketRegistry.INSTANCE.register(sentimentality2_send_seed, (packetContext, attachedData) -> {
            long seed = attachedData.readLong();
            packetContext.getTaskQueue().execute(() -> {
                SlimeChunkLocator.receivedSeed(seed);//save seed to slime chunk detector that requested it
            });
        });
        Registrar.clientRegister();
        extraHUD = new ExtraHUD();//add in the custom hud
        Logger.getLogger(Ref.MODID).log(Level.WARNING,"This is when ClientMain is loaded");
    }
}
