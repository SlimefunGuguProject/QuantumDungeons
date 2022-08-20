package io.github.schntgaispock.quantumdungeons.core.slimefun.items.catalysts;

import java.util.Optional;

import javax.annotation.ParametersAreNonnullByDefault;

import org.bukkit.event.EventHandler;
import org.bukkit.inventory.ItemStack;

import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;

public class Catalyst extends SlimefunItem {

    public Catalyst(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
    }

    
    @Override
    public void preRegister() {
        addItemHandler((ItemUseHandler) this::onRightClick);
    }

    @EventHandler
    @ParametersAreNonnullByDefault
    private void onRightClick(PlayerRightClickEvent e) {
        Optional<SlimefunItem> block = e.getSlimefunBlock();
        String id;
        if (block.isEmpty()) e.cancel();
        else if (
            !(id = block.get().getId()).equals("DUNGEON_PORTAL_MOUND") &&
            !id.equals("CATALYST_MOULD")
        ) e.cancel();
    }
    
}
