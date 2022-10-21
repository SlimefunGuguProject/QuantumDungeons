package io.github.schntgaispock.strophodungeons.core.slimefun;

import javax.annotation.Nonnull;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import io.github.schntgaispock.strophodungeons.Strophodungeons;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import lombok.experimental.UtilityClass;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.MachineRecipe;

@UtilityClass
public class SDRecipes {

    public static class SDRecipeType extends RecipeType {

        public static final RecipeType REFLECTING = new SDRecipeType("reflecting", SDStacks.RECIPE_REFLECTING);
        public static final RecipeType MOULDING = new SDRecipeType("moulding", SDStacks.RECIPE_MOULDING);
        public static final RecipeType KILLING = new SDRecipeType("mending", SDStacks.RECIPE_KILLING);
        public static final RecipeType LOOTING = new SDRecipeType("looting", SDStacks.RECIPE_LOOTING);
        public static final RecipeType MENDING = new SDRecipeType("mending", SDStacks.RECIPE_MENDING);
        public static final RecipeType BOOSTING = new SDRecipeType("boosting", SDStacks.RECIPE_BOOSTING);
        public static final RecipeType DUMMY = new SDRecipeType("dummy", new ItemStack(Material.BARRIER));

        public SDRecipeType(@Nonnull String key, ItemStack item) {
            super(Strophodungeons.newNamespacedKey(key), item);
        }
    
    }

    public static ItemStack[] single(ItemStack item) {
        ItemStack[] recipe = new ItemStack[9];
        recipe[4] = item;
        return recipe;
    }
    
    public static ItemStack[] catalyst(ItemStack... items) {
        ItemStack[] recipe = SDRecipes.collection(items, 6);
        
        recipe[7] = SDStacks.BLANK_DUNGEON_CATALYST;
        return recipe;
    }
    
    public static ItemStack[] collection(ItemStack... items) {
        return SDRecipes.collection(items, 9);
    }
    
    private static ItemStack[] collection(ItemStack[] items, int maxLength) {
        ItemStack[] recipe = new ItemStack[9];

        int l = Math.min(items.length, maxLength);
        for (int i = 0; i < l; i++) {
            recipe[i] = items[i];
        }
        return recipe;
    }

    public static ItemStack[] cyclic(ItemStack outer, ItemStack inner) {
        return new ItemStack[] {outer, outer, outer, outer, inner, outer, outer, outer, outer};
    }

    public static ItemStack[] cyclic(ItemStack outer) {
        return SDRecipes.cyclic(outer, null);
    }

    public static ItemStack[] cyclicAlternating(ItemStack corner, ItemStack middle, ItemStack inner) {
        return new ItemStack[] {corner, middle, corner, middle, inner, middle, corner, middle, corner};
    }

    public static ItemStack[] cyclicAlternating(ItemStack corner, ItemStack middle) {
        return SDRecipes.cyclicAlternating(corner, middle, null);
    }

    public static MachineRecipe machineSingle(int seconds, ItemStack input, ItemStack output) {
        return new MachineRecipe(seconds, new ItemStack[] { input }, new ItemStack[] { output });
    }
    
}
