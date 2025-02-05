package actions;

import entities.EntitiesOnWorldMap;

public class EntitiesRespawn {
    public static double selectCreatureCountRatio(EntitiesOnWorldMap entitiesOnWorldMap) {
        return switch (entitiesOnWorldMap.toString()) {
            case "Herbivore", "Tree", "Rock" -> 0.03;
            case "Predator" -> 0.02;
            case "Grass" -> 0.06;
            default -> throw new IllegalArgumentException("Something broke!");
        };
    }
}
