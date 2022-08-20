package io.github.schntgaispock.quantumdungeons.core.timer;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;

public class CooldownManager {

    private static CooldownManager instance;

    private @Getter Map<String, Timer> timers = new HashMap<>();
    private @Getter Map<String, Cooldown> cooldowns = new HashMap<>();

    private CooldownManager() {
        timers.put("dungeon", new Timer("dungeon"));

        cooldowns.put("dungeon", new Cooldown(0, "dungeon"));
        cooldowns.put("record_player", new Cooldown(20*60*20, "record_player"));
    }

    public static CooldownManager getInstance() {
        if (instance == null) {
            return new CooldownManager();
        }

        return instance;
    }
    
}
