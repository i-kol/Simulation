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
//        Coordinates newCoordinates = new Coordinates(coordinates.getRowCount() - 1, coordinates.getColumnCount() - 1);

        Random random = new Random();
        List<Coordinates> listOfAvailableCoordinates = getAdjacentCell(coordinates, worldMap);

        if (!listOfAvailableCoordinates.isEmpty()) {
            Coordinates newCoordinates = listOfAvailableCoordinates.get(random.nextInt(listOfAvailableCoordinates.size()));
            worldMap.removeEntity(coordinates, this);
            worldMap.setEntity(newCoordinates, this);
            System.out.println("The herbivore has moved");
        } else {
            worldMap.setEntity(coordinates, this);
            System.out.println("The herbivore can't move");
        }
    }

//    @Override
//    public void makeMove(WorldMap worldMap, Coordinates coordinates) {
//        Coordinates newCoordinates = Pathfinder.findPath(worldMap, coordinates);
//        worldMap.removeEntity(coordinates, this);
//        worldMap.setEntity(newCoordinates, this);
//        System.out.println("The herbivore has moved");
//    }
}