package net.touhou.mystiasizakaya.functionals.network;

import net.minecraft.client.gui.components.EditBox;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.network.NetworkEvent;
import net.touhou.mystiasizakaya.MystiasIzakaya;
import net.touhou.mystiasizakaya.content.item.ItemRegistery;
import net.touhou.mystiasizakaya.functionals.inventory.BankUiMenu;

import java.util.HashMap;
import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class BankUiButton {
    private final int buttonID, x, y, z;

    public BankUiButton(FriendlyByteBuf buffer) {
        this.buttonID = buffer.readInt();
        this.x = buffer.readInt();
        this.y = buffer.readInt();
        this.z = buffer.readInt();
    }

    public BankUiButton(int buttonID, int x, int y, int z) {
        this.buttonID = buttonID;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public static void buffer(BankUiButton message, FriendlyByteBuf buffer) {
        buffer.writeInt(message.buttonID);
        buffer.writeInt(message.x);
        buffer.writeInt(message.y);
        buffer.writeInt(message.z);
    }

    public static void handler(BankUiButton message, Supplier<NetworkEvent.Context> contextSupplier) {
        NetworkEvent.Context context = contextSupplier.get();
        context.enqueueWork(() -> {
            Player entity = context.getSender();
            int buttonID = message.buttonID;
            int x = message.x;
            int y = message.y;
            int z = message.z;
            handleButtonAction(entity, buttonID, x, y, z);
        });
        context.setPacketHandled(true);
    }

    public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
        HashMap<String, Object> guistate = BankUiMenu.guistate;
        if (buttonID == 0) {
            double i = 0;
            double j = 0;
            i = new Object() {
                double convert(String s) {
                    try {
                        return Double.parseDouble(s.trim());
                    } catch (Exception e) {
                    }
                    return 0;
                }
            }.convert(guistate.containsKey("text:input") ? ((EditBox) guistate.get("text:input")).getValue() : "");
            if (!(i < 0) && (entity.getCapability(Variables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Variables.PlayerVariables())).balance >= i) {
                {
                    double _setval = (entity.getCapability(Variables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Variables.PlayerVariables())).balance - i;
                    entity.getCapability(Variables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.balance = _setval;
                        capability.syncPlayerVariables(entity);
                    });
                }
                if (i >= 10000) {
                    j = Math.floor(i / 10000);
                    i = i - j * 10000;
                    ItemStack _setstack = new ItemStack(ItemRegistery.EN_10K.get());
                    _setstack.setCount((int) j);
                    ItemHandlerHelper.giveItemToPlayer(entity, _setstack);
                }
                j = Math.floor(i / 10);
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
    public static void registerMessage(FMLCommonSetupEvent event) {
        MystiasIzakaya.addNetworkMessage(BankUiButton.class, BankUiButton::buffer, BankUiButton::new, BankUiButton::handler);
    }
}
