package net.trique.abyssborne.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import net.trique.abyssborne.Abyssborne;
import net.trique.abyssborne.block.AbyssBlocks;
import net.trique.abyssborne.item.AbyssItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class AbyssRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public AbyssRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        // -------- AMARYLLIUM: Smelting/Blasting + Block <-> Ingot ----------
        List<ItemLike> AMARYLLIUM_SMELTABLES = List.of(
                AbyssItems.RAW_AMARYLLIUM,
                AbyssBlocks.ABYSS_AMARYLLIUM_ORE
        );

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, AbyssBlocks.AMARYLLIUM_BLOCK.get())
                .pattern("BBB")
                .pattern("BBB")
                .pattern("BBB")
                .define('B', AbyssItems.AMARYLLIUM_INGOT.get())
                .unlockedBy("has_amaryllium_ingot", has(AbyssItems.AMARYLLIUM_INGOT))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, AbyssItems.AMARYLLIUM_INGOT.get(), 9)
                .requires(AbyssBlocks.AMARYLLIUM_BLOCK)
                .unlockedBy("has_amaryllium_block", has(AbyssBlocks.AMARYLLIUM_BLOCK))
                .save(recipeOutput);

        oreSmelting(recipeOutput, AMARYLLIUM_SMELTABLES, RecipeCategory.MISC, AbyssItems.AMARYLLIUM_INGOT.get(), 0.25f, 200, "amaryllium");
        oreBlasting (recipeOutput, AMARYLLIUM_SMELTABLES, RecipeCategory.MISC, AbyssItems.AMARYLLIUM_INGOT.get(), 0.25f, 100, "amaryllium");

        // -------- AMARYLLIUM: Tools ----------
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, AbyssItems.AMARYLLIUM_SWORD.get())
                .pattern(" I ")
                .pattern(" I ")
                .pattern(" S ")
                .define('I', AbyssItems.AMARYLLIUM_INGOT.get())
                .define('S', Items.STICK)
                .unlockedBy("has_amaryllium_ingot", has(AbyssItems.AMARYLLIUM_INGOT))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, AbyssItems.AMARYLLIUM_PICKAXE.get())
                .pattern("III")
                .pattern(" S ")
                .pattern(" S ")
                .define('I', AbyssItems.AMARYLLIUM_INGOT.get())
                .define('S', Items.STICK)
                .unlockedBy("has_amaryllium_ingot", has(AbyssItems.AMARYLLIUM_INGOT))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, AbyssItems.AMARYLLIUM_AXE.get())
                .pattern("II ")
                .pattern("IS ")
                .pattern(" S ")
                .define('I', AbyssItems.AMARYLLIUM_INGOT.get())
                .define('S', Items.STICK)
                .unlockedBy("has_amaryllium_ingot", has(AbyssItems.AMARYLLIUM_INGOT))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, AbyssItems.AMARYLLIUM_SHOVEL.get())
                .pattern(" I ")
                .pattern(" S ")
                .pattern(" S ")
                .define('I', AbyssItems.AMARYLLIUM_INGOT.get())
                .define('S', Items.STICK)
                .unlockedBy("has_amaryllium_ingot", has(AbyssItems.AMARYLLIUM_INGOT))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, AbyssItems.AMARYLLIUM_HOE.get())
                .pattern("II ")
                .pattern(" S ")
                .pattern(" S ")
                .define('I', AbyssItems.AMARYLLIUM_INGOT.get())
                .define('S', Items.STICK)
                .unlockedBy("has_amaryllium_ingot", has(AbyssItems.AMARYLLIUM_INGOT))
                .save(recipeOutput);

        // -------- AMARYLLIUM: Armor ----------
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, AbyssItems.AMARYLLIUM_HELMET.get())
                .pattern("III")
                .pattern("I I")
                .define('I', AbyssItems.AMARYLLIUM_INGOT.get())
                .unlockedBy("has_amaryllium_ingot", has(AbyssItems.AMARYLLIUM_INGOT))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, AbyssItems.AMARYLLIUM_CHESTPLATE.get())
                .pattern("I I")
                .pattern("III")
                .pattern("III")
                .define('I', AbyssItems.AMARYLLIUM_INGOT.get())
                .unlockedBy("has_amaryllium_ingot", has(AbyssItems.AMARYLLIUM_INGOT))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, AbyssItems.AMARYLLIUM_LEGGINGS.get())
                .pattern("III")
                .pattern("I I")
                .pattern("I I")
                .define('I', AbyssItems.AMARYLLIUM_INGOT.get())
                .unlockedBy("has_amaryllium_ingot", has(AbyssItems.AMARYLLIUM_INGOT))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, AbyssItems.AMARYLLIUM_BOOTS.get())
                .pattern("I I")
                .pattern("I I")
                .define('I', AbyssItems.AMARYLLIUM_INGOT.get())
                .unlockedBy("has_amaryllium_ingot", has(AbyssItems.AMARYLLIUM_INGOT))
                .save(recipeOutput);

        // -------- CRIMSONITE: Smelting/Blasting + Block <-> Ingot ----------
        List<ItemLike> CRIMSONITE_SMELTABLES = List.of(
                AbyssItems.RAW_CRIMSONITE,
                AbyssBlocks.ABYSS_CRIMSONITE_ORE
        );

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, AbyssBlocks.CRIMSONITE_BLOCK.get())
                .pattern("BBB")
                .pattern("BBB")
                .pattern("BBB")
                .define('B', AbyssItems.CRIMSONITE_INGOT.get())
                .unlockedBy("has_crimsonite_ingot", has(AbyssItems.CRIMSONITE_INGOT))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, AbyssItems.CRIMSONITE_INGOT.get(), 9)
                .requires(AbyssBlocks.CRIMSONITE_BLOCK)
                .unlockedBy("has_crimsonite_block", has(AbyssBlocks.CRIMSONITE_BLOCK))
                .save(recipeOutput);

        oreSmelting(recipeOutput, CRIMSONITE_SMELTABLES, RecipeCategory.MISC, AbyssItems.CRIMSONITE_INGOT.get(), 0.25f, 200, "crimsonite");
        oreBlasting (recipeOutput, CRIMSONITE_SMELTABLES, RecipeCategory.MISC, AbyssItems.CRIMSONITE_INGOT.get(), 0.25f, 100, "crimsonite");

        // -------- CRIMSONITE: Tools ----------
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, AbyssItems.CRIMSONITE_SWORD.get())
                .pattern(" I ")
                .pattern(" I ")
                .pattern(" S ")
                .define('I', AbyssItems.CRIMSONITE_INGOT.get())
                .define('S', Items.STICK)
                .unlockedBy("has_crimsonite_ingot", has(AbyssItems.CRIMSONITE_INGOT))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, AbyssItems.CRIMSONITE_PICKAXE.get())
                .pattern("III")
                .pattern(" S ")
                .pattern(" S ")
                .define('I', AbyssItems.CRIMSONITE_INGOT.get())
                .define('S', Items.STICK)
                .unlockedBy("has_crimsonite_ingot", has(AbyssItems.CRIMSONITE_INGOT))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, AbyssItems.CRIMSONITE_AXE.get())
                .pattern("II ")
                .pattern("IS ")
                .pattern(" S ")
                .define('I', AbyssItems.CRIMSONITE_INGOT.get())
                .define('S', Items.STICK)
                .unlockedBy("has_crimsonite_ingot", has(AbyssItems.CRIMSONITE_INGOT))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, AbyssItems.CRIMSONITE_SHOVEL.get())
                .pattern(" I ")
                .pattern(" S ")
                .pattern(" S ")
                .define('I', AbyssItems.CRIMSONITE_INGOT.get())
                .define('S', Items.STICK)
                .unlockedBy("has_crimsonite_ingot", has(AbyssItems.CRIMSONITE_INGOT))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, AbyssItems.CRIMSONITE_HOE.get())
                .pattern("II ")
                .pattern(" S ")
                .pattern(" S ")
                .define('I', AbyssItems.CRIMSONITE_INGOT.get())
                .define('S', Items.STICK)
                .unlockedBy("has_crimsonite_ingot", has(AbyssItems.CRIMSONITE_INGOT))
                .save(recipeOutput);

        // -------- CRIMSONITE: Armor ----------
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, AbyssItems.CRIMSONITE_HELMET.get())
                .pattern("III")
                .pattern("I I")
                .define('I', AbyssItems.CRIMSONITE_INGOT.get())
                .unlockedBy("has_crimsonite_ingot", has(AbyssItems.CRIMSONITE_INGOT))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, AbyssItems.CRIMSONITE_CHESTPLATE.get())
                .pattern("I I")
                .pattern("III")
                .pattern("III")
                .define('I', AbyssItems.CRIMSONITE_INGOT.get())
                .unlockedBy("has_crimsonite_ingot", has(AbyssItems.CRIMSONITE_INGOT))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, AbyssItems.CRIMSONITE_LEGGINGS.get())
                .pattern("III")
                .pattern("I I")
                .pattern("I I")
                .define('I', AbyssItems.CRIMSONITE_INGOT.get())
                .unlockedBy("has_crimsonite_ingot", has(AbyssItems.CRIMSONITE_INGOT))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, AbyssItems.CRIMSONITE_BOOTS.get())
                .pattern("I I")
                .pattern("I I")
                .define('I', AbyssItems.CRIMSONITE_INGOT.get())
                .unlockedBy("has_crimsonite_ingot", has(AbyssItems.CRIMSONITE_INGOT))
                .save(recipeOutput);
    }

    protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for (ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory)
                    .group(pGroup)
                    .unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, Abyssborne.MODID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}
