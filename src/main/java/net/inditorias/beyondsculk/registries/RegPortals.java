package net.inditorias.beyondsculk.registries;

import net.inditorias.beyondsculk.BeyondSculk;
import net.kyrptonaught.customportalapi.CustomPortalBlock;
import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;
import net.kyrptonaught.customportalapi.portal.PortalIgnitionSource;
import net.minecraft.util.Identifier;


public class RegPortals {

    public static final PortalIgnitionSource RESONANT_IGNITER = PortalIgnitionSource.CustomSource(new Identifier(BeyondSculk.MOD_ID, "resonant_frame_igniter"));

    private static void registerCustomPortalHelpers(){

    }


    public static void registerCustomPortals(){
        registerCustomPortalHelpers();

        CustomPortalBuilder.beginPortal()
                .frameBlock(RegBlocks.RESONANT_REINFORCED_DEEPSLATE)
                .customPortalBlock((CustomPortalBlock) RegBlocks.RESONANT_PORTAL)
                .destDimID(RegDimensions.OTHERWORLD_DIM_KEY.getValue())
                .returnDim(new Identifier("overworld"), false)
                .customIgnitionSource(RESONANT_IGNITER)
                .tintColor(239, 147, 0)
                .registerPortal();

    }
}
