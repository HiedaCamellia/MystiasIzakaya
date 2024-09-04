package org.hiedacamellia.mystiasizakaya.core.data.provider;

import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;
import org.hiedacamellia.mystiasizakaya.registries.MIBlock;

public class MIStateProvider extends BlockStateProvider {
    public MIStateProvider(PackOutput gen, ExistingFileHelper helper) {
        super(gen, MystiasIzakaya.MODID, helper);
    }

    @Override
    protected void registerStatesAndModels() {

        simpleBlock(MIBlock.CUTTING_BOARD.get(),models().getExistingFile(modLoc("block/cutting_board")));
        simpleBlock(MIBlock.GRILL.get(),models().getExistingFile(modLoc("block/grill")));
        simpleBlock(MIBlock.BOILING_POT.get(),models().getExistingFile(modLoc("block/boiling_pot")));
        simpleBlock(MIBlock.STEAMER.get(),models().getExistingFile(modLoc("block/steamer")));
        simpleBlock(MIBlock.FRYING_PAN.get(),models().getExistingFile(modLoc("block/frying_pan")));

        simpleBlockWithItem(MIBlock.TELEPHONE.get(),models().getExistingFile(modLoc("block/telephone")));
    }
}