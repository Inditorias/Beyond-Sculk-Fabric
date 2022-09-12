package net.inditorias.beyondsculk.world.feature;

import net.inditorias.beyondsculk.BeyondSculk;
import net.inditorias.beyondsculk.mixin.FoliagePlacerTypeInvoker;
import net.inditorias.beyondsculk.registries.RegBlocks;
import net.inditorias.beyondsculk.world.gen.foliage.ElipseFoliagePlacer;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
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
    public static final RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>> RED_FLAURY_TREE =
            FlauryConfiguredFeatureGen("red_flaury_tree", RegBlocks.RED_FLAURY_LEAVES);
    public static final RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>> CHARTRUCE_FLAURY_TREE =
            FlauryConfiguredFeatureGen("chartruce_flaury_tree", RegBlocks.CHARTRUCE_FLAURY_LEAVES);
    public static final RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>> CYAN_FLAURY_TREE =
            FlauryConfiguredFeatureGen("cyan_flaury_tree", RegBlocks.CYAN_FLAURY_LEAVES);
    public static final RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>> ORANGE_FLAURY_TREE =
            FlauryConfiguredFeatureGen("orange_flaury_tree", RegBlocks.ORANGE_FLAURY_LEAVES);
    public static final RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>> MAGENTA_FLAURY_TREE =
            FlauryConfiguredFeatureGen("magenta_flaury_tree", RegBlocks.MAGENTA_FLAURY_LEAVES);

    public static final RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>>[] FLAURY_TREES =
            new RegistryEntry[]{BLUE_FLAURY_TREE, RED_FLAURY_TREE, CHARTRUCE_FLAURY_TREE, CYAN_FLAURY_TREE, ORANGE_FLAURY_TREE, MAGENTA_FLAURY_TREE};


    public static final RegistryEntry<PlacedFeature> BLUE_FLAURY_CHECKED = PlacedFeatures.register("blue_flaury_checked",
            BLUE_FLAURY_TREE, PlacedFeatures.wouldSurvive(RegBlocks.FLAURY_SAPLING));
    public static final RegistryEntry<PlacedFeature> RED_FLAURY_CHECKED = PlacedFeatures.register("red_flaury_checked",
            RED_FLAURY_TREE, PlacedFeatures.wouldSurvive(RegBlocks.FLAURY_SAPLING));
    public static final RegistryEntry<PlacedFeature> CHARTRUCE_FLAURY_CHECKED = PlacedFeatures.register("chartruce_flaury_checked",
            CHARTRUCE_FLAURY_TREE, PlacedFeatures.wouldSurvive(RegBlocks.FLAURY_SAPLING));
    public static final RegistryEntry<PlacedFeature> CYAN_FLAURY_CHECKED = PlacedFeatures.register("cyan_flaury_checked",
            CYAN_FLAURY_TREE, PlacedFeatures.wouldSurvive(RegBlocks.FLAURY_SAPLING));
    public static final RegistryEntry<PlacedFeature> ORANGE_FLAURY_CHECKED = PlacedFeatures.register("orange_flaury_checked",
            ORANGE_FLAURY_TREE, PlacedFeatures.wouldSurvive(RegBlocks.FLAURY_SAPLING));
    public static final RegistryEntry<PlacedFeature> MAGENTA_FLAURY_CHECKED = PlacedFeatures.register("magenta_flaury_checked",
            MAGENTA_FLAURY_TREE, PlacedFeatures.wouldSurvive(RegBlocks.FLAURY_SAPLING));

    public static final RegistryEntry<ConfiguredFeature<RandomFeatureConfig, ?>> FLAURY_SPAWN =
            ConfiguredFeatures.register("flaury_spawn", Feature.RANDOM_SELECTOR,
                    new RandomFeatureConfig(List.of(
                        new RandomFeatureEntry(BLUE_FLAURY_CHECKED, .1666f),
                            new RandomFeatureEntry(RED_FLAURY_CHECKED, .1666f),
                            new RandomFeatureEntry(CYAN_FLAURY_CHECKED, .1666f),
                            new RandomFeatureEntry(ORANGE_FLAURY_CHECKED, .1666f),
                            new RandomFeatureEntry(MAGENTA_FLAURY_CHECKED, .1666f)
                            ),
                            CHARTRUCE_FLAURY_CHECKED
                    ));

    private static RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>> FlauryConfiguredFeatureGen(String name, Block leaf){
        return ConfiguredFeatures.register(name, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(RegBlocks.FLAURY_LOG),
                new StraightTrunkPlacer(15, 12, 7),
                BlockStateProvider.of(leaf),
                new ElipseFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 5, 4, 4),
                new TwoLayersFeatureSize(1, 0, 2)).build());
    }




    public static void registerConfiguredFeatures(){
    }
}
