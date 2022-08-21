package net.inditorias.beyondsculk.blocks;

import net.inditorias.beyondsculk.registries.RegBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.WorldAccess;

public class UnstableReinforcedDeepslate extends Block {
    public UnstableReinforcedDeepslate(Settings settings) {
        super(settings);
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        return neighborState.isOf(RegBlocks.RESONANT_REINFORCED_DEEPSLATE) ?
            neighborState : super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }
}
