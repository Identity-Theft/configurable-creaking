package identitytheft.configurablecreaking.mixin;

import identitytheft.configurablecreaking.ModConfig;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.CreakingEntity;
import net.minecraft.entity.mob.HostileEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(CreakingEntity.class)
public abstract class CreakingMixin {
	/**
	 * @author IdentityTheft
	 * @reason Changed creaking damage and movement speed
	 */
	@Overwrite
	public static DefaultAttributeContainer.Builder createCreakingAttributes() {
		return HostileEntity.createHostileAttributes()
				.add(EntityAttributes.MAX_HEALTH, 1.0F)
				.add(EntityAttributes.MOVEMENT_SPEED, ModConfig.creakingSpeed)
				.add(EntityAttributes.ATTACK_DAMAGE, ModConfig.creakingDamage)
				.add(EntityAttributes.FOLLOW_RANGE, 32.0F)
				.add(EntityAttributes.STEP_HEIGHT, 1.0625F);
	}
}