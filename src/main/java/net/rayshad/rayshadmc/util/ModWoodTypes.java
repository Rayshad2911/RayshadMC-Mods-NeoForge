package net.rayshad.rayshadmc.util;

import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.rayshad.rayshadmc.RayshadMC;

public class ModWoodTypes {
    public static final WoodType MAPLE = WoodType.register(new WoodType(RayshadMC.MOD_ID + ":maple", BlockSetType.OAK));
    public static final WoodType CHORUS = WoodType.register(new WoodType(RayshadMC.MOD_ID + ":chorus", BlockSetType.WARPED));
    public static final WoodType PALE_CHORUS = WoodType.register(new WoodType(RayshadMC.MOD_ID + ":pale_chorus", BlockSetType.WARPED));
}
