package identitytheft.configurablecreaking.mixin;

import identitytheft.configurablecreaking.ModConfig;
import identitytheft.configurablecreaking.ModDamageTypes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.CreakingEntity;
import net.minecraft.entity.mob.MobEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(MobEntity.class)
public abstract class MobEntityMixin {
    @ModifyVariable(method = "tryAttack", at = @At("STORE"), ordinal = 0)
    private DamageSource damageSource(DamageSource source)
    {
        if (ModConfig.creakingIgnoreArmour && source.getAttacker() instanceof CreakingEntity creaking)
        {
            return ((MobEntity)(Object)this).getDamageSources().create(ModDamageTypes.CREAKING_ATTACK, creaking);
        }

        return source;
    }
}
