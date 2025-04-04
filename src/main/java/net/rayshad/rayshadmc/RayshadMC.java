package net.rayshad.rayshadmc;

import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
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
import net.rayshad.rayshadmc.block.entity.ModBlockEntities;
import net.rayshad.rayshadmc.effect.ModEffects;
import net.rayshad.rayshadmc.entity.ModEntities;
import net.rayshad.rayshadmc.item.ModItems;
import net.rayshad.rayshadmc.loot.ModLootModifiers;
import net.rayshad.rayshadmc.potion.ModPotions;
import net.rayshad.rayshadmc.sound.ModSounds;
import net.rayshad.rayshadmc.util.ModWoodTypes;
import org.slf4j.Logger;

@Mod(RayshadMC.MOD_ID)
public class RayshadMC {
    public static final String MOD_ID = "rayshadmc";
    private static final Logger LOGGER = LogUtils.getLogger();

    public RayshadMC(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);
        NeoForge.EVENT_BUS.register(this);

        ModBlocks.register(modEventBus);
        ModBlockEntities.register(modEventBus);
        ModEffects.register(modEventBus);
        ModEntities.register(modEventBus);
        ModItems.register(modEventBus);
        ModLootModifiers.register(modEventBus);
        ModPotions.register(modEventBus);
        ModSounds.register(modEventBus);

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
            event.accept(ModItems.ZOMBIE_EYE);
        }

        if(event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(ModBlocks.MAPLE_LOG);
            event.accept(ModBlocks.CHORUS_STEM);
            event.accept(ModBlocks.MAPLE_WOOD);
            event.accept(ModBlocks.CHORUS_HYPHAE);
            event.accept(ModBlocks.STRIPPED_MAPLE_LOG);
            event.accept(ModBlocks.PALE_CHORUS_STEM);
            event.accept(ModBlocks.STRIPPED_MAPLE_WOOD);
            event.accept(ModBlocks.PALE_CHORUS_HYPHAE);
            event.accept(ModBlocks.MAPLE_PLANKS);
            event.accept(ModBlocks.CHORUS_PLANKS);
            event.accept(ModBlocks.PALE_CHORUS_PLANKS);
            event.accept(ModBlocks.MAPLE_STAIRS);
            event.accept(ModBlocks.CHORUS_STAIRS);
            event.accept(ModBlocks.PALE_CHORUS_STAIRS);
            event.accept(ModBlocks.MAPLE_SLAB);
            event.accept(ModBlocks.CHORUS_SLAB);
            event.accept(ModBlocks.PALE_CHORUS_SLAB);
            event.accept(ModBlocks.MAPLE_FENCE);
            event.accept(ModBlocks.CHORUS_FENCE);
            event.accept(ModBlocks.PALE_CHORUS_FENCE);
            event.accept(ModBlocks.MAPLE_FENCE_GATE);
            event.accept(ModBlocks.CHORUS_FENCE_GATE);
            event.accept(ModBlocks.PALE_CHORUS_FENCE_GATE);
            event.accept(ModBlocks.MAPLE_DOOR);
            event.accept(ModBlocks.CHORUS_DOOR);
            event.accept(ModBlocks.PALE_CHORUS_DOOR);
            event.accept(ModBlocks.MAPLE_TRAPDOOR);
            event.accept(ModBlocks.CHORUS_TRAPDOOR);
            event.accept(ModBlocks.PALE_CHORUS_TRAPDOOR);
            event.accept(ModBlocks.MAPLE_PRESSURE_PLATE);
            event.accept(ModBlocks.CHORUS_PRESSURE_PLATE);
            event.accept(ModBlocks.PALE_CHORUS_PRESSURE_PLATE);
            event.accept(ModBlocks.MAPLE_BUTTON);
            event.accept(ModBlocks.CHORUS_BUTTON);
            event.accept(ModBlocks.PALE_CHORUS_BUTTON);
            event.accept(ModBlocks.KROIPNITE_BLOCK);
            event.accept(ModBlocks.OPYX_BLOCK);
            event.accept(ModBlocks.OPYX_HARDENED_BLOCK);
        }

        if(event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
            event.accept(ModBlocks.KROIPNITE_ORE);
            event.accept(ModBlocks.DEEPSLATE_KROIPNITE_ORE);
            event.accept(ModBlocks.OPYX_SOIL);
            event.accept(ModBlocks.MAPLE_LOG);
            event.accept(ModBlocks.CHORUS_STEM);
            event.accept(ModBlocks.MAPLE_LEAVES);
            event.accept(ModBlocks.CHORUS_LEAVES);
            event.accept(ModBlocks.MAPLE_SAPLING);
            event.accept(ModBlocks.CHORUS_TREE_SEED);
            event.accept(ModBlocks.PALE_CHORUS_TREE_SEED);
            event.accept(ModItems.CORN_SEEDS);
        }

        if(event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(ModItems.KROIPNITE_SHOVEL);
            event.accept(ModItems.KROIPNITE_PICKAXE);
            event.accept(ModItems.KROIPNITE_AXE);
            event.accept(ModItems.KROIPNITE_HOE);

            event.accept(ModItems.MUSIC_DISC_FUN_RANDOM);
            event.accept(ModItems.MUSIC_DISC_PLAYING_ARCADE_GAME);
        }

        if(event.getTabKey() == CreativeModeTabs.COMBAT) {
            event.accept(ModItems.KROIPNITE_SWORD);

            event.accept(ModItems.KROIPNITE_HELMET);
            event.accept(ModItems.KROIPNITE_CHESTPLATE);
            event.accept(ModItems.KROIPNITE_LEGGINGS);
            event.accept(ModItems.KROIPNITE_BOOTS);

            event.accept(ModItems.AMETHYST_GRENADE);
        }

        if(event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
            event.accept(ModItems.CORN);
            event.accept(ModItems.MASHED_POTATO);
        }

        if(event.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS) {
            event.accept(ModBlocks.MAPLE_SIGN);
            event.accept(ModBlocks.CHORUS_SIGN);
            event.accept(ModBlocks.PALE_CHORUS_SIGN);
            event.accept(ModBlocks.MAPLE_HANGING_SIGN);
        }
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    @EventBusSubscriber(modid = MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            Sheets.addWoodType(ModWoodTypes.MAPLE);
            Sheets.addWoodType(ModWoodTypes.CHORUS);
            Sheets.addWoodType(ModWoodTypes.PALE_CHORUS);

            EntityRenderers.register(ModEntities.AMETHYST_GRENADE.get(), ThrownItemRenderer::new);
        }
    }
}
