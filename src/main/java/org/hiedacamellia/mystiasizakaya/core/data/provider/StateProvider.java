package org.hiedacamellia.mystiasizakaya.core.data.provider;

import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;
import org.hiedacamellia.mystiasizakaya.registries.MIBlock;

public class StateProvider extends BlockStateProvider {
    public StateProvider(PackOutput gen, ExistingFileHelper helper) {
        super(gen, MystiasIzakaya.MODID, helper);
    }

    @Override
    protected void registerStatesAndModels() {

        simpleBlock(MIBlock.CUTTING_BOARD.get(),models().getExistingFile(modLoc("block/cutting_board")));
        simpleBlockItem(MIBlock.CUTTING_BOARD.get(),models().getExistingFile(modLoc("item/liao_li_tai")));
        simpleBlock(MIBlock.GRILL.get(),models().getExistingFile(modLoc("block/grill")));
        simpleBlockItem(MIBlock.GRILL.get(),models().getExistingFile(modLoc("item/shao_kao_jia")));
        simpleBlock(MIBlock.BOILING_POT.get(),models().getExistingFile(modLoc("block/boiling_pot")));
        simpleBlockItem(MIBlock.BOILING_POT.get(),models().getExistingFile(modLoc("item/zhu_guo")));
        simpleBlock(MIBlock.STEAMER.get(),models().getExistingFile(modLoc("block/steamer")));
        simpleBlockItem(MIBlock.STEAMER.get(),models().getExistingFile(modLoc("item/zheng_guo")));
        simpleBlock(MIBlock.FRYING_PAN.get(),models().getExistingFile(modLoc("block/frying_pan")));
        simpleBlockItem(MIBlock.FRYING_PAN.get(),models().getExistingFile(modLoc("item/you_guo")));
    }
}