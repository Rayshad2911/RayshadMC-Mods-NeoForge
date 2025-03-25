package net.rayshad.rayshadmc.datagen;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.rayshad.rayshadmc.RayshadMC;
import net.rayshad.rayshadmc.block.ModBlocks;
import net.rayshad.rayshadmc.block.custom.CornCropBlock;

import java.util.function.Function;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, RayshadMC.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.KROIPNITE_BLOCK);
        blockWithItem(ModBlocks.KROIPNITE_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_KROIPNITE_ORE);
        blockWithItem(ModBlocks.OPYX_SOIL);
        blockWithItem(ModBlocks.OPYX_BLOCK);
        blockWithItem(ModBlocks.OPYX_HARDENED_BLOCK);

        makeCrop(((CropBlock) ModBlocks.CORN_CROP.get()), "corn_crop_stage", "corn_crop_stage");

        logBlock((RotatedPillarBlock) ModBlocks.MAPLE_LOG.get());
        axisBlock((RotatedPillarBlock) ModBlocks.MAPLE_WOOD.get(), blockTexture(ModBlocks.MAPLE_LOG.get()), blockTexture(ModBlocks.MAPLE_LOG.get()));
        logBlock((RotatedPillarBlock) ModBlocks.STRIPPED_MAPLE_LOG.get());
        axisBlock((RotatedPillarBlock) ModBlocks.STRIPPED_MAPLE_WOOD.get(), blockTexture(ModBlocks.STRIPPED_MAPLE_LOG.get()), blockTexture(ModBlocks.STRIPPED_MAPLE_LOG.get()));
        logBlock((RotatedPillarBlock) ModBlocks.CHORUS_STEM.get());
        axisBlock((RotatedPillarBlock) ModBlocks.CHORUS_HYPHAE.get(), blockTexture(ModBlocks.CHORUS_STEM.get()), blockTexture(ModBlocks.CHORUS_STEM.get()));
        logBlock((RotatedPillarBlock) ModBlocks.PALE_CHORUS_STEM.get());
        axisBlock((RotatedPillarBlock) ModBlocks.PALE_CHORUS_HYPHAE.get(), blockTexture(ModBlocks.PALE_CHORUS_STEM.get()), blockTexture(ModBlocks.PALE_CHORUS_STEM.get()));

        blockItem(ModBlocks.MAPLE_LOG);
        blockItem(ModBlocks.MAPLE_WOOD);
        blockItem(ModBlocks.STRIPPED_MAPLE_LOG);
        blockItem(ModBlocks.STRIPPED_MAPLE_WOOD);
        blockItem(ModBlocks.CHORUS_STEM);
        blockItem(ModBlocks.CHORUS_HYPHAE);
        blockItem(ModBlocks.PALE_CHORUS_STEM);
        blockItem(ModBlocks.PALE_CHORUS_HYPHAE);

        blockWithItem(ModBlocks.MAPLE_PLANKS);
        blockWithItem(ModBlocks.CHORUS_PLANKS);
        blockWithItem(ModBlocks.PALE_CHORUS_PLANKS);

        leavesBlock(ModBlocks.MAPLE_LEAVES);
        leavesBlock(ModBlocks.CHORUS_LEAVES);

        saplingBlock(ModBlocks.MAPLE_SAPLING);
        saplingBlock(ModBlocks.CHORUS_TREE_SEED);
        saplingBlock(ModBlocks.PALE_CHORUS_TREE_SEED);
    }

    private void saplingBlock(DeferredBlock<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(BuiltInRegistries.BLOCK.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    private void leavesBlock(DeferredBlock<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(),
                models().singleTexture(BuiltInRegistries.BLOCK.getKey(blockRegistryObject.get()).getPath(), ResourceLocation.parse("minecraft:block/leaves"),
                        "all", blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    public void makeCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> states(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] states(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((CornCropBlock) block).getAgeProperty()),
                ResourceLocation.fromNamespaceAndPath(RayshadMC.MOD_ID, "block/" + textureName + state.getValue(((CornCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("tutorialmod:block/" + deferredBlock.getId().getPath()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock, String appendix) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("tutorialmod:block/" + deferredBlock.getId().getPath() + appendix));
    }
}
