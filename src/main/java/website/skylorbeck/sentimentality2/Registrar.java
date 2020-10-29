package website.skylorbeck.sentimentality2;

import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.client.particle.FlameParticle;
import net.minecraft.client.particle.ParticleManager;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;


public class Registrar {


    public static void register() {
        Registry.register(Registry.ITEM, new Identifier(Ref.MODID, "fleather"), Declarer.fleather);
        Registry.register(Registry.BLOCK, new Identifier(Ref.MODID, "charcoal_block"), Declarer.charcoal_block);
        Registry.register(Registry.ITEM, new Identifier(Ref.MODID, "charcoal_blockitem"), Declarer.charcoal_blockitem);
        FuelRegistry.INSTANCE.add(Declarer.charcoal_blockitem, 16000);


        Declarer.END_FIRE_FLAME = Registry.register(Registry.PARTICLE_TYPE, new Identifier(Ref.MODID, "end_fire_flame"), FabricParticleTypes.simple());
        ParticleFactoryRegistry.getInstance().register(Declarer.END_FIRE_FLAME, FlameParticle.Factory::new);

        Declarer.EXTRA_FURNACE_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE,
                "sentimentality2:extrafurnaceentity",
                BlockEntityType.Builder.create(ExtraFurnaceBlockEntity::new,
                        Declarer.sandstone_furnaceblock,
                        Declarer.red_sandstone_furnaceblock,
                        Declarer.andesite_furnaceblock,
                        Declarer.granite_furnaceblock,
                        Declarer.diorite_furnaceblock,
                        Declarer.endstone_furnaceblock,
                        Declarer.blackstone_furnaceblock,
                        Declarer.netherrack_furnaceblock,
                        Declarer.basalt_furnaceblock
                ).build(null));

        Registry.register(Registry.BLOCK, new Identifier(Ref.MODID, "sandstone_furnace"), Declarer.sandstone_furnaceblock);
        Registry.register(Registry.ITEM, new Identifier(Ref.MODID, "sandstone_furnaceitem"), Declarer.sandstone_furnace);
        Registry.register(Registry.BLOCK, new Identifier(Ref.MODID, "red_sandstone_furnace"), Declarer.red_sandstone_furnaceblock);
        Registry.register(Registry.ITEM, new Identifier(Ref.MODID, "red_sandstone_furnaceitem"), Declarer.red_sandstone_furnace);
        Registry.register(Registry.BLOCK, new Identifier(Ref.MODID, "andesite_furnace"), Declarer.andesite_furnaceblock);
        Registry.register(Registry.ITEM, new Identifier(Ref.MODID, "andesite_furnaceitem"), Declarer.andesite_furnace);
        Registry.register(Registry.BLOCK, new Identifier(Ref.MODID, "granite_furnace"), Declarer.granite_furnaceblock);
        Registry.register(Registry.ITEM, new Identifier(Ref.MODID, "granite_furnaceitem"), Declarer.granite_furnace);
        Registry.register(Registry.BLOCK, new Identifier(Ref.MODID, "diorite_furnace"), Declarer.diorite_furnaceblock);
        Registry.register(Registry.ITEM, new Identifier(Ref.MODID, "diorite_furnaceitem"), Declarer.diorite_furnace);
        Registry.register(Registry.BLOCK, new Identifier(Ref.MODID, "endstone_furnace"), Declarer.endstone_furnaceblock);
        Registry.register(Registry.ITEM, new Identifier(Ref.MODID, "endstone_furnaceitem"), Declarer.endstone_furnace);
        Registry.register(Registry.BLOCK, new Identifier(Ref.MODID, "blackstone_furnace"), Declarer.blackstone_furnaceblock);
        Registry.register(Registry.ITEM, new Identifier(Ref.MODID, "blackstone_furnaceitem"), Declarer.blackstone_furnace);
        Registry.register(Registry.BLOCK, new Identifier(Ref.MODID, "netherrack_furnace"), Declarer.netherrack_furnaceblock);
        Registry.register(Registry.ITEM, new Identifier(Ref.MODID, "netherrack_furnaceitem"), Declarer.netherrack_furnace);
        Registry.register(Registry.BLOCK, new Identifier(Ref.MODID, "basalt_furnace"), Declarer.basalt_furnaceblock);
        Registry.register(Registry.ITEM, new Identifier(Ref.MODID, "basalt_furnaceitem"), Declarer.basalt_furnace);

