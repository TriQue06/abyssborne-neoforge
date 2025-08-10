package net.trique.abyssborne.item;

import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.trique.abyssborne.Abyssborne;
import net.trique.abyssborne.material.AbyssFluids;

public class AbyssItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Abyssborne.MODID);

    public static final DeferredItem<Item> PURPLE_LAVA_BUCKET = ITEMS.register("purple_lava_bucket",
            () -> new BucketItem(AbyssFluids.PURPLE_LAVA, (new Item.Properties()).craftRemainder(Items.BUCKET).stacksTo(1)));

    public static final DeferredItem<Item> STRANGE_SHARD = ITEMS.register("strange_shard",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> WEIRD_SHARD = ITEMS.register("weird_shard",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> ODD_SHARD = ITEMS.register("odd_shard",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> CRIMSONITE_INGOT = ITEMS.register("crimsonite_ingot",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RAW_CRIMSONITE = ITEMS.register("raw_crimsonite",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<SwordItem> CRIMSONITE_SWORD = ITEMS.register("crimsonite_sword",
            () -> new SwordItem(AbyssToolMaterials.CRIMSONITE, new Item.Properties()
                    .attributes(SwordItem.createAttributes(AbyssToolMaterials.CRIMSONITE, 5, -2.4f))));
    public static final DeferredItem<PickaxeItem> CRIMSONITE_PICKAXE = ITEMS.register("crimsonite_pickaxe",
            () -> new PickaxeItem(AbyssToolMaterials.CRIMSONITE, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(AbyssToolMaterials.CRIMSONITE, 1, -2.8f))));
    public static final DeferredItem<ShovelItem> CRIMSONITE_SHOVEL = ITEMS.register("crimsonite_shovel",
            () -> new ShovelItem(AbyssToolMaterials.CRIMSONITE, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(AbyssToolMaterials.CRIMSONITE, 1.5f, -3.0f))));
    public static final DeferredItem<AxeItem> CRIMSONITE_AXE = ITEMS.register("crimsonite_axe",
            () -> new AxeItem(AbyssToolMaterials.CRIMSONITE, new Item.Properties()
                    .attributes(AxeItem.createAttributes(AbyssToolMaterials.CRIMSONITE, 6.0f, -3.2f))));
    public static final DeferredItem<HoeItem> CRIMSONITE_HOE = ITEMS.register("crimsonite_hoe",
            () -> new HoeItem(AbyssToolMaterials.CRIMSONITE, new Item.Properties()
                    .attributes(HoeItem.createAttributes(AbyssToolMaterials.CRIMSONITE, 0f, -3.0f))));

    public static final DeferredItem<ArmorItem> CRIMSONITE_HELMET = ITEMS.register("crimsonite_helmet",
            () -> new ArmorItem(AbyssArmorMaterials.CRIMSONITE, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(19))));
    public static final DeferredItem<ArmorItem> CRIMSONITE_CHESTPLATE = ITEMS.register("crimsonite_chestplate",
            () -> new ArmorItem(AbyssArmorMaterials.CRIMSONITE, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(19))));
    public static final DeferredItem<ArmorItem> CRIMSONITE_LEGGINGS = ITEMS.register("crimsonite_leggings",
            () -> new ArmorItem(AbyssArmorMaterials.CRIMSONITE, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(19))));
    public static final DeferredItem<ArmorItem> CRIMSONITE_BOOTS = ITEMS.register("crimsonite_boots",
            () -> new ArmorItem(AbyssArmorMaterials.CRIMSONITE, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(19))));

    public static final DeferredItem<Item> AMARYLLIUM_INGOT = ITEMS.register("amaryllium_ingot",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RAW_AMARYLLIUM = ITEMS.register("raw_amaryllium",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<SwordItem> AMARYLLIUM_SWORD = ITEMS.register("amaryllium_sword",
            () -> new SwordItem(AbyssToolMaterials.AMARYLLIUM, new Item.Properties()
                    .attributes(SwordItem.createAttributes(AbyssToolMaterials.AMARYLLIUM, 5, -2.4f))));
    public static final DeferredItem<PickaxeItem> AMARYLLIUM_PICKAXE = ITEMS.register("amaryllium_pickaxe",
            () -> new PickaxeItem(AbyssToolMaterials.AMARYLLIUM, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(AbyssToolMaterials.AMARYLLIUM, 1, -2.8f))));
    public static final DeferredItem<ShovelItem> AMARYLLIUM_SHOVEL = ITEMS.register("amaryllium_shovel",
            () -> new ShovelItem(AbyssToolMaterials.AMARYLLIUM, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(AbyssToolMaterials.AMARYLLIUM, 1.5f, -3.0f))));
    public static final DeferredItem<AxeItem> AMARYLLIUM_AXE = ITEMS.register("amaryllium_axe",
            () -> new AxeItem(AbyssToolMaterials.AMARYLLIUM, new Item.Properties()
                    .attributes(AxeItem.createAttributes(AbyssToolMaterials.AMARYLLIUM, 6.0f, -3.2f))));
    public static final DeferredItem<HoeItem> AMARYLLIUM_HOE = ITEMS.register("amaryllium_hoe",
            () -> new HoeItem(AbyssToolMaterials.AMARYLLIUM, new Item.Properties()
                    .attributes(HoeItem.createAttributes(AbyssToolMaterials.AMARYLLIUM, 0f, -3.0f))));

    public static final DeferredItem<ArmorItem> AMARYLLIUM_HELMET = ITEMS.register("amaryllium_helmet",
            () -> new ArmorItem(AbyssArmorMaterials.AMARYLLIUM, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(19))));
    public static final DeferredItem<ArmorItem> AMARYLLIUM_CHESTPLATE = ITEMS.register("amaryllium_chestplate",
            () -> new ArmorItem(AbyssArmorMaterials.AMARYLLIUM, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(19))));
    public static final DeferredItem<ArmorItem> AMARYLLIUM_LEGGINGS = ITEMS.register("amaryllium_leggings",
            () -> new ArmorItem(AbyssArmorMaterials.AMARYLLIUM, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(19))));
    public static final DeferredItem<ArmorItem> AMARYLLIUM_BOOTS = ITEMS.register("amaryllium_boots",
            () -> new ArmorItem(AbyssArmorMaterials.AMARYLLIUM, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(19))));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}