package io.github.schntgaispock.quantumdungeons.core.dungeon.schematics.representation;

import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class QDSFace {

    public static enum QDSFaceDirection {
        NORTH, EAST, SOUTH, WEST;

        public QDSFaceDirection getOpposite() {
            return QDSFaceDirection.values()[(this.ordinal() + 2) & 3];
        }
    }

    @Getter
    public static enum QDSFaceConnection {
        WALL("WALL"),
        ROOM_BASIC("HALL_BASIC"),
        HALL_BASIC(
            new String[] { "ROOM_BASIC", "HALL_BASIC" },
            new Double[] {  0.8,          0.2 }
        ),
        MULTIROOM_T1("MULTIROOM_T1");

        private List<String> possibleConnections;
        private Double[] weights;

        private QDSFaceConnection(String possibleConnection) {
            this(new String[] { possibleConnection }, new Double[] { 1.0 });
        }

        private QDSFaceConnection(String... possibleConnection) {
            this(
                possibleConnection,
                Arrays.stream(possibleConnection).map(
                    (String c) -> {
                        return 1.0/possibleConnection.length;
                    }
                ).toArray(Double[]::new)
            );
        }

        private QDSFaceConnection(String[] possibleConnections, Double[] weights) {
            this.possibleConnections = Arrays.asList(possibleConnections);
            this.weights = weights;
        }
    }

    private final QDSFaceDirection direction;
    private final QDSFaceConnection connection;
    private final int offset;

    @JsonCreator
    public QDSFace(
            @JsonProperty("direction") QDSFaceDirection direction,
            @JsonProperty("connection") QDSFaceConnection connection,
            @JsonProperty("offset") int offset) {
        this.direction = direction;
        this.connection = connection;
        this.offset = offset;
    }

    public int canConnect(QDSFace other) {
        if (other.getDirection().getOpposite() != getDirection()) return -1;
        if (!other.getConnection().getPossibleConnections().contains(getConnection().name())) return -1;

        return other.offset - this.offset;
    }
    
}
