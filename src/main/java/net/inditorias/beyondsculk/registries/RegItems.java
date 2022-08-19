package net.inditorias.beyondsculk.registries;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.inditorias.beyondsculk.BeyondSculk;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class RegItems {

    public static final Item SOUL_WATER_BOTTLE = registerItem("soul_water_bottle",
            new Item(new FabricItemSettings().group(ItemGroup.BREWING)));


    private static Item registerItem(String name, Item item){
        return Registry.register(Registry.ITEM, new Identifier(BeyondSculk.MOD_ID, name), item);
    }

    public static void registerModItems(){
        BeyondSculk.LOGGER.debug("Registering Items for " + BeyondSculk.MOD_ID);
    }
}
