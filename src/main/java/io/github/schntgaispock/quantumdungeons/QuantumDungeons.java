package io.github.schntgaispock.quantumdungeons;


import javax.annotation.Nonnull;

import org.bstats.bukkit.Metrics;
import org.bukkit.NamespacedKey;

import io.github.mooy1.infinitylib.core.AbstractAddon;
import io.github.schntgaispock.quantumdungeons.core.dungeon.schematics.QDSchematicManager;
import io.github.schntgaispock.quantumdungeons.core.setup.ListenerSetup;
import io.github.schntgaispock.quantumdungeons.core.setup.QDItemSetup;
import io.github.schntgaispock.quantumdungeons.core.timer.CooldownManager;
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
        getLogger().info("#=========================================#");

        Metrics metrics = new Metrics(this, 16087);

        dungeonWorldName = getConfig().getString("dungeons.world-name");

        schematicReader = QDSchematicManager.getInstance();
        cooldownManager = CooldownManager.getInstance();


        QDItemSetup.setup();
        ListenerSetup.setup();
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
