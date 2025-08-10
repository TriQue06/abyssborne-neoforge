package net.trique.abyssborne.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.item.armortrim.TrimMaterials;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.trique.abyssborne.Abyssborne;
import net.trique.abyssborne.block.AbyssBlocks;
import net.trique.abyssborne.item.AbyssItems;

import java.util.LinkedHashMap;

public class AbyssItemModelProvider extends ItemModelProvider {
    private static final LinkedHashMap<ResourceKey<TrimMaterial>, Float> trimMaterials = new LinkedHashMap<>();
    static {
        trimMaterials.put(TrimMaterials.QUARTZ, 0.1F);
        trimMaterials.put(TrimMaterials.IRON, 0.2F);
        trimMaterials.put(TrimMaterials.NETHERITE, 0.3F);
        trimMaterials.put(TrimMaterials.REDSTONE, 0.4F);
        trimMaterials.put(TrimMaterials.COPPER, 0.5F);
        trimMaterials.put(TrimMaterials.GOLD, 0.6F);
        trimMaterials.put(TrimMaterials.EMERALD, 0.7F);
        trimMaterials.put(TrimMaterials.DIAMOND, 0.8F);
        trimMaterials.put(TrimMaterials.LAPIS, 0.9F);
        trimMaterials.put(TrimMaterials.AMETHYST, 1.0F);
    }

    public AbyssItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Abyssborne.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(AbyssItems.RAW_AMARYLLIUM.get());
        basicItem(AbyssItems.AMARYLLIUM_INGOT.get());
        basicItem(AbyssItems.RAW_CRIMSONITE.get());
        basicItem(AbyssItems.CRIMSONITE_INGOT.get());
        basicItem(AbyssItems.PURPLE_LAVA_BUCKET.get());
        basicItem(AbyssItems.STRANGE_SHARD.get());
        basicItem(AbyssItems.WEIRD_SHARD.get());
        basicItem(AbyssItems.ODD_SHARD.get());

        flatBlockItem(AbyssBlocks.NIGHT_ROOTS);
        flatBlockItem(AbyssBlocks.AZURE_ROOTS);
        flatBlockItem(AbyssBlocks.AMBER_ROOTS);
        flatBlockItem(AbyssBlocks.NIGHT_FUNGUS);
        flatBlockItem(AbyssBlocks.AZURE_FUNGUS);
        flatBlockItem(AbyssBlocks.AMBER_FUNGUS);
        flatBlockItem(AbyssBlocks.NIGHT_BUSH);
        flatBlockItem(AbyssBlocks.AZURE_BUSH);
        flatBlockItem(AbyssBlocks.AMBER_BUSH);

        flatBlockItem(AbyssBlocks.STRANGE_CLUSTER);
        flatBlockItem(AbyssBlocks.WEIRD_CLUSTER);
        flatBlockItem(AbyssBlocks.ODD_CLUSTER);

        basicItem(AbyssItems.CRIMSONITE_INGOT.get());
        basicItem(AbyssItems.RAW_CRIMSONITE.get());
        handheldItem(AbyssItems.CRIMSONITE_SWORD);
        handheldItem(AbyssItems.CRIMSONITE_PICKAXE);
        handheldItem(AbyssItems.CRIMSONITE_AXE);
        handheldItem(AbyssItems.CRIMSONITE_SHOVEL);
        handheldItem(AbyssItems.CRIMSONITE_HOE);
        trimmedArmorItem(AbyssItems.CRIMSONITE_HELMET);
        trimmedArmorItem(AbyssItems.CRIMSONITE_CHESTPLATE);
        trimmedArmorItem(AbyssItems.CRIMSONITE_LEGGINGS);
        trimmedArmorItem(AbyssItems.CRIMSONITE_BOOTS);

        // === Amaryllium Items ===
        basicItem(AbyssItems.AMARYLLIUM_INGOT.get());
        basicItem(AbyssItems.RAW_AMARYLLIUM.get());
        handheldItem(AbyssItems.AMARYLLIUM_SWORD);
        handheldItem(AbyssItems.AMARYLLIUM_PICKAXE);
        handheldItem(AbyssItems.AMARYLLIUM_AXE);
        handheldItem(AbyssItems.AMARYLLIUM_SHOVEL);
        handheldItem(AbyssItems.AMARYLLIUM_HOE);
        trimmedArmorItem(AbyssItems.AMARYLLIUM_HELMET);
        trimmedArmorItem(AbyssItems.AMARYLLIUM_CHESTPLATE);
        trimmedArmorItem(AbyssItems.AMARYLLIUM_LEGGINGS);
        trimmedArmorItem(AbyssItems.AMARYLLIUM_BOOTS);
    }

    private ItemModelBuilder handheldItem(DeferredItem<?> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/handheld"))
                .texture("layer0", modLoc("item/" + item.getId().getPath()));
    }

    private void flatBlockItem(DeferredBlock<?> block) {
        String name = block.getId().getPath();
        getBuilder(name)
                .parent(getExistingFile(mcLoc("item/generated")))
                .texture("layer0", modLoc("block/" + name));
    }

    private void trimmedArmorItem(DeferredItem<ArmorItem> itemDeferredItem) {
        final String MOD_ID = Abyssborne.MODID;

        if (itemDeferredItem.get() instanceof ArmorItem armorItem) {
            trimMaterials.forEach((trimMaterial, value) -> {
                float trimValue = value;

                String armorType = switch (armorItem.getEquipmentSlot()) {
                    case HEAD -> "helmet";
                    case CHEST -> "chestplate";
                    case LEGS -> "leggings";
                    case FEET -> "boots";
                    default -> "";
                };

                String armorItemPath = armorItem.toString();
                String trimPath = "trims/items/" + armorType + "_trim_" + trimMaterial.location().getPath();
                String currentTrimName = armorItemPath + "_" + trimMaterial.location().getPath() + "_trim";
                ResourceLocation armorItemResLoc = ResourceLocation.parse(armorItemPath);
                ResourceLocation trimResLoc = ResourceLocation.parse(trimPath);
                ResourceLocation trimNameResLoc = ResourceLocation.parse(currentTrimName);

                existingFileHelper.trackGenerated(trimResLoc, PackType.CLIENT_RESOURCES, ".png", "textures");

                getBuilder(currentTrimName)
                        .parent(new ModelFile.UncheckedModelFile("item/generated"))
                        .texture("layer0", armorItemResLoc.getNamespace() + ":item/" + armorItemResLoc.getPath())
                        .texture("layer1", trimResLoc);

                this.withExistingParent(itemDeferredItem.getId().getPath(),
                                mcLoc("item/generated"))
                        .override()
                        .model(new ModelFile.UncheckedModelFile(trimNameResLoc.getNamespace() + ":item/" + trimNameResLoc.getPath()))
                        .predicate(mcLoc("trim_type"), trimValue).end()
                        .texture("layer0",
                                ResourceLocation.fromNamespaceAndPath(MOD_ID,
                                        "item/" + itemDeferredItem.getId().getPath()));
            });
        }
    }
}