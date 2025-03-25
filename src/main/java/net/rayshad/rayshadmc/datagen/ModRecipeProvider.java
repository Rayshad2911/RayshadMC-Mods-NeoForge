package net.rayshad.rayshadmc.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import net.rayshad.rayshadmc.RayshadMC;
import net.rayshad.rayshadmc.block.ModBlocks;
import net.rayshad.rayshadmc.item.ModItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        List<ItemLike> KROIPNITE_INGOT_SMELTABLES = List.of(ModItems.KROIPNITE.get(),
                ModBlocks.KROIPNITE_ORE.get(), ModBlocks.DEEPSLATE_KROIPNITE_ORE.get());
        List<ItemLike> CHORUS_TREE_SEED_SMELTABLES = List.of(ModBlocks.PALE_CHORUS_TREE_SEED.get());

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.KROIPNITE_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.KROIPNITE_INGOT.get())
                .unlockedBy(getHasName(ModItems.KROIPNITE_INGOT.get()), has(ModItems.KROIPNITE_INGOT.get())).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.KROIPNITE_SWORD.get())
                .pattern("A")
                .pattern("A")
                .pattern("B")
                .define('A', ModItems.KROIPNITE_INGOT.get())
                .define('B', Items.STICK)
                .unlockedBy(getHasName(ModItems.KROIPNITE_INGOT.get()), has(ModItems.KROIPNITE_INGOT.get())).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.KROIPNITE_SHOVEL.get())
                .pattern("A")
                .pattern("B")
                .pattern("B")
                .define('A', ModItems.KROIPNITE_INGOT.get())
                .define('B', Items.STICK)
                .unlockedBy(getHasName(ModItems.KROIPNITE_INGOT.get()), has(ModItems.KROIPNITE_INGOT.get())).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.KROIPNITE_PICKAXE.get())
                .pattern("AAA")
                .pattern(" B ")
                .pattern(" B ")
                .define('A', ModItems.KROIPNITE_INGOT.get())
                .define('B', Items.STICK)
                .unlockedBy(getHasName(ModItems.KROIPNITE_INGOT.get()), has(ModItems.KROIPNITE_INGOT.get())).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.KROIPNITE_AXE.get())
                .pattern("AA ")
                .pattern("AB ")
                .pattern(" B ")
                .define('A', ModItems.KROIPNITE_INGOT.get())
                .define('B', Items.STICK)
                .unlockedBy(getHasName(ModItems.KROIPNITE_INGOT.get()), has(ModItems.KROIPNITE_INGOT.get())).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.KROIPNITE_HOE.get())
                .pattern("AA ")
                .pattern(" B ")
                .pattern(" B ")
                .define('A', ModItems.KROIPNITE_INGOT.get())
                .define('B', Items.STICK)
                .unlockedBy(getHasName(ModItems.KROIPNITE_INGOT.get()), has(ModItems.KROIPNITE_INGOT.get())).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.KROIPNITE_HELMET.get())
                .pattern("AAA")
                .pattern("A A")
                .define('A', ModItems.KROIPNITE.get())
                .unlockedBy(getHasName(ModItems.KROIPNITE.get()), has(ModItems.KROIPNITE.get())).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.KROIPNITE_CHESTPLATE.get())
                .pattern("A A")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.KROIPNITE.get())
                .unlockedBy(getHasName(ModItems.KROIPNITE.get()), has(ModItems.KROIPNITE.get())).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.KROIPNITE_LEGGINGS.get())
                .pattern("AAA")
                .pattern("A A")
                .pattern("A A")
                .define('A', ModItems.KROIPNITE.get())
                .unlockedBy(getHasName(ModItems.KROIPNITE.get()), has(ModItems.KROIPNITE.get())).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.KROIPNITE_BOOTS.get())
                .pattern("A A")
                .pattern("A A")
                .define('A', ModItems.KROIPNITE.get())
                .unlockedBy(getHasName(ModItems.KROIPNITE.get()), has(ModItems.KROIPNITE.get())).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.AMETHYST_GRENADE.get(), 1)
                .pattern(" C ")
                .pattern("ABA")
                .pattern(" A ")
                .define('A', Items.AMETHYST_SHARD)
                .define('B', Items.GUNPOWDER)
                .define('C', Items.TRIPWIRE_HOOK)
                .unlockedBy(getHasName(Items.GUNPOWDER), has(Items.GUNPOWDER)).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.OPYX_ROCK.get())
                .pattern("AA")
                .pattern("AA")
                .define('A', ModItems.OPYX_SHARD.get())
                .unlockedBy(getHasName(ModItems.OPYX_SHARD.get()), has(ModItems.OPYX_SHARD.get())).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OPYX_BLOCK.get())
                .pattern("AA")
                .pattern("AA")
                .define('A', ModItems.OPYX_ROCK.get())
                .unlockedBy(getHasName(ModItems.OPYX_ROCK.get()), has(ModItems.OPYX_ROCK.get())).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OPYX_HARDENED_BLOCK.get(), 8)
                .pattern("AAA")
                .pattern("ABA")
                .pattern("AAA")
                .define('A', ModBlocks.OPYX_BLOCK.get())
                .define('B', Blocks.GLASS)
                .unlockedBy(getHasName(ModBlocks.OPYX_BLOCK.get()), has(ModBlocks.OPYX_BLOCK.get())).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MAPLE_WOOD.get(), 3)
                .pattern("AA")
                .pattern("AA")
                .define('A', ModBlocks.MAPLE_LOG.get())
                .unlockedBy(getHasName(ModBlocks.MAPLE_LOG.get()), has(ModBlocks.MAPLE_LOG.get())).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STRIPPED_MAPLE_WOOD.get(), 3)
                .pattern("AA")
                .pattern("AA")
                .define('A', ModBlocks.STRIPPED_MAPLE_LOG.get())
                .unlockedBy(getHasName(ModBlocks.STRIPPED_MAPLE_LOG.get()), has(ModBlocks.STRIPPED_MAPLE_LOG.get())).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHORUS_HYPHAE.get(), 3)
                .pattern("AA")
                .pattern("AA")
                .define('A', ModBlocks.CHORUS_STEM.get())
                .unlockedBy(getHasName(ModBlocks.CHORUS_STEM.get()), has(ModBlocks.CHORUS_STEM.get())).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PALE_CHORUS_HYPHAE.get(), 3)
                .pattern("AA")
                .pattern("AA")
                .define('A', ModBlocks.PALE_CHORUS_STEM.get())
                .unlockedBy(getHasName(ModBlocks.PALE_CHORUS_STEM.get()), has(ModBlocks.PALE_CHORUS_STEM.get())).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModItems.MAPLE_HANGING_SIGN.get(), 6)
                .pattern("B B")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModBlocks.STRIPPED_MAPLE_LOG.get())
                .define('B', Blocks.CHAIN)
                .unlockedBy(getHasName(ModBlocks.STRIPPED_MAPLE_LOG.get()), has(ModBlocks.STRIPPED_MAPLE_LOG.get())).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModItems.MAPLE_SIGN.get(), 3)
                .pattern("AAA")
                .pattern("AAA")
                .pattern(" B ")
                .define('A', ModBlocks.MAPLE_PLANKS.get())
                .define('B', Items.STICK)
                .unlockedBy(getHasName(ModBlocks.MAPLE_PLANKS.get()), has(ModBlocks.MAPLE_PLANKS.get())).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModItems.CHORUS_SIGN.get(), 3)
                .pattern("AAA")
                .pattern("AAA")
                .pattern(" B ")
                .define('A', ModBlocks.CHORUS_PLANKS.get())
                .define('B', Items.STICK)
                .unlockedBy(getHasName(ModBlocks.CHORUS_PLANKS.get()), has(ModBlocks.CHORUS_PLANKS.get())).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModItems.PALE_CHORUS_SIGN.get(), 3)
                .pattern("AAA")
                .pattern("AAA")
                .pattern(" B ")
                .define('A', ModBlocks.PALE_CHORUS_PLANKS.get())
                .define('B', Items.STICK)
                .unlockedBy(getHasName(ModBlocks.PALE_CHORUS_PLANKS.get()), has(ModBlocks.PALE_CHORUS_PLANKS.get())).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.KROIPNITE_INGOT.get(), 9)
                .requires(ModBlocks.KROIPNITE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.KROIPNITE_BLOCK.get()), has(ModBlocks.KROIPNITE_BLOCK.get())).save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MAPLE_PLANKS.get(), 4)
                .requires(ModBlocks.MAPLE_LOG.get())
                .unlockedBy(getHasName(ModBlocks.MAPLE_LOG.get()), has(ModBlocks.MAPLE_LOG.get())).save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHORUS_PLANKS.get(), 4)
                .requires(ModBlocks.CHORUS_STEM.get())
                .unlockedBy(getHasName(ModBlocks.CHORUS_STEM.get()), has(ModBlocks.CHORUS_STEM.get())).save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PALE_CHORUS_PLANKS.get(), 4)
                .requires(ModBlocks.PALE_CHORUS_STEM.get())
                .unlockedBy(getHasName(ModBlocks.PALE_CHORUS_STEM.get()), has(ModBlocks.PALE_CHORUS_STEM.get())).save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.MASHED_POTATO.get())
                .requires(Items.BOWL)
                .requires(Items.MILK_BUCKET)
                .requires(Items.MILK_BUCKET)
                .requires(Items.POTATO)
                .unlockedBy(getHasName(Items.BOWL), has(Items.BOWL)).save(recipeOutput);

        oreSmelting(recipeOutput, KROIPNITE_INGOT_SMELTABLES, RecipeCategory.MISC, ModItems.KROIPNITE_INGOT.get(), 0.5f, 200, "kroipnite");
        oreBlasting(recipeOutput, KROIPNITE_INGOT_SMELTABLES, RecipeCategory.MISC, ModItems.KROIPNITE_INGOT.get(), 0.5f, 100, "kroipnite");
        randomCooking(recipeOutput, CHORUS_TREE_SEED_SMELTABLES, RecipeCategory.MISC, ModBlocks.CHORUS_TREE_SEED.get(), 0f, 200, "sapling");

        stairBuilder(ModBlocks.MAPLE_STAIRS.get(), Ingredient.of(ModBlocks.MAPLE_PLANKS)).group("wooden_stairs")
                .unlockedBy("has_maple_planks", has(ModBlocks.MAPLE_PLANKS)).save(recipeOutput);
        stairBuilder(ModBlocks.CHORUS_STAIRS.get(), Ingredient.of(ModBlocks.CHORUS_PLANKS)).group("wooden_stairs")
                .unlockedBy("has_chorus_planks", has(ModBlocks.CHORUS_PLANKS)).save(recipeOutput);
        stairBuilder(ModBlocks.PALE_CHORUS_STAIRS.get(), Ingredient.of(ModBlocks.PALE_CHORUS_PLANKS)).group("wooden_stairs")
                .unlockedBy("has_pale_chorus_planks", has(ModBlocks.PALE_CHORUS_PLANKS)).save(recipeOutput);

        slab(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.MAPLE_SLAB.get(), ModBlocks.MAPLE_PLANKS.get());
        slab(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHORUS_SLAB.get(), ModBlocks.CHORUS_PLANKS.get());
        slab(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.PALE_CHORUS_SLAB.get(), ModBlocks.PALE_CHORUS_PLANKS.get());

        buttonBuilder(ModBlocks.MAPLE_BUTTON.get(), Ingredient.of(ModBlocks.MAPLE_PLANKS.get())).group("wooden_button")
                .unlockedBy("has_maple_planks", has(ModBlocks.MAPLE_PLANKS)).save(recipeOutput);
        buttonBuilder(ModBlocks.CHORUS_BUTTON.get(), Ingredient.of(ModBlocks.CHORUS_PLANKS.get())).group("wooden_button")
                .unlockedBy("has_chorus_planks", has(ModBlocks.CHORUS_PLANKS)).save(recipeOutput);
        buttonBuilder(ModBlocks.PALE_CHORUS_BUTTON.get(), Ingredient.of(ModBlocks.PALE_CHORUS_PLANKS.get())).group("wooden_button")
                .unlockedBy("has_pale_chorus_planks", has(ModBlocks.PALE_CHORUS_PLANKS)).save(recipeOutput);

        pressurePlate(recipeOutput, ModBlocks.MAPLE_PRESSURE_PLATE.get(), ModBlocks.MAPLE_PLANKS.get());
        pressurePlate(recipeOutput, ModBlocks.CHORUS_PRESSURE_PLATE.get(), ModBlocks.CHORUS_PLANKS.get());
        pressurePlate(recipeOutput, ModBlocks.PALE_CHORUS_PRESSURE_PLATE.get(), ModBlocks.PALE_CHORUS_PLANKS.get());

        fenceBuilder(ModBlocks.MAPLE_FENCE.get(), Ingredient.of(ModBlocks.MAPLE_PLANKS.get())).group("wooden_fence")
                .unlockedBy("has_maple_planks", has(ModBlocks.MAPLE_PLANKS)).save(recipeOutput);
        fenceBuilder(ModBlocks.CHORUS_FENCE.get(), Ingredient.of(ModBlocks.CHORUS_PLANKS.get())).group("wooden_fence")
                .unlockedBy("has_chorus_planks", has(ModBlocks.CHORUS_PLANKS)).save(recipeOutput);
        fenceBuilder(ModBlocks.PALE_CHORUS_FENCE.get(), Ingredient.of(ModBlocks.PALE_CHORUS_PLANKS.get())).group("wooden_fence")
                .unlockedBy("has_pale_chorus_planks", has(ModBlocks.PALE_CHORUS_PLANKS)).save(recipeOutput);

        fenceGateBuilder(ModBlocks.MAPLE_FENCE_GATE.get(), Ingredient.of(ModBlocks.MAPLE_PLANKS.get())).group("fence_gate")
                .unlockedBy("has_maple_planks", has(ModBlocks.MAPLE_PLANKS)).save(recipeOutput);
        fenceGateBuilder(ModBlocks.CHORUS_FENCE_GATE.get(), Ingredient.of(ModBlocks.CHORUS_PLANKS.get())).group("fence_gate")
                .unlockedBy("has_chorus_planks", has(ModBlocks.CHORUS_PLANKS)).save(recipeOutput);
        fenceGateBuilder(ModBlocks.PALE_CHORUS_FENCE_GATE.get(), Ingredient.of(ModBlocks.PALE_CHORUS_PLANKS.get())).group("fence_gate")
                .unlockedBy("has_pale_chorus_planks", has(ModBlocks.PALE_CHORUS_PLANKS)).save(recipeOutput);

        doorBuilder(ModBlocks.MAPLE_DOOR.get(), Ingredient.of(ModBlocks.MAPLE_PLANKS.get())).group("wooden_door")
                .unlockedBy("has_maple_planks", has(ModBlocks.MAPLE_PLANKS)).save(recipeOutput);
        doorBuilder(ModBlocks.CHORUS_DOOR.get(), Ingredient.of(ModBlocks.CHORUS_PLANKS.get())).group("wooden_door")
                .unlockedBy("has_chorus_planks", has(ModBlocks.CHORUS_PLANKS)).save(recipeOutput);
        doorBuilder(ModBlocks.PALE_CHORUS_DOOR.get(), Ingredient.of(ModBlocks.PALE_CHORUS_PLANKS.get())).group("wooden_door")
                .unlockedBy("has_pale_chorus_planks", has(ModBlocks.PALE_CHORUS_PLANKS)).save(recipeOutput);

        trapdoorBuilder(ModBlocks.MAPLE_TRAPDOOR.get(), Ingredient.of(ModBlocks.MAPLE_PLANKS.get())).group("wooden_trapdoor")
                .unlockedBy("has_maple_planks", has(ModBlocks.MAPLE_PLANKS)).save(recipeOutput);
        trapdoorBuilder(ModBlocks.CHORUS_TRAPDOOR.get(), Ingredient.of(ModBlocks.CHORUS_PLANKS.get())).group("wooden_trapdoor")
                .unlockedBy("has_chorus_planks", has(ModBlocks.CHORUS_PLANKS)).save(recipeOutput);
        trapdoorBuilder(ModBlocks.PALE_CHORUS_TRAPDOOR.get(), Ingredient.of(ModBlocks.PALE_CHORUS_PLANKS.get())).group("wooden_trapdoor")
                .unlockedBy("has_pale_chorus_planks",has(ModBlocks.PALE_CHORUS_PLANKS)).save(recipeOutput);
    }

    protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void randomCooking(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                        float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_smelting");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemLike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemLike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemLike), has(itemLike))
                    .save(recipeOutput, RayshadMC.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemLike));
        }
    }
}
