package net.inditorias.beyondsculk.registries;

import net.inditorias.beyondsculk.BeyondSculk;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;

public class RegDimensions {
    public static final RegistryKey<World> OTHERWORLD_DIM_KEY = RegistryKey.of(Registry.WORLD_KEY, new Identifier(BeyondSculk.MOD_ID, "otherworld"));
    public static final RegistryKey<DimensionType> OTHERWORLD_TYPE_KEY = RegistryKey.of(Registry.DIMENSION_TYPE_KEY, OTHERWORLD_DIM_KEY.getValue());

    public static void register(){
        BeyondSculk.LOGGER.debug("Registering Dimensions for " + BeyondSculk.MOD_ID);
    }
}
