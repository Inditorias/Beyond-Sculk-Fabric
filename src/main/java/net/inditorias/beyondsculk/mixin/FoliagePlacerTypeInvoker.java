package net.inditorias.beyondsculk.mixin;

import com.mojang.serialization.Codec;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.foliage.FoliagePlacerType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(FoliagePlacerType.class)
public class FoliagePlacerTypeInvoker {
    @Invoker("<init>")
    public static <P extends FoliagePlacer> FoliagePlacerType<P> invokeCtor(Codec<P> codec){
        throw new IllegalStateException();
    }
}
