package net.rayshad.rayshadmc.datagen;

import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.rayshad.rayshadmc.block.ModBlocks;
import net.rayshad.rayshadmc.block.custom.CornCropBlock;
import net.rayshad.rayshadmc.item.ModItems;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.KROIPNITE_BLOCK.get());
        dropSelf(ModBlocks.OPYX_BLOCK.get());
        dropSelf(ModBlocks.OPYX_HARDENED_BLOCK.get());

        this.add(ModBlocks.KROIPNITE_ORE.get(),
                block -> createOreDrop(ModBlocks.KROIPNITE_ORE.get(), ModItems.KROIPNITE.get()));
        this.add(ModBlocks.DEEPSLATE_KROIPNITE_ORE.get(),
                block -> createOreDrop(ModBlocks.DEEPSLATE_KROIPNITE_ORE.get(), ModItems.KROIPNITE.get()));
        this.add(ModBlocks.OPYX_SOIL.get(),
                block -> createMultipleOreDrops(ModBlocks.OPYX_SOIL.get(), ModItems.OPYX_SHARD.get(), 2, 3));

        LootItemCondition.Builder lootItemConditionBuilder = LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.CORN_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CornCropBlock.AGE, CornCropBlock.MAX_AGE));
        this.add(ModBlocks.CORN_CROP.get(), this.createCropDrops(ModBlocks.CORN_CROP.get(),
                ModItems.CORN.get(), ModItems.CORN_SEEDS.get(), lootItemConditionBuilder));

        this.dropSelf(ModBlocks.MAPLE_LOG.get());
        this.dropSelf(ModBlocks.MAPLE_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_MAPLE_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_MAPLE_WOOD.get());
        this.dropSelf(ModBlocks.MAPLE_PLANKS.get());
        this.dropSelf(ModBlocks.MAPLE_SAPLING.get());

        this.dropSelf(ModBlocks.CHORUS_STEM.get());
        this.dropSelf(ModBlocks.CHORUS_HYPHAE.get());
        this.dropSelf(ModBlocks.PALE_CHORUS_STEM.get());
        this.dropSelf(ModBlocks.PALE_CHORUS_HYPHAE.get());
        this.dropSelf(ModBlocks.CHORUS_PLANKS.get());
        this.dropSelf(ModBlocks.PALE_CHORUS_PLANKS.get());
        this.dropSelf(ModBlocks.CHORUS_TREE_SEED.get());
        this.dropSelf(ModBlocks.PALE_CHORUS_TREE_SEED.get());

        this.add(ModBlocks.MAPLE_LEAVES.get(), block ->
                createLeavesDrops(block, ModBlocks.MAPLE_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));

        this.add(ModBlocks.CHORUS_LEAVES.get(), block ->
                createLeavesDrops(block, ModBlocks.PALE_CHORUS_TREE_SEED.get(), NORMAL_LEAVES_SAPLING_CHANCES));
    }

    protected LootTable.Builder createMultipleOreDrops(Block pBlock, Item item, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock, LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                        .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
