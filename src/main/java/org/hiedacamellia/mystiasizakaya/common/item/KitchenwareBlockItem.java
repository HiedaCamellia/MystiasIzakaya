package org.hiedacamellia.mystiasizakaya.common.item;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.block.Block;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.hiedacamellia.mystiasizakaya.content.cooking.IKitchenware;
import org.hiedacamellia.mystiasizakaya.content.cooking.KitchenwareType;
import org.hiedacamellia.mystiasizakaya.core.util.MIItemStackUtil;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class KitchenwareBlockItem extends BlockItem implements IKitchenware {

    private final KitchenwareType type;

    public KitchenwareBlockItem(Block block, Properties properties) {
        super(block, properties);
        if(block instanceof IKitchenware kitchenware){
            this.type = kitchenware.getKitchenwareType();
        }else {
            this.type = KitchenwareType.NONE;
        }
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(@NotNull ItemStack itemstack, @NotNull TooltipContext context, @NotNull List<Component> list, @NotNull TooltipFlag flag) {
        super.appendHoverText(itemstack, context, list, flag);
        if (!Screen.hasShiftDown()) {
            List<String> tags = MIItemStackUtil.getPositiveTags(itemstack);
            List<String> ntags = MIItemStackUtil.getNegativeTags(itemstack);
            for (String tag : tags) {
                list.add(Component.literal("§6+ " + Component.translatable(gettagprefix()+tag).getString() + "§r"));
            }
            for (String tag : ntags) {
                list.add(Component.literal("§4- " + Component.translatable(gettagprefix()+tag).getString() + "§r"));
            }
            list.add(Component.literal(
                    "§7§o" + Component.translatable("tooltip.mystias_izakaya.press_shift").getString() + "§r"));
        }else {
            ResourceLocation key = BuiltInRegistries.ITEM.getKey(itemstack.getItem());
            String[] description = Component.translatable("tooltip.mystias_izakaya."+key.getPath()).getString().split("§n");
            for (String line : description) {
                list.add(Component.literal(line));
            }
        }
    }

    protected String gettagprefix() {
        return "tag.mystias_izakaya.";
    }

    @Override
    public KitchenwareType getKitchenwareType() {
        return type;
    }
}
