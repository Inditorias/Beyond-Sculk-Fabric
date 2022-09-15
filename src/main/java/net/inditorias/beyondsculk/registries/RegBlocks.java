package net.inditorias.beyondsculk.registries;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.inditorias.beyondsculk.BeyondSculk;
import net.inditorias.beyondsculk.blocks.*;
import net.inditorias.beyondsculk.blocks.ResonantPortal;
import net.inditorias.beyondsculk.world.feature.tree.FlaurySaplingGenerator;
import net.minecraft.block.*;
import net.minecraft.entity.EntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.BlockView;

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

    public static final Block RESONANT_PORTAL = registerBlockWithoutItem("resonant_portal",
            new ResonantPortal(FabricBlockSettings.copy(Blocks.NETHER_PORTAL)));

    public static final Block SCULK_PORTAL = registerBlockWithoutItem("sculk_portal",
            new AxisBlock(FabricBlockSettings.copy(Blocks.NETHER_PORTAL)));

    public static final Block SOUL_CAULDRON = registerBlockWithoutItem("soul_cauldron",
            new SoulCauldron(FabricBlockSettings.copy(Blocks.WATER_CAULDRON)));

    public static final Block FLAURY_LOG = registerBlock("flaury_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG).requiresTool().strength(4.0f)), ItemGroup.BUILDING_BLOCKS);
    public static final Block FLAURY_WOOD = registerBlock("flaury_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_WOOD).requiresTool().strength(4.0f)), ItemGroup.BUILDING_BLOCKS);
    public static final Block STRIPPED_FLAURY_LOG = registerBlock("stripped_flaury_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_LOG).requiresTool().strength(4.0f)), ItemGroup.BUILDING_BLOCKS);
    public static final Block STRIPPED_FLAURY_WOOD = registerBlock("stripped_flaury_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_WOOD).requiresTool().strength(4.0f)), ItemGroup.BUILDING_BLOCKS);
    public static final Block FLAURY_PLANKS = registerBlock("flaury_planks",
            new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS).requiresTool().strength(4.0f)), ItemGroup.BUILDING_BLOCKS);

    public static final Block FLAURY_SAPLING = registerBlock("flaury_sapling",
            new BeyondSaplingBlock(new FlaurySaplingGenerator(),
                    FabricBlockSettings.copy(Blocks.OAK_SAPLING)), ItemGroup.DECORATIONS);

    public static final Block BLUE_FLAURY_LEAVES = registerBlock("blue_flaury_leaves",
            createLeavesBlock(BlockSoundGroup.GRASS), ItemGroup.DECORATIONS);
    public static final Block BROWN_FLAURY_LEAVES = registerBlock("brown_flaury_leaves",
            createLeavesBlock(BlockSoundGroup.GRASS), ItemGroup.DECORATIONS);
    public static final Block BLACK_FLAURY_LEAVES = registerBlock("black_flaury_leaves",
            createLeavesBlock(BlockSoundGroup.GRASS), ItemGroup.DECORATIONS);
    public static final Block GRAY_FLAURY_LEAVES = registerBlock("gray_flaury_leaves",
            createLeavesBlock(BlockSoundGroup.GRASS), ItemGroup.DECORATIONS);
    public static final Block LIGHT_BLUE_FLAURY_LEAVES = registerBlock("light_blue_flaury_leaves",
            createLeavesBlock(BlockSoundGroup.GRASS), ItemGroup.DECORATIONS);
    public static final Block LIGHT_GRAY_FLAURY_LEAVES = registerBlock("light_gray_flaury_leaves",
            createLeavesBlock(BlockSoundGroup.GRASS), ItemGroup.DECORATIONS);
    public static final Block LIME_FLAURY_LEAVES = registerBlock("lime_flaury_leaves",
            createLeavesBlock(BlockSoundGroup.GRASS), ItemGroup.DECORATIONS);
    public static final Block PINK_FLAURY_LEAVES = registerBlock("pink_flaury_leaves",
            createLeavesBlock(BlockSoundGroup.GRASS), ItemGroup.DECORATIONS);
    public static final Block PURPLE_FLAURY_LEAVES = registerBlock("purple_flaury_leaves",
            createLeavesBlock(BlockSoundGroup.GRASS), ItemGroup.DECORATIONS);
    public static final Block WHITE_FLAURY_LEAVES = registerBlock("white_flaury_leaves",
            createLeavesBlock(BlockSoundGroup.GRASS), ItemGroup.DECORATIONS);
    public static final Block YELLOW_FLAURY_LEAVES = registerBlock("yellow_flaury_leaves",
            createLeavesBlock(BlockSoundGroup.GRASS), ItemGroup.DECORATIONS);
    public static final Block GREEN_FLARUY_LEAVES = registerBlock("green_flaury_leaves",
            createLeavesBlock(BlockSoundGroup.GRASS), ItemGroup.DECORATIONS);
    public static final Block CYAN_FLAURY_LEAVES = registerBlock("cyan_flaury_leaves",
            createLeavesBlock(BlockSoundGroup.GRASS), ItemGroup.DECORATIONS);
    public static final Block MAGENTA_FLAURY_LEAVES = registerBlock("magenta_flaury_leaves",
            createLeavesBlock(BlockSoundGroup.GRASS), ItemGroup.DECORATIONS);
    public static final Block ORANGE_FLAURY_LEAVES = registerBlock("orange_flaury_leaves",
            createLeavesBlock(BlockSoundGroup.GRASS), ItemGroup.DECORATIONS);
    public static final Block RED_FLAURY_LEAVES = registerBlock("red_flaury_leaves",
            createLeavesBlock(BlockSoundGroup.GRASS), ItemGroup.DECORATIONS);


    private static Item registerBlockItem(String name, Block block, ItemGroup tab) {
        return Registry.register(Registry.ITEM, new Identifier(BeyondSculk.MOD_ID, name), new BlockItem(block, new FabricItemSettings().group(tab)));
    }

    private static Block registerBlock(String name, Block block, ItemGroup tab) {
        registerBlockItem(name, block, tab);
        return Registry.register(Registry.BLOCK, new Identifier(BeyondSculk.MOD_ID, name), block);
    }

    private static Block registerBlockWithoutItem(String name, Block block) {
        return Registry.register(Registry.BLOCK, new Identifier(BeyondSculk.MOD_ID, name), block);
    }

    public static void registerModBlocks() {
        BeyondSculk.LOGGER.debug("Registering Blocks for " + BeyondSculk.MOD_ID);
    }

    private static LeavesBlock createLeavesBlock(BlockSoundGroup soundGroup) {
        return new LeavesBlock(FabricBlockSettings.copy(Blocks.OAK_LEAVES).sounds(soundGroup).strength(0.2f).ticksRandomly().nonOpaque()
                .allowsSpawning(RegBlocks::canSpawnOnLeaves).suffocates(RegBlocks::never).blockVision(RegBlocks::never));
    }

    private static Boolean canSpawnOnLeaves(BlockState state, BlockView world, BlockPos pos, EntityType<?> type) {
        return type == EntityType.OCELOT || type == EntityType.PARROT;
    }

    private static boolean never(BlockState state, BlockView world, BlockPos pos) {
        return false;
    }
}
