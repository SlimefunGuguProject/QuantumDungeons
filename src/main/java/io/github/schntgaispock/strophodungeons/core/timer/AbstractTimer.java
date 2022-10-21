package io.github.schntgaispock.strophodungeons.core.timer;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.bukkit.Bukkit;

import io.github.schntgaispock.strophodungeons.Strophodungeons;
import lombok.Getter;

public abstract class AbstractTimer {

    protected final Map<UUID, Long> startTimes = new HashMap<>();
    protected final Map<UUID, Long> durations = new HashMap<>();
    protected long defaultTicks;
    protected @Getter String name;

    public void start(UUID uuid, long time) {
        startTimes.put(uuid, System.currentTimeMillis());
        durations.put(uuid, time);

        Runnable onTimerComplete = onTimerComplete(uuid);
        if (onTimerComplete != null) {
            Bukkit.getScheduler().scheduleSyncDelayedTask(
                Strophodungeons.getInstance(),
                onTimerComplete, time
            );
        }
    }

    public boolean check(UUID uuid) {
        return System.currentTimeMillis() - startTimes.getOrDefault(uuid, 0L) >= durations.getOrDefault(uuid, defaultTicks);
    }

    public long elapsed(UUID uuid) {
        return System.currentTimeMillis() - startTimes.getOrDefault(uuid, 0L);
    }

    public abstract Runnable onTimerComplete(UUID uuid);
    
}
