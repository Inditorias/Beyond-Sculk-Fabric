package net.inditorias.beyondsculk.world.feature;

import net.inditorias.beyondsculk.BeyondSculk;
import net.inditorias.beyondsculk.mixin.FoliagePlacerTypeInvoker;
import net.inditorias.beyondsculk.registries.RegBlocks;
import net.inditorias.beyondsculk.world.gen.foliage.ElipseFoliagePlacer;
import net.minecraft.block.Block;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.FoliagePlacerType;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

import java.util.List;

public class ModConfiguredFeatures {

    public static final FoliagePlacerType<ElipseFoliagePlacer> ELIPSE_FOLIAGE_PLACER = Registry.register(
            Registry.FOLIAGE_PLACER_TYPE,
            new Identifier(BeyondSculk.MOD_ID, "elipse_foliage_placer"),
            FoliagePlacerTypeInvoker.invokeCtor(ElipseFoliagePlacer.CODEC)
    );

    public static final RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>> BLUE_FLAURY_TREE =
            FlauryConfiguredFeatureGen("blue_flaury_tree", RegBlocks.BLUE_FLAURY_LEAVES);
    public static final RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>> BLACK_FLAURY_TREE =
            FlauryConfiguredFeatureGen("black_flaury_tree", RegBlocks.BLACK_FLAURY_LEAVES);
    public static final RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>> BROWN_FLAURY_TREE =
            FlauryConfiguredFeatureGen("brown_flaury_tree", RegBlocks.BROWN_FLAURY_LEAVES);
    public static final RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>> LIGHT_BLUE_FLAURY_TREE =
            FlauryConfiguredFeatureGen("light_blue_flaury_tree", RegBlocks.LIGHT_BLUE_FLAURY_LEAVES);
    public static final RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>> LIGHT_GRAY_FLAURY_TREE =
            FlauryConfiguredFeatureGen("light_gray_flaury_tree", RegBlocks.LIGHT_GRAY_FLAURY_LEAVES);
    public static final RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>> LIME_FLAURY_TREE =
            FlauryConfiguredFeatureGen("lime_flaury_tree", RegBlocks.LIME_FLAURY_LEAVES);
    public static final RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>> PINK_FLAURY_TREE =
            FlauryConfiguredFeatureGen("pink_flaury_tree", RegBlocks.PINK_FLAURY_LEAVES);
    public static final RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>> PURPLE_FLAURY_TREE =
            FlauryConfiguredFeatureGen("purple_flaury_tree", RegBlocks.PURPLE_FLAURY_LEAVES);
    public static final RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>> WHITE_FLAURY_TREE =
            FlauryConfiguredFeatureGen("white_flaury_tree", RegBlocks.WHITE_FLAURY_LEAVES);
    public static final RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>> YELLOW_FLAURY_TREE =
            FlauryConfiguredFeatureGen("yellow_flaury_tree", RegBlocks.YELLOW_FLAURY_LEAVES);
    public static final RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>> GRAY_FLAURY_TREE =
            FlauryConfiguredFeatureGen("gray_flaury_tree", RegBlocks.GRAY_FLAURY_LEAVES);
    public static final RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>> RED_FLAURY_TREE =
            FlauryConfiguredFeatureGen("red_flaury_tree", RegBlocks.RED_FLAURY_LEAVES);
    public static final RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>> GREEN_FLAURY_TREE =
            FlauryConfiguredFeatureGen("green_flaury_tree", RegBlocks.GREEN_FLARUY_LEAVES);
    public static final RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>> CYAN_FLAURY_TREE =
            FlauryConfiguredFeatureGen("cyan_flaury_tree", RegBlocks.CYAN_FLAURY_LEAVES);
    public static final RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>> ORANGE_FLAURY_TREE =
            FlauryConfiguredFeatureGen("orange_flaury_tree", RegBlocks.ORANGE_FLAURY_LEAVES);
    public static final RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>> MAGENTA_FLAURY_TREE =
            FlauryConfiguredFeatureGen("magenta_flaury_tree", RegBlocks.MAGENTA_FLAURY_LEAVES);

    public static final RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>>[] FLAURY_TREES =
        new RegistryEntry[]{BLUE_FLAURY_TREE, BLACK_FLAURY_TREE,BROWN_FLAURY_TREE,WHITE_FLAURY_TREE,YELLOW_FLAURY_TREE,
                GRAY_FLAURY_TREE,LIME_FLAURY_TREE,LIGHT_BLUE_FLAURY_TREE,LIGHT_GRAY_FLAURY_TREE, RED_FLAURY_TREE, 
                GREEN_FLAURY_TREE, CYAN_FLAURY_TREE, ORANGE_FLAURY_TREE, MAGENTA_FLAURY_TREE,PURPLE_FLAURY_TREE,PINK_FLAURY_TREE};


