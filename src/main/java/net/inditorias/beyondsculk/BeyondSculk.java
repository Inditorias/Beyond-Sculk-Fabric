package net.inditorias.beyondsculk;

import net.fabricmc.api.ModInitializer;
import net.inditorias.beyondsculk.registries.*;
import net.inditorias.beyondsculk.world.feature.ModConfiguredFeatures;
import net.inditorias.beyondsculk.world.gen.ModWorldGen;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BeyondSculk implements ModInitializer {
	public static final String MOD_ID = "beyondsculk";
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModConfiguredFeatures.registerConfiguredFeatures();
		RegItems.registerModItems();
		RegBlocks.registerModBlocks();
		RegDimensions.register();
		RegTags.register();
		RegBlockEntities.registerAllBlockEntities();
		RegPortals.registerCustomPortals();
		RegRegistries.registerRegistries();
		RegPotions.registerPotions();
		ModWorldGen.generateModWorldGen();
	}
}
