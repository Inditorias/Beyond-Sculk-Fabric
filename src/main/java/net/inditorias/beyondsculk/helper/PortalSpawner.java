package net.inditorias.beyondsculk.helper;

import net.inditorias.beyondsculk.blocks.AxisBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.tag.TagKey;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class PortalSpawner {

    private TagKey<Block> frameBlocks;
    private TagKey<Block> replaceable;
    private AxisBlock portalBlock;

    public PortalSpawner(TagKey<Block> frameBlocks, TagKey<Block> replaceable, AxisBlock block){
        this.frameBlocks = frameBlocks;
        this.replaceable = replaceable;
        this.portalBlock = block;
    }


    public boolean trySpawnPortal(World world, BlockPos pos){
        PortalSpawner.Size s = this.isPortal(world, pos);
        if(s != null){
            s.placePortalBlocks();
            return true;
        }else {
            return false;
        }
    }

    @Nullable
    public PortalSpawner.Size isPortal(World world, BlockPos pos){
        PortalSpawner.Size s = new Size(world, pos, Direction.Axis.X);
        if(s.isValid() && s.portalBlockCount == 0){
            return s;
        }else{
            s = new Size(world, pos, Direction.Axis.Z);
            return s.isValid() && s.portalBlockCount == 0 ? s : null;
        }
    }

    public class Size{
        private final World world;
        private final Direction.Axis axis;
        private final Direction rightDir;
        private final Direction leftDir;
        private int portalBlockCount;
        @Nullable private BlockPos bottomLeft;
        private int height;
        private int width;
        @Nullable
        public BlockPos getBottomLeft(){
            return bottomLeft;
        }
        public Direction.Axis getAxis(){
            return axis;
        }
        public Size(World world, BlockPos pos, Direction.Axis axis){
            this.world = world;
            this.axis = axis;
            if(axis == Direction.Axis.X){
                this.leftDir = Direction.EAST;
                this.rightDir = Direction.WEST;
            }else{
                this.leftDir = Direction.NORTH;
                this.rightDir = Direction.SOUTH;
            }

            for(BlockPos blockPos = pos;
                pos.getY() > blockPos.getY() - 21 && pos.getY() > -64 && this.canConnect(world.getBlockState(pos.down()));
                pos = pos.down())
            {}

            int i = this.getDistanceUntilEdge(pos, this.leftDir) - 1;
            if(i >= 0){
                this.bottomLeft = pos.offset(this.leftDir, i);
                this.width = this.getDistanceUntilEdge(pos, this.rightDir);
                if(this.width < 2 || this.width > 21){
                    this.bottomLeft = null;
                    this.width = 0;
                }
            }

            if(this.bottomLeft != null){
                this.height = this.calculatePortalHeight();
            }
        }

        protected int getDistanceUntilEdge(BlockPos pos, Direction dir) {
            int i;
            for (i = 0; i < 22; ++i) {
                BlockPos blockPos = pos.offset(dir, i);
                if (!this.canConnect(this.world.getBlockState(blockPos)) || !this.world.getBlockState(blockPos.down()).isIn(frameBlocks)) {
                    break;
                }

            }

            BlockPos framePos = pos.offset(dir, i);
            return this.world.getBlockState(framePos).isIn(frameBlocks) ? i : 0;
        }

        public int getHeight(){return height;}
        public int getWidth(){return width;}

        protected int calculatePortalHeight(){
            label56:
            for(this.height = 0; this.height < 21; ++this.height){
                for(int i = 0; i < this.width; ++i){
                    BlockPos blockPos = this.bottomLeft.offset(this.rightDir, i).up(this.height);
                    BlockState state = this.world.getBlockState(blockPos);
                    if(!this.canConnect(state)){
                        break label56;
                    }

                    if(state.isOf(portalBlock)){
                        ++this.portalBlockCount;
                    }

                    if(i == 0){
                        BlockPos framePos = blockPos.offset(this.leftDir);
                        if(!this.world.getBlockState(framePos).isIn(frameBlocks)){
                            break label56;
                        }
                    }else if(i == this.width - 1){
                        BlockPos framePos = blockPos.offset(this.rightDir);
                        if(!this.world.getBlockState(framePos).isIn(frameBlocks)){
                            break label56;
                        }
                    }
                }
            }
            for(int j = 0; j < this.width; j++){
                BlockPos framePos = this.bottomLeft.offset(this.rightDir, j).up(this.height);
                if(!this.world.getBlockState(framePos).isIn(frameBlocks)){
                    this.height = 0;
                    break;
                }
            }
            if(this.height <= 21 && this.height >= 3){
                return this.height;
            }else{
                this.bottomLeft = null;
                this.height = this.width = 0;
                return 0;
            }
        }

        protected boolean canConnect(BlockState pos){
            return pos.isIn(replaceable) || pos.isAir();
        }

        public boolean isValid(){
            return this.bottomLeft != null && this.width >= 2 && this.width <= 21 && this.height >= 3 && this.height <= 21;
        }

        public void placePortalBlocks(){
            for(int i = 0; i < this.width; ++i){
                BlockPos pos = this.bottomLeft.offset(this.rightDir, i);
                for(int j = 0; j < this.height; j++){
                    this.world.setBlockState(pos.up(j), portalBlock.getDefaultState().with(AxisBlock.AXIS, this.axis));
                }
            }
        }

        private boolean isPortalCountValidForSize(){
            return this.portalBlockCount >= this.width * this.height;
        }

        public boolean validatePortal(){
            return this.isValid() && this.isPortalCountValidForSize();
        }
    }
}
