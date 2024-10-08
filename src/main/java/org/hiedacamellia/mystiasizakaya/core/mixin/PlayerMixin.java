package org.hiedacamellia.mystiasizakaya.core.mixin;


import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.decoration.ItemFrame;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import org.hiedacamellia.mystiasizakaya.content.common.block.entities.TableEntity;
import org.hiedacamellia.mystiasizakaya.content.orders.Addorder;
import org.hiedacamellia.mystiasizakaya.content.orders.Deleteorder;
import org.hiedacamellia.mystiasizakaya.core.debug.Debug;
import org.hiedacamellia.mystiasizakaya.core.entry.MIItem;
import org.hiedacamellia.mystiasizakaya.registries.MITag;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static org.hiedacamellia.mystiasizakaya.core.event.MIPlayerEvent.*;

import java.util.*;

@Mixin(Player.class)
public class PlayerMixin {
    
    @Inject(method = "tick", at = @At("TAIL"))
    private void tick(CallbackInfo ci){
        Player player = (Player)(Object)this;
            if (player instanceof ServerPlayer serverPlayer) {
                int telecolddown = getTelecolddown(serverPlayer);
                if (telecolddown > 0) {
                    setTelecolddown(serverPlayer, telecolddown - 1);
                }
            }

        //
        if(player instanceof ServerPlayer serverPlayer)
        {

            List<BlockPos> tables = getTables(serverPlayer);
            List<String> cuisineList = getOrders(serverPlayer);
            List<String> beverageList = getOrdersBeverages(serverPlayer);
            if(tables.size()<8||cuisineList.size()<8||beverageList.size()<8){
                if(tables.size()<8){
                    for(int i=tables.size();i<8;i++){
                        tables.add(new BlockPos(-1,-1,-1));
                    }
                }
                if(cuisineList.size()<8){
                    for(int i=cuisineList.size();i<8;i++){
                        cuisineList.add("minecraft:air");
                    }
                }
                if(beverageList.size()<8){
                    for(int i=beverageList.size();i<8;i++){
                        beverageList.add("minecraft:air");
                    }
                }
                setTables(serverPlayer,tables);
                setOrders(serverPlayer,cuisineList);
                setOrdersBeverages(serverPlayer,beverageList);
            }

//
//            Debug.getLogger().debug(player.getData(MIAttachment.MI_ON_OPEN).toString());
//            Debug.getLogger().debug(tables.toString());

            if(getOnOpen(serverPlayer)){

                Set<ItemStack> beverages = new LinkedHashSet<>();
                Set<ItemStack> cuisines = new LinkedHashSet<>();
                getMenus(serverPlayer).forEach(s -> beverages.add(BuiltInRegistries.ITEM.get(new ResourceLocation(s)).getDefaultInstance()));
                getMenusBeverages(serverPlayer).forEach(s -> cuisines.add(BuiltInRegistries.ITEM.get(new ResourceLocation(s)).getDefaultInstance()));
                beverages.remove(ItemStack.EMPTY);
                cuisines.remove(ItemStack.EMPTY);
                if(beverages.isEmpty()||cuisines.isEmpty()){
                    return;
                }

                List<ItemStack> beverageslist = new ArrayList<>(beverages);
                List<ItemStack> cuisineslist = new ArrayList<>(cuisines);
//
//                Debug.getLogger().debug(beveragesList.toString());
//                Debug.getLogger().debug(cuisinesList.toString());

                for(BlockPos pos : tables){
                    if(pos.equals(new BlockPos(-1,-1,-1))){
                        continue;
                    }
                    if(Math.random()<0.0029){
                        if(beverageList.get(tables.indexOf(pos)).equals("minecraft:air")&&cuisineList.get(tables.indexOf(pos)).equals("minecraft:air")){
                            ItemStack beverage = beverageslist.get((int) (Math.random() * beverages.size()));
                            ItemStack cuisine = cuisineslist.get((int) (Math.random() * cuisines.size()));
                            if(beverage.isEmpty()||cuisine.isEmpty()){
                                return;
                            }
                            Addorder.execute(beverage, cuisine, tables.indexOf(pos), serverPlayer);
                        }
                        break;
                    }
                }
            }
            for(int i = 0; i < tables.size();i++){
                if(tables.get(i).equals(new BlockPos(-1,-1,-1))){
                    continue;
                }
//                Debug.getLogger().debug(tables.get(i).toString());

                ItemStack cuisine = BuiltInRegistries.ITEM.get(new ResourceLocation((cuisineList.get(i).toLowerCase(Locale.ENGLISH)))).getDefaultInstance();
                ItemStack beverage = BuiltInRegistries.ITEM.get(new ResourceLocation((beverageList.get(i).toLowerCase(Locale.ENGLISH)))).getDefaultInstance();
                Level level = serverPlayer.level();
                if(beverage.isEmpty()||cuisine.isEmpty()){
                    continue;
                }
                BlockEntity blockEntity =  level.getBlockEntity(tables.get(i));
                if (blockEntity != null) {
                    Debug.getLogger().debug(blockEntity.toString());
                }

                if(blockEntity instanceof TableEntity tableEntity){
                    List<ItemStack> itemStacks= tableEntity.getItems();
                    Debug.getLogger().debug(itemStacks.toString());
                    Debug.getLogger().debug(cuisine.toString());
                    Debug.getLogger().debug(beverage.toString());

                    if(ItemStack.isSameItem(itemStacks.get(0),cuisine)&&ItemStack.isSameItem(itemStacks.get(1),beverage)){
                        Deleteorder.execute(i,serverPlayer);
                        tableEntity.clearContent();
                        level.setBlockEntity(tableEntity);
//                          level.sendBlockUpdated(tables.get(i),level.getBlockState(tables.get(i)),level.getBlockState(tables.get(i)),3);
                        serverPlayer.closeContainer();
                        int cost = cuisine.getOrCreateTag().getInt("cost")+beverage.getOrCreateTag().getInt("cost");
                        setBalance(serverPlayer,getBalance(serverPlayer)+cost);
                        addTurnover(serverPlayer,"from_table",cost);
                    }
                }
            }
        }
        
    }

