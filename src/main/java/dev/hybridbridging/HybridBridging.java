package dev.hybridbridging;

import net.fabricmc.api.ClientModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class HybridBridging implements ClientModInitializer {
    public static final String MOD_ID = "bridging-mod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitializeClient() {
        BridgingConfig.load();
        LOGGER.info("Hybrid Bridging loaded");
    }
}
