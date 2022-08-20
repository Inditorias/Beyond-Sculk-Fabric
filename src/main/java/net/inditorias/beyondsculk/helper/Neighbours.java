package net.inditorias.beyondsculk.helper;

import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class Neighbours {

    public static List<BlockPos> getDirectlyAdjacentBlockPos(BlockPos pos){
        ArrayList<BlockPos> adjacent = new ArrayList<>();
        for(Direction d : Direction.values()){
            adjacent.add(pos.offset(d, 1));
        }
        return adjacent;
    }

    public static List<BlockPos> getRemotelyAdjacentBlockPos(BlockPos pos){
        List<BlockPos> adjacent = getDirectlyAdjacentBlockPos(pos);

        adjacent.add(pos.down().north());
        adjacent.add(pos.down().south());
        adjacent.add(pos.down().east());
        adjacent.add(pos.down().west());

        adjacent.add(pos.up().north());
        adjacent.add(pos.up().south());
        adjacent.add(pos.up().east());
        adjacent.add(pos.up().west());

        return adjacent;
    }

    public static List<BlockPos> getDirectlyAdjacentBlockPosMatching(World world, BlockPos pos, Block block){
        List<BlockPos> matches = new ArrayList<>();
        for(BlockPos p : getDirectlyAdjacentBlockPos(pos)){
            if(world.getBlockState(p).isOf(block)){
                matches.add(p);
            }
        }
        return matches;
    }

    public static List<BlockPos> getRemotelyAdjacentBlockPosMatching(World world, BlockPos pos, Block block){
        List<BlockPos> matches = new ArrayList<>();
        for(BlockPos p : getRemotelyAdjacentBlockPos(pos)){
            if(world.getBlockState(p).isOf(block)){
                matches.add(p);
            }
        }
        return matches;
    }

    public static BlockPos getFirstRemotelyAdjacentBlockPosMatching(World world, BlockPos pos, Block block){
        for(BlockPos p : getRemotelyAdjacentBlockPos(pos)){
            if(world.getBlockState(p).isOf(block)){
                return p;
            }
        }
        return null;
    }
}
