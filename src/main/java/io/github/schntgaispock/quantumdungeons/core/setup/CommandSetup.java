package io.github.schntgaispock.quantumdungeons.core.setup;

import io.github.schntgaispock.quantumdungeons.QuantumDungeons;
import io.github.schntgaispock.quantumdungeons.core.command.QDCommandExecutor;
import io.github.schntgaispock.quantumdungeons.core.command.QDSCommandExecutor;
import io.github.schntgaispock.quantumdungeons.core.command.QDSTabCompleter;
import io.github.schntgaispock.quantumdungeons.core.command.QDTabCompleter;

/**
 * Does all the necessary prep work for commands to work
 */
public class CommandSetup {
    
    public static void setup() {
        
        QuantumDungeons.getInstance().getCommand("quantumdungeons").setExecutor(new QDCommandExecutor());
        QuantumDungeons.getInstance().getCommand("quantumdungeons").setTabCompleter(new QDTabCompleter());
        QuantumDungeons.getInstance().getCommand("quantumdungeonsschematic").setExecutor(new QDSCommandExecutor());
        QuantumDungeons.getInstance().getCommand("quantumdungeonsschematic").setTabCompleter(new QDSTabCompleter());

    }

}
