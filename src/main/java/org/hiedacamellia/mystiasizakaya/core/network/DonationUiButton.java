package org.hiedacamellia.mystiasizakaya.core.network;

import net.minecraft.client.gui.components.EditBox;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.items.ItemHandlerHelper;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;
import org.hiedacamellia.mystiasizakaya.content.common.inventory.DonationUiMenu;
import org.hiedacamellia.mystiasizakaya.core.codec.record.MIBalance;
import org.hiedacamellia.mystiasizakaya.core.codec.record.MITurnover;
import org.hiedacamellia.mystiasizakaya.registries.MIAttachment;
import org.hiedacamellia.mystiasizakaya.registries.MIItem;

import java.util.HashMap;


public record DonationUiButton(int buttonID, int x, int y, int z) implements CustomPacketPayload {

    public static final Type<DonationUiButton> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(MystiasIzakaya.MODID, "donationui_button"));
    public static final StreamCodec<RegistryFriendlyByteBuf, DonationUiButton> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, DonationUiButton message) -> {
        buffer.writeInt(message.buttonID);
        buffer.writeInt(message.x);
        buffer.writeInt(message.y);
        buffer.writeInt(message.z);
    }, (RegistryFriendlyByteBuf buffer) -> new DonationUiButton(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));
    @Override
    public Type<DonationUiButton> type() {
        return TYPE;
    }

    public static void handleData(final DonationUiButton message, final IPayloadContext context) {
        if (context.flow() == PacketFlow.SERVERBOUND) {
            context.enqueueWork(() -> {
                Player entity = context.player();
                int buttonID = message.buttonID;
                int x = message.x;
                int y = message.y;
                int z = message.z;
                handleButtonAction(entity, buttonID, x, y, z);
            }).exceptionally(e -> {
                context.connection().disconnect(Component.literal(e.getMessage()));
                return null;
            });
        }
    }

    public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
        HashMap<String, Object> guistate = DonationUiMenu.guistate;
        if (buttonID == 0) {
            int i;
            int j;
            try{
                i = Integer.parseInt((guistate.containsKey("text:input") ? ((EditBox) guistate.get("text:input")).getValue() : "0" ).trim()) ;
            } catch (NumberFormatException e) {
                return;
            }

            //Debug.getLogger().debug("Button Pressed with ID: " + buttonID + " with value: " + i);
            if(entity instanceof ServerPlayer player) {

                MITurnover miTurnover = player.getData(MIAttachment.MI_TURNOVER);
                miTurnover = miTurnover.addTurnover("to_donation",(double) -i);
                miTurnover = miTurnover.deleteOverStack();
                player.setData(MIAttachment.MI_TURNOVER, miTurnover);
                PacketDistributor.sendToPlayer(player, miTurnover);


                if (i > 0 && player.getData(MIAttachment.MI_BALANCE).balance() >= i) {
                    //Debug.getLogger().debug("Balance: " + player.getData(MIAttachment.MI_BALANCE).balance());
                    player.setData(MIAttachment.MI_BALANCE, new MIBalance(player.getData(MIAttachment.MI_BALANCE).balance() - i));
                    //Debug.getLogger().debug("NowBalance: " + player.getData(MIAttachment.MI_BALANCE).balance());
                    j = i / 10;
                    i = i - j * 10;
                    ItemStack _setstack = new ItemStack(MIItem.EN_10.get());
                    _setstack.setCount(j);
                    ItemHandlerHelper.giveItemToPlayer(player, _setstack);
                    ItemStack setstack = new ItemStack(MIItem.EN_1.get());
                    setstack.setCount(i);
                    ItemHandlerHelper.giveItemToPlayer(player, setstack);
                    PacketDistributor.sendToPlayer(player, new MIBalance(player.getData(MIAttachment.MI_BALANCE).balance()));
                    //Debug.getLogger().debug("Success in withdrawing " + i + " yen");
                }
            }
        }
    }

}
