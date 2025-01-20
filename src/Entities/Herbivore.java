package Entities;

import WorldMap.Coordinates;
import WorldMap.WorldMap;
import WorldMap.Pathfinder;

import java.util.List;
import java.util.Random;

import static WorldMap.Pathfinder.getAdjacentCell;

public class Herbivore extends Creature {
    public Herbivore(int speed, int health) {
        super(speed, health);
    }

    @Override
    public void makeMove(WorldMap worldMap, Coordinates coordinates) {

        List<Coordinates> listOfAvailableCoordinates = getAdjacentCell(worldMap, coordinates);

        if (!listOfAvailableCoordinates.isEmpty()) {
            Random random = new Random();
            Coordinates newCoordinates = listOfAvailableCoordinates.get(random.nextInt(listOfAvailableCoordinates.size()));
            worldMap.removeEntity(coordinates, this);
            worldMap.setEntity(newCoordinates, this);
            System.out.println("The herbivore has moved");
        } else {
            worldMap.setEntity(coordinates, this);
            System.out.println("The herbivore can't move");
        }

    }
}