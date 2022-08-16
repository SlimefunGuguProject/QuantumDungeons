package io.github.schntgaispock.quantumdungeons.core.music;


import java.util.Map;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import lombok.Getter;

@Getter 
public class Score {
    
    private Map<String, ScoreLine> score;
    private int tickRate;

    public Score(int tickRate) {
        super();
    }

    public ScoreLine newLine(String key, float defaultVolume, Vector defaltDisplacement, Sound instrument) {
        ScoreLine scoreLine = new ScoreLine(defaultVolume, defaltDisplacement, instrument);
        score.put(key, scoreLine);
        return scoreLine;
    }

    public ScoreLine newLine(String key, float defaultVolume, Sound instrument) {
        return newLine(key, defaultVolume, new Vector(0, 0, 0), instrument);
    }

    public ScoreLine newLine(String key, Sound instrument) {
        return newLine(key, 1.0f, instrument);
    }

    public ScoreLine newLine(String key, ScoreLine scoreLine) {
        ScoreLine newLine = scoreLine;
        score.put(key, newLine);
        return scoreLine;
    }

    public ScoreLine copyOf(String key) {
        return score.get(key).clone();
    }

    public ScoreLine transpose(String key, Sound instrument) {
        return score.get(key).transpose(instrument);
    }

    public void play(Player player) {
        
    }

}
