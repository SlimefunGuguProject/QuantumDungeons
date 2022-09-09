package io.github.schntgaispock.quantumdungeons.core.slimefun.recipes;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.function.Predicate;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import lombok.Getter;

@Getter
public class CatalystMouldRecipe {

    private static final @Getter Map<String, CatalystMouldRecipe> recipes = new HashMap<>();

    // Drawback: can't have two items of the same material (Slimefun items, etc...)
    private final Map<Material, ItemStack> input = new HashMap<>();
    private final Map<Material, Predicate<ItemStack>> inputVerifiers = new HashMap<>();
    private final Set<ItemStack> output;

    public CatalystMouldRecipe(ItemStack[] input, ItemStack[] output) {
        for (ItemStack item : input) {
            this.input.put(item.getType(), item);
            this.inputVerifiers.put(item.getType(), getVerifier(item));
        }
        this.output = Set.of(output);
    }

    public boolean useRecipe(Collection<Entity> givenItems) {
        if (givenItems.size() < inputVerifiers.size())
            return false;

        Map<Material, Item> found = new HashMap<>();

        for (Entity entity : givenItems) {
            Item itemEntity = (Item) entity;
            ItemStack item = itemEntity.getItemStack();
            Material material = item.getType();
            if (
                inputVerifiers.containsKey(material) &&
                inputVerifiers.get(material).test(item)
            ) {
                found.put(material, itemEntity);
            }
        }

        if (found.size() != input.size()) return false;

        for (Entry<Material, Item> e : found.entrySet()) {
            Item item = e.getValue();
            ItemStack stack = item.getItemStack();
            stack.setAmount(stack.getAmount() - input.get(e.getKey()).getAmount());
            item.setItemStack(stack);
        }

        return true;
    }

    /**
     * Remembers whether or not a material was a Slimefun item
     * so it doesn't have to execute {@code SlimefunItem#getByItem(ItemStack)}
     * every single time.
     * 
     * @param verifyAgainst An item in a recipe
     * @return A predicate that tests whether or not its test value is
     *         acceptable as a recipe input for the item it was originally
     *         given
     */
    private static Predicate<ItemStack> getVerifier(ItemStack verifyAgainst) {

        int amount = verifyAgainst.getAmount();
        if (verifyAgainst instanceof SlimefunItemStack) {
            String id = ((SlimefunItemStack) verifyAgainst).getItemId();

            return (ItemStack stack) -> {
                SlimefunItem item = SlimefunItem.getByItem(stack);
                return
                    stack.getAmount() >= amount &&
                    item != null &&
                    item.getId().equals(id);
            };
        }

        return (ItemStack stack) -> {
            return stack.getAmount() >= amount;
        };

    }

}
