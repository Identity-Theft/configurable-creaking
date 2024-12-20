package identitytheft.configurablecreaking;

import eu.midnightdust.lib.config.MidnightConfig;
import net.minecraft.util.Identifier;

public class ModConfig extends MidnightConfig {
    public static final String CREAKING = "creaking";
    public static final String BLOSSOM = "blossom";

    @Comment(category = CREAKING, centered = true) public static Comment creakingStats;
    @Entry(category = CREAKING, min = 0f, max = 1024f) public static float creakingSpeed = 0.4f;
    @Entry(category = CREAKING, min = 1f, max = 1024f) public static float creakingDamage = 3.0f;
    @Entry(category = CREAKING) public static boolean creakingIgnoreArmour = false;

    // Eye Blossom
    @Comment(category = BLOSSOM, centered = true) public static Comment blossomPlayerEffect;
    @Entry(category = BLOSSOM) public static boolean enableBlossomOpenEffect = true;
    @Entry(category = BLOSSOM) public static Identifier blossomOpenEffect = Identifier.ofVanilla("darkness");
    @Entry(category = BLOSSOM, min = 1, max = 100000000) public static int blossomOpenEffectDuration = 15;
    @Entry(category = BLOSSOM, min = 0, max = 255) public static int blossomOpenEffectAmplifier = 0;

    @Comment(category = BLOSSOM, centered = true) public static Comment blossomPlayerEffectClosed;
    @Entry(category = BLOSSOM) public static boolean enableBlossomClosedEffect = false;
    @Entry(category = BLOSSOM) public static Identifier blossomClosedEffect = Identifier.ofVanilla("darkness");
    @Entry(category = BLOSSOM, min = 1, max = 100000000) public static int blossomClosedEffectDuration = 15;
    @Entry(category = BLOSSOM, min = 0, max = 255) public static int blossomClosedEffectAmplifier = 0;
}
