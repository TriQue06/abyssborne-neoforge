package net.trique.abyssborne.worldgen;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.HugeFungusConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.trique.abyssborne.Abyssborne;
import net.trique.abyssborne.block.AbyssBlocks;

import java.util.List;

public class AbyssConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> AMARYLLIUM_ORE_KEY = registerKey("amaryllium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CRIMSONITE_ORE_KEY = registerKey("crimsonite_ore");

    public static final ResourceKey<ConfiguredFeature<?, ?>> NIGHT_ROOTS_PATCH = registerKey("night_roots_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> AZURE_ROOTS_PATCH = registerKey("azure_roots_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> AMBER_ROOTS_PATCH = registerKey("amber_roots_patch");

    public static final ResourceKey<ConfiguredFeature<?, ?>> NIGHT_FUNGUS_PATCH = registerKey("night_fungus_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> AZURE_FUNGUS_PATCH = registerKey("azure_fungus_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> AMBER_FUNGUS_PATCH = registerKey("amber_fungus_patch");

    public static final ResourceKey<ConfiguredFeature<?, ?>> NIGHT_BUSH_PATCH = registerKey("night_bush_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> AZURE_BUSH_PATCH = registerKey("azure_bush_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> AMBER_BUSH_PATCH = registerKey("amber_bush_patch");

    public static final ResourceKey<ConfiguredFeature<?, ?>> STRANGE_CLUSTER_KEY = registerKey("strange_cluster_key");
    public static final ResourceKey<ConfiguredFeature<?, ?>> WEIRD_CLUSTER_KEY   = registerKey("weird_cluster_key");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ODD_CLUSTER_KEY     = registerKey("odd_cluster_key");

    public static final ResourceKey<ConfiguredFeature<?, ?>> AZURE_FUNGUS_PLANTED  = registerKey("azure_fungus_planted");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NIGHT_FUNGUS_PLANTED  = registerKey("night_fungus_planted");
    public static final ResourceKey<ConfiguredFeature<?, ?>> AMBER_FUNGUS_PLANTED  = registerKey("amber_fungus_planted");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest abyssReplaceables = new BlockMatchTest(AbyssBlocks.ABYSSTONE.get());

        register(context, AMARYLLIUM_ORE_KEY, Feature.ORE,
                new OreConfiguration(abyssReplaceables, AbyssBlocks.ABYSS_AMARYLLIUM_ORE.get().defaultBlockState(), 4));

        register(context, CRIMSONITE_ORE_KEY, Feature.ORE,
                new OreConfiguration(abyssReplaceables, AbyssBlocks.ABYSS_CRIMSONITE_ORE.get().defaultBlockState(), 4));

        FeatureUtils.register(
                context, NIGHT_ROOTS_PATCH, Feature.RANDOM_PATCH,
                FeatureUtils.simplePatchConfiguration(
                        Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(AbyssBlocks.NIGHT_ROOTS.get().defaultBlockState())),
                        List.of(AbyssBlocks.NIGHT_NYLIUM.get(), AbyssBlocks.ABYSSTONE.get())
                )
        );

        FeatureUtils.register(
                context, AZURE_ROOTS_PATCH, Feature.RANDOM_PATCH,
                FeatureUtils.simplePatchConfiguration(
                        Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(AbyssBlocks.AZURE_ROOTS.get().defaultBlockState())),
                        List.of(AbyssBlocks.AZURE_NYLIUM.get(), AbyssBlocks.ABYSSTONE.get())
                )
        );

        FeatureUtils.register(
                context, AMBER_ROOTS_PATCH, Feature.RANDOM_PATCH,
                FeatureUtils.simplePatchConfiguration(
                        Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(AbyssBlocks.AMBER_ROOTS.get().defaultBlockState())),
                        List.of(AbyssBlocks.AMBER_NYLIUM.get(), AbyssBlocks.ABYSSTONE.get())
                )
        );

        FeatureUtils.register(
                context, NIGHT_FUNGUS_PATCH, Feature.RANDOM_PATCH,
                FeatureUtils.simplePatchConfiguration(
                        Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(AbyssBlocks.NIGHT_FUNGUS.get().defaultBlockState())),
                        List.of(AbyssBlocks.NIGHT_NYLIUM.get(), AbyssBlocks.ABYSSTONE.get())
                )
        );

        FeatureUtils.register(
                context, AZURE_FUNGUS_PATCH, Feature.RANDOM_PATCH,
                FeatureUtils.simplePatchConfiguration(
                        Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(AbyssBlocks.AZURE_FUNGUS.get().defaultBlockState())),
                        List.of(AbyssBlocks.AZURE_NYLIUM.get(), AbyssBlocks.ABYSSTONE.get())
                )
        );

        FeatureUtils.register(
                context, AMBER_FUNGUS_PATCH, Feature.RANDOM_PATCH,
                FeatureUtils.simplePatchConfiguration(
                        Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(AbyssBlocks.AMBER_FUNGUS.get().defaultBlockState())),
                        List.of(AbyssBlocks.AMBER_NYLIUM.get(), AbyssBlocks.ABYSSTONE.get())
                )
        );

        FeatureUtils.register(
                context, NIGHT_BUSH_PATCH, Feature.RANDOM_PATCH,
                FeatureUtils.simplePatchConfiguration(
                        Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(AbyssBlocks.NIGHT_BUSH.get().defaultBlockState())),
                        List.of(AbyssBlocks.NIGHT_NYLIUM.get(), AbyssBlocks.ABYSSTONE.get())
                )
        );

        FeatureUtils.register(
                context, AZURE_BUSH_PATCH, Feature.RANDOM_PATCH,
                FeatureUtils.simplePatchConfiguration(
                        Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(AbyssBlocks.AZURE_BUSH.get().defaultBlockState())),
                        List.of(AbyssBlocks.AZURE_NYLIUM.get(), AbyssBlocks.ABYSSTONE.get())
                )
        );

        FeatureUtils.register(
                context, AMBER_BUSH_PATCH, Feature.RANDOM_PATCH,
                FeatureUtils.simplePatchConfiguration(
                        Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(AbyssBlocks.AMBER_BUSH.get().defaultBlockState())),
                        List.of(AbyssBlocks.AMBER_NYLIUM.get(), AbyssBlocks.ABYSSTONE.get())
                )
        );

        FeatureUtils.register(
                context, STRANGE_CLUSTER_KEY, Feature.RANDOM_PATCH,
                FeatureUtils.simplePatchConfiguration(
                        Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(AbyssBlocks.STRANGE_CLUSTER.get().defaultBlockState())),
                        List.of(AbyssBlocks.ABYSSTONE.get())
                )
        );

        FeatureUtils.register(
                context, WEIRD_CLUSTER_KEY, Feature.RANDOM_PATCH,
                FeatureUtils.simplePatchConfiguration(
                        Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(AbyssBlocks.WEIRD_CLUSTER.get().defaultBlockState())),
                        List.of(AbyssBlocks.ABYSSTONE.get())
                )
        );

        FeatureUtils.register(
                context, ODD_CLUSTER_KEY, Feature.RANDOM_PATCH,
                FeatureUtils.simplePatchConfiguration(
                        Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(AbyssBlocks.ODD_CLUSTER.get().defaultBlockState())),
                        List.of(AbyssBlocks.ABYSSTONE.get())
                )
        );

        BlockPredicate predicate = dangerousBlockPredicate();
        BlockState SHROOMLIGHT = Blocks.SHROOMLIGHT.defaultBlockState();

        register(context, AZURE_FUNGUS_PLANTED, Feature.HUGE_FUNGUS,
                new HugeFungusConfiguration(
                        AbyssBlocks.AZURE_NYLIUM.get().defaultBlockState(),
                        Blocks.OAK_LOG.defaultBlockState(),
                        AbyssBlocks.AZURE_WART_BLOCK.get().defaultBlockState(),
                        SHROOMLIGHT, predicate, true));

        register(context, NIGHT_FUNGUS_PLANTED, Feature.HUGE_FUNGUS,
                new HugeFungusConfiguration(
                        AbyssBlocks.NIGHT_NYLIUM.get().defaultBlockState(),
                        Blocks.OAK_LOG.defaultBlockState(),
                        AbyssBlocks.NIGHT_WART_BLOCK.get().defaultBlockState(),
                        SHROOMLIGHT, predicate, true));

        register(context, AMBER_FUNGUS_PLANTED, Feature.HUGE_FUNGUS,
                new HugeFungusConfiguration(
                        AbyssBlocks.AMBER_NYLIUM.get().defaultBlockState(),
                        Blocks.OAK_LOG.defaultBlockState(),
                        AbyssBlocks.AMBER_WART_BLOCK.get().defaultBlockState(),
                        SHROOMLIGHT, predicate, true));
    }

    private static BlockPredicate dangerousBlockPredicate() {
        return BlockPredicate.matchesBlocks(List.of(
                Blocks.OAK_SAPLING, Blocks.SPRUCE_SAPLING, Blocks.BIRCH_SAPLING, Blocks.JUNGLE_SAPLING,
                Blocks.ACACIA_SAPLING, Blocks.CHERRY_SAPLING, Blocks.DARK_OAK_SAPLING, Blocks.MANGROVE_PROPAGULE,
                Blocks.DANDELION, Blocks.TORCHFLOWER, Blocks.POPPY, Blocks.BLUE_ORCHID, Blocks.ALLIUM,
                Blocks.AZURE_BLUET, Blocks.RED_TULIP, Blocks.ORANGE_TULIP, Blocks.WHITE_TULIP, Blocks.PINK_TULIP,
                Blocks.OXEYE_DAISY, Blocks.CORNFLOWER, Blocks.WITHER_ROSE, Blocks.LILY_OF_THE_VALLEY,
                Blocks.BROWN_MUSHROOM, Blocks.RED_MUSHROOM, Blocks.WHEAT, Blocks.SUGAR_CANE,
                Blocks.ATTACHED_PUMPKIN_STEM, Blocks.ATTACHED_MELON_STEM, Blocks.PUMPKIN_STEM, Blocks.MELON_STEM,
                Blocks.LILY_PAD, Blocks.NETHER_WART, Blocks.COCOA, Blocks.CARROTS, Blocks.POTATOES,
                Blocks.CHORUS_PLANT, Blocks.CHORUS_FLOWER, Blocks.TORCHFLOWER_CROP, Blocks.PITCHER_CROP,
                Blocks.BEETROOTS, Blocks.SWEET_BERRY_BUSH, Blocks.WEEPING_VINES, Blocks.WEEPING_VINES_PLANT,
                Blocks.TWISTING_VINES, Blocks.TWISTING_VINES_PLANT, Blocks.CAVE_VINES, Blocks.CAVE_VINES_PLANT,
                Blocks.SPORE_BLOSSOM, Blocks.AZALEA, Blocks.FLOWERING_AZALEA, Blocks.MOSS_CARPET, Blocks.PINK_PETALS,
                Blocks.BIG_DRIPLEAF, Blocks.BIG_DRIPLEAF_STEM, Blocks.SMALL_DRIPLEAF
        ));
    }

    private static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE,
                ResourceLocation.fromNamespaceAndPath(Abyssborne.MODID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(
            BootstrapContext<ConfiguredFeature<?, ?>> context,
            ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration
    ) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
