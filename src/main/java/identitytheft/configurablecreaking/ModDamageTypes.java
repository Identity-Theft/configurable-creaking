package identitytheft.configurablecreaking;

import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModDamageTypes {
    public static final RegistryKey<DamageType> CREAKING_ATTACK = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, Identifier.of(ConfigurableCreaking.MOD_ID, "creaking_attack"));
}
