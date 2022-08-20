package net.inditorias.beyondsculk.blocks.entity;

import net.inditorias.beyondsculk.blocks.ActivatedReinforcedDeepslate;
import net.inditorias.beyondsculk.blocks.AxisBlock;
import net.inditorias.beyondsculk.helper.Neighbours;
import net.inditorias.beyondsculk.helper.PortalSpawner;
import net.inditorias.beyondsculk.registries.RegBlockEntities;
import net.inditorias.beyondsculk.registries.RegBlocks;
import net.inditorias.beyondsculk.registries.RegTags;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;

public class ActivatedReinforcedDeepslateBlockEntity extends BlockEntity {
    public ActivatedReinforcedDeepslateBlockEntity(BlockPos pos, BlockState state) {
        super(RegBlockEntities.ACTIVATED_REINFORCED_DEEPSLATE_BLOCK_ENTITY, pos, state);
    }

    public static void tick(World world, BlockPos pos, BlockState state, ActivatedReinforcedDeepslateBlockEntity entity){
        if(state.get(ActivatedReinforcedDeepslate.SOULS) > 0){
            List<BlockPos> neighbors = Neighbours.getDirectlyAdjacentBlockPosMatching(world, pos, Blocks.REINFORCED_DEEPSLATE);
            for(BlockPos p : neighbors){
                world.setBlockState(p, RegBlocks.ACTIVATED_REINFORCED_DEEPSLATE.getDefaultState().with(ActivatedReinforcedDeepslate.SOULS,
                        Math.max(0, (state.get(ActivatedReinforcedDeepslate.SOULS) / neighbors.size())-1)));
            }
            world.setBlockState(pos, state.with(ActivatedReinforcedDeepslate.SOULS, 0));
        }else{
            List<BlockPos> neighbors = Neighbours.getRemotelyAdjacentBlockPosMatching(world, pos, RegBlocks.SCULK_PORTAL);
            if(neighbors.isEmpty() && !world.getBlockState(pos.up()).isOf(RegBlocks.ACTIVATED_REINFORCED_DEEPSLATE)){
                PortalSpawner spawner = new PortalSpawner(RegTags.Blocks.SCULK_FRAME_BLOCKS, RegTags.Blocks.SCULK_PORTAL_REPLACEABLE, (AxisBlock) RegBlocks.SCULK_PORTAL);
                if(spawner.trySpawnPortal(world, pos.up())){
                    world.playSound(null, pos, SoundEvents.BLOCK_SCULK_SHRIEKER_SHRIEK, SoundCategory.BLOCKS,1f, 1f);
                }
            }
        }
    }
}
