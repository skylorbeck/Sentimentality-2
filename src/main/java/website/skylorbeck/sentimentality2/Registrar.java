package website.skylorbeck.sentimentality2;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;


public class Registrar {

    public static void register() {
        Registry.register(Registry.ITEM, new Identifier("sentimentality2", "fleather"), Declarer.fleather);
        Registry.register(Registry.ITEM, new Identifier("sentimentality2","granitepick"),ExtraToolDeclaration.granitepick);
        Registry.register(Registry.ITEM, new Identifier("sentimentality2","graniteaxe"),ExtraToolDeclaration.graniteaxe);
        Registry.register(Registry.ITEM, new Identifier("sentimentality2","graniteshovel"),ExtraToolDeclaration.graniteshovel);
        Registry.register(Registry.ITEM, new Identifier("sentimentality2","granitesword"),ExtraToolDeclaration.granitesword);
        Registry.register(Registry.ITEM, new Identifier("sentimentality2","granitehoe"),ExtraToolDeclaration.granitehoe);
        Registry.register(Registry.ITEM, new Identifier("sentimentality2","dioritepick"),ExtraToolDeclaration.dioritepick);
        Registry.register(Registry.ITEM, new Identifier("sentimentality2","dioriteaxe"),ExtraToolDeclaration.dioriteaxe);
        Registry.register(Registry.ITEM, new Identifier("sentimentality2","dioriteshovel"),ExtraToolDeclaration.dioriteshovel);
        Registry.register(Registry.ITEM, new Identifier("sentimentality2","dioritesword"),ExtraToolDeclaration.dioritesword);
        Registry.register(Registry.ITEM, new Identifier("sentimentality2","dioritehoe"),ExtraToolDeclaration.dioritehoe);
        Registry.register(Registry.ITEM, new Identifier("sentimentality2","andesitepick"),ExtraToolDeclaration.andesitepick);
        Registry.register(Registry.ITEM, new Identifier("sentimentality2","andesiteaxe"),ExtraToolDeclaration.andesiteaxe);
        Registry.register(Registry.ITEM, new Identifier("sentimentality2","andesiteshovel"),ExtraToolDeclaration.andesiteshovel);
        Registry.register(Registry.ITEM, new Identifier("sentimentality2","andesitesword"),ExtraToolDeclaration.andesitesword);
        Registry.register(Registry.ITEM, new Identifier("sentimentality2","andesitehoe"),ExtraToolDeclaration.andesitehoe);
        Registry.register(Registry.ITEM, new Identifier("sentimentality2","quartzpick"),ExtraToolDeclaration.quartzpick);
        Registry.register(Registry.ITEM, new Identifier("sentimentality2","quartzaxe"),ExtraToolDeclaration.quartzaxe);
        Registry.register(Registry.ITEM, new Identifier("sentimentality2","quartzshovel"),ExtraToolDeclaration.quartzshovel);
        Registry.register(Registry.ITEM, new Identifier("sentimentality2","quartzsword"),ExtraToolDeclaration.quartzsword);
        Registry.register(Registry.ITEM, new Identifier("sentimentality2","quartzhoe"),ExtraToolDeclaration.quartzhoe);
        Registry.register(Registry.ITEM, new Identifier("sentimentality2","netherrackpick"),ExtraToolDeclaration.netherrackpick);
        Registry.register(Registry.ITEM, new Identifier("sentimentality2","netherrackaxe"),ExtraToolDeclaration.netherrackaxe);
        Registry.register(Registry.ITEM, new Identifier("sentimentality2","netherrackshovel"),ExtraToolDeclaration.netherrackshovel);
        Registry.register(Registry.ITEM, new Identifier("sentimentality2","netherracksword"),ExtraToolDeclaration.netherracksword);
        Registry.register(Registry.ITEM, new Identifier("sentimentality2","netherrackhoe"),ExtraToolDeclaration.netherrackhoe);
        Registry.register(Registry.ITEM, new Identifier("sentimentality2","netherbrickpick"),ExtraToolDeclaration.netherbrickpick);
        Registry.register(Registry.ITEM, new Identifier("sentimentality2","netherbrickaxe"),ExtraToolDeclaration.netherbrickaxe);
        Registry.register(Registry.ITEM, new Identifier("sentimentality2","netherbrickshovel"),ExtraToolDeclaration.netherbrickshovel);
        Registry.register(Registry.ITEM, new Identifier("sentimentality2","netherbricksword"),ExtraToolDeclaration.netherbricksword);
        Registry.register(Registry.ITEM, new Identifier("sentimentality2","netherbrickhoe"),ExtraToolDeclaration.netherbrickhoe);
        Registry.register(Registry.ITEM, new Identifier("sentimentality2","rednetherbrickpick"),ExtraToolDeclaration.rednetherbrickpick);
        Registry.register(Registry.ITEM, new Identifier("sentimentality2","rednetherbrickaxe"),ExtraToolDeclaration.rednetherbrickaxe);
        Registry.register(Registry.ITEM, new Identifier("sentimentality2","rednetherbrickshovel"),ExtraToolDeclaration.rednetherbrickshovel);
        Registry.register(Registry.ITEM, new Identifier("sentimentality2","rednetherbricksword"),ExtraToolDeclaration.rednetherbricksword);
        Registry.register(Registry.ITEM, new Identifier("sentimentality2","rednetherbrickhoe"),ExtraToolDeclaration.rednetherbrickhoe);
        Registry.register(Registry.ITEM, new Identifier("sentimentality2","sandstonepick"),ExtraToolDeclaration.sandstonepick);
        Registry.register(Registry.ITEM, new Identifier("sentimentality2","sandstoneaxe"),ExtraToolDeclaration.sandstoneaxe);
        Registry.register(Registry.ITEM, new Identifier("sentimentality2","sandstoneshovel"),ExtraToolDeclaration.sandstoneshovel);
        Registry.register(Registry.ITEM, new Identifier("sentimentality2","sandstonesword"),ExtraToolDeclaration.sandstonesword);
        Registry.register(Registry.ITEM, new Identifier("sentimentality2","sandstonehoe"),ExtraToolDeclaration.sandstonehoe);
        Registry.register(Registry.ITEM, new Identifier("sentimentality2","redsandstonepick"),ExtraToolDeclaration.redsandstonepick);
        Registry.register(Registry.ITEM, new Identifier("sentimentality2","redsandstoneaxe"),ExtraToolDeclaration.redsandstoneaxe);
        Registry.register(Registry.ITEM, new Identifier("sentimentality2","redsandstoneshovel"),ExtraToolDeclaration.redsandstoneshovel);
        Registry.register(Registry.ITEM, new Identifier("sentimentality2","redsandstonesword"),ExtraToolDeclaration.redsandstonesword);
        Registry.register(Registry.ITEM, new Identifier("sentimentality2","redsandstonehoe"),ExtraToolDeclaration.redsandstonehoe);
        Registry.register(Registry.ITEM, new Identifier("sentimentality2","lapispick"),ExtraToolDeclaration.lapispick);
        Registry.register(Registry.ITEM, new Identifier("sentimentality2","lapisaxe"),ExtraToolDeclaration.lapisaxe);
        Registry.register(Registry.ITEM, new Identifier("sentimentality2","lapisshovel"),ExtraToolDeclaration.lapisshovel);
        Registry.register(Registry.ITEM, new Identifier("sentimentality2","lapissword"),ExtraToolDeclaration.lapissword);
        Registry.register(Registry.ITEM, new Identifier("sentimentality2","lapishoe"),ExtraToolDeclaration.lapishoe);
        Registry.register(Registry.ITEM, new Identifier("sentimentality2","emeraldpick"),ExtraToolDeclaration.emeraldpick);
        Registry.register(Registry.ITEM, new Identifier("sentimentality2","emeraldaxe"),ExtraToolDeclaration.emeraldaxe);
        Registry.register(Registry.ITEM, new Identifier("sentimentality2","emeraldshovel"),ExtraToolDeclaration.emeraldshovel);
        Registry.register(Registry.ITEM, new Identifier("sentimentality2","emeraldsword"),ExtraToolDeclaration.emeraldsword);
        Registry.register(Registry.ITEM, new Identifier("sentimentality2","emeraldhoe"),ExtraToolDeclaration.emeraldhoe);
        Registry.register(Registry.ITEM, new Identifier("sentimentality2","flintpick"),ExtraToolDeclaration.flintpick);
        Registry.register(Registry.ITEM, new Identifier("sentimentality2","flintaxe"),ExtraToolDeclaration.flintaxe);
        Registry.register(Registry.ITEM, new Identifier("sentimentality2","flintshovel"),ExtraToolDeclaration.flintshovel);
        Registry.register(Registry.ITEM, new Identifier("sentimentality2","flintsword"),ExtraToolDeclaration.flintsword);
        Registry.register(Registry.ITEM, new Identifier("sentimentality2","flinthoe"),ExtraToolDeclaration.flinthoe);

    }
}
