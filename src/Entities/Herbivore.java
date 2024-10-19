package Entities;

import WorldMap.Coordinates;
import WorldMap.WorldMap;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static WorldMap.Coordinates.columnCount;
import static WorldMap.Coordinates.rowCount;

public class Herbivore extends Creature {
    public Herbivore(int speed, int health) {
        super(speed, health);
    }

    @Override
    public void makeMove(WorldMap worldMap, Coordinates coordinates) {
        worldMap.setEntity(new Coordinates(rowCount + 1, columnCount), this);
        System.out.println("Herbivores have moved");
    }
}