package com.example.entities;

import com.example.worldMap.Coordinates;
import com.example.worldMap.WorldMap;

public class Herbivore extends Creature {
    public final static int HERBIVORE_MAX_HEALTH = 25;
    public final static int HERBIVORE_SPEED = 2;

    public Herbivore(int speed, int health, int actionPoint) {
        super(speed, health, actionPoint);
    }

    @Override
    void attackTheTarget(Coordinates coordinates) {
        WorldMap.removeEntity(coordinates);
        if (health > (HERBIVORE_MAX_HEALTH - Grass.GRASS_HEALTH_RECOVER)) {
            health = HERBIVORE_MAX_HEALTH;
        } else {
            health += Grass.GRASS_HEALTH_RECOVER;
        }
        System.out.printf("%s ate the Grass at: [%d, %d]%n", getClass().getSimpleName(), coordinates.getRow(), coordinates.getColumn());
        System.out.printf("Herbivore health is %d points %n", health);
    }
}