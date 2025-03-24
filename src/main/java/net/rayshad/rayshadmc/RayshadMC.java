package net.rayshad.rayshadmc;

import com.mojang.logging.LogUtils;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.rayshad.rayshadmc.block.ModBlocks;
import net.rayshad.rayshadmc.item.ModItems;
import org.slf4j.Logger;

@Mod(RayshadMC.MOD_ID)
public class RayshadMC {
    public static final String MOD_ID = "rayshadmc";
    private static final Logger LOGGER = LogUtils.getLogger();

    public RayshadMC(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);
        NeoForge.EVENT_BUS.register(this);

        ModBlocks.register(modEventBus);
        ModItems.register(modEventBus);

        modEventBus.addListener(this::addCreative);
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.KROIPNITE);
            event.accept(ModItems.OPYX_SHARD);
            event.accept(ModItems.KROIPNITE_INGOT);
            event.accept(ModItems.OPYX_ROCK);
        }

        if(event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(ModBlocks.KROIPNITE_BLOCK);
            event.accept(ModBlocks.OPYX_BLOCK);
            event.accept(ModBlocks.OPYX_HARDENED_BLOCK);
        }

        if(event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
            event.accept(ModBlocks.KROIPNITE_ORE);
            event.accept(ModBlocks.DEEPSLATE_KROIPNITE_ORE);
            event.accept(ModBlocks.OPYX_SOIL);
        }
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    @EventBusSubscriber(modid = MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }
}
