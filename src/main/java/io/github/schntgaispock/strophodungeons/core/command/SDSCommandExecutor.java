package io.github.schntgaispock.strophodungeons.core.command;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import io.github.schntgaispock.strophodungeons.Strophodungeons;
import io.github.schntgaispock.strophodungeons.core.dungeon.schematics.SDSchematicManager;
import io.github.schntgaispock.strophodungeons.core.dungeon.schematics.data.SDSFace;
import io.github.schntgaispock.strophodungeons.core.dungeon.schematics.data.SDSchematic;
import io.github.schntgaispock.strophodungeons.core.dungeon.schematics.data.SDSFace.SDSFaceConnection;
import io.github.schntgaispock.strophodungeons.core.dungeon.schematics.data.SDSFace.SDSFaceDirection;

/**
 * Functionality for the '/strophodungeonsschematic' command
 */
public class SDSCommandExecutor implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player player)) {
            return false;
        }

        if (args.length == 0) {
            return false;
        }

        switch (args[0]) {

            case "copy":
                if (args.length != 13) return false;

                player.sendMessage("Copying " + args[12]);

                Location corner = new Location(
                    player.getWorld(),
                    Integer.valueOf(args[1]),
                    Integer.valueOf(args[2]),
                    Integer.valueOf(args[3]));

                int xLen = 4, yLen = 4, zLen = 6;
                // int xLen = 16, yLen = 16, zLen = 16;

                SDSchematicManager.getInstance().generateSchematic(
                    args[12],
                    corner, xLen, yLen, zLen,
                    new SDSFace(SDSFaceDirection.NORTH, SDSFaceConnection.valueOf(args[4]), Integer.valueOf(args[5])),
                    new SDSFace(SDSFaceDirection.EAST, SDSFaceConnection.valueOf(args[6]), Integer.valueOf(args[7])),
                    new SDSFace(SDSFaceDirection.SOUTH, SDSFaceConnection.valueOf(args[8]), Integer.valueOf(args[9])),
                    new SDSFace(SDSFaceDirection.WEST, SDSFaceConnection.valueOf(args[10]), Integer.valueOf(args[11]))
                );

                return true;

            case "paste":
                if (args.length != 6) return false;
                player.sendMessage("Pasting " + args[1]);
                SDSchematicManager
                    .getInstance()
                    .getLoadedSchematics()
                    .get(args[1])
                    .placeAtLocation(new Location(
                        player.getWorld(),
                        Integer.valueOf(args[2]),
                        Integer.valueOf(args[3]),
                        Integer.valueOf(args[4]) 
                    ), Integer.valueOf(args[5]));

                return true;

            case "load":
                if (args.length != 2) return false;
                SDSchematic sds = SDSchematicManager
                    .getInstance()
                    .readFromSaved(args[1] + ".json");

                System.out.println(sds);

                SDSchematicManager
                    .getInstance()
                    .getLoadedSchematics()
                    .put(
                        args[1],
                        sds
                    );
                return true;

            case "save":
                if (args.length != 2) return false;
                SDSchematicManager.getInstance().saveToSaved(args[1] + ".json", args[1]);
                return true;

            
            case "log":
                if (args.length != 2) return false;
                Strophodungeons.getInstance().getLogger().info(SDSchematicManager.getInstance().getLoadedSchematics().toString());
                return true;

            case "list":
                if (args.length != 1) return false;
                String list = "Loaded schematics: " + String.join(", ", SDSchematicManager.getInstance().getLoadedSchematics().keySet().toArray(new String[0]));
                player.sendMessage(list);
                Strophodungeons.getInstance().getLogger().info(list);
                return true;

            default:
                return false;
        }
    }
    
}
