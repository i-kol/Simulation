package Entities;

import WorldMap.Coordinates;
import WorldMap.WorldMap;

public class Herbivore extends Creature {
    public Herbivore(int speed, int health) {
        super(speed, health);
    }

    @Override
    public void makeMove(WorldMap worldMap, Coordinates coordinates) {
        Coordinates newCoordinates = new Coordinates(coordinates.getRowCount() - 1, coordinates.getColumnCount() - 1);
        if (isSquareAvailableForMove(newCoordinates, worldMap)) {
            worldMap.removeEntity(coordinates, this);
            worldMap.setEntity(newCoordinates, this);
            System.out.println("The herbivore has moved");
        } else {
            worldMap.setEntity(coordinates, this);
            System.out.println("The herbivore can't move");
        }
    }
}