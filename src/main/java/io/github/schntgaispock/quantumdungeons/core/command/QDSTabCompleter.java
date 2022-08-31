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
            return Arrays.asList("paste", "copy", "load", "save");
        }
        
        switch (args[0]) {
            case "load":
                return Arrays.asList("name");

            case "save":
                return Arrays.asList("name");

            case "paste":
                return Arrays.asList("name");

            case "copy":
                Location lookingAt = player.getTargetBlockExact(5, FluidCollisionMode.NEVER).getLocation();
                int x = lookingAt.getBlockX();
                int y = lookingAt.getBlockY();
                int z = lookingAt.getBlockZ();

                Stream<String> faces = Arrays
                    .stream(QDSFaceConnection.values())
                    .map((QDSFaceConnection c) -> {return c.name(); });

                switch (args.length) {
                    case 2:
                        return Arrays.asList(
                            x + "",
                            x + " " + y,
                            x + " " + y + " " + z
                        );
                    case 3:
                        return Arrays.asList(
                            y + "",
                            y + " " + z
                        );
                    case 4:
                        return Arrays.asList(
                            z + ""
                        );
                    case 5, 7, 9, 11:
                        return faces.filter((String face) -> (face.startsWith(args[args.length - 1]))).toList();

                    case 6, 8, 10, 12:
                        return Arrays.asList("0");
                
                    default:
                        return null;
                }
        
            default:
                break;
        }

        return null;
    }
}
