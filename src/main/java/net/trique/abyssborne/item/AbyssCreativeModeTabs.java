package net.trique.abyssborne.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.trique.abyssborne.Abyssborne;
import net.trique.abyssborne.block.AbyssBlocks;

import java.util.function.Supplier;

public class AbyssCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
        DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Abyssborne.MODID);

    public static final Supplier<CreativeModeTab> ABYSS_ITEMS_TAB = CREATIVE_MODE_TAB.register("abyss_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(AbyssItems.AMARYLLIUM_INGOT.get()))
                    .title(Component.translatable("creativetab.abyssborne.abyss_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(AbyssItems.PURPLE_LAVA_BUCKET);
                        output.accept(AbyssItems.STRANGE_SHARD);
                        output.accept(AbyssItems.WEIRD_SHARD);
                        output.accept(AbyssItems.ODD_SHARD);

                        output.accept(AbyssItems.CRIMSONITE_INGOT.get());
                        output.accept(AbyssItems.RAW_CRIMSONITE.get());
                        output.accept(AbyssItems.CRIMSONITE_SWORD.get());
                        output.accept(AbyssItems.CRIMSONITE_PICKAXE.get());
                        output.accept(AbyssItems.CRIMSONITE_AXE.get());
                        output.accept(AbyssItems.CRIMSONITE_SHOVEL.get());
                        output.accept(AbyssItems.CRIMSONITE_HOE.get());
                        output.accept(AbyssItems.CRIMSONITE_HELMET.get());
                        output.accept(AbyssItems.CRIMSONITE_CHESTPLATE.get());
                        output.accept(AbyssItems.CRIMSONITE_LEGGINGS.get());
                        output.accept(AbyssItems.CRIMSONITE_BOOTS.get());

                        output.accept(AbyssItems.AMARYLLIUM_INGOT.get());
                        output.accept(AbyssItems.RAW_AMARYLLIUM.get());
                        output.accept(AbyssItems.AMARYLLIUM_SWORD.get());
                        output.accept(AbyssItems.AMARYLLIUM_PICKAXE.get());
                        output.accept(AbyssItems.AMARYLLIUM_AXE.get());
                        output.accept(AbyssItems.AMARYLLIUM_SHOVEL.get());
                        output.accept(AbyssItems.AMARYLLIUM_HOE.get());
                        output.accept(AbyssItems.AMARYLLIUM_HELMET.get());
                        output.accept(AbyssItems.AMARYLLIUM_CHESTPLATE.get());
                        output.accept(AbyssItems.AMARYLLIUM_LEGGINGS.get());
                        output.accept(AbyssItems.AMARYLLIUM_BOOTS.get());
                    }).build());

    public static final Supplier<CreativeModeTab> ABYSS_BLOCKS_TAB = CREATIVE_MODE_TAB.register("abyss_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(AbyssBlocks.ABYSSTONE))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(Abyssborne.MODID, "abyss_items_tab"))
                    .title(Component.translatable("creativetab.abyssborne.abyss_blocks"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(AbyssBlocks.ABYSSTONE);
                        output.accept(AbyssBlocks.ABYSS_AMARYLLIUM_ORE);
                        output.accept(AbyssBlocks.AMARYLLIUM_BLOCK);
                        output.accept(AbyssBlocks.ABYSS_CRIMSONITE_ORE);
                        output.accept(AbyssBlocks.CRIMSONITE_BLOCK);
                        output.accept(AbyssBlocks.NIGHT_NYLIUM);
                        output.accept(AbyssBlocks.AZURE_NYLIUM);
                        output.accept(AbyssBlocks.AMBER_NYLIUM);
                        output.accept(AbyssBlocks.AZURE_ROOTS);
                        output.accept(AbyssBlocks.NIGHT_ROOTS);
                        output.accept(AbyssBlocks.AMBER_ROOTS);
                        output.accept(AbyssBlocks.AZURE_FUNGUS);
                        output.accept(AbyssBlocks.NIGHT_FUNGUS);
                        output.accept(AbyssBlocks.AMBER_FUNGUS);
                        output.accept(AbyssBlocks.AZURE_BUSH);
                        output.accept(AbyssBlocks.NIGHT_BUSH);
                        output.accept(AbyssBlocks.AMBER_BUSH);
                        output.accept(AbyssBlocks.STRANGE_CLUSTER);
                        output.accept(AbyssBlocks.WEIRD_CLUSTER);
                        output.accept(AbyssBlocks.ODD_CLUSTER);
                        output.accept(AbyssBlocks.AZURE_NYLIUM_MASS);
                        output.accept(AbyssBlocks.NIGHT_NYLIUM_MASS);
                        output.accept(AbyssBlocks.AMBER_NYLIUM_MASS);
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}