package website.skylorbeck.sentimentality2;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.*;
import net.minecraft.util.registry.Registry;


public class Declarer {
    public static final Item fleather = new Item(new FabricItemSettings().group(ItemGroup.MISC));
    public static final Block charcoal_block =new Block(FabricBlockSettings.of(Material.STONE, MaterialColor.BLACK).hardness(5f));
    public static final BlockItem charcoal_blockitem = new BlockItem(charcoal_block,new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));
}
