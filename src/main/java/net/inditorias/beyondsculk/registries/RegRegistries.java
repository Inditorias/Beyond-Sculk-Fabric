package net.inditorias.beyondsculk.registries;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;

public class RegRegistries {
    public static void registerRegistries(){
        registerCommands();
        registerEvents();
        registerFuels();
        registerFlammableBlock();
        registerStrippables();
    }

    private static void registerFuels(){

    }

    private static void registerCommands(){

    }

    private static void registerEvents(){

    }

    private static void registerFlammableBlock(){
        FlammableBlockRegistry instance = FlammableBlockRegistry.getDefaultInstance();

        instance.add(RegBlocks.FLAURY_WOOD, 5, 5);
        instance.add(RegBlocks.STRIPPED_FLAURY_WOOD, 5, 5);
        instance.add(RegBlocks.FLAURY_LOG, 5, 5);
        instance.add(RegBlocks.STRIPPED_FLAURY_LOG, 5, 5);
        instance.add(RegBlocks.FLAURY_PLANKS, 5, 20);

        instance.add(RegBlocks.GREEN_FLARUY_LEAVES, 30, 60);
        instance.add(RegBlocks.BLUE_FLAURY_LEAVES, 30, 60);
        instance.add(RegBlocks.ORANGE_FLAURY_LEAVES, 30, 60);
        instance.add(RegBlocks.RED_FLAURY_LEAVES, 30, 60);
        instance.add(RegBlocks.CYAN_FLAURY_LEAVES, 30, 60);
        instance.add(RegBlocks.MAGENTA_FLAURY_LEAVES, 30, 60);
    }

    private static void registerStrippables(){
        StrippableBlockRegistry.register(RegBlocks.FLAURY_LOG, RegBlocks.STRIPPED_FLAURY_LOG);
        StrippableBlockRegistry.register(RegBlocks.FLAURY_WOOD, RegBlocks.STRIPPED_FLAURY_WOOD);
    }

    private static void registerDirts(){

    }
}
