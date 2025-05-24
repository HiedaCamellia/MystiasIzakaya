package org.hiedacamellia.mystiasizakaya.common.menu;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.Slot;
import org.hiedacamellia.mystiasizakaya.registries.MIMenu;

public class ItemPriceAddonMenu extends BaseMenu{

    public ItemPriceAddonMenu(int i, Inventory inventory, Player player) {
        this(i,inventory);
    }
    public ItemPriceAddonMenu(int containerId, Inventory inventory, RegistryFriendlyByteBuf buf) {
        this(containerId, inventory);
    }

    public ItemPriceAddonMenu(int id, Inventory inv) {
        super(MIMenu.PRICE_ADDON_UI.get(), id);

        for (int si = 0; si < 3; ++si)
            for (int sj = 0; sj < 9; ++sj)
                this.addSlot(new Slot(inv, sj + (si + 1) * 9, 10 + sj * 18, 2 + 84 + si * 18));
        for (int si = 0; si < 9; ++si)
            this.addSlot(new Slot(inv, si, 10 + si * 18, 2 + 142));

    }


    @Override
    protected int getSize() {
        return 0;
    }

    @Override
    public boolean stillValid(Player player) {
        return true;
    }
}
