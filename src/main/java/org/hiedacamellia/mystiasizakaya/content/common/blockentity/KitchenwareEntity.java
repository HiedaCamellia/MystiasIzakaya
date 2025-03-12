package org.hiedacamellia.mystiasizakaya.content.common.blockentity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import org.hiedacamellia.mystiasizakaya.content.cooking.KitchenwareType;
import org.hiedacamellia.mystiasizakaya.util.KitchenwareTypeUtil;

public class KitchenwareEntity extends CookingEntity {

    private final KitchenwareType type;

    public KitchenwareEntity(BlockPos position, BlockState state) {
        this(position, state, KitchenwareType.NONE);
    }

    public KitchenwareEntity(BlockPos position, BlockState state, KitchenwareType type) {
        super(KitchenwareTypeUtil.type2BE(type), position, state);
        this.type = type;
    }

    @Override
    public KitchenwareType getKitchenwareType() {
        return type;
    }

    public static class BoilingPot extends KitchenwareEntity {
        public BoilingPot(BlockPos position, BlockState state) {
            super(position, state, KitchenwareType.BOILING_POT);
        }
    }

    public static class FryingPan extends KitchenwareEntity {
        public FryingPan(BlockPos position, BlockState state) {
            super(position, state, KitchenwareType.FRYING_PAN);
        }
    }

    public static class Grill extends KitchenwareEntity {
        public Grill(BlockPos position, BlockState state) {
            super(position, state, KitchenwareType.GRILL);
        }
    }

    public static class CuttingBoard extends KitchenwareEntity {
        public CuttingBoard(BlockPos position, BlockState state) {
            super(position, state, KitchenwareType.CUTTING_BOARD);
        }
    }

    public static class Steamer extends KitchenwareEntity {
        public Steamer(BlockPos position, BlockState state) {
            super(position, state, KitchenwareType.STEAMER);
        }
    }
}
