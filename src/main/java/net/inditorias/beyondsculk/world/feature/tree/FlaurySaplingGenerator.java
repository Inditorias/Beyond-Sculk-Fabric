package net.inditorias.beyondsculk.world.feature.tree;

import net.inditorias.beyondsculk.world.feature.ModConfiguredFeatures;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import org.jetbrains.annotations.Nullable;

public class FlaurySaplingGenerator extends SaplingGenerator {
    @Nullable
    @Override
    protected RegistryEntry<? extends ConfiguredFeature<?, ?>> getTreeFeature(Random random, boolean bees) {
        return  ModConfiguredFeatures.FLAURY_TREES[(int)(random.nextDouble() * ModConfiguredFeatures.FLAURY_TREES.length)];
    }
}
