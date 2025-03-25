package net.rayshad.rayshadmc.worldgen;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FancyFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.ForkingTrunkPlacer;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.rayshad.rayshadmc.RayshadMC;
import net.rayshad.rayshadmc.block.ModBlocks;

import java.util.List;

public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_KROIPNITE_ORE_KEY = registerKey("overworld_kroipnite_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_OPYX_SOIL_KEY = registerKey("nether_opyx_soil");

    public static final ResourceKey<ConfiguredFeature<?, ?>> MAPLE_KEY = registerKey("maple");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CHORUS_KEY = registerKey("chorus");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PALE_CHORUS_KEY = registerKey("pale_chorus");

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

        register(context, MAPLE_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.MAPLE_LOG.get()),
                new ForkingTrunkPlacer(2, 2, 3),

                BlockStateProvider.simple(ModBlocks.MAPLE_LEAVES.get()),
                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(2), 2),

                new TwoLayersFeatureSize(1, 0, 2)).build());
        register(context, CHORUS_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.CHORUS_STEM.get()),
                new ForkingTrunkPlacer(4, 2, 4),

                BlockStateProvider.simple(ModBlocks.CHORUS_LEAVES.get()),
                new FancyFoliagePlacer(ConstantInt.of(3), ConstantInt.of(2), 2),

                new TwoLayersFeatureSize(2, 1, 2)).dirt(BlockStateProvider.simple(Blocks.END_STONE)).build());
        register(context, PALE_CHORUS_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.PALE_CHORUS_STEM.get()),
                new ForkingTrunkPlacer(4, 2, 4),

                BlockStateProvider.simple(ModBlocks.CHORUS_LEAVES.get()),
                new FancyFoliagePlacer(ConstantInt.of(3), ConstantInt.of(2), 2),

                new TwoLayersFeatureSize(2, 1, 2)).dirt(BlockStateProvider.simple(Blocks.END_STONE)).build());
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(RayshadMC.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
