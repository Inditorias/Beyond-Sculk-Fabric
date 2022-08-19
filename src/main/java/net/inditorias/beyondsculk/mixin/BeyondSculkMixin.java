package net.inditorias.beyondsculk.mixin;

import net.inditorias.beyondsculk.BeyondSculk;
import net.minecraft.client.gui.screen.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class BeyondSculkMixin {
	@Inject(at = @At("HEAD"), method = "init()V")
	private void init(CallbackInfo info) {
		BeyondSculk.LOGGER.info(BeyondSculk.MOD_ID + ": Mixin Init Called");
	}
}
