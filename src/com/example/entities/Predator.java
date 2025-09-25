package com.example.entities;

import com.example.worldMap.Coordinates;
import com.example.worldMap.WorldMap;

public class Predator extends Creature {
    public final static int PREDATOR_MAX_HEALTH = 40;
    public final static int PREDATOR_SPEED = 3; //2
    public final static int PREDATOR_ATTACK_STRENGTH = 10;
    int attackStrength;

    public Predator(int speed, int health, int attackStrength, int actionPoint) {
        super(speed, health, actionPoint);
        this.attackStrength = attackStrength;
    }

    @Override
    void attackTheTarget(Coordinates coordinates) {
        Herbivore target = (Herbivore) WorldMap.getEntity(coordinates);

        if (health > (PREDATOR_MAX_HEALTH - PREDATOR_ATTACK_STRENGTH)) {
            health = PREDATOR_MAX_HEALTH;
        } else {
            health += PREDATOR_ATTACK_STRENGTH;
        }

        target.health = target.health - PREDATOR_ATTACK_STRENGTH;

        if (target.health > 0) {
            System.out.printf("%s attacked the Herbivore at: [%d, %d]%n", getClass().getSimpleName(), coordinates.getRow(), coordinates.getColumn());
            System.out.printf("Herbivore health is %d points %n", target.health);
        } else {
            System.out.printf("%s ate the Herbivore at: [%d, %d]%n", getClass().getSimpleName(), coordinates.getRow(), coordinates.getColumn());
            WorldMap.removeEntity(coordinates);
        }
    }
}