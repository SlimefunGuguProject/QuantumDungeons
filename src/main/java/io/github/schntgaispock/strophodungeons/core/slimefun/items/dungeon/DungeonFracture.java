package io.github.schntgaispock.strophodungeons.core.slimefun.items.dungeon;

import java.util.Optional;

import javax.annotation.Nonnull;

import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;

import io.github.schntgaispock.strophodungeons.core.slimefun.SDGroups;
import io.github.schntgaispock.strophodungeons.core.slimefun.SDRecipes.SDRecipeType;
import io.github.schntgaispock.strophodungeons.core.slimefun.items.misc.HiddenItem;
import io.github.schntgaispock.strophodungeons.util.SDEffects;
import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.core.handlers.BlockUseHandler;
import lombok.Getter;
import me.mrCookieSlime.CSCoreLibPlugin.Configuration.Config;
import me.mrCookieSlime.Slimefun.Objects.handlers.BlockTicker;
import me.mrCookieSlime.Slimefun.api.BlockStorage;

@SuppressWarnings("deprecation")
public class DungeonFracture extends HiddenItem {

    private final @Getter Particle particle;

    public DungeonFracture(@Nonnull String id, Particle particle) {
        super(SDGroups.DUNGEON, new SlimefunItemStack(id, new ItemStack(Material.BARRIER)), SDRecipeType.DUMMY, new ItemStack[9]);

        this.particle = particle;
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

            SDEffects.mendFracture(e.getClickedBlock().get());
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
                SDEffects.animateFracture(block, particle);
            }
            
        };
    }

}
