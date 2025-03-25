package net.rayshad.rayshadmc.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.item.armortrim.TrimMaterials;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.rayshad.rayshadmc.RayshadMC;
import net.rayshad.rayshadmc.block.ModBlocks;
import net.rayshad.rayshadmc.item.ModItems;

import java.util.LinkedHashMap;

public class ModItemModelProvider extends ItemModelProvider {
    private static LinkedHashMap<ResourceKey<TrimMaterial>, Float> trimMaterials = new LinkedHashMap<>();
    static {
        trimMaterials.put(TrimMaterials.QUARTZ, 0.1F);
        trimMaterials.put(TrimMaterials.IRON, 0.2F);
        trimMaterials.put(TrimMaterials.NETHERITE, 0.3F);
        trimMaterials.put(TrimMaterials.REDSTONE, 0.4F);
        trimMaterials.put(TrimMaterials.COPPER, 0.5F);
        trimMaterials.put(TrimMaterials.GOLD, 0.6F);
        trimMaterials.put(TrimMaterials.EMERALD, 0.7F);
        trimMaterials.put(TrimMaterials.DIAMOND, 0.8F);
        trimMaterials.put(TrimMaterials.LAPIS, 0.9F);
        trimMaterials.put(TrimMaterials.AMETHYST, 1.0F);
    }

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, RayshadMC.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.KROIPNITE.get());
        basicItem(ModItems.OPYX_SHARD.get());
        basicItem(ModItems.KROIPNITE_INGOT.get());
        basicItem(ModItems.OPYX_ROCK.get());

        basicItem(ModItems.CORN_SEEDS.get());
        basicItem(ModItems.CORN.get());
        basicItem(ModItems.MASHED_POTATO.get());

        basicItem(ModItems.MUSIC_DISC_FUN_RANDOM.get());
        basicItem(ModItems.MUSIC_DISC_PLAYING_ARCADE_GAME.get());

        basicItem(ModItems.ZOMBIE_EYE.get());

        handheldItem(ModItems.KROIPNITE_SWORD);
        handheldItem(ModItems.KROIPNITE_SHOVEL);
        handheldItem(ModItems.KROIPNITE_PICKAXE);
        handheldItem(ModItems.KROIPNITE_AXE);
        handheldItem(ModItems.KROIPNITE_HOE);

        trimmedArmorItem(ModItems.KROIPNITE_HELMET);
        trimmedArmorItem(ModItems.KROIPNITE_CHESTPLATE);
        trimmedArmorItem(ModItems.KROIPNITE_LEGGINGS);
        trimmedArmorItem(ModItems.KROIPNITE_BOOTS);

        saplingItem(ModBlocks.MAPLE_SAPLING);
        saplingItem(ModBlocks.CHORUS_TREE_SEED);
        saplingItem(ModBlocks.PALE_CHORUS_TREE_SEED);

        buttonItem(ModBlocks.MAPLE_BUTTON, ModBlocks.MAPLE_PLANKS);
        buttonItem(ModBlocks.CHORUS_BUTTON, ModBlocks.CHORUS_PLANKS);
        buttonItem(ModBlocks.PALE_CHORUS_BUTTON, ModBlocks.PALE_CHORUS_PLANKS);
        fenceItem(ModBlocks.MAPLE_FENCE, ModBlocks.MAPLE_PLANKS);
        fenceItem(ModBlocks.CHORUS_FENCE, ModBlocks.CHORUS_PLANKS);
        fenceItem(ModBlocks.PALE_CHORUS_FENCE, ModBlocks.PALE_CHORUS_PLANKS);
        basicItem(ModBlocks.MAPLE_DOOR.asItem());
        basicItem(ModBlocks.CHORUS_DOOR.asItem());
        basicItem(ModBlocks.PALE_CHORUS_DOOR.asItem());
        basicItem(ModItems.MAPLE_SIGN.get());
        basicItem(ModItems.CHORUS_SIGN.get());
        basicItem(ModItems.PALE_CHORUS_SIGN.get());
        basicItem(ModItems.MAPLE_HANGING_SIGN.get());

        basicItem(ModItems.AMETHYST_GRENADE.asItem());
    }

    private ItemModelBuilder saplingItem(DeferredBlock<Block> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(RayshadMC.MOD_ID, "block/" + item.getId().getPath()));
    }

    private void trimmedArmorItem(DeferredItem<ArmorItem> itemDeferredItem) {
        final String MOD_ID = RayshadMC.MOD_ID;

        if(itemDeferredItem.get() instanceof ArmorItem armorItem) {
            trimMaterials.forEach((trimMaterial, value) -> {
                float trimValue = value;

                String armorType = switch (armorItem.getEquipmentSlot()) {
                    case HEAD -> "helmet";
                    case CHEST -> "chestplate";
                    case LEGS -> "leggings";
                    case FEET -> "boots";
                    default -> "";
                };

                String armorItemPath = armorItem.toString();
                String trimPath = "trims/items/" + armorType + "_trim_" + trimMaterial.location().getPath();
                String currentTrimName = armorItemPath + "_" + trimMaterial.location().getPath() + "_trim";
                ResourceLocation armorItemResLoc = ResourceLocation.parse(armorItemPath);
                ResourceLocation trimResLoc = ResourceLocation.parse(trimPath);
                ResourceLocation trimNameResLoc = ResourceLocation.parse(currentTrimName);

                existingFileHelper.trackGenerated(trimResLoc, PackType.CLIENT_RESOURCES, ".png", "textures");

                getBuilder(currentTrimName)
                        .parent(new ModelFile.UncheckedModelFile("item/generated"))
                        .texture("layer0", armorItemResLoc.getNamespace() + ":item/" + armorItemResLoc.getPath())
                        .texture("layer1", trimResLoc);

                this.withExistingParent(itemDeferredItem.getId().getPath(),
                                mcLoc("item/generated"))
                        .override()
                        .model(new ModelFile.UncheckedModelFile(trimNameResLoc.getNamespace() + ":item/" + trimNameResLoc.getPath()))
                        .predicate(mcLoc("trim_type"), trimValue).end()
                        .texture("layer0",
                                ResourceLocation.fromNamespaceAndPath(MOD_ID,
                                        "item/" + itemDeferredItem.getId().getPath()));
            });
        }
    }

    private ItemModelBuilder handheldItem(DeferredItem<?> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/handheld")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(RayshadMC.MOD_ID, "item/" + item.getId().getPath()));
    }

    public void buttonItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(RayshadMC.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }

    public void fenceItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(RayshadMC.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }
}
