
package org.hiedacamellia.mystiasizakaya.content.inventory;

import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;

import org.hiedacamellia.mystiasizakaya.content.common.block.entities.CookingRangeEntity;
import org.hiedacamellia.mystiasizakaya.core.debug.Debug;
import org.hiedacamellia.mystiasizakaya.registries.MIMenu;
import org.hiedacamellia.mystiasizakaya.registries.MITag;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class CookingRangeUiMenu extends AbstractContainerMenu {
	public final static HashMap<String, Object> guistate = new HashMap<>();
	public final Level world;
	public final Player entity;
	public int x, y, z;
	private ContainerLevelAccess access = ContainerLevelAccess.NULL;
	private CookingRangeEntity inv;
	public final List<Slot> customSlots = new ArrayList<>();
	private boolean bound = false;
	private Supplier<Boolean> boundItemMatcher = null;
	private Entity boundEntity = null;
	private BlockEntity boundBlockEntity = null;

	public CookingRangeUiMenu(int id, Inventory inv, BlockPos pos,CookingRangeEntity cookingRange) {
		super(MIMenu.COOKING_RANGE_UI, id);
		this.entity = inv.player;
		this.world = inv.player.level();
		access = ContainerLevelAccess.create(world, pos);



			this.customSlots.add(0, this.addSlot(new Slot( inv,0, 203, 62) {
			private final int slot = 0;

			@Override
			public boolean mayPickup(Player entity) {
				return true;
			}

			@Override
			public boolean mayPlace(ItemStack stack) {
				return stack.is(MITag.kitchenwaresKey);
			}
		}));
		this.customSlots.add(1, this.addSlot(new Slot(inv, 1, 95, 26) {
			private final int slot = 1;

			@Override
			public boolean mayPlace(ItemStack stack) {
				if (stack.is(MITag.ingredientsKey)){
					return true;
				}else {
					return false;
				}
			}
		}));
		this.customSlots.add(this.addSlot(new Slot(inv, 2, 122, 26) {
			private final int slot = 2;

			@Override
			public boolean mayPlace(ItemStack stack) {
				if (stack.is(MITag.ingredientsKey)){
					return true;
				}else {
					return false;
				}
			}

		}));
		this.customSlots.add(this.addSlot(new Slot(inv, 3, 149, 26) {
			private final int slot = 3;

			@Override
			public boolean mayPlace(ItemStack stack) {
				if (stack.is(MITag.ingredientsKey)){
					return true;
				}else{
					return false;
				}
			}

		}));
		this.customSlots.add(this.addSlot(new Slot(inv, 4, 176, 26) {
			private final int slot = 4;

			@Override
			public boolean mayPlace(ItemStack stack) {
				if (stack.is(MITag.ingredientsKey)){
					return true;
				}else {
					return false;
				}
			}

		}));
		this.customSlots.add(this.addSlot(new Slot(inv, 5, 203, 26) {
			private final int slot = 5;

			@Override
			public boolean mayPlace(ItemStack stack) {
				if (stack.is(MITag.ingredientsKey)){
					return true;
				}else {
					return false;
				}
			}

		}));
		this.customSlots.add(this.addSlot(new Slot(inv, 6, 239, 44) {
			private final int slot = 6;

			@Override
			public boolean mayPlace(ItemStack stack) {
				return false;
			}
		}));
		this.customSlots.add(this.addSlot(new Slot(inv, 7, 14, 26) {
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
		this.customSlots.add(this.addSlot(new Slot(inv, 8, 14, 53) {
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
		this.customSlots.add(this.addSlot(new Slot(inv, 9, 14, 80) {
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
		this.customSlots.add(this.addSlot(new Slot(inv, 10, 14, 107) {
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
		this.customSlots.add(this.addSlot(new Slot(inv, 11, 14, 134) {
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
			while (!p_38904_.isEmpty()) {
				if (p_38907_) {
					if (i < p_38905_) {
						break;
					}
				} else if (i >= p_38906_) {
					break;
				}
				Slot slot = this.slots.get(i);
				ItemStack itemstack = slot.getItem();
				if (slot.mayPlace(itemstack) && !itemstack.isEmpty() && ItemStack.isSameItemSameTags(p_38904_, itemstack)) {
					int j = itemstack.getCount() + p_38904_.getCount();
					int maxSize = Math.min(slot.getMaxStackSize(), p_38904_.getMaxStackSize());
					if (j <= maxSize) {
						p_38904_.setCount(0);
						itemstack.setCount(j);
						slot.set(itemstack);
						flag = true;
					} else if (itemstack.getCount() < maxSize) {
						p_38904_.shrink(maxSize - itemstack.getCount());
						itemstack.setCount(maxSize);
						slot.set(itemstack);
						flag = true;
					}
				}
				if (p_38907_) {
					--i;
				} else {
					++i;
				}
			}
		}
		if (!p_38904_.isEmpty()) {
			if (p_38907_) {
				i = p_38906_ - 1;
			} else {
				i = p_38905_;
			}
			while (true) {
				if (p_38907_) {
					if (i < p_38905_) {
						break;
					}
				} else if (i >= p_38906_) {
					break;
				}
				Slot slot1 = this.slots.get(i);
				ItemStack itemstack1 = slot1.getItem();
				if (itemstack1.isEmpty() && slot1.mayPlace(p_38904_)) {
					if (p_38904_.getCount() > slot1.getMaxStackSize()) {
						slot1.setByPlayer(p_38904_.split(slot1.getMaxStackSize()));
					} else {
						slot1.setByPlayer(p_38904_.split(p_38904_.getCount()));
					}
					slot1.setChanged();
					flag = true;
					break;
				}
				if (p_38907_) {
					--i;
				} else {
					++i;
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
				for (int j = 0; j < inv.stacks.size(); ++j) {
					if (j == 0)
						continue;
					if (j == 12)
						continue;
					if (j == 7)
						continue;
					if (j == 8)
						continue;
					if (j == 9)
						continue;
					if (j == 10)
						continue;
					if (j == 11)
						continue;
					playerIn.drop(inv.stacks.get(j), false);
				}
			} else {
				for (int i = 0; i < inv.stacks.size(); ++i) {
					if (i == 0)
						continue;
					if (i == 12)
						continue;
					if (i == 7)
						continue;
					if (i == 8)
						continue;
					if (i == 9)
						continue;
					if (i == 10)
						continue;
					if (i == 11)
						continue;
					playerIn.drop(inv.stacks.get(i), false);
				}
			}
		}
	}

}
