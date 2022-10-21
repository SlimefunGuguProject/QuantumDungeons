package io.github.schntgaispock.strophodungeons.core.dungeon.schematics.data;

import javax.annotation.Nonnull;

import org.bukkit.Location;
import org.bukkit.block.data.BlockData;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.ToString;
import me.mrCookieSlime.Slimefun.api.BlockStorage;

@Getter
@ToString
public class SDSBlockState {

    private final String data;
    private final String slimefunId;

    @JsonCreator
    public SDSBlockState(
            @JsonProperty("data") String data,
            @JsonProperty("slimefunId") String slimefunId
    ) {
        this.data = data;
        this.slimefunId = slimefunId; 
    }

    public SDSBlockState(BlockData data, @Nonnull Location l) {
        this.data = data.getAsString(true);
        slimefunId = BlockStorage.checkID(l);
    }

    @Override
    public boolean equals(Object obj) {
        return
            (obj instanceof SDSBlockState state) &&
            data.equals(state.getData()) &&
            ((slimefunId == null && state.getSlimefunId() == null) ||
            (slimefunId.equals(state.getSlimefunId())));
    }
    
}
