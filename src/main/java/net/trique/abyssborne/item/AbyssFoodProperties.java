package net.trique.abyssborne.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class AbyssFoodProperties {
    public static final FoodProperties STRANGE_FOOD = new FoodProperties.Builder().nutrition(4).saturationModifier(0.3f)
            .effect(() -> new MobEffectInstance(MobEffects.NIGHT_VISION, 1200), 1.0f).build();

    public static final FoodProperties WEIRD_FOOD = new FoodProperties.Builder().nutrition(4).saturationModifier(0.3f)
            .effect(() -> new MobEffectInstance(MobEffects.JUMP, 1200), 1.0f).build();

    public static final FoodProperties ODD_FOOD = new FoodProperties.Builder().nutrition(4).saturationModifier(0.3f)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1200), 1.0f).build();
}