package actions;

import entities.EntitiesOnWorldMap;
import entities.Entity;
import worldMap.Coordinates;

import java.util.Random;

import static actions.InitActions.chooseNumberOfCreaturesByMapSize;
import static actions.InitActions.getClassFromName;
import static worldMap.WorldMap.*;
import static worldMap.WorldMap.setEntity;

public class EntitiesRespawn {

    public static double selectCreatureCountRatio(EntitiesOnWorldMap entitiesOnWorldMap) {
        return switch (entitiesOnWorldMap.toString()) {
            case "Herbivore" -> 0.03;    //0.03
            case "Tree", "Rock" -> 0.04; // 0.04
            case "Predator" -> 0.02;    //0.01
            case "Grass" -> 0.06;    // 0,06
            default -> throw new IllegalArgumentException("Unknown type of entity!");
        };
    }

    public static <T> void addEndedEntities(Class<T> type) {
        if (getEntitiesOfType(type).isEmpty()) {
            Random random = new Random();
            Entity entity = getClassFromName(EntitiesOnWorldMap.valueOf(type.getSimpleName()));
            int numberOfCreaturesByMapSize = chooseNumberOfCreaturesByMapSize(EntitiesOnWorldMap.valueOf(type.getSimpleName()));

            for (int i = 0; i < numberOfCreaturesByMapSize; i++) {
                Coordinates coordinates = new Coordinates(random.nextInt(mapWidth), random.nextInt(mapHeight));

                while (!isCellEmpty(coordinates)) {
                    coordinates = new Coordinates(random.nextInt(mapWidth), random.nextInt(mapHeight));
                }

                setEntity(coordinates, entity);
            }
        }
    }
}