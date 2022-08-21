package net.inditorias.beyondsculk.blocks;

import net.inditorias.beyondsculk.registries.RegDimensions;
import net.kyrptonaught.customportalapi.CustomPortalBlock;
import net.kyrptonaught.customportalapi.interfaces.EntityInCustomPortal;
import net.kyrptonaught.customportalapi.portal.frame.PortalFrameTester;
import net.kyrptonaught.customportalapi.util.CustomTeleporter;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.dimension.AreaHelper;

public class ResonantPortal extends CustomPortalBlock {
    public ResonantPortal(Settings settings) {
        super(settings);
    }

//    @Override
//    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
//      //TODO: Move entity to other dim, maybe try swapping to custom portal api instead.
//    }



    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction,
                                                BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        Direction.Axis axis = direction.getAxis();
        Direction.Axis axis2 = state.get(AXIS);
        boolean bl = axis2 != axis && axis.isHorizontal();
        if (bl || neighborState.isOf(this) || new AreaHelper(world, pos, axis2).wasAlreadyValid()) {
            return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
        }
        return Blocks.AIR.getDefaultState();
    }

}
