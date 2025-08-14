package net.trique.abyssborne.item;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

public class AbyssTiers {

    public static final Tier CRIMSONITE = new SimpleTier(
            // Yanlış bloklar tag'ı (vanilla mantığıyla uyumlu)
            BlockTags.INCORRECT_FOR_DIAMOND_TOOL,
            // Dayanıklılık
            1506,
            // Kazma/kırma hızı
            10.0f,
            // Bonus saldırı hasarı
            4.0f,
            // Büyülenebilirlik değeri
            21,
            // Onarım malzemesi
            () -> Ingredient.of(AbyssItems.CRIMSONITE_INGOT)
    ) {
        @Override
        public int getEnchantmentValue() {
            return 21; // Enchant değerini açık şekilde tanımla
        }
    };

    public static final Tier AMARYLLIUM = new SimpleTier(
            BlockTags.INCORRECT_FOR_DIAMOND_TOOL,
            1506,
            10.0f,
            4.0f,
            21,
            () -> Ingredient.of(AbyssItems.AMARYLLIUM_INGOT)
    ) {
        @Override
        public int getEnchantmentValue() {
            return 21;
        }
    };
}
