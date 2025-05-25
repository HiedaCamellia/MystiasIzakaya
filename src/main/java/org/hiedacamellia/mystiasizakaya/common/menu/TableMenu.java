
package org.hiedacamellia.mystiasizakaya.common.menu;

import net.minecraft.core.BlockPos;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.SimpleContainerData;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.ItemStackHandler;
import net.neoforged.neoforge.items.SlotItemHandler;
import org.hiedacamellia.mystiasizakaya.core.config.MICommonConfig;
import org.hiedacamellia.mystiasizakaya.core.config.json.ItemPriceAddon;
import org.hiedacamellia.mystiasizakaya.registries.MIMenu;
import org.hiedacamellia.mystiasizakaya.registries.MITag;

import java.util.HashMap;
import java.util.Map;

public class TableMenu extends BaseMenu {
	public final Level world;
	public final Player entity;
	public BlockPos pos;
	private ContainerLevelAccess access = ContainerLevelAccess.NULL;
	private final Map<Integer, Slot> customSlots = new HashMap<>();

	public TableMenu(int containerId, Inventory inventory, RegistryFriendlyByteBuf buf) {
		this(containerId, inventory, ContainerLevelAccess.NULL,buf.readBlockPos());
	}

	public TableMenu(int containerId, Inventory inventory, BlockPos pos) {
		this(containerId, inventory, ContainerLevelAccess.NULL,pos);
	}

	public TableMenu(int containerId, Inventory inventory, ContainerLevelAccess access, BlockPos pos) {
		this(containerId, inventory, access, new ItemStackHandler(10), new SimpleContainerData(9),pos);
	}

	public TableMenu(int id, Inventory inv, ContainerLevelAccess access, IItemHandler itemHandler, ContainerData containerData, BlockPos pos) {
		super(MIMenu.TABLE_UI.get(), id);
		this.entity = inv.player;
		this.world = inv.player.level();
		this.pos = pos;

		this.customSlots.put(0, this.addSlot(new SlotItemHandler(itemHandler, 0, 70, 30) {
			@Override
			public boolean mayPlace(ItemStack stack) {
				return stack.is(MITag.cuisinesKey)|| MICommonConfig.ENABLE_ALL_CUISINES.get() || ItemPriceAddon.hasPrice(stack);
			}
		}));
		this.customSlots.put(1, this.addSlot(new SlotItemHandler(itemHandler, 1, 100, 30) {
			@Override
			public boolean mayPlace(ItemStack stack) {
                return stack.is(MITag.beveragesKey)|| MICommonConfig.ENABLE_ALL_BEVERAGES.get() || ItemPriceAddon.hasPrice(stack);
			}
		}));

		for (int si = 0; si < 3; ++si)
			for (int sj = 0; sj < 9; ++sj)
				this.addSlot(new Slot(inv, sj + (si + 1) * 9, 10 + sj * 18, 2 + 84 + si * 18));
		for (int si = 0; si < 9; ++si)
			this.addSlot(new Slot(inv, si, 10 + si * 18, 2 + 142));
	}

	@Override
	public boolean stillValid(Player player) {
		return true;
	}

	@Override
	protected int getSize() {
		return 2;
	}

}
