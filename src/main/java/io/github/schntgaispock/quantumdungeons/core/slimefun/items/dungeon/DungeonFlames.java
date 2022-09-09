package io.github.schntgaispock.quantumdungeons.core.slimefun.items.dungeon;

import java.util.Optional;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;

import io.github.schntgaispock.quantumdungeons.core.slimefun.QDGroups;
import io.github.schntgaispock.quantumdungeons.core.slimefun.QDRecipes.QDRecipeType;
import io.github.schntgaispock.quantumdungeons.core.slimefun.items.misc.HiddenItem;
import io.github.schntgaispock.quantumdungeons.util.QDEffects;
import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.core.handlers.BlockUseHandler;
import me.mrCookieSlime.CSCoreLibPlugin.Configuration.Config;
import me.mrCookieSlime.Slimefun.Objects.handlers.BlockTicker;
import me.mrCookieSlime.Slimefun.api.BlockStorage;

@SuppressWarnings("deprecation")
public class DungeonFlames extends HiddenItem {

    public DungeonFlames() {
        super(QDGroups.DUNGEON, new SlimefunItemStack("DUNGEON_FLAMES", new ItemStack(Material.BARRIER)), QDRecipeType.DUMMY, new ItemStack[9]);
    }

    @Override
    public void preRegister() {
        addItemHandler(onTick());

        addItemHandler((BlockUseHandler) (PlayerRightClickEvent e) -> {
            Optional<SlimefunItem> o = e.getSlimefunItem();
            if (o.isEmpty()) return;
            if (e.getClickedBlock().isEmpty()) return;
            if (!o.get().getId().equals("MENDING_GLASS")) return;

            BlockStorage.clearBlockInfo(e.getClickedBlock().get(), true);

            QDEffects.mendFracture(e.getClickedBlock().get());
        });
    }
    
    public BlockTicker onTick() {
        return new BlockTicker() {

            @Override
            public boolean isSynchronized() {
                return false;
            }

            @Override
            public void tick(Block block, SlimefunItem item, Config config) {
                QDEffects.animateDungeonFlames(block);
            }
            
        };
    }

}
