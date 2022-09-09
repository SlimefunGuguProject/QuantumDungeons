package io.github.schntgaispock.quantumdungeons.core.dungeon.schematics;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.Location;
import org.bukkit.block.Biome;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import io.github.schntgaispock.quantumdungeons.core.dungeon.schematics.representation.QDSFace;
import io.github.schntgaispock.quantumdungeons.core.dungeon.schematics.representation.QDSchematic;
import lombok.Getter;

public class QDSchematicManager {

    private static QDSchematicManager instance;
    
    private static final @Getter ObjectMapper JSONObjectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

    private static final String SAVED_SCHEMATIC_PATH = "data-storage/QuantumDungeons/schematics/";
    private static final String DEFAULT_SCHEMATIC_PATH = "plugins/QuantumDungeons/schematics/";

    private final @Getter Map<String, QDSchematic> loadedSchematics = new HashMap<>();

    public static QDSchematicManager getInstance() {
        if (instance == null) {
            instance = new QDSchematicManager();
        }

        return instance;
    }

    public void generateSchematic(
            String name,
            Location corner, int xLen, int yLen, int zLen,
            QDSFace northFace, QDSFace eastFace, QDSFace southFace, QDSFace westFace
    ) {
        getLoadedSchematics().put(name, new QDSchematic(1, corner, xLen, yLen, zLen, Biome.LUSH_CAVES, northFace, eastFace, southFace, westFace));
    }

    public QDSchematic readFromFile(String fullPath) {
        try {
            QDSchematic test = getJSONObjectMapper().readValue(new File(fullPath), QDSchematic.class);
            System.out.println(test);
            return test;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public QDSchematic readFromDefault(String filename) {
        return readFromFile(DEFAULT_SCHEMATIC_PATH, filename);
    }

    public QDSchematic readFromSaved(String filename) {
        return readFromFile(SAVED_SCHEMATIC_PATH, filename);
    }

    public QDSchematic readFromFile(String path, String filename) {
        return readFromFile(path + filename);
    }
    

    private void saveToFile(String fullPath, String schematicKey) {
        try {
            File file = new File(fullPath);
            file.getParentFile().mkdirs();
            file.createNewFile();
            getJSONObjectMapper().writeValue(file, loadedSchematics.get(schematicKey));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveToDefault(String filename, String schematicKey) {
        saveToFile(DEFAULT_SCHEMATIC_PATH, filename, schematicKey);
    }

    public void saveToSaved(String filename, String schematicKey) {
        saveToFile(SAVED_SCHEMATIC_PATH, filename, schematicKey);
    }

    private void saveToFile(String path, String filename, String schematicKey) {
        saveToFile(path + filename, schematicKey);
    }

}
