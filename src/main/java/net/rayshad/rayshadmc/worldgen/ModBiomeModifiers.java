package net.rayshad.rayshadmc.worldgen;

import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.rayshad.rayshadmc.RayshadMC;

public class ModBiomeModifiers {
    public static final ResourceKey<BiomeModifier> ADD_KROIPNITE_ORE = registerKey("add_kroipnite_ore");
    public static final ResourceKey<BiomeModifier> ADD_OPYX_SOIL = registerKey("add_opyx_soil");

    public static final ResourceKey<BiomeModifier> ADD_MAPLE_TREE = registerKey("add_tree_maple");
    public static final ResourceKey<BiomeModifier> ADD_CHORUS_TREE = registerKey("add_tree_chorus");

    public static void bootstrap(BootstrapContext<BiomeModifier> context) {
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        context.register(ADD_KROIPNITE_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.OVERWORLD_KROIPNITE_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_OPYX_SOIL, new BiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.SOUL_SAND_VALLEY)),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.NETHER_OPYX_SOIL_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_MAPLE_TREE, new BiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.PLAINS)),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.MAPLE_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_CHORUS_TREE, new BiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.SMALL_END_ISLANDS)),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.CHORUS_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));
    }

    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(RayshadMC.MOD_ID, name));
    }
}
