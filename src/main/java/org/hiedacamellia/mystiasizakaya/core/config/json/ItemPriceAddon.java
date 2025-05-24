package org.hiedacamellia.mystiasizakaya.core.config.json;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.mojang.serialization.Codec;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.neoforge.network.PacketDistributor;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;
import org.hiedacamellia.mystiasizakaya.core.network.ItemPriceAddonSyncBiMessage;

import java.util.HashMap;
import java.util.Map;

public class ItemPriceAddon {

    private static Map<String, Integer> itemPriceMap = new HashMap<>();

    public static Codec<Map<String, Integer>> CODEC = Codec.unboundedMap(Codec.STRING, Codec.INT);
    public static StreamCodec<ByteBuf,Map<String, Integer>> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.fromCodec(CODEC),
            (e)->e,
            HashMap::new
    );

    public static void setItemPriceMap(Map<String, Integer> map) {
        itemPriceMap = map;
    }
    public static Map<String, Integer> getItemPriceMap() {
        return itemPriceMap;
    }

    public static void load(){
        JsonObject itemPriceAddon = MIJsonHelper.get("item_price_addon");
        try{
            JsonArray asJsonArray = itemPriceAddon.get("item_price").getAsJsonArray();
            for (int i = 0; i < asJsonArray.size(); i++) {
                JsonObject jsonObject = asJsonArray.get(i).getAsJsonObject();
                String itemId = jsonObject.get("item").getAsString();
                int price = jsonObject.get("price").getAsInt();
                itemPriceMap.put(itemId, price);
            }
            MystiasIzakaya.LOGGER.info("ItemPriceAddon loaded with " + itemPriceMap.size() + " items");
        } catch (Exception e) {
            MystiasIzakaya.LOGGER.debug("ItemPriceAddon load error: " + e.getMessage());
        }
    }

    public static void reload() {
        itemPriceMap.clear();
        load();
    }

    public static Integer getPrice(ResourceLocation resourceLocation) {
        return getPrice(resourceLocation.toString());
    }
    public static Integer getPrice(String itemId) {
        return itemPriceMap.getOrDefault(itemId, 0);
    }

    public static void save() {
        JsonArray jsonElements = new JsonArray();
        for (Map.Entry<String, Integer> entry : itemPriceMap.entrySet()) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("item", entry.getKey());
            jsonObject.addProperty("price", entry.getValue());
            jsonElements.add(jsonObject);
        }
        JsonObject itemPriceAddon = new JsonObject();
        itemPriceAddon.add("item_price", jsonElements);
        MIJsonHelper.save("item_price_addon",itemPriceAddon );
    }

    public static void sync2Client() {
        PacketDistributor.sendToAllPlayers(new ItemPriceAddonSyncBiMessage(itemPriceMap));
    }
    public static void sync(ServerPlayer player) {
        PacketDistributor.sendToPlayer(player,new ItemPriceAddonSyncBiMessage(itemPriceMap));
    }

    public static void send2Server(){
        PacketDistributor.sendToServer(new ItemPriceAddonSyncBiMessage(itemPriceMap));
    }

}
