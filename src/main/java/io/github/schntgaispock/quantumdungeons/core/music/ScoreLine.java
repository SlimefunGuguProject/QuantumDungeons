package io.github.schntgaispock.quantumdungeons.core.music;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import io.github.schntgaispock.quantumdungeons.core.music.Note.Pitch;
import lombok.Getter;

@Getter
public class ScoreLine implements Cloneable {

    private final Map<Integer, ScoreComponent> notes;
    private final float defaultVolume;
    private final Vector defaultDisplacement;
    private final Sound instrument;

    private final Rest REST = new Rest();

    private int latestBeat;

    public ScoreLine(float defaultVolume, Vector defaltDisplacement, Sound instrument) {
        this(new HashMap<Integer, ScoreComponent>(), defaultVolume, defaltDisplacement, instrument);
    }

    private ScoreLine(Map<Integer, ScoreComponent> notes, float defaultVolume, Vector defaltDisplacement, Sound instrument) {
        this.notes = notes;
        this.defaultVolume = defaultVolume;
        this.defaultDisplacement = defaltDisplacement;
        this.instrument = instrument;

        this.latestBeat = 0;
    }

    public ScoreLine add(float volume, Vector displacement, int beats, Pitch note) {
        // TODO: Allow notes to stack when beats is 0
        this.notes.put(latestBeat, new Note(volume, displacement, note));
        latestBeat += beats;
        return this;
    }

    public ScoreLine add(float volume, Vector displacement, int beats, Pitch... notes) {
        this.notes.put(latestBeat, new Chord(volume, displacement, notes));
        latestBeat += beats;
        return this;
    }

    public ScoreLine add(float volume, int beats, Pitch note) {
        return add(volume, defaultDisplacement, beats, note);
    }

    public ScoreLine add(int beats, Pitch note) {
        return add(defaultVolume, beats, note);
    }

    public ScoreLine add(Pitch note) {
        return add(1, note);
    }

    public ScoreLine add(float volume, int beats, Pitch... notes) {
        return add(volume, defaultDisplacement, beats, notes);
    }

    public ScoreLine add(int beats, Pitch... notes) {
        return add(defaultVolume, beats, notes);
    }

    public ScoreLine add(Pitch... notes) {
        return add(1, notes);
    }

    public ScoreLine rest(int beats) {
        latestBeat += beats;
        return this;
    }

    public void play(Player player, int position) {
        notes.getOrDefault(position, REST).playSound(player, instrument);
    }

    public ScoreLine clone() {
        Map<Integer, ScoreComponent> newNotes = new HashMap<>();
        newNotes.putAll(notes);
        return new ScoreLine(newNotes, defaultVolume, defaultDisplacement, instrument);
    }

    public ScoreLine transpose(Sound instrument) {
        Map<Integer, ScoreComponent> newNotes = new HashMap<>();
        newNotes.putAll(notes);
        return new ScoreLine(newNotes, defaultVolume, defaultDisplacement, instrument);
    }
    
}