    @Inject(method = "interactOn", at = @At("TAIL"), cancellable = true)
    private void interactOn(Entity entity, InteractionHand interactionHand, CallbackInfoReturnable<InteractionResult> cir){
        Player player = (Player)(Object)this;

        if (player instanceof ServerPlayer serverPlayer && entity instanceof ItemFrame itemFrame) {

            BlockPos blockPos = itemFrame.getPos();
            ItemStack itemStack = itemFrame.getItem();

            if (itemStack.getItem() instanceof MIItem miItem) {
                ResourceLocation key = BuiltInRegistries.ITEM.getKey(miItem);

                List<BlockPos> blockPosList = getMenuBlockPos(serverPlayer);
                List<String> cuisineList = getMenus(serverPlayer);
                List<String> beverageList = getMenusBeverages(serverPlayer);
                if (blockPosList.size() < 8) {
                    for (int i = blockPosList.size() - 1; i < 8; i++) {
                        blockPosList.add(new BlockPos(-1, -1, -1));
                        cuisineList.add("minecraft:air");
                        beverageList.add("minecraft:air");
                    }
                }


                for (int i = 0; i < blockPosList.size(); i++) {
                    BlockPos pos = blockPosList.get(i);
                    if ((pos.equals(blockPos) || pos.above().equals(blockPos) || pos.below().equals(blockPos)) && serverPlayer.isShiftKeyDown()) {
                        blockPosList.set(i, new BlockPos(-1, -1, -1));
                        cuisineList.set(i, "minecraft:air");
                        beverageList.set(i, "minecraft:air");
                        serverPlayer.sendSystemMessage(Component.translatable("message.mystias_izakaya.menu.unbound", i + 1, blockPos.getX(), blockPos.getY(), blockPos.getZ()));
                        break;
                    }
                    if ((pos.equals(blockPos) || pos.above().equals(blockPos) || pos.below().equals(blockPos)) && !serverPlayer.isShiftKeyDown()) {
                        if (itemStack.is(MITag.cuisinesKey) && !cuisineList.contains(key.toString())) {
                            serverPlayer.sendSystemMessage(Component.translatable("message.mystias_izakaya.menu.cuisine", itemStack.getDisplayName().getString(), i + 1));
                            cuisineList.set(i, key.toString());
                        }
                        if (itemStack.is(MITag.beveragesKey) && !beverageList.contains(key.toString())) {
                            serverPlayer.sendSystemMessage(Component.translatable("message.mystias_izakaya.menu.beverage", itemStack.getDisplayName().getString(), i + 1));
                            beverageList.set(i, key.toString());
                        }
                        break;
                    }
                    if (Objects.equals(pos, new BlockPos(-1, -1, -1)) && !serverPlayer.isShiftKeyDown()) {
                        blockPosList.set(i, blockPos);
                        serverPlayer.sendSystemMessage(Component.translatable("message.mystias_izakaya.menu.bound", i + 1, blockPos.getX(), blockPos.getY(), blockPos.getZ()));
                        break;
                    }
                }
                setMenuBlockPos(serverPlayer, blockPosList);
                setMenus(serverPlayer, cuisineList);
                setMenusBeverages(serverPlayer, beverageList);

                Debug.getLogger().debug(blockPosList.toString());
                Debug.getLogger().debug(cuisineList.toString());
                Debug.getLogger().debug(beverageList.toString());

                cir.setReturnValue(InteractionResult.SUCCESS);
            }
        }

    }
}
