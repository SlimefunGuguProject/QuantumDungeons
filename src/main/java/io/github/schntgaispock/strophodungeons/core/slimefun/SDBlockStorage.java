package io.github.schntgaispock.strophodungeons.core.slimefun;

import javax.annotation.Nonnull;

import org.bukkit.Location;
import org.bukkit.block.Block;

import lombok.experimental.UtilityClass;
import me.mrCookieSlime.Slimefun.api.BlockStorage;

/**
 * Wrapper functions for <code>BlockStorage</code>
 */
@UtilityClass
public class SDBlockStorage {

    public static void set(Location location, String key, Object value) {
        BlockStorage.addBlockInfo(location, key, value.toString());
    }

    public static void setSlimefunBlock(Location location, String id) {
        BlockStorage.addBlockInfo(location, "id", id);
    }

    @Nonnull
    private static String get(Location location, @Nonnull String key) {
        return get(location, key, "0");
    }

    @Nonnull
    public static String get(Location location, @Nonnull String key, @Nonnull String def) {
        String value = BlockStorage.getLocationInfo(location, key);
        return (value == null) ? def : value;
    }

    public static short getShort(Location location, @Nonnull String key) {
        return Short.valueOf(get(location, key));
    }

    public static short getShort(Block block, @Nonnull String key) {
        return getShort(block.getLocation(), key);
    }

    public static int getInteger(Location location, @Nonnull String key) {
        return Integer.valueOf(get(location, key));
    }
    
    public static int getInteger(Block block, @Nonnull String key) {
        return getInteger(block.getLocation(), key);
    }

    public static long getLong(Location location, @Nonnull String key) {
        return Long.valueOf(get(location, key));
    }

    public static long getLong(Block block, @Nonnull String key) {
        return getLong(block.getLocation(), key);
    }

    public static float getFloat(Location location, @Nonnull String key) {
        return Float.valueOf(get(location, key));
    }

    public static float getFloat(Block block, @Nonnull String key) {
        return getFloat(block.getLocation(), key);
    }

    public static double getDouble(Location location, @Nonnull String key) {
        return Double.valueOf(get(location, key));
    }

    public static double getDouble(Block block, @Nonnull String key) {
        return getDouble(block.getLocation(), key);
    }

    public static boolean getBoolean(Location location, @Nonnull String key) {
        return Boolean.valueOf(get(location, key));
    }

    public static boolean getBoolean(Block block, @Nonnull String key) {
        return getBoolean(block.getLocation(), key);
    }

}
