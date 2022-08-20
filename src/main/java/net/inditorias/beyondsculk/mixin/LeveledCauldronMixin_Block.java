package net.inditorias.beyondsculk.mixin;

import net.inditorias.beyondsculk.blocks.SoulCauldron;
import net.inditorias.beyondsculk.registries.RegBlocks;
import net.minecraft.block.*;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Block.class)
public class LeveledCauldronMixin_Block {

    @Inject(at = @At("TAIL"), method = "hasRandomTicks", cancellable = true)
    private void randomTickLeveledCauldronHasRandomTick(BlockState state, CallbackInfoReturnable<Boolean> cir){
        if((Object) this instanceof LeveledCauldronBlock){
            cir.setReturnValue(true);
        }
    }

}
