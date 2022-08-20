package net.inditorias.beyondsculk.registries;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.inditorias.beyondsculk.BeyondSculk;
import net.inditorias.beyondsculk.blocks.entity.ActivatedReinforcedDeepslateBlockEntity;
import net.inditorias.beyondsculk.blocks.entity.ResonantReinforcedDeepslateBlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class RegBlockEntities {
    public static BlockEntityType<ActivatedReinforcedDeepslateBlockEntity> ACTIVATED_REINFORCED_DEEPSLATE_BLOCK_ENTITY;
    public static BlockEntityType<ResonantReinforcedDeepslateBlockEntity> RESONANT_REINFORCED_DEEPSLATE_BLOCK_ENTITY;

    public static void registerAllBlockEntities(){
        ACTIVATED_REINFORCED_DEEPSLATE_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE,
                new Identifier(BeyondSculk.MOD_ID, "activated_reinforced_deepslate_block_entity"),
                FabricBlockEntityTypeBuilder.create(ActivatedReinforcedDeepslateBlockEntity::new,
                        RegBlocks.ACTIVATED_REINFORCED_DEEPSLATE).build(null));
        RESONANT_REINFORCED_DEEPSLATE_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE,
                new Identifier(BeyondSculk.MOD_ID, "resonant_reinforced_deepslate_block_entity"),
                FabricBlockEntityTypeBuilder.create(ResonantReinforcedDeepslateBlockEntity::new,
                        RegBlocks.RESONANT_REINFORCED_DEEPSLATE).build(null));
    }
}
