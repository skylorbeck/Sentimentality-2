package website.skylorbeck.sentimentality2;

import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SmokerBlock;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.FurnaceBlockEntity;
import net.minecraft.block.entity.SmokerBlockEntity;
import net.minecraft.client.particle.FlameParticle;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;


public class Registrar {


    public static void register() {
        regItem("fleather", Declarer.fleather);
        regBlock( "charcoal_block", Declarer.charcoal_block);
        regItem("charcoal_blockitem", Declarer.charcoal_blockitem);
        FuelRegistry.INSTANCE.add(Declarer.charcoal_blockitem, 16000);

        Declarer.END_FIRE_FLAME = Registry.register(Registry.PARTICLE_TYPE, new Identifier(Ref.MODID, "end_fire_flame"), FabricParticleTypes.simple());
        ParticleFactoryRegistry.getInstance().register(Declarer.END_FIRE_FLAME, FlameParticle.Factory::new);

        Declarer.EXTRA_FURNACE_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE,
                "sentimentality2:furnace",
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

        Declarer.EXTRA_BLAST_FURNACE_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE,
                "sentimentality2:blast_furnace",
                BlockEntityType.Builder.create(ExtraBlastFurnaceBlockEntity::new,
                        Declarer.sandstone_blast_furnaceblock,
                        Declarer.red_sandstone_blast_furnaceblock,
                        Declarer.andesite_blast_furnaceblock,
                        Declarer.granite_blast_furnaceblock,
                        Declarer.diorite_blast_furnaceblock,
                        Declarer.endstone_blast_furnaceblock,
                        Declarer.blackstone_blast_furnaceblock,
                        Declarer.netherrack_blast_furnaceblock,
                        Declarer.basalt_blast_furnaceblock
                ).build(null));
        
