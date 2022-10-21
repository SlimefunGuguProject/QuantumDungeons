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
                getLogger().info("SlimeHUD was found on this server!");
                getLogger().info("Setting up Strophodungeons for SlimeHUD...");
                SlimeHUDSetup.setup();
            } catch (NoClassDefFoundError e) {
                getLogger().warning("This server is using an old version of SlimeHUD that is incompatitable with this version of Strophodungeons.");
                getLogger().warning("Please update SlimeHUD to version 1.2.0 or higher!");
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
