package com.example.actions;

import com.example.entities.*;
import com.example.worldMap.Coordinates;
import com.example.worldMap.WorldMap;

import java.util.Random;

public class InitActions {

    public static int chooseNumberOfCreaturesByMapSize(EntitiesOnWorldMap entitiesOnWorldMap) {
        return (int) Math.ceil(EntitiesRespawn.selectCreatureCountRatio(entitiesOnWorldMap) * WorldMap.width * WorldMap.height);
    }

    public static void fillWorldMapWithEntities() {
        Random random = new Random();
        for (EntitiesOnWorldMap entitiesOnWorldMap : EntitiesOnWorldMap.values()) {
            for (int i = 0; i < chooseNumberOfCreaturesByMapSize(entitiesOnWorldMap); i++) {
                Coordinates coordinates = new Coordinates(random.nextInt(WorldMap.width), random.nextInt(WorldMap.height));
                while (!WorldMap.isCellEmpty(coordinates)) {
                    coordinates = new Coordinates(random.nextInt(WorldMap.width), random.nextInt(WorldMap.height));
                }
                WorldMap.setEntity(coordinates, getClassFromName(entitiesOnWorldMap));
            }
        }
    }

    public static Entity getClassFromName(EntitiesOnWorldMap entitiesOnWorldMap) {
        return switch (entitiesOnWorldMap.toString()) {
            case "HERBIVORE" -> new Herbivore(Herbivore.HERBIVORE_SPEED, Herbivore.HERBIVORE_MAX_HEALTH, 0);
            case "PREDATOR" -> new Predator(Predator.PREDATOR_SPEED, Predator.PREDATOR_MAX_HEALTH, Predator.PREDATOR_ATTACK_STRENGTH, 0);
            case "GRASS" -> new Grass(Grass.GRASS_HEALTH_RECOVER);
            case "ROCK" -> new Rock();
            case "TREE" -> new Tree();
            default -> throw new IllegalArgumentException("Unknown class name of entity!");
        };
    }
}