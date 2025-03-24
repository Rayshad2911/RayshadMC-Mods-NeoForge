package net.rayshad.rayshadmc.item;

import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.rayshad.rayshadmc.RayshadMC;
import net.rayshad.rayshadmc.sound.ModSounds;

public class ModItems {
    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(RayshadMC.MOD_ID);

    public static final DeferredItem<Item> KROIPNITE = ITEMS.register("kroipnite",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> OPYX_SHARD = ITEMS.register("opyx_shard",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> KROIPNITE_INGOT = ITEMS.register("kroipnite_ingot",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> OPYX_ROCK = ITEMS.register("opyx_rock",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<SwordItem> KROIPNITE_SWORD =ITEMS.register("kroipnite_sword",
            () -> new SwordItem(ModToolTiers.KROIPNITE, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.KROIPNITE, 3, -2.2f))));
    public static final DeferredItem<PickaxeItem> KROIPNITE_PICKAXE = ITEMS.register("kroipnite_pickaxe",
            () -> new PickaxeItem(ModToolTiers.KROIPNITE, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.KROIPNITE, 1, -2.8f))));
    public static final DeferredItem<ShovelItem> KROIPNITE_SHOVEL = ITEMS.register("kroipnite_shovel",
            () -> new ShovelItem(ModToolTiers.KROIPNITE, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.KROIPNITE, 1.5f, -3.0f))));
    public static final DeferredItem<AxeItem> KROIPNITE_AXE = ITEMS.register("kroipnite_axe",
            () -> new AxeItem(ModToolTiers.KROIPNITE, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTiers.KROIPNITE, 4.5f, -2.7f))));
    public static final DeferredItem<HoeItem> KROIPNITE_HOE = ITEMS.register("kroipnite_hoe",
            () -> new HoeItem(ModToolTiers.KROIPNITE, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolTiers.KROIPNITE, -3.5f, 0))));

    public static final DeferredItem<ArmorItem> KROIPNITE_HELMET = ITEMS.register("kroipnite_helmet",
            () -> new ArmorItem(ModArmorMaterials.KROIPNITE_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(24))));
    public static final DeferredItem<ArmorItem> KROIPNITE_CHESTPLATE = ITEMS.register("kroipnite_chestplate",
            () -> new ArmorItem(ModArmorMaterials.KROIPNITE_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(24))));
    public static final DeferredItem<ArmorItem> KROIPNITE_LEGGINGS = ITEMS.register("kroipnite_leggings",
            () -> new ArmorItem(ModArmorMaterials.KROIPNITE_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(24))));
    public static final DeferredItem<ArmorItem> KROIPNITE_BOOTS = ITEMS.register("kroipnite_boots",
            () -> new ArmorItem(ModArmorMaterials.KROIPNITE_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(24))));

    public static final DeferredItem<Item> CORN = ITEMS.register("corn",
            () -> new Item(new Item.Properties().food(ModFoodProperties.CORN)));
    public static final DeferredItem<Item> MASHED_POTATO = ITEMS.register("mashed_potato",
            () -> new Item(new Item.Properties().food(ModFoodProperties.MASHED_POTATO)));

    public static final DeferredItem<Item> MUSIC_DISC_FUN_RANDOM = ITEMS.register("music_disc_fun_random",
            () -> new Item(new Item.Properties().jukeboxPlayable(ModSounds.FUN_RANDOM_KEY).stacksTo(1)));
    public static final DeferredItem<Item> MUSIC_DISC_PLAYING_ARCADE_GAME = ITEMS.register("music_disc_playing_arcade_game",
            () -> new Item(new Item.Properties().jukeboxPlayable(ModSounds.PLAYING_ARCADE_GAME_KEY).stacksTo(1)));

    public static final DeferredItem<Item> ZOMBIE_EYE = ITEMS.register("zombie_eye",
            () -> new Item(new Item.Properties().stacksTo(16)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
