package WorldMap;

import Entities.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class WorldMap {
    Random random = new Random();
    public static final int MAP_WIDTH = 10;
    public static final int MAP_HEIGHT = 10;

/*    public static final int RATIO_NUMBER_HERBIVORE = 2;
    public static final int RATIO_NUMBER_PREDATOR = 1;
    public static final int RATIO_NUMBER_GRASS = 3;
    public static final int RATIO_NUMBER_TREE = 2;
    public static final int RATIO_NUMBER_ROCK = 2;*/

    HashMap<Coordinates, Entity> worldMap = new HashMap<>();

    public void setEntity(Coordinates coordinates, Entity entity) {
        worldMap.put(coordinates, entity);
    }

    public Entity getEntity(Coordinates coordinates) {
        return worldMap.get(coordinates);
    }

    public boolean isSquareEmpty(Coordinates coordinates) {
        return !worldMap.containsKey(coordinates);
    }

    public void moveCreature(WorldMap worldMap) {
        
        for (Map.Entry<Coordinates, Entity> entry : worldMap.worldMap.entrySet()){
            Entity entity = entry.getValue();
            if (entity instanceof Herbivore){
                Coordinates coordinates = entry.getKey();
                ((Herbivore) entity).makeMove(worldMap, coordinates);
            }
        }
    }

    public void fillWorldMapWithEntities(int numberCreaturesOfSameSpecies) {
        for (EntitiesOnWorldMap entitiesOnWorldMap : EntitiesOnWorldMap.values()) {
            for (int i = 0; i < numberCreaturesOfSameSpecies; i++) {
                Coordinates coordinates = new Coordinates(random.nextInt(MAP_WIDTH), random.nextInt(MAP_HEIGHT));
                while (!isSquareEmpty(coordinates)) {
                    coordinates = new Coordinates(random.nextInt(MAP_WIDTH), random.nextInt(MAP_HEIGHT));
                }
                setEntity(coordinates, getClassFromName(entitiesOnWorldMap));
            }
        }
    }

    public Entity getClassFromName(EntitiesOnWorldMap entitiesOnWorldMap) {
        switch (entitiesOnWorldMap.toString()) {
            case "Herbivore":
                return new Herbivore(1, 20);
            case "Predator":
                return new Predator(2, 40, 10);
            case "Grass":
                return new Grass(5);
            case "Rock":
                return new Rock();
            case "Tree":
                return new Tree();
            default:
                throw new IllegalArgumentException("Something broke!");
        }
    }

    public int chooseNumberOfCreaturesByMapSize() {
        int result = MAP_WIDTH * MAP_HEIGHT;
        int numberCreaturesOfSameSpecies;
        if (result >= 900) {
            return numberCreaturesOfSameSpecies = 5;
        } else if (result >= 400 && result < 900) {
            return numberCreaturesOfSameSpecies = 4;
        } else if (result >= 100 && result < 400) {
            return numberCreaturesOfSameSpecies = 3;
        } else if (result >= 50 && result < 100) {
            return numberCreaturesOfSameSpecies = 2;
        } else {
            return numberCreaturesOfSameSpecies = 1;
        }
    }
}