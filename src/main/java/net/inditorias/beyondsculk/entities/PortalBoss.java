package net.inditorias.beyondsculk.entities;

import net.inditorias.beyondsculk.registries.RegPortals;
import net.kyrptonaught.customportalapi.portal.PortalPlacer;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.WardenEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.World;

public class PortalBoss extends WardenEntity {

    private static final TrackedData<Integer> PORTAL_SPAWN_POS_X = DataTracker.registerData(PortalBoss.class, TrackedDataHandlerRegistry.INTEGER);
    private static final TrackedData<Integer> PORTAL_SPAWN_POS_Y = DataTracker.registerData(PortalBoss.class, TrackedDataHandlerRegistry.INTEGER);
    private static final TrackedData<Integer> PORTAL_SPAWN_POS_Z = DataTracker.registerData(PortalBoss.class, TrackedDataHandlerRegistry.INTEGER);
    private static final TrackedData<Boolean> IS_DEAD = DataTracker.registerData(PortalBoss.class, TrackedDataHandlerRegistry.BOOLEAN);

    public PortalBoss(EntityType<? extends HostileEntity> entityType, World world, BlockPos spawnLoc) {
        super(entityType, world);
        this.dataTracker.set(PORTAL_SPAWN_POS_X, spawnLoc.getX());
        this.dataTracker.set(PORTAL_SPAWN_POS_Y, spawnLoc.getY());
        this.dataTracker.set(PORTAL_SPAWN_POS_Z, spawnLoc.getZ());
        this.dataTracker.set(IS_DEAD, false);
    }

    @Override
    public boolean isDead() {
        if(this.dataTracker.get(IS_DEAD)){
            return super.isDead();
        }
        if(this.getHealth() < 0.0f){
            if(!PortalPlacer.attemptPortalLight(this.world,
                    new BlockPos(
                            this.dataTracker.get(PORTAL_SPAWN_POS_X),
                            this.dataTracker.get(PORTAL_SPAWN_POS_Y),
                            this.dataTracker.get(PORTAL_SPAWN_POS_Z)
                    ),RegPortals.RESONANT_IGNITER)){
                this.setHealth(1);
            }else{
                this.dataTracker.set(IS_DEAD, true);
            }
        }
        return super.isDead();
    }
}
