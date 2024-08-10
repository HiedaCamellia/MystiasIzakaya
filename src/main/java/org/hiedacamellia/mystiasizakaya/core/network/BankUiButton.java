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
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;
import org.hiedacamellia.mystiasizakaya.content.common.inventory.DonationUiMenu;
import org.hiedacamellia.mystiasizakaya.core.codec.record.MIBalance;
import org.hiedacamellia.mystiasizakaya.core.debug.Debug;
import org.hiedacamellia.mystiasizakaya.registries.MIAttachment;
import org.hiedacamellia.mystiasizakaya.registries.MIItem;

import java.util.HashMap;


public record BankUiButton(int buttonID, int x, int y, int z) implements CustomPacketPayload {

    public static final Type<BankUiButton> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(MystiasIzakaya.MODID, "donationui_button"));
    public static final StreamCodec<RegistryFriendlyByteBuf, BankUiButton> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, BankUiButton message) -> {
        buffer.writeInt(message.buttonID);
        buffer.writeInt(message.x);
        buffer.writeInt(message.y);
        buffer.writeInt(message.z);
    }, (RegistryFriendlyByteBuf buffer) -> new BankUiButton(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));
    @Override
    public Type<BankUiButton> type() {
        return TYPE;
    }

    public static void handleData(final BankUiButton message, final IPayloadContext context) {
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

            Debug.getLogger().debug("Button Pressed with ID: " + buttonID + " with value: " + i);
            if(!(entity instanceof ServerPlayer))
                return;

            if (i > 0 && entity.getData(MIAttachment.MI_BALANCE).balance() >= i) {
                Debug.getLogger().debug("Balance: " + entity.getData(MIAttachment.MI_BALANCE).balance());
                entity.setData(MIAttachment.MI_BALANCE, new MIBalance(entity.getData(MIAttachment.MI_BALANCE).balance() - i));
                Debug.getLogger().debug("NowBalance: " + entity.getData(MIAttachment.MI_BALANCE).balance());
                if (i >= 10000) {
                    j = i / 10000;
                    i = i - j * 10000;
                    ItemStack _setstack = new ItemStack(MIItem.EN_10K.get());
                    _setstack.setCount((int) j);
                    ItemHandlerHelper.giveItemToPlayer(entity, _setstack);
                }
                j = i / 10;
                i = i - j * 10;
                ItemStack _setstack = new ItemStack(MIItem.EN_10.get());
                _setstack.setCount((int) j);
                ItemHandlerHelper.giveItemToPlayer(entity, _setstack);
                ItemStack setstack = new ItemStack(MIItem.EN_1.get());
                setstack.setCount((int) i);
                ItemHandlerHelper.giveItemToPlayer(entity, setstack);

                //Debug.getLogger().debug("Success in withdrawing " + i + " yen");
            }
        }
    }

}
