package net.inditorias.beyondsculk.mixin;

import net.inditorias.beyondsculk.blocks.SoulCauldron;
import net.inditorias.beyondsculk.registries.RegBlocks;
import net.inditorias.beyondsculk.registries.RegItems;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Item.class)
public class GlassBottleMixin {
    @Inject(at = @At("TAIL"), method = "useOnBlock", cancellable = true)
    private void GlassBottleUseOnBLock(ItemUsageContext context, CallbackInfoReturnable<ActionResult> cir) {
        if ((Object) this instanceof GlassBottleItem) {
            if (context.getWorld().getBlockState(context.getBlockPos()).isOf(RegBlocks.SOUL_CAULDRON)) {
                World world = context.getWorld();
                BlockPos blockPos = context.getBlockPos();
                PlayerEntity playerEntity = context.getPlayer();
                if (playerEntity == null) {
                    cir.setReturnValue(ActionResult.FAIL);
                    return;
                }
                ItemStack itemStack = context.getStack();
                BlockState blockState = world.getBlockState(blockPos);
                world.playSound(null, blockPos, SoundEvents.PARTICLE_SOUL_ESCAPE, SoundCategory.PLAYERS, 1.0f, 1.0f);
                itemStack.decrement(1);
                if(!playerEntity.getInventory().insertStack(RegItems.SOUL_WATER_BOTTLE.getDefaultStack())){
                    playerEntity.dropItem(RegItems.SOUL_WATER_BOTTLE.getDefaultStack(),true);
                }
                if (!world.isClient) {
                    ServerWorld serverWorld = (ServerWorld) world;
                    for (int i = 0; i < 5; ++i) {
                        serverWorld.spawnParticles(ParticleTypes.SPLASH, (double) blockPos.getX() + world.random.nextDouble(), blockPos.getY() + 1, (double) blockPos.getZ() + world.random.nextDouble(), 1, 0.0, 0.0, 0.0, 1.0);
                    }
                }
                world.playSound(null, blockPos, SoundEvents.ITEM_BOTTLE_FILL, SoundCategory.BLOCKS, 0.4f, 1.0f);
                SoulCauldron.decrementFluidLevel(blockState, world, blockPos);
                cir.setReturnValue(ActionResult.success(world.isClient));
            }
        }
    }
}

