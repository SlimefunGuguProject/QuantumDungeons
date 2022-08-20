package io.github.schntgaispock.quantumdungeons.core.music;

import java.util.HashSet;
import java.util.Set;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import io.github.schntgaispock.quantumdungeons.core.music.Note.Pitch;
import lombok.Getter;

public class Chord extends ScoreComponent {

    private @Getter Set<Note> notes = new HashSet<>();

    public Chord(float volume, Vector displacement, Pitch[] pitches) {
        for (Pitch pitch : pitches) {
            notes.add(new Note(volume, displacement, pitch));
        }
    }

    @Override
    public void playSound(Player player, Sound instrument) {
        for (Note note : notes) {
            note.playSound(player, instrument);
        }
    }
    
}
