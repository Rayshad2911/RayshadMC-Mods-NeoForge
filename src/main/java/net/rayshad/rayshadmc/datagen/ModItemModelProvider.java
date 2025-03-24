package net.rayshad.rayshadmc.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredItem;
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

        basicItem(ModItems.CORN.get());
        basicItem(ModItems.MASHED_POTATO.get());

        handheldItem(ModItems.KROIPNITE_SWORD);
        handheldItem(ModItems.KROIPNITE_SHOVEL);
        handheldItem(ModItems.KROIPNITE_PICKAXE);
        handheldItem(ModItems.KROIPNITE_AXE);
        handheldItem(ModItems.KROIPNITE_HOE);
    }

    private ItemModelBuilder handheldItem(DeferredItem<?> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/handheld")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(RayshadMC.MOD_ID, "item/" + item.getId().getPath()));
    }
}
