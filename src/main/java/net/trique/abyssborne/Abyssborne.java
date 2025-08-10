package net.trique.abyssborne;

import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.trique.abyssborne.block.AbyssBlocks;
import net.trique.abyssborne.item.AbyssCreativeModeTabs;
import net.trique.abyssborne.item.AbyssItems;
import net.trique.abyssborne.material.AbyssFluidTypes;
import net.trique.abyssborne.material.AbyssFluids;
import net.trique.abyssborne.sound.AbyssSounds;
import org.slf4j.Logger;

@Mod(Abyssborne.MODID)
public class Abyssborne {
    public static final String MODID = "abyssborne";
    public static final Logger LOGGER = LogUtils.getLogger();

    public Abyssborne(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);
        NeoForge.EVENT_BUS.register(this);
        AbyssFluidTypes.register(modEventBus);
        AbyssCreativeModeTabs.register(modEventBus);
        AbyssItems.register(modEventBus);
        AbyssBlocks.register(modEventBus);
        AbyssSounds.register(modEventBus);
        modEventBus.addListener(this::addCreative);
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        LOGGER.info("Things are working fine, probably.");
        event.enqueueWork(() -> {
            AbyssPortal.register();
            AbyssFluids.bootstrap();
        });
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        LOGGER.info("Abyssborne works properly!");
    }
}