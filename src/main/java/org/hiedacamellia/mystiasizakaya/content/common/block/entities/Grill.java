package org.hiedacamellia.mystiasizakaya.content.common.block.entities;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.block.state.BlockState;
import org.hiedacamellia.mystiasizakaya.registries.MIBlockEntitiy;
import org.jetbrains.annotations.NotNull;

public class Grill extends KitchenwaresEntity{
    public Grill(BlockPos position, BlockState state) {
        super(MIBlockEntitiy.GRILL.get(), position, state);
    }

    @Override
    public @NotNull Component getDefaultName() {
        return Component.literal("grill");
    }

    @Override
    public @NotNull Component getDisplayName() {
        return Component.literal("grill");
    }

}
