package net.inditorias.beyondsculk.blocks;

import net.inditorias.beyondsculk.blocks.entity.ActivatedReinforcedDeepslateBlockEntity;
import net.inditorias.beyondsculk.registries.RegBlockEntities;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class ActivatedReinforcedDeepslate extends BlockWithEntity implements BlockEntityProvider {

    public static IntProperty SOULS = IntProperty.of("souls", 0, 15);
    public ActivatedReinforcedDeepslate(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(SOULS, 0));
    }

    @Override
    public boolean hasRandomTicks(BlockState state) {
        return true;
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {

    }

    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        super.scheduledTick(state, world, pos, random);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(SOULS);
    }

    //BLOCK ENTITY


    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new ActivatedReinforcedDeepslateBlockEntity(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return checkType(type, RegBlockEntities.ACTIVATED_REINFORCED_DEEPSLATE_BLOCK_ENTITY, ActivatedReinforcedDeepslateBlockEntity::tick);
    }
}
