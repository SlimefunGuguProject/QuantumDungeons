package io.github.schntgaispock.quantumdungeons.core.slimefun;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Location;
import org.bukkit.block.Block;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Getter;
import lombok.experimental.UtilityClass;
import me.mrCookieSlime.Slimefun.api.BlockStorage;

/**
 * Wrapper functions for <code>BlockStorage</code>
 */
@UtilityClass
public class QDBlockStorage {
    
    private static final @Getter ObjectMapper JSONObjectMapper = new ObjectMapper();

    public static Map<String, String> read(Location location) {
        try {
            return getJSONObjectMapper().readValue(
                BlockStorage.getBlockInfoAsJson(location),
                new TypeReference<HashMap<String, String>>() {}
            );            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Map<String, String> read(Block block) {
        return read(block.getLocation());
    }

    public static void set(Location location, String key, Object value) {
        BlockStorage.addBlockInfo(location, key, value.toString());
    }

    public static void set(Block block, String key, Object value) {
        set(block.getLocation(), key, value);
    }

    public static String get(Location location, String key) {
        Map<String, String> map = read(location);
        if (map == null) return null;
        return map.get(key);
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
