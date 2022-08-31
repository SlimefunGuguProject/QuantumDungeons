package io.github.schntgaispock.quantumdungeons.core.slimefun;

import javax.annotation.Nonnull;

import org.bukkit.Location;
import org.bukkit.block.Block;

import lombok.experimental.UtilityClass;
import me.mrCookieSlime.Slimefun.api.BlockStorage;

/**
 * Wrapper functions for <code>BlockStorage</code>
 */
@UtilityClass
public class QDBlockStorage {

    public static void set(Location location, String key, Object value) {
        BlockStorage.addBlockInfo(location, key, value.toString());
    }

    public static void setSlimefunBlock(Location location, String id) {
        BlockStorage.addBlockInfo(location, "id", id);
    }

    @Nonnull
    private static String get(Location location, String key) {
        return get(location, key, "0");
    }

    @Nonnull
    public static String get(Location location, String key, String def) {
        String value = BlockStorage.getLocationInfo(location, key);
        return (value == null) ? def : value;
    }

    public static short getShort(Location location, String key) {
        return Short.valueOf(get(location, key));
    }

    public static short getShort(Block block, String key) {
        return getShort(block.getLocation(), key);
    }

    public static int getInteger(Location location, String key) {
        return Integer.valueOf(get(location, key));
    }
    
    public static int getInteger(Block block, String key) {
        return getInteger(block.getLocation(), key);
    }

    public static long getLong(Location location, String key) {
        return Long.valueOf(get(location, key));
    }

    public static long getLong(Block block, String key) {
        return getLong(block.getLocation(), key);
    }

    public static float getFloat(Location location, String key) {
        return Float.valueOf(get(location, key));
    }

    public static float getFloat(Block block, String key) {
        return getFloat(block.getLocation(), key);
    }

    public static double getDouble(Location location, String key) {
        return Double.valueOf(get(location, key));
    }

    public static double getDouble(Block block, String key) {
        return getDouble(block.getLocation(), key);
    }

    public static boolean getBoolean(Location location, String key) {
        return Boolean.valueOf(get(location, key));
    }

    public static boolean getBoolean(Block block, String key) {
        return getBoolean(block.getLocation(), key);
    }

}
