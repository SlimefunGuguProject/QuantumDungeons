package io.github.schntgaispock.quantumdungeons.core.dungeon.schematics.representation;

import javax.annotation.Nullable;

import org.bukkit.Location;
import org.bukkit.block.data.BlockData;

import lombok.Getter;
import lombok.ToString;
import me.mrCookieSlime.Slimefun.api.BlockStorage;

@Getter
@ToString
public class QDSBlockState {

    private final String data;
    private final @Nullable String slimefunId;

    public QDSBlockState(BlockData data, Location l) {
        this.data = data.getAsString(true);
        slimefunId = BlockStorage.checkID(l);
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof QDSBlockState state) && data.equals(state.getData());
    }
    
}
