package net.rayshad.rayshadmc.renderer;

import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.HangingSignBlockEntity;
import net.rayshad.rayshadmc.RayshadMC;

public class ModHangingSignBlockEntityRenderer extends HangingSignRenderer {
    private static final ResourceLocation MAPLE_HANGING_SIGN_GUI =
            ResourceLocation.fromNamespaceAndPath(RayshadMC.MOD_ID, "textures/gui/hanging_signs/maple.png");

    public ModHangingSignBlockEntityRenderer(BlockEntityRendererProvider.Context context) {
        super(context);
    }

    public ResourceLocation getTexture(HangingSignBlockEntity blockEntity) {
        return MAPLE_HANGING_SIGN_GUI;
    }
}
