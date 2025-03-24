package net.rayshad.rayshadmc.effect;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.rayshad.rayshadmc.RayshadMC;

public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(BuiltInRegistries.MOB_EFFECT, RayshadMC.MOD_ID);

    public static final Holder<MobEffect> DECAY_EFFECT = MOB_EFFECTS.register("decay",
            () -> new DecayEffect(MobEffectCategory.HARMFUL, 0xff4655)
                    .addAttributeModifier(Attributes.MAX_HEALTH, ResourceLocation.fromNamespaceAndPath(RayshadMC.MOD_ID, "decay"),
                            -0.8f, AttributeModifier.Operation.ADD_MULTIPLIED_BASE));

    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}
