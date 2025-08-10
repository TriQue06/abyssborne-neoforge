package net.trique.abyssborne.item;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.trique.abyssborne.Abyssborne;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

public class AbyssArmorMaterials {
    public static final Holder<ArmorMaterial> CRIMSONITE = register("crimsonite",
            protectionMap(3, 6, 8, 3, 11),
            15, 3.0f, 0.1f, () -> AbyssItems.CRIMSONITE_INGOT.get());

    public static final Holder<ArmorMaterial> AMARYLLIUM = register("amaryllium",
            protectionMap(3, 6, 8, 3, 11),
            15, 3.0f, 0.1f, () -> AbyssItems.AMARYLLIUM_INGOT.get());

    private static Holder<ArmorMaterial> register(String name, EnumMap<ArmorItem.Type, Integer> protection,
                                                  int enchantability, float toughness, float knockbackResistance,
                                                  Supplier<Item> ingredientItem) {
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(Abyssborne.MODID, name);
        Holder<SoundEvent> equipSound = SoundEvents.ARMOR_EQUIP_NETHERITE;
        Supplier<Ingredient> ingredient = () -> Ingredient.of(ingredientItem.get());
        List<ArmorMaterial.Layer> layers = List.of(new ArmorMaterial.Layer(id));

        return Registry.registerForHolder(BuiltInRegistries.ARMOR_MATERIAL, id,
                new ArmorMaterial(protection, enchantability, equipSound, ingredient, layers, toughness, knockbackResistance));
    }

    private static EnumMap<ArmorItem.Type, Integer> protectionMap(int boots, int leggings, int chestplate, int helmet, int body) {
        EnumMap<ArmorItem.Type, Integer> map = new EnumMap<>(ArmorItem.Type.class);
        map.put(ArmorItem.Type.BOOTS, boots);
        map.put(ArmorItem.Type.LEGGINGS, leggings);
        map.put(ArmorItem.Type.CHESTPLATE, chestplate);
        map.put(ArmorItem.Type.HELMET, helmet);
        map.put(ArmorItem.Type.BODY, body);
        return map;
    }
}
