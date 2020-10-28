package website.skylorbeck.sentimentality2;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.*;
import net.minecraft.util.Rarity;

public class ExtraToolDeclaration {
    //Granite
    public static Item granitesword = new SwordItem(ExtraToolMaterials.GRANITE, 3, -2.4F, (new Item.Settings()).group(ItemGroup.COMBAT));
    public static Item graniteshovel = new ShovelItem(ExtraToolMaterials.GRANITE, 1.5F, -3.0F, (new Item.Settings()).group(ItemGroup.TOOLS));
    public static Item granitepick = new ExtraPickaxeItem(ExtraToolMaterials.GRANITE,1,-2.8F,(new Item.Settings().group(ItemGroup.TOOLS)));
    public static Item graniteaxe = new ExtraAxeItem(ExtraToolMaterials.GRANITE, 7.0F, -3.2F, (new Item.Settings()).group(ItemGroup.TOOLS));
    public static Item granitehoe = new ExtraHoeItem(ExtraToolMaterials.GRANITE, -1,-2.0F, (new Item.Settings()).group(ItemGroup.TOOLS));
    //Diorite
    public static Item dioritesword = new SwordItem(ExtraToolMaterials.DIORITE, 3, -2.4F, (new Item.Settings()).group(ItemGroup.COMBAT));
    public static Item dioriteshovel = new ShovelItem(ExtraToolMaterials.DIORITE, 1.5F, -3.0F, (new Item.Settings()).group(ItemGroup.TOOLS));
    public static Item dioritepick = new ExtraPickaxeItem(ExtraToolMaterials.DIORITE,1,-2.8F,(new Item.Settings().group(ItemGroup.TOOLS)));
    public static Item dioriteaxe = new ExtraAxeItem(ExtraToolMaterials.DIORITE, 7.0F, -3.2F, (new Item.Settings()).group(ItemGroup.TOOLS));
    public static Item dioritehoe = new ExtraHoeItem(ExtraToolMaterials.DIORITE, -1,-2.0F, (new Item.Settings()).group(ItemGroup.TOOLS));
    //Andesite
    public static Item andesitesword = new SwordItem(ExtraToolMaterials.ANDESITE, 3, -2.4F, (new Item.Settings()).group(ItemGroup.COMBAT));
    public static Item andesiteshovel = new ShovelItem(ExtraToolMaterials.ANDESITE, 1.5F, -3.0F, (new Item.Settings()).group(ItemGroup.TOOLS));
    public static Item andesitepick = new ExtraPickaxeItem(ExtraToolMaterials.ANDESITE,1,-2.8F,(new Item.Settings().group(ItemGroup.TOOLS)));
    public static Item andesiteaxe = new ExtraAxeItem(ExtraToolMaterials.ANDESITE, 7.0F, -3.2F, (new Item.Settings()).group(ItemGroup.TOOLS));
    public static Item andesitehoe = new ExtraHoeItem(ExtraToolMaterials.ANDESITE, -1,-2.0F, (new Item.Settings()).group(ItemGroup.TOOLS));
    //Quartz
    public static Item quartzsword = new SwordItem(ExtraToolMaterials.QUARTZ, 3, -2.4F, (new Item.Settings()).group(ItemGroup.COMBAT));
    public static Item quartzshovel = new ShovelItem(ExtraToolMaterials.QUARTZ, 1.5F, -3.0F, (new Item.Settings()).group(ItemGroup.TOOLS));
    public static Item quartzpick = new ExtraPickaxeItem(ExtraToolMaterials.QUARTZ,1,-2.8F,(new Item.Settings().group(ItemGroup.TOOLS)));
    public static Item quartzaxe = new ExtraAxeItem(ExtraToolMaterials.QUARTZ, 6.0F, -3.2F, (new Item.Settings()).group(ItemGroup.TOOLS));
    public static Item quartzhoe = new ExtraHoeItem(ExtraToolMaterials.QUARTZ, -2,-1.0F, (new Item.Settings()).group(ItemGroup.TOOLS));
    //Netherrack
    public static Item netherracksword = new SwordItem(ExtraToolMaterials.NETHERRACK, 3, -2.4F, (new Item.Settings()).group(ItemGroup.COMBAT));
    public static Item netherrackshovel = new ShovelItem(ExtraToolMaterials.NETHERRACK, 1.5F, -3.0F, (new Item.Settings()).group(ItemGroup.TOOLS));
    public static Item netherrackpick = new ExtraPickaxeItem(ExtraToolMaterials.NETHERRACK,1,-2.8F,(new Item.Settings().group(ItemGroup.TOOLS)));
    public static Item netherrackaxe = new ExtraAxeItem(ExtraToolMaterials.NETHERRACK, 7.0F, -3.2F, (new Item.Settings()).group(ItemGroup.TOOLS));
    public static Item netherrackhoe = new ExtraHoeItem(ExtraToolMaterials.NETHERRACK, -1,-2.0F, (new Item.Settings()).group(ItemGroup.TOOLS));
    //NetherBrick
    public static Item netherbricksword = new SwordItem(ExtraToolMaterials.NETHERBRICK, 3, -2.4F, (new Item.Settings()).group(ItemGroup.COMBAT));
    public static Item netherbrickshovel = new ShovelItem(ExtraToolMaterials.NETHERBRICK, 1.5F, -3.0F, (new Item.Settings()).group(ItemGroup.TOOLS));
    public static Item netherbrickpick = new ExtraPickaxeItem(ExtraToolMaterials.NETHERBRICK,1,-2.8F,(new Item.Settings().group(ItemGroup.TOOLS)));
    public static Item netherbrickaxe = new ExtraAxeItem(ExtraToolMaterials.NETHERBRICK, 7.0F, -3.2F, (new Item.Settings()).group(ItemGroup.TOOLS));
    public static Item netherbrickhoe = new ExtraHoeItem(ExtraToolMaterials.NETHERBRICK, -1,-2.0F, (new Item.Settings()).group(ItemGroup.TOOLS));
    //Red NetherBrick
    public static Item rednetherbricksword = new SwordItem(ExtraToolMaterials.REDNETHERBRICK, 3, -2.4F, (new Item.Settings()).group(ItemGroup.COMBAT));
    public static Item rednetherbrickshovel = new ShovelItem(ExtraToolMaterials.REDNETHERBRICK, 1.5F, -3.0F, (new Item.Settings()).group(ItemGroup.TOOLS));
    public static Item rednetherbrickpick = new ExtraPickaxeItem(ExtraToolMaterials.REDNETHERBRICK,1,-2.8F,(new Item.Settings().group(ItemGroup.TOOLS)));
    public static Item rednetherbrickaxe = new ExtraAxeItem(ExtraToolMaterials.REDNETHERBRICK, 7.0F, -3.2F, (new Item.Settings()).group(ItemGroup.TOOLS));
    public static Item rednetherbrickhoe = new ExtraHoeItem(ExtraToolMaterials.REDNETHERBRICK, -1,-2.0F, (new Item.Settings()).group(ItemGroup.TOOLS));
    //Sandstone
    public static Item sandstonesword = new SwordItem(ExtraToolMaterials.SANDSTONE, 3, -2.4F, (new Item.Settings()).group(ItemGroup.COMBAT));
    public static Item sandstoneshovel = new ShovelItem(ExtraToolMaterials.SANDSTONE, 1.5F, -3.0F, (new Item.Settings()).group(ItemGroup.TOOLS));
    public static Item sandstonepick = new ExtraPickaxeItem(ExtraToolMaterials.SANDSTONE,1,-2.8F,(new Item.Settings().group(ItemGroup.TOOLS)));
    public static Item sandstoneaxe = new ExtraAxeItem(ExtraToolMaterials.SANDSTONE, 7.0F, -3.2F, (new Item.Settings()).group(ItemGroup.TOOLS));
    public static Item sandstonehoe = new ExtraHoeItem(ExtraToolMaterials.SANDSTONE, -1,-2.0F, (new Item.Settings()).group(ItemGroup.TOOLS));
    //Red Sandstone
    public static Item redsandstonesword = new SwordItem(ExtraToolMaterials.REDSANDSTONE, 3, -2.4F, (new Item.Settings()).group(ItemGroup.COMBAT));
    public static Item redsandstoneshovel = new ShovelItem(ExtraToolMaterials.REDSANDSTONE, 1.5F, -3.0F, (new Item.Settings()).group(ItemGroup.TOOLS));
    public static Item redsandstonepick = new ExtraPickaxeItem(ExtraToolMaterials.REDSANDSTONE,1,-2.8F,(new Item.Settings().group(ItemGroup.TOOLS)));
    public static Item redsandstoneaxe = new ExtraAxeItem(ExtraToolMaterials.REDSANDSTONE, 7.0F, -3.2F, (new Item.Settings()).group(ItemGroup.TOOLS));
    public static Item redsandstonehoe = new ExtraHoeItem(ExtraToolMaterials.REDSANDSTONE, -1,-2.0F, (new Item.Settings()).group(ItemGroup.TOOLS));
    //Redstone
    public static Item redstonesword = new SwordItem(ExtraToolMaterials.REDSTONE, 3, -2.4F, (new Item.Settings()).group(ItemGroup.COMBAT));
    public static Item redstoneshovel = new ShovelItem(ExtraToolMaterials.REDSTONE, 1.5F, -3.0F, (new Item.Settings()).group(ItemGroup.TOOLS));
    public static Item redstonepick = new ExtraPickaxeItem(ExtraToolMaterials.REDSTONE,1,-2.8F,(new Item.Settings().group(ItemGroup.TOOLS)));
    public static Item redstoneaxe = new ExtraAxeItem(ExtraToolMaterials.REDSTONE, 5.0F, -3.2F, (new Item.Settings()).group(ItemGroup.TOOLS));
    public static Item redstonehoe = new ExtraHoeItem(ExtraToolMaterials.REDSTONE, -2,-1.0F, (new Item.Settings()).group(ItemGroup.TOOLS));
    //Lapis
    public static Item lapissword = new SwordItem(ExtraToolMaterials.LAPIS, 3, -2.4F, (new Item.Settings()).group(ItemGroup.COMBAT));
    public static Item lapisshovel = new ShovelItem(ExtraToolMaterials.LAPIS, 1.5F, -3.0F, (new Item.Settings()).group(ItemGroup.TOOLS));
    public static Item lapispick = new ExtraPickaxeItem(ExtraToolMaterials.LAPIS,1,-2.8F,(new Item.Settings().group(ItemGroup.TOOLS)));
    public static Item lapisaxe = new ExtraAxeItem(ExtraToolMaterials.LAPIS, 5.0F, -3.2F, (new Item.Settings()).group(ItemGroup.TOOLS));
    public static Item lapishoe = new ExtraHoeItem(ExtraToolMaterials.LAPIS, -2,-1.0F, (new Item.Settings()).group(ItemGroup.TOOLS));
    //Emerald
    public static Item emeraldsword = new SwordItem(ExtraToolMaterials.EMERALD, 3, -2.4F, (new Item.Settings()).group(ItemGroup.COMBAT));
    public static Item emeraldshovel = new ShovelItem(ExtraToolMaterials.EMERALD, 1.5F, -3.0F, (new Item.Settings()).group(ItemGroup.TOOLS));
    public static Item emeraldpick = new ExtraPickaxeItem(ExtraToolMaterials.EMERALD,1,-2.8F,(new Item.Settings().group(ItemGroup.TOOLS)));
    public static Item emeraldaxe = new ExtraAxeItem(ExtraToolMaterials.EMERALD, 5.0F, -3.2F, (new Item.Settings()).group(ItemGroup.TOOLS));
    public static Item emeraldhoe = new ExtraHoeItem(ExtraToolMaterials.EMERALD, -2,-1.0F, (new Item.Settings()).group(ItemGroup.TOOLS));
    //Flint
    public static Item flintsword = new SwordItem(ExtraToolMaterials.FLINT, 3, -2.4F, (new Item.Settings()).group(ItemGroup.COMBAT));
    public static Item flintshovel = new ShovelItem(ExtraToolMaterials.FLINT, 1.5F, -3.0F, (new Item.Settings()).group(ItemGroup.TOOLS));
    public static Item flintpick = new ExtraPickaxeItem(ExtraToolMaterials.FLINT,1,-2.8F,(new Item.Settings().group(ItemGroup.TOOLS)));
    public static Item flintaxe = new ExtraAxeItem(ExtraToolMaterials.FLINT, 7.0F, -3.2F, (new Item.Settings()).group(ItemGroup.TOOLS));
    public static Item flinthoe = new ExtraHoeItem(ExtraToolMaterials.FLINT, -1,-2.0F, (new Item.Settings()).group(ItemGroup.TOOLS));
}
