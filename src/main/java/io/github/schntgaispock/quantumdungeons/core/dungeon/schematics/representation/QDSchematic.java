package io.github.schntgaispock.quantumdungeons.core.dungeon.schematics.representation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.management.ConstructorParameters;

import org.bukkit.Axis;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.Directional;
import org.bukkit.block.data.MultipleFacing;
import org.bukkit.block.data.Orientable;
import org.bukkit.block.data.Rotatable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import io.github.schntgaispock.quantumdungeons.core.slimefun.QDBlockStorage;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class QDSchematic {

    private final int[][][] blocks;
    private final List<QDSBlockState> palette;
    private final Biome biome;
    private final List<QDSFace> faces;
    private final int version;

    @ConstructorParameters({"blocks", "palette", "biome", "faces", "version"})
    @JsonCreator(mode = Mode.PROPERTIES)
    public QDSchematic(
        @JsonProperty("blocks") int[][][] blocks,
        @JsonProperty("palette") List<QDSBlockState> palette,
        @JsonProperty("biome") Biome biome,
        @JsonProperty("faces") List<QDSFace> faces,
        @JsonProperty("version") int version) {
        this.blocks = blocks;
        this.palette = palette;
        this.biome = biome;
        this.faces = faces;
        this.version = version;
    }

    public QDSchematic(
            int version,
            Location corner, int xLen, int yLen, int zLen, Biome biome,
            QDSFace northFace, QDSFace eastFace, QDSFace southFace, QDSFace westFace) {
        this.blocks = new int[xLen][yLen][zLen];
        this.palette = new ArrayList<>();
        this.biome = biome;
        this.faces = Arrays.asList(northFace, eastFace, southFace, westFace);
        this.version = version;

        saveFromLocation(corner, xLen, yLen, zLen);
    }

    public void saveFromLocation(Location corner, int xLength, int yLength, int zLength) {
        World world = corner.getWorld();
        int cornerX = corner.getBlockX();
        int cornerY = corner.getBlockY();
        int cornerZ = corner.getBlockZ();

        for (int x = 0; x < xLength; x++) {

            for (int y = 0; y < yLength; y++) {

                for (int z = 0; z < zLength; z++) {

                    Block b = world.getBlockAt(cornerX + x, cornerY + y, cornerZ + z);

                    switch (b.getType()) {
                        case AIR, CAVE_AIR, VOID_AIR:
                            getBlocks()[x][y][z] = 0;
                            continue;

                        default:
                            break;
                    }

                    QDSBlockState data = new QDSBlockState(b.getBlockData(), b.getLocation());

                    int state = this.palette.indexOf(data);
                    if (state == -1) {
                        state = this.palette.size();
                        this.palette.add(data);
                    }

                    // Use 1-indexing for states, because 0 means air
                    getBlocks()[x][y][z] = state + 1;

                }

            }

        }

    }

    public void placeAtLocation(Location l, int rotation) {
        int xLen = blocks.length;
        int yLen = blocks[0].length;
        int zLen = blocks[0][0].length;

        int x0 = 0, z0 = 0;
        int dx = 1, dz = 1;
        Function<Integer, Predicate<Integer>> ascCheck = (Integer max) -> {
            return (Integer n) -> {
                return n < max;
            };
        };
        Predicate<Integer> descCheck = (Integer n) -> {
            return n >= 0;
        };
        Predicate<Integer> px = ascCheck.apply(xLen), pz = ascCheck.apply(zLen);
        Function<Integer[], Block> getWorldBlock = (Integer[] c) -> {
            return l.getWorld().getBlockAt(c[0], c[1], c[2]);
        };

        if ((rotation & 3) > 1) {
            x0 = xLen - 1;
            dx = -1;
            px = descCheck;
        }

        if (((rotation - 1) & 3) < 2) {
            z0 = zLen - 1;
            dz = -1;
            pz = descCheck;
        }

        if ((rotation & 1) == 1) {
            getWorldBlock = (Integer[] c) -> {
                return l.getWorld().getBlockAt(c[2], c[1], c[0]);
            };
        }

        int bx = 0;
        for (int x = x0; px.test(x); x += dx) {

            for (int y = 0; y < yLen; y++) {

                int bz = 0;
                for (int z = z0; pz.test(z); z += dz) {

                    int stateId = blocks[bx][y][bz];
                    bz++;
                    if (stateId == 0) continue;

                    QDSBlockState state = palette.get(stateId - 1);
                    Block b = getWorldBlock.apply(new Integer[] {x + l.getBlockX(), y + l.getBlockY(), z + l.getBlockZ()});
                    BlockData data = Bukkit.createBlockData(state.getData());

                    if (data instanceof Directional directional) {
                        directional.setFacing(rotateBlockFace(directional.getFacing(), rotation));
                    } else if (data instanceof Rotatable rotatable) {
                        rotatable.setRotation(rotateBlockFace(rotatable.getRotation(), rotation));
                    } else if (data instanceof Orientable orientable) {
                        orientable.setAxis(rotateAxis(orientable.getAxis(), rotation));
                    } else if (data instanceof MultipleFacing multipleFacing) {
                        Set<BlockFace> rotated = multipleFacing
                            .getFaces()
                            .stream()
                            .map((BlockFace face) -> {
                                return rotateBlockFace(face, rotation);
                            })
                            .collect(Collectors.toSet());
                        for (BlockFace face : multipleFacing.getAllowedFaces()) {
                            multipleFacing.setFace(face, rotated.contains(face));
                        }
                    }

                    b.setBlockData(data);

                    String slimefunId = state.getSlimefunId();
                    if (slimefunId != null) {
                        QDBlockStorage.setSlimefunBlock(b.getLocation(), slimefunId);
                    }
                    
                }

            }

            bx++;
        }

    }

    private BlockFace rotateBlockFace(BlockFace f, int rotation) {
        rotation &= 3;

        if (rotation == 0) return f;

        BlockFace rotatedOnce = switch (f) {
            case NORTH -> BlockFace.EAST;
            case EAST -> BlockFace.SOUTH;
            case SOUTH -> BlockFace.WEST;
            case WEST -> BlockFace.NORTH;
            case NORTH_EAST -> BlockFace.SOUTH_EAST;
            case SOUTH_EAST -> BlockFace.SOUTH_WEST;
            case SOUTH_WEST -> BlockFace.NORTH_WEST;
            case NORTH_WEST -> BlockFace.NORTH_EAST;
            case NORTH_NORTH_EAST -> BlockFace.EAST_SOUTH_EAST;
            case EAST_NORTH_EAST -> BlockFace.SOUTH_SOUTH_EAST;
            case EAST_SOUTH_EAST -> BlockFace.SOUTH_SOUTH_WEST;
            case SOUTH_SOUTH_EAST -> BlockFace.WEST_SOUTH_WEST;
            case SOUTH_SOUTH_WEST -> BlockFace.WEST_NORTH_WEST;
            case WEST_SOUTH_WEST -> BlockFace.NORTH_NORTH_WEST;
            case WEST_NORTH_WEST -> BlockFace.NORTH_NORTH_EAST;
            case NORTH_NORTH_WEST -> BlockFace.EAST_NORTH_EAST;
            default -> f;
        };

        return rotateBlockFace(rotatedOnce, rotation - 1);
    }

    private Axis rotateAxis(Axis a, int rotation) {
        if (a == Axis.Y) return a;
        return ((rotation & 1) == 1) ^ (a == Axis.Z) ? Axis.Z : Axis.X;
    }
}
