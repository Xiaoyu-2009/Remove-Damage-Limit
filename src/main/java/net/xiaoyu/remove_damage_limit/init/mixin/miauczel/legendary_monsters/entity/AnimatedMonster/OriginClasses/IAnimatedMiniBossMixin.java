package net.xiaoyu.remove_damage_limit.init.mixin.miauczel.legendary_monsters.entity.AnimatedMonster.OriginClasses;

import net.miauczel.legendary_monsters.entity.AnimatedMonster.OriginClasses.IAnimatedMiniBoss;
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
        )
    )
    public double removeDamageCap(IAnimatedMiniBoss instance) {
        return Float.MAX_VALUE;
    }

    @Redirect(
        method = "hurt",
        at = @At(
            value = "INVOKE",
            target = "Lnet/miauczel/legendary_monsters/entity/AnimatedMonster/OriginClasses/IAnimatedMiniBoss;damageReduction()F"
        )
    )
    public float removeDamageReduction(IAnimatedMiniBoss instance) {
        return 1.0f;
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