        Declarer.EXTRA_SMOKER_FURNACE_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE,
                "sentimentality2:smoker",
                BlockEntityType.Builder.create(ExtraSmokerBlockEntity::new,
                        Declarer.sandstone_smokerblock,
                        Declarer.red_sandstone_smokerblock,
                        Declarer.andesite_smokerblock,
                        Declarer.granite_smokerblock,
                        Declarer.diorite_smokerblock,
                        Declarer.endstone_smokerblock,
                        Declarer.blackstone_smokerblock,
                        Declarer.netherrack_smokerblock,
                        Declarer.basalt_smokerblock
                ).build(null));

        regBlock( "sandstone_furnace", Declarer.sandstone_furnaceblock);
        regItem("sandstone_furnaceitem", Declarer.sandstone_furnace);
        regBlock( "red_sandstone_furnace", Declarer.red_sandstone_furnaceblock);
        regItem("red_sandstone_furnaceitem", Declarer.red_sandstone_furnace);
        regBlock( "andesite_furnace", Declarer.andesite_furnaceblock);
        regItem("andesite_furnaceitem", Declarer.andesite_furnace);
        regBlock( "granite_furnace", Declarer.granite_furnaceblock);
        regItem("granite_furnaceitem", Declarer.granite_furnace);
        regBlock( "diorite_furnace", Declarer.diorite_furnaceblock);
        regItem("diorite_furnaceitem", Declarer.diorite_furnace);
        regBlock( "endstone_furnace", Declarer.endstone_furnaceblock);
        regItem("endstone_furnaceitem", Declarer.endstone_furnace);
        regBlock( "blackstone_furnace", Declarer.blackstone_furnaceblock);
        regItem("blackstone_furnaceitem", Declarer.blackstone_furnace);
        regBlock( "netherrack_furnace", Declarer.netherrack_furnaceblock);
        regItem("netherrack_furnaceitem", Declarer.netherrack_furnace);
        regBlock( "basalt_furnace", Declarer.basalt_furnaceblock);
        regItem("basalt_furnaceitem", Declarer.basalt_furnace);

        regBlock( "sandstone_blast_furnace", Declarer.sandstone_blast_furnaceblock);
        regItem("sandstone_blast_furnaceitem", Declarer.sandstone_blast_furnace);
        regBlock( "red_sandstone_blast_furnace", Declarer.red_sandstone_blast_furnaceblock);
        regItem("red_sandstone_blast_furnaceitem", Declarer.red_sandstone_blast_furnace);
        regBlock( "andesite_blast_furnace", Declarer.andesite_blast_furnaceblock);
        regItem("andesite_blast_furnaceitem", Declarer.andesite_blast_furnace);
        regBlock( "granite_blast_furnace", Declarer.granite_blast_furnaceblock);
        regItem("granite_blast_furnaceitem", Declarer.granite_blast_furnace);
        regBlock( "diorite_blast_furnace", Declarer.diorite_blast_furnaceblock);
        regItem("diorite_blast_furnaceitem", Declarer.diorite_blast_furnace);
        regBlock( "endstone_blast_furnace", Declarer.endstone_blast_furnaceblock);
        regItem("endstone_blast_furnaceitem", Declarer.endstone_blast_furnace);
        regBlock( "blackstone_blast_furnace", Declarer.blackstone_blast_furnaceblock);
        regItem("blackstone_blast_furnaceitem", Declarer.blackstone_blast_furnace);
        regBlock( "netherrack_blast_furnace", Declarer.netherrack_blast_furnaceblock);
        regItem("netherrack_blast_furnaceitem", Declarer.netherrack_blast_furnace);
        regBlock( "basalt_blast_furnace", Declarer.basalt_blast_furnaceblock);
        regItem("basalt_blast_furnaceitem", Declarer.basalt_blast_furnace);

        regBlock( "sandstone_smoker", Declarer.sandstone_smokerblock);
        regItem("sandstone_smokeritem", Declarer.sandstone_smoker);
        regBlock( "red_sandstone_smoker", Declarer.red_sandstone_smokerblock);
        regItem("red_sandstone_smokeritem", Declarer.red_sandstone_smoker);
        regBlock( "andesite_smoker", Declarer.andesite_smokerblock);
        regItem("andesite_smokeritem", Declarer.andesite_smoker);
        regBlock( "granite_smoker", Declarer.granite_smokerblock);
        regItem("granite_smokeritem", Declarer.granite_smoker);
        regBlock( "diorite_smoker", Declarer.diorite_smokerblock);
        regItem("diorite_smokeritem", Declarer.diorite_smoker);
        regBlock( "endstone_smoker", Declarer.endstone_smokerblock);
        regItem("endstone_smokeritem", Declarer.endstone_smoker);
        regBlock( "blackstone_smoker", Declarer.blackstone_smokerblock);
        regItem("blackstone_smokeritem", Declarer.blackstone_smoker);
        regBlock( "netherrack_smoker", Declarer.netherrack_smokerblock);
        regItem("netherrack_smokeritem", Declarer.netherrack_smoker);
        regBlock( "basalt_smoker", Declarer.basalt_smokerblock);
        regItem("basalt_smokeritem", Declarer.basalt_smoker);

        regItem("wool_helmet",Declarer.wool_helmet);
        regItem("wool_chestplate",Declarer.wool_chestplate);
        regItem("wool_leggings",Declarer.wool_leggings);
        regItem("wool_boots",Declarer.wool_boots);

        regItem("granitepick", Declarer.granitepick);
        regItem("graniteaxe", Declarer.graniteaxe);
        regItem("graniteshovel", Declarer.graniteshovel);
        regItem("granitesword", Declarer.granitesword);
        regItem("granitehoe", Declarer.granitehoe);
        regItem("dioritepick", Declarer.dioritepick);
        regItem("dioriteaxe", Declarer.dioriteaxe);
        regItem("dioriteshovel", Declarer.dioriteshovel);
        regItem("dioritesword", Declarer.dioritesword);
        regItem("dioritehoe", Declarer.dioritehoe);
        regItem("andesitepick", Declarer.andesitepick);
        regItem("andesiteaxe", Declarer.andesiteaxe);
        regItem("andesiteshovel", Declarer.andesiteshovel);
        regItem("andesitesword", Declarer.andesitesword);
        regItem("andesitehoe", Declarer.andesitehoe);
        regItem("quartzpick", Declarer.quartzpick);
        regItem("quartzaxe", Declarer.quartzaxe);
        regItem("quartzshovel", Declarer.quartzshovel);
        regItem("quartzsword", Declarer.quartzsword);
        regItem("quartzhoe", Declarer.quartzhoe);
        regItem("netherrackpick", Declarer.netherrackpick);
        regItem("netherrackaxe", Declarer.netherrackaxe);
        regItem("netherrackshovel", Declarer.netherrackshovel);
        regItem("netherracksword", Declarer.netherracksword);
        regItem("netherrackhoe", Declarer.netherrackhoe);
        regItem("netherbrickpick", Declarer.netherbrickpick);
        regItem("netherbrickaxe", Declarer.netherbrickaxe);
        regItem("netherbrickshovel", Declarer.netherbrickshovel);
        regItem("netherbricksword", Declarer.netherbricksword);
        regItem("netherbrickhoe", Declarer.netherbrickhoe);
        regItem("rednetherbrickpick", Declarer.rednetherbrickpick);
        regItem("rednetherbrickaxe", Declarer.rednetherbrickaxe);
        regItem("rednetherbrickshovel", Declarer.rednetherbrickshovel);
        regItem("rednetherbricksword", Declarer.rednetherbricksword);
        regItem("rednetherbrickhoe", Declarer.rednetherbrickhoe);
        regItem("sandstonepick", Declarer.sandstonepick);
        regItem("sandstoneaxe", Declarer.sandstoneaxe);
        regItem("sandstoneshovel", Declarer.sandstoneshovel);
        regItem("sandstonesword", Declarer.sandstonesword);
        regItem("sandstonehoe", Declarer.sandstonehoe);
        regItem("redsandstonepick", Declarer.redsandstonepick);
        regItem("redsandstoneaxe", Declarer.redsandstoneaxe);
        regItem("redsandstoneshovel", Declarer.redsandstoneshovel);
        regItem("redsandstonesword", Declarer.redsandstonesword);
        regItem("redsandstonehoe", Declarer.redsandstonehoe);
        regItem("lapispick", Declarer.lapispick);
        regItem("lapisaxe", Declarer.lapisaxe);
        regItem("lapisshovel", Declarer.lapisshovel);
        regItem("lapissword", Declarer.lapissword);
        regItem("lapishoe", Declarer.lapishoe);
        regItem("emeraldpick", Declarer.emeraldpick);
        regItem("emeraldaxe", Declarer.emeraldaxe);
        regItem("emeraldshovel", Declarer.emeraldshovel);
        regItem("emeraldsword", Declarer.emeraldsword);
        regItem("emeraldhoe", Declarer.emeraldhoe);
        regItem("flintpick", Declarer.flintpick);
        regItem("flintaxe", Declarer.flintaxe);
        regItem("flintshovel", Declarer.flintshovel);
        regItem("flintsword", Declarer.flintsword);
        regItem("flinthoe", Declarer.flinthoe);
        regItem("redstonepick", Declarer.redstonepick);
        regItem("redstoneaxe", Declarer.redstoneaxe);
        regItem("redstoneshovel", Declarer.redstoneshovel);
        regItem("redstonesword", Declarer.redstonesword);
        regItem("redstonehoe", Declarer.redstonehoe);
        regItem("blackstonepick",Declarer.blackstonepick);
        regItem("blackstoneaxe",Declarer.blackstoneaxe);
        regItem("blackstoneshovel",Declarer.blackstoneshovel);
        regItem("blackstonesword",Declarer.blackstonesword);
        regItem("blackstonehoe",Declarer.blackstonehoe);
        regItem("basaltpick",Declarer.basaltpick);
        regItem("basaltaxe",Declarer.basaltaxe);
        regItem("basaltshovel",Declarer.basaltshovel);
        regItem("basaltsword",Declarer.basaltsword);
        regItem("basalthoe",Declarer.basalthoe);
        regItem("endstonepick",Declarer.endstonepick);
        regItem("endstoneaxe",Declarer.endstoneaxe);
        regItem("endstoneshovel",Declarer.endstoneshovel);
        regItem("endstonesword",Declarer.endstonesword);
        regItem("endstonehoe",Declarer.endstonehoe);
    }

    public static void regItem(String name, Item itemid){
       Registry.register(Registry.ITEM, new Identifier(Ref.MODID, name), itemid);
    }
    public static void regBlock(String name, Block blockid){
        Registry.register(Registry.BLOCK, new Identifier(Ref.MODID, name), blockid);
    }
}
