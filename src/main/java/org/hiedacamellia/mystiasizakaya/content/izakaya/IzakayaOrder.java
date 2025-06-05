package org.hiedacamellia.mystiasizakaya.content.izakaya;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.network.PacketDistributor;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;
import org.hiedacamellia.mystiasizakaya.api.event.OrderEvent;
import org.hiedacamellia.mystiasizakaya.core.util.MIEventUtil;
import org.hiedacamellia.mystiasizakaya.core.network.IzakayaOrderSyncS2CMessage;
import org.hiedacamellia.mystiasizakaya.core.network.OrderAddS2CMessage;
import org.hiedacamellia.mystiasizakaya.core.network.OrderRemoveS2CMessage;
import org.hiedacamellia.mystiasizakaya.core.util.MICodecUtil;
import org.hiedacamellia.mystiasizakaya.core.util.MIItemStackUtil;
import org.hiedacamellia.mystiasizakaya.registries.MIAttachment;

import java.util.ArrayList;
import java.util.List;

public record IzakayaOrder(List<String> cuisines, List<String> beverages)  {

    public List<ItemStack> toCuisineStacks(){
        return cuisines().stream().map(MIItemStackUtil::fromString).toList();
    }

    public List<ItemStack> toBeverageStacks(){
        return beverages().stream().map(MIItemStackUtil::fromString).toList();
    }

    public static final Codec<IzakayaOrder> CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    MICodecUtil.LIST_STRING_CODEC.fieldOf("cuisines").forGetter(IzakayaOrder::cuisines),
                    MICodecUtil.LIST_STRING_CODEC.fieldOf("beverages").forGetter(IzakayaOrder::beverages)
            ).apply(instance, IzakayaOrder::new)
    );

    public static IzakayaOrder init(){
        List<String> cuisineList = new ArrayList<>();
        List<String> beverageList = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            cuisineList.add("minecraft:air");
            beverageList.add("minecraft:air");
        }
        return new IzakayaOrder(cuisineList,beverageList);
    }


    public static void addOrder(ItemStack beverages, ItemStack cuisines, int id, ServerPlayer player) {

        IzakayaOrder izakayaOrder = player.getData(MIAttachment.IZAKAYA_ORDER.get());

        List<String> cuisineList = new ArrayList<>(izakayaOrder.cuisines());
        List<String> beverageList = new ArrayList<>(izakayaOrder.beverages());

        OrderEvent.Add add = new OrderEvent.Add(player, cuisines, beverages, id);
        MIEventUtil.post(add);

        cuisineList.set(id, MIItemStackUtil.toString(cuisines));
        beverageList.set(id, MIItemStackUtil.toString(beverages));

        IzakayaOrder izakayaOrder1 = new IzakayaOrder(cuisineList, beverageList);
        player.setData(MIAttachment.IZAKAYA_ORDER.get(), izakayaOrder1);
        PacketDistributor.sendToPlayer(player, IzakayaOrderSyncS2CMessage.fromIzakayaOrder(izakayaOrder1));
        PacketDistributor.sendToPlayer(player,new OrderAddS2CMessage((byte) id,
                BuiltInRegistries.ITEM.getKey(cuisines.getItem()),
                BuiltInRegistries.ITEM.getKey(beverages.getItem())));
    }
    public static void removeOrder(int id, ServerPlayer player) {

        IzakayaOrder izakayaOrder = player.getData(MIAttachment.IZAKAYA_ORDER.get());

        List<String> cuisineList = new ArrayList<>(izakayaOrder.cuisines());
        List<String> beverageList = new ArrayList<>(izakayaOrder.beverages());

        ItemStack beverages= ItemStack.EMPTY, cuisines= ItemStack.EMPTY;
        OrderEvent.Remove remove = new OrderEvent.Remove(player, cuisines, beverages, id);
        MIEventUtil.post(remove);

        cuisineList.set(id, "minecraft:air");
        beverageList.set(id, "minecraft:air");

        IzakayaOrder izakayaOrder1 = new IzakayaOrder(cuisineList, beverageList);
        player.setData(MIAttachment.IZAKAYA_ORDER.get(), izakayaOrder1);
        PacketDistributor.sendToPlayer(player, IzakayaOrderSyncS2CMessage.fromIzakayaOrder(izakayaOrder1));
        PacketDistributor.sendToPlayer(player,new OrderRemoveS2CMessage((byte) id));
    }
}
