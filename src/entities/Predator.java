package entities;

import worldMap.Coordinates;
import worldMap.WorldMap;

public class Predator extends Creature {
    int attackStrength;

    public Predator(int speed, int health, int attackStrength) {
        super(speed, health);
        this.attackStrength = attackStrength;
    }


    @Override
    void makeMove(WorldMap worldMap, Coordinates coordinates) {

    }
}