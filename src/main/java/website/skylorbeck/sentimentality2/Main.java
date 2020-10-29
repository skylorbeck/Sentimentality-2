package website.skylorbeck.sentimentality2;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;


public class Main implements ModInitializer {

    @Override
    public void onInitialize() {
        Registrar.register();
    }
}
