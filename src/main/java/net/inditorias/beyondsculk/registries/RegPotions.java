package net.inditorias.beyondsculk.registries;

import net.inditorias.beyondsculk.BeyondSculk;
import net.inditorias.beyondsculk.mixin.BrewingRecipeRegistryMixin;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class RegPotions {

    public static Potion DARKNESS_POTION;
    public static Potion LONG_DARKNESS_POTION;

    public static Potion BLINDNESS_POTION;
    public static Potion LONG_BLINDNESS_POTION;

    public static Potion registerPotion(String name, StatusEffectInstance status){
        return Registry.register(Registry.POTION, new Identifier(BeyondSculk.MOD_ID, name),
               new Potion(status));
    }

    public static void registerPotions(){
        DARKNESS_POTION = registerPotion("darkness", new StatusEffectInstance(StatusEffects.DARKNESS, 1800, 0));
        LONG_DARKNESS_POTION = registerPotion("long_darkness", new StatusEffectInstance(StatusEffects.DARKNESS, 4800, 0));
        BLINDNESS_POTION = registerPotion("blindness", new StatusEffectInstance(StatusEffects.BLINDNESS, 900, 0));
        LONG_BLINDNESS_POTION = registerPotion("long_blindness", new StatusEffectInstance(StatusEffects.BLINDNESS, 1800, 0));

        registerPotionRecipes();
    }

    private static void registerPotionRecipes(){
        BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(Potions.AWKWARD, Items.SCULK_SHRIEKER, RegPotions.DARKNESS_POTION);
        BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(RegPotions.DARKNESS_POTION, Items.REDSTONE, RegPotions.LONG_DARKNESS_POTION);
        BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(RegPotions.DARKNESS_POTION, Items.FERMENTED_SPIDER_EYE, RegPotions.BLINDNESS_POTION);
        BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(RegPotions.LONG_DARKNESS_POTION, Items.FERMENTED_SPIDER_EYE, RegPotions.LONG_BLINDNESS_POTION);
        BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(RegPotions.BLINDNESS_POTION, Items.REDSTONE, RegPotions.LONG_BLINDNESS_POTION);
    }

}
