package net.inditorias.beyondsculk.mixin;

import net.inditorias.beyondsculk.blocks.SoulCauldron;
import net.inditorias.beyondsculk.registries.RegBlocks;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.LeveledCauldronBlock;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AbstractBlock.class)
public class LeveledCauldronMixin_AbstractBlock {

    @Inject(at = @At("HEAD"), method = "randomTick")
    private void randomTickLeveledCauldronRandomTick(BlockState state, ServerWorld world, BlockPos pos, Random random, CallbackInfo ci){
        if((Object) this instanceof LeveledCauldronBlock){
            if(world.getBlockState(pos.down()).isOf(Blocks.SOUL_FIRE)){
                world.playSound(null, pos, SoundEvents.PARTICLE_SOUL_ESCAPE, SoundCategory.BLOCKS, 1f, 1f);
                world.setBlockState(pos, RegBlocks.SOUL_CAULDRON.getDefaultState().with(SoulCauldron.LEVEL, state.get(LeveledCauldronBlock.LEVEL)));
                world.setBlockState(pos.down(), Blocks.FIRE.getDefaultState());
                world.setBlockState(pos.down(2),
                        world.getBlockState(pos.down(2)).isOf(Blocks.SOUL_SAND) ?
                        RegBlocks.SCORCHED_SAND.getDefaultState() : RegBlocks.SCORCHED_SOIL.getDefaultState());
            }
        }
    }

}
