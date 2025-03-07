package actions;

import entities.*;
import worldMap.Coordinates;

import java.util.Random;

import static entities.EntitiesRespawn.selectCreatureCountRatio;
import static entities.Herbivore.*;
import static entities.Predator.*;
import static entities.Grass.GRASS_HEALTH_RECOVER;
import static worldMap.WorldMap.*;

public class InitActions {

    public static int chooseNumberOfCreaturesByMapSize(EntitiesOnWorldMap entitiesOnWorldMap) {
        return (int) Math.ceil(selectCreatureCountRatio(entitiesOnWorldMap) * mapWidth * mapHeight);
    }

    public static void fillWorldMapWithEntities() {
        Random random = new Random();
        for (EntitiesOnWorldMap entitiesOnWorldMap : EntitiesOnWorldMap.values()) {
            for (int i = 0; i < chooseNumberOfCreaturesByMapSize(entitiesOnWorldMap); i++) {
                Coordinates coordinates = new Coordinates(random.nextInt(mapWidth), random.nextInt(mapHeight));
                while (!isCellEmpty(coordinates)) {
                    coordinates = new Coordinates(random.nextInt(mapWidth), random.nextInt(mapHeight));
                }
                setEntity(coordinates, getClassFromName(entitiesOnWorldMap));
            }
        }
    }

    public static Entity getClassFromName(EntitiesOnWorldMap entitiesOnWorldMap) {
        return switch (entitiesOnWorldMap.toString()) {
            case "Herbivore" -> new Herbivore(HERBIVORE_SPEED, HERBIVORE_MAX_HEALTH, 0);
            case "Predator" -> new Predator(PREDATOR_SPEED, PREDATOR_MAX_HEALTH, PREDATOR_ATTACK_STRENGTH, 0);
            case "Grass" -> new Grass(GRASS_HEALTH_RECOVER);
            case "Rock" -> new Rock();
            case "Tree" -> new Tree();
            default -> throw new IllegalArgumentException("Unknown class name of entity!");
        };
    }
}
