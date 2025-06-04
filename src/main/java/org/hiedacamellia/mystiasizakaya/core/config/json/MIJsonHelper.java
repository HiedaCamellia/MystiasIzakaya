package org.hiedacamellia.mystiasizakaya.core.config.json;

import com.google.gson.JsonObject;
import net.minecraft.util.GsonHelper;
import net.neoforged.fml.loading.FMLPaths;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class MIJsonHelper {

    private static final Map<String, JsonObject> jsonMap = new HashMap<>();

    public static void init(){
        Path path = FMLPaths.CONFIGDIR.get();
        if (!path.resolve("mystiasizakaya").toFile().exists()) {
            path.resolve("mystiasizakaya").toFile().mkdirs();
        }
        loadJson("item_price_addon");
        ItemPriceAddon.load();
    }

    private static void loadJson(String fileName) {
        Path path = FMLPaths.CONFIGDIR.get().resolve("mystiasizakaya").resolve(fileName+".json");
        if (!path.toFile().exists()) {
            MystiasIzakaya.LOGGER.debug("MIJsonHelper: File {} does not exist, skipping load.", fileName+".json");
            try {
                Files.writeString(path, "{}");
            } catch (IOException e) {
                MystiasIzakaya.LOGGER.debug("MIJsonHelper: Failed to create empty JSON file for {}: {}", fileName, e.getMessage());
            }
            return;
        }
        try {
            String content = Files.readString(path);
            jsonMap.put(fileName, GsonHelper.parse(content));
        } catch (IOException e) {
            MystiasIzakaya.LOGGER.debug("MIJsonHelper: Failed to load JSON file {}: {}", fileName, e.getMessage());
        } catch (com.google.gson.JsonSyntaxException e) {
            MystiasIzakaya.LOGGER.debug("MIJsonHelper: Invalid JSON syntax in file {}: {}", fileName, e.getMessage());
        }
    }

    public static JsonObject get(String key) {
        return jsonMap.get(key);
    }

    public static void save(String fileName, JsonObject jsonObject) {
        Path path = FMLPaths.CONFIGDIR.get().resolve("mystiasizakaya").resolve(fileName + ".json");
        try {
            Files.writeString(path, jsonObject.toString());
        } catch (IOException e) {
            MystiasIzakaya.LOGGER.debug("MIJsonHelper: Failed to save JSON file {}: {}", fileName, e.getMessage());
        } catch (Exception e) {
            MystiasIzakaya.LOGGER.debug("MIJsonHelper: Unexpected error while saving JSON file {}: {}", fileName, e.getMessage());
        }
    }



}
