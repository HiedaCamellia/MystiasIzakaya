
package org.hiedacamellia.mystiasizakaya.common.menu;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.level.Level;
import org.hiedacamellia.mystiasizakaya.registries.MIMenu;

public class LedgerMenu extends BaseMenu {
	public final Level world;
	public final Player entity;

	public LedgerMenu(int containerId, Inventory inventory, RegistryFriendlyByteBuf buf) {
		this(containerId, inventory, inventory.player);
	}

	public LedgerMenu(int id, Inventory inv, Player player) {
		super(MIMenu.LEDGER_UI.get(), id);
		this.entity = inv.player;
		this.world = inv.player.level();

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
