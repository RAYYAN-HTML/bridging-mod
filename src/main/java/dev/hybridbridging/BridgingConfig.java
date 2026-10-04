package dev.hybridbridging;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.fabricmc.loader.api.FabricLoader;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public final class BridgingConfig {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final Path CONFIG_PATH = FabricLoader.getInstance().getConfigDir().resolve("bridging-mod.json");

    private static BridgingConfig instance;

    public boolean enabled = true;
    public int fallbackSearchRadius = 3;
    public double placementTolerance = 0.25d;
    public boolean edgeAssistance = true;
    public boolean diagonalAssistance = true;

    private BridgingConfig() {
    }

    public static BridgingConfig get() {
        if (instance == null) {
            instance = load();
        }
        return instance;
    }

    public static BridgingConfig load() {
        if (Files.exists(CONFIG_PATH)) {
            try (Reader reader = Files.newBufferedReader(CONFIG_PATH, StandardCharsets.UTF_8)) {
                BridgingConfig loaded = GSON.fromJson(reader, BridgingConfig.class);
                if (loaded != null) {
                    instance = loaded;
                    return loaded;
                }
            } catch (IOException e) {
                HybridBridging.LOGGER.warn("Unable to read config, using defaults", e);
            }
        }
        BridgingConfig defaults = new BridgingConfig();
        save(defaults);
        instance = defaults;
        return defaults;
    }

    public static void save(BridgingConfig config) {
        try (Writer writer = Files.newBufferedWriter(CONFIG_PATH, StandardCharsets.UTF_8)) {
            GSON.toJson(config, writer);
        } catch (IOException e) {
            HybridBridging.LOGGER.warn("Unable to save config", e);
        }
    }
}
