package io.github.schntgaispock.quantumdungeons.core.command;

import java.util.Arrays;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

/**
 * Tab completion for the '/quantumdungeons' command
 */
public class QDTabCompleter implements TabCompleter {

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {

        if (!(sender instanceof Player player)) {
            return null;
        }

        if (args.length == 0) {
            return Arrays.asList("help");
        }

        return null;
    }
}
