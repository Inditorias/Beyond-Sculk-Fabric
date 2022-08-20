package net.inditorias.beyondsculk.blocks;

import net.inditorias.beyondsculk.blocks.entity.ActivatedReinforcedDeepslateBlockEntity;
import net.inditorias.beyondsculk.helper.Neighbours;
import net.inditorias.beyondsculk.helper.PortalSpawner;
import net.inditorias.beyondsculk.registries.RegBlockEntities;
import net.inditorias.beyondsculk.registries.RegBlocks;
import net.inditorias.beyondsculk.registries.RegTags;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.mob.WardenEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.*;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

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
        List<BlockPos> neighbors = Neighbours.getRemotelyAdjacentBlockPosMatching(world, pos, RegBlocks.SCULK_PORTAL);
        if(neighbors.isEmpty()){
            return;
        }
        ArrayList<WardenEntity> wardens = new ArrayList<>();
        for(Entity e : world.getEntitiesByType(EntityType.WARDEN, Entity::isLiving)){
            if(e instanceof WardenEntity w && w.getPos().isInRange(new Vec3d(pos.getX(), pos.getY(), pos.getZ()), 64)){
                wardens.add(w);
            }
        }

        double summonWardenOdds = Math.pow(wardens.size()/7.0-0.1, 3)+0.1;

        if(random.nextDouble() > summonWardenOdds){
            if(createWarden(world, pos) != null){
                world.setBlockState(pos, RegBlocks.UNSTABLE_REINFORCED_DEEPSLATE.getDefaultState());
            }
        }else{
            ArrayList<WardenEntity> lowHealth = new ArrayList<>();
            for(WardenEntity w : wardens){
                if(w.getHealth() < 150){
                    lowHealth.add(w);
                }
            }
            WardenEntity w = lowHealth.get(random.nextBetween(0, lowHealth.size() -1));
            w.heal((float)(-Math.pow(w.getHealth(), 0.55)) + 20);
            world.setBlockState(pos, RegBlocks.UNSTABLE_REINFORCED_DEEPSLATE.getDefaultState());
        }
        if(!world.getBlockState(pos).isOf(RegBlocks.UNSTABLE_REINFORCED_DEEPSLATE)){
            return;
        }
        if(completelyConverted(world, pos,
                world.getBlockState(Neighbours.getFirstRemotelyAdjacentBlockPosMatching(world, pos, RegBlocks.SCULK_PORTAL)).get(AxisBlock.AXIS))){
            createPortalBoss(world, pos);
        }
    }

    private WardenEntity createWarden(ServerWorld world, BlockPos pos){
        WardenEntity warden = EntityType.WARDEN.create(world);
        if(warden == null){
            return null;
        }
        Random r = Random.createLocal();
        List<BlockPos> spawnLocs = Neighbours.getRemotelyAdjacentBlockPosMatching(world, pos, RegBlocks.SCULK_PORTAL);
        BlockPos spawnLoc = getSpawnLoc(spawnLocs.get((int)(spawnLocs.size() * r.nextDouble())), pos, r);
        if(!world.getBlockState(spawnLoc).isOf(RegBlocks.SCULK_PORTAL)){
            spawnLoc = spawnLocs.get((int)(spawnLocs.size() * r.nextDouble()));
        }
        warden.setPos(spawnLoc.getX(), spawnLoc.getY(), spawnLoc.getZ());

        warden.setPersistent();
        warden.initialize(world, world.getLocalDifficulty(pos), SpawnReason.TRIGGERED, null, null);
        warden.increaseAngerAt(world.getClosestPlayer(warden, 128), 150, true);
        warden.setHealth(25f);
        world.spawnEntity(warden);
        return warden;
    }

    private static boolean completelyConverted(World world, BlockPos startPos, Direction.Axis axis){
        BlockPos pos = new BlockPos(startPos);
        Direction leftDir, rightDir;
        if(axis == Direction.Axis.X){
            leftDir = Direction.EAST;
            rightDir = Direction.WEST;
        }else{
            leftDir = Direction.NORTH;
            rightDir = Direction.SOUTH;
        }
        //left down left, then go in a circle tracking blocks.
        while(world.getBlockState(pos.offset(leftDir)).isOf(RegBlocks.UNSTABLE_REINFORCED_DEEPSLATE)){
            pos = pos.offset(leftDir);
        }
        if(world.getBlockState(pos.offset(leftDir)).isOf(RegBlocks.ACTIVATED_REINFORCED_DEEPSLATE)){
            return false;
        }
        while(world.getBlockState(pos.down()).isOf(RegBlocks.UNSTABLE_REINFORCED_DEEPSLATE)){
            pos = pos.down();
        }
        if(world.getBlockState(pos.down()).isOf(RegBlocks.ACTIVATED_REINFORCED_DEEPSLATE)){
            return false;
        }
        while(world.getBlockState(pos.offset(leftDir)).isOf(RegBlocks.UNSTABLE_REINFORCED_DEEPSLATE)){
            pos = pos.offset(leftDir);
        }
        if(world.getBlockState(pos.offset(leftDir)).isOf(RegBlocks.ACTIVATED_REINFORCED_DEEPSLATE)){
            return false;
        }

        //right up left down
        BlockPos bottomLeft = new BlockPos(pos);
        //Make sure that the 4 corners are distinct
        BlockPos lastCorner = new BlockPos(pos);
        while(world.getBlockState(pos.offset(rightDir)).isOf(RegBlocks.UNSTABLE_REINFORCED_DEEPSLATE)){
            pos = pos.offset(rightDir);
        }
        if(pos.equals(lastCorner)){
            return false;
        }
        lastCorner = new BlockPos(pos);
        while(world.getBlockState(pos.up()).isOf(RegBlocks.UNSTABLE_REINFORCED_DEEPSLATE)){
            pos = pos.up();
        }
        if(pos.equals(lastCorner)){
            return false;
        }
        lastCorner = new BlockPos(pos);
        while(world.getBlockState(pos.offset(leftDir)).isOf(RegBlocks.UNSTABLE_REINFORCED_DEEPSLATE)){
            pos = pos.offset(leftDir);
        }
        if(pos.equals(lastCorner)){
            return false;
        }
        lastCorner = new BlockPos(pos);
        while(world.getBlockState(pos.down()).isOf(RegBlocks.UNSTABLE_REINFORCED_DEEPSLATE)){
            pos = pos.down();
        }
        if(pos.equals(lastCorner)){
            return false;
        }
        lastCorner = new BlockPos(pos);
        return pos.equals(bottomLeft);
    }

    private  static BlockPos getSpawnLoc(BlockPos portal, BlockPos frame, Random r){
        Vec3i diff = new Vec3i(portal.getX() - frame.getX(), portal.getY() - frame.getY(), portal.getZ() - frame.getZ());
        diff = diff.multiply((int)(r.nextDouble()*3));
        return frame.add(diff);
    }

    private void createPortalBoss(ServerWorld world, BlockPos pos){
        world.setBlockState(pos, RegBlocks.RESONANT_REINFORCED_DEEPSLATE.getDefaultState());
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
