package io.github.schntgaispock.quantumdungeons;


import javax.annotation.Nonnull;

import org.bstats.bukkit.Metrics;
import org.bukkit.NamespacedKey;

import io.github.mooy1.infinitylib.core.AbstractAddon;
import lombok.Getter;

public class QuantumDungeons extends AbstractAddon {

    private static @Getter QuantumDungeons instance;

    public QuantumDungeons() {
        super("SchnTgaiSpock", "QuantumDungeons", "master", "options.auto-update");

    }

    @Override
    @SuppressWarnings("unused")
    public void enable() {
        instance = this;

        getLogger().info("#=========================================#");
        getLogger().info("#    Quantum Dungeons by SchnTgaiSpock    #");
        getLogger().info("#=========================================#");

        Metrics metrics = new Metrics(this, 16087);
    }

    @Override
    public void disable() {
        instance = null;
        getConfig().save();
    }

    public static NamespacedKey newNamespacedKey(@Nonnull String name) {
        return new NamespacedKey(QuantumDungeons.getInstance(), name);
    }
}
