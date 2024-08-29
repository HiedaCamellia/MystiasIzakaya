
package org.hiedacamellia.mystiasizakaya.content.common.inventory;

import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.ItemStackHandler;
import net.neoforged.neoforge.items.SlotItemHandler;
import net.neoforged.neoforge.items.wrapper.InvWrapper;
import org.hiedacamellia.mystiasizakaya.registries.MIMenu;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class KitchenwaresUiMenu extends AbstractContainerMenu implements Supplier<Map<Integer, Slot>> {
	public final static HashMap<String, Object> guistate = new HashMap<>();
	public final Level world;
	public final Player entity;
	public int x, y, z;
	private ContainerLevelAccess access = ContainerLevelAccess.NULL;
	private IItemHandler internal;
	private final Map<Integer, Slot> customSlots = new HashMap<>();
	private boolean bound = false;
	private Supplier<Boolean> boundItemMatcher = null;
	private Entity boundEntity = null;
	private BlockEntity boundBlockEntity = null;

	public KitchenwaresUiMenu(int id, Inventory inv, FriendlyByteBuf extraData) {
		super(MIMenu.KITCHENWARES_UI.get(), id);
		this.entity = inv.player;
		this.world = inv.player.level();
		this.internal = new ItemStackHandler(12);
		BlockPos pos = null;
		if (extraData != null) {
			pos = extraData.readBlockPos();
			this.x = pos.getX();
			this.y = pos.getY();
			this.z = pos.getZ();
			access = ContainerLevelAccess.create(world, pos);
		}
		if (pos != null) {
			if (extraData.readableBytes() == 1) { // bound to item
				byte hand = extraData.readByte();
				ItemStack itemstack = hand == 0 ? this.entity.getMainHandItem() : this.entity.getOffhandItem();
				this.boundItemMatcher = () -> itemstack == (hand == 0 ? this.entity.getMainHandItem() : this.entity.getOffhandItem());
				IItemHandler cap = itemstack.getCapability(Capabilities.ItemHandler.ITEM);
				if (cap != null) {
					this.internal = cap;
					this.bound = true;
				}
			} else if (extraData.readableBytes() > 1) { // bound to entity
				extraData.readByte(); // drop padding
				boundEntity = world.getEntity(extraData.readVarInt());
				if (boundEntity != null) {
					IItemHandler cap = boundEntity.getCapability(Capabilities.ItemHandler.ENTITY);
					if (cap != null) {
						this.internal = cap;
						this.bound = true;
					}
				}
			} else { // might be bound to block
				boundBlockEntity = this.world.getBlockEntity(pos);
				if (boundBlockEntity instanceof BaseContainerBlockEntity baseContainerBlockEntity) {
					this.internal = new InvWrapper(baseContainerBlockEntity);
					this.bound = true;
				}
			}
		}

//		this.customSlots.put(0, this.addSlot(new SlotItemHandler(internal, 0, 203, 62) {
//			private final int slot = 0;
//		}));
		this.customSlots.put(1, this.addSlot(new SlotItemHandler(internal, 1, 95, 26) {
			private final int slot = 1;

			@Override
			public boolean mayPlace(ItemStack stack) {
				if (stack.is(ItemTags.create(ResourceLocation.parse("mystias_izakaya:ingredients")))){
					return true;
				}else if(stack.is(ItemTags.create(ResourceLocation.parse("mystias_izakaya:bridge_yhc")))){
					return true;
				}else{
					return false;
				}
			}
		}));
		this.customSlots.put(2, this.addSlot(new SlotItemHandler(internal, 2, 122, 26) {
			private final int slot = 2;

			@Override
			public boolean mayPlace(ItemStack stack) {
				if (stack.is(ItemTags.create(ResourceLocation.parse("mystias_izakaya:ingredients")))){
					return true;
				}else if(stack.is(ItemTags.create(ResourceLocation.parse("mystias_izakaya:bridge_yhc")))){
					return true;
				}else{
					return false;
				}
			}

		}));
		this.customSlots.put(3, this.addSlot(new SlotItemHandler(internal, 3, 149, 26) {
			private final int slot = 3;

			@Override
			public boolean mayPlace(ItemStack stack) {
				if (stack.is(ItemTags.create(ResourceLocation.parse("mystias_izakaya:ingredients")))){
					return true;
				}else if(stack.is(ItemTags.create(ResourceLocation.parse("mystias_izakaya:bridge_yhc")))){
					return true;
				}else{
					return false;
				}
			}

		}));
		this.customSlots.put(4, this.addSlot(new SlotItemHandler(internal, 4, 176, 26) {
			private final int slot = 4;

			@Override
			public boolean mayPlace(ItemStack stack) {
				if (stack.is(ItemTags.create(ResourceLocation.parse("mystias_izakaya:ingredients")))){
					return true;
				}else if(stack.is(ItemTags.create(ResourceLocation.parse("mystias_izakaya:bridge_yhc")))){
					return true;
				}else{
					return false;
				}
			}

		}));
		this.customSlots.put(5, this.addSlot(new SlotItemHandler(internal, 5, 203, 26) {
			private final int slot = 5;

			@Override
			public boolean mayPlace(ItemStack stack) {
				if (stack.is(ItemTags.create(ResourceLocation.parse("mystias_izakaya:ingredients")))){
					return true;
				}else if(stack.is(ItemTags.create(ResourceLocation.parse("mystias_izakaya:bridge_yhc")))){
					return true;
				}else{
					return false;
				}
			}

		}));
		this.customSlots.put(6, this.addSlot(new SlotItemHandler(internal, 6, 239, 44) {
			private final int slot = 6;

			@Override
			public boolean mayPlace(ItemStack stack) {
				return false;
			}
		}));
		this.customSlots.put(7, this.addSlot(new SlotItemHandler(internal, 7, 14, 26) {
			private final int slot = 7;

			@Override
			public boolean mayPickup(Player entity) {
				return false;
			}

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return false;
			}
		}));
		this.customSlots.put(8, this.addSlot(new SlotItemHandler(internal, 8, 14, 53) {
			private final int slot = 8;

			@Override
			public boolean mayPickup(Player entity) {
				return false;
			}

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return false;
			}
		}));
		this.customSlots.put(9, this.addSlot(new SlotItemHandler(internal, 9, 14, 80) {
			private final int slot = 9;

			@Override
			public boolean mayPickup(Player entity) {
				return false;
			}

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return false;
			}
		}));
		this.customSlots.put(10, this.addSlot(new SlotItemHandler(internal, 10, 14, 107) {
			private final int slot = 10;

			@Override
			public boolean mayPickup(Player entity) {
				return false;
			}

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return false;
			}
		}));
		this.customSlots.put(11, this.addSlot(new SlotItemHandler(internal, 11, 14, 134) {
			private final int slot = 11;

			@Override
			public boolean mayPickup(Player entity) {
				return false;
			}

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return false;
			}
		}));
		for (int si = 0; si < 3; ++si)
			for (int sj = 0; sj < 9; ++sj)
				this.addSlot(new Slot(inv, sj + (si + 1) * 9, 87 + 8 + sj * 18, 2 + 84 + si * 18));
		for (int si = 0; si < 9; ++si)
			this.addSlot(new Slot(inv, si, 87 + 8 + si * 18, 2 + 142));
	}

	@Override
	public boolean stillValid(Player player) {
		if (this.bound) {
			if (this.boundItemMatcher != null)
				return this.boundItemMatcher.get();
			else if (this.boundBlockEntity != null)
				return AbstractContainerMenu.stillValid(this.access, player, this.boundBlockEntity.getBlockState().getBlock());
			else if (this.boundEntity != null)
				return this.boundEntity.isAlive();
		}
		return true;
	}

	@Override
	public ItemStack quickMoveStack(Player playerIn, int index) {
		ItemStack itemstack = ItemStack.EMPTY;
		Slot slot = this.slots.get(index);
		if (slot != null && slot.hasItem()) {
			ItemStack itemstack1 = slot.getItem();
			itemstack = itemstack1.copy();
			if (index < 12) {
				if (!this.moveItemStackTo(itemstack1, 12, this.slots.size(), true))
					return ItemStack.EMPTY;
				slot.onQuickCraft(itemstack1, itemstack);
			} else if (!this.moveItemStackTo(itemstack1, 0, 12, false)) {
				if (index < 12 + 27) {
					if (!this.moveItemStackTo(itemstack1, 12 + 27, this.slots.size(), true))
						return ItemStack.EMPTY;
				} else {
					if (!this.moveItemStackTo(itemstack1, 12, 12 + 27, false))
						return ItemStack.EMPTY;
				}
				return ItemStack.EMPTY;
			}
			if (itemstack1.getCount() == 0)
				slot.set(ItemStack.EMPTY);
			else
				slot.setChanged();
			if (itemstack1.getCount() == itemstack.getCount())
				return ItemStack.EMPTY;
			slot.onTake(playerIn, itemstack1);
		}
		return itemstack;
	}

	@Override
	protected boolean moveItemStackTo(ItemStack p_38904_, int p_38905_, int p_38906_, boolean p_38907_) {
		boolean flag = false;
		int i = p_38905_;
		if (p_38907_) {
			i = p_38906_ - 1;
		}
		if (p_38904_.isStackable()) {
			while (!p_38904_.isEmpty() && (p_38907_ ? i >= p_38905_ : i < p_38906_)) {
				Slot slot = this.slots.get(i);
				ItemStack itemstack = slot.getItem();
				if (slot.mayPlace(itemstack) && !itemstack.isEmpty() && ItemStack.isSameItemSameComponents(p_38904_, itemstack)) {
					int j = itemstack.getCount() + p_38904_.getCount();
					int k = slot.getMaxStackSize(itemstack);
					if (j <= k) {
						p_38904_.setCount(0);
						itemstack.setCount(j);
						slot.set(itemstack);
						flag = true;
					} else if (itemstack.getCount() < k) {
						p_38904_.shrink(k - itemstack.getCount());
						itemstack.setCount(k);
						slot.set(itemstack);
						flag = true;
					}
				}
				if (p_38907_) {
					i--;
				} else {
					i++;
				}
			}
		}
		if (!p_38904_.isEmpty()) {
			if (p_38907_) {
				i = p_38906_ - 1;
			} else {
				i = p_38905_;
			}
			while (p_38907_ ? i >= p_38905_ : i < p_38906_) {
				Slot slot1 = this.slots.get(i);
				ItemStack itemstack1 = slot1.getItem();
				if (itemstack1.isEmpty() && slot1.mayPlace(p_38904_)) {
					int l = slot1.getMaxStackSize(p_38904_);
					slot1.setByPlayer(p_38904_.split(Math.min(p_38904_.getCount(), l)));
					slot1.setChanged();
					flag = true;
					break;
				}
				if (p_38907_) {
					i--;
				} else {
					i++;
				}
			}
		}
		return flag;
	}


	@Override
	public void removed(Player playerIn) {
		super.removed(playerIn);
		if (!bound && playerIn instanceof ServerPlayer serverPlayer) {
			if (!serverPlayer.isAlive() || serverPlayer.hasDisconnected()) {
				for (int j = 0; j < internal.getSlots(); ++j) {
					switch (j){
                        case 0, 7, 8, 9, 10, 11, 12 -> {
                        }
						default -> playerIn.drop(internal.extractItem(j, internal.getStackInSlot(j).getCount(), false), false);
                    }
				}
			} else {
				for (int i = 0; i < internal.getSlots(); ++i) {
					switch (i){
						case 0, 7, 8, 9, 10, 11, 12 -> {
						}
						default -> playerIn.getInventory().placeItemBackInInventory(internal.extractItem(i, internal.getStackInSlot(i).getCount(), false));
					}
				}
			}
		}
	}

	public Map<Integer, Slot> get() {
		return customSlots;
	}
}