    public static final RegistryEntry<PlacedFeature> BLUE_FLAURY_CHECKED = PlacedFeatures.register("blue_flaury_checked",
            BLUE_FLAURY_TREE, PlacedFeatures.wouldSurvive(RegBlocks.FLAURY_SAPLING));
    public static final RegistryEntry<PlacedFeature> RED_FLAURY_CHECKED = PlacedFeatures.register("red_flaury_checked",
            RED_FLAURY_TREE, PlacedFeatures.wouldSurvive(RegBlocks.FLAURY_SAPLING));
    public static final RegistryEntry<PlacedFeature> GREEN_FLAURY_CHECKED = PlacedFeatures.register("green_flaury_checked",
            GREEN_FLAURY_TREE, PlacedFeatures.wouldSurvive(RegBlocks.FLAURY_SAPLING));
    public static final RegistryEntry<PlacedFeature> CYAN_FLAURY_CHECKED = PlacedFeatures.register("cyan_flaury_checked",
            CYAN_FLAURY_TREE, PlacedFeatures.wouldSurvive(RegBlocks.FLAURY_SAPLING));
    public static final RegistryEntry<PlacedFeature> ORANGE_FLAURY_CHECKED = PlacedFeatures.register("orange_flaury_checked",
            ORANGE_FLAURY_TREE, PlacedFeatures.wouldSurvive(RegBlocks.FLAURY_SAPLING));
    public static final RegistryEntry<PlacedFeature> MAGENTA_FLAURY_CHECKED = PlacedFeatures.register("magenta_flaury_checked",
            MAGENTA_FLAURY_TREE, PlacedFeatures.wouldSurvive(RegBlocks.FLAURY_SAPLING));
    public static final RegistryEntry<PlacedFeature> BLACK_FLAURY_CHECKED = PlacedFeatures.register("black_flaury_checked",
            BLACK_FLAURY_TREE, PlacedFeatures.wouldSurvive(RegBlocks.FLAURY_SAPLING));
    public static final RegistryEntry<PlacedFeature> BROWN_FLAURY_CHECKED = PlacedFeatures.register("brown_flaury_checked",
            BROWN_FLAURY_TREE, PlacedFeatures.wouldSurvive(RegBlocks.FLAURY_SAPLING));
    public static final RegistryEntry<PlacedFeature> YELLOW_FLAURY_CHECKED = PlacedFeatures.register("yellow_flaury_checked",
            YELLOW_FLAURY_TREE, PlacedFeatures.wouldSurvive(RegBlocks.FLAURY_SAPLING));
    public static final RegistryEntry<PlacedFeature> WHITE_FLAURY_CHECKED = PlacedFeatures.register("white_flaury_checked",
            WHITE_FLAURY_TREE, PlacedFeatures.wouldSurvive(RegBlocks.FLAURY_SAPLING));
    public static final RegistryEntry<PlacedFeature> GRAY_FLAURY_CHECKED = PlacedFeatures.register("gray_flaury_checked",
            GRAY_FLAURY_TREE, PlacedFeatures.wouldSurvive(RegBlocks.FLAURY_SAPLING));
    public static final RegistryEntry<PlacedFeature> LIGHT_BLUE_FLAURY_CHECKED = PlacedFeatures.register("light_blue_flaury_checked",
            LIGHT_BLUE_FLAURY_TREE, PlacedFeatures.wouldSurvive(RegBlocks.FLAURY_SAPLING));
    public static final RegistryEntry<PlacedFeature> LIGHT_GRAY_FLAURY_CHECKED = PlacedFeatures.register("light_gray_flaury_checked",
            LIGHT_GRAY_FLAURY_TREE, PlacedFeatures.wouldSurvive(RegBlocks.FLAURY_SAPLING));
    public static final RegistryEntry<PlacedFeature> LIME_FLAURY_CHECKED = PlacedFeatures.register("lime_flaury_checked",
            LIME_FLAURY_TREE, PlacedFeatures.wouldSurvive(RegBlocks.FLAURY_SAPLING));
    public static final RegistryEntry<PlacedFeature> PINK_FLAURY_CHECKED = PlacedFeatures.register("pink_flaury_checked",
            PINK_FLAURY_TREE, PlacedFeatures.wouldSurvive(RegBlocks.FLAURY_SAPLING));
    public static final RegistryEntry<PlacedFeature> PURPLE_FLAURY_CHECKED = PlacedFeatures.register("purple_flaury_checked",
            PURPLE_FLAURY_TREE, PlacedFeatures.wouldSurvive(RegBlocks.FLAURY_SAPLING));

    public static final RegistryEntry<ConfiguredFeature<RandomFeatureConfig, ?>> FLAURY_SPAWN =
            ConfiguredFeatures.register("flaury_spawn", Feature.RANDOM_SELECTOR,
                    new RandomFeatureConfig(List.of(
                        new RandomFeatureEntry(BLUE_FLAURY_CHECKED, .073f),
                            new RandomFeatureEntry(RED_FLAURY_CHECKED, .073f),
                            new RandomFeatureEntry(CYAN_FLAURY_CHECKED, .073f),
                            new RandomFeatureEntry(BLACK_FLAURY_CHECKED, .03f),
                            new RandomFeatureEntry(BROWN_FLAURY_CHECKED, .073f),
                            new RandomFeatureEntry(YELLOW_FLAURY_CHECKED, .073f),
                            new RandomFeatureEntry(WHITE_FLAURY_CHECKED, .03f),
                            new RandomFeatureEntry(GRAY_FLAURY_CHECKED, .03f),
                            new RandomFeatureEntry(LIGHT_BLUE_FLAURY_CHECKED, .073f),
                            new RandomFeatureEntry(LIGHT_GRAY_FLAURY_CHECKED, .03f),
                            new RandomFeatureEntry(LIME_FLAURY_CHECKED, .073f),
                            new RandomFeatureEntry(PINK_FLAURY_CHECKED, .073f),
                            new RandomFeatureEntry(PURPLE_FLAURY_CHECKED, .073f),
                            new RandomFeatureEntry(ORANGE_FLAURY_CHECKED, .073f),
                            new RandomFeatureEntry(MAGENTA_FLAURY_CHECKED, .073f)
                            ),
                            GREEN_FLAURY_CHECKED
                    ));

    private static RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>> FlauryConfiguredFeatureGen(String name, Block leaf){
        return ConfiguredFeatures.register(name, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(RegBlocks.FLAURY_LOG),
                new StraightTrunkPlacer(15, 12, 7),
                BlockStateProvider.of(leaf),
                new ElipseFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 4,4,4),
                new TwoLayersFeatureSize(1, 0, 2)).build());
    }



    public static void registerConfiguredFeatures(){
    }
}
