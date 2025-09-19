package net.trique.abyssborne.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.trique.abyssborne.Abyssborne;
import net.trique.abyssborne.block.AbyssBlocks;

public class AbyssBlockStateProvider extends BlockStateProvider {

    public AbyssBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Abyssborne.MODID, exFileHelper);
    }

    @SuppressWarnings("removal")
    @Override
    protected void registerStatesAndModels() {
        blockWithItem(AbyssBlocks.ABYSSTONE);
        blockWithItem(AbyssBlocks.ABYSS_AMARYLLIUM_ORE);
        blockWithItem(AbyssBlocks.AMARYLLIUM_BLOCK);
        blockWithItem(AbyssBlocks.ABYSS_CRIMSONITE_ORE);
        blockWithItem(AbyssBlocks.CRIMSONITE_BLOCK);
        blockWithItem(AbyssBlocks.AZURE_WART_BLOCK);
        blockWithItem(AbyssBlocks.NIGHT_WART_BLOCK);
        blockWithItem(AbyssBlocks.AMBER_WART_BLOCK);
        blockWithItem(AbyssBlocks.AZURE_PLANKS);
        blockWithItem(AbyssBlocks.NIGHT_PLANKS);
        blockWithItem(AbyssBlocks.AMBER_PLANKS);

        nyliumBlockWithItem(AbyssBlocks.AZURE_NYLIUM, "abysstone");
        nyliumBlockWithItem(AbyssBlocks.NIGHT_NYLIUM, "abysstone");
        nyliumBlockWithItem(AbyssBlocks.AMBER_NYLIUM, "abysstone");

        crossBlockWithItem2D(AbyssBlocks.NIGHT_ROOTS);
        crossBlockWithItem2D(AbyssBlocks.AZURE_ROOTS);
        crossBlockWithItem2D(AbyssBlocks.AMBER_ROOTS);

        crossBlockWithItem2D(AbyssBlocks.NIGHT_FUNGUS);
        crossBlockWithItem2D(AbyssBlocks.AZURE_FUNGUS);
        crossBlockWithItem2D(AbyssBlocks.AMBER_FUNGUS);

        crossBlockWithItem2D(AbyssBlocks.NIGHT_BUSH);
        crossBlockWithItem2D(AbyssBlocks.AZURE_BUSH);
        crossBlockWithItem2D(AbyssBlocks.AMBER_BUSH);

        clusterBlockWithItem(AbyssBlocks.STRANGE_CLUSTER);
        clusterBlockWithItem(AbyssBlocks.WEIRD_CLUSTER);
        clusterBlockWithItem(AbyssBlocks.ODD_CLUSTER);

        hyphaeBlockWithItem(AbyssBlocks.AZURE_HYPHAE, "azure_stem");
        hyphaeBlockWithItem(AbyssBlocks.NIGHT_HYPHAE, "night_stem");
        hyphaeBlockWithItem(AbyssBlocks.AMBER_HYPHAE, "amber_stem");

    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

    private void nyliumBlockWithItem(DeferredBlock<?> block, String baseBlockTextureName) {
        String name = block.getId().getPath();
        models().cubeBottomTop(
                name,
                modLoc("block/" + name + "_side"),
                modLoc("block/" + baseBlockTextureName),
                modLoc("block/" + name)
        );
        simpleBlockWithItem(block.get(), models().getExistingFile(modLoc(name)));
    }

    private void crossBlockWithItem2D(DeferredBlock<?> block) {
        String name = block.getId().getPath();

        simpleBlock(
                block.get(),
                models().cross(name, modLoc("block/" + name))
                        .renderType("cutout")
        );

        itemModels()
                .withExistingParent(name, mcLoc("item/generated"))
                .texture("layer0", modLoc("block/" + name));
    }

    private void clusterBlockWithItem(DeferredBlock<?> block) {
        String name = block.getId().getPath();

        var blockModel = models()
                .withExistingParent(name, mcLoc("block/cross"))
                .texture("cross", modLoc("block/" + name))
                .renderType("cutout");

        getVariantBuilder(block.get())
                .forAllStatesExcept(state -> {
                    var facing = state.getValue(BlockStateProperties.FACING);
                    int xRot = 0;
                    int yRot = 0;

                    switch (facing) {
                        case UP -> { xRot = 0;   yRot = 0;   }
                        case DOWN -> { xRot = 180; yRot = 0;  }
                        case NORTH -> { xRot = 90;  yRot = 0;  }
                        case SOUTH -> { xRot = 90;  yRot = 180; }
                        case WEST  -> { xRot = 90;  yRot = 270; }
                        case EAST  -> { xRot = 90;  yRot = 90;  }
                    }

                    return ConfiguredModel.builder()
                            .modelFile(blockModel)
                            .rotationX(xRot)
                            .rotationY(yRot)
                            .build();
                }, BlockStateProperties.WATERLOGGED);
    }

    private void hyphaeBlockWithItem(DeferredBlock<?> block, String stemTextureName) {
        String name = block.getId().getPath();

        // hem side hem end aynı stem dokusu
        simpleBlockWithItem(block.get(),
                models().cubeColumn(name,
                        modLoc("block/" + stemTextureName),
                        modLoc("block/" + stemTextureName)
                ));
    }

}