package net.rayshad.rayshadmc.sound;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.JukeboxSong;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.rayshad.rayshadmc.RayshadMC;

import java.util.function.Supplier;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, RayshadMC.MOD_ID);

    public static final Supplier<SoundEvent> FUN_RANDOM = registrerSoundEvent("fun_random");
    public static final ResourceKey<JukeboxSong> FUN_RANDOM_KEY = createSong("fun_random");

    public static final Supplier<SoundEvent> PLAYING_ARCADE_GAME = registrerSoundEvent("playing_arcade_game");
    public static final ResourceKey<JukeboxSong> PLAYING_ARCADE_GAME_KEY = createSong("playing_arcade_game");

    private static ResourceKey<JukeboxSong> createSong(String name) {
        return ResourceKey.create(Registries.JUKEBOX_SONG, ResourceLocation.fromNamespaceAndPath(RayshadMC.MOD_ID, name));
    }

    private static Supplier<SoundEvent> registrerSoundEvent(String name) {
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(RayshadMC.MOD_ID, name);
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(id));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
