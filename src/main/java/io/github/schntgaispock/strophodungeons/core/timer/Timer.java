package io.github.schntgaispock.strophodungeons.core.timer;

import java.util.UUID;


public class Timer extends AbstractTimer {

    public Timer(String name) {
        this.defaultTicks = 0;
        this.name = name;
    }

    @Override
    public Runnable onTimerComplete(UUID uuid) {
        return null;
    }

    
}
