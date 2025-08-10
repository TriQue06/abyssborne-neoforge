package net.trique.abyssborne;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import net.trique.abyssborne.block.AbyssBlocks;
import net.trique.abyssborne.material.AbyssFluids;

@Mod(value = Abyssborne.MODID, dist = Dist.CLIENT)
@EventBusSubscriber(modid = Abyssborne.MODID, value = Dist.CLIENT)
public class AbyssborneClient {

    public AbyssborneClient(ModContainer container) {
        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
    }

    @SubscribeEvent
    static void onClientSetup(FMLClientSetupEvent event) {
        Abyssborne.LOGGER.info("HELLO FROM CLIENT SETUP");
        Abyssborne.LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());

        event.enqueueWork(() -> {
            ItemBlockRenderTypes.setRenderLayer(AbyssBlocks.STRANGE_CLUSTER.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(AbyssBlocks.WEIRD_CLUSTER.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(AbyssBlocks.ODD_CLUSTER.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(AbyssBlocks.ABYSS_PORTAL.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(AbyssBlocks.PURPLE_LAVA.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(AbyssFluids.PURPLE_LAVA, RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(AbyssFluids.FLOWING_PURPLE_LAVA, RenderType.translucent());
        });
    }
}