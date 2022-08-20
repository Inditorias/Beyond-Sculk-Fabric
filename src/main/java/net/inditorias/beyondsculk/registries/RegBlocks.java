package net.inditorias.beyondsculk.registries;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.inditorias.beyondsculk.BeyondSculk;
import net.inditorias.beyondsculk.blocks.*;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FallingBlock;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.HashMap;

public class RegBlocks {

    public static final Block SCORCHED_SAND = registerBlock("scorched_sand",
            new FallingBlock(FabricBlockSettings.of(Material.SOIL).strength(0.5f).requiresTool().resistance(0.5f).sounds(BlockSoundGroup.SAND)), ItemGroup.BUILDING_BLOCKS);

    public static final Block SCORCHED_SOIL = registerBlock("scorched_soil",
            new Block(FabricBlockSettings.of(Material.SOIL).strength(0.5f).requiresTool().resistance(0.5f).sounds(BlockSoundGroup.ROOTED_DIRT)), ItemGroup.BUILDING_BLOCKS);

    public static final Block ACTIVATED_REINFORCED_DEEPSLATE = registerBlock("activated_reinforced_deepslate",
            new ActivatedReinforcedDeepslate(FabricBlockSettings.copy(Blocks.BEDROCK).sounds(BlockSoundGroup.DEEPSLATE).luminance((state) -> 6)),
            ItemGroup.BUILDING_BLOCKS);

    public static final Block UNSTABLE_REINFORCED_DEEPSLATE = registerBlock("unstable_reinforced_deepslate",
            new Block(FabricBlockSettings.copy(Blocks.BEDROCK).sounds(BlockSoundGroup.DEEPSLATE).luminance((state) -> 3)),
            ItemGroup.BUILDING_BLOCKS);

    public static final Block RESONANT_REINFORCED_DEEPSLATE = registerBlock("resonant_reinforced_deepslate",
            new ResonantReinforcedDeepslate(FabricBlockSettings.copy(Blocks.BEDROCK).sounds(BlockSoundGroup.DEEPSLATE).luminance((state) -> 12)),
            ItemGroup.BUILDING_BLOCKS);

    public static final Block RESONANT_PORTAL =  registerBlockWithoutItem("resonant_portal",
            new ResonantPortal(FabricBlockSettings.copy(Blocks.NETHER_PORTAL)));

    public static final Block SCULK_PORTAL = registerBlockWithoutItem("sculk_portal",
            new AxisBlock(FabricBlockSettings.copy(Blocks.NETHER_PORTAL)));

    public static final Block SOUL_CAULDRON = registerBlockWithoutItem("soul_cauldron",
            new SoulCauldron(FabricBlockSettings.copy(Blocks.WATER_CAULDRON)));

    private static Item registerBlockItem(String name, Block block, ItemGroup tab){
        return Registry.register(Registry.ITEM, new Identifier(BeyondSculk.MOD_ID, name), new BlockItem(block, new FabricItemSettings().group(tab)));
    }

    private static Block registerBlock(String name, Block block, ItemGroup tab){
        registerBlockItem(name, block, tab);
        return Registry.register(Registry.BLOCK, new Identifier(BeyondSculk.MOD_ID, name), block);
    }

    private static Block registerBlockWithoutItem(String name, Block block){
        return Registry.register(Registry.BLOCK, new Identifier(BeyondSculk.MOD_ID, name), block);
    }

    public static void registerModBlocks(){
        BeyondSculk.LOGGER.debug("Registering Blocks for " + BeyondSculk.MOD_ID);
    }
}
