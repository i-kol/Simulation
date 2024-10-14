package Entities;

import WorldMap.Coordinates;

public class Predator extends Creature {
    int attackStrength;

    public Predator(int speed, int health, int attackStrength) {
        super(speed, health);
        this.attackStrength = attackStrength;
    }


    @Override
    void makeMove() {

    }
}