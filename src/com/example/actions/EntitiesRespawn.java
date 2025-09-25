package com.example.actions;

import com.example.entities.EntitiesOnWorldMap;
import com.example.entities.Entity;
import com.example.worldMap.Coordinates;
import com.example.worldMap.WorldMap;

import java.util.Random;

public class EntitiesRespawn {

    public static double selectCreatureCountRatio(EntitiesOnWorldMap entitiesOnWorldMap) {
        return switch (entitiesOnWorldMap.toString()) {
            case "HERBIVORE" -> 0.03;    // 0.03 by default
            case "TREE", "ROCK" -> 0.04; // 0.04 by default
            case "PREDATOR" -> 0.02;    // 0.02 by default
            case "GRASS" -> 0.06;    // 0,06 by default
            default -> throw new IllegalArgumentException("Unknown type of entity!");
        };
    }

    public static <T> void addEndedEntities(Class<T> type) {
        if (WorldMap.getEntitiesOfType(type).isEmpty()) {
            Random random = new Random();
            EntitiesOnWorldMap entityName = EntitiesOnWorldMap.valueOf(type.getSimpleName().toUpperCase());
            Entity entity = InitActions.getClassFromName(entityName);
            int numberOfCreaturesByMapSize = InitActions.chooseNumberOfCreaturesByMapSize(entityName);

            for (int i = 0; i < numberOfCreaturesByMapSize; i++) {
                Coordinates coordinates = new Coordinates(random.nextInt(WorldMap.width), random.nextInt(WorldMap.height));

                while (!WorldMap.isCellEmpty(coordinates)) {
                    coordinates = new Coordinates(random.nextInt(WorldMap.width), random.nextInt(WorldMap.height));
                }

                WorldMap.setEntity(coordinates, entity);
            }
        }
    }
}