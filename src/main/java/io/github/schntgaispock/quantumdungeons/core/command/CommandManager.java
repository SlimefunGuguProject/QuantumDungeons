package io.github.schntgaispock.quantumdungeons.core.command;

import io.github.schntgaispock.quantumdungeons.QuantumDungeons;

/**
 * Does all the necessary prep work for commands to work
 */
public class CommandManager {
    
    public static void setup() {
        
        QuantumDungeons.getInstance().getCommand("quantumdungeons").setExecutor(new QDCommandExecutor());
        QuantumDungeons.getInstance().getCommand("quantumdungeons").setTabCompleter(new QDTabCompleter());

    }

}
