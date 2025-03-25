package net.rayshad.rayshadmc.entity.custom;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;
import net.rayshad.rayshadmc.entity.ModEntities;
import net.rayshad.rayshadmc.item.ModItems;

public class AmethystGrenadeEntity extends ThrowableItemProjectile {
    public AmethystGrenadeEntity(EntityType<? extends ThrowableItemProjectile> entityType, Level level) {
        super(entityType, level);
    }

    public AmethystGrenadeEntity(LivingEntity livingEntity, Level level) {
        super(ModEntities.AMETHYST_GRENADE.get(), livingEntity, level);
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.AMETHYST_GRENADE.get();
    }

    @Override
    protected void onHit(HitResult result) {
        if(!this.level().isClientSide()) {
            this.level().broadcastEntityEvent(this, ((byte) 3));
            this.level().explode(this, this.getX(), this.getY(), this.getZ(), 3.0F, false, Level.ExplosionInteraction.NONE);
        }

        this.discard();
        super.onHit(result);
    }
}
