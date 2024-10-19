package WorldMap;

import Entities.*;
import static WorldMap.WorldMap.*;

public class WorldRenderer {

    public static final String GROUND = ".. ";
    public static final String HERBIVORE = "\uD83D\uDC07 ";
    public static final String PREDATOR = "\uD83D\uDC3A ";
    public static final String GRASS = "☘️ ";
    public static final String ROCK = "⛰️ ";
    public static final String TREE = "🌲 ";

    public void render(WorldMap worldMap) {
        for (int i = 0; i < MAP_WIDTH; i++) {
            StringBuilder line = new StringBuilder();
            for (int j = 0; j < MAP_HEIGHT; j++) {
                Coordinates coordinates = new Coordinates(i, j);
                if (worldMap.isSquareEmpty(coordinates)){
                    line.append(GROUND);
                } else {
                    line.append(selectUnicodeSpriteEntity(worldMap.getEntity(coordinates)));
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
