package io.github.schntgaispock.quantumdungeons.core.setup;

import org.bukkit.Bukkit;

import io.github.schntgaispock.quantumdungeons.QuantumDungeons;
import io.github.schntgaispock.quantumdungeons.core.listeners.ReflectionListener;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ListenerSetup {

    public static void setup() {
        Bukkit.getPluginManager().registerEvents(new ReflectionListener(), QuantumDungeons.getInstance());
    }

}
