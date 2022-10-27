package io.github.schntgaispock.strophodungeons.core.setup;

import io.github.schntgaispock.strophodungeons.Strophodungeons;
import io.github.schntgaispock.strophodungeons.core.command.SDCommandExecutor;
import io.github.schntgaispock.strophodungeons.core.command.SDSCommandExecutor;
import io.github.schntgaispock.strophodungeons.core.command.SDSTabCompleter;
import io.github.schntgaispock.strophodungeons.core.command.SDTabCompleter;

/**
 * Does all the necessary prep work for commands to work
 */
public class CommandSetup {
    
    public static void setup() {
        
        Strophodungeons.getInstance().getCommand("strophodungeons").setExecutor(new SDCommandExecutor());
        Strophodungeons.getInstance().getCommand("strophodungeons").setTabCompleter(new SDTabCompleter());
        Strophodungeons.getInstance().getCommand("strophodungeonsschematic").setExecutor(new SDSCommandExecutor());
        Strophodungeons.getInstance().getCommand("strophodungeonsschematic").setTabCompleter(new SDSTabCompleter());

    }

}
