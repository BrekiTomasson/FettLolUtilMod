package net.brekitomasson.fettlol_util.mixin;

import net.brekitomasson.fettlol_util.base.Handler.DropEggHandler;
import net.brekitomasson.fettlol_util.module.AddEggCollection;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class EggCollectorMixin {

    @Inject(at = @At("HEAD"), method = "onDeath", cancellable = true)
    private void onEggCollectorKill(DamageSource damageSource, CallbackInfo ci) {
        if (!(damageSource.getAttacker() instanceof PlayerEntity)) {
            return;
        }

        PlayerEntity user = (PlayerEntity) damageSource.getAttacker();
        LivingEntity target = (LivingEntity) (Object) this;
        ItemStack mainHandStack = null;

        if (user != null) {
            mainHandStack = user.getMainHandStack();
        }

        if (EnchantmentHelper.getLevel(AddEggCollection.EGG_COLLECTOR, mainHandStack) > 0) {

            if (user.getRandom().nextFloat() <= 0.05F) {

                DropEggHandler.dropSpawnEgg(target);

                target.world.playSound(null, target.getX(), target.getY(), target.getZ(),
                    SoundEvents.ENTITY_FIREWORK_ROCKET_TWINKLE,
                    SoundCategory.PLAYERS, 1.0F, 1.0F
                );
            }
        }

    }
}
