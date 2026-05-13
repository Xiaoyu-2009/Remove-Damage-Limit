package net.xiaoyu.remove_damage_limit.init.mixin.miauczel.legendary_monsters.entity.AnimatedMonster.OriginClasses;

import net.miauczel.legendary_monsters.entity.AnimatedMonster.OriginClasses.IAnimatedBoss;
import net.xiaoyu.remove_damage_limit.common.config.RemoveDamageLimitConfig;
import net.minecraft.world.entity.EntityType;
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
        if (RemoveDamageLimitConfig.ENABLED_BOSSES.get().contains(EntityType.getKey(instance.getType()).toString())) {
            return Float.MAX_VALUE;
        }
        return instance.damageCap();
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
        if (RemoveDamageLimitConfig.ENABLED_BOSSES.get().contains(EntityType.getKey(instance.getType()).toString())) {
            return 1.0f;
        }
        return instance.damageReduction();
    }
}