package worldMap;

import entities.*;
import static worldMap.WorldMap.*;

public class WorldRenderer {

    public static final String GROUND = ".. ";
    public static final String HERBIVORE = "\uD83D\uDC07 ";
    public static final String PREDATOR = "\uD83D\uDC3A ";
    public static final String GRASS = "☘️ ";
    public static final String ROCK = "⛰️ ";
    public static final String TREE = "🌲 ";
    public static final String DEFAULT_SPRITE = "❓ ";

    public void render(WorldMap worldMap) {
        for (int i = 0; i < MAP_WIDTH; i++) {
            StringBuilder line = new StringBuilder();
            for (int j = 0; j < MAP_HEIGHT; j++) {
                Coordinates coordinates = new Coordinates(i, j);
                if (worldMap.isCellEmpty(coordinates)){
                    line.append(GROUND);
                } else {
                    line.append(selectUnicodeSpriteForEntity(worldMap.getEntity(coordinates)));
                }
            }
            System.out.println(line);
        }
    }

    public String selectUnicodeSpriteForEntity(Entity entity) {
        return switch (entity.getClass().getSimpleName()) {
            case "Herbivore" -> HERBIVORE;
            case "Predator" -> PREDATOR;
            case "Grass" -> GRASS;
            case "Rock" -> ROCK;
            case "Tree" -> TREE;
            default -> DEFAULT_SPRITE;
        };
    }
}
