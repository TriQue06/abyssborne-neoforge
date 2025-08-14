package net.trique.abyssborne.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.trique.abyssborne.Abyssborne;
import net.trique.abyssborne.worldgen.AbyssBiomeModifiers;
import net.trique.abyssborne.worldgen.AbyssConfiguredFeatures;
import net.trique.abyssborne.worldgen.AbyssPlacedFeatures;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class AbyssDatapackProvider extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, AbyssConfiguredFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, AbyssPlacedFeatures::bootstrap)
            .add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, AbyssBiomeModifiers::bootstrap);

    public AbyssDatapackProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(Abyssborne.MODID));
    }
}