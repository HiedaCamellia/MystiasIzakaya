package org.hiedacamellia.mystiasizakaya.core.data.provider;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;

public class StateProvider extends BlockStateProvider {
    public StateProvider(PackOutput gen, ExistingFileHelper helper) {
        super(gen, MystiasIzakaya.MODID, helper);
    }

    @Override
    protected void registerStatesAndModels() {
    }
}
