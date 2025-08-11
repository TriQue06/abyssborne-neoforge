package net.trique.abyssborne.item;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

public class AbyssToolMaterials {
    public static final Tier CRIMSONITE = new SimpleTier(
            BlockTags.NEEDS_DIAMOND_TOOL, 1506, 10.0f, 4.0f, 21, () -> Ingredient.of(AbyssItems.CRIMSONITE_INGOT)
    );

    public static final Tier AMARYLLIUM = new SimpleTier(
            BlockTags.NEEDS_DIAMOND_TOOL, 1506, 10.0f, 4.0f, 21, () -> Ingredient.of(AbyssItems.AMARYLLIUM_INGOT)
    );
}