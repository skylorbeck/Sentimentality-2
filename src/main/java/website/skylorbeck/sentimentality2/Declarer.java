package website.skylorbeck.sentimentality2;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.*;
import net.minecraft.particle.DefaultParticleType;


public class Declarer {
    public static DefaultParticleType END_FIRE_FLAME;
    public static BlockEntityType<ExtraFurnaceBlockEntity> EXTRA_FURNACE_ENTITY;


    public static final Item fleather = new Item(new FabricItemSettings().group(ItemGroup.MISC));

    public static final Block charcoal_block =new Block(FabricBlockSettings.copyOf(Blocks.COAL_BLOCK));
    public static final BlockItem charcoal_blockitem = new BlockItem(charcoal_block,new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));

    public static final Block sandstone_furnaceblock = new ExtraFurnaceBlock(FabricBlockSettings.copyOf(Blocks.FURNACE),0);
    public static final BlockItem sandstone_furnace = new BlockItem(sandstone_furnaceblock,new Item.Settings().group(ItemGroup.DECORATIONS));
    public static final Block red_sandstone_furnaceblock = new ExtraFurnaceBlock(FabricBlockSettings.copyOf(Blocks.FURNACE),0);
    public static final BlockItem red_sandstone_furnace = new BlockItem(red_sandstone_furnaceblock,new Item.Settings().group(ItemGroup.DECORATIONS));
    public static final Block andesite_furnaceblock = new ExtraFurnaceBlock(FabricBlockSettings.copyOf(Blocks.FURNACE),0);
    public static final BlockItem andesite_furnace = new BlockItem(andesite_furnaceblock,new Item.Settings().group(ItemGroup.DECORATIONS));
    public static final Block granite_furnaceblock = new ExtraFurnaceBlock(FabricBlockSettings.copyOf(Blocks.FURNACE),0);
    public static final BlockItem granite_furnace = new BlockItem(granite_furnaceblock,new Item.Settings().group(ItemGroup.DECORATIONS));
    public static final Block diorite_furnaceblock = new ExtraFurnaceBlock(FabricBlockSettings.copyOf(Blocks.FURNACE),0);
    public static final BlockItem diorite_furnace = new BlockItem(diorite_furnaceblock,new Item.Settings().group(ItemGroup.DECORATIONS));
    public static final Block netherrack_furnaceblock = new ExtraFurnaceBlock(FabricBlockSettings.copyOf(Blocks.FURNACE),1);
    public static final BlockItem netherrack_furnace = new BlockItem(netherrack_furnaceblock,new Item.Settings().group(ItemGroup.DECORATIONS));
    public static final Block blackstone_furnaceblock = new ExtraFurnaceBlock(FabricBlockSettings.copyOf(Blocks.FURNACE),1);
    public static final BlockItem blackstone_furnace = new BlockItem(blackstone_furnaceblock,new Item.Settings().group(ItemGroup.DECORATIONS));
    public static final Block basalt_furnaceblock = new ExtraFurnaceBlock(FabricBlockSettings.copyOf(Blocks.FURNACE),1);
    public static final BlockItem basalt_furnace = new BlockItem(basalt_furnaceblock,new Item.Settings().group(ItemGroup.DECORATIONS));
    public static final Block endstone_furnaceblock = new ExtraFurnaceBlock(FabricBlockSettings.copyOf(Blocks.FURNACE),2);
    public static final BlockItem endstone_furnace = new BlockItem(endstone_furnaceblock,new Item.Settings().group(ItemGroup.DECORATIONS));
}
