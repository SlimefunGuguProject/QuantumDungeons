package io.github.schntgaispock.strophodungeons.core.listeners;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.ItemFrame;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

import io.github.schntgaispock.strophodungeons.util.SDEffects;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import me.mrCookieSlime.Slimefun.api.BlockStorage;

public class ReflectionListener implements Listener {
    
    @EventHandler
    public void onReflect(PlayerInteractEntityEvent e) {
        if (!(e.getRightClicked() instanceof ItemFrame)) return;
        ItemFrame frame = (ItemFrame) e.getRightClicked();

        SlimefunItem item;
        if ((item = SlimefunItem.getByItem(e.getPlayer().getInventory().getItemInMainHand())) == null) return;
        if (!item.getId().equals("FRACTURED_REALITY_SHARD")) return;
        if (frame.getItem() != null && frame.getItem().getType() != Material.AIR) return;

        Block reflectionBlock = frame.getLocation().add(frame.getAttachedFace().getOppositeFace().getDirection()).getBlock();

        if (!BlockStorage.check(reflectionBlock, "BINDING_GLASS")) return;

        SDEffects.bindFracturedRealityShard(frame);
    }

}
