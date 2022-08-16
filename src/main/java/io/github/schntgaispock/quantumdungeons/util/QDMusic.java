package io.github.schntgaispock.quantumdungeons.util;

import org.bukkit.Sound;

import io.github.schntgaispock.quantumdungeons.core.music.Score;
import io.github.schntgaispock.quantumdungeons.core.music.Note.Pitch;
import lombok.experimental.UtilityClass;

/**
 * This class holds the little jingles when a record is played
 */
@UtilityClass
public class QDMusic {

    public static final Score RECORD_OF_VALOR = new Score(3);
    public static final Score RECORD_OF_VALOR_BOOSTED = new Score(3);
    
    public static final Score RECORD_OF_AEGIS = new Score(3);
    public static final Score RECORD_OF_AEGIS_BOOSTED = new Score(3);
    
    public static final Score RECORD_OF_ORDER = new Score(3);
    public static final Score RECORD_OF_ORDER_BOOSTED = new Score(3);
    
    public static final Score RECORD_OF_POWER = new Score(3);
    public static final Score RECORD_OF_POWER_BOOSTED = new Score(3);
    
    public static final Score RECORD_OF_HASTE = new Score(2);
    public static final Score RECORD_OF_HASTE_BOOSTED = new Score(2);

    static {
        RECORD_OF_VALOR
            .newLine("melody", Sound.BLOCK_NOTE_BLOCK_FLUTE)
            .add(3, Pitch.F_0)
            .add(3, Pitch.C_1)
            .add(1, Pitch.D_1)
            .add(1, Pitch.C_1)
            .add(1, Pitch.A_SHARP_1)
            .add(3, Pitch.C_1)
            .add(1, Pitch.D_1)
            .add(1, Pitch.C_1)
            .add(1, Pitch.A_SHARP_1)
            .add(3, Pitch.C_1)
            .add(3, Pitch.F_0)
            .add(3, Pitch.G_1);
        RECORD_OF_VALOR
            .newLine("bass", Sound.BLOCK_NOTE_BLOCK_BASS)
            .add(3, Pitch.A_0, Pitch.F_0)
            .add(3, Pitch.C_0, Pitch.A_1)
            .add(3, Pitch.A_SHARP_0, Pitch.G_1)
            .add(3, Pitch.A_0, Pitch.F_0)
            .add(3, Pitch.A_SHARP_0, Pitch.G_1)
            .add(3, Pitch.A_0, Pitch.F_0)
            .add(3, Pitch.C_0, Pitch.A_1)
            .add(3, Pitch.C_0, Pitch.G_1);

        RECORD_OF_VALOR_BOOSTED.newLine("melody1", RECORD_OF_VALOR.copyOf("melody"));
        RECORD_OF_VALOR_BOOSTED.newLine("melody2", RECORD_OF_VALOR.transpose("melody", Sound.BLOCK_NOTE_BLOCK_GUITAR));
        RECORD_OF_VALOR_BOOSTED.newLine("bass", RECORD_OF_VALOR.copyOf("melbassody"));

        RECORD_OF_AEGIS
            .newLine("bass1", Sound.BLOCK_NOTE_BLOCK_GUITAR)
            .add(2, Pitch.C_0, Pitch.D_SHARP_0, Pitch.G_1)
            .add(1, Pitch.C_0, Pitch.D_SHARP_0, Pitch.G_1)
            .add(1, Pitch.C_0, Pitch.D_SHARP_0, Pitch.G_1)
            .add(2, Pitch.B_0, Pitch.E_0, Pitch.G_1)
            .add(1, Pitch.B_0, Pitch.E_0, Pitch.G_1)
            .add(1, Pitch.B_0, Pitch.E_0, Pitch.G_1)
            .add(2, Pitch.C_0, Pitch.D_SHARP_0, Pitch.G_1)
            .add(1, Pitch.C_0, Pitch.D_SHARP_0, Pitch.G_1)
            .add(1, Pitch.C_0, Pitch.D_SHARP_0, Pitch.G_1)
            .add(2, Pitch.B_0, Pitch.E_0, Pitch.G_1)
            .add(2, Pitch.B_0, Pitch.E_0, Pitch.G_1);
        RECORD_OF_AEGIS
            .newLine("bass2", Sound.BLOCK_NOTE_BLOCK_BASS)
            .add(2, Pitch.G_0)
            .add(1, Pitch.G_0)
            .add(1, Pitch.G_0)
            .add(2, Pitch.G_0)
            .add(1, Pitch.G_0)
            .add(1, Pitch.G_0)
            .add(2, Pitch.G_0)
            .add(1, Pitch.G_0)
            .add(1, Pitch.G_0)
            .add(2, Pitch.G_0)
            .add(2, Pitch.G_0);

            
    RECORD_OF_AEGIS_BOOSTED.newLine("bass1", RECORD_OF_AEGIS.copyOf("bass1"));
    RECORD_OF_AEGIS_BOOSTED
        .newLine("bass2", Sound.BLOCK_NOTE_BLOCK_BASS)
        .add(2, Pitch.G_0, Pitch.C_0)
        .add(1, Pitch.G_0, Pitch.C_0)
        .add(1, Pitch.G_0, Pitch.C_0)
        .add(1, Pitch.G_0, Pitch.B_0)
        .add(1, Pitch.B_0)
        .add(1, Pitch.G_0, Pitch.B_0)
        .add(1, Pitch.G_0, Pitch.B_0)
        .add(2, Pitch.G_0, Pitch.C_0)
        .add(1, Pitch.G_0, Pitch.C_0)
        .add(1, Pitch.G_0, Pitch.C_0)
        .add(2, Pitch.G_0, Pitch.B_0)
        .add(2, Pitch.G_0, Pitch.B_0);

        RECORD_OF_ORDER
            .newLine("melody", Sound.BLOCK_NOTE_BLOCK_HARP)
            .add(2, Pitch.C_0)
            .add(1, Pitch.D_SHARP_0)
            .add(2, Pitch.F_0)
            .add(1, Pitch.F_SHARP_1)
            .add(2, Pitch.F_0)
            .add(1, Pitch.F_SHARP_1)
            .add(2, Pitch.F_0)
            .add(1, Pitch.E_0)
            .add(2, Pitch.F_0)
            .add(1, Pitch.G_SHARP_1)
            .add(2, Pitch.A_SHARP_1)
            .add(1, Pitch.B_1)
            .add(2, Pitch.A_SHARP_1)
            .add(1, Pitch.G_SHARP_1)
            .add(3, Pitch.F_0);
        RECORD_OF_ORDER
            .newLine("bass", Sound.BLOCK_NOTE_BLOCK_BASS)
            .add(5, Pitch.C_1)
            .add(1, Pitch.A_SHARP_1)
            .add(5, Pitch.G_1)
            .add(1, Pitch.F_0)
            .add(5, Pitch.F_0)
            .add(1, Pitch.G_SHARP_1)
            .add(1, Pitch.A_SHARP_1)
            .add(1, Pitch.A_SHARP_1)
            .add(1, Pitch.A_SHARP_1)
            .add(3, Pitch.B_1);
        
        RECORD_OF_ORDER_BOOSTED.newLine("melody", RECORD_OF_ORDER.copyOf("melody"));
        RECORD_OF_ORDER_BOOSTED.newLine("bass1", RECORD_OF_ORDER.copyOf("bass"));
        RECORD_OF_ORDER_BOOSTED
            .newLine("bass2", Sound.BLOCK_NOTE_BLOCK_GUITAR)
            .add(2, Pitch.C_0)
            .add(3, Pitch.G_1, Pitch.A_SHARP_1)
            .add(1, Pitch.G_1, Pitch.A_SHARP_1)
            .add(2, Pitch.F_SHARP_1)
            .add(3, Pitch.G_1, Pitch.A_SHARP_1)
            .add(1, Pitch.G_1, Pitch.A_SHARP_1)
            .add(2, Pitch.F_0)
            .add(3, Pitch.G_SHARP_1, Pitch.C_1)
            .add(1, Pitch.G_SHARP_1, Pitch.C_1)
            .add(2, Pitch.B_1)
            .add(4, Pitch.G_SHARP_1, Pitch.C_1);

        
        RECORD_OF_POWER
            .newLine("melody", Sound.BLOCK_NOTE_BLOCK_HARP)
            .add(3, Pitch.A_1, Pitch.D_1, Pitch.E_1)
            .add(1, Pitch.A_1, Pitch.D_1, Pitch.E_1)
            .add(1, Pitch.A_1, Pitch.C_SHARP_1, Pitch.E_1)
            .add(1, Pitch.B_1, Pitch.E_1)
            .add(3, Pitch.A_1, Pitch.C_SHARP_1, Pitch.E_1)
            .add(3, Pitch.A_1,  Pitch.E_1)
            .add(3, Pitch.A_1, Pitch.D_1, Pitch.E_1)
            .add(1, Pitch.A_1, Pitch.D_1, Pitch.E_1)
            .add(1, Pitch.A_1, Pitch.E_1)
            .add(1, Pitch.E_1, Pitch.F_SHARP_2)
            .add(6, Pitch.A_1,  Pitch.E_1);
        RECORD_OF_POWER
            .newLine("bass", Sound.BLOCK_NOTE_BLOCK_GUITAR)
            .add(3, Pitch.D_1)
            .add(1, Pitch.D_1)
            .add(1, Pitch.D_1)
            .add(1, Pitch.D_1)
            .add(3, Pitch.C_SHARP_1)
            .add(3, Pitch.A_1)
            .add(3, Pitch.D_1)
            .add(1, Pitch.D_1)
            .add(1, Pitch.D_1)
            .add(1, Pitch.D_1)
            .add(3, Pitch.E_1);

        RECORD_OF_POWER_BOOSTED.newLine("melody", RECORD_OF_POWER.copyOf("melody"));
        RECORD_OF_POWER_BOOSTED.newLine("bass1", RECORD_OF_POWER.copyOf("bass"));
        RECORD_OF_POWER_BOOSTED
            .newLine("bass2", Sound.BLOCK_NOTE_BLOCK_BASS)
            .add(3, Pitch.F_SHARP_1)
            .add(3, Pitch.F_SHARP_1)
            .add(3, Pitch.E_0)
            .add(3, Pitch.C_SHARP_0)
            .add(3, Pitch.F_SHARP_1)
            .add(3, Pitch.F_SHARP_1)
            .add(3, Pitch.A_1);

        RECORD_OF_HASTE
            .newLine("bass1", Sound.BLOCK_NOTE_BLOCK_GUITAR)
            .add(1, Pitch.G_0, Pitch.B_0, Pitch.D_0)
            .add(1, Pitch.G_0, Pitch.B_0, Pitch.D_0)
            .add(4, Pitch.G_0, Pitch.B_0, Pitch.D_0)
            .add(1, Pitch.G_0, Pitch.B_0, Pitch.D_0)
            .add(1, Pitch.G_0, Pitch.B_0, Pitch.D_0)
            .add(4, Pitch.G_0, Pitch.B_0, Pitch.D_0)
            .add(2, Pitch.G_0, Pitch.B_0, Pitch.D_0)
            .add(2, Pitch.G_0, Pitch.B_0, Pitch.D_0)
            .add(1, Pitch.G_0, Pitch.C_0, Pitch.E_0)
            .add(1, Pitch.G_0, Pitch.C_0, Pitch.E_0)
            .add(4, Pitch.G_0, Pitch.C_0, Pitch.E_0)
            .add(1, Pitch.G_0, Pitch.C_0, Pitch.E_0)
            .add(1, Pitch.G_0, Pitch.C_0, Pitch.E_0)
            .add(8, Pitch.G_0, Pitch.B_0, Pitch.D_0);
        RECORD_OF_HASTE
            .newLine("bass2", Sound.BLOCK_NOTE_BLOCK_BASS)
            .add(1, Pitch.D_0)
            .add(1, Pitch.D_0)
            .add(4, Pitch.D_0)
            .add(1, Pitch.D_0)
            .add(1, Pitch.D_0)
            .add(4, Pitch.D_0)
            .add(2, Pitch.D_0)
            .add(2, Pitch.D_0)
            .add(1, Pitch.C_0)
            .add(1, Pitch.C_0)
            .add(4, Pitch.C_0)
            .add(1, Pitch.C_0)
            .add(1, Pitch.C_0)
            .add(8, Pitch.D_0);

        RECORD_OF_HASTE_BOOSTED.newLine("bass1", RECORD_OF_HASTE.copyOf("bass1"));
        RECORD_OF_HASTE_BOOSTED.newLine("bass2", RECORD_OF_HASTE.copyOf("bass2"));
        RECORD_OF_HASTE_BOOSTED
            .newLine("bass3", Sound.BLOCK_NOTE_BLOCK_HARP)
            .add(6, Pitch.D_0)
            .add(6, Pitch.D_0)
            .add(4, Pitch.D_0)
            .add(6, Pitch.E_0)
            .add(2, Pitch.E_0)
            .add(8, Pitch.D_0);
    }
}
