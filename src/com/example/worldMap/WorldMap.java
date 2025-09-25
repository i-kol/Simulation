package com.example.worldMap;

import com.example.entities.*;

import java.util.HashMap;
import java.util.Map;

public class WorldMap {

    public static int width;
    public static int height;

    public static Map<Coordinates, Entity> entities = new HashMap<>();

    public static void setEntity(Coordinates coordinates, Entity entity) {
        entities.put(coordinates, entity);
    }

    public static Entity getEntity(Coordinates coordinates) {
        return entities.get(coordinates);
    }

    public static void removeEntity(Coordinates coordinates) {
        entities.remove(coordinates);
    }

    public static boolean isCellEmpty(Coordinates coordinates) {
        return !entities.containsKey(coordinates);
    }

    public static boolean isCellOnWorldMap(Coordinates coordinates) {
        return coordinates.getRow() < width && coordinates.getRow() >= 0 &&
                coordinates.getColumn() < height && coordinates.getColumn() >= 0;
    }

    public static <T> HashMap<Coordinates, T> getEntitiesOfType(Class<T> type) {
        HashMap<Coordinates, T> map = new HashMap<>();
        for (Map.Entry<Coordinates, Entity> entity : entities.entrySet()) {
            if (type.isInstance(entity.getValue())) {
                Map.Entry<Coordinates, T> mapEntry = (Map.Entry<Coordinates, T>) entity;
                map.put(mapEntry.getKey(), mapEntry.getValue());
            }
        }
        return map;
    }
}