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

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.KROIPNITE_INGOT.get(), 9)
                .requires(ModBlocks.KROIPNITE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.KROIPNITE_BLOCK.get()), has(ModBlocks.KROIPNITE_BLOCK.get())).save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.MASHED_POTATO.get())
                .requires(Items.BOWL)
                .requires(Items.MILK_BUCKET)
                .requires(Items.MILK_BUCKET)
                .requires(Items.POTATO)
                .unlockedBy(getHasName(Items.BOWL), has(Items.BOWL)).save(recipeOutput);

        oreSmelting(recipeOutput, KROIPNITE_INGOT_SMELTABLES, RecipeCategory.MISC, ModItems.KROIPNITE_INGOT.get(), 0.5f, 200, "kroipnite");
        oreBlasting(recipeOutput, KROIPNITE_INGOT_SMELTABLES, RecipeCategory.MISC, ModItems.KROIPNITE_INGOT.get(), 0.5f, 100, "kroipnite");
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

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemLike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemLike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemLike), has(itemLike))
                    .save(recipeOutput, RayshadMC.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemLike));
        }
    }
}
