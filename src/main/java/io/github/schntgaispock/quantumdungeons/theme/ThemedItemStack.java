package io.github.schntgaispock.quantumdungeons.theme;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.meta.ItemMeta;

import io.github.schntgaispock.quantumdungeons.theme.QDTheme.Theme;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;

public class ThemedItemStack extends SlimefunItemStack {

    private ThemedItemStack(String id, Material material, String name, String... lore) {
        super(id, material, name, lore);
    }

    public static ThemedItemStack of(Theme theme, String id, Material material, String name, String... lore) {
        if (lore.length > 0) {
            String[] flore = new String[lore.length + 1];
            flore[0] = "";

            for (int i = 0; i < lore.length; i++) {
                flore[i + 1] = theme.getLoreColor() + lore[i];
            }

            return new ThemedItemStack(id, material, theme.getColor() + name, flore);
        } else {
            return new ThemedItemStack(id, material, theme.getColor() + name, lore);
        }
    }

    public ThemedItemStack enchant(Enchantment... enchantments) {
        for (Enchantment enchantment : enchantments) {
            enchant(enchantment, 1);
        }
        return this;
    }

    public ThemedItemStack enchant(Enchantment enchantment, int level) {
        addUnsafeEnchantment(enchantment, level);
        return this;
    }

    public ThemedItemStack glisten() {
        return enchant(Enchantment.DURABILITY).addFlags(ItemFlag.HIDE_ENCHANTS);
    }

    public ThemedItemStack addFlags(ItemFlag... flags) {
        ItemMeta meta = getItemMeta();
        meta.addItemFlags(flags);
        setItemMeta(meta);
        return this;
    }
    
}
