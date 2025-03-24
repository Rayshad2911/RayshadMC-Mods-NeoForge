package net.rayshad.rayshadmc.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Items;

public class ModFoodProperties {
    public static final FoodProperties CORN = new FoodProperties.Builder().nutrition(4).saturationModifier(1f)
            .build();
    public static final FoodProperties MASHED_POTATO = new FoodProperties.Builder().nutrition(5).saturationModifier(4f)
            .usingConvertsTo(Items.BOWL).build();
}
