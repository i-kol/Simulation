package entities;

import worldMap.Coordinates;
import worldMap.WorldMap;

public class Herbivore extends Creature {
    public Herbivore(int speed, int health) {
        super(speed, health);
    }

    @Override
    public void makeMove(WorldMap worldMap, Coordinates coordinates) {
        super.makeMove(worldMap, coordinates);

//        if () {
//
//        }
    }
}