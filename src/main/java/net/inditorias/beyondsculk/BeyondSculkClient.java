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

        BlockRenderLayerMap.INSTANCE.putBlock(RegBlocks.GREEN_FLARUY_LEAVES,RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(RegBlocks.BLUE_FLAURY_LEAVES,RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(RegBlocks.RED_FLAURY_LEAVES,RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(RegBlocks.CYAN_FLAURY_LEAVES,RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(RegBlocks.MAGENTA_FLAURY_LEAVES,RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(RegBlocks.ORANGE_FLAURY_LEAVES,RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(RegBlocks.FLAURY_SAPLING,RenderLayer.getCutout());
    }
}
