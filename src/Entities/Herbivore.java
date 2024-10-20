package Entities;

import WorldMap.Coordinates;
import WorldMap.WorldMap;

public class Herbivore extends Creature {
    public Herbivore(int speed, int health) {
        super(speed, health);
    }

    @Override
    public void makeMove(WorldMap worldMap, Coordinates coordinates) {
        worldMap.removeEntity(coordinates, this);
        coordinates = new Coordinates(coordinates.getRowCount() - 1, coordinates.getColumnCount());
        worldMap.setEntity(coordinates, this);
        System.out.println("Herbivores have moved");
    }
}