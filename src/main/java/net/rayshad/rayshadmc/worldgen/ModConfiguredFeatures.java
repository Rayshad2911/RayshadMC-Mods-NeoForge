package net.rayshad.rayshadmc.worldgen;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.rayshad.rayshadmc.RayshadMC;
import net.rayshad.rayshadmc.block.ModBlocks;

import java.util.List;

public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_KROIPNITE_ORE_KEY = registerKey("overworld_kroipnite_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_OPYX_SOIL_KEY = registerKey("nether_opyx_soil");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest soilReplaceables = new BlockMatchTest(Blocks.SOUL_SOIL);

        List<OreConfiguration.TargetBlockState> overworldKroipniteOres = List.of(
                OreConfiguration.target(stoneReplaceables, ModBlocks.KROIPNITE_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.DEEPSLATE_KROIPNITE_ORE.get().defaultBlockState()));

        register(context, OVERWORLD_KROIPNITE_ORE_KEY, Feature.ORE, new OreConfiguration(overworldKroipniteOres, 4));
        register(context, NETHER_OPYX_SOIL_KEY, Feature.ORE, new OreConfiguration(soilReplaceables,
                ModBlocks.OPYX_SOIL.get().defaultBlockState(), 7));
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(RayshadMC.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
