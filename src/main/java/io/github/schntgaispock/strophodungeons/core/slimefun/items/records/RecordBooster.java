package io.github.schntgaispock.strophodungeons.core.slimefun.items.records;

import java.util.List;

import javax.annotation.Nonnull;

import java.util.LinkedList;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import io.github.schntgaispock.strophodungeons.core.slimefun.SDRecipes;
import io.github.schntgaispock.strophodungeons.core.slimefun.SDStacks;
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
    public @Nonnull String getMachineIdentifier() {
        return getId();
    }

    @Override
    public ItemStack getProgressBar() {
        return new ItemStack(Material.SHIELD);
    }

    @Override
    public @Nonnull List<ItemStack> getDisplayRecipes() {
        List<ItemStack> recipes = new LinkedList<>();

        for (MachineRecipe recipe : this.recipes) {
            recipes.add(recipe.getInput()[0]);
            recipes.add(recipe.getOutput()[0]);
        }

        return recipes;
    }

    @Override
    public void register(@Nonnull SlimefunAddon addon) {
        setCapacity(8192);
        setEnergyConsumption(1024);
        setProcessingSpeed(1);

        recipes.add(SDRecipes.machineSingle(5*60, SDStacks.RECORD_OF_VALOR, SDStacks.RECORD_OF_VALOR_BOOSTED));
        recipes.add(SDRecipes.machineSingle(5*60, SDStacks.RECORD_OF_AEGIS, SDStacks.RECORD_OF_AEGIS_BOOSTED));
        recipes.add(SDRecipes.machineSingle(5*60, SDStacks.RECORD_OF_ORDER, SDStacks.RECORD_OF_ORDER_BOOSTED));
        recipes.add(SDRecipes.machineSingle(5*60, SDStacks.RECORD_OF_POWER, SDStacks.RECORD_OF_POWER_BOOSTED));
        recipes.add(SDRecipes.machineSingle(5*60, SDStacks.RECORD_OF_HASTE, SDStacks.RECORD_OF_HASTE_BOOSTED));

        super.register(addon);
    }
}
