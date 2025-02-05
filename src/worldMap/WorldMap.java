package worldMap;

import entities.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static actions.EntitiesRespawn.selectCreatureCountRatio;

public class WorldMap {

    public static final int MAP_WIDTH = 10;
    public static final int MAP_HEIGHT = 10;

    HashMap<Coordinates, Entity> worldMap = new HashMap<>();

    public void setEntity(Coordinates coordinates, Entity entity) {
        worldMap.put(coordinates, entity);
    }

    public Entity getEntity(Coordinates coordinates) {
        return worldMap.get(coordinates);
    }

    public void removeEntity(Coordinates coordinates, Entity entity) {
        worldMap.remove(coordinates, entity);
    }

    public boolean isCellEmpty(Coordinates coordinates) {
        return !worldMap.containsKey(coordinates);
    }

    public int chooseNumberOfCreaturesByMapSize(EntitiesOnWorldMap entitiesOnWorldMap) {
        return (int) Math.ceil(selectCreatureCountRatio(entitiesOnWorldMap) * MAP_WIDTH * MAP_HEIGHT);
    }

    public boolean isCellAvailableForMove(Coordinates coordinates) {
        return coordinates.getRowCount() < MAP_WIDTH && coordinates.getRowCount() >= 0 &&
                coordinates.getColumnCount() < MAP_HEIGHT && coordinates.getColumnCount() >= 0 && isCellEmpty(coordinates);
    }

    public void moveCreature(WorldMap worldMap) {
        HashMap<Coordinates, Entity> updatedWorldMap = new HashMap<>(worldMap.worldMap);
        for (Map.Entry<Coordinates, Entity> entry : updatedWorldMap.entrySet()) {
            Entity entity = entry.getValue();
            if (entity instanceof Herbivore) {
                //мы перебрали всю копию карты, ищем там все сущности entity, и если очередная сущность Herbivore,
                //то получаем ее координаты и делаем ход makeMove
                Coordinates coordinates = entry.getKey();
                ((Herbivore) entity).makeMove(worldMap, coordinates);
            }
        }
    }

    public void fillWorldMapWithEntities() {
        Random random = new Random();
        for (EntitiesOnWorldMap entitiesOnWorldMap : EntitiesOnWorldMap.values()) {
            for (int i = 0; i < chooseNumberOfCreaturesByMapSize(entitiesOnWorldMap); i++) {
                Coordinates coordinates = new Coordinates(random.nextInt(MAP_WIDTH), random.nextInt(MAP_HEIGHT));
                while (!isCellEmpty(coordinates)) {
                    coordinates = new Coordinates(random.nextInt(MAP_WIDTH), random.nextInt(MAP_HEIGHT));
                }
                setEntity(coordinates, getClassFromName(entitiesOnWorldMap));
            }
        }
    }

    public Entity getClassFromName(EntitiesOnWorldMap entitiesOnWorldMap) {
        return switch (entitiesOnWorldMap.toString()) {
            case "Herbivore" -> new Herbivore(1, 20);
            case "Predator" -> new Predator(2, 40, 10);
            case "Grass" -> new Grass(5);
            case "Rock" -> new Rock();
            case "Tree" -> new Tree();
            default -> throw new IllegalArgumentException("Unknown class name of entity!");
        };
    }
}