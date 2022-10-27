package io.github.schntgaispock.strophodungeons.core.dungeon;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import lombok.Getter;
import lombok.experimental.UtilityClass;

@UtilityClass
public class DungeonManager {
    
    private static @Getter Map<UUID, String> dungeons = new HashMap<>();

    public static void kick(UUID player) {

    }

}
