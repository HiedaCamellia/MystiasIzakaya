package org.hiedacamellia.mystiasizakaya.content.common.item.utils;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.hiedacamellia.mystiasizakaya.client.gui.screen.LedgerScreen;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class LedgerItem extends Item {
    public LedgerItem() {
        super(new Properties().stacksTo(1).rarity(Rarity.RARE));
    }

    @Override
    public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
        super.appendHoverText(itemstack, context, list, flag);
        String[] description = Component.translatable("tooltip.mystias_izakaya.ledger").getString().split("§n");
        for (String line : description) {
            list.add(Component.literal(line));
        }
    }


    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
        InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
        if(entity.isShiftKeyDown()&&entity.isLocalPlayer()) {
            Minecraft.getInstance().setScreen(new LedgerScreen());
        }
        return ar;
    }

}
