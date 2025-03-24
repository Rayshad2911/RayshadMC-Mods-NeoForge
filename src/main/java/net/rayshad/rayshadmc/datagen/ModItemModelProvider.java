package net.rayshad.rayshadmc.datagen;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.rayshad.rayshadmc.RayshadMC;
import net.rayshad.rayshadmc.item.ModItems;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, RayshadMC.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.KROIPNITE.get());
        basicItem(ModItems.OPYX_SHARD.get());
        basicItem(ModItems.KROIPNITE_INGOT.get());
        basicItem(ModItems.OPYX_ROCK.get());
    }
}
