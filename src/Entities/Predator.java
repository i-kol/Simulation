package Entities;

import WorldMap.Coordinates;
import WorldMap.WorldMap;

import java.util.Set;

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