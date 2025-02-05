package entities;

import worldMap.Coordinates;
import worldMap.WorldMap;

import java.util.List;
import java.util.Random;

import static worldMap.Pathfinder.getAdjacentCell;

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