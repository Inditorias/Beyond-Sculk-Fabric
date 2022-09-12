package net.inditorias.beyondsculk.world.gen.foliage;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.inditorias.beyondsculk.world.feature.ModConfiguredFeatures;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.foliage.FoliagePlacerType;

import java.util.function.BiConsumer;

public class ElipseFoliagePlacer extends FoliagePlacer {

    public static final Codec<ElipseFoliagePlacer> CODEC = RecordCodecBuilder.create(
            instance -> fillFoliagePlacerFields(instance).apply(instance, ElipseFoliagePlacer::new)
    );
    protected final int height;
    protected final int widthX;
    protected final int widthZ;

    public ElipseFoliagePlacer(IntProvider radius, IntProvider offset){
        this(radius, offset, 3, 3, 3);
    }
    public ElipseFoliagePlacer(IntProvider radius, IntProvider offset, int height, int widthX, int widthZ) {
        super(radius, offset);
        this.height = height;
        this.widthX = widthX;
        this.widthZ = widthZ;
    }

    @Override
    protected FoliagePlacerType<?> getType() {
        return ModConfiguredFeatures.ELIPSE_FOLIAGE_PLACER;
    }

    @Override
    protected void generate(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, Random random, TreeFeatureConfig config, int trunkHeight, TreeNode treeNode, int foliageHeight, int radius, int offset) {
        for(int j = height; j > -height; j--){
            for(int i = widthX; i >= -widthX; i--){
                //check if... ?
                for(int k = widthZ; k >= -widthZ; k--){
                    //i j k -> x y z
                    if(!isInvalidForLeaves(random, i, j, k, widthX, treeNode.isGiantTrunk())){
                        BlockPos.Mutable mutable = new BlockPos.Mutable();
                        mutable.set(treeNode.getCenter(), i, j, k);
                        FoliagePlacer.placeFoliageBlock(world, replacer, random, config, mutable);
                    }
                }
            }
        }
    }

    @Override
    public int getRandomHeight(Random random, int trunkHeight, TreeFeatureConfig config) {
        return this.height;
    }

    @Override
    protected boolean isInvalidForLeaves(Random random, int dx, int y, int dz, int radius, boolean giantTrunk) {
        return dx == this.widthX && dz == this.widthZ && (random.nextInt(2) == 0 || y == 0);
    }
}
