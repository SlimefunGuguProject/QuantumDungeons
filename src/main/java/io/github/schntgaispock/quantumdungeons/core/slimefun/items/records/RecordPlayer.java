package io.github.schntgaispock.quantumdungeons.core.slimefun.items.records;

import javax.annotation.ParametersAreNonnullByDefault;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;

import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;

public class RecordPlayer extends SlimefunItem {

    public RecordPlayer(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
    }

    @Override
    public void preRegister() {
        addItemHandler(new ItemUseHandler() {

            @Override
            @EventHandler(ignoreCancelled = true)
            @ParametersAreNonnullByDefault
            public void onRightClick(PlayerRightClickEvent e) {
                Player p = e.getPlayer();
                ItemStack offhand = p.getInventory().getItemInOffHand();
                if (offhand == null) return;

                SlimefunItem item = getByItem(offhand);
                if (item == null) return;
                if (!(item instanceof Record)) return;

                Record record = (Record) item;
                for (PotionEffect effect : record.getBuffs()) {
                    p.addPotionEffect(effect);
                }
            }
        });
    }
    
}
