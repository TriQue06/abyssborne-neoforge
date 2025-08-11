package net.trique.abyssborne;

import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.Fluids;
import net.trique.abyssborne.block.AbyssBlocks;
import net.trique.abyssborne.block.AbyssPortalBlock;

public class AbyssPortal {

    public static void register() {
        CustomPortalBuilder.beginPortal()
                .frameBlock(Blocks.SMOOTH_QUARTZ)
                .lightWithFluid(Fluids.LAVA)
                .destDimID(ResourceLocation.fromNamespaceAndPath(Abyssborne.MODID, "the_abyss"))
                .returnDim(Level.NETHER.location(), true)
                .customPortalBlock(() -> (AbyssPortalBlock) AbyssBlocks.ABYSS_PORTAL.get())
                .registerPortal();
    }
}