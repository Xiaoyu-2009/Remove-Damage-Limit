package net.xiaoyu.remove_damage_limit.common.config;

import net.minecraftforge.common.ForgeConfigSpec;

import java.util.Arrays;
import java.util.List;

public class RemoveDamageLimitConfig {
    public static final ForgeConfigSpec.ConfigValue<List<? extends String>> ENABLED_BOSSES;
    public static final ForgeConfigSpec CONFIG_SPEC;

    static {
        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();
        builder.push("Damage Cap Removal Boss List");
        ENABLED_BOSSES = builder.defineList("Enabled Bosses", Arrays.asList(
                "legendary_monsters:posessed_paladin",
                "legendary_monsters:skeletosaurus",
                "legendary_monsters:frostbitten_golem",
                "legendary_monsters:ancient_guardian",
                "legendary_monsters:lava_eater",
                "legendary_monsters:withered_abomination",
                "legendary_monsters:shulker_mimic",
                "legendary_monsters:overgrown_colossus",
                "legendary_monsters:annihilation_pursuer",
                "legendary_monsters:cloud_golem",
                "legendary_monsters:the_obliterator"
        ), o -> true);
        builder.pop();
        CONFIG_SPEC = builder.build();
    }
}