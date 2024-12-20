package identitytheft.configurablecreaking;

import eu.midnightdust.lib.config.MidnightConfig;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConfigurableCreaking implements ModInitializer {
	public static final String MOD_ID = "configurable-creaking";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Starting Configurable Creaking!");

		MidnightConfig.init(MOD_ID, ModConfig.class);
	}
}