package net.rayshad.rayshadmc.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DataMapProvider;
import net.neoforged.neoforge.registries.datamaps.builtin.Compostable;
import net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps;
import net.rayshad.rayshadmc.block.ModBlocks;
import net.rayshad.rayshadmc.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModDataMapProvider extends DataMapProvider {
    protected ModDataMapProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(packOutput, lookupProvider);
    }

    @Override
    protected void gather() {
        this.builder(NeoForgeDataMaps.COMPOSTABLES)
                .add(ModItems.CORN.getId(), new Compostable(0.4f), false)
                .add(ModItems.CORN_SEEDS.getId(), new Compostable(0.4f), false)
                .add(ModBlocks.MAPLE_SAPLING.getId(), new Compostable(0.1f), false)
                .add(ModBlocks.CHORUS_TREE_SEED.getId(), new Compostable(0.1f), false)
                .add(ModBlocks.PALE_CHORUS_TREE_SEED.getId(), new Compostable(0.1f), false);
    }
}
