package com.raoulvdberge.refinedstorage.tile.grid.portable;

import com.raoulvdberge.refinedstorage.api.storage.IStorageCache;
import com.raoulvdberge.refinedstorage.api.storage.IStorageDisk;
import com.raoulvdberge.refinedstorage.apiimpl.storage.StorageTrackerItem;
import com.raoulvdberge.refinedstorage.inventory.ItemHandlerBase;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandlerModifiable;

import javax.annotation.Nullable;

public interface IPortableGrid {
    IStorageCache<ItemStack> getCache();

    @Nullable
    IStorageDisk<ItemStack> getStorage();

    void drainEnergy(int energy);

    int getEnergy();

    ItemHandlerBase getDisk();

    IItemHandlerModifiable getFilter();

    StorageTrackerItem getStorageTracker();
}
