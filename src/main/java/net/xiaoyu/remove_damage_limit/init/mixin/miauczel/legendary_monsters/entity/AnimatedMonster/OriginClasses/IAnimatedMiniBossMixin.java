package net.xiaoyu.remove_damage_limit.init.mixin.miauczel.legendary_monsters.entity.AnimatedMonster.OriginClasses;

import net.miauczel.legendary_monsters.entity.AnimatedMonster.OriginClasses.IAnimatedMiniBoss;
import net.xiaoyu.remove_damage_limit.common.config.RemoveDamageLimitConfig;
import net.minecraft.world.entity.EntityType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(IAnimatedMiniBoss.class)
public abstract class IAnimatedMiniBossMixin {

    @Redirect(
        method = "hurt",
        at = @At(
            value = "INVOKE",
            target = "Lnet/miauczel/legendary_monsters/entity/AnimatedMonster/OriginClasses/IAnimatedMiniBoss;damageCap()D"
        ),
        require = 0
    )
    public double removeDamageCap(IAnimatedMiniBoss instance) {
        if (RemoveDamageLimitConfig.ENABLED_BOSSES.get().contains(EntityType.getKey(instance.getType()).toString())) {
            return Float.MAX_VALUE;
        }
        return instance.damageCap();
    }

    @Redirect(
        method = "hurt",
        at = @At(
            value = "INVOKE",
            target = "Lnet/miauczel/legendary_monsters/entity/AnimatedMonster/OriginClasses/IAnimatedMiniBoss;damageReduction()F"
        ),
        require = 0
    )
    public float removeDamageReduction(IAnimatedMiniBoss instance) {
        if (RemoveDamageLimitConfig.ENABLED_BOSSES.get().contains(EntityType.getKey(instance.getType()).toString())) {
            return 1.0f;
        }
        return instance.damageReduction();
    }

    /*@Redirect(
        method = "tick",
        at = @At(
            value = "INVOKE",
            target = "Lnet/miauczel/legendary_monsters/entity/AnimatedMonster/OriginClasses/IAnimatedMiniBoss;regainHealthWithoutTarget(FF)V"
        )
    )
    public void removeNaturalHealing(IAnimatedMiniBoss instance, float health, float speed) {}*/

    /*@Redirect(
        method = "hurt",
        at = @At(
            value = "INVOKE",
            target = "Lnet/miauczel/legendary_monsters/entity/AnimatedMonster/OriginClasses/IAnimatedMiniBoss;isTargetCheesing(FF)Z"
        )
    )
    public boolean removeHeightProtection(IAnimatedMiniBoss instance, float minHeight, float maxHeight) {
        return false;
    }*/
}