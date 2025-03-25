package net.rayshad.rayshadmc.entity;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.rayshad.rayshadmc.RayshadMC;
import net.rayshad.rayshadmc.entity.custom.AmethystGrenadeEntity;

import java.util.function.Supplier;

public class ModEntities {
    public static DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, RayshadMC.MOD_ID);

    public static final Supplier<EntityType<AmethystGrenadeEntity>> AMETHYST_GRENADE =
            ENTITY_TYPES.register("amethyst_grenade", () -> EntityType.Builder.<AmethystGrenadeEntity>of(AmethystGrenadeEntity::new, MobCategory.MISC)
                    .sized(0.5f, 0.5f).build("amethyst_grenade"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
