package net.rayshad.rayshadmc.datagen;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.rayshad.rayshadmc.RayshadMC;
import net.rayshad.rayshadmc.block.ModBlocks;

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
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }
}
