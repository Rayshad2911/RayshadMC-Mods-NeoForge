package net.rayshad.rayshadmc.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.rayshad.rayshadmc.RayshadMC;

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

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
