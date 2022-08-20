package io.github.schntgaispock.quantumdungeons.core.slimefun.items.records;

import java.util.List;
import java.util.LinkedList;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import io.github.schntgaispock.quantumdungeons.core.slimefun.QDRecipes;
import io.github.schntgaispock.quantumdungeons.core.slimefun.QDStacks;
import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.RecipeDisplayItem;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.AContainer;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.MachineRecipe;

public class RecordBooster extends AContainer implements RecipeDisplayItem {

    public RecordBooster(ItemGroup category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(category, item, recipeType, recipe);
    }

    @Override
    public String getMachineIdentifier() {
        return getId();
    }

    @Override
    public ItemStack getProgressBar() {
        return new ItemStack(Material.SHIELD);
    }

    @Override
    public List<ItemStack> getDisplayRecipes() {
        List<ItemStack> recipes = new LinkedList<>();

        for (MachineRecipe recipe : this.recipes) {
            recipes.add(recipe.getInput()[0]);
            recipes.add(recipe.getOutput()[0]);
        }

        return recipes;
    }

    @Override
    public void register(SlimefunAddon addon) {
        setCapacity(8192);
        setEnergyConsumption(1024);
        setProcessingSpeed(1);

        recipes.add(QDRecipes.machineSingle(5*60, QDStacks.RECORD_OF_VALOR, QDStacks.RECORD_OF_VALOR_BOOSTED));
        recipes.add(QDRecipes.machineSingle(5*60, QDStacks.RECORD_OF_AEGIS, QDStacks.RECORD_OF_AEGIS_BOOSTED));
        recipes.add(QDRecipes.machineSingle(5*60, QDStacks.RECORD_OF_ORDER, QDStacks.RECORD_OF_ORDER_BOOSTED));
        recipes.add(QDRecipes.machineSingle(5*60, QDStacks.RECORD_OF_POWER, QDStacks.RECORD_OF_POWER_BOOSTED));
        recipes.add(QDRecipes.machineSingle(5*60, QDStacks.RECORD_OF_HASTE, QDStacks.RECORD_OF_HASTE_BOOSTED));

        super.register(addon);
    }
}
