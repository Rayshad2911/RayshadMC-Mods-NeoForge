package net.rayshad.rayshadmc.item;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;
import net.rayshad.rayshadmc.util.ModTags;

public class ModToolTiers {
    public static final Tier KROIPNITE = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_KROIPNITE_TOOL,
            1300, 8.5f, 3.5f, 15, () -> Ingredient.of(ModItems.KROIPNITE));
}
