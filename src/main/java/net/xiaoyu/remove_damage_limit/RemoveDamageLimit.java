package net.xiaoyu.remove_damage_limit;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.ModLoadingContext;
import net.xiaoyu.remove_damage_limit.common.config.RemoveDamageLimitConfig;

@Mod(RemoveDamageLimit.MOD_ID)
public class RemoveDamageLimit {
    public static final String MOD_ID = "remove_damage_limit";

    @SuppressWarnings("removal")
    public RemoveDamageLimit() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, RemoveDamageLimitConfig.CONFIG_SPEC);
    }
}