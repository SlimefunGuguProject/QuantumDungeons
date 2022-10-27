package io.github.schntgaispock.strophodungeons.core.slimefun.items.records;

import java.util.Set;

import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;

import io.github.schntgaispock.strophodungeons.core.slimefun.SDGroups;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import lombok.Getter;

@Getter
public class Record extends SlimefunItem {

    private final Set<PotionEffect> buffs;

    public Record(SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe,
            PotionEffect... buffs) {
        super(SDGroups.RECORDS, item, recipeType, recipe);
        this.buffs = Set.of(buffs);
    }
    
}
