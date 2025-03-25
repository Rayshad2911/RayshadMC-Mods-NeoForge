package net.rayshad.rayshadmc.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.rayshad.rayshadmc.RayshadMC;
import net.rayshad.rayshadmc.block.ModBlocks;
import net.rayshad.rayshadmc.item.ModItems;
import net.rayshad.rayshadmc.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                              CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, RayshadMC.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(ItemTags.SWORDS)
                .add(ModItems.KROIPNITE_SWORD.get());
        tag(ItemTags.PICKAXES)
                .add(ModItems.KROIPNITE_PICKAXE.get());
        tag(ItemTags.SHOVELS)
                .add(ModItems.KROIPNITE_SHOVEL.get());
        tag(ItemTags.AXES)
                .add(ModItems.KROIPNITE_AXE.get());
        tag(ItemTags.HOES)
                .add(ModItems.KROIPNITE_HOE.get());

        tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.KROIPNITE_HELMET.get())
                .add(ModItems.KROIPNITE_CHESTPLATE.get())
                .add(ModItems.KROIPNITE_LEGGINGS.get())
                .add(ModItems.KROIPNITE_BOOTS.get());

        this.tag(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.MAPLE_LOG.get().asItem())
                .add(ModBlocks.MAPLE_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_MAPLE_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_MAPLE_WOOD.get().asItem());

        tag(ItemTags.PLANKS)
                .add(ModBlocks.MAPLE_PLANKS.get().asItem())
                .add(ModBlocks.CHORUS_PLANKS.get().asItem())
                .add(ModBlocks.PALE_CHORUS_PLANKS.get().asItem());

        tag(ModTags.Items.MAPLE_LOGS)
                .add(ModBlocks.MAPLE_LOG.get().asItem())
                .add(ModBlocks.MAPLE_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_MAPLE_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_MAPLE_WOOD.get().asItem());

        tag(ModTags.Items.CHORUS_STEMS)
                .add(ModBlocks.CHORUS_STEM.get().asItem())
                .add(ModBlocks.CHORUS_HYPHAE.get().asItem());

        tag(ModTags.Items.PALE_CHORUS_STEMS)
                .add(ModBlocks.PALE_CHORUS_STEM.get().asItem())
                .add(ModBlocks.PALE_CHORUS_HYPHAE.get().asItem());
    }
}
