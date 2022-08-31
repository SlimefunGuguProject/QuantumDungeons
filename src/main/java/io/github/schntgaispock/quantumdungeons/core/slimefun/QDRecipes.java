package io.github.schntgaispock.quantumdungeons.core.slimefun;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import io.github.schntgaispock.quantumdungeons.QuantumDungeons;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import lombok.experimental.UtilityClass;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.MachineRecipe;

@UtilityClass
public class QDRecipes {

    public static class QDRecipeType extends RecipeType {

        public static final RecipeType REFLECTING = new QDRecipeType("reflecting", QDStacks.RECIPE_REFLECTING);
        public static final RecipeType MOULDING = new QDRecipeType("moulding", QDStacks.RECIPE_MOULDING);
        public static final RecipeType KILLING = new QDRecipeType("mending", QDStacks.RECIPE_KILLING);
        public static final RecipeType LOOTING = new QDRecipeType("looting", QDStacks.RECIPE_LOOTING);
        public static final RecipeType MENDING = new QDRecipeType("mending", QDStacks.RECIPE_MENDING);
        public static final RecipeType BOOSTING = new QDRecipeType("boosting", QDStacks.RECIPE_BOOSTING);
        public static final RecipeType DUMMY = new QDRecipeType("dummy", new ItemStack(Material.BARRIER));

        public QDRecipeType(String key, ItemStack item) {
            super(QuantumDungeons.newNamespacedKey(key), item);
        }
    
    }

    public static ItemStack[] single(ItemStack item) {
        ItemStack[] recipe = new ItemStack[9];
        recipe[4] = item;
        return recipe;
    }
    
    public static ItemStack[] catalyst(ItemStack... items) {
        ItemStack[] recipe = QDRecipes.collection(items, 6);
        
        recipe[7] = QDStacks.BLANK_DUNGEON_CATALYST;
        return recipe;
    }
    
    public static ItemStack[] collection(ItemStack... items) {
        return QDRecipes.collection(items, 9);
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
        return QDRecipes.cyclic(outer, null);
    }

    public static ItemStack[] cyclicAlternating(ItemStack corner, ItemStack middle, ItemStack inner) {
        return new ItemStack[] {corner, middle, corner, middle, inner, middle, corner, middle, corner};
    }

    public static ItemStack[] cyclicAlternating(ItemStack corner, ItemStack middle) {
        return QDRecipes.cyclicAlternating(corner, middle, null);
    }

    public static MachineRecipe machineSingle(int seconds, ItemStack input, ItemStack output) {
        return new MachineRecipe(seconds, new ItemStack[] { input }, new ItemStack[] { output });
    }
    
}
