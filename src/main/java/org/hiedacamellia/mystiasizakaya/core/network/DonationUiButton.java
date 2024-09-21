package org.hiedacamellia.mystiasizakaya.core.network;

import net.minecraft.client.gui.components.EditBox;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.network.NetworkEvent;
import org.hiedacamellia.mystiasizakaya.content.common.inventory.DonationUiMenu;
import org.hiedacamellia.mystiasizakaya.core.event.MIPlayerEvent;
import org.hiedacamellia.mystiasizakaya.registries.MIItem;
import org.hiedacamellia.mystiasizakaya.util.cross.Pos;

import java.util.HashMap;
import java.util.function.Supplier;


@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class DonationUiButton  {

    private final int buttonID, x, y, z;

    public DonationUiButton(FriendlyByteBuf buffer) {
        this.buttonID = buffer.readInt();
        this.x = buffer.readInt();
        this.y = buffer.readInt();
        this.z = buffer.readInt();
    }

    public DonationUiButton(int buttonID, int x, int y, int z) {
        this.buttonID = buttonID;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public static void buffer(DonationUiButton message, FriendlyByteBuf buffer) {
        buffer.writeInt(message.buttonID);
        buffer.writeInt(message.x);
        buffer.writeInt(message.y);
        buffer.writeInt(message.z);
    }

    public static void handler(DonationUiButton message, Supplier<NetworkEvent.Context> contextSupplier) {
        NetworkEvent.Context context = contextSupplier.get();
        context.enqueueWork(() -> {
            Player entity = context.getSender();
            int buttonID = message.buttonID;
            int x = message.x;
            int y = message.y;
            int z = message.z;
            handleButtonAction(entity, buttonID, Pos.get(x, y, z));
        });
        context.setPacketHandled(true);
    }


    public static void handleButtonAction(Player entity, int buttonID, BlockPos pos) {
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

                MIPlayerEvent.addTurnover(player, "to_donation", -i);
                MIPlayerEvent.deleteOverTurnover(player);
                MIPlayerEvent.syncPlayerVariables(player);



                if (i > 0 && MIPlayerEvent.getBalance(player) >= i) {
                    //Debug.getLogger().debug("Balance: " + player.getData(MIAttachment.MI_BALANCE).balance());
                    MIPlayerEvent.setBalance(player, MIPlayerEvent.getBalance(player) - i);
                    //Debug.getLogger().debug("NowBalance: " + player.getData(MIAttachment.MI_BALANCE).balance());
                    j = i / 10;
                    i = i - j * 10;
                    ItemStack _setstack = new ItemStack(MIItem.EN_10.get());
                    _setstack.setCount(j);
                    ItemHandlerHelper.giveItemToPlayer(player, _setstack);
                    ItemStack setstack = new ItemStack(MIItem.EN_1.get());
                    setstack.setCount(i);
                    ItemHandlerHelper.giveItemToPlayer(player, setstack);
                    MIPlayerEvent.syncPlayerVariables(player);
                    //Debug.getLogger().debug("Success in withdrawing " + i + " yen");
                }
            }
        }
    }
    @SubscribeEvent
    public static void registerMessage(FMLCommonSetupEvent event) {
        MINetWork.addNetworkMessage(DonationUiButton.class, DonationUiButton::buffer, DonationUiButton::new, DonationUiButton::handler);
    }

}
