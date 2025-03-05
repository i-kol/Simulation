package worldMap;

import entities.*;

import java.util.HashMap;

public class WorldMap {

    public static final int MAP_WIDTH = 15;
    public static final int MAP_HEIGHT = 15;

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
        return coordinates.getRowCount() < MAP_WIDTH && coordinates.getRowCount() >= 0 &&
                coordinates.getColumnCount() < MAP_HEIGHT && coordinates.getColumnCount() >= 0;
    }
}