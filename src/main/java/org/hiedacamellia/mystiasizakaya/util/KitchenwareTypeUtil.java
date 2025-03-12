package org.hiedacamellia.mystiasizakaya.util;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntityType;
import org.hiedacamellia.mystiasizakaya.content.common.blockentity.CookingEntity;
import org.hiedacamellia.mystiasizakaya.content.cooking.KitchenwareType;
import org.hiedacamellia.mystiasizakaya.registries.MIBlockEntitiy;
import org.hiedacamellia.mystiasizakaya.registries.MIItem;

public class KitchenwareTypeUtil {

    public static BlockEntityType<? extends CookingEntity> type2BE(KitchenwareType type){
        return switch (type) {
            case CUTTING_BOARD -> MIBlockEntitiy.CUTTING_BOARD.get();
            case BOILING_POT -> MIBlockEntitiy.BOILING_POT.get();
            case FRYING_PAN -> MIBlockEntitiy.FRYING_PAN.get();
            case STEAMER ->MIBlockEntitiy.STEAMER.get();
            case GRILL -> MIBlockEntitiy.GRILL.get();
            default -> MIBlockEntitiy.COOKING_RANGE.get();
        };
    }
    public static ItemStack type2Stack(KitchenwareType type){
        return switch (type){
            case BOILING_POT -> MIItem.BOILING_POT.toStack();
            case FRYING_PAN -> MIItem.FRYING_PAN.toStack();
            case CUTTING_BOARD -> MIItem.CUTTING_BOARD.toStack();
            case GRILL -> MIItem.GRILL.toStack();
            case STEAMER -> MIItem.STEAMER.toStack();
            case NONE -> ItemStack.EMPTY;
        };
    }
}
