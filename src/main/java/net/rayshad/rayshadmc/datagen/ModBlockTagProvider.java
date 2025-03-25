package net.rayshad.rayshadmc.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.rayshad.rayshadmc.RayshadMC;
import net.rayshad.rayshadmc.block.ModBlocks;
import net.rayshad.rayshadmc.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, RayshadMC.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.KROIPNITE_BLOCK.get())
                .add(ModBlocks.KROIPNITE_ORE.get())
                .add(ModBlocks.DEEPSLATE_KROIPNITE_ORE.get())
                .add(ModBlocks.OPYX_BLOCK.get())
                .add(ModBlocks.OPYX_HARDENED_BLOCK.get());

        tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.OPYX_BLOCK.get())
                .add(ModBlocks.OPYX_HARDENED_BLOCK.get());

        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.KROIPNITE_BLOCK.get())
                .add(ModBlocks.KROIPNITE_ORE.get())
                .add(ModBlocks.DEEPSLATE_KROIPNITE_ORE.get());

        tag(ModTags.Blocks.NEEDS_KROIPNITE_TOOL)
                .addTag(BlockTags.NEEDS_DIAMOND_TOOL);

        tag(ModTags.Blocks.INCORRECT_FOR_KROIPNITE_TOOL)
                .addTag(BlockTags.INCORRECT_FOR_DIAMOND_TOOL)
                .remove(ModTags.Blocks.NEEDS_KROIPNITE_TOOL);

        tag(BlockTags.MINEABLE_WITH_SHOVEL)
                .add(ModBlocks.OPYX_SOIL.get());

        tag(BlockTags.SOUL_FIRE_BASE_BLOCKS)
                .add(ModBlocks.OPYX_SOIL.get());

        tag(BlockTags.NETHER_CARVER_REPLACEABLES)
                .add(ModBlocks.OPYX_SOIL.get());

        tag(BlockTags.SOUL_SPEED_BLOCKS)
                .add(ModBlocks.OPYX_SOIL.get());

        this.tag(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.MAPLE_LOG.get())
                .add(ModBlocks.MAPLE_WOOD.get())
                .add(ModBlocks.STRIPPED_MAPLE_LOG.get())
                .add(ModBlocks.STRIPPED_MAPLE_WOOD.get());
    }
}
