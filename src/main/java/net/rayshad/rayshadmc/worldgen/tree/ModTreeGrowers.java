package net.rayshad.rayshadmc.worldgen.tree;

import net.minecraft.world.level.block.grower.TreeGrower;
import net.rayshad.rayshadmc.RayshadMC;
import net.rayshad.rayshadmc.worldgen.ModConfiguredFeatures;

import java.util.Optional;

public class ModTreeGrowers {
    public static final TreeGrower MAPLE = new TreeGrower(RayshadMC.MOD_ID + ":maple",
            Optional.empty(), Optional.of(ModConfiguredFeatures.MAPLE_KEY), Optional.empty());
    public static final TreeGrower CHORUS = new TreeGrower(RayshadMC.MOD_ID + ":chorus",
            Optional.empty(), Optional.of(ModConfiguredFeatures.CHORUS_KEY), Optional.empty());
    public static final TreeGrower PALE_CHORUS = new TreeGrower(RayshadMC.MOD_ID + ":pale_chorus",
            Optional.empty(), Optional.of(ModConfiguredFeatures.PALE_CHORUS_KEY), Optional.empty());
}
