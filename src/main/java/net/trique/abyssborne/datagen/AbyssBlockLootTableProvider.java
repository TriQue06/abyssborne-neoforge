package net.trique.abyssborne.datagen;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.trique.abyssborne.block.AbyssBlocks;
import net.trique.abyssborne.item.AbyssItems;

import java.util.Set;

public class AbyssBlockLootTableProvider extends BlockLootSubProvider {

    public AbyssBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        dropSelf(AbyssBlocks.ABYSSTONE.get());
        dropSelf(AbyssBlocks.AMARYLLIUM_BLOCK.get());
        dropSelf(AbyssBlocks.CRIMSONITE_BLOCK.get());
        dropSelf(AbyssBlocks.AZURE_WART_BLOCK.get());
        dropSelf(AbyssBlocks.NIGHT_WART_BLOCK.get());
        dropSelf(AbyssBlocks.AMBER_WART_BLOCK.get());
        dropSelf(AbyssBlocks.NIGHT_ROOTS.get());
        dropSelf(AbyssBlocks.AZURE_ROOTS.get());
        dropSelf(AbyssBlocks.AMBER_ROOTS.get());
        dropSelf(AbyssBlocks.NIGHT_FUNGUS.get());
        dropSelf(AbyssBlocks.AZURE_FUNGUS.get());
        dropSelf(AbyssBlocks.AMBER_FUNGUS.get());
        dropSelf(AbyssBlocks.NIGHT_BUSH.get());
        dropSelf(AbyssBlocks.AZURE_BUSH.get());
        dropSelf(AbyssBlocks.AMBER_BUSH.get());
        dropSelf(AbyssBlocks.NIGHT_HYPHAE.get());
        dropSelf(AbyssBlocks.AZURE_HYPHAE.get());
        dropSelf(AbyssBlocks.AMBER_HYPHAE.get());
        dropSelf(AbyssBlocks.NIGHT_PLANKS.get());
        dropSelf(AbyssBlocks.AZURE_PLANKS.get());
        dropSelf(AbyssBlocks.AMBER_PLANKS.get());

        add(AbyssBlocks.AZURE_NYLIUM.get(),
                block -> createSilkTouchDispatchTable(
                        block,
                        applyExplosionDecay(block, LootItem.lootTableItem(AbyssBlocks.ABYSSTONE.get()))
                ));

        add(AbyssBlocks.NIGHT_NYLIUM.get(),
                block -> createSilkTouchDispatchTable(
                        block,
                        applyExplosionDecay(block, LootItem.lootTableItem(AbyssBlocks.ABYSSTONE.get()))
                ));

        add(AbyssBlocks.AMBER_NYLIUM.get(),
                block -> createSilkTouchDispatchTable(
                        block,
                        applyExplosionDecay(block, LootItem.lootTableItem(AbyssBlocks.ABYSSTONE.get()))
                ));

        add(AbyssBlocks.ABYSS_AMARYLLIUM_ORE.get(),
                b -> createOreDrop(AbyssBlocks.ABYSS_AMARYLLIUM_ORE.get(), AbyssItems.RAW_AMARYLLIUM.get()));
        add(AbyssBlocks.ABYSS_CRIMSONITE_ORE.get(),
                b -> createOreDrop(AbyssBlocks.ABYSS_CRIMSONITE_ORE.get(), AbyssItems.RAW_CRIMSONITE.get()));

        Holder<Enchantment> fortune = this.registries
                .lookupOrThrow(Registries.ENCHANTMENT)
                .getOrThrow(Enchantments.FORTUNE);

        addClusterLoot(AbyssBlocks.STRANGE_CLUSTER.get(), AbyssItems.STRANGE_SHARD.get(), fortune);
        addClusterLoot(AbyssBlocks.WEIRD_CLUSTER.get(),   AbyssItems.WEIRD_SHARD.get(),   fortune);
        addClusterLoot(AbyssBlocks.ODD_CLUSTER.get(),     AbyssItems.ODD_SHARD.get(),     fortune);
    }

    private void addClusterLoot(Block cluster, ItemLike shard, Holder<Enchantment> fortune) {
        add(cluster, b -> createSilkTouchDispatchTable(
                b,
                applyExplosionDecay(b,
                        LootItem.lootTableItem(shard)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 4.0F)))
                                .apply(ApplyBonusCount.addUniformBonusCount(fortune))
                )));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return AbyssBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}