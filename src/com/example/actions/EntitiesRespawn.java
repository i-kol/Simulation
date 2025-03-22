package com.example.actions;

import com.example.entities.EntitiesOnWorldMap;
import com.example.entities.Entity;
import com.example.worldMap.Coordinates;

import java.util.Random;

import static com.example.actions.InitActions.chooseNumberOfCreaturesByMapSize;
import static com.example.actions.InitActions.getClassFromName;
import static com.example.worldMap.WorldMap.*;
import static com.example.worldMap.WorldMap.setEntity;

public class EntitiesRespawn {

    public static double selectCreatureCountRatio(EntitiesOnWorldMap entitiesOnWorldMap) {
        return switch (entitiesOnWorldMap.toString()) {
            case "Herbivore" -> 0.03;    // 0.03 by default
            case "Tree", "Rock" -> 0.04; // 0.04 by default
            case "Predator" -> 0.02;    // 0.02 by default
            case "Grass" -> 0.06;    // 0,06 by default
            default -> throw new IllegalArgumentException("Unknown type of entity!");
        };
    }

    public static <T> void addEndedEntities(Class<T> type) {
        if (getEntitiesOfType(type).isEmpty()) {
            Random random = new Random();
            EntitiesOnWorldMap entityName = EntitiesOnWorldMap.valueOf(type.getSimpleName());
            Entity entity = getClassFromName(entityName);
            int numberOfCreaturesByMapSize = chooseNumberOfCreaturesByMapSize(entityName);

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