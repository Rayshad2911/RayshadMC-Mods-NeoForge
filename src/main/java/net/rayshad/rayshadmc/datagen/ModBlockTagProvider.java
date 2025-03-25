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

        tag(BlockTags.MINEABLE_WITH_AXE)
                .add(ModBlocks.MAPLE_LOG.get())
                .add(ModBlocks.MAPLE_WOOD.get())
                .add(ModBlocks.STRIPPED_MAPLE_LOG.get())
                .add(ModBlocks.STRIPPED_MAPLE_WOOD.get())
                .add(ModBlocks.MAPLE_PLANKS.get())
                .add(ModBlocks.MAPLE_STAIRS.get())
                .add(ModBlocks.MAPLE_SLAB.get())
                .add(ModBlocks.MAPLE_FENCE.get())
                .add(ModBlocks.MAPLE_FENCE_GATE.get())
                .add(ModBlocks.MAPLE_DOOR.get())
                .add(ModBlocks.MAPLE_TRAPDOOR.get())
                .add(ModBlocks.MAPLE_PRESSURE_PLATE.get())
                .add(ModBlocks.MAPLE_BUTTON.get())
                .add(ModBlocks.MAPLE_SIGN.get())
                .add(ModBlocks.MAPLE_HANGING_SIGN.get())
                .add(ModBlocks.CHORUS_STEM.get())
                .add(ModBlocks.CHORUS_HYPHAE.get())
                .add(ModBlocks.CHORUS_PLANKS.get())
                .add(ModBlocks.CHORUS_STAIRS.get())
                .add(ModBlocks.CHORUS_SLAB.get())
                .add(ModBlocks.CHORUS_FENCE.get())
                .add(ModBlocks.CHORUS_FENCE_GATE.get())
                .add(ModBlocks.CHORUS_DOOR.get())
                .add(ModBlocks.CHORUS_TRAPDOOR.get())
                .add(ModBlocks.CHORUS_PRESSURE_PLATE.get())
                .add(ModBlocks.CHORUS_BUTTON.get())
                .add(ModBlocks.CHORUS_SIGN.get())
                .add(ModBlocks.PALE_CHORUS_STEM.get())
                .add(ModBlocks.PALE_CHORUS_HYPHAE.get())
                .add(ModBlocks.PALE_CHORUS_PLANKS.get())
                .add(ModBlocks.PALE_CHORUS_STAIRS.get())
                .add(ModBlocks.PALE_CHORUS_SLAB.get())
                .add(ModBlocks.PALE_CHORUS_FENCE.get())
                .add(ModBlocks.PALE_CHORUS_FENCE_GATE.get())
                .add(ModBlocks.PALE_CHORUS_DOOR.get())
                .add(ModBlocks.PALE_CHORUS_TRAPDOOR.get())
                .add(ModBlocks.PALE_CHORUS_PRESSURE_PLATE.get())
                .add(ModBlocks.PALE_CHORUS_BUTTON.get())
                .add(ModBlocks.PALE_CHORUS_SIGN.get());

        tag(BlockTags.SOUL_FIRE_BASE_BLOCKS)
                .add(ModBlocks.OPYX_SOIL.get());

        tag(BlockTags.NETHER_CARVER_REPLACEABLES)
                .add(ModBlocks.OPYX_SOIL.get());

        tag(BlockTags.SOUL_SPEED_BLOCKS)
                .add(ModBlocks.OPYX_SOIL.get());

        tag(BlockTags.WOODEN_FENCES).add(ModBlocks.MAPLE_FENCE.get());
        tag(BlockTags.WOODEN_FENCES).add(ModBlocks.CHORUS_FENCE.get());
        tag(BlockTags.WOODEN_FENCES).add(ModBlocks.PALE_CHORUS_FENCE.get());
        tag(BlockTags.FENCE_GATES).add(ModBlocks.MAPLE_FENCE_GATE.get());
        tag(BlockTags.FENCE_GATES).add(ModBlocks.CHORUS_FENCE_GATE.get());
        tag(BlockTags.FENCE_GATES).add(ModBlocks.PALE_CHORUS_FENCE_GATE.get());

        this.tag(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.MAPLE_LOG.get())
                .add(ModBlocks.MAPLE_WOOD.get())
                .add(ModBlocks.STRIPPED_MAPLE_LOG.get())
                .add(ModBlocks.STRIPPED_MAPLE_WOOD.get());

        tag(BlockTags.WALL_POST_OVERRIDE)
                .add(ModBlocks.MAPLE_SIGN.get())
                .add(ModBlocks.CHORUS_SIGN.get())
                .add(ModBlocks.PALE_CHORUS_SIGN.get());

        tag(BlockTags.ALL_SIGNS)
                .add(ModBlocks.MAPLE_SIGN.get())
                .add(ModBlocks.MAPLE_WALL_SIGN.get())
                .add(ModBlocks.CHORUS_SIGN.get())
                .add(ModBlocks.CHORUS_WALL_SIGN.get())
                .add(ModBlocks.PALE_CHORUS_SIGN.get())
                .add(ModBlocks.PALE_CHORUS_WALL_SIGN.get());
    }
}
