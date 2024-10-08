package org.hiedacamellia.mystiasizakaya.core.network;

import me.pepperbell.simplenetworking.C2SPacket;
import me.pepperbell.simplenetworking.SimpleChannel;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.network.ServerGamePacketListenerImpl;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.hiedacamellia.mystiasizakaya.content.inventory.DonationUiMenu;
import org.hiedacamellia.mystiasizakaya.core.event.MIPlayerEvent;
import org.hiedacamellia.mystiasizakaya.registries.MIItem;
import org.hiedacamellia.mystiasizakaya.util.cross.Pos;

import java.util.HashMap;
import java.util.function.Supplier;


public class DonationUiButton implements C2SPacket {

    private final int buttonID, x, y, z;

    public DonationUiButton(int buttonID, int x, int y, int z) {
        this.buttonID = buttonID;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public static DonationUiButton decode(FriendlyByteBuf buffer) {
        return new DonationUiButton(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt());
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



                if (i > 0 && MIPlayerEvent.getBalance(player) >= i) {
                    //Debug.getLogger().debug("Balance: " + player.getData(MIAttachment.MI_BALANCE).balance());
                    MIPlayerEvent.setBalance(player, MIPlayerEvent.getBalance(player) - i);
                    //Debug.getLogger().debug("NowBalance: " + player.getData(MIAttachment.MI_BALANCE).balance());
                    j = i / 10;
                    i = i - j * 10;
                    ItemStack _setstack = new ItemStack(MIItem.EN_10);
                    _setstack.setCount(j);
                    player.addItem(_setstack);
                    ItemStack setstack = new ItemStack(MIItem.EN_1);
                    setstack.setCount(i);
                    player.addItem(setstack);
                    //Debug.getLogger().debug("Success in withdrawing " + i + " yen");
                }
            }
        }
    }

    public static void registerMessage() {
        MINetWork.addC2SNetworkMessage(DonationUiButton.class, DonationUiButton::decode;
    }

    @Override
    public void handle(MinecraftServer server, ServerPlayer player, ServerGamePacketListenerImpl listener, PacketSender responseSender, SimpleChannel channel) {

        int buttonID = this.buttonID;
        int x = this.x;
        int y = this.y;
        int z = this.z;
        handleButtonAction(player, buttonID, Pos.get(x, y, z));
    }

    @Override
    public void encode(FriendlyByteBuf buffer) {
        buffer.writeInt(buttonID);
        buffer.writeInt(x);
        buffer.writeInt(y);
        buffer.writeInt(z);
    }
}
