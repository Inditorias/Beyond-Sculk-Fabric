package net.inditorias.beyondsculk.blocks;

import net.inditorias.beyondsculk.blocks.entity.ActivatedReinforcedDeepslateBlockEntity;
import net.inditorias.beyondsculk.blocks.entity.ResonantReinforcedDeepslateBlockEntity;
import net.inditorias.beyondsculk.registries.RegBlockEntities;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.event.listener.GameEventListener;
import org.jetbrains.annotations.Nullable;

public class ResonantReinforcedDeepslate extends BlockWithEntity implements BlockEntityProvider {
    public ResonantReinforcedDeepslate(Settings settings) {
        super(settings);
    }



//BLOCK ENTITY


    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new ResonantReinforcedDeepslateBlockEntity(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return checkType(type, RegBlockEntities.RESONANT_REINFORCED_DEEPSLATE_BLOCK_ENTITY, ResonantReinforcedDeepslateBlockEntity::tick);
    }
}
