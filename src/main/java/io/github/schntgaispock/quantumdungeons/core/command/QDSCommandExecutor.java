package io.github.schntgaispock.quantumdungeons.core.command;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import io.github.schntgaispock.quantumdungeons.QuantumDungeons;
import io.github.schntgaispock.quantumdungeons.core.dungeon.schematics.QDSchematicManager;
import io.github.schntgaispock.quantumdungeons.core.dungeon.schematics.representation.QDSFace;
import io.github.schntgaispock.quantumdungeons.core.dungeon.schematics.representation.QDSchematic;
import io.github.schntgaispock.quantumdungeons.core.dungeon.schematics.representation.QDSFace.QDSFaceConnection;
import io.github.schntgaispock.quantumdungeons.core.dungeon.schematics.representation.QDSFace.QDSFaceDirection;

/**
 * Functionality for the '/quantumdungeonsschematic' command
 */
public class QDSCommandExecutor implements CommandExecutor {

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

                QDSchematicManager.getInstance().generateSchematic(
                    args[12],
                    corner, xLen, yLen, zLen,
                    new QDSFace(QDSFaceDirection.NORTH, QDSFaceConnection.valueOf(args[4]), Integer.valueOf(args[5])),
                    new QDSFace(QDSFaceDirection.EAST, QDSFaceConnection.valueOf(args[6]), Integer.valueOf(args[7])),
                    new QDSFace(QDSFaceDirection.SOUTH, QDSFaceConnection.valueOf(args[8]), Integer.valueOf(args[9])),
                    new QDSFace(QDSFaceDirection.WEST, QDSFaceConnection.valueOf(args[10]), Integer.valueOf(args[11]))
                );

                return true;

            case "paste":
                if (args.length != 6) return false;
                player.sendMessage("Pasting " + args[1]);
                QDSchematicManager
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
                QDSchematic qds = QDSchematicManager
                    .getInstance()
                    .readFromSaved(args[1] + ".json");

                System.out.println(qds);

                QDSchematicManager
                    .getInstance()
                    .getLoadedSchematics()
                    .put(
                        args[1],
                        qds
                    );
                return true;

            case "save":
                if (args.length != 2) return false;
                QDSchematicManager.getInstance().saveToSaved(args[1] + ".json", args[1]);
                return true;

            
            case "log":
                if (args.length != 2) return false;
                QuantumDungeons.getInstance().getLogger().info(QDSchematicManager.getInstance().getLoadedSchematics().toString());
                return true;

            case "list":
                if (args.length != 1) return false;
                String list = "Loaded schematics: " + String.join(", ", QDSchematicManager.getInstance().getLoadedSchematics().keySet().toArray(new String[0]));
                player.sendMessage(list);
                QuantumDungeons.getInstance().getLogger().info(list);
                return true;

            default:
                return false;
        }
    }
    
}
