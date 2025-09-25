package com.example.worldMap;

import com.example.Menu;
import com.example.entities.*;

public class WorldRenderer {

    public static final String GROUND = ".. ";
    public static final String HERBIVORE = "\uD83D\uDC07 ";
    public static final String PREDATOR = "\uD83D\uDC3A ";
    public static final String GRASS = "☘️ ";
    public static final String ROCK = "⛰️ ";
    public static final String TREE = "🌲 ";
    public static final String DEFAULT_SPRITE = "❓ ";

    public void render() {
        System.out.println();
        for (int i = 0; i < WorldMap.width; i++) {
            StringBuilder line = new StringBuilder();
            for (int j = 0; j < WorldMap.height; j++) {
                Coordinates coordinates = new Coordinates(i, j);
                if (WorldMap.isCellEmpty(coordinates)) {
                    line.append(GROUND);
                } else {
                    line.append(selectUnicodeSpriteForEntity(WorldMap.getEntity(coordinates)));
                }
            }
            System.out.println(line);
        }
        Menu.showControlMenu();
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