package io.github.schntgaispock.quantumdungeons;


import javax.annotation.Nonnull;

import org.bstats.bukkit.Metrics;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;

import io.github.mooy1.infinitylib.core.AbstractAddon;
import io.github.schntgaispock.quantumdungeons.core.dungeon.schematics.QDSchematicManager;
import io.github.schntgaispock.quantumdungeons.core.setup.ListenerSetup;
import io.github.schntgaispock.quantumdungeons.core.setup.QDItemSetup;
import io.github.schntgaispock.quantumdungeons.core.timer.CooldownManager;
import io.github.schntgaispock.quantumdungeons.integration.SlimeHUDSetup;
import lombok.Getter;

public class QuantumDungeons extends AbstractAddon {

    
    private static @Getter QuantumDungeons instance;
    private static @Getter String dungeonWorldName;
    private static @Getter QDSchematicManager schematicReader;
    private static @Getter CooldownManager cooldownManager;

    public QuantumDungeons() {
        super("SchnTgaiSpock", "QuantumDungeons", "master", "options.auto-update");
    }

    @Override
    @SuppressWarnings("unused")
    public void enable() {
        instance = this;

        getLogger().info("#=========================================#");
        getLogger().info("#    Quantum Dungeons by SchnTgaiSpock    #");
        getLogger().info("#  汉化by:SlimefunGuguProject,buiawpkgew1 #")
        getLogger().info("#=========================================#");

        Metrics metrics = new Metrics(this, 16087);

        dungeonWorldName = getConfig().getString("dungeons.world-name");

        schematicReader = QDSchematicManager.getInstance();
        cooldownManager = CooldownManager.getInstance();


        QDItemSetup.setup();
        ListenerSetup.setup();

        if (getInstance().getServer().getPluginManager().isPluginEnabled("SlimeHUD")) {
            try {
                getLogger().info("在这个服务器上发现了SlimeHUD!");
                getLogger().info("为SlimeHUD设置QuantumDungeons...");
                SlimeHUDSetup.setup();
            } catch (NoClassDefFoundError e) {
                getLogger().warning("这个服务器使用的是旧版本的SlimeHUD，与QuantumDungeons不兼容。");
                getLogger().warning("请将 SlimeHUD 更新至 1.2.0 或更高版本!");
            }
        }
    }

    @Override
    public void disable() {
        instance = null;
        getConfig().save();
    }

    public static NamespacedKey newNamespacedKey(@Nonnull String name) {
        return new NamespacedKey(QuantumDungeons.getInstance(), name);
    }

    public static int scheduleSyncDelayedTask(Runnable runnable, long delay) {
        return Bukkit.getScheduler().scheduleSyncDelayedTask(getInstance(), runnable, delay);
    }
}
