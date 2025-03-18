package com.example.worldMap;

import com.example.entities.*;

import static com.example.Menu.showControlMenu;
import static com.example.worldMap.WorldMap.*;

public class WorldRenderer {

    public static final String GROUND = ".. ";
    public static final String HERBIVORE = "\uD83D\uDC07 ";
    public static final String PREDATOR = "\uD83D\uDC3A ";
    public static final String GRASS = "☘️ ";
    public static final String ROCK = "⛰️ ";
    public static final String TREE = "🌲 ";
    public static final String DEFAULT_SPRITE = "❓ ";

    public void render() {
        for (int i = 0; i < mapWidth; i++) {
            StringBuilder line = new StringBuilder();
            for (int j = 0; j < mapHeight; j++) {
                Coordinates coordinates = new Coordinates(i, j);
                if (isCellEmpty(coordinates)){
                    line.append(GROUND);
                } else {
                    line.append(selectUnicodeSpriteForEntity(getEntity(coordinates)));
                }
            }
            System.out.println(line);
        }
        showControlMenu();
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
