package entities;

public class EntitiesRespawn {
    public static double selectCreatureCountRatio(EntitiesOnWorldMap entitiesOnWorldMap) {
        return switch (entitiesOnWorldMap.toString()) {
            case "Herbivore"-> 0.03;    //0.03
            case "Tree", "Rock" -> 0.03; // 0.03
            case "Predator" -> 0.01;    //0.02
            case "Grass" -> 0.06;    // 0,06
            default -> throw new IllegalArgumentException("Unknown type of entity!");
        };
    }
}