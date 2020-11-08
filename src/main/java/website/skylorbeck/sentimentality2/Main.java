package website.skylorbeck.sentimentality2;

import net.fabricmc.api.ModInitializer;


public class Main implements ModInitializer {

    public ExtraHUD extraHUD;

    @Override
    public void onInitialize() {
        Registrar.register();
        extraHUD = new ExtraHUD();
    }

}
