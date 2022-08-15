package io.github.schntgaispock.quantumdungeons.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import io.github.schntgaispock.quantumdungeons.QuantumDungeons;

/**
 * Functionality for the '/quantumdungeons' command
 */
public class QDCommandExecutor implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;

            if (args.length == 0) {
                sendInfo(player);
                return true;
            }
        }

        return false;
    }

    private void sendInfo(Player player) {
        player.sendMessage(
            "",
            "§7§lQuantun Dungeons §f- §8Version " + QuantumDungeons.getInstance().getPluginVersion(),
            "§f------",
            "§7§lWiki §f- §8https://github.com/SchnTgaiSpock/SlimeHUD/wiki",
            "§7§lIssues §f- §8https://github.com/SchnTgaiSpock/SlimeHUD/issues",
            ""
        );
    }
    
}
