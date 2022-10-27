package io.github.schntgaispock.strophodungeons.core.timer;

import java.util.UUID;

import io.github.schntgaispock.strophodungeons.core.dungeon.DungeonManager;

public class DungeonTimer extends Timer {

    public DungeonTimer(String name) {
        super(name);
    }

    @Override
    public Runnable onTimerComplete(UUID uuid) {
        return new Runnable() {
            
            public void run() {
                DungeonManager.kick(uuid);
            }

        };
    }
    
}
