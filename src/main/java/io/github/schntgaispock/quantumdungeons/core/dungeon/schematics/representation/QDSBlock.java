package io.github.schntgaispock.quantumdungeons.core.dungeon.schematics.representation;

import java.util.Arrays;
import java.util.List;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class QDSBlock {

    private List<Integer> position;
    private int state;

    public QDSBlock(int x, int y, int z, int state) {
        this.position = Arrays.asList(x, y, z);
        this.state = state;
    }
    
}
