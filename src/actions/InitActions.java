package actions;

import entities.*;
import worldMap.Coordinates;

import java.util.Random;

import static entities.EntitiesRespawn.selectCreatureCountRatio;
import static worldMap.WorldMap.*;

public class InitActions {

    public static int chooseNumberOfCreaturesByMapSize(EntitiesOnWorldMap entitiesOnWorldMap) {
        return (int) Math.ceil(selectCreatureCountRatio(entitiesOnWorldMap) * MAP_WIDTH * MAP_HEIGHT);
    }

    public static void fillWorldMapWithEntities() {
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

    public static Entity getClassFromName(EntitiesOnWorldMap entitiesOnWorldMap) {
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
