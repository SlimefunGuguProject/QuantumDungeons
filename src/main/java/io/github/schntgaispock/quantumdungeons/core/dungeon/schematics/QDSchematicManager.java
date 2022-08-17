package io.github.schntgaispock.quantumdungeons.core.dungeon.schematics;

import java.io.File;

import io.github.schntgaispock.quantumdungeons.core.dungeon.schematics.representation.QDSFace;
import io.github.schntgaispock.quantumdungeons.core.dungeon.schematics.representation.QDSchematic;
import io.github.schntgaispock.quantumdungeons.core.slimefun.QDBlockStorage;

public class QDSchematicManager {

    private static QDSchematicManager instance;

    private static final String SAVED_SCHEMATIC_PATH = "data-storage/QuantumDungeons/schematics/";
    private static final String DEFAULT_SCHEMATIC_PATH = "plugins/QuantumDungeons/schematics/";

    private QDSchematicManager() {}

    public static QDSchematicManager getInstance() {
        if (instance == null) {
            return new QDSchematicManager();
        }

        return instance;
    }
    
    public QDSchematic generateSchematic(QDSFace... faces) {
        return new QDSchematic(1, faces);
    }

    public QDSchematic readFromFile(String fullName) {
        return readFromFile("", fullName);
    }

    public QDSchematic readFromDefault(String fullName) {
        return readFromFile(DEFAULT_SCHEMATIC_PATH, fullName);
    }

    public QDSchematic readFromSaved(String fullName) {
        return readFromFile(SAVED_SCHEMATIC_PATH, fullName);
    }

    private QDSchematic readFromFile(String path, String filename) {
        try {
            return QDBlockStorage.getJSONObjectMapper().readValue(new File(path + filename), QDSchematic.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
