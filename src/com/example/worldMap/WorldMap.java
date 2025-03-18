package com.example.worldMap;

import com.example.entities.*;

import java.util.HashMap;
import java.util.Map;

public class WorldMap {

    public static int mapWidth;
    public static int mapHeight;

    public static HashMap<Coordinates, Entity> worldMap = new HashMap<>();

    public static void setEntity(Coordinates coordinates, Entity entity) {
        worldMap.put(coordinates, entity);
    }

    public static Entity getEntity(Coordinates coordinates) {
        return worldMap.get(coordinates);
    }

    public static void removeEntity(Coordinates coordinates) {
        worldMap.remove(coordinates);
    }

    public static boolean isCellEmpty(Coordinates coordinates) {
        return !worldMap.containsKey(coordinates);
    }

    public static boolean isCellOnWorldMap(Coordinates coordinates) {
        return coordinates.getRowCount() < mapWidth && coordinates.getRowCount() >= 0 &&
                coordinates.getColumnCount() < mapHeight && coordinates.getColumnCount() >= 0;
    }

    public static <T> HashMap<Coordinates, T> getEntitiesOfType(Class<T> type) {
        HashMap<Coordinates, T> map = new HashMap<>();
        for (Map.Entry<Coordinates, Entity> entity : worldMap.entrySet()) {
            if (type.isInstance(entity.getValue())) {
                Map.Entry<Coordinates, T> mapEntry = (Map.Entry<Coordinates, T>) entity;
                map.put(mapEntry.getKey(), mapEntry.getValue());
            }
        }
        return map;
    }
}