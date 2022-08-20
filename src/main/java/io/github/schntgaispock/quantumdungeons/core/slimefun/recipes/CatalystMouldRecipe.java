package io.github.schntgaispock.quantumdungeons.core.slimefun.recipes;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;

import lombok.Getter;

@Getter
public class CatalystMouldRecipe {

    private static final @Getter Map<String, CatalystMouldRecipe> recipes = new HashMap<>();
    
    private final Map<Material, ItemStack> input = new HashMap<>();
    private final Set<ItemStack> output;

    public CatalystMouldRecipe(ItemStack[] input, ItemStack[] output) {
        for (ItemStack item : input)  this.input.put(item.getType(), item);
        this.output = Set.of(output);
    }

    public boolean useRecipe(Collection<Entity> givenItems) {
        System.out.println(givenItems);
        if (givenItems.size() < input.size()) return false;

        Map<Material, Item> found = new HashMap<>();

        for (Entity entity : givenItems) {
            Item itemEntity = (Item) entity;
            ItemStack item = itemEntity.getItemStack();
            Material material = item.getType();
            if (
                input.containsKey(material) &&
                item.getAmount() >= input.get(material).getAmount()
            ) {
                found.put(material, itemEntity);
            }
        }

        if (found.size() != input.size()) {
            System.out.println(found.keySet());
            System.out.println(input.keySet());
            return false;
        }

        for (Entry<Material, Item> e : found.entrySet()) {
            Item item = e.getValue();
            ItemStack stack = item.getItemStack();
            stack.setAmount(stack.getAmount() - input.get(e.getKey()).getAmount());
            item.setItemStack(stack);
        }

        return true;
    }


}
