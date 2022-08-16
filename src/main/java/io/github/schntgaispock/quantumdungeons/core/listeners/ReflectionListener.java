package io.github.schntgaispock.quantumdungeons.core.listeners;

import org.bukkit.Location;
import org.bukkit.entity.ItemFrame;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

import io.github.schntgaispock.quantumdungeons.util.QDEffects;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import me.mrCookieSlime.Slimefun.api.BlockStorage;

public class ReflectionListener implements Listener {
    
    @EventHandler(ignoreCancelled = true)
    public void onReflect(PlayerInteractEntityEvent e) {
        if (!(e.getRightClicked() instanceof ItemFrame)) return;
        if (SlimefunItem.getByItem(e.getPlayer().getInventory().getItemInMainHand()) == null) return;

        ItemFrame frame = (ItemFrame) e.getRightClicked();
        Location reflectionLocation = frame.getLocation().add(frame.getAttachedFace().getDirection());

        if (!BlockStorage.check(reflectionLocation, "BINDING_GLASS")) return;

        QDEffects.bindFracturedRealityShard(frame);
    }

}
