package org.hiedacamellia.mystiasizakaya.content.common.item.utils;

import io.netty.buffer.Unpooled;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraftforge.network.NetworkHooks;
import org.hiedacamellia.mystiasizakaya.content.common.inventory.LedgerUiMenu;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class LedgerItem extends Item {
    public LedgerItem() {
        super(new Properties().stacksTo(1).rarity(Rarity.RARE));
    }

    @Override
    public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
        super.appendHoverText(itemstack, world, list, flag);
        String[] description = Component.translatable("tooltip.mystias_izakaya.ledger").getString().split("§n");
        for (String line : description) {
            list.add(Component.literal(line));
        }
    }


    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
        InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
        BlockPos pos = entity.getOnPos();

        if (entity.isShiftKeyDown()&&entity instanceof ServerPlayer player) {
            NetworkHooks.openScreen(player,new MenuProvider() {
                @Override
                public @NotNull Component getDisplayName() {
                    return Component.literal("Ledger");
                }

                @Override
                public AbstractContainerMenu createMenu(int id, @NotNull Inventory inventory, @NotNull Player player) {
                    return new LedgerUiMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(pos));
                }
            }, pos);
        }



        return ar;
    }

    @Override
    public InteractionResult useOn(UseOnContext p_41427_) {
        return InteractionResult.PASS;
    }

}
