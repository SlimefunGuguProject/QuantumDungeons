package io.github.schntgaispock.quantumdungeons.core.slimefun.items.catalysts;

import java.util.Collection;

import javax.annotation.ParametersAreNonnullByDefault;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.inventory.ItemStack;

import io.github.schntgaispock.quantumdungeons.core.slimefun.recipes.CatalystMouldRecipe;
import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.handlers.BlockUseHandler;

public class CatalystMould extends SlimefunItem {

    public CatalystMould(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
    }
    
    @Override
    public void preRegister() {
        addItemHandler((BlockUseHandler) this::onRightClick);
    }

    @EventHandler
    @ParametersAreNonnullByDefault
    private void onRightClick(PlayerRightClickEvent e) {
        ItemStack item = e.getItem();
        if (
            item == null ||
            item.getType() == Material.WATER_BUCKET ||
            item.getType() == Material.BUCKET
        ) return;

        e.cancel();

        Block block;
        if (
            e.getSlimefunItem().isEmpty() ||
            !e.getSlimefunItem().get().getId().equals("BLANK_DUNGEON_CATALYST") ||
            e.getClickedBlock().isEmpty() ||
            (block = e.getClickedBlock().get()).getType() != Material.WATER_CAULDRON
        ) return;

        Player p = e.getPlayer();

        Collection<Entity> givenItems = block
            .getWorld()
            .getNearbyEntities(
                block.getLocation().add(0.5, 0.5, 0.5),
                0.5, 0.5, 0.5,
                (Entity entity) -> {
                    return entity instanceof Item;
                }
            );

        for (CatalystMouldRecipe recipe : CatalystMouldRecipe.getRecipes().values()) {
            if (recipe.useRecipe(givenItems)) {
                ItemStack stack = p.getInventory().getItemInMainHand();
                stack.setAmount(stack.getAmount() - 1);
                p.getInventory().setItemInMainHand(stack);

                for (ItemStack output : recipe.getOutput()) {
                    p.getWorld().dropItemNaturally(block.getLocation(), output);
                }

                p.playSound(p.getLocation(), Sound.ENTITY_SLIME_SQUISH_SMALL, SoundCategory.PLAYERS, 1.0f, 1.0f);

                return;
            }
        }

        System.out.println(givenItems);
        p.sendMessage("Unknown Recipe!");
        

    }

}
