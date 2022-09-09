package io.github.schntgaispock.quantumdungeons.core.command;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.bukkit.FluidCollisionMode;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import io.github.schntgaispock.quantumdungeons.core.dungeon.schematics.representation.QDSFace.QDSFaceConnection;

/**
 * Tab completion for the '/quantumdungeons' command
 */
public class QDSTabCompleter implements TabCompleter {

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {

        if (
                !(sender instanceof Player player) ||
                args.length == 0
        ) {
            return null;
        }

        if (args.length == 1) {
            return Arrays.asList("copy", "paste", "save", "load", "print", "list", "clear");
        }
        
        switch (args[0]) {
            case "copy":
                Location lookingAt = player.getTargetBlockExact(5, FluidCollisionMode.NEVER).getLocation();
                int x = lookingAt.getBlockX();
                int y = lookingAt.getBlockY();
                int z = lookingAt.getBlockZ();

                Stream<String> faces = Arrays
                    .stream(QDSFaceConnection.values())
                    .map((QDSFaceConnection c) -> {return c.name(); });

                return switch (args.length) {
                    case 2 -> Arrays.asList(
                            Integer.toString(x),
                            x + " " + y,
                            x + " " + y + " " + z
                        );
                    case 3 -> Arrays.asList(
                            Integer.toString(y),
                            y + " " + z
                        );
                    case 4 -> Arrays.asList(
                            Integer.toString(z)
                        );
                    case 5, 7, 9, 11 -> faces.filter((String face) -> (face.startsWith(args[args.length - 1]))).toList();
                    case 6, 8, 10, 12 -> Arrays.asList("0");
                    default -> null;
                };

            case "paste":
                return Arrays.asList("name");

            case "save":
                return Arrays.asList("name");

            case "load":
                return Arrays.asList("name");

            case "list":
                return null;

            case "print":
                return Arrays.asList("name");

            case "clear":
                return Arrays.asList("name");
        
            default:
                return null;

        }
    }
}
