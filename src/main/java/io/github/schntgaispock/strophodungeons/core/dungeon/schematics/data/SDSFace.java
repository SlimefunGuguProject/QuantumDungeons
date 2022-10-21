package io.github.schntgaispock.strophodungeons.core.dungeon.schematics.data;

import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class SDSFace {

    public static enum SDSFaceDirection {
        NORTH, EAST, SOUTH, WEST;

        public SDSFaceDirection getOpposite() {
            return SDSFaceDirection.values()[(this.ordinal() + 2) & 3];
        }
    }

    @Getter
    public static enum SDSFaceConnection {
        WALL("WALL"),
        ROOM_BASIC("HALL_BASIC"),
        HALL_BASIC(
            new String[] { "ROOM_BASIC", "HALL_BASIC" },
            new Double[] {  0.8,          0.2 }
        ),
        MULTIROOM_T1("MULTIROOM_T1");

        private List<String> possibleConnections;
        private Double[] weights;

        private SDSFaceConnection(String possibleConnection) {
            this(new String[] { possibleConnection }, new Double[] { 1.0 });
        }

        private SDSFaceConnection(String... possibleConnection) {
            this(
                possibleConnection,
                Arrays.stream(possibleConnection).map(
                    (String c) -> {
                        return 1.0/possibleConnection.length;
                    }
                ).toArray(Double[]::new)
            );
        }

        private SDSFaceConnection(String[] possibleConnections, Double[] weights) {
            this.possibleConnections = Arrays.asList(possibleConnections);
            this.weights = weights;
        }
    }

    private final SDSFaceDirection direction;
    private final SDSFaceConnection connection;
    private final int offset;

    @JsonCreator
    public SDSFace(
            @JsonProperty("direction") SDSFaceDirection direction,
            @JsonProperty("connection") SDSFaceConnection connection,
            @JsonProperty("offset") int offset
    ) {
        this.direction = direction;
        this.connection = connection;
        this.offset = offset;
    }

    public int canConnect(SDSFace other) {
        if (other.getDirection().getOpposite() != getDirection()) return -1;
        if (!other.getConnection().getPossibleConnections().contains(getConnection().name())) return -1;

        return other.offset - this.offset;
    }
    
}
