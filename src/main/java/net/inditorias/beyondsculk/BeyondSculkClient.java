package net.inditorias.beyondsculk;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.inditorias.beyondsculk.registries.RegBlocks;
import net.minecraft.client.render.RenderLayer;

public class BeyondSculkClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(RegBlocks.RESONANT_PORTAL, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(RegBlocks.SCULK_PORTAL, RenderLayer.getTranslucent());
    }
}
