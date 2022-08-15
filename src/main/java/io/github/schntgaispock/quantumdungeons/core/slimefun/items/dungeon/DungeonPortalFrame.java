package io.github.schntgaispock.quantumdungeons.core.slimefun.items.dungeon;


import java.util.List;

import javax.annotation.ParametersAreNonnullByDefault;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import io.github.schntgaispock.quantumdungeons.core.slimefun.QDBlockStorage;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.handlers.BlockBreakHandler;
import io.github.thebusybiscuit.slimefun4.core.handlers.BlockPlaceHandler;
import lombok.Getter;
import me.mrCookieSlime.Slimefun.api.BlockStorage;

public class DungeonPortalFrame extends SlimefunItem {

    private static final @Getter Vector[] searchLocations = new Vector[] {
            new Vector(2, 0, 0),
            new Vector(0, 0, 2),
            new Vector(-2, 0, 0),
            new Vector(0, 0, -2)
    };

    public DungeonPortalFrame(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
    }

    @Override
    public void preRegister() {
        addItemHandler(new BlockPlaceHandler(false) {

            @Override
            @EventHandler(ignoreCancelled = true)
            @ParametersAreNonnullByDefault
            public void onPlayerPlace(BlockPlaceEvent e) {
                Block block = e.getBlock();

                for (Vector vector : searchLocations) {
                    Location newLocation = block.getLocation().add(vector);

                    if (!BlockStorage.check(newLocation, "DUNGEON_PORTAL_MOUND"))
                        continue;

                    short connectedFrames = QDBlockStorage.getShort(block, "connected_frames");
                    QDBlockStorage.set(newLocation, "connected_frames", connectedFrames + 1);

                }
            }
        });

        addItemHandler(new BlockBreakHandler(false, false) {

            @Override
            @EventHandler(ignoreCancelled = true)
            @ParametersAreNonnullByDefault
            public void onPlayerBreak(BlockBreakEvent e, ItemStack item, List<ItemStack> drops) {
                Block block = e.getBlock();

                for (Vector vector : searchLocations) {
                    Location newLocation = block.getLocation().add(vector);

                    if (!BlockStorage.check(newLocation, "DUNGEON_PORTAL_MOUND"))
                        continue;

                    short connectedFrames = QDBlockStorage.getShort(block, "connected_frames");
                    QDBlockStorage.set(newLocation, "connected_frames", connectedFrames - 1);

                }
            }
        });
    }

}
