package io.github.schntgaispock.quantumdungeons.core.music;

import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Note extends ScoreComponent {

    public static enum Pitch {
        F_SHARP_0, G_0, G_SHARP_0, A_0, A_SHARP_0, B_0, C_0, C_SHARP_0, D_0, D_SHARP_0, E_0, F_0,
        F_SHARP_1, G_1, G_SHARP_1, A_1, A_SHARP_1, B_1, C_1, C_SHARP_1, D_1, D_SHARP_1, E_1, F_1,
        F_SHARP_2;
    }

    private final float volume;
    private final Vector displacement;
    private final Pitch pitch;

    @Override
    public void playSound(Player player) {
        
    }
    
}
