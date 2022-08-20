package io.github.schntgaispock.quantumdungeons.core.timer;

import java.util.UUID;

public class Cooldown extends AbstractTimer {

    public Cooldown(long defaultTicks, String name) {
        this.defaultTicks = defaultTicks;
        this.name = name;
    }

    @Override
    public Runnable onTimerComplete(UUID uuid) {
        return null;
    }
    
}
