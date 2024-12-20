package identitytheft.configurablecreaking.mixin;

import identitytheft.configurablecreaking.ConfigurableCreaking;
import identitytheft.configurablecreaking.ModConfig;
import net.minecraft.block.BlockState;
import net.minecraft.block.EyeblossomBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EyeblossomBlock.class)
public abstract class EyeblossomBlockMixin {

    @Shadow @Final private EyeblossomBlock.EyeblossomState state;

    @Unique
    private void applyPlayerEffect(PlayerEntity playerEntity, Identifier id, int duration, int amplifier) {
        var registry = Registries.STATUS_EFFECT;
        var effect = registry.getEntry(id);

        if (effect.isEmpty())
        {
            ConfigurableCreaking.LOGGER.error("\"" + ModConfig.blossomOpenEffect.toString() + "\" is not a valid status effect");
        }

        if (effect.isPresent() && !playerEntity.hasStatusEffect(effect.get())) {
            playerEntity.addStatusEffect(new StatusEffectInstance(effect.get(), duration * 20, amplifier));
        }
    }

    @Inject(method = "onEntityCollision", at = @At("TAIL"))
    private void playerEffect(BlockState state, World world, BlockPos pos, Entity entity, CallbackInfo ci)
    {
        if (!world.isClient() && world.getDifficulty() != Difficulty.PEACEFUL && entity instanceof PlayerEntity playerEntity)
        {
            if (this.state.isOpen() && ModConfig.enableBlossomOpenEffect) {
                applyPlayerEffect(playerEntity, ModConfig.blossomOpenEffect, ModConfig.blossomOpenEffectDuration, ModConfig.blossomOpenEffectAmplifier);
            } else if (!this.state.isOpen() && ModConfig.enableBlossomClosedEffect) {
                applyPlayerEffect(playerEntity, ModConfig.blossomClosedEffect, ModConfig.blossomClosedEffectDuration, ModConfig.blossomClosedEffectAmplifier);
            }
        }
    }
}
