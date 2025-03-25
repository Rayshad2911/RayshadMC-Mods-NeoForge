package net.rayshad.rayshadmc.datagen;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
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

        stairsBlock(ModBlocks.MAPLE_STAIRS.get(), blockTexture(ModBlocks.MAPLE_PLANKS.get()));
        stairsBlock(ModBlocks.CHORUS_STAIRS.get(), blockTexture(ModBlocks.CHORUS_PLANKS.get()));
        stairsBlock(ModBlocks.PALE_CHORUS_STAIRS.get(), blockTexture(ModBlocks.PALE_CHORUS_PLANKS.get()));

        slabBlock(ModBlocks.MAPLE_SLAB.get(), blockTexture(ModBlocks.MAPLE_PLANKS.get()), blockTexture(ModBlocks.MAPLE_PLANKS.get()));
        slabBlock(ModBlocks.CHORUS_SLAB.get(), blockTexture(ModBlocks.CHORUS_PLANKS.get()), blockTexture(ModBlocks.CHORUS_PLANKS.get()));
        slabBlock(ModBlocks.PALE_CHORUS_SLAB.get(), blockTexture(ModBlocks.PALE_CHORUS_PLANKS.get()), blockTexture(ModBlocks.PALE_CHORUS_PLANKS.get()));

        buttonBlock(ModBlocks.MAPLE_BUTTON.get(), blockTexture(ModBlocks.MAPLE_PLANKS.get()));
        buttonBlock(ModBlocks.CHORUS_BUTTON.get(), blockTexture(ModBlocks.CHORUS_PLANKS.get()));
        buttonBlock(ModBlocks.PALE_CHORUS_BUTTON.get(), blockTexture(ModBlocks.PALE_CHORUS_PLANKS.get()));

        pressurePlateBlock(ModBlocks.MAPLE_PRESSURE_PLATE.get(), blockTexture(ModBlocks.MAPLE_PLANKS.get()));
        pressurePlateBlock(ModBlocks.CHORUS_PRESSURE_PLATE.get(), blockTexture(ModBlocks.CHORUS_PLANKS.get()));
        pressurePlateBlock(ModBlocks.PALE_CHORUS_PRESSURE_PLATE.get(), blockTexture(ModBlocks.PALE_CHORUS_PLANKS.get()));

        fenceBlock(ModBlocks.MAPLE_FENCE.get(), blockTexture(ModBlocks.MAPLE_PLANKS.get()));
        fenceBlock(ModBlocks.CHORUS_FENCE.get(), blockTexture(ModBlocks.CHORUS_PLANKS.get()));
        fenceBlock(ModBlocks.PALE_CHORUS_FENCE.get(), blockTexture(ModBlocks.PALE_CHORUS_PLANKS.get()));

        fenceGateBlock(ModBlocks.MAPLE_FENCE_GATE.get(), blockTexture(ModBlocks.MAPLE_PLANKS.get()));
        fenceGateBlock(ModBlocks.CHORUS_FENCE_GATE.get(), blockTexture(ModBlocks.CHORUS_PLANKS.get()));
        fenceGateBlock(ModBlocks.PALE_CHORUS_FENCE_GATE.get(), blockTexture(ModBlocks.PALE_CHORUS_PLANKS.get()));

        doorBlockWithRenderType(ModBlocks.MAPLE_DOOR.get(), modLoc("block/maple_door_bottom"), modLoc("block/maple_door_top"), "cutout");
        doorBlockWithRenderType(ModBlocks.CHORUS_DOOR.get(), modLoc("block/chorus_door_bottom"), modLoc("block/chorus_door_top"), "cutout");
        doorBlockWithRenderType(ModBlocks.PALE_CHORUS_DOOR.get(), modLoc("block/pale_chorus_door_bottom"), modLoc("block/pale_chorus_door_top"), "cutout");

        trapdoorBlockWithRenderType(ModBlocks.MAPLE_TRAPDOOR.get(), modLoc("block/maple_trapdoor"), true, "cutout");
        trapdoorBlockWithRenderType(ModBlocks.CHORUS_TRAPDOOR.get(), modLoc("block/chorus_trapdoor"), true, "cutout");
        trapdoorBlockWithRenderType(ModBlocks.PALE_CHORUS_TRAPDOOR.get(), modLoc("block/pale_chorus_trapdoor"), true, "cutout");

        blockItem(ModBlocks.MAPLE_STAIRS);
        blockItem(ModBlocks.MAPLE_SLAB);
        blockItem(ModBlocks.MAPLE_PRESSURE_PLATE);
        blockItem(ModBlocks.MAPLE_FENCE_GATE);
        blockItem(ModBlocks.MAPLE_TRAPDOOR, "_bottom");
        blockItem(ModBlocks.CHORUS_STAIRS);
        blockItem(ModBlocks.CHORUS_SLAB);
        blockItem(ModBlocks.CHORUS_PRESSURE_PLATE);
        blockItem(ModBlocks.CHORUS_FENCE_GATE);
        blockItem(ModBlocks.CHORUS_TRAPDOOR, "_bottom");
        blockItem(ModBlocks.PALE_CHORUS_STAIRS);
        blockItem(ModBlocks.PALE_CHORUS_SLAB);
        blockItem(ModBlocks.PALE_CHORUS_PRESSURE_PLATE);
        blockItem(ModBlocks.PALE_CHORUS_FENCE_GATE);
        blockItem(ModBlocks.PALE_CHORUS_TRAPDOOR, "_bottom");

        signBlock(((StandingSignBlock) ModBlocks.MAPLE_SIGN.get()), ((WallSignBlock) ModBlocks.MAPLE_WALL_SIGN.get()),
                blockTexture(ModBlocks.MAPLE_PLANKS.get()));
        signBlock(((StandingSignBlock) ModBlocks.CHORUS_SIGN.get()), ((WallSignBlock) ModBlocks.CHORUS_WALL_SIGN.get()),
                blockTexture(ModBlocks.CHORUS_PLANKS.get()));
        signBlock(((StandingSignBlock) ModBlocks.PALE_CHORUS_SIGN.get()), ((WallSignBlock) ModBlocks.PALE_CHORUS_WALL_SIGN.get()),
                blockTexture(ModBlocks.PALE_CHORUS_PLANKS.get()));

        hangingSignBlock(ModBlocks.MAPLE_HANGING_SIGN.get(), ModBlocks.MAPLE_WALL_HANGING_SIGN.get(), blockTexture(ModBlocks.MAPLE_PLANKS.get()));
    }

    public void hangingSignBlock(Block signBlock, Block wallSignBlock, ResourceLocation texture) {
        ModelFile sign = models().sign(name(signBlock), texture);
        hangingSignBlock(signBlock, wallSignBlock, sign);
    }

    public void hangingSignBlock(Block signBlock, Block wallSignBlock, ModelFile sign) {
        simpleBlock(signBlock, sign);
        simpleBlock(wallSignBlock, sign);
    }

    private String name(Block block) {
        return key(block).getPath();
    }

    private ResourceLocation key(Block block) {
        return BuiltInRegistries.BLOCK.getKey(block);
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
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("rayshadmc:block/" + deferredBlock.getId().getPath()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock, String appendix) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("rayshadmc:block/" + deferredBlock.getId().getPath() + appendix));
    }
}
