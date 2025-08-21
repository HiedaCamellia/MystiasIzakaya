package org.hiedacamellia.mystiasizakaya.common.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.hiedacamellia.mystiasizakaya.common.menu.LedgerMenu;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class LedgerItem extends Item {
    public LedgerItem(ResourceLocation loc) {
        super(new Properties().setId(ResourceKey.create(Registries.ITEM, loc)).stacksTo(1).rarity(Rarity.RARE));
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
    public InteractionResult use(Level level, Player player, InteractionHand hand) {
        InteractionResult ar = super.use(level, player, hand);
        if(player.isShiftKeyDown()&&!level.isClientSide()) {
            player.openMenu(new MenuProvider() {
                @Override
                public Component getDisplayName() {
                    return Component.empty();
                }

                @Override
                public @Nullable AbstractContainerMenu createMenu(int i, Inventory inventory, Player player) {
                    return new LedgerMenu(i,inventory);
                }
            });
        }
        return ar;
    }

}
