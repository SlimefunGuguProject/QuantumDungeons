package io.github.schntgaispock.strophodungeons.core.setup;

import org.bukkit.Bukkit;

import io.github.schntgaispock.strophodungeons.Strophodungeons;
import io.github.schntgaispock.strophodungeons.core.listeners.DungeonLootingListener;
import io.github.schntgaispock.strophodungeons.core.listeners.ReflectionListener;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ListenerSetup {

    public static void setup() {
        Bukkit.getPluginManager().registerEvents(new ReflectionListener(), Strophodungeons.getInstance());
        Bukkit.getPluginManager().registerEvents(new DungeonLootingListener(), Strophodungeons.getInstance());
    }

}
