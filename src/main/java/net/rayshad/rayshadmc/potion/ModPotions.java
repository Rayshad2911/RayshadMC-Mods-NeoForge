package net.rayshad.rayshadmc.potion;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.rayshad.rayshadmc.RayshadMC;
import net.rayshad.rayshadmc.effect.ModEffects;

public class ModPotions {
    public static final DeferredRegister<Potion> POTIONS =
            DeferredRegister.create(BuiltInRegistries.POTION, RayshadMC.MOD_ID);

    public static final Holder<Potion> DECAY_HEALTH = POTIONS.register("decay_health",
            () -> new Potion(new MobEffectInstance(ModEffects.DECAY_EFFECT, 3600, 0)));

    public static void register(IEventBus eventBus) {
        POTIONS.register(eventBus);
    }
}
