package net.rayshad.rayshadmc.worldgen;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.rayshad.rayshadmc.RayshadMC;
import net.rayshad.rayshadmc.block.ModBlocks;

import java.util.List;

public class ModPlacedFeatures {
    public static final ResourceKey<PlacedFeature> OVERWORLD_KROIPNITE_ORE_PLACED_KEY = registerKey("kroipnite_ore_placed");
    public static final ResourceKey<PlacedFeature> NETHER_OPYX_SOIL_PLACED_KEY = registerKey("opyx_soil_placed");

    public static final ResourceKey<PlacedFeature> MAPLE_PLACED_KEY = registerKey("maple_placed");
    public static final ResourceKey<PlacedFeature> CHORUS_PLACED_KEY = registerKey("chorus_placed");

    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        var configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, OVERWORLD_KROIPNITE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_KROIPNITE_ORE_KEY),
                ModOrePlacement.commonOrePlacement(3, HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(0))));
        register(context, NETHER_OPYX_SOIL_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.NETHER_OPYX_SOIL_KEY),
                ModOrePlacement.commonOrePlacement(4, HeightRangePlacement.uniform(VerticalAnchor.absolute(30), VerticalAnchor.absolute(80))));

        register(context, MAPLE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.MAPLE_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(4, 0.1f, 3),
                        ModBlocks.MAPLE_SAPLING.get()));
        register(context, CHORUS_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CHORUS_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.1f, 1),
                        ModBlocks.CHORUS_TREE_SEED.get()));
    }

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(RayshadMC.MOD_ID, name));
    }

    private static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
