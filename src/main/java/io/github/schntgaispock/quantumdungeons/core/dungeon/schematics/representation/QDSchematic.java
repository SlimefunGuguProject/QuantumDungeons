package io.github.schntgaispock.quantumdungeons.core.dungeon.schematics.representation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;

import lombok.Getter;

@Getter
public class QDSchematic {

    private final List<QDSBlock> blocks;
    private final List<String> palette;
    private final List<QDSFace> faceConnections;
    private final List<Integer> size;
    private int version;

    public QDSchematic(int version, QDSFace... faces) {
        this.blocks = new ArrayList<>();
        this.palette = new ArrayList<>();
        this.faceConnections = Arrays.asList(faces);
        this.size = new ArrayList<>();
        this.version = version;
    }

    public QDSchematic saveFromLocation(Location corner, int xLength, int yLength, int zLength) {
        World world = corner.getWorld();
        int cornerX = (int) corner.getX();
        int cornerY = (int) corner.getY();
        int cornerZ = (int) corner.getZ();
                

        for (int x = cornerX; x < cornerX + xLength; x++) {

            for (int y = cornerY; y < cornerY + yLength; y++) {

                for (int z = cornerZ; z < cornerZ + zLength; z++) {

                    Block b = world.getBlockAt(x, y, z);

                    switch (b.getType()) {
                        case AIR, CAVE_AIR, VOID_AIR: continue;
                        default: break;
                    }
                    
                    String data = b.getBlockData().getAsString(true);

                    int state = this.palette.indexOf(data);
                    if (state == -1) {
                        this.palette.add(data);
                        state = this.palette.size() - 1;
                    }
                    getBlocks().add(
                        new QDSBlock(x, y, z, state)
                    );

                }

            }

        }

        return this;
    }

}
