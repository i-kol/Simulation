package WorldMap;

import Entities.*;
import static WorldMap.WorldMap.*;
import static WorldMap.Coordinates.*;

public class WorldRenderer {
    //public static final String COLOR_RESET = "\u001B[0m";
    //public static final String GROUND = "\uD83D\uDFEB ";
    //public static final String GROUND = "\u001B[42m";

    public static final String GROUND = ".. ";
    public static final String HERBIVORE = "\uD83D\uDC07 ";
    public static final String PREDATOR = "\uD83D\uDC3A ";
    public static final String GRASS = "☘️ ";
    public static final String ROCK = "⛰️ ";
    public static final String TREE = "🌲 ";

    public void render(WorldMap worldMap) {
        for (int i = 0; i < MAP_WIDTH; i++) {
            String line = "";
            for (int j = 0; j < MAP_HEIGHT; j++) {
                Coordinates coordinates = new Coordinates(i, j);
                if (worldMap.isSquareEmpty(coordinates)){
                    line += GROUND;
                } else {
                    line += selectUnicodeSpriteEntity(worldMap.getEntity(coordinates));
                }
            }
            System.out.println(line);
        }
    }

    public String selectUnicodeSpriteEntity(Entity entity) {
        switch (entity.getClass().getSimpleName()) {
            case "Herbivore":
                return HERBIVORE;
            case "Predator":
                return PREDATOR;
            case "Grass":
                return GRASS;
            case "Rock":
                return ROCK;
            case "Tree":
                return TREE;
            default:
                throw new IllegalArgumentException("Something broke!");
        }
    }
}
