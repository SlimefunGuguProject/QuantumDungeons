package io.github.schntgaispock.quantumdungeons.core.listeners;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import io.github.schntgaispock.quantumdungeons.QuantumDungeons;

public class DungeonLootingListener implements Listener {
    
    @EventHandler(ignoreCancelled = true)
    public void onReflect(PlayerInteractEvent e) {
        if (!e.getClickedBlock().getWorld().getName().equals(QuantumDungeons.getDungeonWorldName())) return;
        if (e.getClickedBlock().getType() != Material.CHEST) return;

    }

}
