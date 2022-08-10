package io.github.schntgaispock.quantumdungeons;


import javax.annotation.Nonnull;

import org.bstats.bukkit.Metrics;
import org.bstats.charts.SimplePie;
import org.bukkit.NamespacedKey;

import io.github.mooy1.infinitylib.core.AbstractAddon;
import io.github.mooy1.infinitylib.core.AddonConfig;
import io.github.schntgaispock.quantumdungeons.command.CommandManager;
import lombok.Getter;

public class QuantumDungeons extends AbstractAddon {

    @Getter AddonConfig playerData;
    static @Getter QuantumDungeons instance;

    public QuantumDungeons() {
        super("SchnTgaiSpock", "SlimeHUD", "master", "options.auto-update");
    }

    @Override
    public void enable() {
        instance = this;

        getLogger().info("#=========================================#");
        getLogger().info("#    Quantum Dungeons by SchnTgaiSpock    #");
        getLogger().info("#=========================================#");

        Metrics metrics = new Metrics(this, 15883);
        metrics.addCustomChart(
            new SimplePie("disabled", () -> {
                return "" + getConfig().getBoolean("waila.disabled");
            })
        );
        metrics.addCustomChart(
            new SimplePie("waila_location", () -> {
                return getConfig().getString("waila.location");
            })
        );

        playerData = new AddonConfig("player.yml");

        CommandManager.setup();
    }

    @Override
    public void disable() {
        instance = null;
        getPlayerData().save();
        getConfig().save();
    }

    public static NamespacedKey newNamespacedKey(@Nonnull String name) {
        return new NamespacedKey(QuantumDungeons.getInstance(), name);
    }
}
