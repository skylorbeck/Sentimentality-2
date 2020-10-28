package website.skylorbeck.sentimentality2;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.*;


public class Declarer {
    public static final Item fleather = new Item(new FabricItemSettings().group(ItemGroup.MISC));
    public static final Block charcoal_block =new Block(FabricBlockSettings.copyOf(Blocks.COAL_BLOCK));
    public static final BlockItem charcoal_blockitem = new BlockItem(charcoal_block,new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));
    public static final Block sandstone_furnace = new ExtraFurnaceBlock(FabricBlockSettings.copyOf(Blocks.FURNACE));
    public static final BlockItem sandstone_furnaceitem = new BlockItem(sandstone_furnace,new Item.Settings().group(ItemGroup.DECORATIONS));
}
