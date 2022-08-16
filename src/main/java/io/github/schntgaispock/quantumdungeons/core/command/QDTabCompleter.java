package io.github.schntgaispock.quantumdungeons.core.command;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

/**
 * Tab completion for the '/quantumdungeons' command
 */
public class QDTabCompleter implements TabCompleter {

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> hints = new ArrayList<>();

        return hints;
    }
    
}
