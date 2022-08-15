package io.github.schntgaispock.quantumdungeons.core.setup;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import io.github.schntgaispock.quantumdungeons.QuantumDungeons;
import io.github.schntgaispock.quantumdungeons.core.slimefun.QDGroups;
import io.github.schntgaispock.quantumdungeons.core.slimefun.QDRecipes;
import io.github.schntgaispock.quantumdungeons.core.slimefun.QDStacks;
import io.github.schntgaispock.quantumdungeons.core.slimefun.items.dungeon.DungeonPortalMound;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import lombok.experimental.UtilityClass;

@UtilityClass
public class QDItemSetup {
    
    public static void setup() {

        QuantumDungeons qd = QuantumDungeons.getInstance();

        // ---- Vanilla Ingredients ----

        final ItemStack CRYING_OBSIDIAN = new ItemStack(Material.CRYING_OBSIDIAN);
        final ItemStack GLOWSTONE = new ItemStack(Material.GLOWSTONE);

        // ---- Materials ----

        new SlimefunItem(
            QDGroups.MATERIALS,
            QDStacks.FRACTURED_REALITY_SHARD,
            QDRecipes.KILLING,
            QDRecipes.single(QDStacks.GUIDE_VOIDAL)
        ).register(qd);

        new SlimefunItem(
            QDGroups.MATERIALS,
            QDStacks.RECONSTRUCTED_REALITY_SHARD,
            QDRecipes.REFLECTING,
            QDRecipes.single(QDStacks.FRACTURED_REALITY_SHARD)
        ).register(qd);

        new SlimefunItem(
            QDGroups.MATERIALS,
            QDStacks.DUNGEON_PORTAL_FRAME,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[] {
                CRYING_OBSIDIAN,
                QDStacks.RECONSTRUCTED_REALITY_SHARD,
                CRYING_OBSIDIAN,
                QDStacks.RECONSTRUCTED_REALITY_SHARD,
                SlimefunItems.ANCIENT_PEDESTAL,
                QDStacks.RECONSTRUCTED_REALITY_SHARD,
                CRYING_OBSIDIAN,
                QDStacks.RECONSTRUCTED_REALITY_SHARD,
                CRYING_OBSIDIAN
            }
        ).register(qd);

        new DungeonPortalMound(
            QDGroups.MATERIALS,
            QDStacks.DUNGEON_PORTAL_SWITCH,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[] {
                CRYING_OBSIDIAN,
                QDStacks.RECONSTRUCTED_REALITY_SHARD,
                CRYING_OBSIDIAN,
                QDStacks.RECONSTRUCTED_REALITY_SHARD,
                GLOWSTONE,
                QDStacks.RECONSTRUCTED_REALITY_SHARD,
                CRYING_OBSIDIAN,
                QDStacks.RECONSTRUCTED_REALITY_SHARD,
                CRYING_OBSIDIAN
            }
        ).register(qd);


    }

}
