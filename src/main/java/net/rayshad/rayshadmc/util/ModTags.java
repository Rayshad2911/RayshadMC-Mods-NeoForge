package net.rayshad.rayshadmc.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.rayshad.rayshadmc.RayshadMC;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_KROIPNITE_TOOL = createTag("needs_kroipnite_tool");
        public static final TagKey<Block> INCORRECT_FOR_KROIPNITE_TOOL = createTag("incorrecr_for_kroipnite_tool");

        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(RayshadMC.MOD_ID, name));
        }
    }
}