        Registry.register(Registry.ITEM, new Identifier(Ref.MODID, "granitepick"), ExtraToolDeclaration.granitepick);
        Registry.register(Registry.ITEM, new Identifier(Ref.MODID, "graniteaxe"), ExtraToolDeclaration.graniteaxe);
        Registry.register(Registry.ITEM, new Identifier(Ref.MODID, "graniteshovel"), ExtraToolDeclaration.graniteshovel);
        Registry.register(Registry.ITEM, new Identifier(Ref.MODID, "granitesword"), ExtraToolDeclaration.granitesword);
        Registry.register(Registry.ITEM, new Identifier(Ref.MODID, "granitehoe"), ExtraToolDeclaration.granitehoe);
        Registry.register(Registry.ITEM, new Identifier(Ref.MODID, "dioritepick"), ExtraToolDeclaration.dioritepick);
        Registry.register(Registry.ITEM, new Identifier(Ref.MODID, "dioriteaxe"), ExtraToolDeclaration.dioriteaxe);
        Registry.register(Registry.ITEM, new Identifier(Ref.MODID, "dioriteshovel"), ExtraToolDeclaration.dioriteshovel);
        Registry.register(Registry.ITEM, new Identifier(Ref.MODID, "dioritesword"), ExtraToolDeclaration.dioritesword);
        Registry.register(Registry.ITEM, new Identifier(Ref.MODID, "dioritehoe"), ExtraToolDeclaration.dioritehoe);
        Registry.register(Registry.ITEM, new Identifier(Ref.MODID, "andesitepick"), ExtraToolDeclaration.andesitepick);
        Registry.register(Registry.ITEM, new Identifier(Ref.MODID, "andesiteaxe"), ExtraToolDeclaration.andesiteaxe);
        Registry.register(Registry.ITEM, new Identifier(Ref.MODID, "andesiteshovel"), ExtraToolDeclaration.andesiteshovel);
        Registry.register(Registry.ITEM, new Identifier(Ref.MODID, "andesitesword"), ExtraToolDeclaration.andesitesword);
        Registry.register(Registry.ITEM, new Identifier(Ref.MODID, "andesitehoe"), ExtraToolDeclaration.andesitehoe);
        Registry.register(Registry.ITEM, new Identifier(Ref.MODID, "quartzpick"), ExtraToolDeclaration.quartzpick);
        Registry.register(Registry.ITEM, new Identifier(Ref.MODID, "quartzaxe"), ExtraToolDeclaration.quartzaxe);
        Registry.register(Registry.ITEM, new Identifier(Ref.MODID, "quartzshovel"), ExtraToolDeclaration.quartzshovel);
        Registry.register(Registry.ITEM, new Identifier(Ref.MODID, "quartzsword"), ExtraToolDeclaration.quartzsword);
        Registry.register(Registry.ITEM, new Identifier(Ref.MODID, "quartzhoe"), ExtraToolDeclaration.quartzhoe);
        Registry.register(Registry.ITEM, new Identifier(Ref.MODID, "netherrackpick"), ExtraToolDeclaration.netherrackpick);
        Registry.register(Registry.ITEM, new Identifier(Ref.MODID, "netherrackaxe"), ExtraToolDeclaration.netherrackaxe);
        Registry.register(Registry.ITEM, new Identifier(Ref.MODID, "netherrackshovel"), ExtraToolDeclaration.netherrackshovel);
        Registry.register(Registry.ITEM, new Identifier(Ref.MODID, "netherracksword"), ExtraToolDeclaration.netherracksword);
        Registry.register(Registry.ITEM, new Identifier(Ref.MODID, "netherrackhoe"), ExtraToolDeclaration.netherrackhoe);
        Registry.register(Registry.ITEM, new Identifier(Ref.MODID, "netherbrickpick"), ExtraToolDeclaration.netherbrickpick);
        Registry.register(Registry.ITEM, new Identifier(Ref.MODID, "netherbrickaxe"), ExtraToolDeclaration.netherbrickaxe);
        Registry.register(Registry.ITEM, new Identifier(Ref.MODID, "netherbrickshovel"), ExtraToolDeclaration.netherbrickshovel);
        Registry.register(Registry.ITEM, new Identifier(Ref.MODID, "netherbricksword"), ExtraToolDeclaration.netherbricksword);
        Registry.register(Registry.ITEM, new Identifier(Ref.MODID, "netherbrickhoe"), ExtraToolDeclaration.netherbrickhoe);
        Registry.register(Registry.ITEM, new Identifier(Ref.MODID, "rednetherbrickpick"), ExtraToolDeclaration.rednetherbrickpick);
        Registry.register(Registry.ITEM, new Identifier(Ref.MODID, "rednetherbrickaxe"), ExtraToolDeclaration.rednetherbrickaxe);
        Registry.register(Registry.ITEM, new Identifier(Ref.MODID, "rednetherbrickshovel"), ExtraToolDeclaration.rednetherbrickshovel);
        Registry.register(Registry.ITEM, new Identifier(Ref.MODID, "rednetherbricksword"), ExtraToolDeclaration.rednetherbricksword);
        Registry.register(Registry.ITEM, new Identifier(Ref.MODID, "rednetherbrickhoe"), ExtraToolDeclaration.rednetherbrickhoe);
        Registry.register(Registry.ITEM, new Identifier(Ref.MODID, "sandstonepick"), ExtraToolDeclaration.sandstonepick);
        Registry.register(Registry.ITEM, new Identifier(Ref.MODID, "sandstoneaxe"), ExtraToolDeclaration.sandstoneaxe);
        Registry.register(Registry.ITEM, new Identifier(Ref.MODID, "sandstoneshovel"), ExtraToolDeclaration.sandstoneshovel);
        Registry.register(Registry.ITEM, new Identifier(Ref.MODID, "sandstonesword"), ExtraToolDeclaration.sandstonesword);
        Registry.register(Registry.ITEM, new Identifier(Ref.MODID, "sandstonehoe"), ExtraToolDeclaration.sandstonehoe);
        Registry.register(Registry.ITEM, new Identifier(Ref.MODID, "redsandstonepick"), ExtraToolDeclaration.redsandstonepick);
        Registry.register(Registry.ITEM, new Identifier(Ref.MODID, "redsandstoneaxe"), ExtraToolDeclaration.redsandstoneaxe);
        Registry.register(Registry.ITEM, new Identifier(Ref.MODID, "redsandstoneshovel"), ExtraToolDeclaration.redsandstoneshovel);
        Registry.register(Registry.ITEM, new Identifier(Ref.MODID, "redsandstonesword"), ExtraToolDeclaration.redsandstonesword);
        Registry.register(Registry.ITEM, new Identifier(Ref.MODID, "redsandstonehoe"), ExtraToolDeclaration.redsandstonehoe);
        Registry.register(Registry.ITEM, new Identifier(Ref.MODID, "lapispick"), ExtraToolDeclaration.lapispick);
        Registry.register(Registry.ITEM, new Identifier(Ref.MODID, "lapisaxe"), ExtraToolDeclaration.lapisaxe);
        Registry.register(Registry.ITEM, new Identifier(Ref.MODID, "lapisshovel"), ExtraToolDeclaration.lapisshovel);
        Registry.register(Registry.ITEM, new Identifier(Ref.MODID, "lapissword"), ExtraToolDeclaration.lapissword);
        Registry.register(Registry.ITEM, new Identifier(Ref.MODID, "lapishoe"), ExtraToolDeclaration.lapishoe);
        Registry.register(Registry.ITEM, new Identifier(Ref.MODID, "emeraldpick"), ExtraToolDeclaration.emeraldpick);
        Registry.register(Registry.ITEM, new Identifier(Ref.MODID, "emeraldaxe"), ExtraToolDeclaration.emeraldaxe);
        Registry.register(Registry.ITEM, new Identifier(Ref.MODID, "emeraldshovel"), ExtraToolDeclaration.emeraldshovel);
        Registry.register(Registry.ITEM, new Identifier(Ref.MODID, "emeraldsword"), ExtraToolDeclaration.emeraldsword);
        Registry.register(Registry.ITEM, new Identifier(Ref.MODID, "emeraldhoe"), ExtraToolDeclaration.emeraldhoe);
        Registry.register(Registry.ITEM, new Identifier(Ref.MODID, "flintpick"), ExtraToolDeclaration.flintpick);
        Registry.register(Registry.ITEM, new Identifier(Ref.MODID, "flintaxe"), ExtraToolDeclaration.flintaxe);
        Registry.register(Registry.ITEM, new Identifier(Ref.MODID, "flintshovel"), ExtraToolDeclaration.flintshovel);
        Registry.register(Registry.ITEM, new Identifier(Ref.MODID, "flintsword"), ExtraToolDeclaration.flintsword);
        Registry.register(Registry.ITEM, new Identifier(Ref.MODID, "flinthoe"), ExtraToolDeclaration.flinthoe);
        Registry.register(Registry.ITEM, new Identifier(Ref.MODID, "redstonepick"), ExtraToolDeclaration.redstonepick);
        Registry.register(Registry.ITEM, new Identifier(Ref.MODID, "redstoneaxe"), ExtraToolDeclaration.redstoneaxe);
        Registry.register(Registry.ITEM, new Identifier(Ref.MODID, "redstoneshovel"), ExtraToolDeclaration.redstoneshovel);
        Registry.register(Registry.ITEM, new Identifier(Ref.MODID, "redstonesword"), ExtraToolDeclaration.redstonesword);
        Registry.register(Registry.ITEM, new Identifier(Ref.MODID, "redstonehoe"), ExtraToolDeclaration.redstonehoe);
    }
}
