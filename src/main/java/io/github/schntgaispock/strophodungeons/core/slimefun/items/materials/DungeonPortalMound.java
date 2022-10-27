package io.github.schntgaispock.strophodungeons.core.slimefun.items.materials;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.block.data.type.RespawnAnchor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import io.github.schntgaispock.strophodungeons.Strophodungeons;
import io.github.schntgaispock.strophodungeons.core.slimefun.SDBlockStorage;
import io.github.schntgaispock.strophodungeons.core.timer.Cooldown;
import io.github.schntgaispock.strophodungeons.util.SDEffects;
import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.handlers.BlockPlaceHandler;
import io.github.thebusybiscuit.slimefun4.core.handlers.BlockUseHandler;
import lombok.Getter;
import me.mrCookieSlime.Slimefun.api.BlockStorage;

public class DungeonPortalMound extends SlimefunItem {

    private static final @Getter Vector[] searchLocations = new Vector[] {
        new Vector(3, 0, 0),
        new Vector(0, 0, 3),
        new Vector(-3, 0, 0),
        new Vector(0, 0, -3)
    };

    public DungeonPortalMound(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
    }

    @Override
    public void preRegister() {
        addItemHandler((BlockUseHandler) this::onRightClick);

        addItemHandler(new BlockPlaceHandler(false) {

            @Override
            @EventHandler
            @ParametersAreNonnullByDefault
            public void onPlayerPlace(@Nonnull BlockPlaceEvent e) {
                Location l = e.getBlock().getLocation();

                short connected = 0;
                for (Vector vector : searchLocations) {
                    Location newLocation = l.add(vector);

                    if (newLocation != null && BlockStorage.check(newLocation, "DUNGEON_PORTAL_FRAME")) connected++;

                }

                SDBlockStorage.set(l, "connected_frames", connected);
                updateLocation(l);
            }
        });
    }

    @EventHandler(priority = EventPriority.LOW)
    @ParametersAreNonnullByDefault
    private void onRightClick(PlayerRightClickEvent e) {
        e.cancel();

        if (e.getSlimefunBlock().isEmpty())
            return;
        if (e.getSlimefunItem().isEmpty())
            return;

        Block block = e.getClickedBlock().get();
        ItemStack item = e.getItem();
        SlimefunItem slimefunItem = e.getSlimefunItem().get();
        Player p = e.getPlayer();

        String id;
        String dungeonType;
        switch (id = slimefunItem.getId()) {
            case 
                "BASIC_DUNGEON_CATALYST",
                "VIVACIOUS_DUNGEON_CATALYST",
                "TENEBROUS_DUNGEON_CATALYST",
                "ANCIENT_DUNGEON_CATALYST":
                
                dungeonType = id.split("_")[0].toLowerCase();
                break;

            default:
                p.sendMessage("未知的门户催化剂!");
                return;
        }

        short connectedFrames = SDBlockStorage.getShort(block, "connected_frames");
        if (connectedFrames < 4) {
            p.sendMessage("没有足够的框架连接!");
            return;
        }

        // TODO: Check 7x7 space is empty

        Cooldown cooldown;
        if (
            !(cooldown = Strophodungeons
                .getCooldownManager()
                .getCooldowns()
                .get("dungeon"))
                .check(p.getUniqueId())
        ) {
            p.sendMessage("地下城创建冷却时间: " + cooldown.elapsed(p.getUniqueId()) / 1000*60 + "s");
            return;
        }

        // TODO: Check if dungeon world is busy

        // TODO: Generate Dungeon
        p.sendMessage("创建一个" + dungeonType + " 地牢...");

        item.setAmount(item.getAmount() - 1);

        SDEffects.catalysePortal(dungeonType, block.getLocation());
    }


    public static void updateLocation(Location l) {
        // Assume the location has already been checked for correctness
        RespawnAnchor mound = (RespawnAnchor) l.getBlock().getBlockData();

        mound.setCharges(
            Math.max(
                Math.min(
                    SDBlockStorage.getInteger(l, "connected_frames"),
                    4), 
                    0
            )
        );   
        
        l.getBlock().setBlockData(mound);
    }

}
