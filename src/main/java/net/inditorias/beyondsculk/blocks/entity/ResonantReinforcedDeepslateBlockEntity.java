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

public class ResonantReinforcedDeepslateBlockEntity extends BlockEntity {
    public ResonantReinforcedDeepslateBlockEntity(BlockPos pos, BlockState state) {
        super(RegBlockEntities.RESONANT_REINFORCED_DEEPSLATE_BLOCK_ENTITY, pos, state);
    }

    public static void tick(World world, BlockPos pos, BlockState state, ResonantReinforcedDeepslateBlockEntity entity) {
        List<BlockPos> neighbors = Neighbours.getDirectlyAdjacentBlockPosMatching(world, pos, RegBlocks.UNSTABLE_REINFORCED_DEEPSLATE);
        for(BlockPos p : neighbors){
            world.setBlockState(p, RegBlocks.RESONANT_REINFORCED_DEEPSLATE.getDefaultState());
        }
    }
}
