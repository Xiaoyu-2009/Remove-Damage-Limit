package net.xiaoyu.remove_damage_limit.init.mixin.miauczel.legendary_monsters.entity.AnimatedMonster.OriginClasses;

import net.miauczel.legendary_monsters.entity.AnimatedMonster.OriginClasses.IAnimatedBoss;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(IAnimatedBoss.class)
public abstract class IAnimatedBossMixin {

    @Redirect(
        method = "hurt",
        at = @At(
            value = "INVOKE",
            target = "Lnet/miauczel/legendary_monsters/entity/AnimatedMonster/OriginClasses/IAnimatedBoss;damageCap()D"
        ),
        require = 0
    )
    public double removeDamageCap(IAnimatedBoss instance) {
        return Float.MAX_VALUE;
    }

    @Redirect(
        method = "hurt",
        at = @At(
            value = "INVOKE",
            target = "Lnet/miauczel/legendary_monsters/entity/AnimatedMonster/OriginClasses/IAnimatedBoss;damageReduction()F"
        ),
        require = 0
    )
    public float removeDamageReduction(IAnimatedBoss instance) {
        return 1.0f;
    }
}