package website.skylorbeck.sentimentality2;



import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.server.ServerTickCallback;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main implements ModInitializer {
    public static final Logger logger = LogManager.getLogger("sentimentality2");
    public ExtraHUD extraHUD;

    @Override
    public void onInitialize() {
        Registrar.register();
        extraHUD = new ExtraHUD();
        ServerTickCallback.EVENT.register((server)->{
            SleepEventManager.onTick(server);
        });
    }

}
