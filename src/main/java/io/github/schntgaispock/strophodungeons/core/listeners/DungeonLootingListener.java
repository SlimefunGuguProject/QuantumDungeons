package io.github.schntgaispock.strophodungeons.core.listeners;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import io.github.schntgaispock.strophodungeons.Strophodungeons;

public class DungeonLootingListener implements Listener {
    
    @EventHandler(ignoreCancelled = true)
    public void onReflect(PlayerInteractEvent e) {
        if (!e.getClickedBlock().getWorld().getName().equals(Strophodungeons.getDungeonWorldName())) return;
        if (e.getClickedBlock().getType() != Material.CHEST) return;

    }

}
