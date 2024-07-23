package org.hiedacamellia.mystiasizakaya.functionals.network;

import net.minecraft.client.gui.components.EditBox;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.items.ItemHandlerHelper;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.handling.DirectionalPayloadHandler;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;
import org.hiedacamellia.mystiasizakaya.content.item.ItemRegistery;
import org.hiedacamellia.mystiasizakaya.functionals.inventory.BankUiMenu;

import java.util.HashMap;
import java.util.function.Supplier;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public record BankUiButton(int buttonID, int x, int y, int z) implements CustomPacketPayload {

    public static final Type<BankUiButton> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(MystiasIzakaya.MODID, "bankui_button"));
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
        HashMap<String, Object> guistate = BankUiMenu.guistate;
        if (buttonID == 0) {
            int i = 0;
            int j = 0;
            try{
                i = Integer.parseInt((guistate.containsKey("text:input") ? ((EditBox) guistate.get("text:input")).getValue() : "0" ).trim()) ;
            } catch (NumberFormatException e) {
                return;
            }

            if (!(i < 0) && entity.getData(Variables.PLAYER_VARIABLES).balance >= i) {
                {
                    Variables.PlayerVariables _vars = entity.getData(Variables.PLAYER_VARIABLES);
                    _vars.balance -= i;
                    _vars.syncPlayerVariables(entity);
                }
                if (i >= 10000) {
                    j = i / 10000;
                    i = i - j * 10000;
                    ItemStack _setstack = new ItemStack(ItemRegistery.EN_10K.get());
                    _setstack.setCount((int) j);
                    ItemHandlerHelper.giveItemToPlayer(entity, _setstack);
                }
                j = i / 10;
                i = i - j * 10;
                ItemStack _setstack = new ItemStack(ItemRegistery.EN_10.get());
                _setstack.setCount((int) j);
                ItemHandlerHelper.giveItemToPlayer(entity, _setstack);
                ItemStack setstack = new ItemStack(ItemRegistery.EN_1.get());
                setstack.setCount((int) i);
                ItemHandlerHelper.giveItemToPlayer(entity, setstack);

            }
        }
    }

    @SubscribeEvent
    public static void register(final RegisterPayloadHandlersEvent event) {
        final PayloadRegistrar registrar = event.registrar("4");
        registrar.playBidirectional(
                BankUiButton.TYPE,
                BankUiButton.STREAM_CODEC,
                new DirectionalPayloadHandler<>(
                        BankUiButton::handleData,
                        BankUiButton::handleData
                )
        );
    }
//    @SubscribeEvent
//    public static void registerMessage(FMLCommonSetupEvent event) {
//        MystiasIzakaya.addNetworkMessage(BankUiButton.TYPE, BankUiButton.STREAM_CODEC, BankUiButton::handleData);
//    }
}
