package net.rayshad.rayshadmc.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.neoforged.neoforge.common.data.GlobalLootModifierProvider;
import net.neoforged.neoforge.common.loot.LootTableIdCondition;
import net.rayshad.rayshadmc.RayshadMC;
import net.rayshad.rayshadmc.item.ModItems;
import net.rayshad.rayshadmc.loot.AddItemModifier;

import java.util.concurrent.CompletableFuture;

public class ModGlobalLootModifierProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifierProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, RayshadMC.MOD_ID);
    }

    @Override
    protected void start() {
        add("zombie_eye_from_zombie", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("entities/zombie"))
                        .and(LootItemRandomChanceCondition.randomChance(0.25f)).build()},
                ModItems.ZOMBIE_EYE.get()));

        add("zombie_eye_from_husk", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("entities/husk"))
                        .and(LootItemRandomChanceCondition.randomChance(0.25f)).build()},
                ModItems.ZOMBIE_EYE.get()));

        add("zombie_eye_from_zombie_villager", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("entities/zombie_villager"))
                        .and(LootItemRandomChanceCondition.randomChance(0.25f)).build()},
                ModItems.ZOMBIE_EYE.get()));

        add("zombie_eye_from_drowned", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("entities/drowned"))
                        .and(LootItemRandomChanceCondition.randomChance(0.25f)).build()},
                ModItems.ZOMBIE_EYE.get()));
    }
}
