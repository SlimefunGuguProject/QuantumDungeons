package io.github.schntgaispock.strophodungeons;


import javax.annotation.Nonnull;

import org.bstats.bukkit.Metrics;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;

import io.github.mooy1.infinitylib.core.AbstractAddon;
import io.github.schntgaispock.strophodungeons.core.dungeon.schematics.SDSchematicManager;
import io.github.schntgaispock.strophodungeons.core.setup.CommandSetup;
import io.github.schntgaispock.strophodungeons.core.setup.ListenerSetup;
import io.github.schntgaispock.strophodungeons.core.setup.SDItemSetup;
import io.github.schntgaispock.strophodungeons.core.timer.CooldownManager;
import io.github.schntgaispock.strophodungeons.integration.SlimeHUDSetup;
import lombok.Getter;

@SuppressWarnings("null")
public class Strophodungeons extends AbstractAddon {

    
    private static @Getter Strophodungeons instance;
    private static @Getter String dungeonWorldName;
    private static @Getter SDSchematicManager schematicReader;
    private static @Getter CooldownManager cooldownManager;

    public Strophodungeons() {
        super("SchnTgaiSpock", "Strophodungeons", "master", "options.auto-update");
    }

    @Override
    @SuppressWarnings("unused")
    public void enable() {
        instance = this;

        getLogger().info("#========================================#");
        getLogger().info("#    Strophodungeons by SchnTgaiSpock    #");
        getLogger().info("#  汉化by:SlimefunGuguProject,buiawpkgew1 #");
        getLogger().info("#========================================#");

        Metrics metrics = new Metrics(this, 16700);

        dungeonWorldName = getConfig().getString("dungeons.world-name");

        schematicReader = SDSchematicManager.getInstance();
        cooldownManager = CooldownManager.getInstance();


        SDItemSetup.setup();
        ListenerSetup.setup();
        CommandSetup.setup();

        if (getInstance().getServer().getPluginManager().isPluginEnabled("SlimeHUD")) {
            try {
                getLogger().info("在这个服务器上发现了SlimeHUD!");
                getLogger().info("为SlimeHUD设置Strophodungeons...");
                SlimeHUDSetup.setup();
            } catch (NoClassDefFoundError e) {
                getLogger().warning("这个服务器使用的是旧版本的SlimeHUD，与Strophodungeons不兼容。");
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
        return new NamespacedKey(Strophodungeons.getInstance(), name);
    }

    public static int scheduleSyncDelayedTask(Runnable runnable, long delay) {
        return Bukkit.getScheduler().scheduleSyncDelayedTask(getInstance(), runnable, delay);
    }
}
